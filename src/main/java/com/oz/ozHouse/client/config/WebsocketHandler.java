package com.oz.ozHouse.client.config;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oz.ozHouse.domain.Chatt;
import com.oz.ozHouse.dto.ChattDTO;
import com.oz.ozHouse.market.service.ChattRoomService;
import com.oz.ozHouse.market.service.ChattService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebsocketHandler extends TextWebSocketHandler {

	private final ObjectMapper objectMapper;

	private final ChattRoomService chattRoomService;

	private final ChattService chattService;

	private final StringRedisTemplate stringRedisTemplate;

	private Map<String, HashSet<WebSocketSession>> roomSessions = new ConcurrentHashMap<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("웹소켓 연결이 설정되었습니다.");
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();
		ChattDTO chatt = objectMapper.readValue(payload, ChattDTO.class);
		String roomNumStr = String.valueOf(chatt.getRoomNum()); // 방 번호를 문자열로 변환

		switch (chatt.getType()) {
		case ENTER:
			enterRoom(session, chatt, roomNumStr);
			break;
		case TALK:
//                talk(session, chatt, roomNumStr);
			saveAndBroadcastMessage(session, chatt, roomNumStr);
			break;
		case QUIT:
			quitRoom(session, chatt, roomNumStr);
			break;
		}
	}

	private void enterRoom(WebSocketSession session, ChattDTO chatt, String roomNumStr) throws IOException {
	    HashSet<WebSocketSession> sessions = roomSessions.computeIfAbsent(roomNumStr, k -> new HashSet<>());
	    sessions.add(session);

	    // 새로운 사용자가 입장하면 읽지 않은 메시지를 읽음으로 표시
	    if (sessions.size() > 1) { // 채팅방에 사용자가 2명 이상인 경우
	        List<Chatt> unreadMessages = chattService.markMessagesAsRead(roomNumStr); // 읽지 않은 메시지들을 읽음으로 표시하는 로직

	        // 변경된 메시지 상태를 모든 클라이언트에게 방송
	        for (Chatt updatedMessage : unreadMessages) {
	            ChattDTO updatedChattDTO = convertToChattDTO(updatedMessage);
	            broadcast(updatedChattDTO, roomNumStr); // 변경된 메시지 상태를 방송
	        }
	    }

	    // 사용자 입장 메시지 방송
	    chatt.setMsg(chatt.getSender() + "님이 입장했습니다.");
	    broadcast(chatt, roomNumStr);
	}

	private void talk(WebSocketSession session, ChattDTO chattDTO, String roomNumStr) throws IOException {
		// 데이터베이스에 채팅 메시지를 저장
//	    Chatt messageEntity = convertToEntity(chattDTO, roomNumStr); // DTO를 엔티티로 변환하면서 roomNumStr도 전달
//	    chattService.saveMessage(messageEntity); // 서비스를 사용하여 메시지 엔티티 저장

		broadcast(chattDTO, roomNumStr);
	}

	private void saveAndBroadcastMessage(WebSocketSession session, ChattDTO chattDTO, String roomNumStr)
	        throws IOException {
	    // Assuming that ChattDTO contains a field for the read status and it's initially set to false
	    chattDTO.setRoomNum(Integer.parseInt(roomNumStr));

	    // Determine the read status based on the number of active sessions in the room
	    boolean readStatus = roomSessions.get(roomNumStr) != null && roomSessions.get(roomNumStr).size() > 1;
	    chattDTO.setReadStatus(readStatus); // Set the read status based on the presence of users in the room

	    Chatt savedChatt = chattService.saveMessage(chattDTO); // Save the message with the updated read status

	    // Broadcast the message to all users in the room
	    broadcast(chattDTO, roomNumStr);
	}

	// Chatt 엔티티를 ChattDTO로 변환하는 메서드 (구현 필요)
	private ChattDTO convertToChattDTO(Chatt chatt) {
	    // Chatt 엔티티를 DTO로 변환하는 로직 구현
	    return new ChattDTO();
	}

	private void quitRoom(WebSocketSession session, ChattDTO chatt, String roomNumStr) throws IOException {
		HashSet<WebSocketSession> sessions = roomSessions.get(roomNumStr);
		if (sessions != null) {
			sessions.remove(session);
			chatt.setMsg(chatt.getSender() + "님이 퇴장했습니다.");
			broadcast(chatt, roomNumStr);
		}
	}

	private void broadcast(ChattDTO chatt, String roomNumStr) throws IOException {
		HashSet<WebSocketSession> sessions = roomSessions.get(roomNumStr);
		if (sessions != null) {
			TextMessage textMessage = new TextMessage(objectMapper.writeValueAsString(chatt));
			for (WebSocketSession session : sessions) {
				session.sendMessage(textMessage);
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("웹소켓 연결이 종료되었습니다: " + session.getId());
		// 모든 채팅방에서 해당 세션 제거
		roomSessions.forEach((roomNum, sessions) -> sessions.remove(session));
	}

	// 모든 연결된 세션에 Heartbeat 메시지를 보냄
	@Scheduled(fixedRate = 10000) // 10초마다 실행
	public void sendHeartbeat() {
		roomSessions.values().forEach(sessions -> {
			sessions.forEach(session -> {
				if (session.isOpen()) {
					try {
						session.sendMessage(new TextMessage("{\"type\":\"HEARTBEAT\",\"message\":\"ping\"}"));
						log.info("Heartbeat 메시지 'ping'을 전송했습니다.");
					} catch (IOException e) {
						log.error("Heartbeat 메시지 전송 중 오류 발생", e);
					}
				}
			});
		});
	}

}

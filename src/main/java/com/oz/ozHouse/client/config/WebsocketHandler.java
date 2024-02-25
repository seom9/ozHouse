package com.oz.ozHouse.client.config;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
		// 데이터베이스에 메시지 저장
//		int readStatus = roomSessions.get(roomNumStr).size() == 1 ? 1 : 0;
//	    chattDTO.setReadStatus(readStatus);
		chattDTO.setRoomNum(Integer.parseInt(roomNumStr));

		Chatt savedChatt = chattService.saveMessage(chattDTO);

		String key = "chat:message:readStatus:" + savedChatt.getMsgNum();
		ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
		valueOps.set(key, "false"); // 메시지 저장 시 읽지 않음 상태로 설정

		// 저장된 엔티티를 다시 DTO로 변환하거나 직접 chattDTO 사용
		// 정확히 받은 DTO를 방송할지 또는 저장 과정에서 변경/추가된 내용을 포함할지 여부에 따라 달라짐
		broadcast(chattDTO, String.valueOf(chattDTO.getRoomNum()));
	}

	private Chatt convertToEntity(ChattDTO chattDTO, String roomNumStr) {
		// ChattDTO에서 Chatt 엔티티로의 변환 로직 구현
//	    ChattRoom chattRoom = chattRoomService.findRoomByNumber(Integer.parseInt(roomNumStr)); // roomNumStr을 이용하여 채팅방 정보 조회
		return new Chatt(chattDTO).toBuilder()
//	                              .chattRoom(chattRoom) // 조회한 채팅방 정보를 설정
				.build();
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

	// 메시지 읽음 처리 예시 메소드 (구현 필요)
	public void markMessageAsRead(String messageNum) {
		String key = "chat:message:readStatus:" + messageNum;
		ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
		valueOps.set(key, "true"); // 메시지를 읽음 상태로 업데이트
	}
}

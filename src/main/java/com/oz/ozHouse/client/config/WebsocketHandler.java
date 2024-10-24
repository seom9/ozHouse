package com.oz.ozHouse.client.config;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

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

	private Map<String, HashSet<WebSocketSession>> roomSessions = new ConcurrentHashMap<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("웹소켓 연결이 설정되었습니다.");
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();
		ChattDTO chatt = objectMapper.readValue(payload, ChattDTO.class);
		String roomNumStr = String.valueOf(chatt.getRoomNum());

		switch (chatt.getType()) {
		case ENTER:
			enterRoom(session, chatt, roomNumStr);
			break;
		case TALK:
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

	 // 현재 채팅방에 입장한 사용자 수
	    int numberOfUsers = sessions.size();
	    
	    // 사용자 입장 메시지 방송
	    chatt.setMsg(chatt.getSender() + "님이 입장했습니다.");
	    broadcast(chatt, roomNumStr);
	}


	private void saveAndBroadcastMessage(WebSocketSession session, ChattDTO chattDTO, String roomNumStr)
	        throws IOException {
	    chattDTO.setRoomNum(Integer.parseInt(roomNumStr));
	    chattDTO.setInTime(LocalDateTime.now());
	    chattDTO.setReadStatus(1);
	    String receiver = determineReceiver(chattDTO.getRoomNum(), chattDTO.getSender());
	    chattDTO.setRecipient(receiver);
	    
	    Chatt savedChatt = chattService.save(new Chatt(chattDTO)); // DTO를 엔티티로 변환 후 저장
	    broadcast(chattDTO, roomNumStr);
	}
	
	private String determineReceiver(Integer roomNum, String sender) {
	    String receiver = chattRoomService.findOtherParticipant(roomNum, sender);
	    return receiver;
	}

	private void quitRoom(WebSocketSession session, ChattDTO chatt, String roomNumStr) throws IOException {
	    log.info("Handling quit for user: {} in room: {}", chatt.getSender(), roomNumStr);
	    HashSet<WebSocketSession> sessions = roomSessions.get(roomNumStr);
	    if (sessions != null) {
	        sessions.remove(session);
	        log.info("Updated presence status to off for user: {} in room: {}", chatt.getSender(), roomNumStr);
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
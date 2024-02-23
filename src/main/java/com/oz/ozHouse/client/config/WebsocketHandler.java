package com.oz.ozHouse.client.config;
//
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.oz.ozHouse.domain.Chatt;
//import com.oz.ozHouse.domain.ChattRoom;
//import com.oz.ozHouse.dto.ChattDTO;
//import com.oz.ozHouse.market.service.ChattRoomService;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
public class WebsocketHandler {//extends TextWebSocketHandler {
//
//	private final ObjectMapper objectMapper;
//	private final ChattRoomService chattRoomService;
//	private Map<String, HashSet<WebSocketSession>> roomSessions = new ConcurrentHashMap<>();
//
//	@Override
//	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//		log.info("WebSocket connection established");
//	}
//
//	@Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String payload = message.getPayload();
//        ChattDTO chatt = objectMapper.readValue(payload, ChattDTO.class);
//        String roomNumStr = String.valueOf(chatt.getRoomNum()); // 방 번호를 문자열로 변환
//
//        switch (chatt.getType()) {
//            case ENTER:
//                enterRoom(session, chatt, roomNumStr);
//                break;
//            case TALK:
//                talk(session, chatt, roomNumStr);
//                break;
//            case QUIT:
//                quitRoom(session, chatt, roomNumStr);
//                break;
//        }
//    }
//
//	private void enterRoom(WebSocketSession session, ChattDTO chatt, String roomNumStr) throws IOException {
//		HashSet<WebSocketSession> sessions = roomSessions.computeIfAbsent(roomNumStr, k -> new HashSet<>());
//		sessions.add(session);
//		chatt.setMsg(chatt.getSender() + "님이 입장했습니다.");
//		broadcast(chatt, roomNumStr);
//	}
//
//	private void talk(WebSocketSession session, ChattDTO chatt, String roomNumStr) throws IOException {
//		broadcast(chatt, roomNumStr);
//	}
//
//	private void quitRoom(WebSocketSession session, ChattDTO chatt, String roomNumStr) throws IOException {
//		HashSet<WebSocketSession> sessions = roomSessions.get(roomNumStr);
//		if (sessions != null) {
//			sessions.remove(session);
//			chatt.setMsg(chatt.getSender() + "님이 퇴장했습니다.");
//			broadcast(chatt, roomNumStr);
//		}
//	}
//
//	private void broadcast(ChattDTO chatt, String roomNumStr) throws IOException {
//		HashSet<WebSocketSession> sessions = roomSessions.get(roomNumStr);
//		if (sessions != null) {
//			TextMessage textMessage = new TextMessage(objectMapper.writeValueAsString(chatt));
//			for (WebSocketSession session : sessions) {
//				session.sendMessage(textMessage);
//			}
//		}
//	}
//
//	@Override
//	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//		// Handle connection closed
//	}
}

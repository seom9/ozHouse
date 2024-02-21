//package com.oz.ozHouse.client.config;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//import org.springframework.web.util.UriComponents;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Component
//public class SocketHandler extends TextWebSocketHandler {
//
////    private Map<String, List<WebSocketSession>> roomMap = new ConcurrentHashMap<>();
////
////    @Override
////    // WebSocket 연결이 성립되었을 때 실행되는 메서드
////    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
////        super.afterConnectionEstablished(session);
////        String roomNum = getRoomNum(session); // 세션으로부터 방 번호를 추출
////
////        roomMap.putIfAbsent(roomNum, new ArrayList<>()); // 방 번호에 해당하는 리스트가 없으면 새로 생성
////        roomMap.get(roomNum).add(session); // 해당 방의 세션 리스트에 현재 세션 추가
////
////        log.info("Session added in room: {}", roomNum); // 로그 출력
////    }
////
////    private String getRoomNum(WebSocketSession session) {
////        // URI에서 방 번호를 추출하는 메서드
////        String path = session.getUri().getPath();
////        UriComponents uriComponents = UriComponentsBuilder.fromUriString(path).build();
////        List<String> pathSegments = uriComponents.getPathSegments();
////        int index = pathSegments.indexOf("ws") + 2; // 경로가 /ozMarket/ws/chatt/{roomNum} 형식이라고 가정
////        return index > 1 && index < pathSegments.size() ? pathSegments.get(index) : null; // 방 번호 반환
////    }
////
////    @Override
////    // 메시지 수신 시 실행되는 메서드
////    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
////        String roomNum = getRoomNum(session); // 메시지를 받은 세션의 방 번호 추출
////        List<WebSocketSession> sessions = roomMap.get(roomNum); // 해당 방 번호의 모든 세션 리스트를 가져옴
////        
////        if (sessions != null) {
////            // 해당 방의 모든 세션에게 메시지 브로드캐스트
////            for (WebSocketSession webSocketSession : sessions) {
////                if (webSocketSession.isOpen() && !session.getId().equals(webSocketSession.getId())) {
////                    webSocketSession.sendMessage(message); // 메시지 전송
////                }
////            }
////        }
////    }
////}
//	private Map<String, List<WebSocketSession>> roomMap = new ConcurrentHashMap<>();
//
//    @Override
//    // WebSocket connection is established
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        super.afterConnectionEstablished(session);
//        String roomNum = getRoomNum(session); // Extract room number from session
//
//        roomMap.putIfAbsent(roomNum, new ArrayList<>()); // Create a new list for the room if it doesn't exist
//        roomMap.get(roomNum).add(session); // Add current session to the room's session list
//
//        log.info("Session added in room: {}", roomNum); // Log output
//    }
//
//    private String getRoomNum(WebSocketSession session) {
//        // Method to extract the room number from the URI
//        String path = session.getUri().getPath();
//        UriComponents uriComponents = UriComponentsBuilder.fromUriString(path).build();
//        List<String> pathSegments = uriComponents.getPathSegments();
//        int index = pathSegments.indexOf("chatting") + 1; // Assuming the path format is /ozMarket/ws/chatting/{roomNum}
//        return index > 0 && index < pathSegments.size() ? pathSegments.get(index) : ""; // Return the room number
//    }
//
//    @Override
//    // Handle received message
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String roomNum = getRoomNum(session); // Extract the room number of the session that received the message
//        List<WebSocketSession> sessions = roomMap.get(roomNum); // Get all sessions in the room
//        
//        if (sessions != null) {
//            // Broadcast the message to all sessions in the room except the sender
//            for (WebSocketSession webSocketSession : sessions) {
//                if (webSocketSession.isOpen() && !session.getId().equals(webSocketSession.getId())) {
//                    webSocketSession.sendMessage(message); // Send the message
//                }
//            }
//        }
//    }
//}

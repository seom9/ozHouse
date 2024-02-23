//package com.oz.ozHouse.chatt.test;
//
//import java.io.IOException;
//import java.util.Set;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j // Lombok 라이브러리의 로깅 어노테이션. 클래스 내부에서 로거를 사용할 수 있게 해줌
//@RequiredArgsConstructor // Lombok 라이브러리의 생성자 자동 생성 어노테이션. final이나 @NonNull 필드에 대한 생성자를 자동으로 생성
//@Component // 스프링의 컴포넌트 스캔이 이 클래스를 빈으로 등록하게 해주는 어노테이션.
//public class WebsocketHandler extends TextWebSocketHandler {
//	
//    private final ObjectMapper objectMapper; // JSON 문자열과 Java 객체 간의 변환을 담당하는 Jackson 라이브러리의 클래스.
//    private final ChatService chatService; // 채팅방 관련 서비스 로직을 처리하는 클래스.
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        // 웹소켓 연결이 맺어진 후 실행되는 메소드. 여기서는 추가적인 로직을 구현하지 않았습니다.
//    }
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String payload = message.getPayload(); // 클라이언트로부터 받은 메시지의 내용.
//        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class); // 받은 메시지를 ChatMessage 객체로 변환.
//        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId()); // 메시지에서 얻은 채팅방 ID로 채팅방 정보를 조회.
//        Set<WebSocketSession> sessions = room.getSessions(); // 해당 채팅방에 있는 모든 사용자의 웹소켓 세션을 가져옵니다.
//
//        // 사용자가 채팅방에 입장한 경우의 로직.
//        if (chatMessage.getType().equals(ChatMessage.MessageType.ENTER)) {
//            sessions.add(session); // 현재 세션을 채팅방의 세션 목록에 추가합니다.
//            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다."); // 입장 메시지를 설정합니다.
//            sendToEachSocket(sessions, new TextMessage(objectMapper.writeValueAsString(chatMessage))); // 모든 사용자에게 입장 메시지를 전송합니다.
//        } else if (chatMessage.getType().equals(ChatMessage.MessageType.QUIT)) { // 사용자가 채팅방에서 퇴장한 경우의 로직.
//            sessions.remove(session); // 현재 세션을 채팅방의 세션 목록에서 제거합니다.
//            chatMessage.setMessage(chatMessage.getSender() + "님이 퇴장했습니다."); // 퇴장 메시지를 설정합니다.
//            sendToEachSocket(sessions, new TextMessage(objectMapper.writeValueAsString(chatMessage))); // 모든 사용자에게 퇴장 메시지를 전송합니다.
//        } else {
//            sendToEachSocket(sessions, message); // 그 외의 경우(일반 메시지 전송)에는 받은 메시지를 그대로 모든 사용자에게 전송합니다.
//        }
//    }
//    private void sendToEachSocket(Set<WebSocketSession> sessions, TextMessage message) {
//        sessions.parallelStream().forEach(roomSession -> { // 채팅방에 있는 모든 세션에 대해 메시지를 병렬로 전송합니다.
//            try {
//                roomSession.sendMessage(message); // 각 사용자의 웹소켓 세션에 메시지를 전송합니다.
//            } catch (IOException e) {
//                throw new RuntimeException(e); // 메시지 전송 중 오류가 발생하면 예외를 던집니다.
//            }
//        });
//    }
//
//
//    // 웹소켓 연결이 종료된 후 실행되는 메소드
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//    }
//}
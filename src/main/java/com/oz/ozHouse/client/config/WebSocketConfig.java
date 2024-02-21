//package com.oz.ozHouse.client.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer {
//
//	private final SocketHandler handler;
//
//	@Override
//	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		registry.addHandler(handler, "/ozMarket/ws/chatting").setAllowedOrigins("*").withSockJS();
//
//	}
//}
//
////@Configuration
////@EnableWebSocketMessageBroker // WebSocket 서버를 사용한다! 하는 설정 어노테이션
////public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
////
////	// 클라이언트에서 websocket에 접속하는 endpoint를 등록
////	@Override
////	public void registerStompEndpoints(StompEndpointRegistry registry) {
////		registry.addEndpoint("/ws").withSockJS();
////		// /ws라는 엔드포인트(통신의 도착지점)를 설정 : 웹 소켓 통신이 해당 엔드
////		// 포인트에 도착하면 이 통신이 stomp통신임을 깨닫게 됨.
////
////		// .withSockJS() : SocketJS를 사용
////	}
////}
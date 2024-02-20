package com.oz.ozHouse.client.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketHandler;

@Controller
public class SocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String handle(String message) {
        logger.info("Received message: {}", message);
        return "Hello, " + message + "!";
    }
}


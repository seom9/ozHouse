package com.oz.ozHouse.market.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

//import com.oz.ozHouse.client.config.SocketHandler;
import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.dto.ChattRoomDTO;
import com.oz.ozHouse.market.service.ChattRoomService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ozMarket")
public class ChattController {

	private final ChattRoomService chattRoomService;
	
    private static final Map<String, WebSocketSession> userSessions = new ConcurrentHashMap<>();

    // SocketHandler가 세션 맵에 접근하거나 내부적으로 관리할 수 있다고 가정
    @Autowired
//    private SocketHandler socketHandler;

	// 채팅방 생성
	@PostMapping("/ws/chatt")
	private String chattRoom(@AuthenticationPrincipal MemberSecurityDTO member, HttpServletRequest req,
			@RequestParam Map<String, String> params, @RequestParam("proNum") int proNum) {

		String myId = member.getMemberNickname();
		req.setAttribute("myId", myId);
		ChattRoomDTO dto = new ChattRoomDTO(req);
		System.out.println("myId : " + myId);
		System.out.println("proNum : " + proNum);
		dto.setMyId(member.getMemberNickname());
		dto.setOtherId(params.get("memberNickname"));
		int res = chattRoomService.getOrCreateChatRoom(dto);
		if (res != 0) {
			req.setAttribute("msg", "채팅방에 입장하였습니다.");

		} else {
			req.setAttribute("msg", "다시 시도해주세요.");
		}
		System.out.println("방? : " + res);
		System.out.println("myId : " + dto.getMyId());
		System.out.println("proNum : " + dto.getProNum());
		req.setAttribute("url", "/ozMarket/ws/chatt/" + res);

		return "message";
	}

	// 채팅방 입장
	@GetMapping("/ws/chatt/{roomNum}")
	private String inRoom(HttpServletRequest req, @PathVariable(value = "roomNum") Integer roomNum) {
		return "client/ozMarket/chatt";
	}
	
	public void sendMessage(String user, String message) {
        WebSocketSession session = userSessions.get(user); 
        if (session != null && session.isOpen()) {
            try {
                session.sendMessage(new TextMessage(message));
            } catch (Exception e) {
            }
        }
    }

}
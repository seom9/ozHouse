package com.oz.ozHouse.client.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.EmailService;
import com.oz.ozHouse.client.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final MemberService memberService;
	private final EmailService emailService;
	
	// setMessage 메서드
    private String setMessage (HttpServletRequest req, String url, String msg) {
    	req.setAttribute("url", url);
    	req.setAttribute("msg", msg);
    	return "message";
    }
	
	@GetMapping("/member/login")
	public String loginGet() {
		return "client/member/member_login";
	}
	
	@GetMapping("/login/message")
	public String loginSuccess(HttpServletRequest req) {
		return setMessage(req, "/main", "오즈 하우스에 오신 것을 환영합니다!");
	}
	
	@GetMapping("/member/find")
	public String searchMember() {
		return "client/member/member_find";
	}

	@PostMapping("/member/{memberEmail}/find")
	public String searchMember(HttpServletRequest req, 
								@PathVariable Map<String, String> pathVariables) 
								throws Exception {
		
		String checkNum = emailService.sendOauthMessage(pathVariables.get("memberEmail"), "회원 정보 변경");
		
		return (checkNum == pathVariables.get("userSendNum")) 
				? setMessage(req, "/" + pathVariables.get("memberEmail") + "/updatepass/find", "비밀번호를 재설정해 주세요")
				: setMessage(req, "/member/find", "인증 번호가 다릅니다 : 다시 시도해 주세요");
	}

}

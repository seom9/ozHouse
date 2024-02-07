package com.oz.ozHouse.merchant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oz.ozHouse.merchant.bean.MerchantLoginBean;
import com.oz.ozHouse.merchant.service.MerLoginService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MerLoginController {
	private final MerLoginService loginService;

	@GetMapping("/merchant-login")
	public String login() {
		return "merchant/join/merchant_login";
	}
	
	@PostMapping(value="/merchant-loginOk")
	public String loginOk(HttpServletRequest req, HttpServletResponse resp, 
			@ModelAttribute MerchantLoginBean loginOk, 
			@RequestParam(name = "saveId", required=false) String saveId) {
		int res = loginOk.loginOk(loginService);
		String msg = null, url = null;
		switch(res){
		case MerchantLoginBean.OK :
			Cookie ck = new Cookie("saveId", loginOk.getMerId());
			if (saveId != null) {
				ck.setMaxAge(7*24*60*60);
			}else {
				ck.setMaxAge(0);
			}
			resp.addCookie(ck);
			HttpSession session = req.getSession();
			session.setAttribute("merchantLoginMember", loginOk);
			msg = loginOk.getMerId() + "님, OZ의 집에 오신걸 환영합니다.";
			url = "merchant_main.do";
			break;
		case MerchantLoginBean.NOT_ID :
			msg = "아이디 확인 후 다시 시도해 주세요";
			url = "merchant_login.do";
			break;
		case MerchantLoginBean.NOT_PW :
			msg = "비밀번호 확인 후 다시 시도해 주세요";
			url = "merchant_login.do";
			break;
		case MerchantLoginBean.ERROR : 
			msg = "DB 접속 오류! 관리자에게 문의해 주세요";
			url = "merchant_main.do";
			break;
		case MerchantLoginBean.DELETE_ID : 
			msg = "사용 중지된 ID입니다.";
			url = "merchant_main.do";
			break;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
    	return "forward:message.jsp";
	}
}

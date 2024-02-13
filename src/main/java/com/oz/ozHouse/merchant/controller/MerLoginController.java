package com.oz.ozHouse.merchant.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oz.ozHouse.client.service.EmailService;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.config.MerchantLoginBean;
import com.oz.ozHouse.merchant.service.MerLoginService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/merchant")
public class MerLoginController {
	private final MerLoginService loginService;
	private final EmailService emailService;
	private final PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String login() {
		return "merchant/join/merchant_login";
	}
	
	@PostMapping("/login/loginOk")
	public String loginOk(HttpServletRequest req, HttpServletResponse resp, 
			@ModelAttribute MerchantLoginBean loginOk, 
			@RequestParam(name = "saveId", required=false) String saveId) {
		int res = loginOk.loginOk(loginService, passwordEncoder);
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
			url = "/merchant/main";
			break;
		case MerchantLoginBean.NOT_ID :
			msg = "아이디 확인 후 다시 시도해 주세요";
			url = "/merchant/login";
			break;
		case MerchantLoginBean.NOT_PW :
			msg = "비밀번호 확인 후 다시 시도해 주세요";
			url = "/merchant/login";
			break;
		case MerchantLoginBean.ERROR : 
			msg = "DB 접속 오류! 관리자에게 문의해 주세요";
			url = "/merchant/main";
			break;
		case MerchantLoginBean.DELETE_ID : 
			msg = "사용 중지된 ID입니다.";
			url = "/merchant/main";
			break;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
    	return "message";
	}
	
	@GetMapping(value="/login/logout")
    public String logout(HttpServletRequest req) {
    	HttpSession session = req.getSession();
    	session.invalidate();
    	String msg = "로그아웃 되었습니다.";
    	String url = "/merchant/main";
    	req.setAttribute("msg", msg);
    	req.setAttribute("url", url);
    	return "message";
    }
	@GetMapping("/login/findMerchant")
	public String findMerchant() {
		return "merchant/join/merchant_find";
	}
	
	@PostMapping(value = "/login/sendEmail")
	public String sendEmail1(HttpServletRequest req, 
			@RequestParam(name = "merEmail")String merEmail) throws Exception {
		String mer_id = loginService.checkMerchantIdEmail(merEmail);
		if (mer_id == null) {
			req.setAttribute("msg", "가입되어 있지 않은 Email입니다");
			req.setAttribute("url", "/merchant/login/findMerchant");
			return "message";
		}

		String oauthNum = emailService.sendOauthMessage(merEmail);
		req.setAttribute("oauthNum", oauthNum);
		req.setAttribute("member_email", merEmail);
		return "merchant/join/merchant_send_find_email";
	}
	
	@PostMapping(value="/login/find")
	public String searchMember(HttpServletRequest req, 
			@RequestParam(name = "merEmail")String mer_email) {
		String member_id = loginService.checkMerchantIdEmail(mer_email);
		
		String oauthNum = req.getParameter("oauthNum");
		String userSendNum = req.getParameter("userSendNum");
		
		if (oauthNum.equals(userSendNum)) {
			req.setAttribute("msg", "비밀번호를 재설정해 주세요");
			req.setAttribute("url", "merchant/login/changePass/" + member_id);
		}else {
			req.setAttribute("msg", "인증 번호가 다릅니다 : 다시 시도해 주세요");
			req.setAttribute("url", "merchant/login/find");
		}
		return "message";
	}
	
	@GetMapping(value = "/login/changePass/{member_id}")
    public String mypage_updatePasswd(HttpServletRequest req,
    		@PathVariable("member_id") String memberId) {
    	String mode = req.getParameter("mode");
    	
    	if (mode != null) {
    		req.setAttribute("mode", "find");
    		req.setAttribute("member_id", memberId);
    	}
        return "merchant/join/merchant_changePass";
    }
	
	private MerchantDTO getMember(HttpServletRequest req) {
    	HttpSession session = req.getSession();
    	MerchantLoginBean merchantLoginMember = (MerchantLoginBean)session.getAttribute("merchantLoginMember");
    	MerchantDTO dto = loginService.merchant_getMember(merchantLoginMember.getMerId());
    	return dto;
    }
	
	@PutMapping(value = "/login/putPassword")
    public String mypage_updatePasswdPro(HttpServletRequest req) {
    	MerchantDTO dto = new MerchantDTO();
    	String mode = req.getParameter("mode");
    	String id = req.getParameter("member_id");
    	String new_pass = req.getParameter("new_member_passwd");
    	
        boolean passwd = false;
        
        if (!mode.equals("find")) {
        	dto = getMember(req);
            String old_pass = req.getParameter("member_passwd");
        	passwd = passwordEncoder.matches(old_pass, dto.getMerPw());
        }else if(mode.equals("find")) {
        	passwd = true;
        	dto.setMerId(id);
        }
    	
    	if (passwd) {
    		dto.setMerPw(new_pass);
        	boolean res = loginService.updatePass(
        			dto.getMerPw(), dto.getMerId());
        	if (res) {
    			req.setAttribute("msg", "비밀번호가 업데이트 되었습니다");
    			req.setAttribute("url", "merchant_login.do");
    		}else{
    			req.setAttribute("msg", "비밀번호 업데이트 실패 : 수정하실 비밀번호를 확인해 주세요");
    			req.setAttribute("url", "merchant_login.do");
    		}
    	}else {
    		req.setAttribute("msg", "비밀번호 업데이트 실패 : 다시 확인해 주세요");
			req.setAttribute("url", "merchant_login.do");
    	}
    	
        return "message";
    }
	
}

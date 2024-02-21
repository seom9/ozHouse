package com.oz.ozHouse.client.controller;

import java.net.BindException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oz.ozHouse.client.service.EmailService;
import com.oz.ozHouse.client.service.MypageService;
import com.oz.ozHouse.dto.client.member.MemberPasswdUpdateDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final MypageService mypageService;
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
	
	
	@GetMapping("/member/{memberEmail}/find")
	public String findMember(HttpServletRequest req, 
								@PathVariable("memberEmail") String memberEmail) 
								throws Exception {
		
		String checkNum = emailService.sendOauthMessage(memberEmail, "회원 정보 변경");
		req.setAttribute("checkNum", checkNum);
		return "client/member/send_find_email";
	}	
	 
	
	@PostMapping("/member/{memberEmail}/find")
	public String searchMember(HttpServletRequest req, 
								@PathVariable("memberEmail") String memberEmail,
								@ModelAttribute MemberPasswdUpdateDTO dto) 
								throws Exception {
		
		return (dto.getCheckNum() == dto.getUserSendNum()) 
				? setMessage(req, "/member/" + memberEmail + "/updatepass/find", "비밀번호를 재설정해 주세요")
				: setMessage(req, "/member/find", "인증 번호가 다릅니다 : 다시 시도해 주세요");
	}
	
	
	@GetMapping("/member/{member}/updatepass/find")
    public String mypage_updatePasswd(HttpServletRequest req, 
    					@PathVariable("member") String member) {
		req.setAttribute("mode", "find");
		req.setAttribute("member", member);
        return "client/mypage/mypage_updatePasswd";
    }
	
	
    @PatchMapping("/member/{member}/updatepass/{mode}")
    @ResponseBody
    public String mypage_updatePasswdPro(HttpServletRequest req,
				    					@RequestBody @Validated MemberPasswdUpdateDTO dto,
				    					@PathVariable Map<String, String> pathVariables,
				    					BindingResult result)
				    	    			throws BindException{
    	
    	boolean pass = false;
    	
        if (pathVariables.get("mode").equals("find")) {
        	pass = mypageService.renewPass(dto);
        }else if (pathVariables.get("mode").equals("up")){
        	pass = mypageService.passUpdate(dto);
        }
        
        return (pass) ? "회원 정보가 수정되었습니다" : "회원 정보 수정 실패 : 서버에 문의해 주세요";
    }

}

package com.oz.ozHouse.client.controller;

import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oz.ozHouse.client.service.EmailService;
import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	private final EmailService emailService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/member_login.do")
	public String index() {
		return "client/member/member_login";
	}
	
    @GetMapping(value = "/member_join.do")
    public String member_join() {
        return "client/member/member_join";
    }
    
    // 가입 인증 이메일
    @PostMapping("/member_send_email.do")
    public String emailAuth(HttpServletRequest req, MemberDTO dto) throws Exception{
        String email = req.getParameter("email");

        if (memberService.checkEmail(email) > 0) {
			req.setAttribute("msg", "이미 가입되어 있습니다");
			req.setAttribute("url", "member_join.do");
			return "message";
        }

        // 메일 전송
        String checkNum = emailService.sendOauthMessage(email);
        req.setAttribute("checkNum", checkNum);
        req.setAttribute("email", email);
        req.setAttribute("member", dto);
        return "client/member/member_join_check";
    }
    
    @PostMapping("/email_join_check.do")
    public String emailAuthCheck(HttpServletRequest req, @ModelAttribute MemberDTO dto, @RequestParam Map<String, String> params) {
    	if (params.get("checkNum").equals(params.get("checkNumCheck"))) {
        	
        	HttpSession session = req.getSession();
        	MemberDTO insert = (MemberDTO)session.getAttribute("insertMember");
        	if (insert != null) dto.setMemberImage(insert.getMemberImage()); 
        	String passwd = dto.getMemberPasswd();
        	dto.setMemberPasswd(passwordEncoder.encode(passwd));
        	
        	int res = memberService.insertMember(dto.toEntity());
    		if (res>0) {
    			req.setAttribute("msg", "회원 가입 성공 : 안녕하세요!");
    			req.setAttribute("url", "main.do");
    		}else if (res<0){
    			req.setAttribute("msg", "회원 가입 실패 : 다시 시도해 주세요");
    			req.setAttribute("url", "member_join.do");
    		}
        	return "message";
        }else {
			req.setAttribute("msg", "회원 가입 실패 : 다시 시도해 주세요");
			req.setAttribute("url", "member_join.do");
        	return "message";
        }
    }

    public boolean isValid(String str) {
        return Pattern.matches("^[a-zA-Z0-9-_]*$", str);
    }
    

    @PostMapping("/member_checkId.do")
    @ResponseBody
    public String checkId(@RequestParam("member_id") String id) {
        String result="N";
        if (memberService.checkId(id) > 0) result = "Y"; 	
        if (id.trim().equals("")) result = "E";					
        if (id.length() < 6 || id.length() > 12) result = "L";
        if (isValid(id) == false) result = "V";				
        
        return result;
    }

}

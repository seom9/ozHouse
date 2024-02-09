package com.oz.ozHouse.client.controller;

import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oz.ozHouse.client.config.LoginOkBean;
import com.oz.ozHouse.client.service.EmailService;
import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.domain.common.Address;
import com.oz.ozHouse.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	private final EmailService emailService;
	private final PasswordEncoder passwordEncoder;

	
    @GetMapping("/join")
    public String member_join() {
        return "client/member/member_join";
    }
    
    @PostMapping("/email-verification")
    public String emailAuth(@RequestParam("email") String email, 
    							@ModelAttribute MemberDTO dto, BindingResult result, 
    							HttpServletRequest req) throws Exception {
    	
        if (memberService.checkEmail(email) > 0) {
			req.setAttribute("msg", "이미 가입되어 있습니다");
			req.setAttribute("url", "member/join");
			return "message";
        }

        String checkNum = emailService.sendOauthMessage(email);

        req.setAttribute("checkNum", checkNum);
        req.setAttribute("email", email);
        req.setAttribute("member", dto);

        return "client/member/member_join_check";
    }
    
    @PostMapping("/members")
    public String emailAuthCheck(@ModelAttribute MemberDTO dto, HttpServletRequest req, @RequestParam Map<String, String> params) {
    	if (params.get("checkNum").equals(params.get("checkNumCheck"))) {
        	
        	HttpSession session = req.getSession();
        	MemberDTO insert = (MemberDTO)session.getAttribute("insertMember");
        	if (insert != null) dto.withMemberImage(insert.getMemberImage()); 
        	String passwd = dto.getMemberPasswd();
        	dto.withMemberPasswd(passwordEncoder.encode(passwd));

        	String res = memberService.insertMember(dto);
    		if (res != null) {
    			req.setAttribute("msg", "회원 가입 성공 : 안녕하세요!");
    			req.setAttribute("url", "/main");
    		}else if (res == null){
    			req.setAttribute("msg", "회원 가입 실패 : 다시 시도해 주세요");
    			req.setAttribute("url", "member/join");
    		}
        	return "message";
        }else {
			req.setAttribute("msg", "회원 가입 실패 : 다시 시도해 주세요");
			req.setAttribute("url", "member/join");
        	return "message";
        }
    }

    
    public boolean isValid(String str) {
        return Pattern.matches("^[a-zA-Z0-9-_]*$", str);
    }
    

    @PostMapping("/id-verification/{member_id}")
    @ResponseBody
    public String checkId(@PathVariable("member_id") String id) {
        String result="N";
        if (memberService.checkId(id) > 0) result = "Y"; 	
        if (id.trim().equals("")) result = "E";					
        if (id.length() < 6 || id.length() > 12) result = "L";
        if (isValid(id) == false) result = "V";				
        
        return result;
    }
    
    /* SNS 회원 가입 메서드
    @PostMapping("/member_oauth.do")
    public String member_oauth(HttpServletRequest req, @ModelAttribute MemberDTO dto) {
	    int res = memberMapper.insertMember(dto);
		if (res>0) {
				req.setAttribute("msg", "sns 계정으로 회원 가입 성공 : 안녕하세요!");
				req.setAttribute("url", "main.do");
			}else if (res<0){
				req.setAttribute("msg", "회원 가입 실패 : 다시 시도해 주세요");
				req.setAttribute("url", "member_join.do");
			}
	    	return "message";
    }
  
    

    
    public boolean isValid(String str) {
        return Pattern.matches("^[a-zA-Z0-9-_]*$", str);
    }
    
    @RequestMapping("/member_checkId.do")
    @ResponseBody
    public String checkId(@RequestParam("member_id") String id) {
        String result="N";
        if (memberMapper.checkId(id) != null) result = "Y"; 	
        if (id.trim().equals("")) result = "E";					
        if (id.length() < 6 || id.length() > 12) result = "L";
        if (isValid(id) == false) result = "V";				
        
        return result;
    }
    
    @RequestMapping(value="/member_delete.do", method = RequestMethod.GET)
    public String memberDelete(HttpServletRequest req) {
    	return "client/member/member_delete";
    }
    
    @RequestMapping(value="/member_delete.do", method = RequestMethod.POST)
    public String memberdelete(HttpServletRequest req) {
    	String con = req.getParameter("confirmed");
    	MemberDTO dto = getMember(req);
    	int res = 0;
    	
    	if (con.equals("on")) {
    		res = memberMapper.deleteMember(dto);
    	}
    	
    	if (res >= 1){
    		HttpSession session = req.getSession();
    		session.invalidate();
        	req.setAttribute("msg", "회원 탈퇴 : 완료되었습니다");
        	req.setAttribute("url", "main.do");
    	}else {
        	req.setAttribute("msg", "회원 탈퇴 : 실패하였습니다");
        	req.setAttribute("url", "main.do");
    	}

    	return "message";
    }
     */
}

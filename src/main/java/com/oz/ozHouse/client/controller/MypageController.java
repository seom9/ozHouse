package com.oz.ozHouse.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oz.ozHouse.client.config.LoginOkBean;
import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.domain.common.Address;
import com.oz.ozHouse.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {
	private final MemberService memberService;
	
    private MemberDTO getMember(HttpServletRequest req) {
    	HttpSession session = req.getSession();
    	LoginOkBean loginMember = (LoginOkBean)session.getAttribute("loginMember");
    	MemberDTO dto = memberService.getMember(loginMember.getMember_id());
    	return dto;
    }
	
	@GetMapping("/profile")
	public String index(HttpServletRequest req) {
    	MemberDTO dto = getMember(req);
    	req.setAttribute("member", dto);
        return "client/mypage/mypage_profile";
	}
	
    @GetMapping("/{memberId}/update")
    public String memberUpdate(HttpServletRequest req){
		HttpSession session = req.getSession();
    	LoginOkBean login = (LoginOkBean)session.getAttribute("loginMember");
    	MemberDTO dto = memberService.getMember(login.getMember_id());
    	
        req.setAttribute("upPath", req.getServletContext().getRealPath("/resources/image"));

    	if (dto.getMemberAddress() != null) { 
    		Address address = dto.getMemberAddress();
            req.setAttribute("address", address);
    	}
        req.setAttribute("member", dto);
    	return "client/member/member_update";
    }
}

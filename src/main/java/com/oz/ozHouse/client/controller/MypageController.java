package com.oz.ozHouse.client.controller;

import java.io.File;
import java.io.IOException;
import java.net.BindException;
import java.util.Enumeration;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.client.config.LoginOkBean;
import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.common.Address;
import com.oz.ozHouse.dto.DTO;
import com.oz.ozHouse.dto.MemberDTO;
import com.oz.ozHouse.dto.client.member.MemberUpdateDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
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
	
    // get 방식에는 @PreAuthorize 어노테이션
    @PreAuthorize("hasRole('User')")
	@GetMapping("/profile")
	public String index(HttpServletRequest req) {
    	MemberDTO dto = getMember(req);
    	req.setAttribute("member", dto);
        return "client/mypage/mypage_profile";
	}
	
    @GetMapping(value = {"/{memberId}/update", "/{memberId}/update/{mode}"})
    public String memberUpdate(HttpServletRequest req, 
    							@PathVariable(value = "mode", required = false) String mode){
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
	
    @PatchMapping("/{memberId}/update")
    @ResponseBody
    public String checkId(HttpServletRequest req, @PathVariable("memberId") String memberId,
    		@RequestBody @Validated MemberUpdateDTO dto, BindingResult result) throws BindException {
    	Member member = memberService.getMemberEntity(memberId);
    	member = dto.updateEntity(member, dto);
        int res = memberService.updateMember(member);
        
        if (res > 0) {
            return "회원 정보가 수정되었습니다";
        } else {
            return "회원 정보 수정 실패되었습니다 : 서버에 문의해 주세요";
        }
    }
	
	
    
}

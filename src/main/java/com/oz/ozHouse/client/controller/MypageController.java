package com.oz.ozHouse.client.controller;

import java.io.File;
import java.io.IOException;
import java.net.BindException;
import java.util.Enumeration;
import java.util.Map;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
import com.oz.ozHouse.client.security.CustomUserDetailsService;
import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.common.Address;
import com.oz.ozHouse.dto.DTO;
import com.oz.ozHouse.dto.MemberDTO;
import com.oz.ozHouse.dto.client.member.MemberUpdateDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequestMapping("/mypage")
@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
@RequiredArgsConstructor
public class MypageController {
	private final MemberService memberService;
	
    @GetMapping("/hi")
    public String index(@AuthenticationPrincipal MemberSecurityDTO member) {
        System.out.println("username : " + member.getUsername());
        System.out.println("isSocial? : " + member.isSocial());
        return "client/member/member_join";
    }
    
	@GetMapping("/profile")
	public String index(HttpServletRequest req, 
						@AuthenticationPrincipal MemberSecurityDTO member) {
    	req.setAttribute("member", memberService.getMember(member.getMemberId()));
    	return "client/mypage/mypage_profile";
	}
	
    @GetMapping(value = {"/{memberId}/update", "/{memberId}/update/{mode}"})
    public String memberUpdate(HttpServletRequest req, 
    					@AuthenticationPrincipal MemberSecurityDTO member,
    					@PathVariable(value = "mode", required = false) String mode){
    	MemberDTO dto = memberService.getMember(member.getUsername());
    	
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
    					@RequestBody @Validated MemberUpdateDTO dto, BindingResult result) 
    					throws BindException {
    	
    	Member member = memberService.getMemberEntity(memberId);
    	member = dto.updateEntity(member, dto);
        int res = memberService.updateMember(member);
        
        return (res > 0) ? "회원 정보가 수정되었습니다" : "회원 정보 수정 실패 : 서버에 문의해 주세요";

    }
	
    // 비밀번호 변경
	@GetMapping(value = {"/{memberId}/updatepass/{mode}", "/{memberId}/updatepass"})
    public String mypage_updatePasswd(HttpServletRequest req, 
    					@PathVariable Map<String, String> pathVariables) {
    	
    	if (pathVariables.get("mode") != null) {
    		req.setAttribute("mode", "find");
    		req.setAttribute("member_id", pathVariables.get("memberId"));
    	}
    	
        return "client/mypage/mypage_updatePasswd";
    }
    
    @PatchMapping("/{memberId}/updatepass/{mode}")
    @ResponseBody
    public String mypage_updatePasswdPro(HttpServletRequest req,
				    					@RequestBody @Validated String new_pass,
				    					@PathVariable Map<String, String> pathVariables,
				    					BindingResult result)
				    	    			throws BindException {
        /*
        if (pathVariables.get("mode").equals("find")) {
        	dto = getMember(req);
            String old_pass = req.getParameter("member_passwd");
        	passwd = passwordEncoder.matches(old_pass, dto.getMember_passwd());
        }else if(mode.equals("find")) {
        	passwd = true;
        	dto.setMember_id(id);
        }
    	*/
        return "message";
    }

    
}

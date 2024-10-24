package com.oz.ozHouse.client.controller;

import java.net.BindException;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.client.service.MypageService;
import com.oz.ozHouse.client.service.OrderService;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.common.Address;
import com.oz.ozHouse.dto.MemberDTO;
import com.oz.ozHouse.dto.client.member.ClientOrderListDTO;
import com.oz.ozHouse.dto.client.member.MemberPasswdUpdateDTO;
import com.oz.ozHouse.dto.client.member.MemberUpdateDTO;
import com.oz.ozHouse.dto.client.member.MypagePointDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequestMapping("/mypage")
@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
@RequiredArgsConstructor
public class MypageController {
	
	private final MemberService memberService;
	private final OrderService orderService;
	
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
	
    
	@GetMapping(value = {"/{memberId}/updatepass/up", "/{memberId}/updatepass"})
    public String mypage_updatePasswd(HttpServletRequest req, 
    					@PathVariable Map<String, String> pathVariables) {
    	
    	req.setAttribute("mode", "up");
    	req.setAttribute("member", pathVariables.get("memberId"));

        return "client/mypage/mypage_updatePasswd";
    }
	
	@GetMapping("/point")
    public String mypageMyPoint(HttpServletRequest req, 
    								@AuthenticationPrincipal MemberSecurityDTO member) {
    	
		List<MypagePointDTO> orders = orderService.getMypointDTO(member.getUsername());
		
		req.setAttribute("member_p", orders);
		req.setAttribute("memberPoint", memberService.memberPoint(member.getUsername()));
		
		return "client/mypage/mypage_point";
    }
		
}

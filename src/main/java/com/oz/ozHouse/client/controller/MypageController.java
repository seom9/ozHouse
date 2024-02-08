package com.oz.ozHouse.client.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.client.config.LoginOkBean;
import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.common.Address;
import com.oz.ozHouse.dto.MemberDTO;
import com.oz.ozHouse.dto.client.MemberUpdateDTO;

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

	@PostMapping("/{memberId}/update")
	public String updateMember(HttpServletRequest req, @PathVariable("memberId") String memberId,
								@ModelAttribute MemberUpdateDTO dto, BindingResult result) {
	    // 요청 파라미터 확인
	    Enumeration<String> parameterNames = req.getParameterNames();
	    while (parameterNames.hasMoreElements()) {
	        String paramName = parameterNames.nextElement();
	        String paramValue = req.getParameter(paramName);
	        System.out.println("Parameter: " + paramName + " = " + paramValue);
	    }
	    
	    // DTO 값 확인
	    System.out.println("DTO values: " + dto);
		
		
//		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
//		MultipartFile mf = mr.getFile("memberImage");
//		String filename = mf.getOriginalFilename();
//		String path = req.getServletContext().getRealPath("client/image");
//		System.out.println(path);
//		File file = new File(path, filename);
		
		System.out.println("변경 사항 : " + dto.getMemberNickname());
		System.out.println("===================================");
		System.out.println("파라미터도 제대로 찍히는데 안 들어옴");

		
//		if (filename == null || filename.trim().equals("")) {
//			dto.setMemberImage(req.getParameter("member_image2"));
//			System.out.println(req.getParameter("member_image2"));
//		} else {
//			try {
//				mf.transferTo(file);
//			} catch (IOException e) {
//				req.setAttribute("msg", "이미지 업로드 실패 : 다시 확인해 주세요");
//				req.setAttribute("url", "");
//				return "message";
//			}
//			dto.setMemberImage(path);
//		}
		Member member = memberService.getMemberEntity(memberId);
		member = dto.updateEntity(member, dto);
		int res = memberService.updateMember(member);
		System.out.println("다 되는데 반영이 안 되고 있음");
		if (res > 0) {
			return "redirect:/mypage/" + memberId + "/update/success";
		} else{
			return "redirect:/mypage/" + memberId + "/update/fail";
		}
	}
    
}

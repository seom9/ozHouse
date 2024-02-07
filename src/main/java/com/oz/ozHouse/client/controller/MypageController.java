package com.oz.ozHouse.client.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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

	@PutMapping("/{memberId}/update")
	public String updateMember(HttpServletRequest req, @PathVariable String memberId,
								@ModelAttribute MemberDTO dto, BindingResult result) {
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		MultipartFile mf = mr.getFile("memberImage");
		String filename = mf.getOriginalFilename();
		String path = req.getServletContext().getRealPath("client/image");
		System.out.println(path);
		File file = new File(path, filename);
		
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
		
		int res = memberService.updateMember(dto);
		if (res > 0) {
			req.setAttribute("msg", "회원 정보가 수정되었습니다");
			req.setAttribute("url", "");
		} else if (res < 0) {
			req.setAttribute("msg", "회원 정보 수정 실패");
			req.setAttribute("url", "redirect:/mypage/" + memberId + "/update");
		}
		return "message";
	}
    
}

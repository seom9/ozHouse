package com.oz.ozHouse.client.controller;

import java.net.BindException;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.client.service.MypageService;
import com.oz.ozHouse.client.service.ScrapService;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.dto.client.member.MemberUpdateDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequiredArgsConstructor
public class ScrapController {
	
	private final ScrapService scrapService;
	
    @PostMapping("/scrap/{memberId}/{productNum}/{is}")
    @ResponseBody
    public String scrap(HttpServletRequest req, @PathVariable("productNum") int productNum,
    									@PathVariable("is") boolean is,
    									@AuthenticationPrincipal MemberSecurityDTO member,
				    					BindingResult result) throws BindException {

        boolean res = scrapService.doScrap(member.getUsername(), productNum, is);
    	
        return (res) ? "스크랩 완료되었습니다" : "스크랩 취소되었습니다";
    }
}

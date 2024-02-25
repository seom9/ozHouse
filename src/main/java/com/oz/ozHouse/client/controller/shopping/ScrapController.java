package com.oz.ozHouse.client.controller.shopping;

import java.net.BindException;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.ScrapService;
import com.oz.ozHouse.dto.ProductDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequiredArgsConstructor
public class ScrapController {
	
	private final ScrapService scrapService;
	
	@PostMapping("/scrap/{memberId}/{productNum}/{is}")
	@ResponseBody
	public String scrap(@PathVariable("productNum") int productNum,
			                    @PathVariable("is") boolean is,
			                    @AuthenticationPrincipal MemberSecurityDTO member) {

	    boolean res = scrapService.doScrap(member.getUsername(), productNum, is);
	    
	    return (res) ? "스크랩 완료되었습니다" : "스크랩 취소되었습니다";
	}
	
	
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@GetMapping("/mypage/scrap")
	public String checkScrap(HttpServletRequest req, 
								@AuthenticationPrincipal MemberSecurityDTO member) {
		
		List<ProductDTO> productDTOs = scrapService.myScraps(member.getUsername());
		req.setAttribute("myScrap", productDTOs);
		
		return "client/mypage/mypage_scarp";
	}
	
}

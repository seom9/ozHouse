package com.oz.ozHouse.client.controller.shopping;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.ProductServiceImpl;
import com.oz.ozHouse.client.service.ScrapService;
import com.oz.ozHouse.dto.ProductDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequiredArgsConstructor
public class ShoppingController {
	
	private final ProductServiceImpl ps;
	private final ScrapService scrapService;
	
	@GetMapping(value = "{proNum}/prodView")
	public String prodView(@AuthenticationPrincipal MemberSecurityDTO member,
								@PathVariable("proNum") int proNum, Model model) {
		
		ProductDTO productDTO = ps.getProduct(proNum);
		
		// 가현 : 스크랩 추가
		productDTO.setScrap(scrapService.isScrap(member.getUsername(), proNum) 
				? true : false);

		model.addAttribute("productDTO", productDTO);
		
		return "client/main/Prodview";
	}
}
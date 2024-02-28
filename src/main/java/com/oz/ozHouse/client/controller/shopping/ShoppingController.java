package com.oz.ozHouse.client.controller.shopping;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.ProductServiceImpl;
import com.oz.ozHouse.client.service.ScrapService;
import com.oz.ozHouse.dto.BlogDTO;
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
		if (member != null) {
			productDTO.setScrap(scrapService.isScrap(member.getUsername(), proNum) 
					? true : false);
		}

		model.addAttribute("productDTO", productDTO);
		
		return "client/main/Prodview";
	}
	
	@GetMapping(value = "products")
	public String goProducts(@AuthenticationPrincipal MemberSecurityDTO member, Model model) {
		
		String memberId = (member != null) ? member.getUsername() : null;

		List<ProductDTO> cliProductList = ps.cliProductList(memberId);
		
		for(ProductDTO dto : cliProductList) {
			String img = dto.getProImg();
			System.out.println(img);
		}

		
		model.addAttribute("product", cliProductList);
		model.addAttribute("spec", "products");
		
		return "client/main/products";
	}
	
	@GetMapping(value = "products/today")
	public String goProductsToday(@AuthenticationPrincipal MemberSecurityDTO member,
								@PathVariable("proNum") int proNum, Model model) {
		
		ProductDTO productDTO = ps.getProduct(proNum);
		
		// 가현 : 스크랩 추가
		if (member != null) {
			productDTO.setScrap(scrapService.isScrap(member.getUsername(), proNum) 
					? true : false);
		}

		model.addAttribute("productDTO", productDTO);
		model.addAttribute("spec", "today");
		
		return "client/main/products";
	}
}
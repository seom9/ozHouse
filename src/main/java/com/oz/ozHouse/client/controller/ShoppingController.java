package com.oz.ozHouse.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oz.ozHouse.client.service.ProductServiceImpl;
import com.oz.ozHouse.dto.ProductDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequiredArgsConstructor
public class ShoppingController {
	
	private final ProductServiceImpl ps;
	
	@GetMapping(value = "{proNum}/prodView")
	public String prodView(@PathVariable("proNum") int proNum, Model model) {
		
		ProductDTO productDTO = ps.getProduct(proNum);
		
		model.addAttribute("productDTO", productDTO);
		
		return "client/main/Prodview";
	}
}
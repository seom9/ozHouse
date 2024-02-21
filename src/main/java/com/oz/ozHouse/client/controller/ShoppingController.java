package com.oz.ozHouse.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oz.ozHouse.dto.ProductDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequiredArgsConstructor
public class ShoppingController {
	
	@GetMapping(value = "${proNum}/prodView")
	public String prodView(HttpServletRequest req, @ModelAttribute ProductDTO dto) {
		
		
		return "";
	}
}
package com.oz.ozHouse.merchant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MerchantController {
	@GetMapping("merchant-main.do")
	public String merchantMain() {
		return "merchant/main/main";
	}
}

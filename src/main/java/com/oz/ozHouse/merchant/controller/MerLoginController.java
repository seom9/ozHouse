package com.oz.ozHouse.merchant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MerLoginController {

	@GetMapping("/merchant_login.do")
	public String login() {
		return "merchant/join/merchant_login";
	}
}

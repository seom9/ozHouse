package com.oz.ozHouse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OzHouseController {
	@RequestMapping("/")
	public String index() {
		System.out.println("바부");
		return "client/main/Main";
	}
}
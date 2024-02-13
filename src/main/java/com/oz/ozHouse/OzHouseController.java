package com.oz.ozHouse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OzHouseController {
	@GetMapping(value = {"/", "/index.do", "/main.do"})
	public String index() {
		return "test2";
	}
}
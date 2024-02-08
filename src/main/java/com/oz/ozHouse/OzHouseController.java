package com.oz.ozHouse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class OzHouseController {
	@GetMapping(value = {"/", "/index", "/main"})
	public String index() {
		return "client/main/Main";
	}
}
package com.oz.ozHouse.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ozMarket/chatt")
public class ChattController {
	//채팅
	@GetMapping("")
	public String ozChat() {
		return "client/ozMarket/chatt";
	}
}

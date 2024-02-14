package com.oz.ozHouse.client.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oz.ozHouse.client.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@Validated
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageRestController {
	
	private final MemberService memberService;

	
	
}

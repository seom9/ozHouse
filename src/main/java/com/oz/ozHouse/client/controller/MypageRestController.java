package com.oz.ozHouse.client.controller;

import java.io.IOException;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.dto.MemberDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@Validated
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageRestController {
	
	private final MemberService memberService;


	
}

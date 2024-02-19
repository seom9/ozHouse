package com.oz.ozHouse.market.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ozMarket")
public class ozMarketController {

	private static final String PATH = "C:\\ozMarket\\";

	// base64 인코딩
	private String encodeImageToBase64(File file) throws IOException {

		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// 파일의 크기만큼 바이트 배열을 생성
			byte[] imageData = new byte[(int) file.length()];

			// 파일 내용을 읽어서 바이트 배열에 저장
			imageInFile.read(imageData);

			// 바이트 배열을 Base64 문자열로 인코딩
			return Base64.getEncoder().encodeToString(imageData);
		}
	}
	
	@GetMapping("") 
	public String ozMarketMain() {
		return "client/ozMarket/ozMarket";
	}

	//물건 팔기 폼
	@GetMapping("/my-product")
	public String ozMarketMyProduct(HttpServletRequest req) {
		return "client/ozMarket/myProduct_input";
	}
	
	//물건 팔기 등록
	@PostMapping("/my-product")
	public String ozMarketMyProduct(@RequestParam("proImgPro") List<MultipartFile> proImgPro, HttpServletRequest req) {
		return "client/ozMarket/myProduct_content";
	}
	
	//상세보기
	@GetMapping("/my-product/{proNum}")
	public String ozMarketContent() {
		return "client/ozMarket/myProduct_content";
	}
	

}

package com.oz.ozHouse.merchant.controller;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oz.ozHouse.merchant.service.MerProService;
import com.oz.ozHouse.domain.Category;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/merchants")
public class MerProController {

	private final MerProService proService;

//	private static final String PATH = "C:\\proImgs";

	// 상품 등록
	@GetMapping("/product-input")
	public String proInput(HttpServletRequest req) {
		req.setAttribute("categories", Category.values());
		return "merchant/store/productManagement/productManagement_input";
	}

	// 상품 등록
	@PostMapping("/product-input")
	public String proInput(@RequestParam("proImg") List<MultipartFile> proImg, 
    		@RequestParam("proImgPro") List<MultipartFile> proImgPro, 
    		MultipartHttpServletRequest multipartRequest, HttpServletRequest req, @ModelAttribute ProductDTO dto, 
    		BindingResult result, @RequestParam Map<String, String> params)
			throws IOException {
		proService.saveProduct(proImg, proImgPro, multipartRequest, req, dto, result, params);
		req.setAttribute("msg", "상품 수정 요청 성공했습니다.");
		req.setAttribute("url", "/merchant/product");
		return "merchant/store/productManagement/productManagement_list";
	}
	
	//상품 상세보기
	@GetMapping("/product")
	public String productContent() {
		return "merchant/store/productManagement/productManagement_content";
	}

	// 상품 조회
	@GetMapping("/products")
	public String productList() {
		return "merchant/store/productManagement/productManagement_list";
	}

	// 요청 리스트
	@GetMapping("/product/request")
	public String productRequest() {
		return "merchant/store/productManagement/productManagement_request_list";
	}

	// 재고 관리
	@GetMapping("/product/stock")
	public String productStock() {
		return "merchant/store/productManagement/productManagement_stock";
	}
}

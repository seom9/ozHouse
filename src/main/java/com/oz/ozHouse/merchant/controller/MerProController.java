package com.oz.ozHouse.merchant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.oz.ozHouse.merchant.service.MerProService;
import com.oz.ozHouse.domain.Category;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/merchants")
public class MerProController {

	private final MerProService proService;
	
	//상품 등록
	@GetMapping("/product-input")
	public String proInput(HttpServletRequest req) {
		req.setAttribute("categories", Category.values()); 
		return "merchant/store/productManagement/productManagement_input";
	}
	
	//상품 조회
	@GetMapping("/products")
	public String productList() {
		return "merchant/store/productManagement/productManagement_list";
	}
	
	//요청 리스트
	@GetMapping("/product/request")
	public String productRequest() {
		return "merchant/store/productManagement/productManagement_request_list";
	}
	
	//재고 관리
	@GetMapping("/product/stock")
	public String productStock() {
		return "merchant/store/productManagement/productManagement_stock";
	}
	
}

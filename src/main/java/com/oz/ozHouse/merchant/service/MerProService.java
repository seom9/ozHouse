package com.oz.ozHouse.merchant.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;

import jakarta.servlet.http.HttpServletRequest;

public interface MerProService {
	
	
//	public String saveProduct(@RequestParam("proImg") List<MultipartFile> proImg, 
//    		@RequestParam("proImgPro") List<MultipartFile> proImgPro,
//    		MultipartHttpServletRequest multipartRequest, HttpServletRequest req, @ModelAttribute ProductDTO dto, 
//    		BindingResult result, @RequestParam Map<String, String> params) throws IOException;
//	
	
//	int saveProduct(ProductDTO productDTO);
	
	void insertProduct(ProductDTO productDTO);
}

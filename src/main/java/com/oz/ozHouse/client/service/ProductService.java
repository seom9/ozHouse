package com.oz.ozHouse.client.service;

import java.util.List;

import com.oz.ozHouse.dto.ProductDTO;

public interface ProductService {
	
	List<ProductDTO> cliProductList(String memberId);
	
	ProductDTO getProduct(Integer proNum);
	
	List<ProductDTO> todayProductList(String memberId);
	
	List<ProductDTO> bestProduct(String memberId);
}

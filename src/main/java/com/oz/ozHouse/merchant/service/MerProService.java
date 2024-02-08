package com.oz.ozHouse.merchant.service;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.dto.ProductDTO;

@Service
public interface MerProService {
	
	public String insertProduct(ProductDTO dto);

}

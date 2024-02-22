package com.oz.ozHouse.client.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.ProductRepository;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.merchant.repository.MerProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
	
	private final ProductService productService;
	
	public ProductDTO getProduct(int productNum) {
		return productService.getProduct(productNum);
	}
	
}

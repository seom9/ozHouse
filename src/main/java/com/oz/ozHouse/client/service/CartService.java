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
	
	private final MerProductRepository productRepository;
	
	public ProductDTO getProduct(Integer productNum) {
		Optional<ProductDTO> result = productRepository.findByProNum(productNum);
		if (result.isEmpty()) return null;
		return result.get();
	}
	
}

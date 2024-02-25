package com.oz.ozHouse.client.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.ProductRepository;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.dto.client.member.ClientProductDTO;
import com.oz.ozHouse.merchant.repository.MerProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
	
	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;
	
	public ClientProductDTO getProduct(int productNum) {
		ClientProductDTO productDTO = new ClientProductDTO();
		Optional<Product> result = productRepository.findById(productNum);
		if (result.isPresent()) {
			Product product = result.get();
			productDTO = ClientProductDTO.from(product);
		}
		return productDTO;
	}
	
}

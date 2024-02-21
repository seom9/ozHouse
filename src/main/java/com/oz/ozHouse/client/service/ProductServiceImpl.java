package com.oz.ozHouse.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.ProductRepository;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService{
	
	private final ProductRepository productRepository;
	
	@Override
	public List<ProductDTO> cliProductList() {
		List<ProductDTO> dto = productRepository.findAll();
	}

	@Override
	public int cliProdView(int proNum) {
		// TODO Auto-generated method stub
		return 0;
	}
}

package com.oz.ozHouse.client.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
	
	private final ModelMapper modelMapper;
	private final ProductRepository productRepository;
	
	@Override
	public List<ProductDTO> cliProductList() {
		List<Product> productList = productRepository.findAll();
		
		List<ProductDTO> proList = productList.stream()
									.map(data -> modelMapper.map(data, ProductDTO.class))
									.collect(Collectors.toList());
		
		return proList;
	}

	@Override
	public int cliProdView(int proNum) {
		// TODO Auto-generated method stub
		return 0;
	}
}

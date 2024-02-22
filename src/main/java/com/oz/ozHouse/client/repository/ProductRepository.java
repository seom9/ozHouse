package com.oz.ozHouse.client.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;

public interface ProductRepository extends Repository<Product, Integer> {
	
	// 전체 상품 목록
	List<Product> findAll();
	
	// 상품 상세보기
	Optional<ProductDTO> findByProNum(Integer proNum);
}

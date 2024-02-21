package com.oz.ozHouse.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oz.ozHouse.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	// 전체 상품 목록
	List<Product> findAll(); 
	
}

package com.oz.ozHouse.merchant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.oz.ozHouse.domain.Product;

@NoRepositoryBean
public interface MerProductRepository extends JpaRepository<Product, Integer> {
	
	//전체 상품 현황
	Long allCount();
	
}

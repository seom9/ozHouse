package com.oz.ozHouse.merchant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;

@NoRepositoryBean
public interface MerProductRepository extends Repository<Product, Integer> {
	
	//전체 상품 현황
	Long allCount();
	
	//상품 등록
	Product save(Product product);
	
	//재고 리스트
	List<ProductDTO> stockList();
	
	//재고 리스트 건수
	Long stockListCount();
	
	//재고 수정
	Optional<Product> findByProNum(Integer proNum);
	
}

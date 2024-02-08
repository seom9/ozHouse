package com.oz.ozHouse.merchant.repository;


import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.oz.ozHouse.domain.Product;
//import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.dto.ProductDTO;

@NoRepositoryBean
public interface MerProductRepository extends CrudRepository<Product, Integer> {
	
	//전체 상품 현황
	Long allCount();

	void save(ProductDTO productDTO);
	
//	//승인대기
//	int waitCount();
//	
//	//승인보류
//	int requestCount();
//	
//	//승인 반려
//	int cancleCount();
//	
//	//요청 취소
//	int requestCancle();
//	
//	//판매중
//	int saleOk();
	
//	int boardCount();
	
//	//상품 등록
//	int insertProduct(Product product);

//	public void insertProduct(ProductDTO productDTO);
//	void saveProduct(Product product);

}

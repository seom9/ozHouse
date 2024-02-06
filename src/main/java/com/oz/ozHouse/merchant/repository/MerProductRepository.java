package com.oz.ozHouse.merchant.repository;


import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.oz.ozHouse.domain.Product;

@NoRepositoryBean
public interface MerProductRepository extends Repository<Product, Integer> {
	
	//전체 상품 현황
	Long allCount();
	
	//승인대기
	int waitCount();
	
	//승인보류
	int requestCount();
	
	//승인 반려
	int cancleCount();
	
	//요청 취소
	int requestCancle();
	
	//판매중
	int saleOk();
	
//	int boardCount();
	
}

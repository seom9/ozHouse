package com.oz.ozHouse.merchant.repository;

import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Product;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor 
public class MerProductRepositoryImpl implements MerProductRepository{

	private final EntityManager em;
	
	//전체 상품 현황
	@Override
	public Long allCount() {
		return em.createQuery("SELECT COUNT(p) FROM Product p", Long.class)
	             .getSingleResult();
	}

	//승인 대기
	@Override
	public int waitCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	//승인 보류
	@Override
	public int requestCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//승인 반려
	@Override
	public int cancleCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	//요청 취소
	@Override
	public int requestCancle() {
		// TODO Auto-generated method stub
		return 0;
	}

	//판매중
	@Override
	public int saleOk() {
		// TODO Auto-generated method stub
		return 0;
	}

}

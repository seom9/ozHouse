package com.oz.ozHouse.merchant.service;


import org.springframework.stereotype.Service;

import com.oz.ozHouse.merchant.repository.MerProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreManageServiceImpl implements StoreManageService{

	private final MerProductRepository productRepository;
	
	//전체 상품 현황
	@Override
	public Long allCount(Integer merNum) {
		return productRepository.allCount(merNum);
	}

	//승인 대기 현황
	@Override
	public Long waitCount(Integer merNum) {
		return productRepository.waitCount(merNum);
	}

	//승인 보류 현황
	@Override
	public Long requestCount(Integer merNum) {
		return productRepository.requestCount(merNum);
	}

	//승인 반려 현황
	@Override
	public Long cancleCount(Integer merNum) {
		return productRepository.cancleCount(merNum);
	}

	//요청 취소 현황
	@Override
	public Long requestCancle(Integer merNum) {
		return productRepository.requestCancle(merNum);
	}

	//판매중 현황
	@Override
	public Long saleOk(Integer merNum) {
		return productRepository.saleOk(merNum);
	}
}

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
	public Long allCount() {
		return productRepository.allCount();
	}

	@Override
	public int waitCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int requestCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cancleCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int requestCancle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saleOk() {
		// TODO Auto-generated method stub
		return 0;
	}
//
//	@Override
//	public int waitCount() {
//		return productRepository.waitCount();
//	}
//
//	@Override
//	public int requestCount() {
//		return productRepository.requestCount();
//	}
//
//	@Override
//	public int cancleCount() {
//		return productRepository.cancleCount();
//	}
//
//	@Override
//	public int requestCancle() {
//		return productRepository.requestCancle();
//	}
//
//	@Override
//	public int saleOk() {
//		return productRepository.saleOk();
//	}

}

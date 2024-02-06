package com.oz.ozHouse.merchant.service;


public interface StoreManageService {
	//전체 상품 현황
	public Long allCount();
	
	//승인대기
	public int waitCount();
	
	//승인보류
	public int requestCount();
	
	//승인 반려
	public int cancleCount();
	
	//요청 취소
	public int requestCancle();
	
	//판매중
	public int saleOk();
}

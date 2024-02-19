package com.oz.ozHouse.merchant.service;


public interface StoreManageService {
	//전체 상품 현황
	public Long allCount(Integer merNum);
	
	//승인 대기 현황
	public Long waitCount(Integer merNum);
	
	//승인 보류 현황
	public Long requestCount(Integer merNum);
	
	//승인 반려 현황
	public Long cancleCount(Integer merNum);
	
	//요청 취소 현황
	public Long requestCancle(Integer merNum);
	
	//판매중 현황
	public Long saleOk(Integer merNum);
}

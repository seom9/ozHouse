package com.oz.ozHouse.merchant.service;

import java.util.Map;

import com.oz.ozHouse.dto.InbrandDTO;
import com.oz.ozHouse.merchant.Exception.NotFoundMerNumException;

public interface MerInbrandService {

	//판매자 번호로 입점신청여부 확인
	public InbrandDTO selectMer(int num);
	
	//판매자 번호로 사업자번호 조회
	public boolean searchComNum(int merNum, Map<String, String> map) throws NotFoundMerNumException;
	
	public void deleteInbrand(int inNum);
	
	public int application(InbrandDTO dto);
}

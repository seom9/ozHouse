package com.oz.ozHouse.merchant.service;

import java.util.Map;

import com.oz.ozHouse.dto.ApplicationDTO;
import com.oz.ozHouse.dto.InbrandDTO;
import com.oz.ozHouse.merchant.exception.NotFoundMerNumException;

public interface MerInbrandService {

	//판매자 번호로 입점신청여부 확인
	public InbrandDTO selectMer(int merNum);
	
	//판매자 번호로 사업자번호 조회
	public boolean searchComNum(int merNum, Map<String, String> map) throws NotFoundMerNumException;
	
	//재신청시 입점신청번호로 신청내역 삭제
	public void deleteInbrand(int inNum);
	
	//신청내역 DB 추가
	public int application(InbrandDTO dto);
	
	//입점신청내역 조회
	public ApplicationDTO applicationList(int merNum);
	
	//입점신청 취소
	public int brandCancel(int inNum);
}

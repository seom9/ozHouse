package com.oz.ozHouse.merchant.service;

import java.util.Map;

import com.oz.ozHouse.dto.MerchantDTO;

public interface MerJoinService {
	//사업자등록번호 조회
	public boolean merchant_checkBsNum(Map<String, String> comNum);
	//Email 조회
	public boolean merchant_checkEmail(String email);
	//ID 중복 조회
	public MerchantDTO merchant_checkMerId(String id);
}

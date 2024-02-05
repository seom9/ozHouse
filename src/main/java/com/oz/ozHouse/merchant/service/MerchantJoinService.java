package com.oz.ozHouse.merchant.service;

import java.util.Map;

public interface MerchantJoinService {
	
	//사업자등록번호 중복 확인
	public boolean merchant_checkBsNum(Map<String, String> comNum);
	
	//판매자 Email 중복 확인
	public boolean merchant_checkEmail(String email);

}

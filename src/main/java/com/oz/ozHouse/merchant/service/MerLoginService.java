package com.oz.ozHouse.merchant.service;

import com.oz.ozHouse.dto.MerchantDTO;

public interface MerLoginService {

	public MerchantDTO merchant_getMember(String mer_id);
	
	public String checkMerchantIdEmail(String mer_email);
	
	public int updatePass(String merPw, String merId);
}

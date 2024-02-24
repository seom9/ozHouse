package com.oz.ozHouse.merchant.repository.merchantRepository;


import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;

public interface MerchantRepositoryCustom{
	// ID로 판매자 조회
	public MerchantDTO findMerchantId(String id);
	
	public Merchant findMerchantEmail(String mer_email);
	
}

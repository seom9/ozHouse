package com.oz.ozHouse.merchant.repository.joinRepository;


import com.oz.ozHouse.dto.MerchantDTO;

public interface MerJoinRepositoryCustom{
	// ID로 판매자 조회
	public MerchantDTO findMerchantId(String id);

}

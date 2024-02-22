package com.oz.ozHouse.merchant.service;

import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.dto.MerchantUpdateDTO;
import com.oz.ozHouse.merchant.exception.NotFoundMerNumException;

public interface MerMyInformService {

	public MerchantDTO myInformView(int merNum) throws NotFoundMerNumException;
	
	public String updateMerchant(MerchantUpdateDTO dto);
}

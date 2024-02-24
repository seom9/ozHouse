package com.oz.ozHouse.merchant.service;

import java.util.List;

import com.oz.ozHouse.dto.InsertMerCouponDTO;
import com.oz.ozHouse.dto.MerCouponDTO;

public interface MerCouponService {

	public int merCouponInsert(InsertMerCouponDTO dto);
	
	public List<MerCouponDTO> searchCouponList(int merNum);
	
	public int merCouponDelete(int merCouponnum);
}

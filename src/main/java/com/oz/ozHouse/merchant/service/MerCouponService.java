package com.oz.ozHouse.merchant.service;

import java.util.List;
import java.util.Map;

import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.dto.merchant.CouponSearchDTO;
import com.oz.ozHouse.dto.merchant.InsertMerCouponDTO;

public interface MerCouponService {

	public int merCouponInsert(InsertMerCouponDTO dto);
	
	public List<MerCouponDTO> couponList(int merNum);
	
	public List<MerCouponDTO> searchCouponList(Map<String, String> map);
	
	public int merCouponDelete(int merCouponnum);
}

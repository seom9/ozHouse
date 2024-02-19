package com.oz.ozHouse.client.service;

import java.util.List;

import com.oz.ozHouse.dto.MerCouponDTO;

public interface CouponService {
	
	List<MerCouponDTO> getAllCoupons();
	
	List<MerCouponDTO> getUserCoupons(String memberId);
	
	void addCoupon(String memberId, int merCouponnum);
}

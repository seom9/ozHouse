package com.oz.ozHouse.client.service;

import java.util.List;

import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.dto.UserCouponDTO;

public interface CouponService {
	
	List<MerCouponDTO> getAllCoupons();
	
	List<MerCouponDTO> getUserCoupons(String memberId);
	
	boolean addCoupon(String memberId, int merCouponnum);
	
}

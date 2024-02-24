package com.oz.ozHouse.client.service;

import java.util.HashSet;
import java.util.List;

import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.dto.client.member.ProQuanDTO;

public interface CouponService {
	
	List<MerCouponDTO> getAllCoupons();
	
	List<MerCouponDTO> getUserCoupons(String memberId);
	
	boolean addCoupon(String memberId, int merCouponnum);
	
	HashSet<MerCouponDTO> getOrderCoupons(String memberId, List<ProQuanDTO> products);
	
}

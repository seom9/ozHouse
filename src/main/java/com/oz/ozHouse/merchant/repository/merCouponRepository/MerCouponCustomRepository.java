package com.oz.ozHouse.merchant.repository.merCouponRepository;

import java.util.List;
import java.util.Map;

import com.oz.ozHouse.domain.MerCoupon;
import com.oz.ozHouse.dto.merchant.CouponSearchDTO;

public interface MerCouponCustomRepository {

	public int merCouponDelete(int merCouponnum);
	
	public List<MerCoupon> searchCouponList(Map<String, String> map);
//	public List<MerCoupon> searchCouponList(CouponSearchDTO dto);
}

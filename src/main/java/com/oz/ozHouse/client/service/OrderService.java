package com.oz.ozHouse.client.service;

import java.util.List;
import java.util.Optional;

import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.domain.ProInform;
import com.oz.ozHouse.domain.UserCoupon;
import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.dto.client.member.ClientOrderConfirmDTO;
import com.oz.ozHouse.dto.client.member.ClientOrderDTO;
import com.oz.ozHouse.dto.client.member.ClientOrderListDTO;
import com.oz.ozHouse.dto.client.member.ProQuanDTO;

public interface OrderService {

	OrderTb order(ClientOrderDTO dto, String memberId, List<ProQuanDTO> orderProducts, List<String> selectedCoupons);
	
	OrderTb getOrder(long ONum);
	
	// proInforms를 DTO 로
	List<ProQuanDTO> getProQuanDTO(List<ProInform> proInforms);
	
	// userCoupons 를 DTO 로
	List<MerCouponDTO> getMerCouponDTO(List<UserCoupon> useCoupons);
	
	OrderTb getOrderWithCoupons(long ONum);
	
	OrderTb getOrderWithItems(long ONum);
	
	List<ClientOrderListDTO> getMemberWithOrder(String memberId);
	
	void cancelOrder(int memberNum, long oNum);
}

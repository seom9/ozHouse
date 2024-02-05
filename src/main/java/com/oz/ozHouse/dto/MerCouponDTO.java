package com.oz.ozHouse.dto;

import java.time.LocalDateTime;

import com.oz.ozHouse.domain.MerCoupon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MerCouponDTO {
	
	private int merCouponnum;
	private String merCouponname;
	private String merIsok;
	private int merCoupondiscount;
	private int merNum;
	private LocalDateTime merCouponusedate;
	private LocalDateTime merCouponenddate;
	
	public MerCouponDTO toDto(MerCoupon m) {
	    return MerCouponDTO.builder()
	            .merCouponnum(m.getMerCouponnum())
	            .merCouponname(m.getMerCouponname())
	            .merIsok(m.getMerIsok())
	            .merCoupondiscount(m.getMerCoupondiscount())
	            .merNum(m.getMerNum())
	            .merCouponusedate(m.getMerCouponusedate())
	            .merCouponenddate(m.getMerCouponenddate())
	            .build();
	}
}

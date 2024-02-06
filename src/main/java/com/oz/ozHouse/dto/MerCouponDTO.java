package com.oz.ozHouse.dto;

import java.time.LocalDate;

import com.oz.ozHouse.domain.MerCoupon;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MerCouponDTO {
	
	private int merCouponnum;
	private String merCouponname;
	private String merIsok;
	private int merCoupondiscount;
	private int merNum;
	private LocalDate merCouponusedate;
	private LocalDate merCouponenddate;
	
}

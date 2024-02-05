package com.oz.ozHouse.dto;

import java.sql.Date;

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
	private Date merCouponusedate;
	private Date merCouponenddate;
	
}

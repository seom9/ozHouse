package com.oz.ozHouse.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class InsertMerCouponDTO {
	private int merCouponnum;
	private int merNum;
	private String merCouponname;
	private int merCoupondiscount;
	private String merCouponusedate;
	private String merCouponenddate;

}


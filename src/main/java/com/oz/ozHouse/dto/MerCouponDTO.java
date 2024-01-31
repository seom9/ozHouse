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
	
	public MerCoupon toEntity() {
		MerCoupon merCoupon = new MerCoupon();

		// Set the properties of the new Mer_Coupon instance based on the values of the current object
		merCoupon.setMerCouponnum(this.merCouponnum);
		merCoupon.setMerCouponname(this.merCouponname);
		merCoupon.setMerIsok(this.merIsok);
		merCoupon.setMerCoupondiscount(this.merCoupondiscount);
		merCoupon.setMerNum(this.merNum);
		merCoupon.setMerCouponusedate(this.merCouponusedate);
		merCoupon.setMerCouponenddate(this.merCouponenddate);

		// Return the new Mer_Coupon instance with its properties set
		return merCoupon;
	}
}

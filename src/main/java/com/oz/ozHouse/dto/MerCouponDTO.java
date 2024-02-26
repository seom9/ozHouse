package com.oz.ozHouse.dto;

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
	private int merNum;
	private String merCouponname;
	private String merIsok;
	private int merCoupondiscount;
	private String merCouponusedate;
	private String merCouponenddate;
	
	
    public static MerCouponDTO from(MerCoupon merCoupon) {
    	if (merCoupon == null) return null;
    	
        return MerCouponDTO.builder()
        		.merCouponnum(merCoupon.getMerCouponnum())
        		.merNum(merCoupon.getMerNum().getMerNum())
        		.merCouponname(merCoupon.getMerCouponname())
        		.merIsok(merCoupon.getMerIsok())
        		.merCoupondiscount(merCoupon.getMerCoupondiscount())
        		.merCouponusedate(merCoupon.getMerCouponusedate())
        		.merCouponenddate(merCoupon.getMerCouponenddate())
                .build();
    }

}

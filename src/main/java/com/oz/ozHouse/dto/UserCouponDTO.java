package com.oz.ozHouse.dto;

import java.sql.Date;

import com.oz.ozHouse.domain.MerCoupon;
import com.oz.ozHouse.domain.UserCoupon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCouponDTO {
	private int userCouponNum;
	private int merCouponNum;
	private int memberNum;
	private int merNum;
	private long oCode;
	
    public static UserCouponDTO from(UserCoupon userCoupon) {
        if (userCoupon == null) return null;
        if (userCoupon.getOrderTb() != null) return null; 
        
        return UserCouponDTO.builder()
                .userCouponNum(userCoupon.getUserCouponNum())
                .merCouponNum(userCoupon.getMerCoupon().getMerCouponnum())
                .memberNum(userCoupon.getMember().getMemberNum())
                .merNum(userCoupon.getMerCoupon().getMerNum().getMerNum())
                .build();
    }
}

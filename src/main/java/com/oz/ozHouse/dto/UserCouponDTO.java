package com.oz.ozHouse.dto;

import java.sql.Date;

import com.oz.ozHouse.domain.UserCoupon;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCouponDTO {
	private int userCouponNum;
	private int merCouponNum;
	private int memberNum;
	private int merNum;
	private String userCouponActive;
	private Date merCouponEndDate;
	private long orderCode;
	
    public UserCoupon toEntity() {
        UserCoupon userCoupon = new UserCoupon();
        userCoupon.setUserCouponNum(this.userCouponNum);
        userCoupon.setMerCouponNum(this.merCouponNum);
        userCoupon.setMemberNum(this.memberNum);
        userCoupon.setMerNum(this.merNum);
        userCoupon.setUserCouponActive(this.userCouponActive);
        userCoupon.setMerCouponEndDate(this.merCouponEndDate);
        userCoupon.setOrderCode(this.orderCode);

        return userCoupon;
    }
}

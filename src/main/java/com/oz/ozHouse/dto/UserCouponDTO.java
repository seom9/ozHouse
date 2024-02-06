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
}

package com.oz.ozHouse.dto;

import java.time.LocalDate;

import com.oz.ozHouse.domain.MerCoupon;
import com.oz.ozHouse.dto.client.member.MemberPasswdUpdateDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	
}

package com.oz.ozHouse.dto.merchant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CouponSearchDTO {
	private String merNum;
	private String startDate;
	private String endDate;
	private String date;
	private String merIsok;
	private String search;
	private String searchString;
}

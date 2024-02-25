package com.oz.ozHouse.dto.merchant;

import java.util.List;

import com.oz.ozHouse.domain.Category;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApplicationDTO {

	private int inNum;
	private int merNum;
	private String merIsbrand;
	private String inCompany;
	private String inComnum1;
	private String inComnum2;
	private String inComnum3;
	private String inHomepage;
	private String inManname;
	private String inManhp1;
	private String inManhp2;
	private String inManhp3;
	private String inManemail;
	private List<Category> inCategory;
	private String inOthershop;
	private String inSaleFile;
	private String inAppliDate;
	private String inCancelDate;
	
}

package com.oz.ozHouse.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApplicationDTO {

	private int inNum;
	private int merNum;
	private String categoryNum;
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
	private String inCategory;
	private String inOthershop;
	private String inFile;
	private Date inAppliDate;
	private Date inCancelDate;
	
}

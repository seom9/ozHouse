package com.oz.ozHouse.dto;

import java.time.LocalDateTime;

import com.oz.ozHouse.domain.Inbrand;
import com.oz.ozHouse.domain.Member;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InbrandDTO {
	private int inNum;
	private int merNum;
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
	private String inSaleFile;
<<<<<<< HEAD
	private Date inAppliDate;
	private Date inCancelDate;
=======
	private LocalDateTime inAppliDate;
	private LocalDateTime inCancelDate;
	
	
>>>>>>> 9cf53a3acda31e05970035d8de8ccdc963c6fdfd
}

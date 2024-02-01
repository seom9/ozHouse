package com.oz.ozHouse.dto;

import java.sql.Date;

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
	private String inSalefile;
	private Date inAppliDate;
	private Date inCancelDate;
	
	public Inbrand toEntity() {
		Inbrand inbrand = new Inbrand();
		inbrand.setInNum(this.inNum);
		inbrand.setMerNum(this.merNum);
		inbrand.setInCompany(this.inCompany);
		inbrand.setInComnum1(this.inComnum1);
		inbrand.setInComnum2(this.inComnum2);
		inbrand.setInComnum3(this.inComnum3);
		inbrand.setInHomepage(this.inHomepage);
		inbrand.setInManname(this.inManname);
		inbrand.setInManhp1(this.inManhp1);
		inbrand.setInManhp2(this.inManhp2);
		inbrand.setInManhp3(this.inManhp3);
		inbrand.setInManemail(this.inManemail);
		inbrand.setInCategory(this.inCategory);
		inbrand.setInOthershop(this.inOthershop);
		inbrand.setInSalefile(this.inSalefile);
		inbrand.setInAppliDate(this.inAppliDate);
		inbrand.setInCancelDate(this.inCancelDate);

		return inbrand;
	}
	
}

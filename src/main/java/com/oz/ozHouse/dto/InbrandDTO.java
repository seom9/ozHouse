package com.oz.ozHouse.dto;

import java.time.LocalDateTime;

import com.oz.ozHouse.domain.Inbrand;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
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
	private LocalDateTime inAppliDate;
	private LocalDateTime inCancelDate;
	
	public InbrandDTO toDto(Inbrand i) {
	    return InbrandDTO.builder()
	            .inNum(i.getInNum())
	            .merNum(i.getMerNum())
	            .inCompany(i.getInCompany())
	            .inComnum1(i.getInComnum().getMerComnum1())
	            .inComnum2(i.getInComnum().getMerComnum2())
	            .inComnum3(i.getInComnum().getMerComnum3())
	            .inHomepage(i.getInbrandInfo().getHomepage())
	            .inManname(i.getInbrandInfo().getManagerName())
	            .inManhp1(i.getInbrandInfo().getPhoneNum().getPhoneNumber1())
	            .inManhp2(i.getInbrandInfo().getPhoneNum().getPhoneNumber2())
	            .inManhp3(i.getInbrandInfo().getPhoneNum().getPhoneNumber3())
	            .inManemail(i.getInbrandInfo().getManagerEmail())
	            .inCategory(i.getInbrandInfo().getCategory())
	            .inOthershop(i.getInbrandInfo().getOtherShop())
	            .inSaleFile(i.getInbrandInfo().getBrandFile())
	            .inAppliDate(i.getRegDate())
	            .inCancelDate(i.getInCancelDate())
	            .build();
	}
}

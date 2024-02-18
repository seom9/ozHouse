package com.oz.ozHouse.dto;

import java.util.List;

import com.oz.ozHouse.domain.Category;
import com.oz.ozHouse.domain.Inbrand;
import com.oz.ozHouse.domain.Merchant;

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
	private List<Category> inCategory;
	private String inOthershop;
	private String inSaleFile;
	private String inAppliDate;
	private String inCancelDate;
	
	
	public InbrandDTO toDto(Inbrand inbrand) {
		Merchant merchant = inbrand.getMerchant(); // Merchant 객체 가져오기
        int merNum = merchant.getMerNum(); // Merchant 객체의 id 가져오기
        return InbrandDTO.builder()
        		.inNum(inbrand.getInNum())
                .merNum(merNum)
                .inCompany(inbrand.getInCompany())
                .inComnum1(inbrand.getInComnum().getMerComnum1())
                .inComnum2(inbrand.getInComnum().getMerComnum2())
                .inComnum3(inbrand.getInComnum().getMerComnum3())
                .inHomepage(inbrand.getInbrandInfo().getHomepage())
                .inManname(inbrand.getInbrandInfo().getManagerName())
                .inManhp1(inbrand.getInbrandInfo().getPhoneNum().getPhoneNumber1())
                .inManhp2(inbrand.getInbrandInfo().getPhoneNum().getPhoneNumber2())
                .inManhp3(inbrand.getInbrandInfo().getPhoneNum().getPhoneNumber3())
                .inManemail(inbrand.getInbrandInfo().getManagerEmail())
                .inCategory(inbrand.getInbrandInfo().getCategory())
                .inOthershop(inbrand.getInbrandInfo().getOtherShop())
                .inSaleFile(inbrand.getInbrandInfo().getBrandFile())
                .inAppliDate(inbrand.getRegDate())
                .inCancelDate(inbrand.getInCancelDate())
                .build();
    }


	public void setInSaleFile(String inSaleFile) {
		this.inSaleFile = inSaleFile;
	}
}

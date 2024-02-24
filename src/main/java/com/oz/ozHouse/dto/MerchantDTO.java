package com.oz.ozHouse.dto;


import java.util.List;

import com.oz.ozHouse.domain.Category;
import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.common.CompanyNumber;
import com.oz.ozHouse.domain.common.PhoneNumber;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor   //기본생성자 자동으로 생성
public class MerchantDTO {

    private int merNum;
    private String merId;
    private String merPw;
    private String merIsbrand;
    private String merCompany;
    
    //CompanyNumber merComnum
    private String merComnum1;
    private String merComnum2;
    private String merComnum3;
    
    //PhoneNumber merHp
    private String merHp1;
    private String merHp2;
    private String merHp3;
    
    //Inbrand inbrand
    private String merHomepage;
    private String merManname;
    private String merManhp1;
    private String merManhp2;
    private String merManhp3;
    private String merManemail;
    private List<Category> merCategory;
    private String merOthershop;
    private String merFile;
    
    private String merJoindate;
    private String merInbranddate;
    private String merDeletedate;
    private String merOutDate;
    private String merDelete;
    private String merAdress;
    private String merRegistration;
    private String merName;
    private String merEmail;
    private String merBusinessPost;
    
    public void setMer_business_adress(String merAdress) {
		this.merAdress = merAdress;
	}
    
    
    public MerchantDTO toDto(Merchant merchant) {
        return MerchantDTO.builder()
                .merNum(merchant.getMerNum())
                .merId(merchant.getMerId())
                .merPw(merchant.getMerPw())
                .merIsbrand(merchant.getMerIsbrand())
                .merCompany(merchant.getMerCompany())
                .merComnum1(merchant.getMerComnum().getMerComnum1())
                .merComnum2(merchant.getMerComnum().getMerComnum2())
                .merComnum3(merchant.getMerComnum().getMerComnum3())
                .merHp1(merchant.getMerHp().getPhoneNumber1())
                .merHp2(merchant.getMerHp().getPhoneNumber2())
                .merHp3(merchant.getMerHp().getPhoneNumber3())
                .merJoindate(merchant.getMerJoindate())
                .merInbranddate(merchant.getMerInbranddate())
                .merDeletedate(merchant.getMerDeletedate())
                .merOutDate(merchant.getMerOutDate())
                .merDelete(merchant.getMerDelete())
                .merAdress(merchant.getMerAdress())
                .merRegistration(merchant.getMerRegistration())
                .merName(merchant.getMerName())
                .merEmail(merchant.getMerEmail())
                .merBusinessPost(merchant.getMerBusinessPost())
                .build();
    }
    
    public MerchantDTO(HttpServletRequest req) {
    	this.merId = req.getParameter("merId");
    	this.merPw = req.getParameter("merPw");
    	this.merCompany = req.getParameter("merCompany");
    	this.merComnum1 = req.getParameter("merComnum1");
    	this.merComnum2 = req.getParameter("merComnum2");
    	this.merComnum3 = req.getParameter("merComnum3");
    	this.merHp1 = req.getParameter("merHp1");
    	this.merHp2 = req.getParameter("merHp2");
    	this.merHp3 = req.getParameter("merHp3");
    	this.merRegistration = req.getParameter("merRegistration");
    	this.merName = req.getParameter("merName");
    	this.merEmail = req.getParameter("merEmail");
    	this.merBusinessPost = req.getParameter("merBusinessPost");
    	this.merAdress = req.getParameter("sample6_address")
    			 + "/" + req.getParameter("sample6_detailAddress")
    			 + "/" + req.getParameter("sample6_extraAddress");
    }

	public void setMerRegistration(String merRegistration) {
		this.merRegistration = merRegistration;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}

	public void setMerPw(String merPw) {
		this.merPw = merPw;
	}

}
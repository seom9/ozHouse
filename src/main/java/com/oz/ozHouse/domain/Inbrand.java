package com.oz.ozHouse.domain;


import com.oz.ozHouse.domain.common.BaseEntity;
import com.oz.ozHouse.domain.common.CompanyNumber;
import com.oz.ozHouse.domain.common.InbrandInfo;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "regDate", column = @Column(name = "inAppliDate"))
public class Inbrand extends BaseEntity{

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inNum;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "merNum")
	private Merchant merchant;
	
	private String inCompany;
	
	@Embedded
    @AttributeOverrides({
    		@AttributeOverride(name = "merComnum1", column = @Column(name = "inComnum1")),
    		@AttributeOverride(name = "merComnum2", column = @Column(name = "inComnum2")),
    		@AttributeOverride(name = "merComnum3", column = @Column(name = "inComnum3"))
    })
	private CompanyNumber inComnum;
	
	@Embedded
	@AttributeOverrides({
    	@AttributeOverride(name = "homepage", column = @Column(name = "inHomepage")),
    	@AttributeOverride(name = "ManagerName", column = @Column(name = "inManname")),
    	@AttributeOverride(name = "ManagerEmail", column = @Column(name = "inManemail")),
    	@AttributeOverride(name = "category", column = @Column(name = "inCategory")),
    	@AttributeOverride(name = "otherShop", column = @Column(name = "inOthershop")),
    	@AttributeOverride(name = "brandFile", column = @Column(name = "inSaleFile")),
		@AttributeOverride(name = "phoneNum.phoneNumber1", column = @Column(name = "inManhp1")),
		@AttributeOverride(name = "phoneNum.phoneNumber2", column = @Column(name = "inManhp2")),
		@AttributeOverride(name = "phoneNum.phoneNumber3", column = @Column(name = "inManhp3"))
    })
	private InbrandInfo inbrandInfo;
	
	private String inCancelDate;
	
	
}
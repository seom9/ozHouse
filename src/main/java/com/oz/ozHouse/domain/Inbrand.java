package com.oz.ozHouse.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.common.BaseEntity;
import com.oz.ozHouse.domain.common.CompanyNumber;
import com.oz.ozHouse.domain.common.InbrandInfo;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AttributeOverride(name = "regDate", column = @Column(name = "inAppliDate"))
public class Inbrand extends BaseEntity{

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inNum;
	private int merNum;
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
		@AttributeOverride(name = "PhoneNumber.phoneNumber1", column = @Column(name = "inManhp1")),
		@AttributeOverride(name = "PhoneNumber.phoneNumber2", column = @Column(name = "inManhp2")),
		@AttributeOverride(name = "PhoneNumber.PhoneNumber3", column = @Column(name = "inManhp3"))
    })
	private InbrandInfo inbrandInfo;
	
	@DateTimeFormat(pattern = "yy/MM/dd")
	private LocalDate inCancelDate;
	
}
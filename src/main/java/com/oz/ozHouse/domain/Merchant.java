package com.oz.ozHouse.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.common.BaseEntity;
import com.oz.ozHouse.domain.common.CompanyNumber;
import com.oz.ozHouse.domain.common.InbrandInfo;
import com.oz.ozHouse.domain.common.PhoneNumber;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "regDate", column = @Column(name = "merJoindate"))
public class Merchant extends BaseEntity{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int merNum;
	
    private String merId;
    
    private String merPw;
    
    private String merIsbrand;
    
    private String merCompany;
    
    @Embedded
    private CompanyNumber merComnum;
    
    @Embedded
    @AttributeOverrides({
    		@AttributeOverride(name = "phoneNumber1", column = @Column(name = "merHp1")),
    		@AttributeOverride(name = "phoneNumber2", column = @Column(name = "merHp2")),
    		@AttributeOverride(name = "PhoneNumber3", column = @Column(name = "merHp3"))
    })
    private PhoneNumber merHp;
    
    //private String merComintro;
   
    @Embedded
    @AttributeOverrides({
    	@AttributeOverride(name = "homepage", column = @Column(name = "merHomepage")),
    	@AttributeOverride(name = "ManagerName", column = @Column(name = "merManname")),
    	@AttributeOverride(name = "ManagerEmail", column = @Column(name = "merManemail")),
    	@AttributeOverride(name = "category", column = @Column(name = "merCategory")),
    	@AttributeOverride(name = "otherShop", column = @Column(name = "merOthershop")),
    	@AttributeOverride(name = "brandFile", column = @Column(name = "merFile")),
		@AttributeOverride(name = "PhoneNumber.phoneNumber1", column = @Column(name = "merManhp1")),
		@AttributeOverride(name = "PhoneNumber.phoneNumber2", column = @Column(name = "merManhp2")),
		@AttributeOverride(name = "PhoneNumber.PhoneNumber3", column = @Column(name = "merManhp3"))
    })
    private InbrandInfo inbrandInfo;
   
    private String merProdintro;
    
	@DateTimeFormat(pattern = "yy/MM/dd")
    private LocalDate merInbranddate;
    
	@DateTimeFormat(pattern = "yy/MM/dd")
    private LocalDate merDeletedate;
    
	@DateTimeFormat(pattern = "yy/MM/dd")
    private LocalDate merOutDate;
    
    private String merDelete;
    
    private String merAdress;
    
    private String merRegistration;
    
    private String merName;
    
    private String merEmail;
    
    private String merBusinessPost;

}
package com.oz.ozHouse.domain;

<<<<<<< HEAD
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
=======
import java.time.LocalDate;
>>>>>>> 9cf53a3acda31e05970035d8de8ccdc963c6fdfd

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.common.BaseEntity;
<<<<<<< HEAD

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
=======
import com.oz.ozHouse.domain.common.CompanyNumber;
import com.oz.ozHouse.domain.common.InbrandInfo;
import com.oz.ozHouse.domain.common.PhoneNumber;

import jakarta.persistence.*;
import lombok.AccessLevel;
>>>>>>> 9cf53a3acda31e05970035d8de8ccdc963c6fdfd
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
<<<<<<< HEAD
public class Merchant extends BaseEntity {
=======
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "regDate", column = @Column(name = "merJoindate"))
public class Merchant extends BaseEntity{
>>>>>>> 9cf53a3acda31e05970035d8de8ccdc963c6fdfd
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int merNum;
	
    private String merId;
    
    private String merPw;
    
    private String merIsbrand;
    
    private String merCompany;
<<<<<<< HEAD
    private String merComnum1;
    private String merComnum2;
    private String merComnum3;
    private String merHp1;
    private String merHp2;
    private String merHp3;
    private String merComintro;
    private String merHomepage;
    private String merManname;
    private String merManhp1;
    private String merManhp2;
    private String merManhp3;
    private String merManemail;
    private String merCategory;
    private String merProdintro;
    private String merOthershop;
    private String merFile;
    
    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL)
    private List<UserCoupon> userCoupons = new ArrayList<>();

    @Column(columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yy/MM/dd")
    private LocalDate merInbranddate;

    @Column(columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yy/MM/dd")
    private LocalDate merDeletedate;

    @Column(columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yy/MM/dd")
=======
    
    @Embedded
    private CompanyNumber merComnum;
    
    @Embedded
    @AttributeOverrides({
    		@AttributeOverride(name = "phoneNumber1", column = @Column(name = "merHp1")),
    		@AttributeOverride(name = "phoneNumber2", column = @Column(name = "merHp2")),
    		@AttributeOverride(name = "PhoneNumber3", column = @Column(name = "merHp3"))
    })
    private PhoneNumber merHp;
    
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
    
	@DateTimeFormat(pattern = "yy/MM/dd")
    private LocalDate merInbranddate;
    
	@DateTimeFormat(pattern = "yy/MM/dd")
    private LocalDate merDeletedate;
    
	@DateTimeFormat(pattern = "yy/MM/dd")
>>>>>>> 9cf53a3acda31e05970035d8de8ccdc963c6fdfd
    private LocalDate merOutDate;
    
    private String merDelete;
    
    private String merAdress;
    
    private String merRegistration;
    
    private String merName;
    
    private String merEmail;
    
    private String merBusinessPost;

}
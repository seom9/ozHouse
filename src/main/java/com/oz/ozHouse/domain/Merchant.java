package com.oz.ozHouse.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.common.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Merchant extends BaseEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int merNum;
	
    private String merId;
    private String merPw;
    private String merIsbrand;
    private String merCompany;
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
    private LocalDate merOutDate;
    
    private String merDelete;
    private String merAdress;
    private String merRegistration;
    private String merName;
    private String merEmail;
    private String merBusinessPost;

}
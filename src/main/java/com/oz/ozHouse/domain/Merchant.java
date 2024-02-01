package com.oz.ozHouse.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.Merchant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Merchant {
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
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
    private Date merJoindate;
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
    private Date merInbranddate;
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
    private Date merDeletedate;
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
    private Date merOutDate;
    private String merDelete;
    private String merAdress;
    private String merRegistration;
    private String merName;
    private String merEmail;
    private String merBusinessPost;

}
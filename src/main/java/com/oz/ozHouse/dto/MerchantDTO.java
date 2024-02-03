package com.oz.ozHouse.dto;

import java.sql.Date;

import com.oz.ozHouse.domain.Merchant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MerchantDTO {

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
    private Date merJoindate;
    private Date merInbranddate;
    private Date merDeletedate;
    private Date merOutDate;
    private String merDelete;
    private String merAdress;
    private String merRegistration;
    private String merName;
    private String merEmail;
    private String merBusinessPost;

}
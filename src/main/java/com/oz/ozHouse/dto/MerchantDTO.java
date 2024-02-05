package com.oz.ozHouse.dto;

import java.sql.Date;

import com.oz.ozHouse.domain.Merchant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder			 //builder 패턴 적용(필요한 필드만 생성자로 초기화 가능)
@NoArgsConstructor   //기본생성자 자동으로 생성
@AllArgsConstructor  //모든 필드의 생성자를 자동으로 생성
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
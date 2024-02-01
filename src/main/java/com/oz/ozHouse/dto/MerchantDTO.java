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

    public Merchant toEntity() {
        Merchant merchant = new Merchant();

        // Set the properties of the new Merchant instance based on the values of the current object
        merchant.setMerNum(this.merNum);
        merchant.setMerId(this.merId);
        merchant.setMerPw(this.merPw);
        merchant.setMerIsbrand(this.merIsbrand);
        merchant.setMerCompany(this.merCompany);
        merchant.setMerComnum1(this.merComnum1);
        merchant.setMerComnum2(this.merComnum2);
        merchant.setMerComnum3(this.merComnum3);
        merchant.setMerHp1(this.merHp1);
        merchant.setMerHp2(this.merHp2);
        merchant.setMerHp3(this.merHp3);
        merchant.setMerComintro(this.merComintro);
        merchant.setMerHomepage(this.merHomepage);
        merchant.setMerManname(this.merManname);
        merchant.setMerManhp1(this.merManhp1);
        merchant.setMerManhp2(this.merManhp2);
        merchant.setMerManhp3(this.merManhp3);
        merchant.setMerManemail(this.merManemail);
        merchant.setMerCategory(this.merCategory);
        merchant.setMerProdintro(this.merProdintro);
        merchant.setMerOthershop(this.merOthershop);
        merchant.setMerFile(this.merFile);
        merchant.setMerJoindate(this.merJoindate);
        merchant.setMerInbranddate(this.merInbranddate);
        merchant.setMerDeletedate(this.merDeletedate);
        merchant.setMerOutDate(this.merOutDate);
        merchant.setMerDelete(this.merDelete);
        merchant.setMerAdress(this.merAdress);
        merchant.setMerRegistration(this.merRegistration);
        merchant.setMerName(this.merName);
        merchant.setMerEmail(this.merEmail);
        merchant.setMerBusinessPost(this.merBusinessPost);

        // Return the new Merchant instance with its properties set
        return merchant;
    }

    // Getters and setters go here
}
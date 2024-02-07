package com.oz.ozHouse.domain;

import com.oz.ozHouse.domain.common.Image;
import com.oz.ozHouse.domain.common.ProPrice;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proNum;
    
    private String proName;
    
    private int cateNum;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merNum")
    private Merchant merchant;
    
    @Embedded
    private Image img;
    
    @Embedded
    private ProPrice merPrice;

//    @Embedded
//    private Image proImage;
//    
//    @Embedded
//    private Image proImgPro;
    
    private int proQuantity;
    
//    @Embedded
//    private ProPrice proPrice;
    
    private String proModifier;
    
//    @Embedded
//    private ProPrice proPoint;
    
    @DateTimeFormat(pattern = "yy/MM/dd")
    private LocalDate proInDate;
    
    private String proSpec;
    
    private int proPurchasesCount;
    
    private String proApprovalStatus;
    
//    @Embedded
//    private ProPrice proAssemblyCost;
//    
//    @Embedded
//    private ProPrice proDiscountRate;
//    
//    @Embedded
//    private ProPrice proDiscountPrice;
    
    private String cateName;
    
//    @Embedded
//    private Image proImageChange;
//    
//    @Embedded
//    private Image proImageProChange;
//    
//    @Embedded
//    private Image encodedImage;

    @JoinColumn(name = "inManName")
    private String inbrandCompany;
    
    private String proToday;
}

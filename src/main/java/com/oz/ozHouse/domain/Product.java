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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class Product {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proNum;
	
	private String proName;
	
	private int cateNum;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "merNum")
	private Merchant merchant;
    
    @Embedded
	private Image proImage;
	
	private int proQuantity;
	
    @Embedded
	private ProPrice proPrice;
	
	private String proModifier;

	private String proSpec;
	
	private int proPurchasesCount;
	
	private String proApprovalStatus;
	
	private String cateName;

    @JoinColumn(name="inManname")
	private String inbrandCompany;
	
	private String proToday;
}
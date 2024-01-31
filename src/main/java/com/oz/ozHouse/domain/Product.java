package com.oz.ozHouse.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
public class Product {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proNum;
	private String proName;
	private int cateNum;
	private int merNum;
	private String proImg;
	private String proImgPro;
	private int proQuantity;
	private int proPrice;
	private String proModifier;
	private int proPoint;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private String proInDate;
	private String proSpec;
	private int proPurchasesCount;
	private String proApprovalStatus;
	private int proAssemblyCost;
	private int proDiscountRate;
	private int proDiscountPrice;
	private String cateName;
	private String proImageChange;
	private String proImageProChange;
	private String encodedImage;
	private String inbrandCompany;
	private String proToday;
}

package com.oz.ozHouse.dto;

import com.oz.ozHouse.domain.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
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

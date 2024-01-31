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
	
   public Product toEntity() {
        Product product = new Product();
        product.setProNum(this.proNum);
        product.setProName(this.proName);
        product.setCateNum(this.cateNum);
        product.setMerNum(this.merNum);
        product.setProImg(this.proImg);
        product.setProImgPro(this.proImgPro);
        product.setProQuantity(this.proQuantity);
        product.setProPrice(this.proPrice);
        product.setProModifier(this.proModifier);
        product.setProPoint(this.proPoint);
        product.setProInDate(this.proInDate);
        product.setProSpec(this.proSpec);
        product.setProPurchasesCount(this.proPurchasesCount);
        product.setProApprovalStatus(this.proApprovalStatus);
        product.setProAssemblyCost(this.proAssemblyCost);
        product.setProDiscountRate(this.proDiscountRate);
        product.setProDiscountPrice(this.proDiscountPrice);
        product.setInbrandCompany(this.inbrandCompany);
        product.setProToday(this.proToday);
        return product;
    }
}

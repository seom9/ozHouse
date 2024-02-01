package com.oz.ozHouse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class RequestProduct {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productNum;
	private String productName;
	private int categoryNum;
	private String productImage;
	private String productImagePro;
	private int productQuantity;
	private int productPrice;
	private String productModifier;
	private int productPoint;
	private int productDeliveryCharge;
	private int productDiscountRate;
	private int productDiscountPrice;
	private int productAssemblyCost;
	private String productImageChange;
	private String productImageProChange;
	private int merNum;
	private String categoryName;
	private String encodedImage;

}

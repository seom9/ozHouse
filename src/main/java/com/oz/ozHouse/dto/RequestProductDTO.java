package com.oz.ozHouse.dto;

import com.oz.ozHouse.domain.RequestProduct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor   //기본생성자 자동으로 생성
public class RequestProductDTO {
	private int proNum;
	private String proName;
	private int categoryNum;
	private String proImg;
	private String proImgPro;
	private int proPrice;
	private String proModifier;
	private int proPoint;
	private int proDiscountRate;
	private int proDiscountPrice;
	private int proAssemblyCost;
	private String proImageChange;
	private String proImageProChange;
	private String categoryName;
	private String encodedImage;


}

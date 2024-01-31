package com.oz.ozHouse.dto;

import com.oz.ozHouse.domain.ProductReQA;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductReQADTO {

	private int productReQANum;
	private int productNum;
	private String memberId;
	private String productReQAContent;
	private String productReQADate;
	
	public ProductReQA toEntity() {
	    ProductReQA productReQA = new ProductReQA();
	    productReQA.setProductReQANum(this.productReQANum);
	    productReQA.setProductNum(this.productNum);
	    productReQA.setMemberId(this.memberId);
	    productReQA.setProductReQAContent(this.productReQAContent);
	    productReQA.setProductReQADate(this.productReQADate);
	    return productReQA;
	}

}

package com.oz.ozHouse.dto;

import com.oz.ozHouse.domain.ProductQA;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductQADTO {
	
	private int productQANum;
	private int productNum;
	private String memberId;
	private String productQASubject;
	private String productQAContent;
	private String productQADate;
	private int productReLevel;
	private int productReStep;
	private String productInquiryType;
	private String productQAState;
	
	public ProductQA toEntity() {
	    ProductQA productQA = new ProductQA();
	    productQA.setProductQANum(this.productQANum);
	    productQA.setProductNum(this.productNum);
	    productQA.setMemberId(this.memberId);
	    productQA.setProductQASubject(this.productQASubject);
	    productQA.setProductQAContent(this.productQAContent);
	    productQA.setProductQADate(this.productQADate);
	    productQA.setProductReLevel(this.productReLevel);
	    productQA.setProductReStep(this.productReStep);
	    productQA.setProductInquiryType(this.productInquiryType);
	    productQA.setProductQAState(this.productQAState);
	    return productQA;
	}


}

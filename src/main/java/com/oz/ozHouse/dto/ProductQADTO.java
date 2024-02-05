package com.oz.ozHouse.dto;

import java.time.LocalDate;

import com.oz.ozHouse.domain.ProductQA;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor  //기본생성자 자동으로 생성
public class ProductQADTO {
	
	private int productQANum;
	private int productNum;
	private String memberId;
	private String productQAContent;
	private LocalDate productQADate;
	private String productInquiryType;
	private String productQAState;
	
	public ProductQADTO toDTO(ProductQA productQA) {
		return ProductQADTO.builder()
				.productQANum(productQA.getProductQANum())
				.productQAContent(productQA.getProductQAContent())
				.productQADate(productQA.getProductQADate())
				.productInquiryType(productQA.getProductInquiryType())
				.productQAState(productQA.getProductQAState())
				.build();
	}
}

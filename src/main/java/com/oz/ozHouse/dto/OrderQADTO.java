package com.oz.ozHouse.dto;

import java.time.LocalDate;

import com.oz.ozHouse.domain.OrderQA;
import com.oz.ozHouse.domain.OrderTb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor  //기본생성자 자동으로 생성
public class OrderQADTO {
    private int orderQANum;
    private String memberId;
    private String orderQAContent;
    private String orderInquiryType;
    private String orderQAState;
    private LocalDate orderQADate;
    private int orderNum;

    public OrderQADTO toDTO(OrderQA orderQA) {
		return OrderQADTO.builder()
				.orderQANum(orderQA.getOrderQANum())
				.orderQAContent(orderQA.getOrderQAContent())
				.orderQADate(orderQA.getOrderQADate())
				.orderInquiryType(orderQA.getOrderInquiryType())
				.orderQAState(orderQA.getOrderQAState())
				.build();
	}
}

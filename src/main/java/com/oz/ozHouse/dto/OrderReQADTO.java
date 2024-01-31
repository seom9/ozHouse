package com.oz.ozHouse.dto;

import java.sql.Date;

import com.oz.ozHouse.domain.OrderReQA;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderReQADTO {

	private int orderReQANum ;
	private String memberId;
	private String orderReQAContent;
	private String orderReQADate;
	
	public OrderReQA toEntity() {
	    OrderReQA orderReQA = new OrderReQA();
	    orderReQA.setOrderReQANum(this.orderReQANum);
	    orderReQA.setMemberId(this.memberId);
	    orderReQA.setOrderReQAContent(this.orderReQAContent);
	    orderReQA.setOrderReQADate(this.orderReQADate);
	    return orderReQA;
	}


}

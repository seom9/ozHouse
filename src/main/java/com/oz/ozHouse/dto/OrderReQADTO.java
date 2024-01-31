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

	private int order_reQA_num ;
	private String member_id;
	private String order_reQA_content;
	private String order_reQA_date;
	
	public OrderReQA toEntity() {
	    OrderReQA orderReQA = new OrderReQA();
	    orderReQA.setOrder_reQA_num(this.order_reQA_num);
	    orderReQA.setMember_id(this.member_id);
	    orderReQA.setOrder_reQA_content(this.order_reQA_content);
	    orderReQA.setOrder_reQA_date(this.order_reQA_date);
	    return orderReQA;
	}

}

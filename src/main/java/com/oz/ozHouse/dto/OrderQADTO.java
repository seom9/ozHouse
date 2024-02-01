package com.oz.ozHouse.dto;

import java.sql.Date;

import com.oz.ozHouse.domain.OrderQA;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderQADTO {
    private int orderQANum;
    private String memberId;
    private String orderQAContent;
    private String orderInquiryType;
    private String orderQAState;
    private Date orderQADate;

    public OrderQA toEntity() {
        OrderQA orderQA = new OrderQA();
        orderQA.setOrderQANum(this.orderQANum);
        orderQA.setMemberId(this.memberId);
        orderQA.setOrderQAContent(this.orderQAContent);
        orderQA.setOrderInquiryType(this.orderInquiryType);
        orderQA.setOrderQAState(this.orderQAState);
        orderQA.setOrderQADate(this.orderQADate);
        return orderQA;
    }
}

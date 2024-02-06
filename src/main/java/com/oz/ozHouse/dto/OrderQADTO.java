package com.oz.ozHouse.dto;

import java.sql.Date;

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
}

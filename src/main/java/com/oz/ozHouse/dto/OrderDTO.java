package com.oz.ozHouse.dto;

import java.sql.Date;

import com.oz.ozHouse.domain.Order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private long oCode;
    private String memberId;
    private int productNum;
    private int oPrice;
    private int oDiscoupon;
    private int oDiscount;
    private int oDispoint;
    private String oComment;
    private int oCount;
    private String oDate;
    private String oPlace;
    private String oDelnow;
    private Date oCanceldate;
    private String oLike;
    private String oRefund;
    private int oAssemblycost;
    private int oNum;
    private String oName;
    private String oHp1;
    private String oHp2;
    private String oHp3;
    private String oPostcode;

    public Order toEntity() {
        Order order = new Order();

        // Set the properties of the new Order instance based on the values of the current object
        order.setOCode(this.oCode);
        order.setMemberId(this.memberId);
        order.setProductNum(this.productNum);
        order.setOPrice(this.oPrice);
        order.setODiscoupon(this.oDiscoupon);
        order.setODiscount(this.oDiscount);
        order.setODispoint(this.oDispoint);
        order.setOComment(this.oComment);
        order.setOCount(this.oCount);
        order.setODate(this.oDate);
        order.setOPlace(this.oPlace);
        order.setODelnow(this.oDelnow);
        order.setOCanceldate(this.oCanceldate);
        order.setOLike(this.oLike);
        order.setORefund(this.oRefund);
        order.setOAssemblycost(this.oAssemblycost);
        order.setONum(this.oNum);
        order.setOName(this.oName);
        order.setOHp1(this.oHp1);
        order.setOHp2(this.oHp2);
        order.setOHp3(this.oHp3);
        order.setOPostcode(this.oPostcode);

        // Return the new Order instance with its properties set
        return order;
    }

    // Getters and setters go here
}
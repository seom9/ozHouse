package com.oz.ozHouse.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Order {

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
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
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

}
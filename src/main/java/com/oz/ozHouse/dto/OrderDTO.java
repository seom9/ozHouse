package com.oz.ozHouse.dto;

import java.time.LocalDate;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private long oCode;
    private MemberDTO memberId;
    private int productNum;
    private int oPrice;
    private int oDiscoupon;
    private int oDiscount;
    private int oDispoint;
    private String oComment;
    private int oCount;
    private LocalDate oDate;
    private String oPlace;
    private String oDelnow;
    private LocalDate oCanceldate;
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
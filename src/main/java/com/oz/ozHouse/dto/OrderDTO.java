package com.oz.ozHouse.dto;

import java.time.LocalDateTime;

import com.oz.ozHouse.domain.OrderTb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
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
    private String oDate;
    private String oPlace;
    private String oDelnow;
    private LocalDateTime oCanceldate;
    private String oLike;
    private String oRefund;
    private int oAssemblycost;
    private int oNum;
    private String oName;
    private String oHp1;
    private String oHp2;
    private String oHp3;
    private String oPostcode;
    
//    public OrderDTO toDto(OrderTb o) {
//        return OrderDTO.builder()
//                .oCode(o.getOCode())
//                .memberId(o.getMemberId())  <- entity type을 어떻게 DTO로 옮길 것인가
//                .productNum(o.getProductNum())
//                .oPrice(o.getOPrice())
//                .oDiscoupon(o.getODiscoupon())
//                .oDiscount(o.getODiscount())
//                .oDispoint(o.getODispoint())
//                .oComment(o.getOComment())
//                .oCount(o.getOCount())
//                .oDate(o.getODate())
//                .oPlace(o.getOPlace())
//                .oDelnow(o.getODelnow())
//                .oCanceldate(o.getOCanceldate())
//                .oLike(o.getOLike())
//                .oRefund(o.getORefund())
//                .oAssemblycost(o.getOAssemblycost())
//                .oNum(o.getONum())
//                .oName(o.getOName())
//                .oHp1(o.getOHp1())
//                .oHp2(o.getOHp2())
//                .oHp3(o.getOHp3())
//                .oPostcode(o.getOPostcode())
//                .build();
//    }
}
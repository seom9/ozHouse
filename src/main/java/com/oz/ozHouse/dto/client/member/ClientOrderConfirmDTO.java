package com.oz.ozHouse.dto.client.member;

import com.oz.ozHouse.domain.OrderTb;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientOrderConfirmDTO {
    
    private Long oNum;               // 주문 코드
    private int memberNum;          // 구매자 정보 (회원 번호)
    
    private int oDispoint;           // 사용 포인트 금액
    private int oPrice;              // 최종 상품 주문 금액
    private String oName;            // 배송 받을 사람 이름
    
	public String phoneNumber1;		 // 받을 사람 번호
	public String phoneNumber2;
	public String phoneNumber3;
	
    private String postcode;		 // 받을 사람 주소지
    private String city;
    private String street;
    private String zipcode;
    
    private String oComment;         // 주문 시 남기는 코멘트
    private String oDelnow;          // 배송 상태
    private String oLike;            // 주문 상태
    private String oCanceldate;      // 주문 취소일
    private String regDate;          // 주문일

    
    // 정적 팩토리 메서드
    public static ClientOrderConfirmDTO fromEntity(OrderTb order) {
        return ClientOrderConfirmDTO.builder()
            .oNum(order.getONum())
            .memberNum(order.getMember().getMemberNum())
            .oDispoint(order.getODispoint())
            .oPrice(order.getOPrice())
            .oName(order.getOName())
            .phoneNumber1(order.getOHp().getPhoneNumber1())
            .phoneNumber2(order.getOHp().getPhoneNumber2())
            .phoneNumber3(order.getOHp().getPhoneNumber3())
            .postcode(order.getOAddress().getPostcode())
            .city(order.getOAddress().getCity())
            .street(order.getOAddress().getStreet())
            .zipcode(order.getOAddress().getZipcode())
            .oComment(order.getOComment())
            .oDelnow(order.getODelnow())
            .oLike(order.getOstatus())
            .oCanceldate(order.getOCanceldate())
            .regDate(order.getRegDate())
            .build();
    }
    
}

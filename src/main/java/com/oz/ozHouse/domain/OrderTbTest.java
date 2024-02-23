package com.oz.ozHouse.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.OrderTbTest;
import com.oz.ozHouse.domain.common.PhoneNumber;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
@AttributeOverride(name = "regDate", column = @Column(name = "oDate"))
public class OrderTbTest {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oCode;				//주문 코드 :
    private int oNum;				//주문 번호 : 
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="memberNum")
    private Member member;			//구매자 정보
    
    @OneToOne
    @JoinColumn(name="proNum")
    private Product product;		//구매 상품
    
    private int oCount;				//구매 수량
    
    private int oDispoint;			//사용 포인트 금액
    
    private int oPrice;				//최종 상품 주문 금액
    
    private String oComment;
    
    private String oPlace;			//배송지
    
    private String oPostcode;		//우편번호
    
    private String oDelnow;			//배송상태
	
    private String oLike;			//주문상태
    
    private String oRefund;			//판매자 처리 여부
    
	@DateTimeFormat(pattern = "yy/MM/dd")
    private LocalDate oCanceldate;	//주문 취소일
    

}
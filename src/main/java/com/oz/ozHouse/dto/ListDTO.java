package com.oz.ozHouse.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListDTO {

	private long oCode;
	private String memberId;
	
	private int proNum;
	private String proName;
	private int proPrice;
	private int proAssemblyCost;
	
	private String oPlace;
	private String oComment;
	private LocalDateTime oDate;
	private LocalDateTime oCanceldate;
	private int oCount;				//상품의 수량
	private int oPrice;				//소비자 결제 금액
	
	private String oDelnow;		//배송준비(ready)/배송중(delivery)/배송완료(complete)
	private String oLike;			//정상주문(null)/교환(exchange)/환불(return)
	private String oRefund;			//환불/반품 여부
	
	private int oDiscoupon;
	private int oDiscount;
	
}

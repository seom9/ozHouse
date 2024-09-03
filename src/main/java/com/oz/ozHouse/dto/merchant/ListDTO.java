package com.oz.ozHouse.dto.merchant;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListDTO {

	private long oCode;
	private String memberId;
	
	private int proNum;
	private String proName;
	private int proPrice;
	private int proAssemblyCost;
	
	private String oPlace;
	private String oComment;
	private Date oDate;
	private Date oCanceldate;
	private int oCount;				//상품의 수량
	private int oPrice;				//소비자 결제 금액
	
	private String oDelnow;		//배송준비(ready)/배송중(delivery)/배송완료(complete)
	private String oLike;			//정상주문(null)/교환(exchange)/환불(return)
	private String oRefund;			//환불/반품 여부
	
	private int oDiscoupon;
	private int oDiscount;
	
}

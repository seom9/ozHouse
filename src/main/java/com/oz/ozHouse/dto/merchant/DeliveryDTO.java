package com.oz.ozHouse.dto.merchant;

import java.util.List;

import com.oz.ozHouse.domain.ProInform;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDTO {

	//private int merNum;			//판매자 번호
	private Long orderNum;			//주문 번호
	private String memberId;	//회원 아이디
	private String regDate;		//주문일
	private String oCanceldate;  //취소일
	private String oComment;	//요청사항
	private String oDelnow;		//배송현황
	private String oLike;		//주문상태(환불여부)
	private List<MerProOrderDTO> orderPro; //주문 물품 
	private String oRefund;		//처리 여부
	
}

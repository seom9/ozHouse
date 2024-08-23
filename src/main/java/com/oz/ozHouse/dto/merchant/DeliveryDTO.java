package com.oz.ozHouse.dto.merchant;

import java.util.List;

import com.oz.ozHouse.domain.ProInform;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDTO {

	//private int merNum;			//판매자 번호
	private Long oderNum;			//주문 번호
	private String memberId;	//회원 아이디
	private String regDate;		//주문일
	private List<ProinformDTO> orderItems;		//물품과 수량
	private int oPrice;			//총 주문액
	private String order_comment;	//요청사항
	private String order_delivery_now;		//주문상태
}

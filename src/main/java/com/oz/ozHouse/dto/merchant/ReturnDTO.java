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
public class ReturnDTO {

	private Long order_code;			//주문 번호
	private String memberId;	//회원 아이디
	private String order_canceldate; //취소일(신청일)
	private List<ProinformDTO> orderItems;		//물품과 수량
	private int oPrice;			//총 주문액
	private String oComment;	//요청사항
	private String oDelnow;		//주문상태
	private String place;		//주문 장소
	private String order_delivery_now;   //배송 상태
	private String orderRefund;		//환불 반품 완료 여부(t,f)
}

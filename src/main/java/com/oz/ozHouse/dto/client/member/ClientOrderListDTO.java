package com.oz.ozHouse.dto.client.member;

import java.util.List;

import com.oz.ozHouse.domain.OrderTb;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientOrderListDTO {
	
    private Long orderNum;               // 주문 코드
    private String orderDelnow;          // 배송 상태
    private String orderCanceldate;      // 주문 취소일
    private String regDate;          // 주문일
    
    private List<ProQuanDTO> proQuanDTOs;
    
    // 정적 팩토리 메서드
    public static ClientOrderListDTO fromEntity(OrderTb order, List<ProQuanDTO> proQuanDTOs) {
        return ClientOrderListDTO.builder()
            .orderNum(order.getONum())
            .orderDelnow(order.getODelnow())
            .orderCanceldate(order.getOCanceldate())
            .regDate(order.getRegDate())
            .proQuanDTOs(proQuanDTOs)
            .build();
    }
}

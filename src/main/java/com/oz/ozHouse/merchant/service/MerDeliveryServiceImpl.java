package com.oz.ozHouse.merchant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.dto.merchant.DeliveryDTO;
import com.oz.ozHouse.merchant.repository.orderTbRepository.OrderTbRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerDeliveryServiceImpl implements MerDeliveryService {
	private final OrderTbRepository orderRepository;
	
	private List<DeliveryDTO> setListDto(List<OrderTb> ot){
		List<DeliveryDTO> listDto = new ArrayList<>();
		for(OrderTb o : ot) {
			DeliveryDTO dto = DeliveryDTO.builder()
					.oNum(o.getONum())
					.memberId(o.getMember().getMemberId())
					.regDate(o.getRegDate())
					.orderItems(o.getOrderItems())
					.oComment(o.getOComment())
					.oDelnow(o.getODelnow())
					.build();
		}
		return listDto;
	}
	@Override
	public List<DeliveryDTO> deliveryList(int merNum) {
		System.out.println("전체배송조회");
		List<OrderTb> ot = orderRepository.findOrdersByMerNum(merNum);
		List<DeliveryDTO> listDto = setListDto(ot);
		return listDto;
	}

	@Override
	public List<DeliveryDTO> deliveryLikeList(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

}

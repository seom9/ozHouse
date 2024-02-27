package com.oz.ozHouse.merchant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.dto.merchant.DeliveryDTO;
import com.oz.ozHouse.dto.merchant.DeliverySearchDTO;
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
			listDto.add(dto);
		}
		return listDto;
	}
	@Override
	public List<DeliveryDTO> deliveryList(int merNum) {
		System.out.println("배송전체조회");
		List<OrderTb> ot = orderRepository.findOrdersByMerNum(merNum);
		List<DeliveryDTO> listDto = setListDto(ot);
		return listDto;
	}

	@Override
	public List<DeliveryDTO> deliveryLikeList(Map<String, String> map) {
		System.out.println("배송상태별조회");
		List<OrderTb> ot = orderRepository.findOrdersLikeByMerNum(map.get("merNum"), map.get("mode"));
		List<DeliveryDTO> listDto = setListDto(ot);
		return listDto;
	}
	@Override
	public List<DeliveryDTO> searchDeliveryList(DeliverySearchDTO dto) {
		System.out.println("배송상태별조건조회");
		List<OrderTb> ot = orderRepository.searchDeliveryList(dto);
		List<DeliveryDTO> listDto = setListDto(ot);
		return listDto;
	}

}

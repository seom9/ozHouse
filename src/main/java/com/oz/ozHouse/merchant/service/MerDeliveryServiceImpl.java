package com.oz.ozHouse.merchant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.domain.ProInform;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.merchant.DeliveryDTO;
import com.oz.ozHouse.dto.merchant.DeliverySearchDTO;
import com.oz.ozHouse.dto.merchant.MerProOrderDTO;
import com.oz.ozHouse.merchant.repository.orderTbRepository.OrderTbRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerDeliveryServiceImpl implements MerDeliveryService {
	private final OrderTbRepository orderRepository;
	
	private List<DeliveryDTO> setListDto(List<OrderTb> ot){
		List<DeliveryDTO> listDto = new ArrayList<>();
		for(OrderTb o : ot) {
			List<MerProOrderDTO> MpoList = new ArrayList<>();
			for(ProInform pi : o.getOrderItems()) {
				MerProOrderDTO mpoDto = MerProOrderDTO.builder()
				.proName(pi.getProduct().getProName())
				.proNum(pi.getProduct().getProNum())
				.quantity(pi.getQuantity())
				.realPrice(pi.getRealPrice())
				.oRefund(pi.getORefund())
				.build();
				MpoList.add(mpoDto);
			}
			DeliveryDTO dto = DeliveryDTO.builder()
					.orderNum(o.getONum())
					.memberId(o.getMember().getMemberId())
					.regDate(o.getRegDate())
					.oCanceldate(o.getOCanceldate())
					.oComment(o.getOComment())
					.oDelnow(o.getODelnow())
					.oLike(o.getOLike())
					.orderPro(MpoList)
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

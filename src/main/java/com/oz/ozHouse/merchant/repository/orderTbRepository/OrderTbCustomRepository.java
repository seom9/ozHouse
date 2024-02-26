package com.oz.ozHouse.merchant.repository.orderTbRepository;

import java.util.List;

import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.dto.merchant.DeliverySearchDTO;

public interface OrderTbCustomRepository {
	
	public List<OrderTb> searchDeliveryList(DeliverySearchDTO dto);

}

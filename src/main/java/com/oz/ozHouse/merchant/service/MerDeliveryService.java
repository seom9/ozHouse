package com.oz.ozHouse.merchant.service;

import java.util.List;
import java.util.Map;

import com.oz.ozHouse.dto.merchant.DeliveryDTO;
import com.oz.ozHouse.dto.merchant.DeliverySearchDTO;

public interface MerDeliveryService {

	public List<DeliveryDTO> deliveryList(int merNum);
	
	public List<DeliveryDTO> deliveryLikeList(Map<String, String> map);
	
	public List<DeliveryDTO> searchDeliveryList(DeliverySearchDTO dto);
}

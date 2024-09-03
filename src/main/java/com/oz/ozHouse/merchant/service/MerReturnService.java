package com.oz.ozHouse.merchant.service;

import java.util.List;
import java.util.Map;

import com.oz.ozHouse.dto.merchant.DeliveryDTO;
import com.oz.ozHouse.dto.merchant.DeliverySearchDTO;
import com.oz.ozHouse.dto.merchant.ListDTO;
import com.oz.ozHouse.dto.merchant.ReturnDTO;

public interface MerReturnService {

	public List<ReturnDTO> returnList(int merNum);
	
	public List<ReturnDTO> deliveryLikeList(Map<String, String> map);
	
	public List<ReturnDTO> searchDeliveryList(DeliverySearchDTO dto);
}

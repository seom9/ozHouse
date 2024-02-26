package com.oz.ozHouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.dto.merchant.DeliverySearchDTO;

@Mapper
public interface DeliveryMapper {

	public List<OrderTb> searchDeliveryList(DeliverySearchDTO dto);
}

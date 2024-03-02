package com.oz.ozHouse.merchant.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MerchantMapper {
	String mybatisMerId(int merNum);
}

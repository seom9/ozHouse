package com.oz.ozHouse.merchant.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.oz.ozHouse.domain.OrderTb;

@NoRepositoryBean
public interface MerOrderRepository extends Repository<OrderTb, Integer>{
	int readyCount();
	int deliveryCount();
	int completeCount();
	int exchangeCount();
	int returnCount();
}

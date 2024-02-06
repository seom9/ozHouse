package com.oz.ozHouse.merchant.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.oz.ozHouse.domain.OrderQA;

@NoRepositoryBean
public interface MerOrderQARepository extends Repository<OrderQA, Integer>{

}

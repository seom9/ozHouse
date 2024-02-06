package com.oz.ozHouse.merchant.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.oz.ozHouse.domain.ProductQA;

@NoRepositoryBean
public interface MerProQARepository extends Repository<ProductQA, Integer>{

}

package com.oz.ozHouse.merchant.repository.inbrandRepository;

import org.springframework.data.repository.Repository;

import com.oz.ozHouse.domain.Inbrand;

public interface MerInbrandRepositoryCustum extends Repository<Inbrand, Integer> {

	public Inbrand selectMerNum(int merNum);
}

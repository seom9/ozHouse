package com.oz.ozHouse.merchant.repository.inbrandRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Inbrand;

@Repository
public interface MerInbrandRepository extends JpaRepository<Inbrand, Integer>, MerInbrandRepositoryCustum{

}

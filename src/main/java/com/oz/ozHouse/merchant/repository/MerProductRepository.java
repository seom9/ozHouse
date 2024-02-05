package com.oz.ozHouse.merchant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Notice;

@Repository
public interface MerStoreManageRepository extends JpaRepository<Notice, Integer> {

}

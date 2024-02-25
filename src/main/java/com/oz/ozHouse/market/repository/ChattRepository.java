package com.oz.ozHouse.market.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oz.ozHouse.domain.Chatt;

public interface ChattRepository extends JpaRepository<Chatt, Integer> {
	
	List<Chatt> findByRoomNum(Integer roomNum);
}

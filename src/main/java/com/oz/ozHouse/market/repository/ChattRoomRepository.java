package com.oz.ozHouse.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oz.ozHouse.domain.ChattRoom;

public interface ChattRoomRepository extends JpaRepository<ChattRoom, Integer> {
	
}
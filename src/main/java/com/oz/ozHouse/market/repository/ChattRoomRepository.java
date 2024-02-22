package com.oz.ozHouse.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.oz.ozHouse.domain.ChattRoom;

//@NoRepositoryBean
public interface ChattRoomRepository extends JpaRepository<ChattRoom, Integer> {
	
}
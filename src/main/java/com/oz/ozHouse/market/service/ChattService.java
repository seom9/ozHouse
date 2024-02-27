package com.oz.ozHouse.market.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Chatt;
import com.oz.ozHouse.dto.ChattDTO;

@Service
public interface ChattService {
	
	Chatt saveMessage(ChattDTO chattDTO);

	Chatt save(Chatt chatt);

	List<Chatt> findMessagesByRoomNum(Integer roomNum);

	Chatt findLastMessageByRoomNum(int roomNum);

	void deleteByInTimeBefore(LocalDateTime date);

	void deleteMessagesByRoomNum(int roomNum);

}

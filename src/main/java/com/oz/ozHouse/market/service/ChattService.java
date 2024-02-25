package com.oz.ozHouse.market.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Chatt;
import com.oz.ozHouse.domain.ChattRoom;
import com.oz.ozHouse.dto.ChattDTO;
import com.oz.ozHouse.dto.ChattRoomDTO;

@Service
public interface ChattService {
	
	Chatt saveMessage(ChattDTO chattDTO);

	List<Chatt> findMessagesByRoomNum(Integer roomNum);
	
	boolean markMessageAsRead(Integer msgNum);
}

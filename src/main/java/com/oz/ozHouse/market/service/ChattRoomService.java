package com.oz.ozHouse.market.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.ChattRoom;
import com.oz.ozHouse.dto.ChattRoomDTO;

@Service
public interface ChattRoomService {
	
	ChattRoom createChatRoom(ChattRoomDTO chattRoomDTO);
    List<ChattRoom> findAllRooms();
    ChattRoom findRoomByNum(Integer roomNum);
}

package com.oz.ozHouse.market.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.ChattRoom;
import com.oz.ozHouse.dto.ChattRoomDTO;

@Service
public interface ChattRoomService {

	int getOrCreateChatRoom(ChattRoomDTO dto);
}

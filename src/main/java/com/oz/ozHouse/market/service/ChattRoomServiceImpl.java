package com.oz.ozHouse.market.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oz.ozHouse.domain.ChattRoom;
import com.oz.ozHouse.dto.ChattRoomDTO;
import com.oz.ozHouse.market.repository.ChattRoomRepository;
import com.oz.ozHouse.market.repository.MarketProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입
public class ChattRoomServiceImpl implements ChattRoomService {

	private final ChattRoomRepository chattRoomRepository;

	private final MarketProductRepository marketProductRepository;

	// 채팅방
	@Override
	@Transactional
	public int getOrCreateChatRoom(ChattRoomDTO dto) {

		int existRoom = chattRoomRepository.findByMyIdAndProNum(dto.getMyId(), dto.getProNum());
		if (existRoom != 0) {
			return existRoom;
		}

		ChattRoom newRoom = new ChattRoom(dto);
//		newRoom.setMyId(myId);
//		newRoom.setProNum(proNum);
		ChattRoom savedRoom = chattRoomRepository.save(newRoom);
		return savedRoom.getRoomNum();
	}

}

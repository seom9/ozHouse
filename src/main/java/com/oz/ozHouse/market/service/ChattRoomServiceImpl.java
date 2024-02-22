package com.oz.ozHouse.market.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oz.ozHouse.domain.ChattRoom;
import com.oz.ozHouse.dto.ChattRoomDTO;
import com.oz.ozHouse.market.repository.ChattRoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChattRoomServiceImpl implements ChattRoomService {

    private final ChattRoomRepository chattRoomRepository;

    @Override
    @Transactional
    public ChattRoom createChatRoom(ChattRoomDTO chattRoomDTO) {
        ChattRoom chattRoom = new ChattRoom(chattRoomDTO);
        chattRoom = chattRoomRepository.save(chattRoom);
        return chattRoom;
    }

    @Override
    public List<ChattRoom> findAllRooms() {
        return chattRoomRepository.findAll();
    }

    @Override
    public ChattRoom findRoomByNum(Integer roomNum) {
        return chattRoomRepository.findById(roomNum)
                                  .orElseThrow(() -> new IllegalArgumentException("Chat room not found"));
    }
}

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
    public List<ChattRoom> findBymyId(String myId) {
        return chattRoomRepository.findBymyId(myId);
    }

    @Override
    public ChattRoom findRoomByNum(Integer roomNum) {
        return chattRoomRepository.findById(roomNum)
                                  .orElseThrow(() -> new IllegalArgumentException("Chat room not found"));
    }
    
    @Override
    @Transactional
    public ChattRoom findOrCreateRoom(String buyerNickname, String sellerNickname, Integer proNum) {
        // 기존 채팅방 검색 로직 구현 (예시 코드, 실제 구현은 데이터 모델에 따라 달라질 수 있음)
        List<ChattRoom> existingRooms = chattRoomRepository.findByBuyerAndSellerAndProNum(buyerNickname, sellerNickname, proNum);
        if (!existingRooms.isEmpty()) {
            return existingRooms.get(0); // 기존 채팅방이 있다면 반환
        }
        
        // 새 채팅방 생성 로직
        ChattRoomDTO chattRoomDTO = new ChattRoomDTO();
        chattRoomDTO.setMyId(buyerNickname);
        chattRoomDTO.setOtherId(sellerNickname);
        chattRoomDTO.setProNum(proNum);
        ChattRoom newRoom = new ChattRoom(chattRoomDTO);
        return chattRoomRepository.save(newRoom);
    }
}

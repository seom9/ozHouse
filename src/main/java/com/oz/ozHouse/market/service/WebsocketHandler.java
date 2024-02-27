package com.oz.ozHouse.market.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Object> findParticipantsByRoomNum(Integer roomNum) {
        return chattRoomRepository.findParticipantsByRoomNum(roomNum).stream()
                                  .flatMap(Arrays::stream)
                                  .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateUserCheckStatus(Integer roomNum, String userId, String status) {
        ChattRoom room = findRoomByNum(roomNum); // Assuming this method fetches the room by its number
        
        if (userId.equals(room.getMyId())) {
            room.setMyIdCheck(status);
        } else if (userId.equals(room.getOtherId())) {
            room.setOtherIdCheck(status);
        } else {
        }

        chattRoomRepository.save(room); // Save the updated room status
    }

	@Override
	public String findOtherParticipant(Integer roomNum, String sender) {
		return chattRoomRepository.findOtherParticipantId(roomNum, sender);
	}
}

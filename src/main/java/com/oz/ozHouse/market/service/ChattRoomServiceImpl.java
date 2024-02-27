package com.oz.ozHouse.market.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oz.ozHouse.domain.Chatt;
import com.oz.ozHouse.domain.ChattRoom;
import com.oz.ozHouse.dto.ChattRoomDTO;
import com.oz.ozHouse.market.repository.ChattRepository;
import com.oz.ozHouse.market.repository.ChattRoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChattRoomServiceImpl implements ChattRoomService {

    private final ChattRoomRepository chattRoomRepository;
    
    private final ChattRepository chattRepository;

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
        List<ChattRoom> existingRooms = chattRoomRepository.findByBuyerAndSellerAndProNum(buyerNickname, sellerNickname, proNum);
        if (!existingRooms.isEmpty()) {
            return existingRooms.get(0);
        }
        
        ChattRoomDTO chattRoomDTO = new ChattRoomDTO();
        chattRoomDTO.setMyId(buyerNickname);
        chattRoomDTO.setOtherId(sellerNickname);
        chattRoomDTO.setProNum(proNum);
        ChattRoom newRoom = new ChattRoom(chattRoomDTO);
        return chattRoomRepository.save(newRoom);
    }

    @Override
    public List<String> findParticipantsByRoomNum(Integer roomNum) {
        return chattRepository.findParticipantsByRoomNum(roomNum);
    }

//    @Override
//    public void updateUserCheckStatus(Integer roomNum, String userId, String status) {
//        chattRoomRepository.updateUserCheckStatus(roomNum, userId, status);
//    }

    @Override
    public String findOtherParticipant(Integer roomNum, String sender) {
        return chattRoomRepository.findOtherParticipantId(roomNum, sender);

    }
    
    public List<ChattRoomDTO> findRoomDetailsByMemberNickname(String memberNickname) {
        List<ChattRoom> rooms = findBymyId(memberNickname);
        List<ChattRoomDTO> roomDetails = new ArrayList<>();
        
        for (ChattRoom room : rooms) {
            Optional<Chatt> lastChattOpt = chattRepository.findLastMessageByRoomNum(room.getRoomNum());
            String lastMessage = lastChattOpt.map(Chatt::getMsg).orElse("");
            String partnerNickname = room.getMyId().equals(memberNickname) ? room.getOtherId() : room.getMyId();
            roomDetails.add(new ChattRoomDTO(room.getRoomNum(), partnerNickname, lastMessage));
        }

        return roomDetails;
    }

    @Override
    public void deleteChatRoom(int roomNum) {
    	chattRoomRepository.deleteChatRoom(roomNum);
    }

//    @Override
//    public String getUserCheckStatus(Integer roomNum, String userId) {
//        // TODO Auto-generated method stub
//        return null;
//    }

//    @Override
//    public void updateUserCheckStatus(int roomNum, String username, String status) {
//        chattRoomRepository.updateCheckStatus(roomNum, username, status);
//    }
}

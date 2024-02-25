package com.oz.ozHouse.market.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Chatt;
import com.oz.ozHouse.dto.ChattDTO;
import com.oz.ozHouse.market.repository.ChattRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChattServiceImpl implements ChattService {

	private final ChattRepository chattRepository;

	private final ChattRoomService chattRoomService;

	@Override
	public Chatt saveMessage(ChattDTO chattDTO) {
		
		// 채팅방의 참여자 목록을 가져옵니다.
		List<Object> participants = chattRoomService.findParticipantsByRoomNum(chattDTO.getRoomNum());

		// 발신자가 아닌 다른 참여자를 수신자로 설정합니다.
		String recipient = (String) participants.stream()
				.filter(participant -> !participant.equals(chattDTO.getSender())).findFirst()
				.orElseThrow(() -> new IllegalStateException("수신자를 결정할 수 없습니다."));

		// ChattDTO에 수신자를 설정합니다.
		chattDTO.setRecipient(recipient);
		
		chattDTO.setRoomNum(chattDTO.getRoomNum());

		// ChattDTO를 Chatt 엔터티로 변환하고, 모든 필드를 포함하여 올바르게 설정합니다.
		Chatt chatt = new Chatt(chattDTO);

		// Chatt 엔터티를 저장합니다.
		return chattRepository.save(chatt);
	}

	@Override
    public List<Chatt> findMessagesByRoomNum(Integer roomNum) {
        return chattRepository.findByRoomNum(roomNum);
    }
	
	@Override
	public boolean markMessageAsRead(Integer msgNum) {
	    // 메시지를 찾아 읽음 상태로 업데이트하는 로직 구현
	    // 예: 메시지 엔티티를 찾고, readStatus를 true로 설정한 다음 저장
	    Optional<Chatt> message = chattRepository.findById(msgNum);
	    if (message.isPresent()) {
	        Chatt chatt = message.get();
	        chatt.setReadStatus(true);
	        chattRepository.save(chatt);
	        return true; // 업데이트 성공
	    } else {
	        return false; // 메시지를 찾을 수 없음
	    }
	}
	
}

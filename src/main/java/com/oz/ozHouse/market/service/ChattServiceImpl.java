package com.oz.ozHouse.market.service;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Chatt;
import com.oz.ozHouse.dto.ChattDTO;
import com.oz.ozHouse.market.repository.ChattRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChattServiceImpl implements ChattService {

    private final ChattRepository chattRepository;

    @Override
    public Chatt saveMessage(ChattDTO chattDTO) {
        // Chatt로의 변환을 처리하는 생성자나 메소드 가정
        Chatt chatt = new Chatt(chattDTO); // 이 변환 과정이 올바른지 확인
        return chattRepository.save(chatt);
    }
}

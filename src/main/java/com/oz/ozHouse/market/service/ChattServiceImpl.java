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
    	Chatt chatt = new Chatt(chattDTO);
    	chatt = chattRepository.save(chatt);
    	return chatt;
    }
}

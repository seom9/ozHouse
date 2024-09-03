package com.oz.ozHouse.merchant.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.merchant.repository.mapper.MerchantMapper;
import com.oz.ozHouse.merchant.repository.merchantRepository.MerchantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchedulerServiceImple implements SchedulerService {
	private final MerchantRepository merchantRepository;
	//private final SqlSession sqlSession;
	private final MerchantMapper mapper;

	@Override
	public void deleteMerchant() {
		SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd");
		Date date = new Date();
		String today = df.format(date);
		System.out.println("Service--> today : " + today);
		merchantRepository.deleteByMerDeletedate(today);
		
	}

	@Override
	public String merId(int merNum) {
		String result = mapper.mybatisMerId(merNum);
		return result;
	}
}

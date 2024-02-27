package com.oz.ozHouse.merchant.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.merchant.repository.merchantRepository.MerchantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchedulerServiceImple implements SchedulerService {
	private final MerchantRepository merchantRepository;

	@Override
	public void deleteMerchant() {
		SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd");
		Date date = new Date();
		String today = df.format(date);
		System.out.println("Service--> today : " + today);
		merchantRepository.deleteByMerDeletedate(today);
		
	}
//
//	@Override
//	public String merId(String id) {
//		Optional<Merchant> om = mapper.findById(id);
//		String result = om.get().getMerId();
//		return result;
//	}
}

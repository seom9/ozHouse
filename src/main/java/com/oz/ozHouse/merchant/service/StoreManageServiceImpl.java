package com.oz.ozHouse.merchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Notice;
import com.oz.ozHouse.merchant.repository.MerStoreManageRepository;

@Service
public class StoreManageServiceImpl implements StoreManageService{

	@Autowired
	private MerStoreManageRepository storeManageRepository;
	
	@Override
	public List<Notice> getStoreNotice() {
		Pageable firstFive = PageRequest.of(0, 5);
		return storeManageRepository.findAll(firstFive).getContent();
	}
}

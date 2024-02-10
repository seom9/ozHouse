package com.oz.ozHouse.merchant.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.merchant.repository.MerProductRepository;
import com.oz.ozHouse.merchant.repository.MerchantJoinRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입
public class MerProServiceImpl implements MerProService {

	private final MerProductRepository proRepository;

//	private final MerchantJoinRepository merRepository;

	@Override
	@Transactional
	public String insertProduct(ProductDTO dto) {
//		Integer merchant = merRepository.findMerchantById(dto.getMerNum());

		Product pro = new Product(dto);
//		pro.setMerchant(1);
		System.out.println("service : " + dto.getProName());
		System.out.println(pro.getProName());
		proRepository.save(pro);
		return dto.getProName();
	}

}

package com.oz.ozHouse.merchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.merchant.repository.MerProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입
public class MerProServiceImpl implements MerProService {

	private final MerProductRepository proRepository;

//	private final MerchantJoinRepository merRepository;

	//상품 등록
	@Override
//	@Transactional
	public String insertProduct(ProductDTO dto) {
		Product pro = new Product(dto);
		System.out.println("service : " + dto.getProName());
		System.out.println(pro.getProName());
//		proRepository.save(pro);
		return dto.getProName();
	}

	//재고 리스트
	@Override
	public List<ProductDTO> stockList() {
		return proRepository.stockList();
	}

	//재고 리스트 건수
	@Override
	public Long stockListCount() {
		return proRepository.stockListCount();
	}

}

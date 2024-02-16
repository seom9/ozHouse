package com.oz.ozHouse.merchant.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.merchant.repository.MerProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입
public class MerProServiceImpl implements MerProService {

	private final MerProductRepository proRepository;

	//상품 등록
	@Override
	@Transactional
	public String insertProduct(ProductDTO dto) {
		Product pro = new Product(dto);
		proRepository.save(pro);
		return dto.getProName();
	}

	//재고 리스트
	@Override
	public List<ProductDTO> stockList(Map<String, Object> params) {
		return proRepository.stockList(params);
	}

	//재고 리스트 건수
	@Override
	public Long stockListCount(Map<String, Object> params) {
		return proRepository.stockListCount(params);
	}
}


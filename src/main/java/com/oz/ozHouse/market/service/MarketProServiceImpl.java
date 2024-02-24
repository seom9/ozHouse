package com.oz.ozHouse.market.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oz.ozHouse.domain.OzMarketPro;
import com.oz.ozHouse.dto.OzMarketProDTO;
import com.oz.ozHouse.market.repository.MarketProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입
public class MarketProServiceImpl implements MarketProService {

	private final MarketProductRepository proRepository;

	// 상품 등록
	@Override
	@Transactional
	public String insertProduct(OzMarketProDTO dto) {
		OzMarketPro pro = new OzMarketPro(dto);
		proRepository.save(pro);
		return dto.getProTitle();
	}

	// 상품 상세보기
	@Override
	public OzMarketProDTO getProduct(Integer proNum) {
        return proRepository.findByProNum(proNum)
                .orElseThrow(() -> new IllegalArgumentException("proNum : " + proNum));
    }

	// 조회 리스트
	@Override
	public List<OzMarketProDTO> listProduct(Map<String, Object> params) {
		return proRepository.listProduct(params);
	}
	
	// 상품 검색
	@Override
	public List<OzMarketProDTO> findProduct(String proTitle) {
		return proRepository.findProduct(proTitle);
	}
}

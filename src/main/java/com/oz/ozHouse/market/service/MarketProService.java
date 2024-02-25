package com.oz.ozHouse.market.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.OzMarketPro;
import com.oz.ozHouse.dto.OzMarketProDTO;

@Service
public interface MarketProService {

	// 상품 등록
	public String insertProduct(OzMarketProDTO dto);

	// 상품 상세보기
	OzMarketProDTO getProduct(Integer proNum);

	// 조회리스트
	public List<OzMarketProDTO> listProduct(Map<String, Object> params);
	
	// 상품 검색
	public List<OzMarketProDTO> findProduct(String proTitle);
	
	//내 정보 _ 판매중
	List<OzMarketProDTO> findSellingProductsByNickname(String nickname);
	
	//내 정보 _ 판매내역
	List<OzMarketProDTO> findSoldProductsByNickname(String nickname);
	
	//내 정보 _ 구매내역
	List<OzMarketProDTO> findBoughtProductsByNickname(String nickname);
	
	// 상품 삭제
	void deleteProduct(Integer proNum);
}

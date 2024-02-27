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
	
	//내 정보 _ 판매중
	@Override
	public List<OzMarketProDTO> findSellingProductsByNickname(String nickname) {
		return proRepository.findSellingProductsByNickname(nickname);
	}

	//내 정보 _ 판매내역
	@Override
	public List<OzMarketProDTO> findSoldProductsByNickname(String nickname) {
		return proRepository.findSoldProductsByNickname(nickname);
	}

	//내 정보 _ 구매내역
	@Override
	public List<OzMarketProDTO> findBoughtProductsByNickname(String nickname) {
		return proRepository.findBoughtProductsByNickname(nickname);
	}
	
	//내 정보 _ 예약내역
	@Override
	public List<OzMarketProDTO> findReservationProductsByNickname(String nickname) {
		return proRepository.findReservationProductsByNickname(nickname);
	}
	
	// 상품 삭제
	@Override
	@Transactional
	public void deleteProduct(Integer proNum) {
		 proRepository.deleteByProNum(proNum);
	}

	@Override
	@Transactional
	public boolean reserveProduct(Integer proNum, String memberNickname) {
		return proRepository.reserveProduct(proNum, memberNickname);
	}

	@Override
	@Transactional
	public boolean confirmPurchase(Integer proNum, String memberNickname) {
		return proRepository.confirmPurchase(proNum, memberNickname);
	}

	@Override
	@Transactional
	public boolean cancelReservation(Integer proNum) {
		return proRepository.cancelReservation(proNum);
	}
}

package com.oz.ozHouse.market.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.oz.ozHouse.domain.OzMarketPro;
import com.oz.ozHouse.dto.OzMarketProDTO;

@NoRepositoryBean
public interface MarketProductRepository extends Repository<OzMarketPro, Integer> {

	// 상품 등록
	OzMarketPro save(OzMarketPro product);

	// 상품 상세보기
	Optional<OzMarketProDTO> findByProNum(Integer proNum);

	// 상품 9개 모아보기
	List<OzMarketProDTO> listProduct(Map<String, Object> params);

	// 상품 검색
	List<OzMarketPro> findProduct(String proTitle);

}

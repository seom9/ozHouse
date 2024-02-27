package com.oz.ozHouse.market.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

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
	List<OzMarketProDTO> findProduct(String proTitle);
	
	//내 정보 _ 판매중
	List<OzMarketProDTO> findSellingProductsByNickname(String nickname);
	
	//내 정보 _ 판매내역
	List<OzMarketProDTO> findSoldProductsByNickname(String nickname);
	
	//내 정보 _ 구매내역
	List<OzMarketProDTO> findBoughtProductsByNickname(String nickname);

	// 상품 삭제
	void deleteByProNum(Integer proNum);
	
	@Modifying
	@Query("UPDATE OzMarketPro p SET p.buyStatus = :nickname, p.proApprovalStatus = '예약중' WHERE p.proNum = :proNum")
	boolean reserveProduct(@Param("proNum") Integer proNum, @Param("nickname") String nickname);
	
	@Modifying
	@Query("UPDATE OzMarketPro p SET p.buyStatus = :nickname, p.proApprovalStatus = '구매완료' WHERE p.proNum = :proNum")
	boolean confirmPurchase(@Param("proNum") Integer proNum, @Param("nickname") String nickname);
	
	@Modifying
	@Query("UPDATE OzMarketPro p SET p.buyStatus = NULL, p.proApprovalStatus = '판매중' WHERE p.proNum = :proNum")
	boolean cancelReservation(@Param("proNum") Integer proNum);
}

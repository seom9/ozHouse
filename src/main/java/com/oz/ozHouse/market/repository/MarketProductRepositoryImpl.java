package com.oz.ozHouse.market.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.boot.model.source.internal.hbm.AbstractSingularAttributeSourceEmbeddedImpl;
import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.OzMarketPro;
import com.oz.ozHouse.dto.OzMarketProDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MarketProductRepositoryImpl implements MarketProductRepository {

	private final EntityManager em;


	// 상품 상세보기
	@Override
	public Optional<OzMarketProDTO> findByProNum(Integer proNum) {
		try {
			OzMarketPro product = em.createQuery("SELECT oz FROM OzMarketPro oz WHERE oz.proNum = :proNum", OzMarketPro.class)
					.setParameter("proNum", proNum).getSingleResult();
			return Optional.of(OzMarketProDTO.toDTO(product));
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

	// 상품 등록
	@Override
	public OzMarketPro save(OzMarketPro product) {
		if (product.getProNum() == 0) { // 새로운 상품인 경우
			em.persist(product); // 상품 정보 저장
			return product;
		} else {
			return em.merge(product); // 기존 상품 정보 업데이트
		}
	}


	// 상품 9개 모아보기
	@Override
	public List<OzMarketProDTO> listProduct(Map<String, Object> params) {
	    // JPQL 쿼리 구성, 최신 상품부터 정렬
	    StringBuilder jpql = new StringBuilder("SELECT oz FROM OzMarketPro oz ORDER BY oz.proNum DESC");
	    TypedQuery<OzMarketPro> query = em.createQuery(jpql.toString(), OzMarketPro.class);

	    // 'params'에 'limit' 파라미터가 있으면 적용하여 결과 수 제한
	    if (params.containsKey("limit")) {
	        int limit = (int) params.get("limit");
	        query.setMaxResults(limit);
	    }

	    List<OzMarketPro> productList = query.getResultList();
	    // DTO 리스트로 변환하여 반환
	    return productList.stream().map(OzMarketProDTO::toDTO).collect(Collectors.toList());
	}
	
	// 상품 검색
	@Override
	public List<OzMarketPro> findProduct(String proTitle) {
		return em.createQuery("SELECT oz from OzMarketPro WHERE oz.proTitle Like :proTitle", OzMarketPro.class)
				.setParameter("proTitle", "%" + proTitle + "%")
				.getResultList();
	}
}

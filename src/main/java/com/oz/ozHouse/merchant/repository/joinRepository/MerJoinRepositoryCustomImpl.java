package com.oz.ozHouse.merchant.repository.joinRepository;

import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MerJoinRepositoryCustomImpl implements MerJoinRepositoryCustom{
	private final EntityManager em;

	@Transactional
	public MerchantDTO findMerchantId(String id) {
	String query = "SELECT m FROM Merchant m where m.merId = :value";
		TypedQuery<Merchant> jpql = em.createQuery(query, Merchant.class)
			.setParameter("value", id);
	// 결과 조회
	MerchantDTO dto = new MerchantDTO();
	try {
		Merchant m = jpql.getSingleResult();
		dto = dto.toDto(m);
	}catch(NoResultException e) {
		dto = null;
	}
		return dto;
	}

}
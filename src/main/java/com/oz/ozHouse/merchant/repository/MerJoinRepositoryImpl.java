package com.oz.ozHouse.merchant.repository;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MerJoinRepositoryImpl implements MerJoinRepository{
	private final EntityManager em;

	@Override
	public MerchantDTO findMerchantComnum(Map<String, String> comNum) {
		//Query 작성
		String query = "SELECT m FROM Merchant m where m.merComnum1 = :value1 AND m.merComnum2 = :value2 AND m.merComnum3 = :value3";
		//Query 생성
		TypedQuery<Merchant> jpql = em.createQuery(query, Merchant.class)
		        .setParameter("value1", comNum.get("merComnum1"))
		        .setParameter("value2", comNum.get("merComnum2"))
		        .setParameter("value3", comNum.get("merComnum3"));
		
		//결과 조회
		Merchant m = jpql.getSingleResult();
		
		MerchantDTO dto = new MerchantDTO();
		dto = dto.toDto(m);
		return dto;
	}

	@Override
	public MerchantDTO findMerchantEmail(String email) {
		// Query 작성
		String query = "SELECT m FROM Merchant m where m.merEmail = :value1";
		// Query 생성
		TypedQuery<Merchant> jpql = em.createQuery(query, Merchant.class)
				.setParameter("value1", email);

		// 결과 조회
		Merchant m = jpql.getSingleResult();

		MerchantDTO dto = new MerchantDTO();
		dto = dto.toDto(m);
		return dto;
	}

	@Override
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
			return dto;
		}
		return dto;
	}

}
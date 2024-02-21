package com.oz.ozHouse.merchant.repository.inbrandRepository;

import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Inbrand;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MerInbrandRepositoryCustumImpl implements MerInbrandRepositoryCustum {
	private final EntityManager em;

	@Transactional
	@Override
	public Inbrand selectMerNum(int merNum) {
		String query = "SELECT i FROM Inbrand i WHERE i.merchant.merNum = :merNum";
		TypedQuery<Inbrand> jpql = em.createQuery(query,Inbrand.class)
				.setParameter("merNum", merNum);
		Inbrand inbrand = null;
		try {
			inbrand = jpql.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("입점신청내역 판매자번호 조회 결과 없음");
		}
		return inbrand;
	}
}

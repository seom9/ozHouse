package com.oz.ozHouse.merchant.repository.loginRepository;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Merchant;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MerLoginRepositoryCustomImpl implements MerLoginRepositoryCustom {
	private final EntityManager em;
	
	@Override
	public Merchant findMerchantEmail(String mer_email) {
		String query = "SELECT m FROM Merchant m where m.merEmail = :value";
		TypedQuery<Merchant> jpql = em.createQuery(query, Merchant.class)
				.setParameter("value", mer_email);
		Merchant m = null;
		try {
			m = jpql.getSingleResult();
		}catch(NoResultException e) {
			e.printStackTrace();
		}
		return m;
	}

}

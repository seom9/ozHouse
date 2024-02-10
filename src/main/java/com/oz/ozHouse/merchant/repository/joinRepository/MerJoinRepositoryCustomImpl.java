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
		try {
			// 결과 조회
			Merchant m = jpql.getSingleResult();
			MerchantDTO dto = MerchantDTO.builder()
					.merNum(m.getMerNum()).merId(m.getMerId()).merPw(m.getMerPw())
					.merCompany(m.getMerCompany()).merComnum1(m.getMerComnum().getMerComnum1())
					.merComnum2(m.getMerComnum().getMerComnum2()).merComnum3(m.getMerComnum().getMerComnum3())
					.merHp1(m.getMerHp().getPhoneNumber1()).merHp2(m.getMerHp().getPhoneNumber2())
					.merHp3(m.getMerHp().getPhoneNumber3()).merAdress(m.getMerAdress())
					.merRegistration(m.getMerRegistration()).merName(m.getMerName()).merEmail(m.getMerEmail())
					.merBusinessPost(m.getMerBusinessPost()).build();
			return dto;
		} catch (NoResultException e) {
			MerchantDTO dto = new MerchantDTO();
			dto = null;
			return dto;
		}
		
	}

}
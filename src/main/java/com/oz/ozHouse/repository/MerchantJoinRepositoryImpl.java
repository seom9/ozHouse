package com.oz.ozHouse.repository;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor //final field, Not Null field에 대해 생성자 생성
public class MerchantJoinRepositoryImpl implements MerchantJoinRepository{
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
		
/*		Merchant jpql = em.createQuery(query, Merchant.class)
 *		        .setParameter("value1", comNum.get("merComnum1"))
 *		        .setParameter("value2", comNum.get("merComnum2"))
 *		        .setParameter("value3", comNum.get("merComnum3"))
 *		        .getSingleResult();
 *
 *		위의 코드도 같은 결과를 가져오지만 TypedQuery로 쿼리를 생성하는 것이 코드를 안정적으로 유지할 수 있으며,
 *		유지보수에도 용이하다 => 타입 안전성이 보장되기 때문이다(지정 Entity 이외의 다른 클래스캐스팅 시 오류 발생)
 */
	}

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

}

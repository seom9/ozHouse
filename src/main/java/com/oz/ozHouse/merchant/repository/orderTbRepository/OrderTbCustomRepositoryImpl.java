package com.oz.ozHouse.merchant.repository.orderTbRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.MerCoupon;
import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.dto.merchant.DeliveryDTO;
import com.oz.ozHouse.dto.merchant.DeliverySearchDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderTbCustomRepositoryImpl implements OrderTbCustomRepository {
	private final EntityManager em;
	
	public List<String> setConditions(DeliverySearchDTO dto){
		List<String> conditions = new ArrayList<>();
		
		if(dto.getStartDate() != null && dto.getEndDate() != null) {
			conditions.add("ot.regDate between " + dto.getStartDate()+ " and " + dto.getEndDate());
		}
		if(!dto.getMode().equals("all")) {
			conditions.add("ot.oDelnow = " + dto.getMode());
		}
		if(dto.getSearch().equals("all") && dto.getSearchString() != null) {
			conditions.add("(ot.oNum LIKE '%" + dto.getSearchString() + "%'"
					+ " OR ot.memberId LIKE '%" + dto.getSearchString() + "%'"
					+ "	OR p.proName LIKE '%" + dto.getSearchString() + "%')");
		}
		if(dto.getSearch().equals("proName") && dto.getSearchString() != null) {
			conditions.add("p.proName LIKE '%" + dto.getSearchString() + "%'");
		}
		if(dto.getSearch().equals("memberId") && dto.getSearchString() != null) {
			conditions.add("ot.memberId LIKE '%" + dto.getSearchString() + "%'");
		}
		if(dto.getSearch().equals("oNum") && dto.getSearchString() != null) {
			conditions.add("CAST(ot.oNum AS string) LIKE '%" + dto.getSearchString() + "%'");
		}
		return conditions;
	}

	@Override
	public List<OrderTb> searchDeliveryList(DeliverySearchDTO dto) {
		StringBuilder jpqlBuilder = new StringBuilder(
				"SELECT ot FROM OrderTb ot JOIN PRODUCT p ON ot.proNum = p.proNum"
				+ "	WHERE p.merNum = :merNum AND ot.oLike = 'ok'");

		List<String> conditions = setConditions(dto);
		
		if (!conditions.isEmpty()) {
			jpqlBuilder.append(" AND ").append(String.join(" AND ", conditions));
		}
		
		System.out.println("Repository ---> jpql : " + jpqlBuilder.toString());
		Merchant m = Merchant.builder().merNum(Integer.valueOf(dto.getMerNum())).build();
		TypedQuery<OrderTb> query = em.createQuery(jpqlBuilder.toString(), OrderTb.class)
				.setParameter("merNum",m);
	    return query.getResultList();
	}
	

}

package com.oz.ozHouse.merchant.repository.orderTbRepository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.OrderTb;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderTbCustomRepositoryImpl implements OrderTbCustomRepository {
	private final EntityManager em;
	
//	public List<OrderTb> deliveryAllList(Map<String, String> map){
//		String query = "SELECT ot FROM OrderTb ot WHERE ot.orderItems.product.merchant.merNum = :merNum AND ot.oLike = 'ok' ORDER BY ot.regDate DESC";
//		TypedQuery<OrderTb> jpql = em.createQuery(query, OrderTb.class)
//				.setParameter("merNum", map.get("merNum"));
//		List<OrderTb> list;
//		try {
//			list = jpql.getResultList();
//		}catch(Exception e) {
//			e.printStackTrace();
//			list = null;
//		}
//		return list;
//	}
}

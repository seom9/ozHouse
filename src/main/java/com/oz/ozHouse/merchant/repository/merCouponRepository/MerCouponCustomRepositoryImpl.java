package com.oz.ozHouse.merchant.repository.merCouponRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.MerCoupon;
import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.merchant.CouponSearchDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MerCouponCustomRepositoryImpl implements MerCouponCustomRepository {
	private final EntityManager em;
	
	@Transactional
	public int merCouponDelete(int merCouponnum) {
		String deleteCoupon = "delete from MerCoupon mc where mc.merCouponnum = :merCouponnum";
		//String deleteMsg = "delete from msg m where m.productNum=:merCouponnum and m.status='coupon'";
		try {
			//em.createQuery(deleteMsg, Msg.class).setParameter("merCouponnum", merCouponnum);
			Query query = em.createQuery(deleteCoupon); // 쿼리 생성
			query.setParameter("merCouponnum", merCouponnum); // 파라미터 설정
			int rowsAffected = query.executeUpdate(); // 쿼리 실행 및 영향 받은 행 수 반환
			if (rowsAffected > 0) {
				return 1; // 성공적으로 삭제됨
			} else {
				return 0; // 삭제할 항목이 없음
			}
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	private List<String> setConditions(Map<String, String> map){
		List<String> conditions = new ArrayList<>();
		
		if(map.get("startDate") != null && map.get("endDate") != null) {
			conditions.add("mc." + map.get("date") + " between '" + map.get("startDate") + "' and '" + map.get("endDate") + "'");
		}
		if(!map.get("merIsok").equals("all")) {
			conditions.add("mc.merIsok = " + "'" + map.get("merIsok") + "'");
		}
		String str = (map.get("searchString"));
		if(map.get("search").equals("all") && str != null && !str.equals("")) {
			String searchString = "%" + map.get("searchString") + "%";
			conditions.add("(CAST(mc.merCouponnum AS string) LIKE " + "'" + map.get("searchString") + "'" +
				    " OR mc.merCouponname LIKE" + " '" + searchString + "')");
		}else if(map.get("search") != null && map.get("search").equals("merCouponname")) {
			String searchString = "%" + map.get("searchString") + "%";
			conditions.add("mc.merCouponname like" + " '" + searchString + "'");
		}else if(map.get("search") != null && map.get("search").equals("merCouponnum")) {
			conditions.add("CAST(mc.merCouponnum AS string) like " + "'" + map.get("searchString") + "'");
		}
		return conditions;
	}

	@Override
	public List<MerCoupon> searchCouponList(Map<String, String> params) {
		StringBuilder jpqlBuilder = new StringBuilder("SELECT mc FROM MerCoupon mc WHERE mc.merNum = :merNum");

		List<String> conditions = setConditions(params);
		
		if (!conditions.isEmpty()) {
			jpqlBuilder.append(" AND ").append(String.join(" AND ", conditions));
		}
		
		System.out.println("Repository ---> jpql : " + jpqlBuilder.toString());
		Merchant m = Merchant.builder().merNum(Integer.valueOf(params.get("merNum"))).build();
		TypedQuery<MerCoupon> query = em.createQuery(jpqlBuilder.toString(), MerCoupon.class)
				.setParameter("merNum",m);
	    return query.getResultList();
	}

}

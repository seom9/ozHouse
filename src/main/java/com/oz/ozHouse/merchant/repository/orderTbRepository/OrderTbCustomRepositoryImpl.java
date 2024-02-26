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
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderTbCustomRepositoryImpl implements OrderTbCustomRepository {
	private final EntityManager em;
	
	public List<String> setConditions(DeliverySearchDTO dto){
		List<String> conditions = new ArrayList<>();
		
		//조회일이 있다면?
		if(dto.getStartDate() != null && dto.getEndDate() != null) {
			conditions.add("ot.regDate between '" + dto.getStartDate()+ "' and '" + dto.getEndDate() + "'");
		}
		//배송상태가 있다면?
		if(!dto.getMode().equals("all")) {
			conditions.add("ot.oDelnow = '" + dto.getMode() + "'");
		}
		//환불신청조건이 있다면?(ok : 정상주문 / return : 환불요청)
		if(!dto.getOLike().equals("all")) {
			conditions.add("ot.oLike = '" + dto.getOLike() + "'");
		}
		// 환불확인 여부가 있다면?(f : 미처리 / t : 처리)
		if (!dto.getORefund().equals("all")) {
			conditions.add("ot.ProInform.oRefund = '" + dto.getORefund() + "'");
		}
		//키워드 검색이 있다면?
		String str = dto.getSearchString();
		if(dto.getSearch().equals("all") && str != null && !str.equals("")) {
			conditions.add("(ot.oNum LIKE '%" + str + "%'"
					+ " OR ot.memberId LIKE '%" + str + "%'"
					+ "	OR p.proName LIKE '%" + str + "%')");
		}
		if(dto.getSearch().equals("proName") && str != null) {
			conditions.add("p.proName LIKE '%" + str + "%'");
		}
		if(dto.getSearch().equals("memberId") && str != null) {
			conditions.add("ot.memberId LIKE '%" + dto.getSearchString() + "%'");
		}
		if(dto.getSearch().equals("oNum") && str != null) {
			conditions.add("CAST(ot.oNum AS string) LIKE '%" + dto.getSearchString() + "%'");
		}
		return conditions;
	}

	@Override
	public List<OrderTb> searchDeliveryList(DeliverySearchDTO dto) {
		StringBuilder jpqlBuilder = new StringBuilder(
				//초기 조건 : 판매자 번호만으로 전체 조회
				"SELECT * FROM ozHouse.OrderTb ot " +
			            "JOIN ozHouse.ProInform AS pi2 ON ot.orderNum = pi2.oNum " +
			            "JOIN ozHouse.Product AS p ON pi2.proNum = p.proNum " +
			            "WHERE p.merNum = :merNumValue");

		List<String> conditions = setConditions(dto);
		
		if (!conditions.isEmpty()) {
			jpqlBuilder.append(" AND ").append(String.join(" AND ", conditions));
		}
		
		System.out.println("Repository ---> jpql : " + jpqlBuilder.toString());
		Query query = em.createNativeQuery(jpqlBuilder.toString(), OrderTb.class)
				.setParameter("merNumValue", dto.getMerNum());
	    return query.getResultList();
	}
	

}

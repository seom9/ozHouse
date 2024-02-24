package com.oz.ozHouse.merchant.repository.merCouponRepository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
}

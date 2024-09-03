package com.oz.ozHouse.merchant.repository.orderTbRepository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oz.ozHouse.domain.OrderTb;

import jakarta.transaction.Transactional;

public interface OrderTbRepository extends OrderTbCustomRepository, JpaRepository<OrderTb, Long>{
	
//	@Transactional
//	@Query(value = "SELECT * FROM ozHouse.OrderTb ot " +
//            "JOIN ozHouse.ProInform AS pi2 ON ot.orderNum = pi2.oNum " +
//            "JOIN ozHouse.Product AS p ON pi2.proNum = p.proNum " +
//            "WHERE p.merNum = :merNumValue AND ot.oLike = 'ok'", nativeQuery = true)
//	List<OrderTb> findOrdersByMerNum(@Param("merNumValue") int merNumValue);
//	
//	@Transactional
//	@Query("SELECT DISTINCT ot FROM OrderTb ot " +
//	       "JOIN FETCH ot.orderItems pi2 " +
//	       "JOIN FETCH pi2.product p " +
//	       "WHERE p.merchant.merNum = :merNumValue AND ot.oLike = 'ok'")
//	List<OrderTb> findOrdersByMerNum(@Param("merNumValue") int merNumValue);
	
	@Transactional
	@Query(value = "SELECT * FROM ozHouse.OrderTb ot " +
            "JOIN ozHouse.ProInform AS pi2 ON ot.orderNum = pi2.oNum " +
            "JOIN ozHouse.Product AS p ON pi2.proNum = p.proNum " +
            "WHERE p.merNum = :merNumValue AND ot.oLike = 'ok' AND ot.oDelnow = :oDelnow", nativeQuery = true)
	List<OrderTb> findOrdersLikeByMerNum(@Param("merNumValue") String merNumValue, 
			@Param("oDelnow") String oDelnow);
	
	List<OrderTb> findByOrderItemsProductMerchantMerNumAndOstatus(int merNumValue, String oLike);
}

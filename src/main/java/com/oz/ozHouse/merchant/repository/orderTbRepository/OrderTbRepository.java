package com.oz.ozHouse.merchant.repository.orderTbRepository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oz.ozHouse.domain.OrderTb;

import jakarta.transaction.Transactional;

public interface OrderTbRepository extends OrderTbCustomRepository, JpaRepository<OrderTb, Long>{
	
	@Transactional
	@Query(value = "SELECT * FROM OrderTb ot " +
            "JOIN ProInform pi2 ON ot.oNum = pi2.oNum " +
            "JOIN Product p ON pi2.proNum = p.proNum " +
            "WHERE p.merNum = :merNumValue", nativeQuery = true)
	List<OrderTb> findOrdersByMerNum(@Param("merNumValue") int merNumValue);
}

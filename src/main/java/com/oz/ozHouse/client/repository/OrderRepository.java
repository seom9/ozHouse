package com.oz.ozHouse.client.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oz.ozHouse.domain.OrderTb;

import jakarta.transaction.Transactional;

public interface OrderRepository extends JpaRepository<OrderTb, Long> {
	OrderTb findByoNum(long oNum);
	
    @Transactional
    @EntityGraph(attributePaths = {"useCoupons"})
    Optional<OrderTb> findOrderWithCouponsByoNum(Long oNum);
    
    @Transactional
    @EntityGraph(attributePaths = {"orderItems"})
    Optional<OrderTb> findOrderWithItemsByoNum(Long oNum);
    
    @Modifying
    @Transactional
    @Query("UPDATE OrderTb o SET o.oCanceldate = :date WHERE o.member.memberNum = :memberNum AND o.oNum = :oNum")
    void cancelOrderByMemberNumAndONum(@Param("memberNum") int memberNum, @Param("oNum") Long oNum, @Param("date") String date);
    
}

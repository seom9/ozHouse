package com.oz.ozHouse.client.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

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

}

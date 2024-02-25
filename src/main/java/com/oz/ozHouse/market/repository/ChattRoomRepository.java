package com.oz.ozHouse.market.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oz.ozHouse.domain.ChattRoom;

public interface ChattRoomRepository extends JpaRepository<ChattRoom, Integer> {
	
	@Query("SELECT c FROM ChattRoom c WHERE c.myId = :buyerNickname AND c.otherId = :sellerNickname AND c.proNum = :proNum")
    List<ChattRoom> findByBuyerAndSellerAndProNum(@Param("buyerNickname") String buyerNickname, 
                                                   @Param("sellerNickname") String sellerNickname, 
                                                   @Param("proNum") Integer proNum);
	
	@Query("SELECT c FROM ChattRoom c WHERE c.myId = :myId OR c.otherId = :myId")
    List<ChattRoom> findBymyId(@Param("myId") String myId);
}
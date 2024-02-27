package com.oz.ozHouse.market.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oz.ozHouse.domain.ChattRoom;

public interface ChattRoomRepository extends JpaRepository<ChattRoom, Integer> {

	@Query("SELECT c FROM ChattRoom c WHERE c.myId = :buyerNickname AND c.otherId = :sellerNickname AND c.proNum = :proNum")
	List<ChattRoom> findByBuyerAndSellerAndProNum(@Param("buyerNickname") String buyerNickname,
			@Param("sellerNickname") String sellerNickname, @Param("proNum") Integer proNum);

	@Query("SELECT c FROM ChattRoom c WHERE c.myId = :myId OR c.otherId = :myId ORDER BY c.roomNum DESC")
	List<ChattRoom> findBymyId(@Param("myId") String myId);

	@Query("SELECT c.myId, c.otherId FROM ChattRoom c WHERE c.roomNum = :roomNum")
	List<Object[]> findParticipantsByRoomNum(@Param("roomNum") Integer roomNum);

	@Query("SELECT CASE WHEN c.myId = :sender THEN c.otherId ELSE c.myId END FROM ChattRoom c WHERE c.roomNum = :roomNum")
	String findOtherParticipantId(@Param("roomNum") Integer roomNum, @Param("sender") String sender);

//	@Modifying
//    @Query("update ChattRoom c set c.check = :status where c.roomNum = :roomNum and c.username = :username")
//    void updateCheckStatus(@Param("roomNum") int roomNum, @Param("username") String username, @Param("status") String status);
}
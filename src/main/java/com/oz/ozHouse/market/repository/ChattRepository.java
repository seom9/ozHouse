package com.oz.ozHouse.market.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.oz.ozHouse.domain.Chatt;

public interface ChattRepository extends JpaRepository<Chatt, Integer> {
	
	List<Chatt> findByRoomNum(Integer roomNum);
	
	List<Chatt> findByRoomNum(int roomNum);
	
    Chatt findTopByRoomNumOrderByInTimeDesc(int roomNum);
    
    @Query("SELECT c FROM Chatt c WHERE c.roomNum = :roomNum ORDER BY c.inTime DESC")
    Optional<Chatt> findTopByRoomNumOrderByCreatedDateDesc(@Param("roomNum") Integer roomNum);

    @Transactional
    void deleteByInTimeBefore(LocalDateTime threshold);
    
    @Query("SELECT c FROM Chatt c WHERE c.roomNum = :roomNum ORDER BY c.inTime DESC")
    Optional<Chatt> findLastMessageByRoomNum(@Param("roomNum") Integer roomNum);

    @Query("SELECT DISTINCT c.sender FROM Chatt c WHERE c.roomNum = :roomNum")
    List<String> findParticipantsByRoomNum(@Param("roomNum") Integer roomNum);

}

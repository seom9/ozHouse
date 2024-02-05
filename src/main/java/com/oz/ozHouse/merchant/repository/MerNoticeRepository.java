package com.oz.ozHouse.merchant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Notice;

@Repository
public interface MerNoticeRepository extends JpaRepository<Notice, Integer> {
	List<Notice> findByNoticeNum(int noticeNum);
	List<Notice> findByNoticeTitleContaining(String title);
}

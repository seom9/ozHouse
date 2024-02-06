package com.oz.ozHouse.merchant.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.oz.ozHouse.domain.Notice;
import com.oz.ozHouse.dto.NoticeDTO;

@NoRepositoryBean
public interface MerNoticeRepository extends Repository<Notice, Integer> {
	
	//공지사항 6개 출력
	List<Notice> simpleNotice(Pageable mainNotice);
	
	//공지사항 상세보기
	NoticeDTO detailNotice(int noticeNum);
	
	//공지사항 목록 출력
	List<Notice> listNotice();
	
	//공지사항 검색
	List<Notice> findNotice(String noticeTitle);
	
	//스토어관리 홈 공지사항
	List<Notice> storeNotice(Pageable storeNotice);
}

package com.oz.ozHouse.merchant.service;

import java.util.List;

import com.oz.ozHouse.domain.Notice;

public interface NoticeService {
	List<Notice> getSimpleNotice();  //공지사항 5개 출력
 	List<Notice> getAllNotice(); //공지사항 전체 목록 출력
	List<Notice> getNotice(int noticeNum); //공지사항 상세보기
	List<Notice> findNoticesByTitle(String title); //공지사항 검색
}

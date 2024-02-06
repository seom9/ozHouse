package com.oz.ozHouse.merchant.service;

import java.util.List;

import com.oz.ozHouse.domain.Notice;
import com.oz.ozHouse.dto.NoticeDTO;

public interface NoticeService {
	
	//공지사항 6개 출력
	public List<Notice> simpleNotice();
	
	//공지사항 상세보기
	public NoticeDTO detailNotice(int noticeNum);
	
	//공지사항 목록 출력
	public List<Notice> listNotice();
	
	//공지사항 검색
	public List<Notice> findNotice(String noticeTitle);
	
	//스토어관리 홈 공지사항
	public List<Notice> storeNotice();
}

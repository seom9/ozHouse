package com.oz.ozHouse.merchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Notice;
import com.oz.ozHouse.dto.NoticeDTO;
import com.oz.ozHouse.merchant.repository.MerNoticeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{
	
	private final MerNoticeRepository noticeRepository;

	//공지사항 6개 출력
	@Override
	public List<Notice> simpleNotice() {
		Pageable mainNotice = PageRequest.of(0, 6);
		return noticeRepository.simpleNotice(mainNotice);
	}

	//공지사항 상세보기
	@Override
	public NoticeDTO detailNotice(int noticeNum) {
		return noticeRepository.detailNotice(noticeNum);
	}

	//공지사항 목록 출력
	@Override
	public List<Notice> listNotice() {
		return noticeRepository.listNotice();
	}

	//공지사항 검색
	@Override
	public List<Notice> findNotice(String noticeTitle) {
		return noticeRepository.findNotice(noticeTitle);
	}

	//스토어관리 홈 공지사항
	@Override
	public List<Notice> storeNotice() {
		Pageable storeNotice = PageRequest.of(0, 5);
		return noticeRepository.storeNotice(storeNotice);
	}

	
}

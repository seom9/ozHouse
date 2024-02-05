package com.oz.ozHouse.merchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Notice;
import com.oz.ozHouse.merchant.repository.MerNoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private MerNoticeRepository noticeRepository;

	@Override
	public List<Notice> getSimpleNotice() {
		Pageable firstSix = PageRequest.of(0, 6);
		return noticeRepository.findAll(firstSix).getContent();
	}

	@Override
	public List<Notice> getNotice(int noticeNum) {
		return noticeRepository.findByNoticeNum(noticeNum);
	}
	
	@Override
	public List<Notice> getAllNotice() {
		return noticeRepository.findAll();
	}

	@Override
	public List<Notice> findNoticesByTitle(String title) {
		return noticeRepository.findByNoticeTitleContaining(title);
	}
}

package com.oz.ozHouse.dto;

import java.time.LocalDate;

import com.oz.ozHouse.domain.Notice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor   //기본생성자 자동으로 생성
public class NoticeDTO {
    private int noticeNum;
    private String noticeTitle;
    private String noticeContent;
    private LocalDate noticeDate;

    public NoticeDTO toDTO(Notice notice) {
    	return NoticeDTO.builder()
    			.noticeNum(notice.getNoticeNum())
    			.noticeTitle(notice.getNoticeTitle())
    			.noticeContent(notice.getNoticeContent())
    			.noticeDate(notice.getNoticeDate())
    			.build();
    }
}

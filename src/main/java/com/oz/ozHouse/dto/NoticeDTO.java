package com.oz.ozHouse.dto;

import java.sql.Date;

import com.oz.ozHouse.domain.Notice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeDTO {
    private int noticeNum;
    private String noticeTitle;
    private String noticeContent;
    private Date noticeDate;

}

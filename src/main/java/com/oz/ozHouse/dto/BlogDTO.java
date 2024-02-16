package com.oz.ozHouse.dto;

import java.sql.Date;
import java.time.LocalDate;

import com.oz.ozHouse.domain.Blog;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BlogDTO {
	private int blogNum;
	private String blogContent;
	private Date blogDate;
	private String blogImage;
	private String blogRoomType;
	private String blogSubject;
	private String memberId;
	private int readcount;
	
}

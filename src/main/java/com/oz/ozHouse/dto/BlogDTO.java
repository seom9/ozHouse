package com.oz.ozHouse.dto;

import com.oz.ozHouse.domain.Blog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BlogDTO {
	private int blogNum;
	private String memberId;
	private String blogSubject;
	private String blogContent;
	private String blogImage;
	private String blogDate;
	private String blogRoomType;
	private int readcount;
	

}

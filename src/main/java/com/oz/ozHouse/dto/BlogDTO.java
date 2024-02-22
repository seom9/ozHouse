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
	
	// Entity를 DTO로 변환하는 메서드
	public BlogDTO(Blog blog) {
		this.blogNum = blog.getBlogNum();
		this.blogContent = blog.getBlogContent();
		this.blogDate = blog.getBlogDate();
		this.blogImage = blog.getBlogImage();
		this.blogRoomType = blog.getBlogRoomType();
		this.blogSubject = blog.getBlogSubject();
		this.memberId = blog.getMemberId();
		this.readcount = blog.getReadcount();
	}
	
	// DTO를 Entity로 변환하는 메서드
	public Blog toEntity() {
		return Blog.builder()
				.blogNum(this.blogNum)
				.blogContent(this.blogContent)
				.blogDate(this.blogDate)
				.blogImage(this.blogImage)
				.blogRoomType(this.blogRoomType)
				.blogSubject(this.blogSubject)
				.memberId(this.memberId)
				.readcount(this.readcount)
				.build();
	}
	
}

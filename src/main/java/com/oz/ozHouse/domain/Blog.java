package com.oz.ozHouse.domain;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "BLOG")
public class Blog {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blogNum;
	@Lob
	private String blogContent;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date blogDate;
	private String blogImage;
	private String blogRoomType;
	private String blogSubject;
	private String memberId;
	private int readcount;
	
	@Builder
	public Blog(int blogNum, String blogContent, Date blogDate, String blogImage, String blogRoomType,
			String blogSubject, String memberId, int readcount) {
		this.blogNum = blogNum;
		this.blogContent = blogContent;
		this.blogDate = blogDate;
		this.blogImage = blogImage;
		this.blogRoomType = blogRoomType;
		this.blogSubject = blogSubject;
		this.memberId = memberId;
		this.readcount = readcount;
	}
}
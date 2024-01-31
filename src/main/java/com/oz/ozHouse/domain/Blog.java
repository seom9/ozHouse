package com.oz.ozHouse.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Blog {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blog_num;
	private String member_id;
	private String blog_subject;
	private String blog_content;
	private String blog_image;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private String blog_date;
	private String blog_room_type;
	private int readcount;
}

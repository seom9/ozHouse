package com.oz.ozHouse.dto;

import com.oz.ozHouse.domain.Blog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BlogDTO {
	private int blog_num;
	private String member_id;
	private String blog_subject;
	private String blog_content;
	private String blog_image;
	private String blog_date;
	private String blog_room_type;
	private int readcount;
	
	public Blog toEntity() {
		Blog blog = new Blog();
		blog.setBlog_num(blog_num);
		blog.setMember_id(member_id);
		blog.setBlog_subject(blog_subject);
		blog.setBlog_content(blog_content);
		blog.setBlog_image(blog_image);
		blog.setBlog_date(blog_date);
		blog.setBlog_room_type(blog_room_type);
		blog.setReadcount(readcount);
		return blog;
	}
}

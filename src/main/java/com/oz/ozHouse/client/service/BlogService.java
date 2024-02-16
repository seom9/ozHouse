package com.oz.ozHouse.client.service;

import java.util.List;

import com.oz.ozHouse.domain.Blog;
import com.oz.ozHouse.dto.BlogDTO;

public interface BlogService {
	// 블로그 목록
	List<Blog> blogList();
	
	// 블로그 등록
	void insertBlog(BlogDTO blogDTO);
}

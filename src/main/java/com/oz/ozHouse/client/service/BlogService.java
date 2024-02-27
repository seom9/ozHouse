package com.oz.ozHouse.client.service;

import java.util.List;

import com.oz.ozHouse.dto.BlogDTO;

public interface BlogService {
	// 블로그 목록
	List<BlogDTO> blogList();
	
	// 블로그 등록
	int insertBlog(BlogDTO blogDTO);
	
	// 블로그 상세페이지
	BlogDTO getBlog(Integer blogNum);
	
	int updateReadCount(Integer blogNum);
}

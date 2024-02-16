package com.oz.ozHouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oz.ozHouse.domain.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	// 블로그 목록
	List<Blog> findAll();
}

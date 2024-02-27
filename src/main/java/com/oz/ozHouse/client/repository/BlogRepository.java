package com.oz.ozHouse.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oz.ozHouse.domain.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	// 블로그 목록
	List<Blog> findAll();
	
	Blog findByBlogNum(Integer blogNum);
	
	@Modifying
	@Query("UPDATE Blog b SET b.readcount = b.readcount + 1 where b.blogNum = :blogNum")
	int updateReadCount(@Param("blogNum") Integer blogNum);
}

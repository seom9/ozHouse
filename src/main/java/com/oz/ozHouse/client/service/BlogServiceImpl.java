package com.oz.ozHouse.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Blog;
import com.oz.ozHouse.dto.BlogDTO;
import com.oz.ozHouse.repository.BlogRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BlogServiceImpl implements BlogService {
	private final BlogRepository br;
	
	@Override
	public List<Blog> blogList() {
		return br.findAll();
	}

	@Override
	public void insertBlog(BlogDTO blogDTO) {
		try {
			Blog blog = Blog.builder()
					.blogNum(blogDTO.getBlogNum())
					.blogContent(blogDTO.getBlogContent())
					.blogDate(blogDTO.getBlogDate())
					.blogImage(blogDTO.getBlogImage())
					.blogRoomType(blogDTO.getBlogRoomType())
					.blogSubject(blogDTO.getBlogSubject())
					.memberId(blogDTO.getMemberId())
					.readcount(blogDTO.getReadcount())
					.build();
			
			br.save(blog);	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

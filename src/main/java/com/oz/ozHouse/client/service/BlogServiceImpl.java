package com.oz.ozHouse.client.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.BlogRepository;
import com.oz.ozHouse.domain.Blog;
import com.oz.ozHouse.dto.BlogDTO;
import com.oz.ozHouse.dto.ProductDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BlogServiceImpl implements BlogService {
	
	private final BlogRepository br;
	private final ModelMapper modelMapper;
	
	// 블로그 전체 목록
	@Override
	public List<BlogDTO> blogList() {
		
		List<Blog> blList = br.findAll();
		
		List<BlogDTO> blogList = blList.stream()
				.map(data -> modelMapper.map(data, BlogDTO.class))
				.collect(Collectors.toList());
		
		return blogList;
	}
	
	// 블로그 등록
	@Override
	public int insertBlog(BlogDTO blogDTO) {
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
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	// 블로그 상세보기
	@Override
	public BlogDTO getBlog(Integer blogNum) {
		
		Blog getBlog = br.findByBlogNum(blogNum);
		
		return new BlogDTO(getBlog);
	}
}

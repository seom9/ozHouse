package com.oz.ozHouse.client.service;

import java.util.List;

import com.oz.ozHouse.dto.ReviewDTO;

public interface ReviewService {
	//리뷰 목록
	List<ReviewDTO> reivewList();
	
	//리뷰 등록
	int insertReview(ReviewDTO reviewDTO);
	
	long reviewCount();
}

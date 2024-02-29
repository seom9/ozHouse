package com.oz.ozHouse.client.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.BlogRepository;
import com.oz.ozHouse.client.repository.ReviewRepository;
import com.oz.ozHouse.domain.Review;
import com.oz.ozHouse.dto.ReviewDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ReivewServiceImpl implements ReviewService {
	
	private final ReviewRepository re;
	private final ModelMapper modelMapper;
	
	@Override
	public List<ReviewDTO> reivewList() {

		List<Review> reList = re.findAll(Sort.by(Sort.Direction.DESC, "reviewNum"));
		
		List<ReviewDTO> reviewList = reList.stream()
				.map(data -> modelMapper.map(data, ReviewDTO.class))
				.collect(Collectors.toList());
		
		return reviewList;
	}

	@Override
	public int insertReview(ReviewDTO reviewDTO) {
		try {
			Review review = Review.builder()
					.reviewNum(reviewDTO.getReviewNum())
					.memberId(reviewDTO.getMemberId())
					.reviewStar(reviewDTO.getReviewStar())
					.reviewImage(reviewDTO.getReviewImage())
					.productNum(reviewDTO.getProductNum())
					.reviewDate(reviewDTO.getReviewDate())
					.build();
			
			re.save(review);
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public long reviewCount() {
		return re.count();
	}

}

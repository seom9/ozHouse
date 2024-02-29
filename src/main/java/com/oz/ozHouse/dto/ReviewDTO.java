package com.oz.ozHouse.dto;

import com.oz.ozHouse.domain.Review;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDTO {
	
    private int reviewNum;
    private String memberId;
    private int reviewStar;
    private String reviewContent;
    private String reviewImage;
    private int productNum;
    private String reviewDate;
    
    // entity를 DTO로 변환
    public ReviewDTO(Review review) {
    	this.reviewNum = review.getReviewNum();
    	this.memberId = review.getMemberId();
    	this.reviewStar = review.getReviewStar();
    	this.reviewImage = review.getReviewImage();
    	this.productNum = review.getProductNum();
    	this.reviewDate = review.getReviewDate();
    }
    
    // DTO를 Entity로 변환
    public Review toEntity() {
    	return Review.builder()
    			.reviewNum(this.reviewNum)
    			.memberId(this.memberId)
    			.reviewStar(this.reviewStar)
    			.reviewImage(this.reviewImage)
    			.productNum(this.productNum)
    			.reviewDate(this.reviewDate)
    			.build();
    }
}

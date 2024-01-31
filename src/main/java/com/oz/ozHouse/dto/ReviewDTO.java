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
    private int reviewLike;
    private String reviewDate;
	
    public Review toEntity() {
        Review reviewEntity = new Review();
        reviewEntity.setReviewNum(this.reviewNum);
        reviewEntity.setMemberId(this.memberId);
        reviewEntity.setReviewStar(this.reviewStar);
        reviewEntity.setReviewContent(this.reviewContent);
        reviewEntity.setReviewImage(this.reviewImage);
        reviewEntity.setProductNum(this.productNum);
        reviewEntity.setReviewLike(this.reviewLike);
        reviewEntity.setReviewDate(this.reviewDate);
        return reviewEntity;
    }

}

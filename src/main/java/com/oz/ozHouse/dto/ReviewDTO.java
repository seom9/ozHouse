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

}

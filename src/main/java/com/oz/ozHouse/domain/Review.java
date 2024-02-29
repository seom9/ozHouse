package com.oz.ozHouse.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Review {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewNum;
    private String memberId;
    private int reviewStar;
    private String reviewContent;
    private String reviewImage;
    private int productNum;
    private String reviewDate;
	
	@Builder
	public Review(int reviewNum, String memberId, int reviewStar, String reviewContent, String reviewImage,
			int productNum, String reviewDate) {
		this.reviewNum = reviewNum;
		this.memberId = memberId;
		this.reviewStar = reviewStar;
		this.reviewContent = reviewContent;
		this.reviewImage = reviewImage;
		this.productNum = productNum;
		this.reviewDate = reviewDate;
	}

}

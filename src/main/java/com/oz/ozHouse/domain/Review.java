package com.oz.ozHouse.domain;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Review {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewNum;
    private String memberId;
    private int reviewStar;
    private String reviewContent;
    private String reviewImage;
    private int productNum;
    private int reviewLike;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String reviewDate;

}

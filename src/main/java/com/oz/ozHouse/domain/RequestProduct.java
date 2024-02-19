package com.oz.ozHouse.domain;

import com.oz.ozHouse.domain.common.Image;
import com.oz.ozHouse.domain.common.ProPrice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity(name = "RequestProduct")
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestProduct {
	@Id 
	@GeneratedValue()
	private int proNum;
	private String proName;
	private int categoryNum;
	private String proImg;
	private String proImgPro;
	private int proPrice;
	private String proModifier;
	private int proPoint;
	private int proDiscountRate;
	private int proDiscountPrice;
	private int proAssemblyCost;
	private String proImageChange;
	private String proImageProChange;
	private String categoryName;
	private String encodedImage;

}

package com.oz.ozHouse.domain.common;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Image {
	private String proImg;
	private String proImgPro;
	private String proImageChange;
	private String proImageProChange;
	private String encodedImage;
}

package com.oz.ozHouse.domain.common;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PhoneNumber {
	private String phoneNumber1;
	private String phoneNumber2;
	private String PhoneNumber3;
}

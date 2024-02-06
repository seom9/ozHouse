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
	public String phoneNumber1;
	public String phoneNumber2;
	public String phoneNumber3;
}

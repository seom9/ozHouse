package com.oz.ozHouse.domain.member;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PhoneNumber {
	private String memberHp1;
	private String memberHp2;
	private String memberHp3;
}

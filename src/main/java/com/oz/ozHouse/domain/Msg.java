package com.oz.ozHouse.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Msg {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String reason;
	private String approvalStatus;
}

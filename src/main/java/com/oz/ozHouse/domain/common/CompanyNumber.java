package com.oz.ozHouse.domain.common;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)   //기본 생성자 자동 생성
@AllArgsConstructor  //필드의 모든 값을 초기화하는 생성자 자동 생성
@Getter
public class CompanyNumber {
    private String merComnum1;
    private String merComnum2;
    private String merComnum3;
}

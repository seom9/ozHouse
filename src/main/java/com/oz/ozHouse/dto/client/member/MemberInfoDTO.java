package com.oz.ozHouse.dto.client.member;

import java.time.LocalDate;

import com.oz.ozHouse.domain.common.MemberLevel;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberInfoDTO {
	int memberPoint;
	Enum memberLevel;
}

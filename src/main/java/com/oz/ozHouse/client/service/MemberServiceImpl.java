package com.oz.ozHouse.client.service;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.common.MemberLevel;
import com.oz.ozHouse.domain.common.PhoneNumber;
import com.oz.ozHouse.dto.MemberDTO;
import com.oz.ozHouse.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;

    public String insertMember(MemberDTO memberDTO) {
    	PhoneNumber phoneNumber = new PhoneNumber(
    	        memberDTO.getPhoneNumber1(),
    	        memberDTO.getPhoneNumber2(),
    	        memberDTO.getPhoneNumber3()
    	);
    	
        Member member = Member.builder()
                .memberId(memberDTO.getMemberId())
                .memberPasswd(memberDTO.getMemberPasswd())
                .memberNickname(memberDTO.getMemberNickname())
                .memberEmail(memberDTO.getMemberEmail())
                .memberImage(memberDTO.getMemberImage())
                .memberHp(phoneNumber)
                .memberPoint(0)
                .memberLevel(MemberLevel.NORMAL)
                .memberDeletedate(memberDTO.getMemberDeletedate())
                .build();

        memberRepository.save(member);
        return memberDTO.getMemberId();
    }

	@Override
	public int checkId(String memberId) {
		int answer = memberRepository.countByMemberId(memberId);
		return answer;
	}

	@Override
	public int checkEmail(String memberEmail) {
		return memberRepository.countByMemberEmail(memberEmail);
	}
    
}


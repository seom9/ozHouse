package com.oz.ozHouse.client.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.common.MemberLevel;
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
    	
        Member member = Member.builder()
                .memberId(memberDTO.getMemberId())
                .memberPasswd(memberDTO.getMemberPasswd())
                .memberNickname(memberDTO.getMemberNickname())
                .memberEmail(memberDTO.getMemberEmail())
                .memberPoint(0)
                .memberLevel(MemberLevel.NORMAL)
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

	@Override
	public MemberDTO getMember(String memberId) {
		Member member = memberRepository.findByMemberId(memberId);
	    return new MemberDTO(member);
	}

	@Override
	public int updateMember(MemberDTO dto) {
		Member member = new Member(dto);
		memberRepository.save();
		return 0;
	}
	
	
}


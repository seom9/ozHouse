package com.oz.ozHouse.client.service;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;

    @Override
    public int insertMember(Member member) {
        memberRepository.save(member);
        int mem = member.getMemberNum();
        return mem;
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


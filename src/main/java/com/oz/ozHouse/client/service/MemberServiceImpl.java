package com.oz.ozHouse.client.service;

import org.springframework.stereotype.Service;
import com.oz.ozHouse.client.repository.MemberRepository;
import com.oz.ozHouse.domain.Member;

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
	public int checkId(String member_id) {
		int answer = memberRepository.countByMemberId(member_id);
		return answer;
	}
    
}


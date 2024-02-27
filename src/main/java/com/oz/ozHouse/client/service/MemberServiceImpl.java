package com.oz.ozHouse.client.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.MemberRepository;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.common.MemberLevel;
import com.oz.ozHouse.domain.common.MemberRole;
import com.oz.ozHouse.dto.MemberDTO;
import com.oz.ozHouse.dto.client.member.MemberInfoDTO;
import com.oz.ozHouse.dto.client.member.MemberJoinDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional // 해당 객체를 감싸는 별도의 클래스를 생성
public class MemberServiceImpl implements MemberService {
	
	private final ModelMapper modelMapper;
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
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
	public Member getMemberEntity(String memberId) {
		Member member = memberRepository.findByMemberId(memberId);
		return member;
	}
	
	@Override
	public int updateMember(Member member) {
	    try {
	        memberRepository.save(member);
	        return 1; // 성공 시 반환할 값
	    } catch (Exception e) {
	        e.printStackTrace(); // 에러 로그 출력
	        return -1; // 에러 시 반환할 값
	    }
	}

	@Override
	public String join(MemberJoinDTO memberJoinDTO) throws IdExistException {
		String memberId = memberJoinDTO.getMemberId();
		boolean exist = memberRepository.existsByMemberId(memberId);
		
		if(exist) {
			throw new IdExistException();
		}
		
		Member member = modelMapper.map(memberJoinDTO, Member.class);
		member.changeMemberPassword(passwordEncoder.encode(memberJoinDTO.getMemberPasswd()));
		member.addRole(MemberRole.CLIENT);
		member.setMemberPoint(0);
        member.setMemberLevel(MemberLevel.NORMAL);
        memberRepository.save(member);
        
        return member.getMemberId();
	}

	@Override
	public int deleteMember(String memberId) {
		memberRepository.deleteByMemberId(memberId);
		return 0;
	}
	
	@Override
	public void updatePoint(String memberId, int point) {
		memberRepository.updateMemberPointByMemberId(point, memberId);
	}

	@Override
	public int memberPoint(String memberId) {
		return memberRepository.findByMemberId(memberId).getMemberPoint();
	}
	
	@Override
	public MemberInfoDTO memberPointAndLevel(String memberId) {
		Member member = memberRepository.findByMemberId(memberId);
		MemberInfoDTO memInfo = MemberInfoDTO.builder()
				.memberPoint(member.getMemberPoint())
				.memberLevel(member.getMemberLevel())
				.build();
		
		return memInfo;
		
	}
}


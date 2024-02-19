package com.oz.ozHouse.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.common.Address;
import com.oz.ozHouse.domain.common.BaseEntity;
import com.oz.ozHouse.domain.common.Image;
import com.oz.ozHouse.domain.common.MemberLevel;
import com.oz.ozHouse.domain.common.MemberRole;
import com.oz.ozHouse.domain.common.PhoneNumber;
import com.oz.ozHouse.dto.MemberDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "roleSet")
public class Member extends BaseEntity{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberNum;
	
	private String memberName;
	
	private String memberId;
	
	private String memberPasswd;
	
	private String memberNickname;
	
	private String memberEmail;
	
	private Image memberImage;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@Builder.Default
	private Set<MemberRole> roleSet = new HashSet<>();
	
	private boolean social;
	
	@Embedded
	private Address memberAddress;
	
	@Embedded
	private PhoneNumber memberHp;
	
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<OrderTb> orderList = new ArrayList<>();
    
    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Scrap> scrap = new ArrayList<>();
    
	private int memberPoint;
	
    @Enumerated(EnumType.STRING)
    private MemberLevel memberLevel;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private LocalDate memberDeletedate;
	
	public void changeMemberPassword(String memberPasswd) {
		this.memberPasswd = memberPasswd;
	}
	
	public void addRole(MemberRole memberRole) {
		this.roleSet.add(memberRole);
	}
	
	public void setMemberPoint (int memberPoint) {
		this.memberPoint = memberPoint;
	}
	
    public Member social(boolean social) {
        this.social = social;
        return this;
    }
	
	public void setMemberLevel (MemberLevel memberLevel) {
		this.memberLevel = memberLevel;
	}

    public static Member fromDTO(MemberDTO dto) {
        return Member.builder()
                .memberNum(dto.getMemberNum())
                .memberName(dto.getMemberName())
                .memberId(dto.getMemberId())
                .memberPasswd(dto.getMemberPasswd())
                .memberNickname(dto.getMemberNickname())
                .memberEmail(dto.getMemberEmail())
                .memberImage(dto.getMemberImage())
                .memberAddress(dto.getMemberAddress())
                .memberHp(dto.getMemberHp())
                .orderList(dto.getOrderList())
                .memberPoint(dto.getMemberPoint())
                .memberLevel(dto.getMemberLevel())
                .memberDeletedate(dto.getMemberDeletedate())
                .build();
    }
}
	

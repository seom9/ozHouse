package com.oz.ozHouse.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.common.BaseEntity;
import com.oz.ozHouse.domain.common.CompanyNumber;
import com.oz.ozHouse.domain.common.InbrandInfo;
import com.oz.ozHouse.domain.common.PhoneNumber;
import com.oz.ozHouse.dto.MerchantDTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "regDate", column = @Column(name = "merJoindate", nullable = false))
public class Merchant extends BaseEntity{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
    private int merNum;
	
	@NotNull
    private String merId;
    
	@NotNull
    private String merPw;
    
	@NotNull
    private String merIsbrand;
    
    @NotNull
    private String merCompany;
    
    @Embedded
    @NotNull
    private CompanyNumber merComnum;
    
    
    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL)
    private List<UserCoupon> userCoupons = new ArrayList<>();
    
    @Embedded
    @NotNull
    @AttributeOverrides({
    		@AttributeOverride(name = "phoneNumber1", column = @Column(name = "merHp1")),
    		@AttributeOverride(name = "phoneNumber2", column = @Column(name = "merHp2")),
    		@AttributeOverride(name = "phoneNumber3", column = @Column(name = "merHp3"))
    })
    private PhoneNumber merHp;
    
    @Embedded
    @AttributeOverrides({
    	@AttributeOverride(name = "homepage", column = @Column(name = "merHomepage")),
    	@AttributeOverride(name = "ManagerName", column = @Column(name = "merManname")),
    	@AttributeOverride(name = "ManagerEmail", column = @Column(name = "merManemail")),
    	@AttributeOverride(name = "category", column = @Column(name = "merCategory")),
    	@AttributeOverride(name = "otherShop", column = @Column(name = "merOthershop")),
    	@AttributeOverride(name = "brandFile", column = @Column(name = "merFile")),
		@AttributeOverride(name = "PhoneNumber.phoneNumber1", column = @Column(name = "merManhp1")),
		@AttributeOverride(name = "PhoneNumber.phoneNumber2", column = @Column(name = "merManhp2")),
		@AttributeOverride(name = "PhoneNumber.phoneNumber3", column = @Column(name = "merManhp3"))

    })
    	private InbrandInfo inbrandInfo;
    
	@DateTimeFormat(pattern = "yy/MM/dd")
    private LocalDate merInbranddate;
    
	@DateTimeFormat(pattern = "yy/MM/dd")
    private LocalDate merDeletedate;
    
	@DateTimeFormat(pattern = "yy/MM/dd")
    private LocalDate merOutDate;
    
    private String merDelete;
    
    @NotNull
    private String merAdress;
    
    @NotNull
    private String merRegistration;
    
    @NotNull
    private String merName;
    
    @NotNull
    private String merEmail;
    
    @NotNull
    private String merBusinessPost;
    
    public Merchant hashPassword(PasswordEncoder passwordEncoder) {
        this.merPw = passwordEncoder.encode(this.merPw);
        return this;
      }
    
    public Merchant(MerchantDTO dto) {
    	CompanyNumber merComnum = new CompanyNumber(dto.getMerComnum1(), dto.getMerComnum2(), dto.getMerComnum3());
    	PhoneNumber merHp = new PhoneNumber(dto.getMerHp1(), dto.getMerHp2(), dto.getMerHp3());
    	
    	this.merNum = dto.getMerNum();
    	this.merId = dto.getMerId();
    	this.merPw = dto.getMerPw();
    	this.merCompany = dto.getMerCompany();
    	this.merComnum = merComnum;
    	this.merHp = merHp;
    	this.merAdress = dto.getMerAdress();
    	this.merRegistration = dto.getMerRegistration();
    	this.merName = dto.getMerName();
    	this.merEmail = dto.getMerEmail();
    	this.merBusinessPost = dto.getMerBusinessPost();
    	this.merIsbrand = "f";
    }
}
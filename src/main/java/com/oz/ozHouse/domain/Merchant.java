package com.oz.ozHouse.domain;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.common.CompanyNumber;
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
@Builder(toBuilder = true)
@AllArgsConstructor
@DynamicUpdate 
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Merchant{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int merNum;
	
    private String merId;
    
    private String merPw;
    
    private String merIsbrand;
    
    private String merCompany;
    
    @Embedded
    private CompanyNumber merComnum;
    
    @OneToOne(mappedBy = "merchant", cascade = CascadeType.MERGE)
    private Inbrand inbrand;
    
    @Embedded
    @AttributeOverrides({
    		@AttributeOverride(name = "phoneNumber1", column = @Column(name = "merHp1")),
    		@AttributeOverride(name = "phoneNumber2", column = @Column(name = "merHp2")),
    		@AttributeOverride(name = "phoneNumber3", column = @Column(name = "merHp3"))
    })
    private PhoneNumber merHp;
    
    private String merInbranddate;
    
    private String merDeletedate;
    
    private String merJoindate;
    
    private String merOutDate;
    
    private String merDelete;
    
    private String merAdress;
    
    private String merRegistration;
    
    private String merName;
    
    private String merEmail;
    
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
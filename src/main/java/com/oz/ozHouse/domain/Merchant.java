package com.oz.ozHouse.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.common.BaseEntity;
import com.oz.ozHouse.domain.common.CompanyNumber;
import com.oz.ozHouse.domain.common.PhoneNumber;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AttributeOverride(name = "regDate", column = @Column(name = "merJoindate"))
public class Merchant extends BaseEntity{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int merNum;
    private String merId;
    private String merPw;
    private String merIsbrand;
    private String merCompany;
    
    @Embedded
    private CompanyNumber merComnum;
    
    @Embedded
//    @AttributeOverrides({
//    		@AttributeOverride(name = "memberHp1", column = @Column(name = "merHp1")),
//    		@AttributeOverride(name = "memberHp2", column = @Column(name = "merHp2")),
//    		@AttributeOverride(name = "memberHp3", column = @Column(name = "merHp3"))
//    })
    private PhoneNumber merHp;
    
    private String merComintro;
    private String merHomepage;
    private String merManname;
    
    @Embedded
    @AttributeOverrides({
    		@AttributeOverride(name = "memberHp1", column = @Column(name = "merManhp1")),
    		@AttributeOverride(name = "memberHp2", column = @Column(name = "merManhp2")),
    		@AttributeOverride(name = "memberHp3", column = @Column(name = "merManhp3"))
    })
    private PhoneNumber merManhp;
    
    private String merManemail;
    private String merCategory;
    private String merProdintro;
    private String merOthershop;
    private String merFile;
    
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
    private Date merInbranddate;
    
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
    private Date merDeletedate;
    
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
    private Date merOutDate;
    
    private String merDelete;
    private String merAdress;
    private String merRegistration;
    private String merName;
    private String merEmail;
    private String merBusinessPost;

}
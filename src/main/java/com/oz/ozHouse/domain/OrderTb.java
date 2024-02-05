package com.oz.ozHouse.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.domain.common.PhoneNumber;

<<<<<<< HEAD
import jakarta.persistence.CascadeType;
=======
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
>>>>>>> 9cf53a3acda31e05970035d8de8ccdc963c6fdfd
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
<<<<<<< HEAD
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
=======
>>>>>>> 9cf53a3acda31e05970035d8de8ccdc963c6fdfd
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AttributeOverride(name = "regDate", column = @Column(name = "oDate"))
public class OrderTb {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oCode;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="memberId")
    private Member member;
    
    private int productNum;
    
    private int oPrice;
    
    private int oDiscoupon;
    
    private int oDiscount;
    
    private int oDispoint;
    
    private String oComment;
    
    private int oCount;
    
    private String oPlace;
    
    private String oDelnow;
    
	@DateTimeFormat(pattern = "yy/MM/dd")
    private LocalDate oCanceldate;
	
    private String oLike;
    
    private String oRefund;
    
    private int oAssemblycost;
    
    private int oNum;
    
    private String oName;
    @Embedded
    @AttributeOverrides({
		@AttributeOverride(name = "phoneNumber1", column = @Column(name = "oHp1")),
		@AttributeOverride(name = "phoneNumber2", column = @Column(name = "oHp2")),
		@AttributeOverride(name = "PhoneNumber3", column = @Column(name = "oHp3"))
    })
    private PhoneNumber oHp;
    
    private String oPostcode;

}
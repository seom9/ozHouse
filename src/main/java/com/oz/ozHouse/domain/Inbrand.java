package com.oz.ozHouse.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

<<<<<<< HEAD

=======
import com.oz.ozHouse.domain.common.BaseEntity;
import com.oz.ozHouse.domain.common.CompanyNumber;
import com.oz.ozHouse.domain.common.InbrandInfo;

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
<<<<<<< HEAD
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
=======
import jakarta.persistence.OneToOne;
>>>>>>> 9cf53a3acda31e05970035d8de8ccdc963c6fdfd
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
<<<<<<< HEAD
public class Inbrand {
=======
@AttributeOverride(name = "regDate", column = @Column(name = "inAppliDate"))
public class Inbrand extends BaseEntity{

>>>>>>> 9cf53a3acda31e05970035d8de8ccdc963c6fdfd
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inNum;
	
<<<<<<< HEAD
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "merNum")
	private Merchant merchant;

	private String inCompany;
	
	private String inComnum;

	private String inHomepage;

	private String inManname;
	
	private String inManHp;

	private String inManemail;

	private String inCategory;

	private String inOthershop;

	private String inSaleFile;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date inAppliDate;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date inCancelDate;
}
=======
	@OneToOne
	@JoinColumn(name = "merNum")
	private int merNum;
	private String inCompany;
	
	@Embedded
    @AttributeOverrides({
    		@AttributeOverride(name = "merComnum1", column = @Column(name = "inComnum1")),
    		@AttributeOverride(name = "merComnum2", column = @Column(name = "inComnum2")),
    		@AttributeOverride(name = "merComnum3", column = @Column(name = "inComnum3"))
    })
	private CompanyNumber inComnum;
	
	@Embedded
	@AttributeOverrides({
    	@AttributeOverride(name = "homepage", column = @Column(name = "inHomepage")),
    	@AttributeOverride(name = "ManagerName", column = @Column(name = "inManname")),
    	@AttributeOverride(name = "ManagerEmail", column = @Column(name = "inManemail")),
    	@AttributeOverride(name = "category", column = @Column(name = "inCategory")),
    	@AttributeOverride(name = "otherShop", column = @Column(name = "inOthershop")),
    	@AttributeOverride(name = "brandFile", column = @Column(name = "inSaleFile")),
		@AttributeOverride(name = "PhoneNumber.phoneNumber1", column = @Column(name = "inManhp1")),
		@AttributeOverride(name = "PhoneNumber.phoneNumber2", column = @Column(name = "inManhp2")),
		@AttributeOverride(name = "PhoneNumber.PhoneNumber3", column = @Column(name = "inManhp3"))
    })
	private InbrandInfo inbrandInfo;
	
	@DateTimeFormat(pattern = "yy/MM/dd")
	private LocalDate inCancelDate;
	
}
>>>>>>> 9cf53a3acda31e05970035d8de8ccdc963c6fdfd

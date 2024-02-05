package com.oz.ozHouse.domain;

<<<<<<< HEAD
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
=======
import java.time.LocalDate;
>>>>>>> 9cf53a3acda31e05970035d8de8ccdc963c6fdfd

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.OneToMany;
=======
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
>>>>>>> 9cf53a3acda31e05970035d8de8ccdc963c6fdfd
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class MerCoupon {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int merCouponnum;
	private String merCouponname;
	private String merIsok;
	private int merCoupondiscount;
	
	@ManyToOne
	@JoinColumn(name = "merNum")
	private int merNum;
	
<<<<<<< HEAD
    @OneToMany(mappedBy = "merCoupon", cascade = CascadeType.ALL)
    private List<UserCoupon> userCoupons = new ArrayList<>();
	
	private Date merCouponusedate;
	private Date merCouponenddate;
=======
	@DateTimeFormat(pattern = "yy/MM/dd")
	private LocalDate merCouponusedate;
	
	@DateTimeFormat(pattern = "yy/MM/dd")
	private LocalDate merCouponenddate;
>>>>>>> 9cf53a3acda31e05970035d8de8ccdc963c6fdfd
	
}

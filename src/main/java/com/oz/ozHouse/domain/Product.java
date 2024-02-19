package com.oz.ozHouse.domain;

import java.time.format.DateTimeFormatter;

import com.oz.ozHouse.domain.common.Image;
import com.oz.ozHouse.domain.common.ProPrice;
import com.oz.ozHouse.dto.ProductDTO;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "Product")
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proNum;

	private String proName;

	private int categoryNum;

//	@Enumerated(EnumType.STRING)
//    private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "merNum")
	private Merchant merchant;

//	private int merNum;
	
	@Embedded
	private Image img;

	@Embedded
	private ProPrice merPrice;

	private int proQuantity;

	private String proModifier;

	private String proInDate;

	private String proSpec;

	private int proPurchasesCount;

	private String proApprovalStatus;

	private String categoryName;

	private String proToday;

	public Product(ProductDTO dto) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
		
		this.proNum = dto.getProNum();
		this.proName = dto.getProName();
		this.categoryNum = dto.getCategoryNum();
//		this.merchant = new Merchant(); 
		this.img = new Image(dto.getProImg(), dto.getProImgPro(), dto.getProImageChange(), dto.getProImageProChange()
//				,dto.getEncodedImage());
				);
		this.merPrice = new ProPrice(dto.getProPrice(), dto.getProPoint(), dto.getProAssemblyCost(),
				dto.getProDiscountRate(), dto.getProDiscountPrice());
		this.proQuantity = dto.getProQuantity();
		this.proModifier = dto.getProModifier();
		this.proInDate = dto.getProInDate().formatted(formatter);
		this.proSpec = "normal";
		this.proPurchasesCount = 0;
		this.proApprovalStatus = "f";
		this.categoryName = dto.getCategoryName();
		this.proToday = "0";
	}
}

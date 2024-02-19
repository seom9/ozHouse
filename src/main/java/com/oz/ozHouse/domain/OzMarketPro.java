package com.oz.ozHouse.domain;

import java.time.format.DateTimeFormatter;

import com.oz.ozHouse.domain.common.Image;
import com.oz.ozHouse.domain.common.ProPrice;
import com.oz.ozHouse.dto.OzMarketProDTO;
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
@Entity(name = "OzMarketPro")
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OzMarketPro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proNum;

	private String proTitle;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "memberNickname")
//	private Member Member;
	
	private String memberNickname;

	@Embedded
	private Image img;

	@Embedded
	private ProPrice proPrice;

	private String proContent;
	
	private String proInDate;

	private String proApprovalStatus;


	public OzMarketPro(OzMarketProDTO dto) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
		
		this.proNum = dto.getProNum();
		this.proTitle = dto.getProTitle();
//		this.Member = dto.getMemberNickname();
//		this.img = new Image(dto.getProImg(), dto.getProImgPro(), dto.getProImageChange(), dto.getProImageProChange());
//		this.proPrice = new ProPrice(dto.getProPrice(), dto.getProPoint(), dto.getProAssemblyCost(),
//				dto.getProDiscountRate(), dto.getProDiscountPrice());
		this.proContent = dto.getProContent();
		this.proInDate = dto.getProInDate().formatted(formatter);
		this.proApprovalStatus = "판매중";
	}
}

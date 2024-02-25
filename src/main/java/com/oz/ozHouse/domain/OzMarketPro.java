package com.oz.ozHouse.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.oz.ozHouse.dto.OzMarketProDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "memberNickname")
//	private Member Member;
	
	private String memberNickname;

//	@Embedded
//	private Image img;

//	@Embedded
//	private ProPrice proPrice;

	private String proImgPro;
    
	private int proPrice;
    
    private String proImageChange;

    @Lob
	private String proContent;
	
	private String proInDate;

	private String proApprovalStatus;
	
	private String buyStatus;


	public OzMarketPro(OzMarketProDTO dto) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
		
		this.proNum = dto.getProNum();
		this.proTitle = dto.getProTitle();
		this.memberNickname = dto.getMemberNickname();
//		this.memberNickname = "서아";
//		this.Member = dto.getMemberNickname();
//		this.img = new Image(dto.getProImg(), dto.getProImgPro(), dto.getProImageChange(), dto.getProImageProChange());
//		this.proPrice = new ProPrice(dto.getProPrice(), dto.getProPoint(), dto.getProAssemblyCost(),
//				dto.getProDiscountRate(), dto.getProDiscountPrice());
		this.proImgPro = dto.getProImgPro();
		this.proPrice = dto.getProPrice();
		this.proImageChange = dto.getProImageChange();
		this.proContent = dto.getProContent();
//		this.proInDate = dto.getProInDate().formatted(formatter);
		
		if (dto.getProInDate() != null) {
	        this.proInDate = dto.getProInDate().formatted(formatter);
	    } else {
	        this.proInDate = LocalDate.now().format(formatter); // 기본값으로 현재 날짜 설정
	    }
		
		this.proApprovalStatus = "판매중";
		this.buyStatus = dto.getBuyStatus();
	}
}

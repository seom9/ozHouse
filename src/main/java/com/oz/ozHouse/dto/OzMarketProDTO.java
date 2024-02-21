package com.oz.ozHouse.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.oz.ozHouse.domain.OzMarketPro;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.domain.common.Image;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor   //기본생성자 자동으로 생성
public class OzMarketProDTO {
    private int proNum;
    private String proTitle;
    private String memberNickname;
    private String proImgPro;
    private int proPrice; 
    private String proContent;
    private String proInDate;
    private String proApprovalStatus;
    private String proImageChange;
    private String encodedImage;
    private String buyStatus;

    public static OzMarketProDTO toDTO(OzMarketPro product) {
        
        return OzMarketProDTO.builder()
                .proNum(product.getProNum())
                .proTitle(product.getProTitle())
                .memberNickname(product.getMemberNickname())
//                .memberNickname(product.getMember().getMemberNickname())
//                .proImgPro(product.getImg().getProImgPro())
//                .proPrice(product.getProPrice().getProPrice())
                .proImgPro(product.getProImgPro())
                .proPrice(product.getProPrice())
                .proContent(product.getProContent())
                .proInDate(product.getProInDate())
                .proApprovalStatus(product.getProApprovalStatus())
                .proImageChange(product.getProImageChange())
                .buyStatus(product.getBuyStatus())
                .build();
    }
    
    public OzMarketProDTO(HttpServletRequest req) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");

        this.proTitle = req.getParameter("proTitle");
        this.memberNickname = req.getParameter("memberNickname");
        this.proImgPro = req.getParameter("proImgPro");
        this.proPrice = Integer.parseInt(req.getParameter("proPrice"));
        this.proContent = req.getParameter("proContent");
        this.proInDate = LocalDate.now().format(formatter);
        this.proApprovalStatus = req.getParameter("proApprovalStatus");
        this.proImageChange = req.getParameter("proImageChange");
        this.buyStatus = req.getParameter("buyStatus");
    }

	public void setProImageChange(String proImageChange) {
		this.proImageChange = proImageChange;
	}

	public void setProImgPro(String proImgPro) {
		this.proImgPro = proImgPro;
	}
	
	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}
	
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
}

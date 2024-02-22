package com.oz.ozHouse.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.oz.ozHouse.domain.Product;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor   //기본생성자 자동으로 생성
public class ProductDTO {
    private int proNum;
    private String proName;
    private int categoryNum;
    private int merNum;
    private String proImg;
    private String proImgPro;
    private int proQuantity;
    private int proPrice; 
    private String proModifier;
    private int proPoint;
    private String proInDate;
    private String proSpec;
    private int proPurchasesCount;
    private String proApprovalStatus;
    private int proAssemblyCost;
    private int proDiscountRate;
    private int proDiscountPrice;
    private String categoryName;
    private String proImageChange;
    private String proImageProChange;
    private String encodedImage;
    private String proToday;
    private boolean scrap;

    
    public static ProductDTO toDTO(Product product) {
        
        return ProductDTO.builder()
                .proNum(product.getProNum())
                .proName(product.getProName())
                .categoryNum(product.getCategoryNum())
                .merNum(product.getMerchant().getMerNum())
                .proImg(product.getImg().getProImg())
                .proImgPro(product.getImg().getProImgPro())
                .proQuantity(product.getProQuantity())
                .proPrice(product.getMerPrice() != null ? product.getMerPrice().getProPrice() : 0)
                .proModifier(product.getProModifier())
                .proPoint(product.getMerPrice() != null ? product.getMerPrice().getProPoint() : 0)
                .proInDate(product.getProInDate())
                .proSpec(product.getProSpec())
                .proPurchasesCount(product.getProPurchasesCount())
                .proApprovalStatus(product.getProApprovalStatus())
                .proAssemblyCost(product.getMerPrice() != null ? product.getMerPrice().getProAssemblyCost() : 0)
                .proDiscountRate(product.getMerPrice() != null ? product.getMerPrice().getProDiscountRate() : 0)
                .proDiscountPrice(product.getMerPrice() != null ? product.getMerPrice().getProDiscountPrice() : 0)
                .categoryName(product.getCategoryName())
                .proImageChange(product.getImg().getProImageChange())
                .proImageProChange(product.getImg().getProImageProChange())
                .proToday(product.getProToday())
                .build();
    }
    
    public ProductDTO(HttpServletRequest  req) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");

        this.proName = req.getParameter("proName");
        this.categoryNum = Integer.parseInt(req.getParameter("categoryNum"));
        this.merNum = Integer.parseInt(req.getParameter("merNum"));
        this.proImg = req.getParameter("proImg");
        this.proImgPro = req.getParameter("proImgPro");
        this.proQuantity = Integer.parseInt(req.getParameter("proQuantity"));
        this.proPrice = Integer.parseInt(req.getParameter("proPrice"));
        this.proModifier = req.getParameter("proModifier");
        this.proPoint = Integer.parseInt(req.getParameter("proPoint"));
//        this.proInDate = LocalDate.now();
        this.proInDate = LocalDate.now().format(formatter);
//        this.proSpec = "normal";
//        this.proPurchasesCount = 0;
//        this.proApprovalStatus = "f";
        this.proAssemblyCost = Integer.parseInt(req.getParameter("proAssemblyCost"));
        this.proDiscountRate = Integer.parseInt(req.getParameter("proDiscountRate"));
        this.proDiscountPrice = Integer.parseInt(req.getParameter("proDiscountPrice"));
        this.categoryName = req.getParameter("categoryName");
        this.proImageChange = req.getParameter("proImageChange");
        this.proImageProChange = req.getParameter("proImageProChange");
//        this.encodedImage = "encodedImage";
//        this.proToday = "0";
    }

	public void setProImg(String proImg) {
		this.proImg = proImg;
	}

	public void setProImageChange(String proImageChange) {
		this.proImageChange = proImageChange;
	}
	
	public void setProImageProChange(String proImageProChange) {
		this.proImageProChange = proImageProChange;
	}

	public void setProImgPro(String proImgPro) {
		this.proImgPro = proImgPro;
	}
	
	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public void setMerNum(int merNum) {
		this.merNum = merNum;
	}

	public void setScrap(boolean scrap) {
		this.scrap = scrap;
	}
}

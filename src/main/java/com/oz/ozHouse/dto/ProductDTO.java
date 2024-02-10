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
    private LocalDate proInDate; 
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

    public ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .proNum(product.getProNum())
                .proName(product.getProName())
                .categoryNum(product.getCategoryNum())
//                .merNum(product.getMerchant().getMerNum())
                .merNum(product.getMerNum())
                .proImg(product.getImg().getProImg())
                .proImgPro(product.getImg().getProImgPro())
                .proQuantity(product.getProQuantity())
                .proPrice(product.getMerPrice().getProPrice())
                .proModifier(product.getProModifier())
                .proPoint(product.getMerPrice().getProPoint())
                .proInDate(product.getProInDate())
                .proSpec(product.getProSpec())
                .proPurchasesCount(product.getProPurchasesCount())
                .proApprovalStatus(product.getProApprovalStatus())
                .proAssemblyCost(product.getMerPrice().getProAssemblyCost())
                .proDiscountRate(product.getMerPrice().getProDiscountRate())
                .proDiscountPrice(product.getMerPrice().getProDiscountPrice())
                .categoryName(product.getCategoryName())
                .proImageChange(product.getImg().getProImageChange())
                .proImageProChange(product.getImg().getProImageProChange())
                .encodedImage(product.getImg().getEncodedImage())
                .proToday(product.getProToday())
                .build();
    }
    
//    public Product toEntity() {
//        return Product.builder()
//                .proNum(this.proNum)
//                .proName(this.proName)
//                .categoryNum(this.categoryNum)
//                .img(new Image(this.proImg, this.proImgPro, this.proImageChange, this.proImageProChange, this.encodedImage))
//                .merPrice(new ProPrice(this.proPrice, this.proPoint, this.proAssemblyCost, this.proDiscountRate, this.proDiscountPrice))
//                .proQuantity(this.proQuantity)
//                .proModifier(this.proModifier)
//                .proInDate(this.proInDate)
//                .proSpec(this.proSpec)
//                .proPurchasesCount(this.proPurchasesCount)
//                .proApprovalStatus(this.proApprovalStatus)
//                .categoryName(this.categoryName)
//                .proToday(this.proToday)
//                .build();
//    }
    
    public String getFormattedProInDate() {
        return proInDate.format(DateTimeFormatter.ofPattern("yy/MM/dd"));
    }
    	
    public ProductDTO(HttpServletRequest req) {
//        this.proNum = 5;
        this.proName = req.getParameter("proName");
        this.categoryNum = Integer.parseInt(req.getParameter("categoryNum"));
        this.merNum = 1;
        this.proImg = req.getParameter("proImg");
        this.proImgPro = req.getParameter("proImgPro");
        this.proQuantity = Integer.parseInt(req.getParameter("proQuantity"));
        this.proPrice = Integer.parseInt(req.getParameter("proPrice"));
        this.proModifier = req.getParameter("proModifier");
        this.proPoint = Integer.parseInt(req.getParameter("proPoint"));
        this.proInDate = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
//        this.proInDate = LocalDate.now().format(formatter); // 현재 날짜를 "yy/MM/dd" 형식으로 포맷하여 저장

        this.proSpec = "normal";
        this.proPurchasesCount = 0;
        this.proApprovalStatus = "f";
        this.proAssemblyCost = Integer.parseInt(req.getParameter("proAssemblyCost"));
        this.proDiscountRate = Integer.parseInt(req.getParameter("proDiscountRate"));
        this.proDiscountPrice = Integer.parseInt(req.getParameter("proDiscountPrice"));
        this.categoryName = req.getParameter("categoryName");
        this.proImageChange = "proImageChange";
        this.proImageProChange = "proImageProChange";
        this.encodedImage = "encodedImage";
        this.proToday = "0";
    }
}

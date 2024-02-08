package com.oz.ozHouse.dto;

import java.time.LocalDate;

import com.oz.ozHouse.domain.Product;

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
                .merNum(product.getMerchant().getMerNum())
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
}

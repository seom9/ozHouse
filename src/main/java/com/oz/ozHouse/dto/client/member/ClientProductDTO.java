package com.oz.ozHouse.dto.client.member;

import com.oz.ozHouse.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor   
public class ClientProductDTO {
    private int proNum;
    
    private String proName;
    
    private int categoryNum;
    
    private int merNum;
    
    private String proImg;
    private String proImgPro;
    private String proImageChange;
    private String proImageProChange;
    private String encodeImage;
    
	private int proPrice;
	private int proPoint;	
	private int proAssemblyCost;
	private int proDiscountRate;
	private int proDiscountPrice;
    
    private String proModifier;
    
	private int proQuantity;

	private String proInDate;

	private String proSpec;

	private int proPurchasesCount;

	private String proApprovalStatus;

	private String categoryName;

	private String proToday;
	
    private boolean scrap;
    
    public void setScrap(boolean scrap) {
    	this.scrap = scrap;
    }
    
    // 정적 팩토리 메서드
    public static ClientProductDTO from(Product product) {
    	if (product == null) return null;
    	
        return ClientProductDTO.builder()
                .proNum(product.getProNum())
                .proName(product.getProName())
                .categoryNum(product.getCategoryNum())
                .merNum(product.getMerchant().getMerNum())
	            .proImg(product.getImg().getProImg())
	            .proImgPro(product.getImg().getProImgPro())
	            .proImageChange(product.getImg().getProImageChange())
	            .proImageProChange(product.getImg().getProImageProChange())
                .proPrice(product.getMerPrice().getProPrice())
                .proPoint(product.getMerPrice().getProPoint())
                .proAssemblyCost(product.getMerPrice().getProAssemblyCost())
                .proDiscountRate(product.getMerPrice().getProDiscountRate())
                .proDiscountPrice(product.getMerPrice().getProDiscountPrice())
                .proModifier(product.getProModifier())
                .proQuantity(product.getProQuantity())
                .proInDate(product.getProInDate())
                .proSpec(product.getProSpec())
                .proPurchasesCount(product.getProPurchasesCount())
                .proApprovalStatus(product.getProApprovalStatus())
                .categoryName(product.getCategoryName())
                .proToday(product.getProToday())
                .build();
    }
}

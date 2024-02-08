package com.oz.ozHouse.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.common.Image;
import com.oz.ozHouse.domain.common.ProPrice;

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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merNum")
    private Merchant merchant;
    
    @Embedded
    private Image img;
    
    @Embedded
    private ProPrice merPrice;

    private int proQuantity;
    
    private String proModifier;
    
    @DateTimeFormat(pattern = "yy/MM/dd")
    private LocalDate proInDate;
    
    private String proSpec;
    
    private int proPurchasesCount;
    
    private String proApprovalStatus;
    
    private String categoryName;

    private String proToday;
    
    public void addImages(String primaryImageFileName, List<String> additionalImageFileNames) {
        this.img = new Image();
    }

//    public static Product fromDTO(ProductDTO dto) {
//        return Product.builder()
//                .proNum(dto.getProNum())
//                .proName(dto.getProName())
//                .categoryNum(dto.getCategoryNum())
////                .merNum(dto.getMerchant().getMerNum())
////                .proImg(dto.getImg().getProImg())
////                .proImgPro(dto.getImg().getProImgPro())
//                .proQuantity(dto.getProQuantity())
////                .proPrice(dto.getMerPrice().getProPrice())
//                .proModifier(dto.getProModifier())
////                .proPoint(dto.getMerPrice().getProPoint())
//                .proInDate(dto.getProInDate())
//                .proSpec(dto.getProSpec())
//                .proPurchasesCount(dto.getProPurchasesCount())
//                .proApprovalStatus(dto.getProApprovalStatus())
////                .proAssemblyCost(dto.getMerPrice().getProAssemblyCost())
////                .proDiscountRate(dto.getMerPrice().getProDiscountRate())
////                .proDiscountPrice(dto.getMerPrice().getProDiscountPrice())
//                .categoryName(dto.getCategoryName())
////                .proImageChange(dto.getImg().getProImageChange())
////                .proImageProChange(dto.getImg().getProImageProChange())
////                .encodedImage(dto.getImg().getEncodedImage())
//                .proToday(dto.getProToday())
//                .build();
//    }
//    public ProductDTO toDTO(Product product) {
//        return ProductDTO.builder()
//                .proNum(product.getProNum())
//                .proName(product.getProName())
//                .categoryNum(product.getCategoryNum())
//                .merNum(product.getMerchant().getMerNum())
//                .proImg(product.getImg().getProImg())
//                .proImgPro(product.getImg().getProImgPro())
//                .proQuantity(product.getProQuantity())
//                .proPrice(product.getMerPrice().getProPrice())
//                .proModifier(product.getProModifier())
//                .proPoint(product.getMerPrice().getProPoint())
//                .proInDate(product.getProInDate())
//                .proSpec(product.getProSpec())
//                .proPurchasesCount(product.getProPurchasesCount())
//                .proApprovalStatus(product.getProApprovalStatus())
//                .proAssemblyCost(product.getMerPrice().getProAssemblyCost())
//                .proDiscountRate(product.getMerPrice().getProDiscountRate())
//                .proDiscountPrice(product.getMerPrice().getProDiscountPrice())
//                .categoryName(product.getCategoryName())
//                .proImageChange(product.getImg().getProImageChange())
//                .proImageProChange(product.getImg().getProImageProChange())
//                .encodedImage(product.getImg().getEncodedImage())
//                .proToday(product.getProToday())
//                .build();
//    }
}

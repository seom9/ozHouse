package com.oz.ozHouse.domain;

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
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Product")
@Getter
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

//	public Product(ProductDTO productDTO) {
//	}
}

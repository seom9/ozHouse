package com.oz.ozHouse.dto;

import com.oz.ozHouse.domain.RequestProduct;

public class RequestProductDTO {
	private int productNum;
	private String productName;
	private int categoryNum;
	private String productImage;
	private String productImagePro;
	private int productQuantity;
	private int productPrice;
	private String productModifier;
	private int productPoint;
	private int productDeliveryCharge;
	private int productDiscountRate;
	private int productDiscountPrice;
	private int productAssemblyCost;
	private String productImageChange;
	private String productImageProChange;
	private int merNum;
	private String categoryName;
	private String encodedImage;
	
    public RequestProduct toEntity() {
    	RequestProduct product = new RequestProduct();
        product.setProductNum(this.productNum);
        product.setProductName(this.productName);
        product.setCategoryNum(this.categoryNum);
        product.setProductImage(this.productImage);
        product.setProductImagePro(this.productImagePro);
        product.setProductQuantity(this.productQuantity);
        product.setProductPrice(this.productPrice);
        product.setProductModifier(this.productModifier);
        product.setProductPoint(this.productPoint);
        product.setProductDeliveryCharge(this.productDeliveryCharge);
        product.setProductDiscountRate(this.productDiscountRate);
        product.setProductDiscountPrice(this.productDiscountPrice);
        product.setProductAssemblyCost(this.productAssemblyCost);
        product.setProductImageChange(this.productImageChange);
        product.setProductImageProChange(this.productImageProChange);
        product.setMerNum(this.merNum);
        product.setCategoryName(this.categoryName);
        product.setEncodedImage(this.encodedImage);
        return product;
    }

}

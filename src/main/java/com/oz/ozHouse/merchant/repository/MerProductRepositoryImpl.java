package com.oz.ozHouse.merchant.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor 
public class MerProductRepositoryImpl implements MerProductRepository{

	private final EntityManager em;
	
	//전체 상품 현황
	@Override
	public Long allCount() {
		return em.createQuery("SELECT COUNT(p) FROM Product p", Long.class)
	             .getSingleResult();
	}

//	//승인 대기
//	@Override
//	public int waitCount() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	//승인 보류
//	@Override
//	public int requestCount() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//	//승인 반려
//	@Override
//	public int cancleCount() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	//요청 취소
//	@Override
//	public int requestCancle() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	//판매중
//	@Override
//	public int saleOk() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	

	//상품 등록
//	@Transactional
//	@Override
//	public int insertProduct(Product product) {
//	    String sql = "INSERT INTO Product (categoryName, categoryNum, encodedImage, merNum, "
//	    		+ "proAssemblyCost, proDiscountPrice, "
//	    		+ "proDiscountRate, proImageChange, proImageProChange, "
//	    		+ "proImg, proImgPro, proInDate, proModifier, proName, "
//	    		+ "proPoint, proPrice, proQuantity, proApprovalStatus, "
//	    		+ "proSpec, proToday, "
//	    		+ "proPurchasesCount) "
//	    		+ "VALUES (:categoryName, :categoryNum, 'encodedImage', 1, "
//	    		+ ":proAssemblyCost, :proDiscountPrice, :proDiscountRate, "
//	    		+ "'ImageChange', 'ProChange', :proImg, :proImgPro, "
//	    		+ "CURRENT_DATE, :proModifier, :proName, :proPoint, :proPrice, "
//	    		+ ":proQuantity, 'f', 'normal', 'today', 0,)";
//
//	    Query query = em.createQuery(sql, Integer.class);
//	    // 파라미터 설정 예시
//	    query.setParameter("categoryName", product.getCategoryName());
//	    // 나머지 파라미터 설정...
//
//	    return query.executeUpdate(); // executeUpdate는 영향 받은 행의 수를 반환합니다.
//	}
	
//	@Transactional
//	@Override
//	public void insertProduct(ProductDTO productDTO) {
//	    em.persist(productDTO);
////	    em.flush();
//	}
	
	@Override
    @Transactional
    public void saveProduct(Product product) {
		em.persist(product);
    }

}

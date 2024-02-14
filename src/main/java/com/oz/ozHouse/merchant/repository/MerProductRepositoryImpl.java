package com.oz.ozHouse.merchant.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;
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
    
	//상품 등록
	@Override
	public Product save(Product product) {
	    if (product.getProNum() == 0) { // 새로운 상품인 경우
	        em.persist(product); // 상품 정보 저장
	        return product;
	    } else {
	        return em.merge(product); // 기존 상품 정보 업데이트
	    }
	}

	
	//재고 리스트
	@Override
	public List<ProductDTO> stockList() {
		List<Product> productList = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
	    
	    //엔티티 리스트를 DTO 리스트로 변환
		List<ProductDTO> productDTOList = productList.stream()
				//Product 인스턴스를 ProductDTO로 변환
			    .map(ProductDTO::toDTO) 
			    .collect(Collectors.toList());
	    return productDTOList;
	}

	//재고 리스트 건수
	@Override
	public Long stockListCount(Map<String, Object> params) {
		return em.createQuery("SELECT COUNT(p) FROM Product p", Long.class)
	             .getSingleResult();
	}
//	@Override
//	// 재고 리스트 건수 with dynamic conditions using QueryDSL
//    public Long stockListCount(Map<String, Object> params) {
//        // JPAQueryFactory 초기화
//        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//        QProduct qProduct = QProduct.product;
//        
//        // 기본 쿼리 생성
//        var query = queryFactory
//                .select(qProduct.count())
//                .from(qProduct);
//
//        // spec 조건 처리
//        if (params.containsKey("spec") && params.get("spec") instanceof List) {
//            List<String> specs = (List<String>) params.get("spec");
//            // spec 조건에 따른 동적 쿼리 추가
//            specs.forEach(spec -> {
//                switch (spec) {
//                    case "todays":
//                        query.where(qProduct.productToday.ne("0"));
//                        break;
//                    case "best":
//                        query.where(qProduct.productSpec.eq("best"));
//                        break;
//                    case "normal":
//                        query.where(qProduct.productSpec.eq("normal"));
//                        break;
//                }
//            });
//        }
//
//        // stock 조건 처리
//        if (params.containsKey("stock")) {
//            String stock = (String) params.get("stock");
//            switch (stock) {
//                case "out":
//                    query.where(qProduct.productQuantity.eq(0));
//                    break;
//                case "almost_out":
//                    query.where(qProduct.productQuantity.between(1, 5));
//                    break;
//                case "good":
//                    query.where(qProduct.productQuantity.gt(5));
//                    break;
//            }
//        }
//
//        // search 조건 처리
//        if (params.containsKey("search") && params.containsKey("searchString")) {
//            String search = (String) params.get("search");
//            String searchString = (String) params.get("searchString");
//            if (!searchString.isEmpty()) {
//                switch (search) {
//                    case "all":
//                        query.where(qProduct.productNum.like("%" + searchString + "%")
//                                .or(qProduct.productName.like("%" + searchString + "%")));
//                        break;
//                    case "product_num":
//                        query.where(qProduct.productNum.like("%" + searchString + "%"));
//                        break;
//                    case "product_name":
//                        query.where(qProduct.productName.like("%" + searchString + "%"));
//                        break;
//                    // category_name 처리는 관련 필드가 Product 엔티티에 있어야 합니다.
//                    // 예시: query.where(qProduct.category.name.like("%" + searchString + "%"));
//                }
//            }
//        }
//
//        return query.fetchOne();
//    }
//	@Override
//    public Long stockListCount(Map<String, Object> params) {
//        QProduct qProduct = QProduct.product;
//
//        var query = queryFactory.selectFrom(qProduct);
//
//        // Dynamic conditions
//        if (params.containsKey("mer_num")) {
//            Long merNum = (Long) params.get("mer_num");
//            query.where(qProduct.merNum.eq(merNum));
//        }
//
//        // Assuming spec is a List<String>
//        if (params.containsKey("spec")) {
//            List<String> specs = (List<String>) params.get("spec");
//            specs.forEach(spec -> {
//                switch (spec) {
//                    case "todays":
//                        query.where(qProduct.productToday.ne("0"));
//                        break;
//                    case "best":
//                        query.where(qProduct.productSpec.eq("best"));
//                        break;
//                    case "normal":
//                        query.where(qProduct.productSpec.eq("normal"));
//                        break;
//                }
//            });
//        }
//
//        if (params.containsKey("stock")) {
//            String stock = (String) params.get("stock");
//            switch (stock) {
//                case "out":
//                    query.where(qProduct.productQuantity.eq(0));
//                    break;
//                case "almost_out":
//                    query.where(qProduct.productQuantity.between(1, 5));
//                    break;
//                case "good":
//                    query.where(qProduct.productQuantity.gt(5));
//                    break;
//            }
//        }
//
//        if (params.containsKey("searchString")) {
//            String searchString = (String) params.get("searchString");
//            query.where(qProduct.productNum.like("%" + searchString + "%")
//                    .or(qProduct.productName.like("%" + searchString + "%")));
//            // Add additional search conditions as needed
//        }
//
//        return query.fetchCount();
//    }

	//재고 수정


}

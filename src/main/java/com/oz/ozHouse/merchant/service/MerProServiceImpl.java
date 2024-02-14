package com.oz.ozHouse.merchant.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.merchant.repository.MerProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입
public class MerProServiceImpl implements MerProService {

	private final MerProductRepository proRepository;

	//상품 등록
	@Override
	@Transactional
	public String insertProduct(ProductDTO dto) {
		Product pro = new Product(dto);
		proRepository.save(pro);
		return dto.getProName();
	}

	//재고 리스트
	@Override
	public List<ProductDTO> stockList() {
		return proRepository.stockList();
	}

	//재고 리스트 건수
	@Override
	public Long stockListCount(Map<String, Object> params) {
		return proRepository.stockListCount(params);
	}
	
//	@Override
//	public Long stockListCount(Map<String, Object> params) {
//    QProduct product = QProduct.product;
//    QCategory category = QCategory.category;
//    
//    JPAQuery<Long> query = new JPAQuery<>(em);
//    query.from(product)
//         .leftJoin(category).on(product.categoryNum.eq(category.categoryNum));
//
//    // Apply WHERE conditions based on params
//    if (params.containsKey("mer_num")) {
//        query.where(product.merNum.eq((Long) params.get("mer_num")));
//    }
//
//    // Spec conditions
//    if (params.containsKey("spec") && params.get("spec") instanceof List) {
//        List<String> spec = (List<String>) params.get("spec");
//        BooleanExpression specCondition = Expressions.asBoolean(true).isTrue(); // Start with a true predicate
//        for (String item : spec) {
//            switch (item) {
//                case "todays":
//                    specCondition = specCondition.and(product.productToday.ne("0"));
//                    break;
//                case "best":
//                    specCondition = specCondition.and(product.productSpen.eq("best"));
//                    break;
//                case "normal":
//                    specCondition = specCondition.and(product.productSpen.eq("normal"));
//                    break;
//            }
//        }
//        query.where(specCondition);
//    }
//
//    // Stock conditions
//    if (params.containsKey("stock")) {
//        String stock = (String) params.get("stock");
//        switch (stock) {
//            case "out":
//                query.where(product.productQuantity.eq(0));
//                break;
//            case "almost_out":
//                query.where(product.productQuantity.between(1, 5));
//                break;
//            case "good":
//                query.where(product.productQuantity.gt(5));
//                break;
//        }
//    }
//
//    // Search conditions
//    if (params.containsKey("search") && params.containsKey("searchString")) {
//        String search = (String) params.get("search");
//        String searchString = (String) params.get("searchString");
//        BooleanExpression searchCondition = Expressions.asBoolean(true).isTrue(); // Dummy condition
//        switch (search) {
//            case "all":
//                searchCondition = product.productNum.like("%" + searchString + "%")
//                                   .or(product.productName.like("%" + searchString + "%"))
//                                   .or(category.categoryName.like("%" + searchString + "%"));
//                break;
//            case "product_num":
//                searchCondition = product.productNum.like("%" + searchString + "%");
//                break;
//            case "product_name":
//                searchCondition = product.productName.like("%" + searchString + "%");
//                break;
//            case "category_name":
//                searchCondition = category.categoryName.like("%" + searchString + "%");
//                break;
//        }
//        query.where(searchCondition);
//    }
//
//    return query.select(product.count()).fetchOne();
//}
	
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
}


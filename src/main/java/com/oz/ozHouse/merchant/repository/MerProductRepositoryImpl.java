package com.oz.ozHouse.merchant.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MerProductRepositoryImpl implements MerProductRepository {

	private final EntityManager em;

	// 전체 상품 현황
	@Override
	public Long allCount() {
		return em.createQuery("SELECT COUNT(p) FROM Product p", Long.class).getSingleResult();
	}

	// 상품 등록
	@Override
	public Product save(Product product) {
		if (product.getProNum() == 0) { // 새로운 상품인 경우
			em.persist(product); // 상품 정보 저장
			return product;
		} else {
			return em.merge(product); // 기존 상품 정보 업데이트
		}
	}

	// 재고 리스트
	@Override
	public List<ProductDTO> stockList(Map<String, Object> params) {
		StringBuilder jpql = new StringBuilder("SELECT p FROM Product p ");

		List<String> conditions = new ArrayList<>();

		if (params.containsKey("stock")) {
			String stockStatus = (String) params.get("stock");
			switch (stockStatus) {
			case "out":
				conditions.add("p.proQuantity = 0");
				break;
			case "almost_out":
				conditions.add("p.proQuantity > 0 AND p.proQuantity <= 5");
				break;
			case "good":
				conditions.add("p.proQuantity > 5");
				break;
			}
		}

		if (params.containsKey("spec")) {
			List<String> specs = (List<String>) params.get("spec");
			if (!specs.isEmpty()) {
				String specCondition = specs.stream().map(spec -> {
					switch (spec) {
					case "todays":
						return "p.proToday != '0'";
					case "best":
						return "p.proSpec = 'best'";
					case "normal":
						return "p.proSpec = 'normal'";
					default:
						return null;
					}
				}).filter(Objects::nonNull).collect(Collectors.joining(" OR "));
				if (!specCondition.isEmpty()) {
					conditions.add("(" + specCondition + ")");
				}
			}
		}

		if (params.containsKey("search") && params.containsKey("searchString")
				&& !((String) params.get("searchString")).isEmpty()) {
			String searchType = (String) params.get("search");
			String searchString = "%" + params.get("searchString") + "%";
			switch (searchType) {
			case "all" : 
				conditions.add("CAST(p.proNum AS string) LIKE :searchString "
						+ "OR "
						+ "p.proName LIKE :searchString "
						+ "OR "
						+ "p.categoryName LIKE :searchString");
				break;
			case "proNum":
				conditions.add("CAST(p.proNum AS string) LIKE :searchString");
				break;
			case "proName":
				conditions.add("p.proName LIKE :searchString");
				break;
			case "categoryName":
				conditions.add("p.categoryName LIKE :searchString");
				break;
			}
		}

		if (!conditions.isEmpty()) {
			jpql.append("WHERE ").append(String.join(" AND ", conditions));
		}

		TypedQuery<Product> query = em.createQuery(jpql.toString(), Product.class);

		if (params.containsKey("searchString") && !((String) params.get("searchString")).isEmpty()) {
			query.setParameter("searchString", "%" + params.get("searchString") + "%");
		}

		List<Product> productList = query.getResultList();

		return productList.stream().map(ProductDTO::toDTO).collect(Collectors.toList());
	}

	// 재고 리스트 건수
	@Override
	public Long stockListCount(Map<String, Object> params) {
		return em.createQuery("SELECT COUNT(p) FROM Product p", Long.class).getSingleResult();
	}

	// 재고 수정

}

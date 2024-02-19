package com.oz.ozHouse.merchant.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.domain.RequestProduct;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.dto.RequestProductDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MerProductRepositoryImpl implements MerProductRepository {

	private final EntityManager em;

	// 전체 상품 현황
	@Override
	public Long allCount(Integer merNum) {
		return em.createQuery("SELECT COUNT(p) FROM Product p WHERE p.merchant.merNum = :merNum", Long.class)
				.setParameter("merNum", merNum).getSingleResult();
	}

	// 승인 대기 현황
	public Long waitCount(Integer merNum) {
		return em.createQuery(
				"SELECT COUNT(p) FROM Product p WHERE p.proApprovalStatus IN ('f', 'dr', 'ur') AND p.merchant.merNum = :merNum",
				Long.class).setParameter("merNum", merNum).getSingleResult();
	}

	// 승인 보류 현황
	public Long requestCount(Integer merNum) {
		return em.createQuery(
				"SELECT COUNT(p) FROM Product p WHERE p.proApprovalStatus = 're' AND p.merchant.merNum = :merNum",
				Long.class).setParameter("merNum", merNum).getSingleResult();
	}

	// 승인 반려 현황
	public Long cancleCount(Integer merNum) {
		return em.createQuery(
				"SELECT COUNT(p) FROM Product p WHERE p.proApprovalStatus = 'ca' AND p.merchant.merNum = :merNum",
				Long.class).setParameter("merNum", merNum).getSingleResult();
	}

	// 요청 취소 현황
	public Long requestCancle(Integer merNum) {
		return em.createQuery(
				"SELECT COUNT(p) FROM Product p WHERE p.proApprovalStatus IN ('fc', 'dc', 'uc') AND p.merchant.merNum = :merNum",
				Long.class).setParameter("merNum", merNum).getSingleResult();
	}

	// 판매중 현황
	public Long saleOk(Integer merNum) {
		return em.createQuery(
				"SELECT COUNT(p) FROM Product p WHERE p.proApprovalStatus = 'ok' AND p.merchant.merNum = :merNum",
				Long.class).setParameter("merNum", merNum).getSingleResult();
	}

	// 상품 상세보기
	@Override
	public Optional<ProductDTO> findByProNum(Integer proNum) {
		try {
			Product product = em.createQuery("SELECT p FROM Product p WHERE p.proNum = :proNum", Product.class)
					.setParameter("proNum", proNum).getSingleResult();
			return Optional.of(ProductDTO.toDTO(product));
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

//	// 수정 상품 상세보기
//	@Override
//	public Optional<RequestProductDTO> findRequestByProNum(Integer proNum) {
//	    return Optional.ofNullable(getreProduct(proNum));
//	}

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

	// 요청 리스트 검색 조건
	public List<String> conditions(Map<String, Object> params) {
		List<String> conditions = new ArrayList<>();

		// 재고 상태 조건
		String stockStatus = (String) params.getOrDefault("stock", "");
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

		String approvalStatus = (String) params.get("proApprovalStatus");
		if (approvalStatus != null && !approvalStatus.equals("all")) {
			switch (approvalStatus) {
			case "approval_cancle":
				conditions.add("p.proApprovalStatus IN ('fc', 'dc', 'uc')");
				break;
			case "approval_wait":
				conditions.add("p.proApprovalStatus IN ('f', 'dr', 'ur')");
				break;
			case "approval_pend":
				conditions.add("p.proApprovalStatus = 're'");
				break;
			case "approval_consideration":
				conditions.add("p.proApprovalStatus = 'ca'");
				break;
			case "approval_ok":
				conditions.add("p.proApprovalStatus = 'ro'");
				break;
			case "approved":
				conditions.add("p.proApprovalStatus = 'ok'");
				break;
			}
		}

		// Date Range Condition
		if (params.get("startDate") != null && params.get("endDate") != null && !params.get("startDate").equals("")
				&& !params.get("endDate").equals("")) {
			conditions.add("p.proInDate BETWEEN '" + params.get("startDate") + "' AND '" + params.get("endDate") + "'");
		}

		// 검색 조건
		if (params.containsKey("search") && params.containsKey("searchString")
				&& !((String) params.get("searchString")).isEmpty()) {
			String searchType = (String) params.get("search");
			String searchString = "%" + params.get("searchString") + "%";
			// "전체" 검색 조건일 경우, 모든 상품 필드를 대상으로 검색
			if ("all".equals(searchType)) {
				conditions.add(
						"(CAST(p.proNum AS string) LIKE :searchString OR p.proName LIKE :searchString OR p.categoryName LIKE :searchString)");
			} else {
				// 특정 필드에 대한 검색 조건 처리
				String fieldCondition = switch (searchType) {
				case "proNum" -> "CAST(p.proNum AS string) LIKE :searchString";
				case "proName" -> "p.proName LIKE :searchString";
				case "categoryName" -> "p.categoryName LIKE :searchString";
				default -> ""; // 기본값 설정, 유효하지 않은 검색 유형에 대한 처리
				};
				if (!fieldCondition.isEmpty()) {
					conditions.add(fieldCondition);
				}
			}
		}

		return conditions;
	}

	// 조회 리스트
	@Override
	public List<ProductDTO> listProduct(Map<String, Object> params) {
		StringBuilder jpql = new StringBuilder("SELECT p FROM Product p WHERE p.merchant.merNum = :merNum");
		List<String> conditions = conditions(params);

		if (!conditions.isEmpty()) {
			jpql.append(" AND ").append(String.join(" AND ", conditions));
		}

		TypedQuery<Product> query = em.createQuery(jpql.toString(), Product.class).setParameter("merNum",
				params.get("merNum"));

		// searchString 파라미터 설정
		if (params.containsKey("searchString") && !((String) params.get("searchString")).isEmpty()) {
			query.setParameter("searchString", "%" + params.get("searchString") + "%");
		}

		List<Product> productList = query.getResultList();
		return productList.stream().map(ProductDTO::toDTO).collect(Collectors.toList());
	}

	// 조회 리스트 건수
	@Override
	public Long listCount(Map<String, Object> params) {
		StringBuilder jpql = new StringBuilder("SELECT COUNT(p) FROM Product p WHERE p.merchant.merNum = :merNum");
		List<String> conditions = conditions(params); // 조건 문자열 리스트를 반환한다고 가정

		// 조건들을 쿼리에 추가
		if (!conditions.isEmpty()) {
			jpql.append(" AND ").append(String.join(" AND ", conditions));
		}

		// 쿼리 생성시 반환 타입을 Long으로 변경
		TypedQuery<Long> query = em.createQuery(jpql.toString(), Long.class).setParameter("merNum",
				params.get("merNum"));

		// 조건에 따라 :searchString 파라미터 설정
		if (params.containsKey("searchString") && !((String) params.get("searchString")).isEmpty()) {
			query.setParameter("searchString", "%" + params.get("searchString") + "%");
		}

		return query.getSingleResult();
	}

	// 요청 리스트 검색 조건
	public List<String> requestConditions(Map<String, Object> params) {
		List<String> conditions = new ArrayList<>();

		String approvalStatus = (String) params.get("proApprovalStatus");
		if (approvalStatus != null && !approvalStatus.equals("all")) {
			switch (approvalStatus) {
			case "approval_cancle":
				conditions.add("p.proApprovalStatus IN ('fc', 'dc', 'uc')");
				break;
			case "approval_wait":
				conditions.add("p.proApprovalStatus IN ('f', 'dr', 'ur')");
				break;
			case "approval_pend":
				conditions.add("p.proApprovalStatus = 're'");
				break;
			case "approval_consideration":
				conditions.add("p.proApprovalStatus = 'ca'");
				break;
			case "approval_ok":
				conditions.add("p.proApprovalStatus = 'ro'");
				break;
			case "approved":
				conditions.add("p.proApprovalStatus = 'ok'");
				break;
			}
		}

		// Date Range Condition
		if (params.get("startDate") != null && params.get("endDate") != null && !params.get("startDate").equals("")
				&& !params.get("endDate").equals("")) {
			conditions.add("p.proInDate BETWEEN '" + params.get("startDate") + "' AND '" + params.get("endDate") + "'");
		}

		// 검색 조건
		if (params.containsKey("search") && params.containsKey("searchString")
				&& !((String) params.get("searchString")).isEmpty()) {
			String searchType = (String) params.get("search");
			String searchString = "%" + params.get("searchString") + "%";
			// "전체" 검색 조건일 경우, 모든 상품 필드를 대상으로 검색
			if ("all".equals(searchType)) {
				conditions.add(
						"(CAST(p.proNum AS string) LIKE :searchString OR p.proName LIKE :searchString OR p.categoryName LIKE :searchString)");
			} else {
				// 특정 필드에 대한 검색 조건 처리
				String fieldCondition = switch (searchType) {
				case "proNum" -> "CAST(p.proNum AS string) LIKE :searchString";
				case "proName" -> "p.proName LIKE :searchString";
				case "categoryName" -> "p.categoryName LIKE :searchString";
				default -> ""; // 기본값 설정, 유효하지 않은 검색 유형에 대한 처리
				};
				if (!fieldCondition.isEmpty()) {
					conditions.add(fieldCondition);
				}
			}
		}

		return conditions;
	}

	// 요청 리스트
	@Override
	public List<ProductDTO> requestList(Map<String, Object> params) {
		StringBuilder jpql = new StringBuilder("SELECT p FROM Product p WHERE p.merchant.merNum = :merNum");
		List<String> conditions = requestConditions(params);

		if (!conditions.isEmpty()) {
			jpql.append(" AND ").append(String.join(" AND ", conditions));
		}

		TypedQuery<Product> query = em.createQuery(jpql.toString(), Product.class).setParameter("merNum",
				params.get("merNum"));

		// searchString 파라미터 설정
		if (params.containsKey("searchString") && !((String) params.get("searchString")).isEmpty()) {
			query.setParameter("searchString", "%" + params.get("searchString") + "%");
		}

		List<Product> productList = query.getResultList();
		return productList.stream().map(ProductDTO::toDTO).collect(Collectors.toList());
	}

	// 요청 리스트 건수
	@Override
	public Long requestListCount(Map<String, Object> params) {
		StringBuilder jpql = new StringBuilder("SELECT COUNT(p) FROM Product p WHERE p.merchant.merNum = :merNum");
		List<String> conditions = requestConditions(params); // 조건 문자열 리스트를 반환한다고 가정

		// 조건들을 쿼리에 추가
		if (!conditions.isEmpty()) {
			jpql.append(" AND ").append(String.join(" AND ", conditions));
		}

		// 쿼리 생성시 반환 타입을 Long으로 변경
		TypedQuery<Long> query = em.createQuery(jpql.toString(), Long.class).setParameter("merNum",
				params.get("merNum"));

		// 조건에 따라 :searchString 파라미터 설정
		if (params.containsKey("searchString") && !((String) params.get("searchString")).isEmpty()) {
			query.setParameter("searchString", "%" + params.get("searchString") + "%");
		}

		return query.getSingleResult();
	}

	// 재고 리스트 검색 조건
	public List<String> stockConditions(Map<String, Object> params) {
		List<String> conditions = new ArrayList<>();

		// 재고 상태 조건
		String stockStatus = (String) params.getOrDefault("stock", "");
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

		// 상품 구분 조건
		List<?> specs = (List<?>) params.get("spec");
		if (specs != null && !specs.isEmpty()) {
			String specConditions = specs.stream().map(Object::toString).map(spec -> {
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
			if (!specConditions.isEmpty()) {
				conditions.add("(" + specConditions + ")");
			}
		}

		// 검색 조건
		if (params.containsKey("search") && params.containsKey("searchString")
				&& !((String) params.get("searchString")).isEmpty()) {
			String searchType = (String) params.get("search");
			String searchString = "%" + params.get("searchString") + "%";
			// "전체" 검색 조건일 경우, 모든 상품 필드를 대상으로 검색
			if ("all".equals(searchType)) {
				conditions.add(
						"(CAST(p.proNum AS string) LIKE :searchString OR p.proName LIKE :searchString OR p.categoryName LIKE :searchString)");
			} else {
				// 특정 필드에 대한 검색 조건 처리
				String fieldCondition = switch (searchType) {
				case "proNum" -> "CAST(p.proNum AS string) LIKE :searchString";
				case "proName" -> "p.proName LIKE :searchString";
				case "categoryName" -> "p.categoryName LIKE :searchString";
				default -> ""; // 기본값 설정, 유효하지 않은 검색 유형에 대한 처리
				};
				if (!fieldCondition.isEmpty()) {
					conditions.add(fieldCondition);
				}
			}
		}

		return conditions;
	}

	// 재고 리스트
	@Override
	public List<ProductDTO> stockList(Map<String, Object> params) {
		StringBuilder jpql = new StringBuilder("SELECT p FROM Product p WHERE p.merchant.merNum = :merNum");
		List<String> conditions = stockConditions(params);

		if (!conditions.isEmpty()) {
			jpql.append(" AND ").append(String.join(" AND ", conditions));
		}

		TypedQuery<Product> query = em.createQuery(jpql.toString(), Product.class).setParameter("merNum",
				params.get("merNum"));

		// searchString 파라미터 설정
		if (params.containsKey("searchString") && !((String) params.get("searchString")).isEmpty()) {
			query.setParameter("searchString", "%" + params.get("searchString") + "%");
		}

		List<Product> productList = query.getResultList();
		return productList.stream().map(ProductDTO::toDTO).collect(Collectors.toList());
	}

	// 재고 리스트 건수
	@Override
	public Long stockListCount(Map<String, Object> params) {
		StringBuilder jpql = new StringBuilder("SELECT COUNT(p) FROM Product p WHERE p.merchant.merNum = :merNum");
		List<String> conditions = stockConditions(params); // 조건 문자열 리스트를 반환한다고 가정

		// 조건들을 쿼리에 추가
		if (!conditions.isEmpty()) {
			jpql.append(" AND ").append(String.join(" AND ", conditions));
		}

		// 쿼리 생성시 반환 타입을 Long으로 변경
		TypedQuery<Long> query = em.createQuery(jpql.toString(), Long.class).setParameter("merNum",
				params.get("merNum"));

		// 조건에 따라 :searchString 파라미터 설정
		if (params.containsKey("searchString") && !((String) params.get("searchString")).isEmpty()) {
			query.setParameter("searchString", "%" + params.get("searchString") + "%");
		}

		return query.getSingleResult();
	}

	// 재고 수정
	@Override
	public Optional<Product> findById(Integer proNum) {
		return Optional.ofNullable(em.find(Product.class, proNum));
	}

}

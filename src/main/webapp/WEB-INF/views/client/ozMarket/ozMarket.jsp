<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="ozMarketTop.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/ozMarket/ozMarketPro.css" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>ozMarket</title>
</head>
<body>
	<c:if test="${limit eq 9 }">
		<div align="center">
			<h2>중고거래 최근 매물</h2>
		</div>
	</c:if>
	<c:if test="${limit eq 0 }">
		<div align="center">
			<h2>모든 상품 모아보기</h2>
		</div>
	</c:if>

	<c:if test="${limit eq 5 }">
		<div align="center">
			<h2>검색 결과</h2>
		</div>
	</c:if>
	<c:if test="${empty listProduct}">
		<div class="center-text">검색 결과가 없습니다.</div>
	</c:if>
	<div class="grid-container">
		<c:forEach var="product" items="${listProduct}" varStatus="status">
			<div class="grid-item">
				<c:if test="${not empty product.encodedImage}">
					<a
						href="${pageContext.request.contextPath}/ozMarket/my-product/${product.proNum}">
						<img src="data:image/jpeg;base64,${product.encodedImage}"
						alt="${product.proTitle}" class="product-image">
					</a>
				</c:if>
				<div class="product-title">
					<a
						href="${pageContext.request.contextPath}/ozMarket/my-product/${product.proNum}">${product.proTitle}</a>
				</div>
				<div class="product-price">
					<fmt:formatNumber value="${product.proPrice}" pattern="###,###" />
					원
				</div>
				<div class="product-status">${product.proApprovalStatus }</div>
			</div>
		</c:forEach>
	</div>
	<c:if test="${limit eq 9 }">
		<div class="center">
			<a href="${pageContext.request.contextPath}/ozMarket/products">상품
				더 보기</a>
		</div>
	</c:if>
		<%@ include file="../main/bottom.jsp"%>
</body>
</html>

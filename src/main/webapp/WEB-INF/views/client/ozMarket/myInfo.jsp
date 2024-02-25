<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="ozMarketTop.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>My Info</title>
</head>
<body>
	<div class="user-info">
		<div class="user-avatar">
			<c:choose>
				<c:when test="${empty member.memberImage}">
					<img
						src="https://image.ohou.se/i/bucketplace-v2-development/uploads/default_images/avatar.png?gif=1&w=144&h=144&c=c&webp=1"
						alt="User Avatar">
				</c:when>
				<c:otherwise>
					<img src="${member.memberImage}" alt="User Avatar">
				</c:otherwise>
			</c:choose>
		</div>
		<div class="memberNickname">${nickname}</div>
		<div>판매중</div>
		<c:choose>
			<c:when test="${not empty sellingProducts}">
				<div class="grid-item">
					<c:forEach items="${sellingProducts}" var="product">
						<div>${product.proTitle }</div>
						<a
							href="${pageContext.request.contextPath}/ozMarket/my-product/${product.proNum}">
							<c:if test="${not empty product.encodedImage}">
								<img src="data:image/jpeg;base64,${product.encodedImage}"
									alt="${product.proTitle}" class="product-image">
							</c:if>
						</a>
					</c:forEach>
				</div>
			</c:when>
			<c:otherwise>
				<div class="center-text">판매중인 상품이 없습니다.</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div>구매내역</div>
	<c:choose>
		<c:when test="${not empty boughtProducts}">
			<div class="grid-item">
				<c:forEach items="${boughtProducts}" var="buyproduct">
					<a
						href="${pageContext.request.contextPath}/ozMarket/my-product/${buyproduct.proNum}">
						<c:if test="${not empty buyproduct.encodedImage}">
							<img src="data:image/jpeg;base64,${buyproduct.encodedImage}"
								alt="${buyproduct.proTitle}" class="product-image">
						</c:if>
					</a>
				</c:forEach>
			</div>
		</c:when>
		<c:otherwise>
			<div class="center-text">구매한 상품이 없습니다.</div>
		</c:otherwise>
	</c:choose>

	</div>
	<div>판매내역</div>
	<c:choose>
		<c:when test="${not empty soldProducts}">
			<div class="grid-item">
				<c:forEach items="${soldProducts}" var="sellproduct">
					<a
						href="${pageContext.request.contextPath}/ozMarket/my-product/${sellproduct.proNum}">
						<c:if test="${not empty sellproduct.encodedImage}">
							<img src="data:image/jpeg;base64,${sellproduct.encodedImage}"
								alt="${sellproduct.proTitle}" class="product-image">
						</c:if>
					</a>
				</c:forEach>
			</div>
		</c:when>
		<c:otherwise>
			<div class="center-text">판매한 상품이 없습니다.</div>
		</c:otherwise>
	</c:choose>

	</div>
</body>
</html>
	<%@ include file="../main/bottom.jsp"%>

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
		<h3>판매중</h3>
		<c:choose>
			<c:when test="${not empty sellingProducts}">
				<div class="grid-item">
					<c:forEach items="${sellingProducts}" var="sellingProducts">
						<div>${sellingProducts.proTitle }</div>
						<a
							href="${pageContext.request.contextPath}/ozMarket/my-product/${sellingProducts.proNum}">
							<c:if test="${not empty sellingProducts.encodedImage}">
								<img
									src="data:image/jpeg;base64,${sellingProducts.encodedImage}"
									alt="${sellingProducts.proTitle}" width="60" height="60"
									class="product-image">
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
	<h3>구매내역</h3>
	<c:choose>
		<c:when test="${not empty boughtProducts}">
			<div class="grid-item">
				<c:forEach items="${boughtProducts}" var="boughtProducts">
					<div>${boughtProducts.proTitle }</div>
					<a
						href="${pageContext.request.contextPath}/ozMarket/my-product/${boughtProducts.proNum}">
						<c:if test="${not empty boughtProducts.encodedImage}">
							<img src="data:image/jpeg;base64,${boughtProducts.encodedImage}"
								alt="${boughtProducts.proTitle}" width="60" height="60"
								class="product-image">
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
	<h3>판매내역</h3>
	<c:choose>
		<c:when test="${not empty soldProducts}">
			<div class="grid-item">
				<c:forEach items="${soldProducts}" var="soldProducts">
					<div>${soldProducts.proTitle }</div>

					<a
						href="${pageContext.request.contextPath}/ozMarket/my-product/${soldProducts.proNum}">
						<c:if test="${not empty soldProducts.encodedImage}">
							<img src="data:image/jpeg;base64,${soldProducts.encodedImage}"
								alt="${soldProducts.proTitle}" width="60" height="60"
								class="product-image">
						</c:if>
					</a>
				</c:forEach>
			</div>
		</c:when>
		<c:otherwise>
			<div class="center-text">판매한 상품이 없습니다.</div>
		</c:otherwise>
	</c:choose>
	<h3>예약중내역</h3>
	<c:choose>
		<c:when test="${not empty reservationProducts}">
			<div class="grid-item">
				<c:forEach items="${reservationProducts}" var="reservationProducts">
					<div>${reservationProducts.proTitle }</div>

					<a
						href="${pageContext.request.contextPath}/ozMarket/my-product/${reservationProducts.proNum}">
						<c:if test="${not empty reservationProducts.encodedImage}">
							<img
								src="data:image/jpeg;base64,${reservationProducts.encodedImage}"
								alt="${reservationProducts.proTitle}" width="60" height="60"
								class="product-image">
						</c:if>
					</a>
				</c:forEach>
			</div>
		</c:when>
		<c:otherwise>
			<div class="center-text">예약한 상품이 없습니다.</div>
		</c:otherwise>
	</c:choose>

	</div>
</body>
</html>
<%@ include file="../main/bottom.jsp"%>

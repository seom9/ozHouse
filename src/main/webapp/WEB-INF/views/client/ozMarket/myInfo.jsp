<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="ozMarketTop.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/ozMarket/myInfo.css" />
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
	</div>
	<h3>판매중</h3>
	<div class="grid-container">
		<c:choose>
			<c:when test="${not empty sellingProducts}">
				<c:forEach items="${sellingProducts}" var="sellingProducts">
					<div class="product-container">
						<a
							href="${pageContext.request.contextPath}/ozMarket/my-product/${sellingProducts.proNum}">
							<c:set var="proImgPro"
								value="${fn:split(sellingProducts.proImgPro, ',')}" /> <img
							class="image" src="${proImgPro[0]}" width="60" height="60">
						</a>
						<div>${sellingProducts.proTitle}</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="center-text">판매중인 상품이 없습니다.</div>
			</c:otherwise>
		</c:choose>
	</div>
	<h3>구매내역</h3>
	<div class="grid-container">
		<c:choose>
			<c:when test="${not empty boughtProducts}">
				<c:forEach items="${boughtProducts}" var="boughtProducts">
					<div class="product-container">
						<a
							href="${pageContext.request.contextPath}/ozMarket/my-product/${boughtProducts.proNum}">
							<c:set var="proImgPro"
								value="${fn:split(boughtProducts.proImgPro, ',')}" /> <img
							class="image" src="${proImgPro[0]}" width="60" height="60">
						</a>
						<div>${boughtProducts.proTitle }</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="center-text">구매한 상품이 없습니다.</div>
			</c:otherwise>
		</c:choose>
	</div>
	<h3>판매내역</h3>
	<div class="grid-container">
		<c:choose>
			<c:when test="${not empty soldProducts}">
				<c:forEach items="${soldProducts}" var="soldProducts">
					<div class="product-container">
						<a
							href="${pageContext.request.contextPath}/ozMarket/my-product/${soldProducts.proNum}">
							<c:set var="proImgPro"
								value="${fn:split(soldProducts.proImgPro, ',')}" /> <img
							class="image" src="${proImgPro[0]}" width="60" height="60">
						</a>
						<div>${soldProducts.proTitle }</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="center-text">판매한 상품이 없습니다.</div>
			</c:otherwise>
		</c:choose>
		</div>
		<h3>예약중내역</h3>
		<div class="grid-container">
			<c:choose>
				<c:when test="${not empty reservationProducts}">
						<c:forEach items="${reservationProducts}"
							var="reservationProducts">
							<div class="product-container">
								<a
									href="${pageContext.request.contextPath}/ozMarket/my-product/${reservationProducts.proNum}">
									<c:set var="proImgPro"
										value="${fn:split(reservationProducts.proImgPro, ',')}" /> <img
									class="image" src="${proImgPro[0]}" width="60" height="60">
								</a>
								<div>${reservationProducts.proTitle }</div>
							</div>
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

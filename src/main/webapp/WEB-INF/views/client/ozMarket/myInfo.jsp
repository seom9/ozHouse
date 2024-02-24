<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<div class="grid-item">
			<c:forEach var="myproduct" items="${myProduct}" varStatus="status">
				<c:if test="${not empty myproduct.encodedImage}">
					<a
						href="${pageContext.request.contextPath}/ozMarket/my-product/${myproduct.proNum}">
						<img src="data:image/jpeg;base64,${product.encodedImage}"
						alt="${myproduct.proTitle}" class="product-image">
					</a>
				</c:if>
			</c:forEach>
			<div>구매내역</div>
			<div class="grid-item">
				<c:forEach var="buyproduct" items="${buyProduct}" varStatus="status">
					<c:if test="${not empty buyproduct.encodedImage}">
						<a
							href="${pageContext.request.contextPath}/ozMarket/my-product/${buyproduct.proNum}">
							<img src="data:image/jpeg;base64,${buyproduct.encodedImage}"
							alt="${buyproduct.proTitle}" class="product-image">
						</a>
					</c:if>
				</c:forEach>
				<div>판매내역</div>
				<div class="grid-item">
					<c:forEach var="sellproduct" items="${sellProduct}"
						varStatus="status">
						<c:if test="${not empty sellproduct.encodedImage}">
							<a
								href="${pageContext.request.contextPath}/ozMarket/my-product/${sellproduct.proNum}">
								<img src="data:image/jpeg;base64,${sellproduct.encodedImage}"
								alt="${sellproduct.proTitle}" class="product-image">
							</a>
						</c:if>
					</c:forEach>
</body>
</html>
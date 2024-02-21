<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="ozMarketTop.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>OZ의 집 : 상품상세보기</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/client/ozMarket_css/ozMarket.css" />
</head>
<body>
	<div class="container">
		<div class="content-container">
			<h1 class="stock-header">상품 상세보기</h1>
			<div class="form-container">
				<div class="section-header">
					<h2>기본 정보</h2>
				</div>
				<div class="form-section">
					<div class="form-group">
						<label for="proTitle">상품명</label>
						<div>${getProduct.proTitle}</div>
					</div>
					<div class="form-group">
						<label for="proTitle">판매자</label>
						<div>${getProduct.memberNickname}</div>
					</div>
					<div class="form-group">
						<label>상품금액</label>
						<div class="price-inputs">
							<div>
								대표가 :
								<fmt:formatNumber value="${getProduct.proPrice}"
									pattern="###,###" />
								원
							</div>
						</div>
					</div>
				</div>
				<div class="section-header">
					<h2>이미지</h2>
				</div>
				<div class="form-section">
					<div class="form-group">
						<label>상세이미지</label>
						<div>
							<c:forEach var="encodedImagePro" items="${encodedImagesPro}">
								<img src="data:image/png;base64,${encodedImagePro}" width="800"
									height="800">
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="button-container">
				<input type="button" class="list-button" value="목록보기"
					onclick="window.location='${pageContext.request.contextPath}/ozMarket'">
			</div>
			<div class="button-container">
    <form action="${pageContext.request.contextPath}/ozMarket/ws/chatt" method="post">
        <input type="hidden" name="proNum" value="${getProduct.proNum}" />
        <input type="hidden" name="memberNickname" value="${getProduct.memberNickname}" />
        <input type="submit" value="채팅하기" class="list-button"/>
    </form>
</div>
		</div>
	</div>
</body>
</html>

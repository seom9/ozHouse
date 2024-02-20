<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="ozMarketTop.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/client/ozMarket_css/ozMarket.css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<title>ozMarket</title>
</head>
<div align="center">
	<h2>중고거래 최근 매물</h2>
</div>
<div>
	<c:forEach var="product" items="${listProduct}">
    <div>
        <c:if test="${not empty product.encodedImage}">
            <img src="data:image/jpeg;base64,${product.encodedImage}" width="250" height="250" alt="${product.proTitle}" class="css-gnpvt2">
        </c:if>
        <div>
            <a href="${pageContext.request.contextPath}/ozMarket/my-product/${product.proNum}">${product.proTitle}</a>
        </div>
        <div>
            <fmt:formatNumber value="${product.proPrice}" pattern="###,###"/>원
        </div>
    </div>
</c:forEach>
</div>
<%@ include file="../main/bottom.jsp"%>
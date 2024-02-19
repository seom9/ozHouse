<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="ozMarketTop.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/ozMarket_css/ozMarket.css"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>ozMarket</title>
</head>
<div>
	중고거래 인기매물
</div>
<div>
	<c:forEach var="dto" items="${requestListProduct}">
		<c:if test="${not empty dto.encodedImage}">
			<img src="data:image/jpeg;base64,${dto.encodedImage}" width="40"
				height="40">
		</c:if>
		<c:if test="${empty dto.encodedImage}">
			<span>No image</span>
		</c:if>
	</c:forEach>
</div>
<%@ include file="../main/bottom.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/top.css">
<!-- 주문배송 top -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>OZ의 집 : 배송관리</title>
</head>
<body>
	<div class="tab-container">
	<c:set var="merNum" value="${merLoginMember.merNum}"/>
		<a
			href="${pageContext.request.contextPath}/merchant/${merNum}/store/orders?mode=all"
			class="tab-link">전체 배송 주문</a> <a
			href="${pageContext.request.contextPath}/merchant/${merNum}/store/orders?mode=ready"
			class="tab-link">배송 준비 주문</a> <a
			href="${pageContext.request.contextPath}/merchant/${merNum}/store/orders?mode=delivery"
			class="tab-link">배송 중인 주문</a> <a
			href="${pageContext.request.contextPath}/merchant/${merNum}/store/orders?mode=complete"
			class="tab-link">배송 완료 주문</a>
	</div>
</body>
</html>

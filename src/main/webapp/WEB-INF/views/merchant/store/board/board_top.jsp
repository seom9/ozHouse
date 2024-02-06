<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 게시판 top -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/top.css">
<html>
<body>
	<c:set var="merNum" value="${merchantLoginMember.merNum}" />
	<div class="tab-container">
		<a href="${pageContext.request.contextPath}/merchants/proQAs"
			class="tab-link">상품 문의</a> <a
			href="${pageContext.request.contextPath}/merchants/orderQAs"
			class="tab-link">주문 문의</a> <a
			href="${pageContext.request.contextPath}/merchants/reviews"
			class="tab-link">구매 후기</a>
	</div>
	<!-- 
	<div class="tab-container">
		<a
			href="${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/proQAs"
			class="tab-link">상품 문의</a> <a
			href="${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/orderQAs"
			class="tab-link">주문 문의</a> <a
			href="${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/reviews"
			class="tab-link">구매 후기</a>
	</div>
	-->
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 쿠폰관리 top -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/top.css">
<html>
<body>
	<div class="tab-container">
		<a href="${pageContext.request.contextPath}/merchants/coupon-input"
			class="tab-link">쿠폰 등록</a> <a
			href="${pageContext.request.contextPath}/merchants//coupons"
			class="tab-link">쿠폰 현황</a>
	</div>
	<!-- 
<div class="tab-container">
	<a href="${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/coupon-input" class="tab-link">쿠폰 등록</a> 
	<a href="${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/coupons">쿠폰 현황</a>
</div>
 -->
</body>
</html>
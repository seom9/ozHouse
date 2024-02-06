<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 환불/교환 top -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/top.css">
<html>
<body>
	<div class="tab-container">
		<a href="${pageContext.request.contextPath}/merchants/returns"
			class="tab-link">환불 리스트</a> <a
			href="${pageContext.request.contextPath}/merchants/exchange"
			class="tab-link">교환 리스트</a>
	</div>
</body>
<!-- 
<body>
	<div class="tab-container">
		<a href="${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/returns" class="tab-link">환불 리스트</a> 
		<a href="${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/exchange" class="tab-link">교환 리스트</a>
	</div>
</body>
 -->
</html>
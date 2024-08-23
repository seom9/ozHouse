<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 스토어관리 메인 top -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/top.css">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,700|Montserrat:400,700&display=swap"
	rel="stylesheet">
<html>
<head>
<style>
.partner-center {
	margin-left: 10px;
}

header img.oz-logo {
	width: 100px;
	height: 50px;
}
</style>
<script type="text/javascript">
		function logout(){
			if(window.confirm("로그아웃 하시겠습니까?")){
				location.href = "${pageContext.request.contextPath}/merchant/login/logout";
			}
		}
	</script>
</head>
<body>

	<header>
		<a href="${pageContext.request.contextPath}/merchant/home"> <img
			src="/merchant/img/ozlogo3.png" width="100" height="100"> <img
			src="/merchant/img/oz3.png" class="oz-logo">
		</a> <a href="#"> <span class="partner-center">스토어관리</span>
		</a>
		<div class="logout-container">
			<a href="${pageContext.request.contextPath}/main" class="main-button">OZ의집
				가기</a> <a href="javascript:logout()" class="logout-button">로그아웃</a>
		</div>
	</header>
	<div class="tab-navigation">
	<c:set var="merNum" value="${merLoginMember.merNum}" />
		<a href="${pageContext.request.contextPath}/merchant/${merNum}/store/storeHome"
			class="tab-link">관리홈</a> 
		<a href="${pageContext.request.contextPath}/merchant/${merNum}/store/products"
			class="tab-link">상품관리</a> 
		<a href="${pageContext.request.contextPath}/merchant/${merNum}/store/orders?mode=all"
			class="tab-link">정상주문관리</a>
		<a href="${pageContext.request.contextPath}/merchant/${merNum}/store/returns"
			class="tab-link">환불주문관리</a>  
		<a href="${pageContext.request.contextPath}/merchant/proQAs"
			class="tab-link">문의/후기</a>
		<a href="${pageContext.request.contextPath}/merchant/${merNum}/store/coupons"
			class="tab-link">쿠폰관리</a> 
		<a href="${pageContext.request.contextPath}/merchant/${merNum}/store/sales?mode=day"
			class="tab-link">매출관리</a>
	</div>
	
	<script>
document.addEventListener('DOMContentLoaded', function () {
    const tabs = document.querySelectorAll('.tab-link');
    tabs.forEach(tab => {
        tab.addEventListener('click', function () {
            tabs.forEach(t => t.classList.remove('active-tab'));
            this.classList.add('active-tab');
        });
    });
});
</script>
</body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 메인 top -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/styleMain.css">
<!DOCTYPE html>
<html>
<head>
<title>OZ의 집 : 파트너 센터</title>
<script type="text/javascript">
	function logout() {
		if (window.confirm("로그아웃 하시겠습니까?")) {
			location.href = "${pageContext.request.contextPath}/merchant/login/logout";
		}
	}
</script>
</head>
<body>
	<header>
		<div class="header-left">
			<a href="${pageContext.request.contextPath}/merchant/home"> <img
				src="/merchant/img/ozlogo2.png" width="60" height="60"> <img
				src="/merchant/img/oz2.png" width="90" height="50"> <span
				class="partner-center"><b>파트너센터</b></span>
			</a>
		</div>
		<div class="header-right">
			<nav>
				<c:if test="${empty merchantLoginMember.merNum}">
					<a href="${pageContext.request.contextPath}/merchant/login">로그인</a>
					<a href="${pageContext.request.contextPath}/merchant/login/join">회원가입</a>
				</c:if>
				<c:if test="${not empty merchantLoginMember.merNum}">
					<a href="javascript:logout()">로그아웃</a>
				</c:if>
			</nav>
		</div>
	</header>
	<c:set var="merNum" value="${merchantLoginMember.merNum}" />
	<div class="container">
		<div class="link-section">
			<div class="left-section">
				<a href="${pageContext.request.contextPath}/merchant/store/storeHome"
					class="main-button">스토어관리 돌아가기</a>
			</div>
			<div class="right-section">
				<a
					href="${pageContext.request.contextPath}/brands/${merNum}/applications">입점하기</a>
				<a href="${pageContext.request.contextPath}/merchant/home/notices">공지사항</a>
				<c:if test="${not empty merchantLoginMember.merNum}">
					<a
						href="${pageContext.request.contextPath}/merchant/${merNum}/info">나의정보</a>
				</c:if>
			</div>
		</div>
	</div>
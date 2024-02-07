<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 매출관리 top -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/top.css">
<html>
<body>
	<div class="tab-container">
		<c:set var="merNum" value="${merchantLoginMember.merNum}" />
		<a href="${pageContext.request.contextPath}/merchants/sales?mode=day"
			class="tab-link">일별 조회</a> <a
			href="${pageContext.request.contextPath}/merchants/sales?mode=month"
			class="tab-link">월별 조회</a> <a
			href="${pageContext.request.contextPath}/merchants/sales?mode=year"
			class="tab-link">연별 조회</a>
	</div>
	<!-- 
<div class="tab-container">
	<c:set var="merNum" value="${merchantLoginMember.merNum}"/>
	<a href="${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/sales?mode=day" class="tab-link">일별 조회</a> 
	<a href="${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/sales?mode=month" class="tab-link">월별 조회</a>
	<a href="${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/sales?mode=year" class="tab-link">연별 조회</a>
</div>
 -->
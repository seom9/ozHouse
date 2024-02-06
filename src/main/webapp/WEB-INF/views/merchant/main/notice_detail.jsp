<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 공지사항 세부사항 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/styleMain.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/noticeStyle.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="mainTop.jsp"%>
<div class="main-notice">
	<ul class="notice-list">
		<li class="notice-item">
			<h2 class="notice-title">${noticeDetail.noticeTitle}</h2> <span
			class="notice-date-modify">${noticeDetail.noticeDate}</span>
			<p class="notice-content">${noticeDetail.noticeContent}</p>
		</li>
	</ul>
</div>
<%@ include file="../../client/main/bottom.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 메인 공지사항 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/noticeStyle.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/styleMain.css">
<div class="main-notice">
	<h2>공지사항</h2>
	<hr>
	<ul class="notice-list">
		<c:forEach var="dto" items="${noticeMainList}">
			<li class="notice-item"><span class="notice-title"> <a
					href="${pageContext.request.contextPath}/merchant/home/notice-title/${dto.noticeNum }">
						${dto.noticeTitle} </a>
			</span> <span class="notice-date">${dto.noticeDate}</span></li>
		</c:forEach>
	</ul>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 공지사항 세부사항 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/styleMain.css">
<link rel="stylesheet" type="text/css" href="resources/merchant/css/noticeStyle.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="mainTop.jsp" %>
<div class="main-notice">
    <ul class="notice-list">
        <c:forEach var="dto" items="${noticeDetail}">
            <li class="notice-item">
                <h2 class="notice-title">${dto.notice_title}</h2>
                <span class="notice-date-modify">${dto.notice_date}</span>
                <p class="notice-content">${dto.notice_content}</p>
            </li>
        </c:forEach>
    </ul>
</div>
<%@ include file="mainBottom.jsp" %>
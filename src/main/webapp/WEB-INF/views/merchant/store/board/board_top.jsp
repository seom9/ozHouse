<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 게시판 top -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="resources/merchant/css/top.css">
<html>
<body>
	<c:set var="mer_num" value="${merchantLoginMember.mer_num}"/>
	<div class="tab-container">
		<a href="board_productBoard.do?mer_num=${mer_num}" class="tab-link">상품 문의</a> 
		<a href="board_orderBoard.do?mer_num=${mer_num}" class="tab-link">주문 문의</a>
		<a href="board_orderReview.do?mer_num=${mer_num}" class="tab-link">구매 후기</a>
	</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 리뷰 상세보기 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/board_style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="board_top.jsp" %>
<head>
<title>OZ의 집 : 후기 상세보기</title>
</head>
<div class="container">
	<div class="content-container">
	    <h1 class="board-header">구매 후기</h1>
		<div class="flex-container">
	<c:forEach var="review" items="${reviewContent}">
		<div class="flex-row">
			<div class="flex-cell">작성자</div>
			<div class="flex-cell">${review.member_id}</div>
			<div class="flex-cell">별점</div>
			<div class="flex-cell">${review.review_star}</div>
			<div class="flex-cell">좋아요 수</div>
			<div class="flex-cell">${review.review_like}</div>
			<div class="flex-cell">작성일</div>
			<div class="flex-cell">${review.review_date}</div>
		</div>
		<div class="flex-row">
			<div class="flex-cell">제품명</div>
			<div class="flex-cell">${review.product_name}</div>
		</div>
		<div class="flex-row">
			<div class="flex-cell">이미지</div>
			<div class="flex-cell">${review.review_image }</div>
		</div>
		<div class="flex-row">
			<div class="flex-cell">글내용</div>
			<div class="flex-cell-sub">${review.review_content }</div>
		</div>
		<div class="button-group">
				<input type="button" value="목록 보기" onclick="window.location='board_orderReview.do?mer_num=${merchantLoginMember.mer_num}'">
		</div>
		</c:forEach>
	</div>
</div>
</div>

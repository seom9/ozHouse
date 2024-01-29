<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 상품문의 상세보기 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/board_style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="board_top.jsp" %>
<head>
<title>OZ의 집 : 상품문의 상세보기</title>
<script>
	function answerQuestion(productQANum) {
	    var url = 'product_reqa.do?product_QA_num=' + productQANum;
	    window.location.href = url;
	}
	function requestQuestion(productQANum) {
	    var url = 'product_reqa_update.do?product_reQA_num=' + productQANum;
	    window.location.href = url;
	}
</script>
</head>

<div class="container">
	<div class="content-container">
	    <h1 class="board-header">상품 문의 상세보기</h1>
		<div class="flex-container">
			<c:forEach var="dto" items="${productContent}">
				<form name="f" action="javascript:answerQuestion(${dto.product_QA_num});" method="post">
					<div class="flex-row">
						<div class="flex-cell">글번호</div>
						<div class="flex-cell">${dto.product_QA_num}</div>
						<div class="flex-cell">제품명</div>
						<div class="flex-cell">${dto.product_name}</div>
						<div class="flex-cell">문의 유형</div>
						<div class="flex-cell">${dto.product_inquiry_type}</div>
					</div>
					<div class="flex-row">
						<div class="flex-cell">작성자</div>
						<div class="flex-cell">${dto.member_id}</div>
						<div class="flex-cell">작성일</div>
						<div class="flex-cell">${dto.product_QA_date}</div>
					</div>
					<div class="flex-row">
						<div class="flex-cell">글내용</div>
						<div class="flex-cell-sub">${dto.product_QA_content }</div>
					</div>
					<c:if test="${empty productReContent}">
						<h1 class="board-header">답변되지 않았습니다.</h1>
						<div class="button-group">
						        <input type="submit" value="답변">
						</div>
					</c:if>
				</form>
			</c:forEach>
			<c:if test="${not empty productReContent }">
				<h1 class="board-header">상품 문의 답변보기</h1>
				<div class="flex-container">
					<c:forEach var="redto" items="${productReContent}">
						<form name="f2" action="javascript:requestQuestion(${redto.product_reQA_num});" method="post">
							<div class="flex-row">
								<div class="flex-cell">작성일</div>
								<div class="flex-cell-sub">${redto.product_reQA_date}</div>
							</div>
							<div class="flex-row">
								<div class="flex-cell">글내용</div>
								<div class="flex-cell-sub">${redto.product_reQA_content }</div>
							</div>
							<div class="button-right-align">
							<br>
									<input type="submit" value="수정">
								    <input type="hidden" name="product_reQA_num" value="${redto.product_reQA_num}">
							</div>
						</form>
					</c:forEach>
				</div>
			</c:if>
		</div>
		<div class="button-group">
		<c:set var="mer_num" value="${merchantLoginMember.mer_num}"/>
			<input type="button" value="목록 보기" onclick="window.location='board_productBoard.do?mer_num=${mer_num}'">
		</div>
	</div>
</div>

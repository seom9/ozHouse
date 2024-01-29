<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 주문문의 상세보기 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/board_style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="board_top.jsp" %>
<head>
<title>OZ의 집 : 주문 상세보기</title>
<script>
	function answerQuestion(orderQANum) {
	    var url = 'order_reqa.do?order_QA_num=' + orderQANum;
	    window.location.href = url;
	}
	function requestQuestion(orderQANum) {
	    var url = 'order_reqa_update.do?order_reQA_num=' + orderQANum;
	    window.location.href = url;
	}
</script>
</head>

<div class="container">
	<div class="content-container">
	    <h1 class="board-header">주문 문의 상세보기</h1>
		<div class="flex-container">
			<c:forEach var="dto" items="${orderContent}">
				<form name="f" action="javascript:answerQuestion(${dto.order_QA_num});" method="post">
					<div class="flex-row">
						<div class="flex-cell">글번호</div>
						<div class="flex-cell">${dto.order_QA_num}</div>
						<div class="flex-cell">문의 유형</div>
						<div class="flex-cell">${dto.order_inquiry_type}</div>
					</div>
					<div class="flex-row">
						<div class="flex-cell">작성자</div>
						<div class="flex-cell">${dto.member_id}</div>
						<div class="flex-cell">작성일</div>
						<div class="flex-cell">${dto.order_QA_date}</div>
					</div>
					<div class="flex-row">
						<div class="flex-cell">글내용</div>
						<div class="flex-cell-sub">${fn:replace(dto.order_QA_content, '\\n', '<br>')}</div>
					</div>
					<c:if test="${empty orderReContent}">
						<h1 class="board-header">답변되지 않았습니다.</h1>
						<div class="flex-resub" align="center">
								<input type="submit" value="답변">
							</div>
						</div>
					</c:if>
				</form>
			</c:forEach>
			<c:if test="${not empty orderReContent }">
			    <h1 class="board-header">주문 문의 답변보기</h1>
				<div class="flex-container">
					<c:forEach var="redto" items="${orderReContent}">
						<form name="f2" action="javascript:requestQuestion(${redto.order_reQA_num});" method="post">
							<div class="flex-row">
								<div class="flex-cell">작성일</div>
								<div class="flex-cell-sub">${redto.order_reQA_date}</div>
							</div>
							<div class="flex-row">
								<div class="flex-cell">글내용</div>
								<div class="flex-cell-sub">${redto.order_reQA_content }</div>
							</div>
							<div class="button-right-align">
							<br>
								    <input type="hidden" name="order_reQA_num" value="${redto.order_reQA_num}">
									<input type="submit" value="수정">
								</div>
						</form>
					</c:forEach>
				</div>
			</c:if>
		</div>
		<div class="button-group">
			<c:set var="mer_num" value="${merchantLoginMember.mer_num}"/>
			<input type="button" value="목록 보기" onclick="window.location='board_orderBoard.do?mer_num=${mer_num}'">
		</div>
	</div>
</div>
			
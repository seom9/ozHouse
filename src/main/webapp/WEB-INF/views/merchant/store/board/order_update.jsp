<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 주문문의 답변 수정 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/board_style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../storeMain/storeManagementTop.jsp"%>
<%@ include file="board_top.jsp"%>
<head>
<title>OZ의 집 : 주문 답변 수정</title>
<script>
	function validateForm() {
		var order_reQA_content = document.forms["f"]["order_reQA_content"].value;

		if (order_reQA_content == null || order_reQA_content.trim() === "") {
			alert("내용을 입력해주세요.");
			return false;
		}
		return true;
	}
</script>
</head>

<div class="container">
	<div class="content-container">
		<h1 class="board-header">주문 문의 상세보기</h1>
		<div class="flex-container">
			<c:forEach var="dto" items="${orderContent}">
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
			</c:forEach>
		</div>
	</div>
	<form name="f" action="order_reqa_update.do" method="post"
		onsubmit="return validateForm()">
		<div class="content-container">
			<h1 class="board-header">답변 수정</h1>
			<c:forEach var="redto" items="${orderReContent}">
				<input type="hidden" name="order_reQA_num"
					value="${redto.order_reQA_num}">
				<div class="flex-container">
					<div class="flex-row">
						<div class="flex-cell">내 용</div>
						<div class="flex-cell-sub">
							<textarea name="order_reQA_content" rows="11" cols="40"
								class="box">${redto.order_reQA_content}</textarea>
						</div>
					</div>
					<div class="button-group">
						<input type="submit" value="글수정"> <input type="reset"
							value="다시작성">
						<c:set var="mer_num" value="${merchantLoginMember.mer_num}" />
						<input type="button" value="목록보기"
							onclick="window.location='board_orderBoard.do?mer_num=${mer_num}'">
						<input type="hidden" name="mer_num"
							value="${merchantUpdate.mer_num}">
					</div>
				</div>
			</c:forEach>
		</div>
	</form>
</div>

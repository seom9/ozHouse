<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 상품문의 상세보기 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/board_style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../storeMain/storeManagementTop.jsp"%>
<%@ include file="board_top.jsp"%>
<head>
<title>OZ의 집 : 상품문의 상세보기</title>
<script>
function answerQuestion(productQANum) {
    const url = '${pageContext.request.contextPath}/proReQA/' + productQANum + '/answer`;
    fetch(url, {
        method: 'POST', // 또는 'GET', 'PUT' 등의 적절한 HTTP 메소드 사용
        headers: {
            'Content-Type': 'application/json',
            // 필요한 경우 추가 헤더를 설정
        },
        body: JSON.stringify({
            // 요청과 함께 보낼 데이터, 답변 등록 등의 경우
        }),
    })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error('Error:', error));
}

function requestQuestion(productQANum) {
    const url = '${pageContext.request.contextPath}/proReQA/' + productQANum + '/update';
    fetch(url, {
        method: 'PUT', // 업데이트를 위해 PUT 메소드 사용
        headers: {
            'Content-Type': 'application/json',
            // 필요한 경우 추가 헤더를 설정
        },
        body: JSON.stringify({
            // 요청과 함께 보낼 데이터, 상태 업데이트 등의 경우
        }),
    })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error('Error:', error));
}
</script>
</head>

<div class="container">
	<div class="content-container">
		<h1 class="board-header">상품 문의 상세보기</h1>
		<div class="flex-container">
			<c:forEach var="dto" items="${productContent}">
				<form name="f"
					action="javascript:answerQuestion(${dto.product_QA_num});"
					method="post">
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
						<form name="f2"
							action="javascript:requestQuestion(${redto.product_reQA_num});"
							method="post">
							<div class="flex-row">
								<div class="flex-cell">작성일</div>
								<div class="flex-cell-sub">${redto.product_reQA_date}</div>
							</div>
							<div class="flex-row">
								<div class="flex-cell">글내용</div>
								<div class="flex-cell-sub">${redto.product_reQA_content }</div>
							</div>
							<div class="button-right-align">
								<br> <input type="submit" value="수정"> <input
									type="hidden" name="product_reQA_num"
									value="${redto.product_reQA_num}">
							</div>
						</form>
					</c:forEach>
				</div>
			</c:if>
		</div>
		<div class="button-group">
			<c:set var="merNum" value="${merchantLoginMember.merNum}" />
			<input type="button" value="목록 보기"
				onclick="window.location='${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/proQAs'">
		</div>
	</div>
</div>

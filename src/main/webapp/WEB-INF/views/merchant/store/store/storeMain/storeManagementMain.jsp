<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="resources/merchant/css/style.css">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700|Montserrat:400,700&display=swap" rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 관리홈-->
<%@ include file="storeManagementTop.jsp" %>
<head>
<title>OZ의 집 : 스토어 관리</title>
</head>
<body>
<div align="left">
    <table border="0" height="70%">
        <tr>
            <td colspan="2" width="25%" align="left">
            <br>
                <div class="title no-box-style" align="left">상품등록</div>
                <hr>
                <div class="button-container">
				    <a href="productManagement_input.do?mer_num=${merchantLoginMember.mer_num}" class="button">신규 상품 등록</a>
				</div>
                <br>
				<div class="title no-box-style" align="left">상품현황</div>
                <hr>
               <div class="content">
				    <span>전체</span>
				    <a href="productManagement_requestList.do?mer_num=${merchantLoginMember.mer_num}">
				    <span class="number">
				    	${allCount }건
			    	</span>
			    	</a>
				</div>
				<div class="content">
				    <span>승인대기(검수중)</span>
				    <a href="productManagement_requestList.do?mer_num=${merchantLoginMember.mer_num}">
				    <span class="number">
				    	${waitCount }건
				    </span>
				    </a>
				</div>
				<div class="content">
				    <span>승인보류(수정요청)</span>
				    <a href="productManagement_requestList.do?mer_num=${merchantLoginMember.mer_num}">
				    <span class="number">
				    	${requestCount }건
				    </span>
				    </a>
				</div>
				<div class="content">
				    <span>승인반려(등록불가)</span>
				    <a href="productManagement_requestList.do?mer_num=${merchantLoginMember.mer_num}">
				    <span class="number">
				    	${cancleCount }건
				    </span>
				    </a>
				</div>
				<div class="content">
				    <span>요청취소</span>
				    <a href="productManagement_requestList.do?mer_num=${merchantLoginMember.mer_num}">
				    <span class="number">
				    	${requestCancle }건
				    </span>
				    </a>
				</div>
				<div class="content">
				    <span>판매중</span>
				    <a href="productManagement_requestList.do?mer_num=${merchantLoginMember.mer_num}">
				    <span class="number">
				    	${saleOk }건
				    </span>
				    </a>
				</div>
            </td>
            <td colspan="3" width="50%">
            <br>
                <div class="sales-header">
			    <div class="title no-box-style" align="left">판매진행</div>
			    <span class="subtitle">(판매건수는 SUM단위로 수집됩니다.)</span>
			</div>
				<hr>
				<div class="sales-progress-container">
			    <div class="sales-progress">
			        <div class="progress-item">
			            <span class="stage">배송 준비</span>
			            <a href="deliveryList.do?mer_num=${merchantLoginMember.mer_num}&mode=ready">
			            <span class="count">${readyCount }건</span>
			            </a>
			        </div>
			        <div class="separator">></div>
			        <div class="progress-item">
			            <span class="stage">배송중</span>
			            <a href="deliveryList.do?mer_num=${merchantLoginMember.mer_num}&mode=delivery">
			            <span class="count">${deliveryCount }건</span>
			            </a>
			        </div>
			        <div class="separator">></div>
			        <div class="progress-item">
			            <span class="stage">배송 완료</span>
			            <a href="deliveryList.do?mer_num=${merchantLoginMember.mer_num}&mode=complete">
			            <span class="count">${completeCount }건</span>
			            </a>
			        </div>
			    </div>
			</div>
				<br>
                <div class="title no-box-style" align="left">클래임 관리 및 Q&A 관리</div>
                <hr>
                <div class="content">
			    <div class="content-box">
			        <span  style="font-size: 20px; color: #FFFFFF;">&nbsp;&nbsp;&nbsp;처리해야 할 교환건</span>
			        <hr class="underline-style">
			        <a href="returnCancle_returnList.do?mer_num=${merchantLoginMember.mer_num}&order_orderlike=exchange">
			        <span class="number" style="font-size: 20px;">
			       ${exchangeCount }건</span></a>
			    </div>
			    <div class="content-box">
			        <span style="font-size: 20px; color: #FFFFFF;">&nbsp;&nbsp;&nbsp;처리해야 할 환불건</span>
			        <hr class="underline-style">
			        <a href="returnCancle_returnList.do?mer_num=${merchantLoginMember.mer_num}&order_orderlike=return">
			        <span class="number" style="font-size: 20px;">
			        ${returnCount }건</span></a>
			    </div>
			    <div class="content-box">
			        <span style="font-size: 20px; color: #FFFFFF;">&nbsp;&nbsp;&nbsp;응답해야 할 Q&A</span>
			        <hr class="underline-style">
			        <a href="board_board.do?mer_num=${merchantLoginMember.mer_num}">
			        <span class="number" style="font-size: 20px;">
			        ${boardCount}건</span></a>
			    </div>
			</div>
            </td>
            <td colspan="2" width="25%">
            <br>
                <div class="notice-section">
			    <div class="notice-header">
			        <div class="title no-box-style" align="left">공지사항</div>
			        <a href="notice.do" class="subtitle">더보기 ></a>
			    </div>
			    <hr>
				    <div class="notice-content">
				    <ul class="notice-list">
				        <c:forEach var="dto" items="${noticeTitleList }">
				        <li>
				        	<a href="notice_title.do?notice_num=${dto.notice_num }">
				        		${dto.notice_title }
			        		</a>
			        		</li>
				        </c:forEach>
			        </ul>
				    </div>
				    <div class="button-container">
				    <a href="merchant_main.do" class="button">HOME</a>
				</div>
				</div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
	

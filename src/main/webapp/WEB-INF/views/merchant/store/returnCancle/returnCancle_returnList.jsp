<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 환불/교환 리스트 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/top.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/returnCancle_style.css">
<%@ include file="../storeMain/storeManagementTop.jsp"%>
<%@ include file="returnCancle_top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<title>OZ의 집 : 환불/교환 관리</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
	$(function() { //html화면이 열리면 function함수가 동작 준비를 함 =>$(document).ready(function(){});과 같
		$("#startDate").datepicker(
				{
					changeMonth : true,
					changeYear : true,
					nextText : '다음 달',
					prevText : '이전 달',
					dayNames : [ '일요일', '월요일', '화요일', '수요일', '목요일', '금요일',
							'토요일' ],
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ],
					dateFormat : "y/mm/dd",
					maxDate : 0, //선택 가능한 최소날짜, 0: 오늘 이후 선택 불가
					onClose : function(selectedDate) {
						//시작일(startDate) datepicker가 닫힐때                      
						//종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정                     
						$("#endDate").datepicker("option", "minDate",
								selectedDate);
					}
				});
	});
	$(function() {
		$("#endDate").datepicker(
				{
					changeMonth : true,
					changeYear : true,
					nextText : '다음 달',
					prevText : '이전 달',
					dayNames : [ '일요일', '월요일', '화요일', '수요일', '목요일', '금요일',
							'토요일' ],
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ],
					dateFormat : "y/mm/dd",
					maxDate : 0, //선택 가능한 최소날짜, 0: 오늘 이후 선택 불가
					onClose : function(selectedDate) {
						//시작일(startDate) datepicker가 닫힐때                      
						//종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정                     
						$("#endDate").datepicker("option", "maxDate",
								selectedDate);
					}
				});
	});

	function resetForm() {
		document.f.startDate.value = null;
		document.f.endDate.value = null;
		document.f.order_refund.value = "all";
		document.f.searchString.value = null;
	}
</script>
<script type="text/javascript">
	function checkMore() {
		if (window.confirm("확인을 하시면 취소하실 수 없습니다. 계속 진행하시겠습니까?")) {
			return true;
		}
	}
</script>
</head>
<div class="container">
	<div class="content-container">

		<c:if test="${map.order_orderlike eq 'exchange'}">
			<h1 class="returnCancle-header">교환 리스트</h1>
			<div class="flex-container">
				<div class="flex-item">
					<p class="info-text">
						• 교환 신청내역을 확인한 후 고객과 상담해주세요.<br> • 교환 신청승인은 반드시 물건 상태를 확인하고
						진행해주세요.
					<p class="info-text red-text">
						• 개인정보는 배송 이외의 목적으로 사용을 금하며, 개인정보를 PC에 다운로드하는 경우 반드시 암호화 저장해야 합니다.<br>
						• 교환을 승인하기 전에 물건 수령 및 상태확인, 배송금처리를 하였는지 확인해주세요.<br>
					<p class="info-text">
						• 교환진행절차 : 교환신청 > 교환승인 > 교환완료<br> <br>
					</p>
				</div>
			</div>
		</c:if>
		<c:if test="${map.order_orderlike eq 'return'}">
			<h1 class="returnCancle-header">환불 리스트</h1>
			<div class="flex-container">
				<div class="flex-item">
					<p class="info-text">
						• 환불 신청내역을 확인한 후 고객과 상담해주세요.<br> • 환불 신청승인은 반드시 물건 상태를 확인하고
						진행해주세요.
					<p class="info-text red-text">
						• 개인정보는 배송 이외의 목적으로 사용을 금하며, 개인정보를 PC에 다운로드하는 경우 반드시 암호화 저장해야 합니다.<br>
						• 환불을 승인하기 전에 물건 수령 및 상태확인, 배송금처리를 하였는지 확인해주세요.<br>
					<p class="info-text">
						• 환불진행절차 : 환불신청 > 환불승인 > 환불완료<br> <br>
					</p>
				</div>
			</div>
		</c:if>
		<form name="f"
			action="${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/return-and-exchange/search"
			class="flex-container" method="post">
			<input type="hidden" name="oLike"
				value="${map.oLike}"> 
			<input type="hidden"
				name="merNum" value="${merLoginMember.merNum}">
			<div class="flex-row">
				<c:if test="${map.oLike eq 'return'}">
					<div class="flex-cell header-cell custom-label">환불 신청일</div>
				</c:if>
				<div class="flex-cell input-cell">
					<input type="text" id="startDate" name="startDate"
						value="${map.startDate}"> ~ <input type="text"
						id="endDate" name="endDate" value="${map.endDate}">
				</div>
			</div>
			<div class="flex-row">
				<div class="flex-cell header-cell custom-label">처리여부&nbsp;&nbsp;</div>
				<div class="flex-cell input-cell">
					<input type="radio" name="oRefund" value="all" ${radio == 'all' ? 'checked' : ''}>전체
					<input type="radio" name="oRefund" value="t" ${radio == 't' ? 'checked' : ''}>완료 
					<input type="radio" name="oRefund" value="f" ${radio == 'f' ? 'checked' : ''}>미완료"
				</div>
			</div>
			<div class="flex-row">
				<div class="flex-cell header-cell custom-label">검색&nbsp;&nbsp;&nbsp;&nbsp;</div>
				<div class="flex-cell input-cell">
					<select name="search"> 
						<option value="all" ${search == 'all'?'selected':''}>전체</option>
				 		<option value="memberId" ${search == 'memberId'?'selected':''}>id</option>
				 		<option value="proName" ${search == 'proName'?'selected':''}>상품명</option>
				 		<option value="oNum" ${search == 'oNum'?'selected':''}>주문번호</option>
					</select> <input type="text" name="searchString" value="${map.searchString}">
				</div>
			</div>
			<div class="flex-subrow custom-button-row">
				<div class="button-container">
					<input type="submit" value="검색"> <input type="button"
						value="초기화" onclick="resetForm();">
				</div>
			</div>
		</form>

		<br>
		<div align="left" class="results-heading">
			<font size="3">검색 결과</font>&nbsp;&nbsp;총 ${returnCount} 건
		</div>
		<div class="scroll flex-container content-table">
			<div class="flex-row header-row">
				<div class="flex-cell">주문번호</div>
				<div class="flex-cell">주문자 ID</div>
				<div class="flex-cell">신청일</div>
				<div class="flex-cell">
					상품명<br> 상품 회수지
				</div>
				<div class="flex-cell">
					총 수량<br> 주문액
				</div>
				<div class="flex-cell">상태</div>
				<div class="flex-cell">배송현황</div>
				<div class="flex-cell">확인</div>
			</div>
			<c:if test="${empty orderReturnList}">
				<div class="flex-row">
					<div class="flex-cell" colspan="8">조회결과가 없습니다.</div>
				</div>
			</c:if>
			<c:forEach var="dto" items="${orderReturnList}">
				<div class="flex-row">
					<div class="flex-cell">${dto.order_code}</div>
					<div class="flex-cell">${dto.member_id}</div>
					<div class="flex-cell">${dto.order_canceldate}</div>
					<div class="flex-cell">${dto.orderItems.proName}<br>${dto.place}</div>
					<div class="flex-cell">
						<fmt:formatNumber value="${dto.orderItems.quantity}" type="number"
							pattern="###,###개" />
						<br>
						<fmt:formatNumber value="${dto.orderItems.realPrice}" type="number"
							pattern="###,###원" />
					</div>
					<c:choose>
						<c:when test="${dto.orderRefund eq 't'}">
							<div class="flex-cell">완료</div>
						</c:when>
						<c:otherwise>
							<div class="flex-cell">미완료</div>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${dto.order_delivery_now eq 'ready'}">
							<div class="flex-cell">배송 준비중</div>
						</c:when>
						<c:when test="${dto.order_delivery_now eq 'delivery'}">
							<div class="flex-cell">배송 중</div>
						</c:when>
						<c:otherwise>
							<div class="flex-cell">배송 완료</div>
						</c:otherwise>
					</c:choose>
					<div class="flex-cell">
						<c:choose>
							<c:when test="${dto.orderRefund eq 't'}">
								<input type="button" value="완료" disabled="disabled">
							</c:when>
							<c:otherwise>
								<form name="ff"
									action="${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/return-and-exchange/check"
									method="post" onsubmit="return checkMore();">
									<input type="hidden" name="order_code"
										value="${dto.order_code}"> <input type="hidden"
										name="product_num" value="${dto.product_num}"> <input
										type="hidden" name="order_orderlike"
										value="${map.order_orderlike}"> <input type="hidden"
										name="merNum" value="${merchantLoginMember.merNum}"> <input
										type="submit" id="button-type" value="완료">
								</form>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:forEach>
		</div>
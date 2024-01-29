<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 주문배송 리스트 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/delivery_style.css">
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="delivery_top.jsp" %>
<head>
<title>OZ의 집 : 배송관리</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
 $( function() {  //html화면이 열리면 function함수가 동작 준비를 함 =>$(document).ready(function(){});과 같
   $( "#startDate" ).datepicker({
   	changeMonth: true,
   	changeYear: true,
   	nextText: '다음 달',
   	prevText: '이전 달',
   	dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
   	dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
   	monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
   	monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
   	dateFormat: "y/mm/dd",
   	maxDate: 0, //선택 가능한 최소날짜, 0: 오늘 이후 선택 불가
   	onClose: function( selectedDate ) {                          
	//시작일(startDate) datepicker가 닫힐때                      
	//종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정                     
	$("#endDate").datepicker( "option", "minDate", selectedDate );                 
   	}	
   });
});
 $( function() {
   $( "#endDate" ).datepicker({
   	changeMonth: true,
   	changeYear: true,
   	nextText: '다음 달',
   	prevText: '이전 달',
   	dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
   	dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
   	monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
   	monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
   	dateFormat: "y/mm/dd",
   	maxDate: 0, //선택 가능한 최소날짜, 0: 오늘 이후 선택 불가
   	onClose: function( selectedDate ) {                          
	//시작일(startDate) datepicker가 닫힐때                      
	//종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정                     
	$("#endDate").datepicker( "option", "maxDate", selectedDate );                 
   	}
   });
});
 
 function resetForm(){
	 document.f.startDate.value = null;
	 document.f.endDate.value = null;
	 document.f.searchString.value = null;
 }
 </script>
</head>
<div class="container">
	<div class="content-container">
	<c:if test="${map.mode == 'all'}">
	<h1 class="delivery-header">전체 배송 주문
	<span class="delivery-subtitle">
		배송과 관련된 전체주문을 조회합니다.</span>
	</h1>
	</c:if>
	<c:if test="${map.mode eq 'ready'}">
		<h1 class="delivery-header">배송 준비 주문
		<span class="delivery-subtitle">
			배송과 관련된 미발송주문을 조회합니다.</span>
		</h1>
	</c:if>
	<c:if test="${map.mode eq 'delivery'}">
		<h1 class="delivery-header"> 배송 중인 주문
		<span class="delivery-subtitle">
			배송과 관련된 발송주문을 조회합니다.</span>
		</h1>
	</c:if>
	<c:if test="${map.mode eq 'complete'}">
		<h1 class="delivery-header">배송 완료 주문
		<span class="delivery-subtitle">
			배송과 관련된 완료주문을 조회합니다.</span>
		</h1>
	</c:if>
	<div class="flex-container">
		<div class="flex-item">
		<p class="info-text">
		• 정상주문과 관련된 배송상태를 조회합니다.(환불, 교환의 배송상태는 환불/교환 리스트 확인)<br>
		• 개인정보는 배송 이외의 목적으로 사용이 불가능합니다.<br>
		• 배송절차 : 배송준비 > 배송중 > 배송완료<br><br>
		</p>
		</div>
</div>

<form name="f" action="delivery_listSearch.do" method="post" class="flex-container">
   <input type="hidden" name="mer_num" value="${merchantLoginMember.mer_num}">
   <input type="hidden" name="mode" value="${map.mode}">
    <div class="flex-row">
        <div class="flex-cell header-cell custom-label">주문일</div>
        <div class="flex-cell input-cell">
            <input type="text" id="startDate" name="startDate" value="${map.startDate}"> ~ 
            <input type="text" id="endDate" name="endDate" value="${map.endDate}">
        </div>
    </div>
	<div class="flex-row">
        <div class="flex-cell header-cell custom-label">검색&nbsp;&nbsp;</div>
        <div class="flex-cell input-cell">
			<select name="search">
				${options}
			</select>
			<input type="text" name="searchString" value="${map.searchString}">
		</div>
	</div>
	<div class="flex-subrow custom-button-row">
   				<div class="button-container">
          <input type="submit" value="검색">
          <input type="button" value="초기화" onclick="resetForm();">
      </div>
  </div>
</form>
			<br>
	<div align="left" class="results-heading">
        <font size="3">검색 결과</font>
        <c:if test="${empty deliveryCount}">
        	&nbsp;&nbsp;총 0 건
        </c:if>
        <c:if test="${not empty deliveryCount}">
        	&nbsp;&nbsp;총 ${deliveryCount} 건
        </c:if>
    </div>
	<div class="scroll flex-container content-table">
       <div class="flex-row header-row">
        <div class="flex-cell">주문번호</div>
        <div class="flex-cell">주문자 ID</div>
        <div class="flex-cell">주문일</div>
        <div class="flex-cell">상품명<br>배송지</div>
        <div class="flex-cell">총 수량<br>주문액</div>
        <div class="flex-cell">요청사항</div>
        <div class="flex-cell">배송현황</div>
    </div>
	<c:if test="${empty deliveryList}">
        <div class="flex-row">
            <div class="flex-cell" colspan="7">조회결과가 없습니다.</div>
        </div>
    </c:if>
    <c:forEach var="dto" items="${deliveryList}">
        <div class="flex-row">
            <div class="flex-cell">${dto.order_code}</div>
            <div class="flex-cell">${dto.member_id}</div>
            <div class="flex-cell">${dto.order_date}</div>
            <div class="flex-cell">${dto.product_name}<br>${dto.order_place}</div>
            <div class="flex-cell">
                <fmt:formatNumber value="${dto.order_count}" type="number" pattern="###,###개"/><br>
                <fmt:formatNumber value="${dto.order_price}" type="number" pattern="###,###원"/>
            </div>
            <div class="flex-cell">${dto.order_comment}</div>
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
        </div>
    </c:forEach>
</div>

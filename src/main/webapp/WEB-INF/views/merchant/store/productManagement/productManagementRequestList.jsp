<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 요청리스트 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="productManagementTop.jsp" %>
<style>
	.scroll {
	overflow : auto
	}
</style>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script>
  $( function() {  //html화면이 열리면 function함수가 동작 준비를 함 =>$(document).ready(function(){});과 같
    $( "#startDate" ).datepicker({
    	changeMonth: true,
    	changeYear: true,
    	nextText: '다음 달',
    	prevText: '이전 달',
    	dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
    	monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    	monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    	dateFormat: "yy-mm-dd",
    	maxDate: 0, //선택 가능한 최소날짜, 0: 오늘 이후 선택 불가
    	onClose: function( selectedDate ) {                          
    		//시작일(startDate) datepicker가 닫힐때                      
    		//종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정                     
    		$("#endDate").datepicker( "option", "minDate", selectedDate );                 
    	}	
    });
  } );
  $( function() {
    $( "#endDate" ).datepicker({
    	changeMonth: true,
    	changeYear: true,
    	nextText: '다음 달',
    	prevText: '이전 달',
    	dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
    	monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    	monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    	dateFormat: "yy-mm-dd",
    	maxDate: 0, //선택 가능한 최소날짜, 0: 오늘 이후 선택 불가
    	onClose: function( selectedDate ) {                          
    		//시작일(startDate) datepicker가 닫힐때                      
    		//종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정                     
    		$("#endDate").datepicker( "option", "maxDate", selectedDate );                 
    	}
    });
  } );
  </script>
</head>
<div align="center">
<form name="f1" action="productManagement_requestList.do">
	<table border="1" width="100%">
	<div align="left">
	- MD 승인이 필요한 상품 수정 요청 내역을 조회할 수 있습니다.<br>
	- 승인대기 상품의 재수정 또는 추가 수정 항목이 있는 경우 철회 후 다시 수정 요청해주세요.<br>
	- 승인대기는 오늘의 집 MD가 판매 승인을 하지 않은 상품을 의미합니다.<br>
	<br>
	</div>
		<tr>
			<th>승인 상태</th>
			<td>
				<select name="product_approval_status">
					<option value="all" name="product_approval_status">전체</option>
					<option value="approval_wait" name="product_approval_status">승인대기</option>
					<option value="approval_pend" name="product_approval_status">승인보류</option>
					<option value="approval_consideration" name="product_approval_status">승인반려</option>
					<option value="approval_cancle" name="product_approval_status">승인철회</option>
					<option value="approved" name="product_approval_status">판매가능</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>기간</th>
			<td>
				<input type="text" id="startDate" name="startDate"> ~ 
				<input type="text" id="endDate" name="endDate">
			</td>
		</tr>
		<tr>
			<th>검색</th>
			<td>
			<select name="search">
			<option value="product_num">상품번호</option>
			<option value="product_name">상품명</option>
		</select>
				<input type="text" name="searchString">
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<input type="reset" value="초기화">
				<input type="submit" value="검색">
			</td>
		</tr>
	</table>
</form>
	<br>
	<div align="left"  class="scroll">
	<font size="3">검색 결과</font>
	</div>
	<table border="0" width="100%">
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>대표이미지</th>
			<th>가격</th>
			<th>수량</th>
			<th>신청일</th>
			<th>상태</th>
			<th>취소여부</th>
		</tr>
	<c:if test="${empty requestListProduct}">
		<tr>
			<td colspan="8" align="center">등록된 상품이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${requestListProduct}">
 		<tr>
			<td>${dto.product_num}</td>
			<td>${dto.product_name}</td>
			<td>
					<img src="${product_image}/${dto.product_image}" width="40" height="40">
			</td>
			<td><fmt:formatNumber value="${dto.product_price}" pattern="###,###"/>원</td>
			<td>${dto.product_quantity}개</td>
			<td>${dto.product_input_date }</td>
			<c:if test="${dto.product_approval_status=='f'}">
			<td>등록대기</td>
			<td><a href="product_fcancle.do?product_num=${dto.product_num }">취소</a></td>
			</c:if>
			<c:if test="${dto.product_approval_status=='dr'}">
			<td>삭제요청</td>
			<td><a href="product_dcancle.do?product_num=${dto.product_num }">취소</a></td>
			</c:if>
			<c:if test="${dto.product_approval_status=='ur'}">
			<td>수정요청</td>
			<td><a href="product_ucancle.do?product_num=${dto.product_num }">취소</a></td>
			</c:if>
			<c:if test="${dto.product_approval_status=='re'}">
			<td colspan="2">승인보류</td>
			</c:if>
			<c:if test="${dto.product_approval_status=='ca'}">
			<td colspan="2">승인불가</td>
			</c:if>
			<c:if test="${dto.product_approval_status=='ro'}">
			<td colspan="2">승인완료</td>
			</c:if>
			<c:if test="${dto.product_approval_status=='ok'}">
			<td colspan="2">판매중</td>
			</c:if>
			<c:if test="${dto.product_approval_status=='fc'}">
			<td colspan="2">등록취소</td>
			</c:if>
			<c:if test="${dto.product_approval_status=='dc'}">
			<td colspan="2">삭제취소</td>
			</c:if>
			<c:if test="${dto.product_approval_status=='uc'}">
			<td colspan="2">수정취소</td>
			</c:if>
		</tr>				
	</c:forEach>
	</table>
</div>

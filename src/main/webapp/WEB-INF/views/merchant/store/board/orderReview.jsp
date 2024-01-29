<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 구매후기 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="boardTop.jsp" %>
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
</head><form name="f1" action="board_orderReview.do">
<table border="1" width="100%">
		<tr>
			<th>기간</th>
			<td>
				<input type="text" id="startDate" name="startDate"> ~ 
				<input type="text" id="endDate" name="endDate">
			</td>
		</tr>
		<tr>
			<th>평균별점</th>
			<td>
				<select name="review_star">
				<option value="all">전체</option>
				<c:forEach var="star" begin="0" end="5">
				<option value="${star}">
					${star}
				</option>
				</c:forEach>					
				</select>
			</td>
		</tr>
		<tr>
		<th>검색</th>
		<td>
		<select name="search">
			<option value="product_num">상품번호</option>
			<option value="product_name">상품명</option>
		</select>
				<input type="text">
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
	<div align="left">
	<font size="3">검색 결과</font>
	</div>

<div align="center" class="scroll">
	<table border="0" width="100%">
		<tr>
			<th>번호</th>
			<th>제품명</th>
			<th>별점</th>
			<th>내용</th>
			<th>작성자 정보</th>
			<th>작성일</th>
		</tr>
	<c:if test="${empty reviewList}">
		<tr>
			<td colspan="6" align="center">검색 결과가 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${reviewList}">
 		<tr>
			<td>${dto.review_num }</td>
			<td>${dto.product_num }</td>
			<td>${dto.review_star }</td>
			<td>${dto.review_content }</td>
			<td>${dto.member_id }</td>
			<td>${dto.review_date }</td>
		</tr>				
	</c:forEach>
	</table>
</div>

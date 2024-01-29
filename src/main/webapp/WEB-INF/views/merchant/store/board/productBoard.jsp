<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 상품문의 -->
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
</head>
<form name="f1" action="board_productBoard.do">
<table border="1" width="100%">
		<tr>
			<th>처리 상태</th>
			<td>
				<select name="product_QA_state">
					<option value="all">전체</option>
					<option value="answer_wait">답변대기</option>
					<option value="answer_complete">답변완료</option>
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
			<th>문의 유형</th>
			<th>답변 상태</th>
			<th>내용</th>
			<th>작성자 정보</th>
			<th>작성일</th>
			<th>답변</th>
		</tr>
	<c:if test="${empty productQAList}">
		<tr>
			<td colspan="7" align="center">검색 결과가 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${productQAList}">
 		<tr>
			<td>${dto.product_QA_num }</td>
			<td>${dto.product_inquiry_type }</td>
			<td>${dto.product_QA_state }</td>
			<td>${dto.product_QA_content }</td>
			<td>${dto.member_id }</td>
			<td>${dto.product_QA_date }</td>
			<td>
			<c:if test="${dto.product_QA_state == 'f'}">
				<a href="product_qa_state_ok.do?product_QA_num=${dto.product_QA_num }">답변</a>
			</c:if>
			<c:if test="${dto.product_QA_state == 't'}">
				답변완료
			</c:if>
			</td>
		</tr>				
	</c:forEach>
	</table>
</div>

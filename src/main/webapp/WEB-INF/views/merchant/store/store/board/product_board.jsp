<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 상품문의 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/delivery_style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="board_top.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
<title>OZ의 집 : 상품 문의</title>
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
	  	dateFormat: "y/mm/dd",
	  	maxDate: 0, //선택 가능한 최소날짜, 0: 오늘 이후 선택 불가
	  	onClose: function( selectedDate ) {                          
		//시작일(startDate) datepicker가 닫힐때                      
		//종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정                     
		$("#endDate").datepicker( "option", "minDate", selectedDate );                 
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
	  	monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	  	monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	  	dateFormat: "y/mm/dd",
	  	maxDate: 0, //선택 가능한 최소날짜, 0: 오늘 이후 선택 불가
	  	onClose: function( selectedDate ) {                          
		//시작일(startDate) datepicker가 닫힐때                      
		//종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정                     
		$("#endDate").datepicker( "option", "maxDate", selectedDate );                 
	  	}
	  });
	});
	function answerQuestion(productQANum) {
	    var url = 'product_reqa.do?product_QA_num=' + productQANum;
	    window.location.href = url;
	}
	function requestQuestion(productQANum) {
	    var url = 'product_reqa_update.do?product_reQA_num=' + productQANum;
	    window.location.href = url;
	}
	
	function resetForm() {
	    document.forms["f1"].reset();  // 폼 초기화
	    document.getElementById("startDate").value = "";
	    document.getElementById("endDate").value = "";
	    document.getElementById("searchString").value = "";
	    document.getElementById("search").value = "all";
	    document.getElementById("product_QA_state").value = "all";
	}
</script>
</head>

<div class="container">
	<div class="content-container">
	    <h1 class="board-header">상품 문의</h1>
		<div class="flex-container">
			<form name="f1" action="board_productBoard.do?mer_num=${merchantLoginMember.mer_num }" class="flex-container">
   			    <input type="hidden" name="mer_num" value="${merchantLoginMember.mer_num }">
			    <div class="flex-row">
			        <div class="flex-cell header-cell custom-label">답변 상태</div>
			        <div class="flex-cell input-cell">
			            <select name="product_QA_state" id="product_QA_state">
			                <option value="all">전체</option>
			                <option value="answer_wait" ${param.product_QA_state == 'answer_wait' ? 'selected' : ''}>답변대기</option>
			                <option value="answer_complete" ${param.product_QA_state == 'answer_complete' ? 'selected' : ''}>답변완료</option>
			            </select>
			        </div>
			    </div>
			    <div class="flex-row">
			        <div class="flex-cell header-cell custom-label">기간&nbsp;&nbsp;&nbsp;&nbsp;</div>
			        <div class="flex-cell input-cell">
			            <input type="text" id="startDate" name="startDate" value="${param.startDate}">
			            ~
			            <input type="text" id="endDate" name="endDate" value="${param.endDate}">
			        </div>
			    </div>
			    <div class="flex-row">
			        <div class="flex-cell header-cell custom-label">검색&nbsp;&nbsp;&nbsp;&nbsp;</div>
			        <div class="flex-cell input-cell">
			            <select name="search" id="search">
			                <option value="all" ${param.search == 'all' ? 'selected' : ''}>전체</option>
			                <option value="member_id" ${param.search == 'member_id' ? 'selected' : ''}>작성자</option>
			                <option value="product_inquiry_type" ${param.search == 'product_inquiry_type' ? 'selected' : ''}>문의유형</option>			                
			                <option value="product_qa_content" ${param.search == 'product_qa_content' ? 'selected' : ''}>내용</option>
			                <option value="product_name" ${param.search == 'product_name' ? 'selected' : ''}>제품명</option>
			            </select>
			            <input type="text" id="searchString" name="searchString" value="${param.searchString}">
			        </div>
			    </div>
		    <div class="flex-subrow custom-button-row">
   				<div class="button-container">
			            <input type="submit" value="검색">
			            <input type="button" value="초기화" onclick="resetForm()">
			        </div>
			    </div>
			</form>
			<br>
		</div>
		<div align="left" class="results-heading">
	        <font size="2">검색 결과</font>&nbsp;&nbsp;총 ${productqaCount} 건
	    </div>
		<div class="scroll flex-container content-table">
	       <div class="flex-row header-row">
		       <div class="flex-cell">번호</div>
		       <div class="flex-cell">작성자</div>
		       <div class="flex-cell">문의 유형</div>
		       <div class="flex-cell">내용</div>
		       <div class="flex-cell">제품명</div>
		       <div class="flex-cell">작성일</div>
		       <div class="flex-cell">답변 상태</div>
		       <div class="flex-cell">답변</div>
		    </div>
		    <c:if test="${empty productQAList}">
		        <div class="flex-row">
		            <div class="flex-cell" colspan="8">검색 결과가 없습니다.</div>
		        </div>
		    </c:if>
		    <c:forEach var="dto" items="${productQAList}">
		        <div class="flex-row">
		            <div class="flex-cell">${dto.product_QA_num }</div>
		            <div class="flex-cell">${dto.member_id }</div>
		            <div class="flex-cell">${dto.product_inquiry_type }</div>
					<div class="flex-cell">
						<a href="product_qa_content.do?product_QA_num=${dto.product_QA_num }">
							<c:choose>
								<c:when test="${fn:length(dto.product_QA_content) > 10}">
									${fn:substring(dto.product_QA_content, 0, 10)}...
								</c:when>
								<c:otherwise>
									${dto.product_QA_content}
								</c:otherwise>
							</c:choose>
						</a>
					</div>           
		            <div class="flex-cell">${dto.product_name }</div>
		            <div class="flex-cell">${dto.product_QA_date }</div>
		            <div class="flex-cell">
		            	<c:if test="${dto.product_QA_state == 'f'}">
		            		답변 대기
		                </c:if>
		                <c:if test="${dto.product_QA_state == 't'}">
		                    답변 완료
		                </c:if>
	       			</div>
		            <div class="flex-cell">
		                <c:if test="${dto.product_QA_state == 'f'}">
		                    <a href="javascript:answerQuestion(${dto.product_QA_num});">답변</a>
		                </c:if>
		                <c:if test="${dto.product_QA_state == 't'}">
		                    <a href="javascript:requestQuestion(${dto.product_QA_num});">수정</a>
		                </c:if>
		            </div>
	       		</div>
			</c:forEach>
		</div>
	</div>
</div>

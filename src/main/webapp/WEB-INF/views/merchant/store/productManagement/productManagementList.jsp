<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 상품조회 -->
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
<form name="f1" action="productManagement_productList.do">
<table border="1" width="100%">
<div align="left">
- 제품정보는 옵션 단위로 보여지게 됩니다.<br>
- 품절된 옵션 및 품절 임박 옵션을 잘 관리해주세요. (품절 : 0건 / 품절임박 : 0건 / 미사용 : 0건)<br>
- 양 당사자간 수수료율에 대한 합의가 이루어지지 않을 경우, 합의시까지 상품에 대한 판매 및 노출은 중단됩니다.<br>
- 품절임박은 옵션 재고가 5개 이하 남은 제품을 의미합니다.<br>
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
				<option value="approved" name="product_approval_status">판매가능</option>
			</select>
		</td>
	</tr>
	<tr>
			<th>품절</th>
			<td>
				<input type="radio" value="out" name="stock">품절
				<input type="radio" value="almost_out" name="stock">품절 임박
				<input type="radio" value="good" name="stock">양호
			</td>
		</tr>
		<tr>
			<th>기간별</th>
			<td>
				<input type="text" id="startDate" name="startDate"> ~ 
				<input type="text" id="endDate" name="endDate">
			</td>
		</tr>
		<tr>
		<th>검색</th>
		<td>
		<select name="search">
			<option name="product_num" value="product_num">상품번호</option>
			<option name="product_name" value="product_name">상품명</option>
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
	<div align="left">
	<font size="3">검색 결과</font>
	</div>
<div align="center" class="scroll">
	<table border="0" width="100%">
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>대표이미지</th>
			<th>가격</th>
			<th>수량</th>
			<th>조립비</th>
			<th>신청일</th>
			<th>상태</th>
			<th>수정|삭제</th>
		</tr>
	<c:if test="${empty listProduct}">
		<tr>
			<td colspan="9" align="center">검색된 결과가 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${listProduct}">
 		<tr>
			<td>${dto.product_num}</td>
			<td>${dto.product_name}</td>
			<td>
					<img src="${product_image}/${dto.product_image}" width="40" height="40">
			</td>
			<td><fmt:formatNumber value="${dto.product_price}" pattern="###,###"/>원</td>
			<td>${dto.product_quantity}개</td>
			<td>${dto.product_assembly_cost }</td>
			<td>
				${dto.product_input_date }
			</td>
			<td>
			<c:if test="${dto.product_approval_status=='f'}">
				판매대기
				</td>
				<td>
				신청불가
			</c:if>
			<c:if test="${dto.product_approval_status=='dr'}">
				삭제대기
				</td>
				<td>
				신청 불가
			</c:if>
			<c:if test="${dto.product_approval_status=='ur'}">
				수정대기
				</td>
				<td>
				신청 불가 | 
				<a href="product_delete.do?product_num=${dto.product_num}">삭제</a>
			</c:if>
			<c:if test="${dto.product_approval_status=='ok' }">
				판매중
				</td>
				<td>
				<a href="product_update.do?product_num=${dto.product_num}">수정</a> | 
				<a href="product_delete.do?product_num=${dto.product_num}">삭제</a>
			</c:if>
			<c:if test="${dto.product_approval_status=='fc'}">
				신청철회
				</td>
				<td>
				신청 불가
			</c:if>
			<c:if test="${dto.product_approval_status=='dc'}">
				신청철회
				</td>
				<td>
				신청 불가
			</c:if>
			<c:if test="${dto.product_approval_status=='uc'}">
				신청철회
				</td>
				<td>
				신청 불가
			</c:if>
			</td>
		</tr>				
	</c:forEach>
	</table>
</div>
</body>

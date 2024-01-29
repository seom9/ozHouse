<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 요청리스트 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/product_style.css">
<link rel="stylesheet" type="text/css" href="resources/merchant/css/delivery_style.css">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="productManagement_top.jsp" %>
<head>
<title>OZ의 집 : 요청리스트</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<style>
        .button-container {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 10px;
        }
    </style>
<script>
function updateDeleteButtonState() {
    var checkboxes = document.getElementsByName('selectedProducts');
    var deleteButton = document.getElementById('deleteButton');
    var anyChecked = Array.from(checkboxes).some(checkbox => checkbox.checked);

    deleteButton.disabled = !anyChecked;
}

$(document).ready(function() {
    $('input[name="selectedProducts"]').change(updateDeleteButtonState);
    updateDeleteButtonState(); 
});

function fetchAndDisplayMsg(productNum) {
    $.ajax({
        url: 'getProductMessage.do',
        type: 'GET',
        data: { product_num: productNum },
        contentType : "application/json; charset:UTF-8",
        success: function(response) {
        	
        	console.log(response);
            alert("사유 : " + response);
        },
        error: function(error) {
            console.log(error);
        }
    });
}

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

function resetForm() {
	document.forms["f1"].reset();  // 폼 초기화
    document.getElementById("startDate").value = "";
    document.getElementById("endDate").value = "";
    document.getElementById("searchString").value = "";
    document.getElementById("search").value = "all";
    document.getElementById("product_approval_status").value = "all";
}
</script>
</head>
<div class="container">
	<div class="content-container">
	    <h1 class="stock-header">수정 요청 리스트</h1>
		<div class="flex-container">
	        <div class="flex-item">
	        	<p class="info-text">
					• MD 승인이 필요한 상품 수정 요청 내역을 조회할 수 있습니다.<br>
					• 승인대기 상품의 재수정 또는 추가 수정 항목이 있는 경우 철회 후 다시 수정 요청해주세요.<br>
					• 승인대기는 오늘의 집 MD가 판매 승인을 하지 않은 상품을 의미합니다.<br><br>
				</p>
			</div>
		</div>
		<form name="f1" action="productManagement_requestList.do" class="flex-container" method="post">
			<c:set var="mer_num" value="${merchantLoginMember.mer_num}"/>
	    	<div class="flex-row">
		        <div class="flex-cell header-cell custom-label">승인 상태</div>
		        <div class="flex-cell input-cell input-cell">
		            <select name="product_approval_status" id="product_approval_status">
								<option value="all" name="product_approval_status">전체</option>
								<option value="approval_wait" name="product_approval_status" ${param.product_approval_status == 'approval_wait' ? 'selected' : ''}>승인대기</option>
								<option value="approval_pend" name="product_approval_status" ${param.product_approval_status == 'approval_pend' ? 'selected' : ''}>승인보류</option>
								<option value="approval_consideration" name="product_approval_status" ${param.product_approval_status == 'approval_consideration' ? 'selected' : ''}>승인반려</option>
								<option value="approved" name="product_approval_status" ${param.product_approval_status == 'approved' ? 'selected' : ''}>판매가능</option>
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
		        <div class="flex-cell input-cell input-cell">
		            <select name="search" id="search">
							<option value="all" ${param.search == 'all' ? 'selected' : ''}>전체</option>
				                    <option value="product_num" ${param.search == 'product_num' ? 'selected' : ''}>상품번호</option>
				                    <option value="product_name" ${param.search == 'product_name' ? 'selected' : ''}>상품명</option>
				                    <option value="category_name" ${param.search == 'category_name' ? 'selected' : ''}>카테고리</option>
				                </select>
			            <input type="text" id="searchString" name="searchString" value="${param.searchString}">
		        </div>
		    </div>
	<div class="flex-subrow custom-button-row">
   				<div class="button-container">
		        	<input type="submit" value="검색">
				                <input type="button" value="초기화" onclick="resetForm()">
		            <input type="hidden" name="mer_num" value="${merchantLoginMember.mer_num }"/>
		        </div>
		    </div>
		</form>
		<br>
		<div align="left" class="results-heading">
		    <font size="2">검색 결과</font>&nbsp;&nbsp;총 ${requestListCount} 건
		</div>
		<form id="deleteForm" method="post" action="deleteSelectedProducts.do">
		<div class="scroll flex-container content-table">
		    <div class="flex-row header-row">
		        <div class="flex-cell">상품번호</div>
		        <div class="flex-cell">상품설명<div class="sub-header">상품명</div></div>
	        	<div class="flex-cell">카테고리</div>
		        <div class="flex-cell">대표이미지</div>
		        <div class="flex-cell">가격</div>
		        <div class="flex-cell">수량</div>
		        <div class="flex-cell">신청일</div>
		        <div class="flex-cell">상태</div>
		        <div class="flex-cell">기타</div>
		    </div>
		    <c:if test="${empty requestListProduct}">
		        <div class="flex-row">
		            <div class="flex-cell" colspan="8">등록된 상품이 없습니다.</div>
		        </div>
		    </c:if>
		    <c:forEach var="dto" items="${requestListProduct}">
		        <div class="flex-row">
		            <div class="flex-cell">${dto.product_num}</div>
		            <div class="flex-cell">[${dto.product_modifier}]
	            	<div class="sub-content">${dto.product_name}</div>
		            </div>
		            <div class="flex-cell">${dto.category_name}</div>
		            <div class="flex-cell">
        <c:if test="${not empty dto.encodedImage}">
            <img src="data:image/jpeg;base64,${dto.encodedImage}" width="40" height="40">
        </c:if>
        <c:if test="${empty dto.encodedImage}">
            <span>No image</span>
        </c:if>
    </div>
		            <div class="flex-cell"><fmt:formatNumber value="${dto.product_price}" pattern="###,###"/>원</div>
		            <div class="flex-cell">${dto.product_quantity}개</div>
		            <div class="flex-cell">${dto.product_input_date }</div>
		            <div class="flex-cell">
		                <c:choose>
		                    <c:when test="${dto.product_approval_status=='f'}">등록대기</c:when>
		                    <c:when test="${dto.product_approval_status=='ur'}">수정요청</c:when>
		                    <c:when test="${dto.product_approval_status=='re'}">승인보류</c:when>
		                    <c:when test="${dto.product_approval_status=='ca'}">승인불가</c:when>
		                    <c:when test="${dto.product_approval_status=='ok'}">판매중</c:when>
   		                    <c:when test="${dto.product_approval_status=='dr'}">삭제대기</c:when>
		                </c:choose>
		            </div>
		            <div class="flex-cell">
		                <c:choose>
    <c:when test="${dto.product_approval_status=='f'}">
        <div>
            <input type="button" style="background-color: #F4F4F4; color: black;" value="취소" onclick="window.location='product_delete.do?product_num=${dto.product_num}&mer_num=${merchantLoginMember.mer_num}'">
        </div>
    </c:when>
    <c:when test="${dto.product_approval_status=='dr'}">
        <div>
            <input type="button" class="update-button" value="취소" onclick="window.location='product_ucancle.do?product_num=${dto.product_num}&mer_num=${merchantLoginMember.mer_num}'">
        </div>
    </c:when>
    <c:when test="${dto.product_approval_status=='ur'}">
        <div>
            <input type="button" class="update-button" value="취소" onclick="window.location='product_dcancle.do?product_num=${dto.product_num}&mer_num=${merchantLoginMember.mer_num}'">
        </div>
    </c:when>
    <c:when test="${dto.product_approval_status=='re'}">
        <div>
            <input type="button" value="확인" onclick="fetchAndDisplayMsg('${dto.product_num}')">
        </div>
        <div>
            <input type="button" class="update-button" style="background-color: #50E5B4; color: white; margin-bottom: 10px; margin-top: 10px;" value="수정" onclick="window.location='product_update.do?product_num=${dto.product_num}&mer_num=${merchantLoginMember.mer_num}'">
        </div>
        <div>
            <input type="button" class="update-button" value="삭제" onclick="window.location='product_delete.do?product_num=${dto.product_num}&mer_num=${merchantLoginMember.mer_num}'">
        </div>
        
    </c:when>
    
    
     <c:when test="${dto.product_approval_status=='ca'}">
        <div>
            <input type="button" value="확인" onclick="fetchAndDisplayMsg('${dto.product_num}')">
		</div>
	</c:when>
	<c:when test="${dto.product_approval_status=='ok'}">
		<div>
			<input type="button" style="background-color: #50E5B4; color: white; margin-bottom: 10px;" value="수정" onclick="window.location='product_update.do?product_num=${dto.product_num}&mer_num=${merchantLoginMember.mer_num}'">
		</div>
		<div>
			<input type="button" class="update-button" value="삭제" onclick="window.location='product_cancle.do?product_num=${dto.product_num}&mer_num=${merchantLoginMember.mer_num}'">
		</div>
	</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
    
		            </div>
		        </div>
		    </c:forEach>
		</div>
	</div>

	</form>

</div>
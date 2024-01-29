<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 상품조회 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/product_style2.css">
<link rel="stylesheet" type="text/css" href="resources/merchant/css/delivery_style2.css">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="productManagement_top.jsp" %>
<head>
<title>OZ의 집 : 상품조회</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>

function submitDeleteForm() {
    var confirmation = confirm("정말 삭제하시겠습니까?");
    if (confirmation) {
        document.getElementById("deleteForm").submit();
    }
}

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
    
    var stockRadios = document.getElementsByName("stock");
    for(var i = 0; i < stockRadios.length; i++) {
        stockRadios[i].checked = false;
    }
    
}
</script>
</head>
<div class="container">
	<div class="content-container">
	    <h1 class="stock-header">상품 조회</h1>
		<div class="flex-container">
	        <div class="flex-item">
	        	<p class="info-text">
					• 제품정보는 옵션 단위로 보여지게 됩니다.<br>
					• 품절된 옵션 및 품절 임박 옵션을 잘 관리해주세요. (품절 : 0건 / 품절임박 : 0건 / 미사용 : 0건)<br>
					• 양 당사자간 수수료율에 대한 합의가 이루어지지 않을 경우, 합의시까지 상품에 대한 판매 및 노출은 중단됩니다.<br>
				<p class="info-text red-text">
					• 품절임박은 옵션 재고가 5개 이하 남은 제품을 의미합니다.<br>
					• 승인대기는 오늘의집 MD가 판매 승인을 하지 않은 상품을 의미합니다.<br><br>
				</p>
			</div>
			<c:set var="mer_num" value="${merchantLoginMember.mer_num}"/>
			<form name="f1" action="productManagement_productList.do?mer_num=${merchantLoginMember.mer_num }" class="flex-container" method="post">
			    <div class="flex-row">
			    	<div class="flex-cell header-cell custom-label">품절&nbsp;&nbsp;&nbsp;&nbsp;</div>
		            <div class="flex-cell input-cell">
    <input type="radio" value="out" name="stock" ${param.stock == 'out' ? 'checked' : ''}>품절
    <input type="radio" value="almost_out" name="stock" ${param.stock == 'almost_out' ? 'checked' : ''}>품절 임박
    <input type="radio" value="good" name="stock" ${param.stock == 'good' ? 'checked' : ''}>양호
</div>
		        </div>
		        <div class="flex-row">
		    		<div class="flex-cell header-cell custom-label">승인 상태</div>
		    			<div class="flex-cell input-cell">
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
		        <div class="flex-cell input-cell">
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
       				</div>
				</form>
				<br>
	<div align="left" class="results-heading">
        <font size="2">검색 결과</font>&nbsp;&nbsp;총 ${listCount} 건
    </div>
<form id="deleteForm" method="post" action="deleteSelectedProducts.do">
<input type="hidden" name="mer_num" value="${merchantLoginMember.mer_num }"/>
	<div class="scroll flex-container content-table">
       <div class="flex-row header-row">
       <div class="flex-cell">구분</div>
	        <div class="flex-cell">상품번호</div>
	        <div class="flex-cell">상품설명<div class="sub-header">상품명</div></div>
	        <div class="flex-cell">카테고리</div>
	        <div class="flex-cell">대표이미지</div>
	        <div class="flex-cell">가격</div>
	        <div class="flex-cell">수량</div>
	        <div class="flex-cell">조립비</div>
	        <div class="flex-cell">신청일</div>
        	<div class="flex-cell">상태</div>
	        <div class="flex-cell">기타</div>
        </div>
	    <c:if test="${empty listProduct}">
	        <div class="flex-row">
	            <div class="flex-cell" colspan="10">검색된 결과가 없습니다.</div>
	        </div>
	    </c:if>    
		<c:forEach var="dto" items="${listProduct}">
	        <div class="flex-row">
	        <div class="flex-cell">
                <input type="checkbox" name="selectedProducts" value="${dto.product_num}" ${dto.product_approval_status != 'ca' ? 'disabled' : ''}>
	        </div>
				<div class="flex-cell">${dto.product_num}</div>
	            <div class="flex-cell">[${dto.product_modifier}]
	            	<div class="sub-content">
	            		<a href="product_content.do?product_num=${dto.product_num }">${dto.product_name}</a>
	            	</div>
	            </div>
	            <div class="flex-cell">${dto.category_name}</div>
<div class="flex-cell">
        <c:if test="${not empty dto.encodedImage}">
            <img src="data:image/jpeg;base64,${dto.encodedImage}" width="100" height="100">
        </c:if>
        <c:if test="${empty dto.encodedImage}">
            <span>No image</span>
        </c:if>
    </div>
	            <div class="flex-cell">
	            	<fmt:formatNumber value="${dto.product_price}" pattern="###,###"/>원
	            </div>
	            <div class="flex-cell">${dto.product_quantity}개</div>
	            <div class="flex-cell">
	            	<fmt:formatNumber value= "${dto.product_assembly_cost }" pattern="###,###"/>원
            	</div>
	            <div class="flex-cell">${dto.product_input_date }</div>
					<c:if test="${dto.product_approval_status=='f'}">
					<div class="flex-cell">
						판매대기
					</div>
					<div class="flex-cell">
						<span>-</span>
					</div>
				</c:if>
				<c:if test="${dto.product_approval_status=='dr'}">
				<div class="flex-cell">
					삭제대기
					</div>
					<div class="flex-cell">
						<span>-</span>
					</div>
				</c:if>
				<c:if test="${dto.product_approval_status=='re'}">
				<div class="flex-cell">
					승인보류
					</div>
					<div class="flex-cell">
					<input type="button" value="확인" onclick="fetchAndDisplayMsg('${dto.product_num}')">
					</div>
				</c:if>
<c:if test="${dto.product_approval_status=='ca'}">
    <div class="flex-cell">승인반려</div>
    <div class="flex-cell">
   	<input type="button" value="확인" onclick="fetchAndDisplayMsg('${dto.product_num}')">
    </div>
</c:if>
				<c:if test="${dto.product_approval_status=='ur'}">
				<div class="flex-cell">
					수정대기
					</div>
					<div class="flex-cell">
					<span>-</span>
					</div>
				</c:if>

				<c:if test="${dto.product_approval_status=='ok' }">
				<div class="flex-cell">
					판매중
					</div>
					<div class="flex-cell">
					<span>-</span>
					</div>
				</c:if>
				<c:if test="${dto.product_approval_status=='fc'}">
				<div class="flex-cell">
					등록철회
					</div>
					<div class="flex-cell">
					<span>-</span>
					</div>
				</c:if>
				<c:if test="${dto.product_approval_status=='dc'}">
				<div class="flex-cell">
					삭제철회
					</div>
					<div class="flex-cell">
					<span>-</span>
					</div>
				</c:if>
				<c:if test="${dto.product_approval_status=='uc'}">
				<div class="flex-cell">
					수정철회
					</div>
					<div class="flex-cell">
					<span>-</span>
					</div>
				</c:if>	
			</div>
		</c:forEach>
	</div>
	<br>
	<br>
<div align="center">
    <input type="button" id="deleteButton" value="삭제" onclick="submitDeleteForm()" disabled>
</div>
</form>
</div>

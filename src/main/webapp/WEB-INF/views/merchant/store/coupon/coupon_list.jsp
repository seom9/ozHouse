<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 쿠폰 현황 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/coupon_style.css">
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="coupon_top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<title>OZ의 집 : 쿠폰현황</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
$( function() {  //html화면이 열리면 function함수가 동작 준비를 함 =>$(document).ready(function(){});과 같
	$("#startDate" ).datepicker({
		changeMonth: true,
		changeYear: true,
		nextText: '다음 달',
		prevText: '이전 달',
		dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		dateFormat: "y/mm/dd",
		/* maxDate: 0, //선택 가능한 최소날짜, 0: 오늘 이후 선택 불가 */
		onClose: function( selectedDate ) {                          
   		//시작일(startDate) datepicker가 닫힐때                      
   		//종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정                     
   		$("#endDate").datepicker( "option", "minDate", selectedDate );                 
   		}	
	});
});
$( function() {
	$("#endDate" ).datepicker({
	  	changeMonth: true,
	  	changeYear: true,
	  	nextText: '다음 달',
	  	prevText: '이전 달',
	  	dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
	  	dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	  	monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	  	monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	  	dateFormat: "y/mm/dd",
	  	/* maxDate: 0, //선택 가능한 최소날짜, 0: 오늘 이후 선택 불가 */
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
	 document.f.mer_isapproval.value = "all";
}
</script>
<script type="text/javascript">
function checkMore(mer_couponnum, mer_num){
	if(window.confirm("정말로 삭제하시겠습니까?")){
		document.location.href = 'coupon_delete.do?mer_couponnum=' + mer_couponnum + '&mer_num=' + mer_num;
	}
}

function fetchAndDisplayMsg(merCouponNum) {
    $.ajax({
        url: 'getCouponMessage.do',
        type: 'GET',
        data: { mer_couponnum: merCouponNum },
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

</script>
</head>
<div class="container">
	<div class="content-container">
	    <h1 class="coupon-header">쿠폰 현황</h1>
	    <div class="flex-container">
	        <div class="flex-item">
	            <p class="info-text">
					• 내 상점의 쿠폰 현황입니다.<br>
					• 승인이 완료되지 않은 쿠폰은 해당 화면에서 취소가 가능합니다.
				<p class="info-text red-text">
					• 승인 전의 쿠폰은 판매자가 직접 삭제가 가능하나, 승인된 쿠폰은 관리자를 통하여 삭제가 가능합니다.<br>
					• 사용 시작 기간이 도래한 가용 쿠폰은 삭제가 불가능합니다.
				<p class="info-text">
					• 쿠폰승인절차 : 쿠폰등록신청 > 쿠폰승인 > 쿠폰사용가능<br><br>
				</p>
			</div>
		</div>
		<form name="f" action="coupon_listSearch.do" method="post" class="flex-container">
		    <input type="hidden" name="mer_num" value="${merchantLoginMember.mer_num}">
		    <div class="flex-row">
		        <div class="flex-cell header-cell">쿠폰 기간</div>
		        <div class="flex-cell input-cell">
		            <select name="date">
		                <option value="mer_couponusedate">시작일</option>
		                <option value="mer_couponenddate">종료일</option>
		            </select>
		            <input type="text" id="startDate" name="startDate" value="${map.startDate}"> ~
		            <input type="text" id="endDate" name="endDate" value="${map.endDate}">
		        </div>
		    </div>
		    <div class="flex-row">
		        <div class="flex-cell header-cell">승인여부</div>
		            <div class="flex-cell">
		            ${radioOptions}
		        </div>
		    </div>
		    <div class="flex-row">
		        <div class="flex-cell header-cell">검색&nbsp;&nbsp;&nbsp;</div>
		            		<div class="flex-cell">
		            <select name="search">
		                ${checkOptions}
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
		        <font size="3">검색 결과</font>&nbsp;&nbsp;총 ${couponCount} 건
		    </div>
		    <div class="scroll flex-container content-table">
		        <div class="flex-row header-row">
		        <div class="flex-cell">쿠폰번호</div>
		        <div class="flex-cell">쿠폰이름</div>
		        <div class="flex-cell">사용시작일</div>
		        <div class="flex-cell">사용종료일</div>
		        <div class="flex-cell">할인가격</div>
		        <div class="flex-cell">승인여부</div>
		        <div class="flex-cell">삭제</div>
		    </div>
		    <c:if test="${empty couponList}">
		        <div class="flex-row">
		       		<div class="flex-cell" colspan="7" align="center">조회결과가 없습니다.</div>
				</div>
		    </c:if>
		    <c:forEach var="dto" items="${couponList}">
				<div class="flex-row-sub">	
		            <div class="flex-cell">${dto.mer_couponnum}</div>
		            <div class="flex-cell">${dto.mer_couponname}</div>
		            <div class="flex-cell">${dto.mer_couponusedate}</div>
		            <div class="flex-cell">${dto.mer_couponenddate}</div>
		            <div class="flex-cell">
		                <fmt:formatNumber value="${dto.mer_coupondiscount}" type="number" pattern="###,###원"/></div>
			<c:choose>
				<c:when test="${dto.mer_isapproval eq 'f'}">
		            <div class="flex-cell">승인 중</div>
		        </c:when>
		        <c:when test="${dto.mer_isapproval eq 't'}">
		            <div class="flex-cell">승인 완료</div>
		        </c:when>
		        <c:when test="${dto.mer_isapproval eq 'c'}">
		            <div class="flex-cell">승인 거절</div>
		        </c:when>
		    </c:choose>
		            <div class="flex-cell">
		                <c:choose>
		                    <c:when test="${dto.mer_isapproval eq 't'}">
                    <input type="button" style="background-color: #50E5B4; color: white;" value="삭제" disabled="disabled">
                </c:when>
                <c:when test="${dto.mer_isapproval eq 'c'}">
                <div>
                    <input type="button" value="확인" onclick="fetchAndDisplayMsg('${dto.mer_couponnum}')">
                </div>
                <div>
                    <input type="button" style="background-color: #50E5B4; color: white; margin-top: 10px;" value="삭제" onclick="checkMore('${dto.mer_couponnum}', '${dto.mer_num}')">
                </div>    
                </c:when>
                <c:otherwise>
                    <input type="button" value="삭제" onclick="checkMore('${dto.mer_couponnum}', '${dto.mer_num}')">
                </c:otherwise>
		                </c:choose>
		            </div>
		        </div>
		    </c:forEach>
		</div>
	</div>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 쿠폰 등록 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/top.css">
<link rel="stylesheet" type="text/css" href="resources/merchant/css/coupon_style.css">
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="coupon_top.jsp" %>
<head>
<title>OZ의 집 : 쿠폰등록</title>
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
  	dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
  	monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  	monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  	dateFormat: "y/mm/dd",
  	minDate: 0, //선택 가능한 최소날짜, 0: 오늘 이후 선택 불가
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
  	minDate: 0, //선택 가능한 최소날짜, 0: 오늘 이후 선택 불가
  	onClose: function( selectedDate ) {                          
	//시작일(startDate) datepicker가 닫힐때                      
	//종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정                     
	$("#endDate").datepicker( "option", "maxDate", selectedDate );                 
  	}
  });
});

function check(){
	if(f.mer_couponname.value==""){
		alert("쿠폰명을 입력해주세요");
		return false;
	}
	if(f.startDate.value=="" || f.endDate.value==""){
		alert("사용기간을 선택해주세요");
		return false;
	}
	return true;
}
</script>
</head>
<div class="container">
	<div class="content-container">
	    <h1 class="coupon-header">쿠폰 등록하기</h1>
	    <div class="flex-container">
	        <div class="flex-item">
	            <p class="info-text">
				• 등록할 쿠폰의 정보를 입력하여주세요.<br>
				• 쿠폰의 등록 여부는 심사의 결과에 따라 달라질 수 있습니다.<br><br>
				</p>
			</div>
		</div>
		<form name="f" action="coupon_insert.do" method="post" class="flex-container" onsubmit="return check();">	
			<div class="flex-row">
		        <div class="flex-cell header-cell custom-label">쿠폰명&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
	        	<div class="flex-cell">
	        		<input type="text" name="mer_couponname" size="60"></div>
		    	</div>
			    <div class="flex-row custom-row">
			        <div class="flex-cell header-cell custom-label recustom-label">쿠폰 할인 가격</div>
			        <div class="flex-cell">
			            <input type="radio" name="mer_coupondiscount" value="3000" checked="checked">3,000원
			            <input type="radio" name="mer_coupondiscount" value="5000">5,000원
			            <input type="radio" name="mer_coupondiscount" value="10000">10,000원
			            <input type="radio" name="mer_coupondiscount" value="30000">30,000원
			        </div>
			    </div>
			    <div class="flex-row custom-row">
			        <div class="flex-cell header-cell custom-label">쿠폰 사용 기간</div>
			        <div class="flex-cell">
			            <input type="text" id="startDate" name="mer_couponusedate"> ~
			            <input type="text" id="endDate" name="mer_couponenddate">
			        </div>
		        </div>
		        <div class="flex-subrow custom-button-row">
    				<div class="button-container">
			        	<input type="submit" value="등록">
			            <input type="reset" value="초기화">
			        </div>
			    </div>
		    </div>
		    <input type="hidden" name="mer_isapproval" value="f"/>
		    <input type="hidden" name="mer_num" value="${merchantLoginMember.mer_num }"/> <!-- login연결되면 고치기 -->
		</form>
	</div>
</div>
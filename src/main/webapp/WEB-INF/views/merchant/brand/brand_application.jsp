<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 사업자 인증 -->
<%@ include file="../brand/brand_inform_top.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/merchant/css/brandInformStyle.css">

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>입점신청</title>
	<script>
	var comNumChecked = false;
	
	 	function onSubmit() {
	        var comnum1 = document.f.inbrand_comnum1.value;
	        var comnum2 = document.f.inbrand_comnum2.value;
	        var comnum3 = document.f.inbrand_comnum3.value;

	        if (comnum1.length == 0 || comnum2.length == 0 || comnum3.length == 0) {
	            alert('사업자 등록번호를 입력해주세요.');
	            return false;
	        }
	        if (!comNumChecked){
	        	alert('사업자 등록번호를 다시 확인해주세요.');
				return false;
	        }
	        return true;
	    }
	 	
	 	//사업자 등록번호 조회
		$(function(){ 
		    $("#checkMer").click (function(){
		    	var reg1 = document.f.inbrand_comnum1.value;
	            var reg2 = document.f.inbrand_comnum2.value;
	            var reg3 = document.f.inbrand_comnum3.value;
	            

	            var bs_num = reg1 + "" + reg2 + "" + reg3;
		    	var data = {
		    	        "b_no": [""+bs_num+""] // 사업자번호 "xxxxxxx" 로 조회 시,
		    	    }; 
		    	
		    	    $.ajax({
			    	    url: "https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=ON6vWwaVbPxXcG%2BGGFlEnRDxo%2FYC0hrAEPWnSOoOTQc3R8U9KNHc9AZdkEee5%2FeLuDV9PAH%2FZIbuhPq4ZC81Zg%3D%3D",
			    	    type: "POST",
			    	    data: JSON.stringify(data), // json 을 string으로 변환하여 전송
			    	    dataType: "JSON",
			    	    contentType: "application/json",
			    	    accept: "application/json",
			    	    success: function(result) {
			    	        var apiCode = result.data[0].b_stt_cd;
			    	       	
			    	        if(apiCode == "01"){
			    	        	var text = "현재 계속 사업자입니다.";
			    	        	$("#bs_result").html(text).css("color", "green");
			                    $("#mer_comnum1").trigger("focus");
			                    comNumChecked = true; // 중복 검사를 실행했음을 기록
			    	        }else if(apiCode == "02"){
			    	        	var text = "현재 휴업자입니다.";
			    	        	$("#bs_result").html(text).css("color","red");
			                    $("#mer_comnum1").trigger("focus");
			                    comNumChecked = false; // 중복 검사를 실행했음을 기록
			    	        }else if(apiCode == "03"){
			    	        	var text = "현재 폐업자입니다.";
			    	        	$("#bs_result").html(text).css("color","red");
			                    $("#mer_comnum1").trigger("focus");
			                    comNumChecked = false; // 중복 검사를 실행했음을 기록
			    	        }else {
			    	        	var text = "국세청에 등록되지 않은 사업자입니다.";
			    	        	$("#bs_result").html(text).css("color","red");
			                    $("#mer_comnum1").trigger("focus");
			                    comNumChecked = false; // 중복 검사를 실행했음을 기록
			    	        }
			    	    },
			    	    error: function(result) {
			    	        console.log(result.responseText); //responseText의 에러메세지 확인
			    	    }
	    	    	});//ajax
	    	    	
		    });
		        
		});
	</script>
</head>
<body style="background-color: #F4F4F4">
<div class="centered-form-container">
    <div class="con">
<h2>입점신청</h2>
<h4>
• 입점신청중에는 중복 신청이 불가하고, 입점 거절 또는 취소시 재입점 신청은 
<span class="notice-link">OZ의 집 공지사항</span>
을 확인하여 주시기 바랍니다.<br>
• 공지사항 외의 궁금한 사항은 OZ의 집 판매자센터로 연락하시면 친절히 안내해드리겠습니다.<br>
• 입점신청중에는 중복 신청이 불가하고, 입점 거절 또는 취소시 재입점 신청은 
<span class="red-text">3개월 후</span>에 가능합니다.<br><br>
<hr>
</h4>
    <h3>사업자 인증</h3>
    	<form name="f" action="brand_application.do" method="post" onsubmit="return onSubmit();">
           <input type="hidden" name="mer_num" value="${mer_num}"/>
    <div class="business-num-section">
<label for="inbrand_comnum1" class="business-num-label">사업자 등록번호</label>
<span id="bs_result" class="business-num-result"></span>
    <div class="business-num-flex-container">
        <div class="business-num-inputs">
            <input type="text" id="inbrand_comnum1" name="inbrand_comnum1" maxlength="3" size="9"/>
            <span>-</span>
            <input type="text" id="inbrand_comnum2" name="inbrand_comnum2" maxlength="2" size="6"/>
            <span>-</span>
            <input type="text" id="inbrand_comnum3" name="inbrand_comnum3" maxlength="5" size="15"/>
        </div>
        <div class="business-num-inquiry">

            <input type="button" id="checkMer" value="사업자 등록번호 조회">
        </div>
    </div>
</div>
    <div class="button-container">
        <button type="submit">다음</button>
    </div>
            </div>
        </form>
    </div>
</div>
</body>
<%@ include file="../main/mainBottom.jsp" %>

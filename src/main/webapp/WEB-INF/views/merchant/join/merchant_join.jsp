<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>회원 가입</title>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/merchant/css/styleMain.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/merchant/css/join.css">
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript">
	
		var idMerChecked = false;
		var comNumChecked = false;
		var postChecked = false;
		
		function check(business){
			if (f.mer_id.value == ""){
				alert("아이디를 입력해 주세요")
				f.id.focus()
				return
			}
			if (!idMerChecked) { // 중복 검사가 실행되지 않았으면
				alert("아이디 유효성을 확인해 주세요");
				return;
			}
			if (!f.mer_pw.value){
				alert("비밀번호를 입력해 주세요")
				f.mer_pw.focus()
				return
			}
			if (!f.mer_pw2.value) {
				alert("비밀번호 확인을 해 주세요");
				f.mer_pw2.focus();
				return;
			}
			if (!f.mer_name.value) {
				alert("담당자 이름을 입력해주세요");
				f.mer_name.focus();
				return;
			}
			var email = f.mer_email.value;
			var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

			if(exptext.test(email)==false){
			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우	
				alert("이메일형식이 올바르지 않습니다.");
				f.mer_email.focus();
				return;
			}
			if (f.mer_pw.value !== f.mer_pw2.value) {
				alert("비밀번호가 일치하지 않습니다.");
				f.mer_pw.focus();
				return;
			}
	        if (!isValidPassword($("#password").val())) {
	            alert("비밀번호 유효성을 확인해 주세요");
	            f.member_passwd2.focus();
	            return;
	        }
	        if (!comNumChecked){
	        	alert("유효한 사업자등록번호를 입력해 주세요");
				f.mer_comnum1.focus();
				return;
	        }
	        if(!business.files || business.files.length == 0){
	        	alert("사업자등록증을 등록하여 주세요.");
	        	return;
	        }
	        var businessSize = business.files[0].size; 
			var businessMaxSize = 1024 * 1024 * 1024 ;	//1GB
		    if(businessSize > businessMaxSize) { 
		        alert("사업자등록증이 용량을 초과하였습니다. 업로드 가능한 최대크기는 1GB입니다.");
		        return;
		    }
			
		    //파일 이름 확인
		    var businessName = business.files[0].name; //files[0] : 업로드 된 파일 중 첫번째 파일  name : 파일의 이름
		    const regex = /\d{10}\.[a-zA-Z]{1,}/g; 
		    if (!regex.test(businessName)) {
		        alert("사업자등록증 파일 이름의 형식은 '-'를 제외한 사업자등록번호 입니다.");
		        return;
		    }
		    
		    var cNum1 = businessName.substr(0,3);
		    var cNum2 = businessName.substr(3,2);
		    var cNum3 = businessName.substr(5,5);
		    
		    if(cNum1 != f.mer_comnum1.value || 
		    		cNum2 != f.mer_comnum2.value  || 
		    		cNum3 != f.mer_comnum3.value ){
		    	alert("사업자등록증 파일의 사업자등록번호를 확인하여 주세요.");
		    	return;
		    }
		    
		    if (!postChecked) { // 중복 검사가 실행되지 않았으면
				alert("우편번호를 검색하여 입력해주세요.");
				return;
			}
			document.f.submit();
		}
		
		function checkMerIdFalse() {
			idMerChecked = false;
		}

		$(function(){ 
		    $("#checkMerId").click(function(){
		        let mer_id = $("#mer_id").val();
		        $.ajax({
		            type:'post', //post 형식으로 controller 에 보내기위함!!
		            url:"mer_checkId.do", // 컨트롤러로 가는 mapping 입력
		            data: {"mer_id":mer_id}, // 원하는 값을 중복확인하기위해서  JSON 형태로 DATA 전송
		            success: function(data){ 
		             if (data == "N" ){ // 만약 성공할시
		                    result = "사용 가능한 아이디입니다.";
		                    $("#result_checkMerId").html(result).css("color", "green");
		                    $("#mer_pw").trigger("focus");
		                    idMerChecked = true; // 중복 검사를 실행했음을 기록
		             }else if(data == "E" ){
		                    result = "아이디를 입력해 주세요.";
		                    $("#result_checkMerId").html(result).css("color", "red");
		                    $("#mer_pw").trigger("focus");
		                    idMerChecked = false; // 중복 검사를 실행했음을 기록
		             }else if(data == "L" ){
		                    result = "아이디는 6-12자의 영문, 숫자, 기호( - _ )만 사용이 가능합니다";
		                    $("#result_checkMerId").html(result).css("color", "red");
		                    $("#mer_pw").trigger("focus");
		                    idMerChecked = false; // 중복 검사를 실행했음을 기록
		             }else if(data == "V" ){
		                    result = "아이디는 영문, 숫자, 기호( - _ )만 사용이 가능합니다";
		                    $("#result_checkMerId").html(result).css("color", "red");
		                    $("#mer_pw").trigger("focus");
		                    idMerChecked = false; // 중복 검사를 실행했음을 기록
		             }else{ // 만약 실패할시
		                 result="이미 사용중인 아이디입니다.";
		                     $("#result_checkMerId").html(result).css("color","red");
		                     $("#mer_id").val("").trigger("focus");
		                     idMerChecked = false; // 중복 검사를 실행하지 않았음을 기록
		             }
		         },
		            error : function(error){alert(error);}
		        });
		    });
		});
		
		//사업자 등록번호 조회
		$(function(){ 
		    $("#checkMer").click (function(){
		    	var reg1 = document.f.mer_comnum1.value;
	            var reg2 = document.f.mer_comnum2.value;
	            var reg3 = document.f.mer_comnum3.value;
	            

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
		
    function isValidPassword(password) {
        //  최소 8자리 이상 영문 대소문자, 숫자, 특수문자가 각각 1개 이상 
        let regex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$/
        return regex.test(password);
    }
	
    function checkPasswd2() {
    	let password = $("#password").val();
        if (!isValidPassword(password)) {
            $("#checkPasswd2").show();
        } else {
            $("#checkPasswd2").hide();
        }
    }
    
    function checkPasswd() {
        let password = $("#password").val();
        let passwordCheck = $("#passwordCheck").val();

        if (password !== passwordCheck) {
            $("#checkPasswd").show();
        } else {
            $("#checkPasswd").hide();
        }
    }

    $(document).ready(function() {
        $("#checkPasswd").hide();
    }); 
    
	   function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수
	
	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("sample6_extraAddress").value = extraAddr;
	                
	                } else {
	                    document.getElementById("sample6_extraAddress").value = '';
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('postcode1').value = data.zonecode;
	                document.getElementById("sample6_address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("sample6_detailAddress").focus();
	                postChecked = true;
	            }
	        }).open();
	    }
	</script>
</head> 

<body onload="f.mer_id.focus()">
<header>
<div class="header-left">
		    <a href="merchant_main.do">
		        <img src="resources/merchant/img/ozlogo2.png" width="60" height="60">
		        <img src="resources/merchant/img/oz2.png" width="90" height="50">
		        <span class="partner-center" style="color:black"><b>파트너센터</b></span>
		    </a>
	    </div>
	    <div class="header-right">
	    </div>
	    </header>
    <main>
        <div class="registration-form-container">
            <form name="f" method="post" action="merchant_send_email.do" enctype="multipart/form-data">
                <h1>판매자 회원가입</h1>
<div class="form-group id-check-group">
                    <label for="mer_id">아이디</label>
                        <div class="id-input-container">
                    <input type="text" id="mer_id" name="mer_id" placeholder="아이디를 입력해 주세요." oninput="checkMerIdFalse()">
                    <button type="button" id="checkMerId">중복검사</button>
                    </div>
                    <span id="result_checkMerId"></span>
                </div>
                
				<div class="form-group">
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="mer_pw" placeholder="비밀번호를 입력해 주세요." oninput="checkPasswd2()">
                </div>

                <div class="form-group">
                    <label for="passwordCheck">비밀번호 확인</label>
                    <input type="password" id="passwordCheck" name="mer_pw2" placeholder="비밀번호를 정확하게 입력해 주세요." oninput="checkPasswd()">
                    <div id="checkPasswd" class="error-message">PASSWORD가 동일하지 않습니다</div>
                    <div id="checkPasswd2" class="error-message">비밀번호는 8자리 이상 영문 대소문자, 숫자, 특수문자가 각각 1개 이상이어야 합니다</div>
                </div>

				<div class="form-group">
                    <label for="mer_company">회사 이름</label>
                    <input type="text" id="mer_company" name="mer_company" placeholder="회사 이름을 입력해 주세요.">
                </div>
                
<div class="form-group">
    <label for="mer_comnum1">사업자 번호</label>
    <div class="business-num-container">
        <input type="text" id="mer_comnum1" name="mer_comnum1" class="business-num" placeholder="123" maxlength="3">
        <span>-</span>
        <input type="text" id="mer_comnum2" name="mer_comnum2" class="business-num" placeholder="45" maxlength="2">
        <span>-</span>
        <input type="text" id="mer_comnum3" name="mer_comnum3" class="business-num" placeholder="67890" maxlength="5">
        <button type="button" id="checkMer">사업자 등록번호 조회</button>
    </div>
    <span id="bs_result"></span>
</div>

				<div class="form-group">
    <label class="title" for="mer_business_registration">사업자 등록증</label>
    <span id="comnum">파일형식은 '(사업자번호 10자)입니다. (사업자등록번호의 '-' 제외)</span>
    <input type="file" id="mer_business_registration" name="mer_business_registration">
</div>

<div class="form-group">
    <label for="postcode1">사업장 주소지</label>
    <div class="postcode-group">
        <input type="text" id="postcode1" name="member_postcode1" placeholder="우편번호" readOnly>
        <button type="button" onclick="sample6_execDaumPostcode()">우편번호 찾기</button>
    </div>
    <input type="text" id="sample6_address" name="sample6_address" placeholder="주소" readOnly>
    <input type="text" id="sample6_detailAddress" name="sample6_detailAddress" placeholder="상세주소">
    <input type="text" id="sample6_extraAddress" name="sample6_extraAddress" placeholder="참고항목" readOnly>
</div>

<div class="form-group">
    <label class="title" for="mer_name">판매자 이름</label>
    <input type="text" id="mer_name" name="mer_name" maxlength="20">
</div>

<div class="form-group">
    <label for="mer_hp1">판매자 전화 번호</label>
    <div class="input-group">
        <input type="text" id="mer_hp1" name="mer_hp1" maxlength="3">-
        <input type="text" id="mer_hp2" name="mer_hp2" maxlength="4">-
        <input type="text" id="mer_hp3" name="mer_hp3" maxlength="4">
    </div>
</div>

<div class="form-group">
    <label class="title" for="mer_email">판매자 E-mail</label>
    <input type="text" id="mer_email" name="mer_email">
</div>

<div class="form-group">
    <label class="title" for="mer_comintro">회사 소개</label>
    <textarea id="mer_comintro" name="mer_comintro" placeholder="회사 소개를 가독성 있게 작성해 주세요." class="box"></textarea>
</div>

<div class="form-group">
    <label class="title" for="mer_prodintro">상품 소개</label>
    <textarea id="mer_prodintro" name="mer_prodintro" class="box"></textarea>
</div>

<div class="button-group">
    <input type="button" value="다음" onclick="javascript:check(f.mer_business_registration)">
    <input type="reset" value="reset">
</div>

	</form>
	</div>
	</div> 
	</main>
</body>
</html>
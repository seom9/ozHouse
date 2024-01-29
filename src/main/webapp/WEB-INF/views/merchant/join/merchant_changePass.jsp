<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 <head>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/merchant/css/styleMain.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/merchant/css/change_style.css">
	
<script>
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
</script>
</head>

<body onload="f.member_id.focus()">
<header>
<div class="header-left">
		    <a href="merchant_main.do">
		        <img src="resources/merchant/img/ozlogo2.png" width="60" height="60">
		        <img src="resources/merchant/img/oz2.png" width="90" height="50">
		        <span class="partner-center"><b>파트너센터</b></span>
		    </a>
	    </div>
	    <div class="header-right">
	    </div>
	    </header>
	    <br><br><br>
<div class="container">
	<div class="find-id">비밀번호 변경</div>	    
		<form name="f" method="post" id="login-form" action="merchant_changePass.do">
			
			
			<c:if test="${not empty mode}">
			<span class="title">아이디</span>
				${member_id}
			</c:if>
			
			<c:if test="${empty mode}">
			<span class="title">현재 비밀번호</span>
			<input type="password" tabindex="3" name="member_passwd" placeholder="비밀번호를 입력해 주세요." class="box" placeholder="Enter password">
			</c:if>
			
			<br><br>
			<span class="title3">비밀번호</span>
	        <input type="password" tabindex="3" name="new_member_passwd" placeholder="비밀번호를 입력해 주세요." class="box" id="password" oninput="checkPasswd2()">
			<span class="title3">비밀번호 확인</span>
			<input type="password" tabindex="4" placeholder="비밀번호를 정확하게 입력해 주세요." name="new_member_passwd2" class="box" id="passwordCheck" oninput="checkPasswd()">
                    <div id="checkPasswd" class="error-message">
  						PASSWORD 가 동일하지 않습니다
					</div>
					<div id="checkPasswd2" class="error-message">
  						비밀번호는 8자리 이상 영문 대소문자, 숫자, 특수문자가 각각 1개 이상이어야 합니다
					</div>
					<div class="button-group">
			<input type="hidden" name="mode" value="${mode}">
			<input type="hidden" name="member_id" value="${member_id}">
			<input type="submit" value="비밀번호 수정">
			<input type="reset" value="reset">
			</div>
		</form>
	</div>
</body>

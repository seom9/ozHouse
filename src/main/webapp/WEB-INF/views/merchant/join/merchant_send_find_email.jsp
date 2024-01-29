<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
	function checkNumber() {
	    var oauthNum = parseInt(${oauthNum}); // 여기에 비교하고 싶은 숫자를 넣으세요.
	    var userInput = document.getElementById('numberInput').value;
	
	    if (parseInt(userInput) === oauthNum) {
	    	document.f.submit();
	    } else {
	        alert('인증번호가 일치하지 않습니다. 다시 확인해 주세요.');
	    }
	}
</script>

<html>
<head>
	<title>회원 정보 찾기</title>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/merchant/css/styleMain.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/merchant/css/find_style.css">
</head>  

<body onload="f.member_email.focus()">
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
        <div class="find-id">아이디 / 비밀번호 찾기</div>
		<form name="f" method="post" id="login-form" action="merchant_find.do">
			<span class="title">입력하신 이메일 주소</span>
			<input type="text" tabindex="2" class="box" value="${member_email}" id="member_email" name="mer_email" ReadOnly>
			<br><br>
			<span class="title">받으신 6자리 인증번호를 입력해 주세요</span>
			<input type="text" name="userSendNum" class="box" id="numberInput">
			<input type="hidden" name="oauthNum" value="${oauthNum}">
			
			<input type="button" value="회원정보 찾기" onclick="javascript:checkNumber()">
		</form>
	</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/top.jsp" %>   

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
	<link rel="stylesheet" href="${path}/resources/login.css"/>
</head>  

<body onload="f.member_email.focus()">
	<div  align="center" class="login-wrapper" >
		<br><br><br>
		<h2><img src="${path}/resources/client/ozHouseLogo.png" style="width: 20%"></h2>
		<font face="Roboto, sans-serif">아이디 / 비밀번호 찾기</font>
		<p>
		<form name="f" method="post" id="login-form" action="member_find.do">
			<br><br>
			<span class="title">입력하신 이메일 주소</span>
			<input type="text" tabindex="2" class="box" value="${member_email}" id="member_email" name="member_email" ReadOnly>
			
			<br><br>
			
			<span class="title">받으신 6자리 인증번호를 입력해 주세요</span>
			<input type="text" name="userSendNum" class="box" id="numberInput">
			<input type="hidden" name="oauthNum" value="${oauthNum}">
			
			<input type="button" value="회원정보 찾기" onclick="javascript:checkNumber()">
		</form>
	</div>
</body>
</html>
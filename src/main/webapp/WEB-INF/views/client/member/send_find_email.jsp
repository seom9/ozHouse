<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/top.jsp" %>   

<script type="text/javascript">
	function checkNumber() {
        var member_email = document.getElementById("member_email").value;
        document.getElementById("login-form").action = "/member/" + member_email + "/find";
        document.getElementById("login-form").submit(); // Form 제출
	}
</script>

<html>
<head>
	<title>회원 정보 찾기</title>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<link rel="stylesheet" href="${path}/client/member_css/login.css"/>
</head>  

<body onload="f.member_email.focus()">
	<div  align="center" class="login-wrapper" >
		<br><br><br>
		<h2><img src="${path}/client/image/ozHouseLogo.png" style="width: 20%"></h2>
		<font face="Roboto, sans-serif">아이디 / 비밀번호 찾기</font>
		<p>
		<form name="f" method="post" id="login-form">
			<br><br>
			<span class="title">입력하신 이메일 주소</span>
			<input type="text" tabindex="2" class="box" value="${memberEmail}" id="member_email" name="memberEmail" ReadOnly>
			
			<br><br>
			
			<span class="title">받으신 6자리 인증번호를 입력해 주세요</span>
			<input type="text" name="userSendNum" class="box" id="numberInput">
			<input type="hidden" value="${checkNum}" name="checkNum">
			<input type="button" value="회원정보 찾기" onclick="javascript:checkNumber()">
		</form>
	</div>
</body>
</html>
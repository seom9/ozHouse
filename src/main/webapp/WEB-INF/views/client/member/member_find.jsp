<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/top.jsp" %>   

<script type="text/javascript">
	function sendFindEmail(){
		document.f.submit();
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
		<form name="f" method="post" id="login-form" action="send_find_email.do">
			<br><br>
			<span class="title">가입한 이메일 주소를 입력해 주세요</span>
			<input type="text" tabindex="2" class="box" id="member_email" name="member_email">
			
			<input type="button" value="인증 이메일 보내기" onclick="javascript:sendFindEmail()">
		</form>
	</div>
</body>
</html>
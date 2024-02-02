<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/top.jsp" %>   
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${path}/client/member_css/login.css"/>
<title>이메일 인증</title>
	<script type="text/javascript">
		function check(){
			if (f.checkNum.value == ""){
				alert("인증 번호를 입력해 주세요")
				f.checkNum.focus()
				return
			}
			document.f.submit();
		}
	</script>	
</head>
<body>
<div  align="center" class="login-wrapper" >
	<h1>회원 가입</h1>
	<br><br>
	<font face="Roboto, sans-serif">이메일 인증 번호를 입력하세요</font>
	<form name="f" method="Post" id="login-form" action="email_join_check.do">	
		<span class="title">이메일 주소 : </span>
		<span class="title">${email}</span>
		<input type="text" id="member_id" placeholder="받으신 인증번호 8자리를 입력해 주세요" name="checkNumCheck" class="box">
			<input type="hidden" name="checkNum" value="${checkNum}">
			<input type="hidden" name="memberId" value="${member.memberId}"/>
			<input type="hidden" name="memberPasswd" value="${member.memberPasswd}"/>
			<input type="hidden" name="memberEmail" value="${email}"/>
			<input type="hidden" name="memberNickname" value="${member.memberNickname}"/>
			<input type="button" value="인증번호 확인" onclick="check()">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
			
	</form>
</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${path}/resources/merchant/login.css"/>
<link rel="stylesheet" type="text/css" href="${path}/resources/merchant/css/styleMain.css">
<link rel="stylesheet" type="text/css" href="${path}/resources/merchant/css/find_style.css">
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
        <div class="find-id">회원가입</div>
	<form name="f" method="post" id="login-form" action="merchant_email_join_check.do">	
        
        <div class="email-verification-instruction">
                <span class="title">이메일 인증 번호를 입력하세요</span>
            </div>
		<span class="title">이메일 주소 : </span>
		<span class="title">${email}</span>
		<input type="text" id="member_id" placeholder="받으신 인증번호 8자리를 입력해 주세요" name="checkNumCheck" class="box">
			<input type="hidden" name="checkNum" value="${checkNum}">
			<input type="button" value="인증번호 확인" onclick="check()">
	</form>
</div>
</body>
</html>
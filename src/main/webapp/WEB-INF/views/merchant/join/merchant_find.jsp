<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/merchant/css/styleMain.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/merchant/css/find_style.css">
<script type="text/javascript">
	function sendFindEmail(){
		document.f.submit();
	}
</script>
<html>
<head>
	<title>OZ의 집 : 회원 정보 찾기</title>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
        <form name="f" method="post" id="login-form" action="merchant_send_find_email.do">
            <span class="title">가입한 이메일 주소를 입력해 주세요</span>
            <input type="text" tabindex="2" class="box" id="member_email" name="mer_email">
            <input type="button" value="인증 이메일 보내기" onclick="javascript:sendFindEmail()">
        </form>
	</div>
    </body>


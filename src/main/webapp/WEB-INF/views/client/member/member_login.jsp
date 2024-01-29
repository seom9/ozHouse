<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../main/top.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${path}/resources/client/login.css"/>
<script type="text/javascript">
	function searchMember(mode){
		window.open("searchMember.do?mode="+mode, "search", "width=640, height=400")
	}
	function loginCheck(){
		if (f.member_id.value == ""){
			alert("아이디를 입력해 주세요!!")
			f.id.focus()
			return
		}
		if (f.member_passwd.value == ""){
			alert("비밀번호를 입력해 주세요!!")
			f.passwd.focus()
			return
		}
		document.f.submit()
	}
</script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

</head>
<title>Login</title>
</head>
<body> 
    <div align="center" class="login-wrapper" style="top: 70px; position: relative;">
        <h2><img src="${path}/resources/client/image/ozHouseLogo.png" style="width: 30%"></h2>
        <form method="post" action="member_login.do" id="login-form" name="f">
         
			<c:if test="${not empty cookie.saveId}">
            	<input type="text" name="member_id" tabindex="1"  value="${cookie['saveId'].value}">
			</c:if>	
			<c:if test="${empty cookie.saveId}">
            	<input type="text" name="member_id" tabindex="2" placeholder="아이디 입력">
            </c:if>	
            <input type="password" name="member_passwd" placeholder="비밀번호 입력">
            <label for="remember-check">
		<c:if test="${not empty cookie.saveId}">
            <input type="checkbox" name="saveId" checked>
		</c:if>	    
		<c:if test="${empty cookie.saveId}">     
            <input type="checkbox" name="saveId" id="remember-check">
		</c:if>	     
            <font face="Roboto, sans-serif">아이디 저장하기</font>
            </label>
            <input type="button" value="로그인"
            	  onclick="javascript:loginCheck()">
            	  <style>
            	  .join {
    				position: relative; 				    
    				margin: 10; 
    				padding: 10;
    				font-size: 14px;
}
					.join1 {
    				position: relative;  				    
    				margin: 0; 
    				padding: 30;
    				font-size: 14px;
}					
					.join2 {
    				position: relative;  				    
    				margin: 30; 
    				padding: 30;
    				line-height: 50px;
    				font-size: 11px;
}					
            	  </style>
           	<span class="join"><a href="member_find.do">비밀번호 재설정</a></span>              
            <span class="join1"><a href="member_join.do">회원가입</a></span>   <br>
            <span class="join2">sns계정으로 간편 로그인/회원가입</span>  
            
        </form>
        <section>
        
        <a datatype="github" class="css-l0qndx e1ufx3to0" href="/users/auth/github">
        <img src="${path}/resources/client/image/github.png">
        </a>
        <a datatype="kakao" class="css-l0qndx e1ufx3to0" href="https://kauth.kakao.com/oauth/authorize?client_id=e5b283df9616f7c21f3e15db5f9b0df2&redirect_uri=http://localhost:8080/ozHouse/kakao_login.do&response_type=code">
        <img src="${path}/resources/client/image/kakao.png">
        </a>
        <a datatype="naver" class="css-l0qndx e1ufx3to0" href="naverLogin.do">
        <img src="${path}/resources/client/image/naver.png">
        </a><br>
     	<span class="join3">로그인에 문제가 있으신가요?</span>
     	<style>
     	.join3 {
    				position: relative;  				    
    				margin: 30; 
    				padding: 30;
    				line-height: 70px;
    				font-size: 12px;
}					
     	</style>
     	<hr color="#50E5B4" align="center">
    </div>
    
</body>
</html>





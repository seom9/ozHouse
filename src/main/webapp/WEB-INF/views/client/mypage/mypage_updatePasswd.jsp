<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../mypage/mypage_top.jsp" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<link rel="stylesheet" href="${path}/resources/client/login.css"/>
	
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
		.join3 {
			position: relative;  				    
			margin: 30; 
			padding: 30;
			line-height: 70px;
			font-size: 12px;
		}  
		.error-message {
		    font-family: 'Roboto', sans-serif;
		    color: red;
	 	}
	    .title {
	        font-family: 'Roboto', sans-serif;
	        color: black; /* 검정색으로 변경 */
	        font-size: 15px; /* 글꼴 크기를 15픽셀로 지정 */
	        margin: 30px 0; 
	    }   
	 		
	 	.title2 {
	        font-family: 'Roboto', sans-serif;
	        color: #58E6B7; /* 검정색으로 변경 */
	        font-size: 20px; /* 글꼴 크기를 15픽셀로 지정 */
	        margin: 30px 0; 
	    }  	
	    .title3 {
	        font-family: 'Roboto', sans-serif;
	        color: #58E6B7; /* 검정색으로 변경 */
	        font-size: 15px; /* 글꼴 크기를 15픽셀로 지정 */
	        margin: 30px 0; 
	    }  	    
				
	 </style>
</head>

<body onload="f.member_id.focus()">
	<div  align="center" class="login-wrapper" >
		<form name="f" method="post" id="login-form" action="mypage_upadatePasswd.do">
 			<br><br><br>
			<span class="title2">비밀번호 변경</span>
			<br><br><br><br>
			
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
			<input type="hidden" name="mode" value="${mode}">
			<input type="hidden" name="member_id" value="${member_id}">
			<input type="submit" value="비밀번호 수정">
			<input type="reset" value="reset">
		</form>
	</div>
</body>
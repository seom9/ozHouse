<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/top.jsp" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<link rel="stylesheet" href="${path}/client/member_css/login.css"/>
	
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

<!-- Json Data 전송 -->
<script type="text/javascript">
    function passUpdate() {
    	// ** json data 전송 시 jstl 태그 자바스크립트에 안 먹음 ** // 
    	var mode = document.getElementById("mode").value
    	var member = document.getElementById("member").value
		var memberPasswd = document.getElementById("memberPasswd").value
		var newMemberPasswd = document.getElementById("password").value
        fetch('/member/' + member + "/updatepass/" + mode, {
            method: 'PATCH', 
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
            	member : member,
                memberPasswd : memberPasswd,
                newMemberPasswd : newMemberPasswd
            }),
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text(); 
        })
        .then(data => {
            alert(data)
            location.reload()
        })
        .catch(error => {
        	alert("서버 통신에 실패했습니다 : 관리자에게 문의해 주세요")
        });
    }
</script>

</head>

<body onload="f.member_id.focus()">
	<div  align="center" class="login-wrapper" >
		<form name="f" method="post" id="login-form">
 			<br><br><br><br>
			<span class="title2">비밀번호 변경</span>
			<br><br><br><br>
			
			<c:if test="${mode == 'find'}">			
				<span class="title">이메일</span>
				<input type="text" value="${member}" id="memberEmail" tabindex="3" name="memberEmail" ReadOnly>
			</c:if>
						
			<c:if test="${mode == 'up'}">
				<span class="title">현재 비밀번호</span>
				<input type="password" tabindex="3" name="memberPasswd" id="memberPasswd" placeholder="비밀번호를 입력해 주세요." class="box" placeholder="Enter password">
			</c:if>
			
			<c:if test="${mode == 'find'}">
				<input type="hidden" tabindex="3" name="memberPasswd" id="memberPasswd" placeholder="비밀번호를 입력해 주세요." class="box" placeholder="Enter password">
			</c:if>
			
			<br><br>
			<span class="title3">비밀번호</span>
	        <input type="password" tabindex="3" name="newMemberPasswd" placeholder="비밀번호를 입력해 주세요." class="box" id="password" oninput="checkPasswd2()">
			<span class="title3">비밀번호 확인</span>
			<input type="password" tabindex="4" placeholder="비밀번호를 정확하게 입력해 주세요." name="newMemberPasswd2" class="box" id="passwordCheck" oninput="checkPasswd()">
                <div id="checkPasswd" class="error-message">
 						PASSWORD 가 동일하지 않습니다
				</div>
				<div id="checkPasswd2" class="error-message">
 						비밀번호는 8자리 이상 영문 대소문자, 숫자, 특수문자가 각각 1개 이상이어야 합니다
				</div>
			
			<input type="hidden" value="${memberId}" id="memberId" tabindex="3" name="memberId">
			
			<input type="hidden" value="${member}" id="member" tabindex="3" name="member">
			
			<input type="hidden" value="${mode}" id="mode">
			
			<input type="button" value="비밀번호 수정" onclick="javascript:passUpdate()">
			<input type="reset" value="reset">
		</form>
	</div>
</body>
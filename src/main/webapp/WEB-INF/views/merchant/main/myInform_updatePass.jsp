<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="resources/merchant/css/change_pass_style.css">
    
<%@ include file="mainTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>OZ의 집 : 비밀번호 변경</title>
<script type="text/javascript">

function isValidPassword(password) {
    //  최소 8자리 이상 영문 대소문자, 숫자, 특수문자가 각각 1개 이상 
    let regex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$/
    return regex.test(password);
}

function check(pw){
    var nowPw = document.f.now_pw.value;
    var merPw1 = document.f.mer_pw.value;
    var merPw2 = document.f.mer_pw2.value;

    if(nowPw != pw){
        alert("현재 비밀번호와 일치하지 않습니다.");
        return false;
    }
    if(merPw1 != merPw2){
        alert("비밀번호가 일치하지 않습니다.");
        return false;
    }
    if(merPw1 == pw){
        alert("이전 비밀번호와 동일합니다.");
        return false;
    }
    if (!isValidPassword(merPw1)) {
    	alert("비밀번호는 8자리 이상 영문 대소문자, 숫자, 특수문자가 각각 1개 이상이어야 합니다.");
    	return false;
    }
   
    return true;
}
</script>

<body>
<div align="center">
<form name="f" action="myInform_updatePass.do" method="post" onsubmit="return check('<c:out value="${merchantLoginMember.mer_pw}" />');">
		<input type="hidden" name="mer_num" value="${merchantLoginMember.mer_num}">
		<input type="hidden" name="mer_id" value="${merchantLoginMember.mer_id}">
		<div class="flex-container">
			<div class="flex-row">
			 	<div class="flex-header">
			 		현재 비밀번호
			 	</div>
			 	<div class="flex-content">
			 		<input type="password" tabindex="3" name="now_pw" placeholder="비밀번호를 입력해 주세요." class="box" placeholder="Enter password" id="password">
			 	</div>
			 </div>
			 <div class="flex-row">
			 	<div class="flex-header">
			 		변경할 비밀번호
			 	</div>
			 	<div class="flex-content">
			 		<input type="password" tabindex="3" name="mer_pw" placeholder="비밀번호를 입력해 주세요." class="box" placeholder="Enter password" id="password">
			 	</div>
			 </div>
			 <div class="flex-row">
			 	<div class="flex-header">
			 		비밀번호 확인
			 	</div>
			 	<div class="flex-content">
			 		<input type="password" tabindex="4" placeholder="비밀번호를 정확하게 입력해 주세요." name="mer_pw2" class="box" placeholder="Enter passwordCheck" id="passwordCheck">
			 	</div>
			 </div>
			<input type="submit" value="변경">
			<input type="button" value="취소" 
				onclick="location.href='myInform_view.do?mer_num=${merchantLoginMember.mer_num}'">
		</div>
	</form>
</div>
</body>
<%@ include file="mainBottom.jsp" %>
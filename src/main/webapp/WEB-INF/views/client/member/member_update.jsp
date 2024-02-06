<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 
 <%@ include file="../mypage/mypage_top.jsp" %>  
<html>
<head>
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<title>회원 정보 수정</title>
	<script type="text/javascript">
		function check(){
	        var memberId = document.getElementById("memberId").value;
	        document.getElementById("login-form").action = "/member/" + memberId;
			document.f.submit()
		}
	</script>	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	    function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수
	
	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("sample6_extraAddress").value = extraAddr;
	                
	                } else {
	                    document.getElementById("sample6_extraAddress").value = '';
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('postcode1').value = data.zonecode;
	                document.getElementById("sample6_address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("sample6_detailAddress").focus();
	            }
	        }).open();
	    }
	</script>
	<link rel="stylesheet" href="${path}/client/login.css"/>
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
				
	 </style>
	
</head>  
<body onload="f.member_id.focus()">
	<div  align="center" class="login-wrapper">
		<form name="f" method="post" id="login-form" enctype="multipart/form-data">
 			<br><br><br>
			<span class="title2">프로필 수정</span>
			<br><br><br><br>
			<span class="title">프로필 사진</span><br>
			<c:if test="${fn:startsWith(member.member_image, 'http')}">
		        <img src="${member.memberImage}" width="40%" height="60%">
		        <input type="file" name="memberImage" class="box">
		        <input type="hidden" name="memberImage2" value="${member.memberImage}"/>
			</c:if>
			<c:if test="${not fn:startsWith(member.memberImage, 'http')}">
		        <img src="${path}/resources/image/${member.memberImage}" width="30%" height="40%">
		        
		        <input type="file" name="memberImage" class="box">
		        <input type="hidden" name="memberImage2"/>
			</c:if>
				<span class="title">아이디</span>
					<input type="text" name="memberId" id="memberId" value="${member.memberId}" class="box" ReadOnly>
				<span class="title">이메일</span>
					<input type="text" value="${member.memberEmail}" class="box" ReadOnly>
				<span class="title">닉네임</span>
					<input type="text" placeholder="닉네임을 입력해 주세요." name="member_nickname" value="${member.member_nickname}" class="box">
				<span class="title">연락처</span><br>
					<input type="text" name="PhoneNumber1" value="${member.PhoneNumber1}" class="member_hp" size="3" maxlength="3"> -
					<input type="text" name="PhoneNumber2" value="${member.PhoneNumber2}" class="member_hp" size="4" maxlength="4"> -
					<input type="text" name="PhoneNumber3" value="${member.PhoneNumber3}" class="member_hp" size="4" maxlength="4">
				<br>
				<span class="title">집 주소 설정</span>
					<span class="title">주소 1</span>
					<input type="text" id="postcode1" name="postcode" value="${member.Address.postcode}" placeholder="우편번호">
					<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="sample6_address" name="city" value="${member.Address.city}" placeholder="주소"><br>
					<input type="text" id="sample6_detailAddress" name="street" value="${member.Address.street}" placeholder="상세주소">
					<input type="text" id="sample6_extraAddress" name="zipcode" value="${member.Address.zipcode}" placeholder="참고항목">
					<input type="submit" value="정보 수정">
					<input type="reset" value="reset">
					
					<input type="hidden" name="_method" value="PUT"/>
					
		</form>
	</div>
</body>
</html>
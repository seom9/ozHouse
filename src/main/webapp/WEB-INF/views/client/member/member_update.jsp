<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 
 <%@ include file="../mypage/mypage_top.jsp" %>  
<html>
<head>
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<title>회원 정보 수정</title>
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script type="text/javascript">
	    function update() {	    	
	        var memberId = document.getElementById("memberId").value;	
	        var memberNickname = document.getElementsByName("memberNickname")[0].value;			
	        var phoneNumber1 = document.getElementsByName("phoneNumber1")[0].value;
	        var phoneNumber2 = document.getElementsByName("phoneNumber2")[0].value;
	        var phoneNumber3 = document.getElementsByName("phoneNumber3")[0].value;
	        var postcode = document.getElementById("postcode1").value;	        
	        var city = document.getElementsByName("city")[0].value;	
	        var street = document.getElementsByName("street")[0].value;
	        var zipcode = document.getElementsByName("zipcode")[0].value;

	        fetch('/mypage/' + memberId + "/update", {
	            method: 'PATCH', // PUT 메소드를 지정합니다.
	            headers: {
	                'Content-Type': 'application/json'
	            },
	            body: JSON.stringify({
	                memberNickname: memberNickname,
	                memberHp: {
	                	phoneNumber1: phoneNumber1,
	                	phoneNumber2: phoneNumber2,
	                	phoneNumber3: phoneNumber3
	                },
	                memberAddress: {
	                	postcode: postcode,
	                	city: city,
	                	street: street,
	                	zipcode: zipcode
	                }
	            }),
	        })
	        .then(response => {
	            if (!response.ok) {
	                throw new Error('Network response was not ok');
	            }
	            return response.text(); 
	        })
	        .then(data => {
	        	// 상태 알림 return 받아와서 alert 로 출력
	            alert(data)
	        })
	        .catch(error => {
	        	alert("회원 정보 수정이 실패되었습니다")
	        });
	    }
	</script>
	
	<script type="text/javascript">
	    document.getElementById("login-form").addEventListener("submit", function(event) {
	        event.preventDefault(); // 기본 동작인 폼의 submit을 막습니다.
	
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
	<link rel="stylesheet" href="${path}/client/member_css/login.css"/>
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

	<script type="text/javascript">
    	var mode = "${mode}";
	    if (mode === "fail") {
	        alert("회원 정보 수정에 실패하였습니다");
	    } else if (mode === "success") {
	        alert("회원 정보 수정에 성공하였습니다");
	    }
	</script>

</head>  
<body onload="f.member_id.focus()">
	<div  align="center" class="login-wrapper">
		<form name="f" method="post" id="login-form">
 			<br><br><br>
			<span class="title2">프로필 수정</span>
			<br><br><br><br>
			<span class="title">프로필 사진</span><br>
			<!-- 
			<c:if test="${fn:startsWith(member.memberImage, 'http')}">
		        <img src="${member.memberImage}" width="40%" height="60%">
		        <input type="file" name="memberImage" class="box">
		        <input type="hidden" name="memberImage2" value="${member.memberImage}"/>
			</c:if>
			<c:if test="${not fn:startsWith(member.memberImage, 'http')}">
		        <img src="${path}/resources/image/${member.memberImage}" width="30%" height="40%">
		        
		        <input type="file" name="memberImage" class="box">
		        <input type="hidden" name="memberImage2"/>
			</c:if>
			 -->
				<span class="title">아이디</span>
					<input type="text" name="memberId" id="memberId" value="${member.memberId}" class="box" ReadOnly>
				<span class="title">이메일</span>
					<input type="text" value="${member.memberEmail}" class="box" ReadOnly>
				<span class="title">닉네임</span>
					<input type="text" placeholder="닉네임을 입력해 주세요." name="memberNickname" value="${member.memberNickname}" class="box">
				<span class="title">연락처</span><br>
					<input type="text" name="phoneNumber1" value="${member.memberHp.PhoneNumber1}" class="member_hp" size="3" maxlength="3"> -
					<input type="text" name="phoneNumber2" value="${member.memberHp.PhoneNumber2}" class="member_hp" size="4" maxlength="4"> -
					<input type="text" name="phoneNumber3" value="${member.memberHp.PhoneNumber3}" class="member_hp" size="4" maxlength="4">
				<br>
				<span class="title">집 주소 설정</span>
					<span class="title">주소 1</span>
					<input type="text" id="postcode1" name="postcode" value="${member.memberAddress.postcode}" placeholder="우편번호">
					<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="sample6_address" name="city" value="${member.memberAddress.city}" placeholder="주소"><br>
					<input type="text" id="sample6_detailAddress" name="street" value="${member.memberAddress.street}" placeholder="상세주소">
					<input type="text" id="sample6_extraAddress" name="zipcode" value="${member.memberAddress.zipcode}" placeholder="참고항목">
					<input type="button" value="정보 수정" onclick="javascript:update()">
					<input type="reset" value="reset">
		</form>
	</div>
</body>
</html>
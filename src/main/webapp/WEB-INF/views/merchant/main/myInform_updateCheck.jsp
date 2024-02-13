<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/styleMain.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/info_style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>OZ의 집 : 본인확인</title>
<script type="text/javascript">
	function pressEnter(e) {
		if (e.keyCode == 13) {
			check('${merchantLoginMember.merId}',
					'${merchantLoginMember.merPw}');
		}
	}

	function check(id, pw) {
		var merIdInput = document.getElementsByName("merId")[0];
		var merPwInput = document.getElementsByName("merPw")[0];
		var mode = '${param.mode}';

		if (merIdInput.value != id) {
			alert("아이디와 로그인정보가 일치하지 않습니다.");
			return;
		}
		if (merPwInput.value != pw) {
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}

		if (!merIdInput || !merPwInput) {
			alert("ID와 비밀번호를 입력해주세요.");
			return;
		}
		if (mode == 'pass') {
			location.href = "${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/password";
		} else if (mode == 'inform') {
			location.href = "${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/info";
		} else if (mode == 'out') {
			if (window.confirm("정말로 회원 탈퇴를 진행하시겠습니까?")) {
				location.href = "${pageContext.request.contextPath}/merchants/${merchantLoginMember.merNum}/delete";
			}

		}

		return;
	}
</script>

<header>
	<div class="header-left">
		<a href="${pageContext.request.contextPath}/merchant/main"> <img
			src="${pageContext.request.contextPath}/merchant/img/ozlogo2.png"
			width="60" height="60"> <img
			src="${pageContext.request.contextPath}/merchant/img/oz2.png"
			width="90" height="50"> <span class="partner-center"><b>파트너센터</b></span>
		</a>
	</div>
	<div class="header-right"></div>
</header>
<body style="background-color: #F4F4F4">
	<div class="container">
		<div class="find-id">본인 인증</div>
		<span class="title">ID</span> <input type="text" name="merId"
			class="box"> <span class="title">PW</span> <input
			type="password" name="merPw" class="box"
			onkeypress="return pressEnter(event)">
		<button
			onclick="check('${merchantLoginMember.merId}', '${merchantLoginMember.merPw}');">인증</button>
	</div>
	</div>
</body>

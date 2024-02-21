<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ include file="../mypage/mypage_top.jsp"%>

<head>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/client/member_css/memberdelete.css" />
<script type="text/javascript">
window.onload = function() {
    var checkbox = document.querySelector('input[type="checkbox"].box123');
    var submitButton = document.querySelector('input[type="submit"]');

    // 초기 상태에서 submit 버튼 비활성화
    submitButton.disabled = true;

    // 체크박스 상태 변경 시 이벤트 리스너
    checkbox.addEventListener('change', function() {
        // 체크박스가 선택되어 있으면 submit 버튼 활성화, 그렇지 않으면 비활성화
        submitButton.disabled = !this.checked;
    });
};
</script>
</head>

<form name="f" method="post" action="/member/delete">
<div class="box">
	<h2>회원 탈퇴 신청</h2>
	<br>
	<h3>
		<b>회원 탈퇴 신청에 앞서 아래 내용을 반드시 확인해주세요.</b>
	</h3>
	<br>
	<div class="css-15t02j8">
		<h3>
			<b>회원탈퇴 시 처리내용</b>
		</h3>
		<ul>
			<li>&nbsp; - 오즈의 집 포인트·쿠폰은 소멸되며 환불되지 않습니다.</li>
			<li>&nbsp; - 오즈의 집 구매 정보가 삭제됩니다.</li>
			<li>&nbsp; - 소비자보호에 관한 법률 제6조에 의거,계약 또는 청약철회 등에 관한 기록은 5년, 대금결제
				및 재화등의 공급에 관한 기록은 5년, 소비자의 불만 또는 분쟁처리에 관한 기록은 3년 동안 보관됩니다. 동 개인정보는
				법률에 의한 보유 목적 외에 다른 목적으로는 이용되지 않습니다.</li>
		</ul>
		<br>
		<h3>
			<b>회원탈퇴 시 게시물 관리</b>
		</h3>
		회원탈퇴 후 오즈의 집 서비스에 입력한 게시물 및 댓글은 삭제되지 않으며, 회원정보 삭제로 인해 작성자 본인을 확인할 수
		없으므로 게시물 편집 및 삭제 처리가 원천적으로 불가능 합니다. 게시물 삭제를 원하시는 경우에는 먼저 해당 게시물을 삭제 하신
		후, 탈퇴를 신청하시기 바랍니다.<br> <br>
		<h3>
			<b>회원탈퇴 후 재가입 규정</b>
		</h3>
		탈퇴 회원이 재가입하더라도 기존의 오즈의 집 포인트는 이미 소멸되었기 때문에 양도되지 않습니다.<br>
	</div>
	<label> 
		<input type="checkbox" class="box123" name="confirmed">&nbsp; 위 내용을 모두 확인하였습니다.&nbsp;<span class="css-alijph e187gapo3" style="color: red;">필수</span></span>
	</label> <br>
	<br>
	<br>
	<br>
	
	<h3>
		<b>오즈의 집 서비스 이용 중 어떤 부분이 불편하셨나요?</b> &nbsp; <span class="css-alijph e187gapo3" style="color: gray;">선택</span>
	</h3>
	<div class="css-15t02j8">
		<textarea rows="5" cols="130" name="complain" placeholder="선택하신 항목에 대한 자세한 이유를 남겨주시면 서비스 개선에 큰 도움이 됩니다."></textarea>
	</div>
	
	<input type="submit" value="탈퇴하기">
	<input type="reset" value="reset">
</div>
</form>

</body>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="mainTop.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/myinfo_style.css">
<head>
<title>OZ의 집 : 나의 정보</title>
<script type="text/javascript">
	function setMode(mode) {
		document.getElementById('f').action = mode;
        document.getElementById('f').submit();
	}
</script>
</head>
<div class="container">
	<div class="main-notice" width="auto">
		<h1>나의 정보</h1>
		<br> <br>
		<div align="center">
			<form name="f" action="#" method="post">
				<input type="hidden" name="mode" value="inform">
				<div class="flex-container">
					<div class="flex-row">
						<div class="flex-header">상점명</div>
						<div class="flex-content">${merchantUpdate.merCompany}</div>
						<div class="flex-header"></div>
						<div class="flex-content"></div>
					</div>
					<div class="flex-row">
						<div class="flex-header">상점ID</div>
						<div class="flex-content">${merchantUpdate.merId}</div>
						<div class="flex-header"></div>
						<div class="flex-content"></div>
					</div>
					<div class="flex-row">
						<div class="flex-header">사업장소재지</div>
						<div class="flex-content">
							${merchantUpdate.merAdress} <input type="hidden"
								name="merAdress"
								value="${merchantUpdate.merAdress}">
						</div>
						<div class="flex-header"></div>
						<div class="flex-content"></div>
					</div>
					<div class="flex-row">
						<div class="flex-header">사업자등록증</div>
						<div class="flex-content">
							${merchantUpdate.merRegistration} <input type="hidden"
								name="merRegistration"
								value="${merchantUpdate.merRegistration}">
						</div>
						<div class="flex-header">사업자등록번호</div>
						<div class="flex-content">
							${merchantUpdate.merComnum1}-${merchantUpdate.merComnum2}-${merchantUpdate.merComnum3}
						</div>
					</div>
					<div class="flex-row">
						<div class="flex-header">상점담당자 이름</div>
						<div class="flex-content">
							${merchantUpdate.merName} <input type="hidden" name="merName"
								value="${merchantUpdate.merName}">
						</div>
						<div class="flex-header">핸드폰</div>
						<div class="flex-content">
							${merchantUpdate.merHp1}-${merchantUpdate.merHp2}-${merchantUpdate.merHp3}
							<input type="hidden" name="merHp1"
								value="${merchantUpdate.merHp1}"> <input type="hidden"
								name="merHp2" value="${merchantUpdate.merHp2}"> <input
								type="hidden" name="merHp3" value="${merchantUpdate.merHp3}">
						</div>
					</div>
					<div class="flex-row">
						<div class="flex-header">상점담장자 E-mail</div>
						<div class="flex-content">
							${merchantUpdate.merEmail} <input type="hidden" name="merEmail"
								value="${merchantUpdate.merEmail}">
						</div>
						<div class="flex-header"></div>
						<div class="flex-content"></div>
					</div>
					<div class="flex-row">
						<div class="flex-header">카테고리</div>
						<div class="flex-content">
						<c:if test="${empty merchantUpdate.merCategory}">
							미등록
						</c:if>
						<c:if test="${not empty merchantUpdate.merCategory}">
							<c:forEach var="cate" items="${merchantUpdate.merCategory}">
								${cate.categoryName}/
							</c:forEach>
						</c:if>
						</div>
						<div class="flex-header"></div>
						<div class="flex-content"></div>
					</div>
					<div class="flex-row">
						<div class="flex-header">판매관련 파일</div>
						<div class="flex-content">
							${merchantUpdate.merFile} <input type="hidden" name="merFile"
								value="${merchantUpdate.merFile}">
						</div>
						<div class="flex-header"></div>
						<div class="flex-content"></div>
					</div>
					<div class="flex-row">
						<div class="flex-header">회사 홈페이지</div>
						<div class="flex-content">
							${merchantUpdate.merHomepage} <input type="hidden"
								name="merHomepage" value="${merchantUpdate.merHomepage}">
						</div>
						<div class="flex-header"></div>
						<div class="flex-content"></div>
					</div>
					<div class="flex-row">
						<div class="flex-header">타입점 쇼핑몰</div>
						<div class="flex-content">
							${merchantUpdate.merOthershop} <input type="hidden"
								name="merOthershop" value="${merchantUpdate.merOthershop}">
						</div>
						<div class="flex-header"></div>
						<div class="flex-content"></div>
					</div>
					<div class="flex-row">
						<div class="flex-header">영업담당자 이름</div>
						<div class="flex-content">${merchantUpdate.merManname}</div>
						<div class="flex-header">영업담당자 핸드폰</div>
						<c:if test="${empty merchantUpdate.merManhp2}">
							<div class="flex-content">
								${merchantUpdate.merManhp1}
							</div>
						</c:if>
						<c:if test="${not empty merchantUpdate.merManhp2}">
							<div class="flex-content">
								${merchantUpdate.merManhp1}-${merchantUpdate.merManhp2}-${merchantUpdate.merManhp3}
							</div>
						</c:if>
					</div>
					<div class="flex-row">
						<div class="flex-header">영업담당자 E-mail</div>
						<div class="flex-content">${merchantUpdate.merManemail}</div>
						<div class="flex-header"></div>
						<div class="flex-content"></div>
					</div>
					<div class="button-group">
						<button type="button" 
							onclick="setMode('${pageContext.request.contextPath}/merchant/home/myinfo/${merchantUpdate.merNum}/modify')">정보수정</button>
						<button type="button" 
							onclick="setMode('${pageContext.request.contextPath}/merchant/home/myinfo/${merchantUpdate.merNum}/passwd')">비밀번호 변경</button>
						<button type="button" 
							onclick="setMode('${pageContext.request.contextPath}/merchant/home/myinfo/${merchantUpdate.merNum}/out')">회원탈퇴</button>
					</div>
				</div>
		</div>
		</form>
	</div>
</div>
</div>
<%@ include file="../../client/main/bottom.jsp"%>
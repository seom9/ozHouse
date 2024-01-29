<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="mainTop.jsp" %>
<link rel="stylesheet" type="text/css" href="resources/merchant/css/myinfo_style.css">
<head>
<title>OZ의 집 : 나의 정보</title>
<script type="text/javascript">
	function setMode(mode){
		if(mode == 'pass'){
			f.mode.value='pass';
		}else if(mode == 'out'){
			f.mode.value='out';
		}
		document.f.submit();
	}
</script>
</head>
<div class="container">
	<div class="main-notice" width="auto">
		<h1>나의 정보</h1><br><br>
			<div align="center">
				<form name="f" action="myInform_view.do" method="post">
				<input type="hidden" name="mode" value="inform">
					<div class="flex-container">
		 				<div class="flex-row">
						 	<div class="flex-header">
						 		상점명
						 	</div>
						 	<div class="flex-content">
						 		${merchantUpdate.mer_company}
						 	</div>
						 	<div class="flex-header">
							</div>
							<div class="flex-content">
						 	</div>
		 				</div>
						<div class="flex-row">
							<div class="flex-header">
								상점ID
							</div>
							<div class="flex-content">
								${merchantUpdate.mer_id}
							</div>
							<div class="flex-header">
							</div>
							<div class="flex-content">
						 	</div>
						</div>
						<div class="flex-row">
							<div class="flex-header">
								상점소개
							</div>
							<div class="flex-content">
								${merchantUpdate.mer_comintro}
						<input type="hidden" name="mer_comintro" value="${merchantUpdate.mer_comintro}">
							</div>
							<div class="flex-header">
							</div>
							<div class="flex-content">
						 	</div>
						</div>
						<div class="flex-row">
							<div class="flex-header">
								사업장소재지
							</div>
							<div class="flex-content">
								${merchantUpdate.mer_business_adress}
								<input type="hidden" name="mer_business_adress" value="${merchantUpdate.mer_business_adress}">
							</div>
							<div class="flex-header">
							</div>
							<div class="flex-content">
						 	</div>
						</div>
						<div class="flex-row">
							<div class="flex-header">
								사업자등록증
							</div>
							<div class="flex-content">
								${merchantUpdate.mer_business_registration}
								<input type="hidden" name="mer_business_registration" value="${merchantUpdate.mer_business_registration}">
							</div>
							<div class="flex-header">
								사업자등록번호
							</div>
							<div class="flex-content">
								${merchantUpdate.mer_comnum1}-${merchantUpdate.mer_comnum2}-${merchantUpdate.mer_comnum3}
							</div>
						</div>
						<div class="flex-row">
							<div class="flex-header">
								상점담당자 이름
							</div>
							<div class="flex-content">
								${merchantUpdate.mer_name}
								<input type="hidden" name="mer_name" value="${merchantUpdate.mer_name}">
							</div>
							<div class="flex-header">
								핸드폰
							</div>
							<div class="flex-content">
								${merchantUpdate.mer_hp1}-${merchantUpdate.mer_hp2}-${merchantUpdate.mer_hp3}
								<input type="hidden" name="mer_hp1" value="${merchantUpdate.mer_hp1}">
								<input type="hidden" name="mer_hp2" value="${merchantUpdate.mer_hp2}">
								<input type="hidden" name="mer_hp3" value="${merchantUpdate.mer_hp3}">
							</div>
						</div>
						<div class="flex-row">
							<div class="flex-header">
								상점담장자 E-mail
							</div>
							<div class="flex-content">
								${merchantUpdate.mer_email}
								<input type="hidden" name="mer_email" value="${merchantUpdate.mer_email}">
							</div>
							<div class="flex-header">
							</div>
							<div class="flex-content">
						 	</div>
						</div>
						<div class="flex-row">
							<div class="flex-header">
								카테고리
							</div>
							<div class="flex-content">
								${resultCate}
							</div>
							<div class="flex-header">
							</div>
							<div class="flex-content">
						 	</div>
						</div>
						<div class="flex-row">
							<div class="flex-header">
								판매관련 파일
							</div>
							<div class="flex-content">
								${merchantUpdate.mer_file}
								<input type="hidden" name="mer_file" value="${merchantUpdate.mer_file}">
							</div>
							<div class="flex-header">
							</div>
							<div class="flex-content">
						 	</div>
						</div>
						<div class="flex-row">
							<div class="flex-header">
								회사 홈페이지
							</div>
							<div class="flex-content">
								${merchantUpdate.mer_homepage}
								<input type="hidden" name="mer_homepage" value="${merchantUpdate.mer_homepage}">
							</div>
							<div class="flex-header">
							</div>
							<div class="flex-content">
						 	</div>
						</div>
						<div class="flex-row">
							<div class="flex-header">
								타입점 쇼핑몰
							</div>
							<div class="flex-content">
								${merchantUpdate.mer_othershop}
								<input type="hidden" name="mer_othershop" value="${merchantUpdate.mer_othershop}">
							</div>
							<div class="flex-header">
							</div>
							<div class="flex-content">
						 	</div>
						</div>
						<div class="flex-row">
							<div class="flex-header">
								영업담당자 이름
							</div>
							<div class="flex-content">
								${merchantUpdate.mer_manname}
							</div>
							<div class="flex-header">
								영업담당자 핸드폰
							</div>
							<div class="flex-content">
								${merchantUpdate.mer_manhp1}-${merchantUpdate.mer_manhp2}-${merchantUpdate.mer_manhp3}
							</div>
						</div>
						<div class="flex-row">
							<div class="flex-header">
								영업담당자 E-mail
							</div>
							<div class="flex-content">
								${merchantUpdate.mer_manemail}
						 	</div>
						 	<div class="flex-header">
							</div>
							<div class="flex-content">
						 	</div>
						</div>
						<div class="button-group">
							<button type="button" onclick="setMode('inform');">정보수정</button>
							<button type="button" onclick="setMode('pass');">비밀번호 변경</button>
							<button type="button" onclick="setMode('out');">회원탈퇴</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<%@ include file="mainBottom.jsp" %>
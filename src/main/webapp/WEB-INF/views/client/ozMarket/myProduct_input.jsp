<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>내 상품 팔기</title>
<meta charset="UTF-8">
<%@ include file="ozMarketTop.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/client/ozMarket_css/ozMarketWrite_style.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/js/blogWrite.js"></script>
<script>
	var contextPath = '${pageContext.request.contextPath}';

	function validatePrice(input) {
		input.value = input.value.replace(/[^0-9]/g, '');
	}

	// 폼 제출 전 필드들이 채워져 있는지 검사하는 함수
	function validateForm() {
		var proTitle = document.forms["f"]["proTitle"].value;
		var proPrice = document.forms["f"]["proPrice"].value;
		var proContent = document.forms["f"]["proContent"].value;

		if (proTitle == "" || proPrice == "" || proContent == "") {
			alert("모든 필드를 채워주세요.");
			return false;
		}

		// 가격 필드에 숫자 외 다른 값이 입력되었는지 추가 검사
		if (!/^\d+$/.test(proPrice)) {
			alert("가격은 숫자만 입력할 수 있습니다.");
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<form name="f" method="POST"
		action="${pageContext.request.contextPath}/ozMarket/my-product"
		enctype="multipart/form-data">
		<div class="all">
			<div class="head"></div>
			<div class="all_sub"></div>
			<div class="contents">

				<div class="abcd">
					<ol class="css-kjmyv4">
					</ol>
				</div>
				<div class="contents_2">
					<div class="contents_box1">
						<ol class="contents_box_1_1">
							<li>
								<div class="contents_box_1_2">
									<label for="proImgPro" class="button_box">
										<div class="button_div">
											<span class="button_div_1">사진 이미지</span> <span
												class="button_div_2">사진을 끌어다 놓으세요</span> <span
												class="button_div_3">10장까지 올릴 수 있어요</span> <span
												class="button_div_4">PC에서 불러오기</span>
										</div>
									</label> <input type="file" id="proImgPro" required name="proImgPro"
										multiple accept="image/*">

								</div>
							</li>
						</ol>
					</div>
					<div class="contents_box2">
						<div class="contents_box2_1">
							<div class="explain">
								<input type="text" name="proTitle" class="explain2"
									placeholder="제목을 작성해주세요." onfocus="handleFocus(this)"
									onblur="handleBlurr(this)" required>
							</div>
							<div class="explain">
								<input type="text" name="proPrice" class="explain2"
									placeholder="가격을 입력해주세요.(숫자만 입력 가능)"
									onfocus="handleFocus(this)" onblur="handleBlurr(this)"
									oninput="validatePrice(this)">
							</div>
							<div class="explain_box1">
								<textarea rows="4" class="explain_box2" cols="50"
									name="proContent" placeholder="신뢰할 수 있는 거래를 위해 자세히 적어주세요."
									onfocus="handleFocus(this)" onblur="handleBlu2(this)"
									maxlength="1000"></textarea>
							</div>
						</div>
						<div class="write">
							<button type="submit" class="write_div">올리기</button>
							<input type="hidden" name="memberNickname" value="nickName" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<title>ozMarket</title>
</head>
<%@ include file="ozMarketTop.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/client/blog_css/blogWrite_style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/js/blogWrite.js"></script>
<script>
        var contextPath = '${pageContext.request.contextPath}';
    </script>
<body>
	<form name="f" method="POST" action="${contextPath}/ozMarket/my-product"
		enctype="multipart/form-data">
		<div class="all">
			<div class="all_sub"></div>
				<div class="contents">
					<input type="file" id="proImgPro" name="proImgPro" hidden>
					<div class="abcd">
						<ol class="css-kjmyv4">
						</ol>
					</div>
					<div class="contents_2">
						<div class="contents_box1">
							<ol class="contents_box_1_1">
								<li>
									<div class="contents_box_1_2">
										<button type="button" onclick="img_input()" class="button_box">
											<div class="button_div">
												<span class="button_div_1">사진 이미지</span> <span
													class="button_div_2">사진을 끌어다 놓으세요</span> <span
													class="button_div_3">4장까지 올릴 수 있어요</span> <span
													class="button_div_4">PC에서 불러오기</span>
											</div>
										</button>
									</div>
								</li>
							</ol>
						</div>
						<div class="contents_box2">
							<div class="contents_box2_1">
								<div class="explain">
									<input type="text" name="proTitle" class="explain2"
										placeholder="제목을 작성해주세요." onfocus="handleFocus(this)"
										onblur="handleBlurr(this)">
								</div>
								<div class="explain">
									<input type="text" name="proPrice" class="explain2"
										placeholder="가격을 입력해주세요." onfocus="handleFocus(this)"
										onblur="handleBlurr(this)">
								</div>
								<div class="explain_box1">
									<textarea name="proContent" rows="4" class="explain_box2"
										cols="50" placeholder="신뢰할 수 있는 거래를 위해 자세히 적어주세요."
										onfocus="handleFocus(this)" onblur="handleBlur(this)"></textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
		</div>
	</form>
</body>
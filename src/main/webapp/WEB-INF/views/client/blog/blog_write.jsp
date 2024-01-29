<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>블로그 글쓰기</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/client/blog_css/blogWrite_style.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/blogWrite.js"></script>
    <script>
        var contextPath = '${pageContext.request.contextPath}';
    </script>
</head>
<body>
		<form name="f" method="POST" action="blog_write2.do" enctype="multipart/form-data">
		<input type="hidden" name="mode" value="${mode}" />
		<div class="all">
			<div class="head">
				<div>
					<a href="main.do" class="banner">OZ의 집</a>
				</div>
				<div class="write">
					<button type="submit" class="write_div">올리기</button>
				</div>
			</div>
			<div class="all_sub"></div>
			<div class="second_div">
				<ul class="select">
					<c:if test="${mode == 'photo'}">
					<li>
						<a href="blog_write.do?mode=photo" aria-pressed="true" class="toggle-button" data-target="photo" onclick="toggleButton(this)">
						사진
						</a>
					</li>
					<li>
						<a href="blog_write.do?mode=video" aria-pressed="false" class="toggle-button" data-target="video" onclick="toggleButton(this)">
						동영상
						</a>
					</li>
					</c:if>
					<c:if test="${mode == 'video'}">
					<li>
						<a href="blog_write.do?mode=photo" aria-pressed="false" class="toggle-button" data-target="photo" onclick="toggleButton(this)">
						사진
						</a>
					</li>
					<li>
						<a href="blog_write.do?mode=video" aria-pressed="true" class="toggle-button" data-target="video" onclick="toggleButton(this)">
						동영상
						</a>
					</li>
					</c:if>
				</ul>
			</div>
			<c:if test="${mode == 'photo'}">
				<div class="contents">
				<input type="file" id="blog_image" name="blog_image" hidden>
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
  												<span class="button_div_1">사진 이미지</span>
												<span class="button_div_2">사진을 끌어다 놓으세요</span>
												<span class="button_div_3">4장까지 올릴 수 있어요</span>
												<span class="button_div_4">PC에서 불러오기</span>
											</div>
										</button>
									</div>
								</li>
							</ol>
						</div>
						<div class="contents_box2">
							<div class="contents_box2_1">
								<div class="explain">
									<input type="text" name="blog_subject" class="explain2"
										placeholder="제목을 작성해주세요." onfocus="handleFocus(this)"
										onblur="handleBlurr(this)">
								</div>
								<div class="explain_box1">
									<textarea name="blog_content" rows="4" class="explain_box2"
										cols="50" placeholder="어떤 사진인지 짧은 소개로 시작해보세요."
										onfocus="handleFocus(this)" onblur="handleBlur(this)"></textarea>
								</div>
							</div>
							<div class="select_box1">
								<select class="select_box2" name="blog_room_type" id="spaceSelect" onchange="hideDefaultOption()">
									<option>공간정보</option>
									<option>원룸</option>
									<option>거실</option>
									<option>침실</option>
									<option>주방</option>
									<option>욕실</option>
									<option>현관</option>
									<option>드레스룸</option>
									<option>베란다</option>
									<option>사무공간</option>
									<option>서재&작업실</option>
									<option>가구&소품</option>
								</select>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${mode == 'video'}">
				<div class="contents">
					<div class="contents_2">
						<div class="contents_box1">
							<ol class="contents_box_1_1">
								<li>
									<div class="contents_box_1_2">
										<input type="file" name="photo" id="photoInput" hidden>
										<button type="button" class="button_box"
											onclick="openFileInput()">
											<div class="button_div">
												<span class="button_div_1">동영상을 끌어다 놓으세요</span>
												<span class="button_div_2">5GB미만, 3~60초 미만의 세로 영상이 좋아요</span>
											</div>
										</button>
										<button type="button" class="button_div_4" id="photoInput"
											onclick="openFileInput()">PC에서 불러오기</button>
									</div>
								</li>
							</ol>
						</div>
						<div class="contents_box2">
							<div class="contents_box2_1">
								<div class="explain">
									<input type="text" name="blog_subject" class="explain2"
										placeholder="제목을 작성해주세요." onfocus="handleFocus(this)"
										onblur="handleBlurr(this)">
								</div>
								<div class="explain_box1">
									<textarea rows="4" class="explain_box2" cols="50"
										placeholder="어떤 동영상인지 짧은 소개로 시작해보세요."
										onfocus="handleFocus(this)" onblur="handleBlu2(this)"></textarea>
								</div>
							</div>
							<div class="select_box1">
								<select class="select_box2" id="spaceSelect" onchange="hideDefaultOption()">
									<option>공간정보</option>
									<option>원룸</option>
									<option>거실</option>
									<option>침실</option>
									<option>주방</option>
									<option>욕실</option>
									<option>현관</option>
									<option>드레스룸</option>
									<option>베란다</option>
									<option>사무공간</option>
									<option>서재&작업실</option>
									<option>가구&소품</option>
								</select>
							</div>
						</div>
					</div>
			</c:if>
		</div>
 	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="blog_top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/client/blog_css/blogContents_style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/blogContent.js"></script>
<body>
<c:set var="blogImages" value="${fn:split(blogDTO.blog_image, ',')}" />
<c:set var="blogSubjects" value="${fn:split(blogDTO.blog_subject, ',')}" />
<c:set var="blogContents" value="${fn:split(blogDTO.blog_content, ',')}" />
<c:set var="blogRoomTypes" value="${fn:split(blogDTO.blog_room_type, ',')}" />

	<div class="contents_box"><!-- 전체를 감싸는 영역 -->
	<c:if test="${fn:length(blogImages) > 0 || fn:length(blogSubjects) > 0 || fn:length(blogContents) > 0 || fn:length(blogRoomTypes) > 0}">
		<c:forEach var="index" begin="0" end="${fn:length(blogImages) - 1}" step="1" varStatus="loop">
		<div class="all">
			<div class="head">
				<div>${blogSubjects[index]}</div>
			</div>
			<div class="room_type">${blogRoomTypes[index]}</div>
			<div class="left_box"><!-- 왼쪽에 올 애들 -->
				<div class="photo_box"><!-- 사진 영역 -->
					<img src="data:image/jpeg;base64,${encodedImages[loop.index]}" alt="이미지 영역" class="img_box">
<!-- 					<div class="img_button">
						<ul class="img_button2">
							<li class="img_button3">
								<span>
									<div class="img_button4">
										<a class="img_button5">
											<div class="img_button6">
												<figure class="img_button7">
													<img src="" alt="사진 삽입" class="img">
												</figure>
											</div>
										</a>
									</div>
								</span>
							</li>
						</ul>
					</div>img_button -->
					<div class="write">
						<span>
							<div class="write_2"></div>
						</span>
						<p class="write_3">${blogContents[index]}</p>
					</div>
				</div>
			</c:forEach>
			</c:if>
				<div class="a">
					${blogDTO.blog_date} 조회 ${blogDTO.readcount}
				</div>
				<hr class="hr_style">
				<div class="b">
					<button class="b2">
						<figure class="b3">
							<img src="" class="b_img" alt="프로필 사진">
						</figure>
						<div class="b4">
							<span class="b5">아이디 : ${memberInfo.member_id}</span>
							<span class="b6">닉네임 : ${memberInfo.member_nickname}</span>
						</div>
					</button>
				</div>
				<div class="c">
					<h1 class="c2">
						댓글
						<span class="c2_1">댓글 총 개수</span>
					</h1>
					<div class="c3">
						<div class="c3_1">
							<figure class="c3_2">
								<img class="c3_3">
							</figure>
							<div class="c3_4">
								<form name="f" action="comment.do">
								<div class="c3_5">
									<div class="c3_6">
										<input type="text" class="c3_7" id="commentInput" placeholder="댓글을 작성해주세요" size="44" type="text">
									</div>
									<div class="c4">
										<button type="submit" class="c4_1" id="submitButton" disabled>입력</button>
									</div>
								</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<div>
					댓글이 오는 자리
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		// input 요소와 button 요소 가져오기
		const commentInput = document.getElementById('commentInput');
		const submitButton = document.getElementById('submitButton');
	
		// input 이벤트에 대한 이벤트 리스너 추가
		commentInput.addEventListener('input', function() {
		    // 입력된 텍스트가 있는지 확인
		    const isInputEmpty = commentInput.value.trim() === '';
	
		    // 입력된 텍스트가 있는 경우 버튼 활성화, 그렇지 않으면 비활성화
		    submitButton.disabled = isInputEmpty;
		});
	</script>
	<script>
	    document.addEventListener('DOMContentLoaded', function () {
	        // 페이지 로드가 완료된 후 실행됩니다.
	
	        // top.jsp의 스타일을 삭제합니다.
	        const stickyContainer = document.querySelector('.sticky-container');
	        if (stickyContainer) {
	            stickyContainer.removeAttribute('style');
	        }
	    });
	</script>
</body>
</html>
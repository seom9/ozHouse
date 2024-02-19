<%@ page language="java" contentType="text/html; charset=UTF-8s"
    pageEncoding="UTF-8"%>
<%@ include file="ozMarketTop.jsp"%>
	<div class="contents_box"><!-- 전체를 감싸는 영역 -->
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="blog_top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/client/blog_css/blogMain_style.css" />
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<body>
	<c:if test="${empty blog_list}">
		<div class="a">
			<img src="resources/client/image/notice_image.png">
		</div>
	</c:if>
	<div class="container">
		<div class="blog-list">
			<c:forEach var="dto" items="${blog_list}" varStatus="loop">
			<div class="blog-item-wrap" id="${dto.blog_num}">
				<div class="blog-item">
					<article class="blog-item-collection">
						<div class="memberInfo">
							<address class="memberInfo-content">
								<div class="memberInfo-content_header">
									<a class="memberInfo-content_link">
										<img class="memberInfo-content_image" src="">
										<span class="memberInfo-content_name">${dto.member_id}</span>
									</a>
								</div>
							</address>
						</div>
						<div class="blogInfo">
							<a class="content_link" href="blog_get.do?num=${dto.blog_num}"></a>
							<div class="blog_image">
								<img class="image" src="data:image/jpeg;base64,${encodedImages[loop.index]}">
								<span class="blog_image_view-count">
								조회수
								${dto.readcount}
								</span>
							</div>
<!-- 							<aside class="action-list">
								<button class="action-list_action" type="button">
									<svg class="icon icon--stroke" aria-label="좋아요" width="24" height="24" 
									fill="currentColor" stroke="currentColor" stroke-width="2" 
									viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet">
									<path d="M23.22 7.95c.4 4.94-2.92 9.71-10.92 13.85a.47.47 0 0 1-.42 
									0C3.88 17.66.56 12.9.96 7.93 1.54 2.48 8.28.3 12.1 4.7c3.8-4.4 10.55-2.22 
									11.13 3.25z"></path>
									</svg>
									<span class="count">123</span>
								</button>
								<button class="action-list_action" type="button">
									<svg class="icon icon--stroke" aria-label="스크랩" width="24" height="24" 
									fill="currentColor" stroke="currentColor" stroke-width="0.5" 
									viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet">
									<path d="M11.53 18.54l-8.06 4.31A1 1 0 0 1 2 21.97V3.5A1.5 1.5 0 0 1 3.5 2h17A1.5 1.5 0 0 1 22 3.5v18.47a1 1 0 0 1-1.47.88l-8.06-4.31a1 1 0 0 0-.94 0z">
									</path></svg>
									<span class="count">123</span>
								</button>
								<a class="action-list_action">
									<svg class="icon" aria-label="댓글 달기" width="24" height="24" 
									viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet">
									<path fill="currentColor" fill-rule="nonzero" 
									d="M13.665 18.434l.53-.066C19.69 17.679 23 14.348 23 10c0-4.942-4.235-8.5-11-8.5S1 5.058 1 10c0 4.348 3.31 7.68 8.804 8.368l.531.066L12 21.764l1.665-3.33zm-3.985.926C3.493 18.585 0 14.69 0 10 0 4.753 4.373.5 12 .5S24 4.753 24 10c0 4.69-3.493 8.585-9.68 9.36l-1.647 3.293c-.374.75-.974.744-1.346 0L9.68 19.36z">
									</path></svg>
									<span class="count">123</span>
								</a>
							</aside> -->
						</div>
						<div class="content_description">
							<div class="content_description_2">
								<c:set var="blogContents" value="${fn:split(dto.blog_content, ',')}" />
								<c:if test="${not empty blogContents and fn:length(blogContents) > 0}">
								<p class="content_description_3">${blogContents[0]}</p>
								</c:if>
							</div>
						</div>
<!-- 						<div class="comment-wrap">
							<article class="comment" aria-label="댓글">
								<address class="comment_writer">
									<a class="comment_writer_link">
										<div class="comment_writer_image">
											<img class="image" src="">
										</div>
										<span class="comment_writer_name">댓글 회원 아이디</span>
										<span class="comment_writer_separator">: </span>
										
									</a>
								</address>
								<a>
									<p class="comment_content">댓글 내용</p>
								</a>
							</article>
						</div> -->
					</article>
				</div>
			</div>
			</c:forEach>
		</div>
	</div><!-- 최상위 div -->
</body>
</html>
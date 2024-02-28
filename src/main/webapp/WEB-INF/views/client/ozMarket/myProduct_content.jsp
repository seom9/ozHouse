<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="ozMarketTop.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>OZ의 집 : 상품상세보기</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/ozMarket/ozMarketProContent.css" />
</head>
<body>
	<div class="container">
		<div class="content-container">
			<div class="form-container">
				<div class="form-section">
					<div class="form-group">
						<div class="image-slider">
							<a class="prev" onclick="changeSlide(-1)">&#10094;</a>
							<div class="image-container">
								<!-- 이미지 URL 리스트를 순회하며 각 이미지를 표시 -->
								<c:forEach items="${encodedImagesPro}" var="encodedImagePro"
									varStatus="status">
									<img src="${encodedImagePro}" class="slide"
										style="width: 100%; display: none;">
								</c:forEach>
							</div>
							<a class="next" onclick="changeSlide(1)">&#10095;</a>
						</div>
						<div class="user-info">
							<div class="user-avatar">
								<c:choose>
									<c:when test="${empty member.memberImage}">
										<img
											src="https://image.ohou.se/i/bucketplace-v2-development/uploads/default_images/avatar.png?gif=1&w=144&h=144&c=c&webp=1"
											alt="User Avatar">
									</c:when>
									<c:otherwise>
										<img src="${member.memberImage}" alt="User Avatar">
									</c:otherwise>
								</c:choose>
							</div>
							<div class="memberNickname">${getProduct.memberNickname}</div>
						</div>
						<hr>
						<div class="proTitle">${getProduct.proTitle}</div>
						<div class="proInDate">${getProduct.proInDate}</div>
						<div class="proPrice">
							<fmt:formatNumber value="${getProduct.proPrice}"
								pattern="###,###" />
							원
						</div>
						<div class="proContent">${getProduct.proContent}</div>
						<div class="button-group">
							<input type="button" class="list-button" value="목록보기"
								onclick="window.location='${pageContext.request.contextPath}/ozMarket'">
							<div class="button-group">
								<c:if test="${nickName eq getProduct.memberNickname}">
									<form
										action="${pageContext.request.contextPath}/ozMarket/delete/${getProduct.proNum}"
										method="post" style="display: inline;">
										<input type="submit" value="삭제" class="list-button" />
									</form>
								</c:if>
								<c:if test="${nickName ne getProduct.memberNickname}">
									<form
										action="${pageContext.request.contextPath}/ozMarket/chatt"
										method="post" style="display: inline;">
										<input type="hidden" name="proNum"
											value="${getProduct.proNum}" /> <input type="hidden"
											name="sellerNickname" value="${getProduct.memberNickname}" />
										<input type="submit" value="채팅하기" class="list-button" />
									</form>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../main/bottom.jsp"%>

	<script>
    var slideIndex = 0; // 슬라이드 인덱스를 0부터 시작
    showSlides(slideIndex); // 초기 슬라이드 표시

    function changeSlide(n) {
        slideIndex += n;
        if (slideIndex >= document.getElementsByClassName("slide").length) {
            slideIndex = 0; // 마지막 슬라이드 이후 첫 번째 슬라이드로
        } else if (slideIndex < 0) {
            slideIndex = document.getElementsByClassName("slide").length - 1; // 첫 번째 슬라이드 이전 마지막 슬라이드로
        }
        showSlides(slideIndex);
    }

    function showSlides(n) {
        var i;
        var slides = document.getElementsByClassName("slide");
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none"; // 모든 슬라이드 숨기기
        }
        slides[n].style.display = "block"; // 현재 슬라이드 표시
    }
</script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="mypage_top.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/client/mypage_css/mypageScrap.css"/>
<head>
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<main class="css-1ium9fd">
	<div class="css-7rhnz2">
		<p>스크랩북</p>
	</div>
	<div class="css-8mhhua">
		<div class="css-1tba8n4">
			<c:forEach var="tdto" items="${myScrap}" varStatus="loop">
			<div>
				<div>
					<div class="css-3q4ecs">
						<article class="production-item css-18g08sj">
							<a class="production-item__overlay" href="prodView_main.do?num=${tdto.product_num}"></a>
							<div class="production-item-image production-item__image">
								<img class="image" src="data:image/jpeg;base64,${encodedImages[loop.index]}">
									<c:set var="map" value="${scrapCheck}"/>
									<c:if test="${not empty sessionScope.loginMember}">
										<c:if test="${map[tdto.product_num] eq 't'}">
											<button type="button" id="unScrap_${tdto.product_num}" aria-label="scrap 토글 버튼" class="eggro9e0 css-1lyaokr unScrap">
												<input type="hidden" tabindex="1" value="${tdto.product_num}" class="product_num">
												<svg class="css-whh5e5" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" clip-rule="evenodd" d="M20 2.75H4C3.44772 2.75 3 3.19771 3 3.75V20.8228C3 21.1988 3.39948 21.4403 3.73242 21.2655L11.5352 17.169C11.8262 17.0162 12.1738 17.0162 12.4648 17.169L20.2676 21.2655C20.6005 21.4403 21 21.1988 21 20.8228V3.75C21 3.19772 20.5523 2.75 20 2.75Z" fill="#35C5F0"></path></svg>
												<svg class="css-q7lffx" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><g clip-path="url(#clip0_15409_67579)"><g filter="url(#filter0_d_15409_67579)"><path d="M4.3 4.05V19.4992L10.9309 16.018C11.6003 15.6666 12.3997 15.6666 13.0691 16.018L19.7 19.4992V4.05H4.3ZM4 2.75H20C20.5523 2.75 21 3.19772 21 3.75V20.8228C21 21.1988 20.6005 21.4403 20.2676 21.2655L12.4648 17.169C12.1738 17.0162 11.8262 17.0162 11.5352 17.169L3.73242 21.2655C3.39948 21.4403 3 21.1988 3 20.8228V3.75C3 3.19771 3.44772 2.75 4 2.75Z" fill="#50E5B4"></path><path d="M4.3 4.05V19.4992L10.9309 16.018C11.6003 15.6666 12.3997 15.6666 13.0691 16.018L19.7 19.4992V4.05H4.3Z" fill="#50E5B4" fill-opacity="0.5"></path></g></g><defs><filter id="filter0_d_15409_67579" x="-2" y="-0.25" width="28" height="28.5735" filterUnits="userSpaceOnUse" color-interpolation-filters="sRGB"><feFlood flood-opacity="0" result="BackgroundImageFix"></feFlood><feColorMatrix in="SourceAlpha" type="matrix" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0" result="hardAlpha"></feColorMatrix><feOffset dy="2"></feOffset><feGaussianBlur stdDeviation="2.5"></feGaussianBlur><feColorMatrix type="matrix" values="0 0 0 0 0.247059 0 0 0 0 0.278431 0 0 0 0 0.301961 0 0 0 0.15 0"></feColorMatrix><feBlend mode="normal" in2="BackgroundImageFix" result="effect1_dropShadow_15409_67579"></feBlend><feBlend mode="normal" in="SourceGraphic" in2="effect1_dropShadow_15409_67579" result="shape"></feBlend></filter><clipPath id="clip0_15409_67579"><rect width="24" height="24" fill="white"></rect></clipPath></defs></svg>
											</button>
										</c:if>
										<c:if test="${map[tdto.product_num] ne 't'}">
											<button type="button" id="doScrap_${tdto.product_num}" aria-label="scrap 토글 버튼" class="eggro9e0 css-1lyaokr doScrap">  
										    	<input type="hidden" tabindex="1" value="${tdto.product_num}" class="product_num">								      						          
													<svg class="css-q7lffx" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" clip-rule="evenodd" d="M20 2.75H4C3.44772 2.75 3 3.19771 3 3.75V20.8228C3 21.1988 3.39948 21.4403 3.73242 21.2655L11.5352 17.169C11.8262 17.0162 12.1738 17.0162 12.4648 17.169L20.2676 21.2655C20.6005 21.4403 21 21.1988 21 20.8228V3.75C21 3.19772 20.5523 2.75 20 2.75Z" fill="#35C5F0"></path></svg>
										        	<svg class="css-whh5e5" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><g clip-path="url(#clip0_15409_67579)"><g filter="url(#filter0_d_15409_67579)"><path d="M4.3 4.05V19.4992L10.9309 16.018C11.6003 15.6666 12.3997 15.6666 13.0691 16.018L19.7 19.4992V4.05H4.3ZM4 2.75H20C20.5523 2.75 21 3.19772 21 3.75V20.8228C21 21.1988 20.6005 21.4403 20.2676 21.2655L12.4648 17.169C12.1738 17.0162 11.8262 17.0162 11.5352 17.169L3.73242 21.2655C3.39948 21.4403 3 21.1988 3 20.8228V3.75C3 3.19771 3.44772 2.75 4 2.75Z" fill="white"></path><path d="M4.3 4.05V19.4992L10.9309 16.018C11.6003 15.6666 12.3997 15.6666 13.0691 16.018L19.7 19.4992V4.05H4.3Z" fill="white" fill-opacity="0.5"></path></g></g><defs><filter id="filter0_d_15409_67579" x="-2" y="-0.25" width="28" height="28.5735" filterUnits="userSpaceOnUse" color-interpolation-filters="sRGB"><feFlood flood-opacity="0" result="BackgroundImageFix"></feFlood><feColorMatrix in="SourceAlpha" type="matrix" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0" result="hardAlpha"></feColorMatrix><feOffset dy="2"></feOffset><feGaussianBlur stdDeviation="2.5"></feGaussianBlur><feColorMatrix type="matrix" values="0 0 0 0 0.247059 0 0 0 0 0.278431 0 0 0 0 0.301961 0 0 0 0.15 0"></feColorMatrix><feBlend mode="normal" in2="BackgroundImageFix" result="effect1_dropShadow_15409_67579"></feBlend><feBlend mode="normal" in="SourceGraphic" in2="effect1_dropShadow_15409_67579" result="shape"></feBlend></filter><clipPath id="clip0_15409_67579"><rect width="24" height="24" fill="white"></rect></clipPath></defs></svg>
										     </button>          
										</c:if>
									</c:if>
								<div class="production-item-image__dark-overlay"></div>
							</div>
							<div class="production-item__content">
								<h1 class="production-item__header">
									<span class="production-item__header__brand">브랜드명</span>
									<span class="production-item__header__name">${tdto.product_name}</span>
								</h1>
								<span class="production-item-price">
									<span class="production-item-price__rate">
										${tdto.product_discount_rate}
										<span class="percentage">%</span>
									</span>
									<span class="production-item-price__price">
										<fmt:formatNumber value="${tdto.product_price}" pattern="###,###"/> 원
									</span>
								</span>
								<p class="production-item-stats production-item-stats--review">
									<svg class="icon" width="24" height="24" viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet"><path fill="currentColor" fill-rule="evenodd" d="M12 19.72l-5.677 2.405c-.76.322-1.318-.094-1.247-.906l.533-6.142-4.042-4.656c-.54-.624-.317-1.283.477-1.467l6.006-1.39L11.23 2.28c.426-.707 1.122-.699 1.542 0l3.179 5.282 6.006 1.391c.805.187 1.011.851.477 1.467l-4.042 4.656.533 6.142c.072.822-.497 1.224-1.247.906L12 19.72z"></path></svg>
									<strong class="avg">${review_count}</strong>
								</p>
							</div>
						</article>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
</main>
<script type="text/javascript">
    $(function () {
        function unexecuteScrap(product_num) {
            $.ajax({
                type: 'post',
                url: 'unscrap_product.do',
                data: { 'product_num': product_num },
                success: function (data) {
                    if (data === 'Y') {
                        alert('상품 스크랩 취소 되었습니다');
                        location.reload(true);
                    } else if (data === 'N') {
                        alert('이미 취소된 상품입니다');
                    }
                },
                error: function (error) {
                    alert(error);
                }
            });
        }

        // unScrap 버튼 클릭 이벤트 핸들러 등록
        $(document).on("click", ".unScrap", function () {
            var product_num = $(this).find(".product_num").val();
            unexecuteScrap(product_num);
        });
    });
</script>
</body>
</html>
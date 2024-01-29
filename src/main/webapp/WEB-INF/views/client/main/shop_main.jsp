<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/client/main_css/shop.css"/>
<div class="category-feed-container">
	<div class="category-feed-wrap container">
		<div class="category-feed row">
			<div class="category-feed__side-bar">
				<section class="commerce-category-list">
					<ul class="commerce-category-list__others">
						<c:forEach var="cate" items="${list_cate}">
						<li class="commerce-category-list__others__item">
							<a href="">${cate.category_name}</a>
						</li>
						</c:forEach>
					</ul>
				</section>
			</div><!-- side bar -->
			<div class="category-feed__content">
				<div>
					<div class="virtualized-list category-feed__content__content row">
						<c:forEach var="dto" items="${list_product}" varStatus="loop">
						<div class="category-feed__content__item-wrap col-6 col-lg-4">
							<article class="production-item">
								<a class="production-item__overlay" href="prodView_main.do?num=${dto.product_num}"></a>
								<div class="production-item-image production-item__image">
									<img class="image" src="data:image/jpeg;base64,${product_encodedImages[loop.index]}">
								</div>
								<div class="production-item__content">
									<hi class="production-item__header">
										<span class="production-item__header__brand">브랜드명</span>
										<span class="production-item__header__name">[${dto.product_modifier}] ${dto.product_name}</span>
									</hi>
									<span class="production-item-price">
										<span class="production-item-price__rate">
											${dto.product_discount_rate}
											<span class="percentage">%</span>
										</span>
										<span class="production-item-price__price"><fmt:formatNumber value="${dto.product_price}" pattern="###,###"/>원</span>
									</span>
								</div>
							</article>
						</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
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
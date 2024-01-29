<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/client/main_css/prodView.css"/>
<div class="production-selling">
	<div class="production-selling-overview container">
		<nav class="production-selling-overview__category">
			<ol>
				<li class="commerce-category-breadcrumb__entry">
					<a>카테고리</a>
				</li>
			</ol>
		</nav>
		<div class="production-selling-overview__container">
			<div class="production-selling-overview__cover-image-wrap">
				<div class="production-selling-cover-image-container">
					<div class="production-selling-overview__cover-image">
						<div class="production-selling-cover-image__carousel-wrap">
							<div class="carousel__list">
								<div class="production-selling-cover-image__entry">
									<img class="production-selling-cover-image__entry__image" alt="상품 대표이미지" src="data:image/jpeg;base64,${encodedImage}">
								</div>
								<div class="production-selling-cover-image__entry"></div>
							</div>
						</div>
					</div>
				</div>
			</div><!-- production-selling-overview__cover-image-wrap -->
			<div class="production-selling-overview__content">
				<div class="production-selling-header">
					<h1 class="production-selling-header__title">
						<p class="production-selling-header__title__brand-wrap">
							<span class="production-selling-header__title__brand">브랜드명</span>
						</p>
						<div class="production-selling-header__title__name-wrap">
							<span class="production-selling-header__title__name">[${productDTO.product_modifier}] ${productDTO.product_name}</span>
							<div class="production-selling-header__action">
								<button class="production-selling-header__action__button production-selling-header__action__button-scrap" onclick="${scrapResult eq 'Y' ? 'unscrap()' : 'scrap()'}">
									<svg class="icon--stroke" aria-label="스크랩" width="24" height="24" fill="${scrapResult eq 'N' ? 'rgba(0, 0, 0, 0)' : '#50E5B4'}" stroke="currentColor" stroke-width="0.5" viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet"><path d="M11.53 18.54l-8.06 4.31A1 1 0 0 1 2 21.97V3.5A1.5 1.5 0 0 1 3.5 2h17A1.5 1.5 0 0 1 22 3.5v18.47a1 1 0 0 1-1.47.88l-8.06-4.31a1 1 0 0 0-.94 0z"></path></svg>
									<span class="count" id="scrapCount">${scrap_count}</span>
								</button>
							</div>
						</div>
					</h1>
					<div class="production-selling-header__content">
						<p class="production-selling-header__review-wrap">
							<a class="production-selling-header__review">
								<span class="production-selling-header__review__icon">
									<svg fill="#50E5B4" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><defs><path id="star-path-275" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path><clipPath id="star-clip-275"><rect x="0" y="0" width="24" height="24"></rect></clipPath></defs><use xlink:href="#star-path-275" fill="#DBDBDB"></use><use clip-path="url(#star-clip-275)" xlink:href="#star-path-275"></use></svg>
									<svg fill="#50E5B4" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><defs><path id="star-path-276" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path><clipPath id="star-clip-276"><rect x="0" y="0" width="24" height="24"></rect></clipPath></defs><use xlink:href="#star-path-276" fill="#DBDBDB"></use><use clip-path="url(#star-clip-276)" xlink:href="#star-path-276"></use></svg>
									<svg fill="#50E5B4" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><defs><path id="star-path-277" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path><clipPath id="star-clip-277"><rect x="0" y="0" width="24" height="24"></rect></clipPath></defs><use xlink:href="#star-path-277" fill="#DBDBDB"></use><use clip-path="url(#star-clip-277)" xlink:href="#star-path-277"></use></svg>
									<svg fill="#50E5B4" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><defs><path id="star-path-278" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path><clipPath id="star-clip-278"><rect x="0" y="0" width="24" height="24"></rect></clipPath></defs><use xlink:href="#star-path-278" fill="#DBDBDB"></use><use clip-path="url(#star-clip-278)" xlink:href="#star-path-278"></use></svg>
									<svg fill="#50E5B4" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><defs><path id="star-path-279" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path><clipPath id="star-clip-279"><rect x="0" y="0" width="18.57687195392114" height="24"></rect></clipPath></defs><use xlink:href="#star-path-279" fill="#DBDBDB"></use><use clip-path="url(#star-clip-279)" xlink:href="#star-path-279"></use></svg>
								</span>
								<span class="production-selling-header__review__text">
									<span class="number">${review_count}</span>
									<span class="postfix">개 리뷰</span>
								</span>
							</a>
						</p>
						<div class="production-selling-header__price">
							<span class="production-selling-header__price__price-wrap">
								<span class="production-selling-header__price__discount">
									<span class="number">${productDTO.product_discount_rate}</span>
									<span class="percent">%</span>
								</span>
								<del class="production-selling-header__price__original">
									<span class="number">${productDTO.product_price}</span>
									<span class="percent">원</span>
								</del>
								<span class="production-selling-header__price__separator"></span>
								<div class="production-selling-header__price__price-value-wrap">
									<c:set var="discount" value="${(productDTO.product_price * (100 - productDTO.product_discount_rate))/100}"/>
									<div class="production-selling-header__price__price">
										<span class="number"><fmt:formatNumber value="${discount}" pattern="###,###"/></span>
										<span class="won">원</span>
										<!-- 만약 할인율이 있으면 svg를 추가 할 수 있게 만들어야함. -->
										<svg class="icon" aria-label="특가" width="30" height="20" viewBox="0 0 30 20" preserveAspectRatio="xMidYMid meet"><rect width="30" height="20" fill="#F77" rx="4"></rect><path fill="#fff" d="M12.83 7.93v-.97H7.93v-.555h5.228v-.991H6.655v4.063h6.59v-.992H7.928V7.93h4.901zm-6.295 3.747v1.002h5.326v2.037h1.274v-3.04h-6.6zm7.733-.588v-1.024H5.5v1.024h8.768zM23.91 9.782V8.725h-1.405V5H21.24v9.705h1.264V9.782h1.405zm-3.954-3.79h-4.53v1.056h3.147c-.174 1.938-1.623 3.975-3.736 4.945l.773.958c2.974-1.612 4.259-4.03 4.346-6.96z"></path></svg>
									</div>
								</div>
							</span>
						</div>
					</div><!-- production-selling-header__content -->
					<div class="production-selling-header__info-wrap">
						<div class="production-selling-header__promotion">
							<div class="production-selling-header__promotion__title-wrap">혜택</div>
							<div class="production-selling-header__promotion__content-wrap">
								<p class="production-selling-header__promotion__entry">
									<b>${productDTO.product_point}P</b>
									적립
								</p>
							</div>
						</div>
					</div>
				</div><!-- production-selling-header -->
				<div class="production-selling-overview__option-form">
					<section class="production-selling-option-form__form">
						<ul class="selling-option-form-content__list">
                 			<li>
					        	<article class="css-m75hpw">               
					            	<h2 class="css-yakegh">${productDTO.product_name}</h2>
					            	<div class="css-1nrstx4">
					            		<div class="css-i2qw7n">
					            			<span id="minus" class="css-1k5678y">
					            				<svg xmlns="http://www.w3.org/2000/svg" height="16" width="14" viewBox="0 0 448 512"><!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.--><path d="M432 256c0 17.7-14.3 32-32 32L48 288c-17.7 0-32-14.3-32-32s14.3-32 32-32l352 0c17.7 0 32 14.3 32 32z"/></svg>
					            			</span>
					            			<button id="quantity" class="css-1gjftf7">1</button>
					            			<span id="plus" class="e1fp679o3">
					            				<svg xmlns="http://www.w3.org/2000/svg" height="16" width="14" viewBox="0 0 448 512"><!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.--><path d="M256 80c0-17.7-14.3-32-32-32s-32 14.3-32 32V224H48c-17.7 0-32 14.3-32 32s14.3 32 32 32H192V432c0 17.7 14.3 32 32 32s32-14.3 32-32V288H400c17.7 0 32-14.3 32-32s-14.3-32-32-32H256V80z"/></svg>
					            			</span>
					            		</div>	
					            		<div class="css-sp8wxv">
					            			<span id="productPrice" class="css-1xrj6am">
					            				<fmt:formatNumber value="${discount}" pattern="###,###"/>원
					            			</span>
					            		</div>
					            	</div>
					            </article>
					         </li>
					     </ul>
					</section>
					<hr class="css-1gc4ylt">					
					<p class="css-49v6aj">
						<span class="css-7c0zb9">주문금액</span>
						<span class="css-q02jxk">
							<span id="productPrice2"><fmt:formatNumber value="${discount}" pattern="###,###"/>원</span>
						</span>
					</p>
					<div class="production-selling-option-form__footer">
						<button class="button button--color-blue-inverted button--size-55 button--shape-4" onclick="goCart()" type="button">장바구니</button>
						<button class="button button--color-blue button--size-55 button--shape-4" onclick="goOrder()" type="button">바로구매</button>
					</div>
				</div>
			</div>
		</div>
	</div><!-- production-selling-overview container -->
	<div class="production-selling-navigation__wrap" style="position: sticky; top: 131.5px; transition: top 0.1s ease 0s;">
		<div class="production-selling-navigation">
			<nav class="production-selling-navigation__content">
				<ol class="production-selling-navigation__list">
					<li>
						<a class="production-selling-navigation__item production-selling-navigation__item--active" href="#production-selling-information">상품정보</a>
					</li>
					<li>
						<a class="production-selling-navigation__item" href="#production-selling-question">
							문의
							<span class="production-selling-navigation__item__count">문의숫자</span>
						</a>
					</li>
					<li>
						<a class="production-selling-navigation__item" href="#production-selling-review">
							리뷰
							<span class="production-selling-navigation__item__count">${review_count}</span>
						</a>
					</li>
				</ol>
			</nav>
		</div>
	</div><!-- production-selling-navigation__wrap -->
	<div class="production-selling__detail-wrap container">
		<div class="production-selling__detail">
			<div class="production-selling__detail__content">
				<div class="production-selling-content">
					<a id="production-selling-information"></a>
					<section class="production-selling-section">
						<header class="production-selling-section__header">
							<h1 class="production-selling-section__title">상품정보</h1>
						</header>
						<div class="production-selling-description">
							<div class="production-selling-description__content">
								<p>&nbsp;</p>
								<c:forEach var="encodedImagePro" items="${encodedImagesPro}">
								<div align="center">
									<img src="data:image/png;base64,${encodedImagePro}" alt="상품 상세 이미지">
								</div>
								</c:forEach>
							</div>
						</div>
					</section><!-- production-selling-information -->
					<a id="production-selling-review"></a>
					<section class="production-selling-section">
						<header class="production-selling-section__header">
							<h1 class="production-selling-section__title">
								리뷰
								<span class="count">${review_count}</span>
							</h1>
							<div class="production-selling-section__right">
								<button type="button" onclick="reviewOpen()">리뷰쓰기</button>
							</div>
						</header>
						<div class="production-review-feed">
							<div class="production-review-feed__header-v2">
								<div class="production-review-feed__header-v2__stars">
									<div class="production-review-feed__header-v2__stars__badge">
										<span class="icon" aria-label="별점 ">
											<svg fill="#50E5B4" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><defs><path id="star-path-165" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path><clipPath id="star-clip-165"><rect x="0" y="0" width="24" height="24"></rect></clipPath></defs><use xlink:href="#star-path-165" fill="#DBDBDB"></use><use clip-path="url(#star-clip-165)" xlink:href="#star-path-165"></use></svg>
											<svg fill="#50E5B4" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><defs><path id="star-path-166" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path><clipPath id="star-clip-166"><rect x="0" y="0" width="24" height="24"></rect></clipPath></defs><use xlink:href="#star-path-166" fill="#DBDBDB"></use><use clip-path="url(#star-clip-166)" xlink:href="#star-path-166"></use></svg>
											<svg fill="#50E5B4" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><defs><path id="star-path-167" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path><clipPath id="star-clip-167"><rect x="0" y="0" width="24" height="24"></rect></clipPath></defs><use xlink:href="#star-path-167" fill="#DBDBDB"></use><use clip-path="url(#star-clip-167)" xlink:href="#star-path-167"></use></svg>
											<svg fill="#50E5B4" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><defs><path id="star-path-168" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path><clipPath id="star-clip-168"><rect x="0" y="0" width="24" height="24"></rect></clipPath></defs><use xlink:href="#star-path-168" fill="#DBDBDB"></use><use clip-path="url(#star-clip-168)" xlink:href="#star-path-168"></use></svg>
											<svg fill="#50E5B4" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><defs><path id="star-path-169" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path><clipPath id="star-clip-169"><rect x="0" y="0" width="24" height="24"></rect></clipPath></defs><use xlink:href="#star-path-169" fill="#DBDBDB"></use><use clip-path="url(#star-clip-169)" xlink:href="#star-path-169"></use></svg>
										</span>
										<span class="badge__pc"></span>
									</div>
									<div class="production-review-feed__header-v2__stars__avg">
										<div class="production-review-feed__header-v2__stars__avg-warp">
											<!-- 별점 5점 개수 -->
											<div class="production-review-feed__header-v2__stars__avg__container">
												<div class="production-review-feed__header-v2__stars__avg__label label_selected">5점</div>
												<div class="production-review-feed__header-v2__stars__avg__bar">
													<div class="production-review-feed__header-v2__stars__avg__bar__bg"></div>
													<div class="production-review-feed__header-v2__stars__avg__bar__color" style="길이가 별점 수에 따라서 달라짐."></div>
												</div>
												<div class="production-review-feed__header-v2__stars__avg__number label_selected">별점 개수</div>
											</div>
											<!-- 별점 5점 개수 -->
											<!-- 별점 4점 개수 -->
											<div class="production-review-feed__header-v2__stars__avg__container">
												<div class="production-review-feed__header-v2__stars__avg__label label_selected">4점</div>
												<div class="production-review-feed__header-v2__stars__avg__bar">
													<div class="production-review-feed__header-v2__stars__avg__bar__bg"></div>
													<div class="production-review-feed__header-v2__stars__avg__bar__color" style="길이가 별점 수에 따라서 달라짐."></div>
												</div>
												<div class="production-review-feed__header-v2__stars__avg__number label_selected">별점 개수</div>
											</div>
											<!-- 별점 4점 개수 -->
											<!-- 별점 3점 개수 -->
											<div class="production-review-feed__header-v2__stars__avg__container">
												<div class="production-review-feed__header-v2__stars__avg__label label_selected">3점</div>
												<div class="production-review-feed__header-v2__stars__avg__bar">
													<div class="production-review-feed__header-v2__stars__avg__bar__bg"></div>
													<div class="production-review-feed__header-v2__stars__avg__bar__color" style="길이가 별점 수에 따라서 달라짐."></div>
												</div>
												<div class="production-review-feed__header-v2__stars__avg__number label_selected">별점 개수</div>
											</div>
											<!-- 별점 3점 개수 -->
											<!-- 별점 2점 개수 -->
											<div class="production-review-feed__header-v2__stars__avg__container">
												<div class="production-review-feed__header-v2__stars__avg__label label_selected">2점</div>
												<div class="production-review-feed__header-v2__stars__avg__bar">
													<div class="production-review-feed__header-v2__stars__avg__bar__bg"></div>
													<div class="production-review-feed__header-v2__stars__avg__bar__color" style="길이가 별점 수에 따라서 달라짐."></div>
												</div>
												<div class="production-review-feed__header-v2__stars__avg__number label_selected">별점 개수</div>
											</div>		
											<!-- 별점 2점 개수 -->
											<!-- 별점 1점 개수 -->										
											<div class="production-review-feed__header-v2__stars__avg__container">
												<div class="production-review-feed__header-v2__stars__avg__label label_selected">1점</div>
												<div class="production-review-feed__header-v2__stars__avg__bar">
													<div class="production-review-feed__header-v2__stars__avg__bar__bg"></div>
													<div class="production-review-feed__header-v2__stars__avg__bar__color" style="길이가 별점 수에 따라서 달라짐."></div>
												</div>
												<div class="production-review-feed__header-v2__stars__avg__number label_selected">별점 개수</div>
											</div>
											<!-- 별점 1점 개수 -->																					
										</div>
									</div>
								</div>
							</div><!-- production-review-feed__header-v2 -->
							<div class="filter">
								<div class="production-review-feed__filter-wrap">
									<div class="production-review-feed__filter">
										<div class="production-review-feed__filter__order-list">
											<button class="production-review-feed__filter__order production-review-feed__filter__order--active" aria-pressed="true" type="button">베스트순</button>
											<button class="production-review-feed__filter__order" aria-pressed="false" type="button">최신순</button>
											<button class="production-review-feed__filter__order production-review-feed__filter__order--photo" aria-pressed="false" type="button"><svg class="icon" width="18" height="18" viewBox="0 0 18 18" preserveAspectRatio="xMidYMid meet"><path fill="currentColor" d="M15.821 3a.67.67 0 0 1 .679.672v10.656a.67.67 0 0 1-.679.672H2.18a.67.67 0 0 1-.679-.672V3.672c0-.375.3-.672.679-.672H15.82zm-.679 1.344H2.858v8.14L7.01 7.781c.094-.125.284-.125.394 0l2.321 2.657c.048.046.063.109.048.156l-.3 1.375c-.016.11.11.172.173.094l2.369-2.579a.202.202 0 0 1 .284 0l2.842 3.094V4.344zm-2.526 3.61a1.1 1.1 0 0 1-1.105-1.095 1.1 1.1 0 0 1 1.105-1.093 1.1 1.1 0 0 1 1.105 1.093 1.1 1.1 0 0 1-1.105 1.094z"></path></svg>
											사진리뷰
											</button>
										</div>
									</div>
								</div>
							</div><!-- filter -->
							<div class="production-review-feed__list">
								<c:forEach var="Review" items="${main_listReview}" varStatus="loop">
								<div class="production-review-item__container" id="review_${loop.index}">
									<article class="production-review-item">
										<div class="production-review-item__writer">
										    <c:choose>
										        <c:when test="${not empty member_encodedImages[loop.index]}">
										            <a href=""><!-- 회원의 마이페이지로 이동 -->
										                <img src="data:image/jpeg;base64,${member_encodedImages[loop.index]}" alt="회원 이미지" class="production-review-item__writer__img"><!-- 회원 이미지 -->
										            </a>
										        </c:when>
										        <c:otherwise>
										            <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/default_images/avatar.png?gif=1&amp;w=144&amp;h=144&amp;c=c&amp;webp=1" class="production-review-item__writer__img" alt="User Avatar">
										        </c:otherwise>
										    </c:choose>
											<div class="production-review-item__writer__info">
												<p class="production-review-item__writer__info__name">${Review.member_id}</p>
												<span class="production-review-item__writer__info__total-star">
													<svg name="star1" fill="lightgray" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><path id="star-path-5" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path></svg>
													<svg name="star2" fill="lightgray" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><path id="star-path-6" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path></svg>
													<svg name="star3" fill="lightgray" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><path id="star-path-7" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path></svg>
													<svg name="star4" fill="lightgray" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><path id="star-path-8" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path></svg>
													<svg name="star5" fill="lightgray" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><path id="star-path-9" d="M11.9996 19.7201L6.32294 22.1251C5.5626 22.4472 5.005 22.0311 5.0755 21.2188L5.60855 15.0767L1.5671 10.421C1.02579 9.79745 1.24924 9.13855 2.04358 8.95458L8.04973 7.56354L11.2287 2.28121C11.6545 1.57369 12.3502 1.5826 12.7706 2.28121L15.9496 7.56354L21.9557 8.95458C22.7602 9.1409 22.9667 9.8053 22.4322 10.421L18.3907 15.0767L18.9238 21.2188C18.9952 22.0414 18.4271 22.4432 17.6764 22.1251L11.9996 19.7201Z"></path></svg>
												</span>
												<span class="production-review-item__writer__info__date">
													구매한 날짜 구매
												</span>
											</div>
										</div>
										<div class="production-review-item__name">
											<p class="production-review-item__name__explain__text hidden-overflow">
										</div>
											<c:choose>
										        <c:when test="${not empty review_encodedImages[loop.index]}">
										        	<img src="data:image/jpeg;base64,${review_encodedImages[loop.index]}" alt="리뷰 이미지" class="production-review-item__img"><!-- 회원 이미지 -->
										        </c:when>
										        <c:otherwise>
										            <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/default_images/avatar.png?gif=1&amp;w=144&amp;h=144&amp;c=c&amp;webp=1" class="css-1auwp8u" alt="User Avatar">
										        </c:otherwise>
										    </c:choose>										
									</article>
								</div>
								</c:forEach>
							</div><!-- production-review-feed__list -->
							<ul></ul>
						</div>
					</section><!-- production-selling-review -->
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 모달창 -->
<div id="review_modal" style="display: none;">
<form name="f" method="POST" action="review_write.do" enctype="multipart/form-data">
	<input type="hidden" name="product_num" value="${productDTO.product_num}">
	<div class="_1SpqS review-modal__modal__wrap open open-active" id="reviewModal">
		<div class="_3OUv-">
			<div class="_2mP0n review-modal__modal">
				<div class="review-modal">
					<div class="review-modal__title">
						리뷰 쓰기
						<button type="button" class="review-modal__close" onclick="reviewClose()">
							<svg class="review-modal__close__icon" width="20" height="20" viewBox="0 0 20 20" fill="currentColor" preserveAspectRatio="xMidYMid meet"><path fill-rule="nonzero" d="M11.6 10l7.1 7.1-1.6 1.6-7.1-7.1-7.1 7.1-1.6-1.6L8.4 10 1.3 2.9l1.6-1.6L10 8.4l7.1-7.1 1.6 1.6z"></path></svg>
						</button>
					</div>
					<form class="review-modal__form">
						<div class="review-modal__form__product">
							<img class="review-modal__form__product__image" src="data:image/jpeg;base64,${encodedImage}">
							<div class="review-modal__form__product__contents">
								<div class="review-modal__form__product__contents__brand">브랜드명</div>
								<div class="review-modal__form__product__contents__name">[${productDTO.product_modifier}] ${productDTO.product_name}</div>
							</div>
						</div>
						<div class="review-modal__section">
							<div class="review-modal__section__title">별점 평가</div>
							<div class="review-modal__form__star__wrap">
								<div class="review-modal__form__star">
									<div class="review-modal__form__star__label">만족도</div>
									<div class="review-modal__form__star__value">
										<ul class="rating-input" id="starRating">
											<li>
												<label class="rating-input__star" aria-label="별점 1점">
													<input type="radio" name="review_star" value="1">
													<svg class="star" fill="currentColor" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 36 36"><path fill-rule="evenodd" d="M18 30.7l-9 3.8c-1.5.7-2.6-.2-2.5-1.8l.8-9.7L1 15.6c-1-1.3-.6-2.6 1-3l9.5-2.2 5-8.3c1-1.5 2.3-1.5 3.1 0l5 8.3 9.6 2.2c1.6.4 2 1.7 1 3L28.7 23l.8 9.7c.1 1.6-1 2.5-2.5 1.8l-9-3.8z"></path></svg>
												</label>
											</li>
											<li>
												<label class="rating-input__star" aria-label="별점 2점">
													<input type="radio" name="review_star" value="2">
													<svg class="star" fill="currentColor" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 36 36"><path fill-rule="evenodd" d="M18 30.7l-9 3.8c-1.5.7-2.6-.2-2.5-1.8l.8-9.7L1 15.6c-1-1.3-.6-2.6 1-3l9.5-2.2 5-8.3c1-1.5 2.3-1.5 3.1 0l5 8.3 9.6 2.2c1.6.4 2 1.7 1 3L28.7 23l.8 9.7c.1 1.6-1 2.5-2.5 1.8l-9-3.8z"></path></svg>
												</label>
											</li>
											<li>
												<label class="rating-input__star" aria-label="별점 3점">
													<input type="radio" name="review_star" value="3">
													<svg class="star" fill="currentColor" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 36 36"><path fill-rule="evenodd" d="M18 30.7l-9 3.8c-1.5.7-2.6-.2-2.5-1.8l.8-9.7L1 15.6c-1-1.3-.6-2.6 1-3l9.5-2.2 5-8.3c1-1.5 2.3-1.5 3.1 0l5 8.3 9.6 2.2c1.6.4 2 1.7 1 3L28.7 23l.8 9.7c.1 1.6-1 2.5-2.5 1.8l-9-3.8z"></path></svg>
												</label>
											</li>
											<li>
												<label class="rating-input__star" aria-label="별점 4점">
													<input type="radio" name="review_star" value="4">
													<svg class="star" fill="currentColor" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 36 36"><path fill-rule="evenodd" d="M18 30.7l-9 3.8c-1.5.7-2.6-.2-2.5-1.8l.8-9.7L1 15.6c-1-1.3-.6-2.6 1-3l9.5-2.2 5-8.3c1-1.5 2.3-1.5 3.1 0l5 8.3 9.6 2.2c1.6.4 2 1.7 1 3L28.7 23l.8 9.7c.1 1.6-1 2.5-2.5 1.8l-9-3.8z"></path></svg>
												</label>
											</li>
											<li>
												<label class="rating-input__star" aria-label="별점 5점">
													<input type="radio" name="review_star" value="5">
													<svg class="star" fill="currentColor" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 36 36"><path fill-rule="evenodd" d="M18 30.7l-9 3.8c-1.5.7-2.6-.2-2.5-1.8l.8-9.7L1 15.6c-1-1.3-.6-2.6 1-3l9.5-2.2 5-8.3c1-1.5 2.3-1.5 3.1 0l5 8.3 9.6 2.2c1.6.4 2 1.7 1 3L28.7 23l.8 9.7c.1 1.6-1 2.5-2.5 1.8l-9-3.8z"></path></svg>
												</label>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="review-modal__section">
							<input type="file" name="review_image" hidden>
							<div class="review-modal__section__title">
								사진 첨부(선택)
							</div>
							<div class="review-modal__section__explain">사진을 첨부해주세요. (최대 1장)</div>
							<button class="button button--color-blue-inverted button--size-50 button--shape-4 upload-button">
								<svg viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet"><path d="M21.1 4c.5 0 .9.4.9.9v14.2c0 .5-.4.9-.9.9H2.9a.9.9 0 01-.9-.9V4.9c0-.5.4-.9.9-.9h18.2zm-.91 1.8H3.8v10.85l5.54-6.27c.12-.17.38-.17.52 0l3.1 3.54c.06.06.08.14.06.2l-.4 1.84c-.02.14.15.23.23.12l3.16-3.43a.27.27 0 01.38 0l3.79 4.12V5.8zm-3.37 4.8a1.47 1.47 0 01-1.47-1.45c0-.81.66-1.46 1.47-1.46s1.48.65 1.48 1.46c0 .8-.66 1.45-1.48 1.45z"></path></svg>
								사진 첨부하기
							</button>
						</div>
						<div class="review-modal__section">
							<div class="review-modal__section__title">리뷰 작성</div>
							<textarea name="review_content" placeholder="자세하고 솔직한 리뷰는 다른 고객에게 큰 도움이 됩니다. (최소 20자 이상)" class="form-control text-area-input review-modal__form__review-input" style="height: 55.6px;"></textarea>
						</div>
						<button class="button button--color-blue button--size-50 button--shape-4 review-modal__form__submit" type="submit">완료</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	</form>
</div>
<!-- 장바구니 스크립트 -->
<script type="text/javascript">
function goCart() {
	var qtyInput = document.querySelector("button[id='quantity']");
	var value = qtyInput.textContent;
	window.location.href = "CartAdd_main.do?product_num=" + ${param.num} + "&order_count=" + value;
}

function goOrder() {
	var result = confirm("장바구니 상품을 포함하여 주문하시겠습니까?");
	if (result) {
		var qtyInput = document.querySelector("button[id='quantity']");
		var value = qtyInput.textContent;
		window.location.href = "Order_main.do?mode=all&product_num=" + ${param.num} + "&order_count=" + value;
	} else {
		var qtyInput = document.querySelector("button[id='quantity']");
		var value = qtyInput.textContent;
		window.location.href = "Order_main.do?mode=one&product_num=" + ${param.num}	+ "&order_count=" + value;
	}
}

function showChoose() {
	var result = confirm("진행하시겠습니까?"); // '예'를 선택하면 true, '아니오'를 선택하면 false 반환

	if (result) {
		// '예'를 선택한 경우
		console.log("사용자가 '예'를 선택했습니다. login.do로 이동합니다.");
		window.location.href = 'login.do'; // 사용자를 login.do로 리디렉션
	} else {
		// '아니오'를 선택한 경우
		console.log("사용자가 '아니오'를 선택했습니다.");
		// '아니오'를 선택했을 때의 동작을 여기에 작성할 수 있습니다.
	}
}
</script>

<!-- 스크랩 스크립트 -->
<script>
function scrap() {
	var isLogin = ${loginMember != null};
    
    if (!isLogin) {
        window.location.href = 'member_login.do';
        return;
    }
	
    var productNum = ${productDTO.product_num};

    $.ajax({
        url: 'scrap.do',
        type: 'POST',
        data: { product_num: productNum },
        success: function(result) {
            if (result === 'Y') {
            	console.log('스크랩 성공');
            	
            	// 버튼 색상 변경
                var button = $(".production-selling-header__action__button-scrap");
                button.find("svg").attr("fill", "#50E5B4");
                
                // 버튼 호출 함수 변경
                var button = $(".production-selling-header__action__button-scrap");
                button.find("svg").attr("fill", "#50E5B4");
                button.attr("onclick", "unscrap()");
                
                // 스크랩 수 증가
                var scrapCountElement = document.getElementById('scrapCount');
                var currentCount = parseInt(scrapCountElement.innerText);
                scrapCountElement.innerText = currentCount + 1;
                
            }  else {
                console.error('스크랩 실패');
            }
        },
        error: function(error) {
            console.error('스크랩 요청 실패:', result);
        }
    });
}

function unscrap() {
    var productNum = ${productDTO.product_num};

    $.ajax({
        url: 'unscrap.do',
        type: 'POST',
        data: { product_num: productNum },
        success: function(result) {
            console.log('스크랩 해제 요청 완료');
            
            // 스크랩 해제가 성공했을 때
            var button = $(".production-selling-header__action__button-scrap");
            button.find("svg").attr("fill", "rgba(0, 0, 0, 0)");
            button.attr("onclick", "scrap()");
            
            // 스크랩 수 감소
            var scrapCountElement = document.getElementById('scrapCount');
            var currentCount = parseInt(scrapCountElement.innerText);
            scrapCountElement.innerText = currentCount - 1;

        },
        error: function(error) {
            console.error('스크랩 해제 요청 실패:', error);
        }
    });
}
</script>

<!-- 리뷰쓰기 스크립트 -->
<script>
	function reviewOpen() {
		var isLogin = ${loginMember != null && loginMember.member_id != null};
		
		if(isLogin){
			document.getElementById('review_modal').style.display = 'block';
		} else {
			alert("로그인 후 이용가능 합니다.")
			window.location.href = "member_login.do";
		}

	}
	
	function reviewClose() {
		document.getElementById('review_modal').style.display = 'none';
	}
</script>

<script>
document.addEventListener('DOMContentLoaded', function() {
	let quantity = 1;
	
    // 수량 업데이트 함수
    function updateQuantity(newQuantity) {
        // 수량이 1 미만이 되지 않도록 보장
        quantity = Math.max(1, newQuantity);

        // 화면에 수량 업데이트
        document.getElementById('quantity').innerText = quantity;

        // 가격 업데이트
        const originalPrice = ${productDTO.product_price};
        const discountRate = ${productDTO.product_discount_rate};
        const discountedPrice = (originalPrice * (100 - discountRate)) / 100;
        const totalPrice = quantity * discountedPrice;

     // 화면에 가격 업데이트 (한글로 원 표시, 소수점 제거)
        document.getElementById('productPrice').innerText = Math.floor(totalPrice).toLocaleString('ko-KR') + '원';
        document.getElementById('productPrice2').innerText = Math.floor(totalPrice).toLocaleString('ko-KR') + '원';
    }

    // 플러스 버튼 클릭 이벤트
    document.getElementById('plus').addEventListener('click', function () {
        updateQuantity(quantity + 1);
    });

    // 마이너스 버튼 클릭 이벤트
    document.getElementById('minus').addEventListener('click', function () {
        updateQuantity(quantity - 1);
    });
    
    
    var header = document.querySelector('.production-selling-navigation__wrap');
    window.addEventListener('scroll', function() {
    	console.log('Scrolling');
        if (window.scrollY > 131.5) {
          header.style.top = '79.75px';
        } else {
          header.style.top = '131.5px';
        }
      });
});
</script>

<!-- 별점 스크립트 -->
<script>
  document.addEventListener('DOMContentLoaded', function() {
    var ratingStars = document.querySelectorAll('.rating-input__star');

    ratingStars.forEach(function(star, index) {
      star.addEventListener('mouseover', function() {
    
        resetRatingStars();
        this.classList.add('hover');
        fillStarsUptoThis(index);
      });
      
      star.addEventListener('click', function() {
      
        resetRatingStars();
        this.classList.add('selected');
        fillStarsUptoThis(index);
      });
    });

    function fillStarsUptoThis(index) {
      for (var i = 0; i <= index; i++) {
        ratingStars[i].classList.add('selected');
      }
    }

    function resetRatingStars() {
      ratingStars.forEach(function(star) {
        star.classList.remove('selected', 'hover');
      });
    }

    function getSelectedStarIndex() {
      var selectedStarIndex = -1;
      ratingStars.forEach(function(star, index) {
        if (star.classList.contains('selected')) {
          selectedStarIndex = index;
        }
      });
      return selectedStarIndex;
    }
      });
 </script>
 
<script>
document.addEventListener('DOMContentLoaded', function() {
    var stars = document.querySelectorAll('.production-review-item__writer__info__total-star svg');

    // 별점 초기화 (모든 별의 fill을 lightgray로 설정)
    stars.forEach(function(star) {
        star.setAttribute('fill', 'lightgray');
        console.log("초기화 완료");
    });
    
    <c:forEach var="Review" items="${main_listReview}" varStatus="loop">
    var starValue = ${Review.review_star};
    var reviewContainer = document.getElementById('review_${loop.index}'); // 리뷰 컨테이너에 고유한 ID를 설정
    var starContainer = reviewContainer.querySelector('.production-review-item__writer__info__total-star');
    var starElements = starContainer.querySelectorAll('svg');

    // 서버에서 받은 별점이 null이 아닌 경우에만 처리
    if (starValue !== null) {
        // 서버에서 받은 별점까지의 별에 대해 색상 변경
        for (var i = 1; i <= starValue; i++) {
            starElements[i - 1].setAttribute('fill', '#50E5B4');
        }
    }
</c:forEach>

});
</script>


 
 
 <!-- 리뷰 스크립트 -->
 <script>
 document.querySelector('.upload-button').addEventListener('click', function(event) {
	// 기본 이벤트 실행 방지
	event.preventDefault();
	    
	// input file 실행
	document.querySelector('input[name="review_image"]').click();
	
	});
 </script>
  
 <script>
  document.addEventListener('DOMContentLoaded', function(event) {
	  const stars = document.querySelectorAll('.rating-input__star');
	  
	  function updateStars(target) {
	    stars.forEach(function(star) {
	      star.classList.remove('filled');
	    });

	    target.classList.add('filled');
	    let previousSibling = target.previousElementSibling;
	    while(previousSibling) {
	      previousSibling.classList.add('filled');
	      previousSibling = previousSibling.previousElementSibling;
	    }
	  }

	  stars.forEach(function(star) {
	    star.addEventListener('click', function(e){
	      updateStars(e.currentTarget);
	    
	    });
	  });
	});
 </script>
<%-- <%@ include file="bottom.jsp" %> --%>
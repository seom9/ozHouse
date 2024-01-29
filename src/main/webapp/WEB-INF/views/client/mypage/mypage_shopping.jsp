<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ include file="mypage_top.jsp" %>

<link rel="stylesheet" href="${path}/resources/main_css/order.css"/>

<!-- css 파일 분리했더니 적용이 안 돼서 우선 여기다 뒀습니다 -->
<style>
.order_code234{
	padding-left: 42px;
    padding-top: 20px;
    padding-bottom: 10px;
}

.order_code123{
	font-weight: bold;
	font-size: 16px;
    line-height: 0;
    padding-left: 10px;
    padding-top: 10px;
    padding-bottom: 10px;
}

.order_code123:hover {
	color: #50E5B4;
}
.my-box {
    width: 91%;
    border: 1px solid #ddd; /* 테두리 스타일 지정 */
    border-radius: 10px; /* 네모 칸의 모서리를 둥글게 만듦 */
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 추가 */
    margin-top: 20px;
}

.commerce-cart__delivery-group__total1:hover {
    color: red; /* This will change the text color to red on hover */
}

</style>

<div>
	<div class="css-1jyrqzb">
		<div class="order-list__info__wrap">
		<div class="profile-box1">
		<a class="order-list__info__wrap__content" href="mypage_coupon.do">
			<svg class="order-list__info__wrap__content__icon--coupon" width="51" height="29" viewBox="0 0 51 29" preserveAspectRatio="xMidYMid meet"><g fill="none" fill-rule="evenodd"><path d="M46.493 1a3.5 3.5 0 012.48 1.025A3.482 3.482 0 0150 4.497h0v20.006A3.501 3.501 0 0146.493 28h0H4.507a3.5 3.5 0 01-2.48-1.025A3.482 3.482 0 011 24.503h0V4.497A3.501 3.501 0 014.507 1h0z" stroke="#757575" fill="#FFF" data-darkreader-inline-fill="" style="--darkreader-inline-fill: #181a1b; --darkreader-inline-stroke: #9e9689;" data-darkreader-inline-stroke=""></path><path fill="#757575" d="M7.167 1.06h1.111v26.32H7.167z" data-darkreader-inline-fill="" style="--darkreader-inline-fill: #9e9689;"></path><path d="M32.722 12.26c-.926-1.73-2.658-2.8-4.706-2.8h0c-2.895 0-5.294 2.382-5.294 5.6 0 2.658 2.4 5.04 5.294 5.04 2.048 0 3.78-1.07 4.706-2.8" stroke="#757575" stroke-width="3" stroke-linecap="round" data-darkreader-inline-stroke="" style="--darkreader-inline-stroke: #9e9689;"></path></g></svg>
		
		<div class="order-list__info__wrap__content__text"><span>쿠폰</span>
		<span class="order-list__info__wrap__content__value">${coupon} 개</span></div>
		</a>
		<a class="order-list__info__wrap__content" href="mypage_point.do">
		<svg class="order-list__info__wrap__content__icon--point" width="40" height="29" viewBox="0 0 40 29" preserveAspectRatio="xMidYMid meet">
		
		<title>icon/ic_point</title>
		
		<g transform="translate(-5 .5)" stroke="#757575" fill="none" fill-rule="evenodd" data-darkreader-inline-stroke="" style="--darkreader-inline-stroke: #9e9689;"><g transform="translate(23.889 6.16)" fill="#FFF" data-darkreader-inline-fill="" style="--darkreader-inline-fill: #e8e6e3;">
		<path d="M.5 3.86h20.111v13.585c0 .316-.248.59-.599.852-.5.374-1.234.705-2.14.986-1.873.581-4.46.937-7.316.937-2.857 0-5.444-.356-7.316-.937-.907-.281-1.642-.612-2.14-.986-.351-.263-.6-.536-.6-.852h0V3.86z"></path><ellipse cx="10.556" cy="3.36" rx="10.056" ry="2.86"></ellipse>
		<path d="M0 12.88c0 1.856 4.602 3.36 10.278 3.36h0c5.676 0 10.278-1.504 10.278-3.36M0 7.84c0 1.856 4.602 3.36 10.278 3.36h0c5.676 0 10.278-1.504 10.278-3.36"></path></g><ellipse fill="#FFF" cx="18.889" cy="14" rx="13.389" ry="13.5" data-darkreader-inline-fill="" style="--darkreader-inline-fill: #e8e6e3;"></ellipse><path d="M13.889 15.68h6.667c1.756.415 3.333-1.182 3.333-3.36 0-1.759-1.572-3.36-3.333-3.36h-3.334v11.2" stroke-linecap="round" stroke-width="3"></path></g></svg><div class="order-list__info__wrap__content__text">
		<span>포인트</span>
		<span class="order-list__info__wrap__content__value">${point} P</span></div></a>
		<button type="button" class="order-list__info__wrap__content order-list__info__wrap__content--button">
		<svg class="order-list__info__wrap__content__icon--rating" width="44" height="29" viewBox="0 0 44 29" preserveAspectRatio="xMidYMid meet"><g stroke="#757575" fill="none" fill-rule="evenodd" data-darkreader-inline-stroke="" style="--darkreader-inline-stroke: #9e9689;"><g fill="#FFF" data-darkreader-inline-fill="" style="--darkreader-inline-fill: #181a1b;"><path d="M20.797 10.59l3.46 9.584-19.742 7.243v-5.175l-3.48-4.402 19.762-7.25z"></path><path d="M23.203 10.59l-3.46 9.584 19.742 7.243v-5.175l3.48-4.402-19.762-7.25z"></path></g><path d="M24.967.466l.093.012a.499.499 0 01.307.214h0l1.235 1.884a1.499 1.499 0 001.39.672h0l2.228-.202a.499.499 0 01.54.432h0l.303 2.25a1.499 1.499 0 00.956 1.203h0l2.105.797a.499.499 0 01.299.62h0l-.698 2.17a1.499 1.499 0 00.339 1.491h0l1.561 1.647a.499.499 0 010 .688h0l-1.561 1.647a1.499 1.499 0 00-.34 1.492h0l.699 2.168a.499.499 0 01-.299.621h0l-2.105.797a1.499 1.499 0 00-.956 1.203h0l-.303 2.25a.499.499 0 01-.54.432h0l-2.228-.202a1.499 1.499 0 00-1.39.672h0l-1.235 1.884a.499.499 0 01-.676.155h0l-1.917-1.155a1.499 1.499 0 00-1.548 0h0l-1.917 1.155a.499.499 0 01-.676-.155h0l-1.235-1.884a1.499 1.499 0 00-1.39-.672h0l-2.228.202a.499.499 0 01-.54-.432h0l-.303-2.25a1.499 1.499 0 00-.956-1.203h0l-2.105-.797a.499.499 0 01-.299-.62h0l.698-2.17a1.499 1.499 0 00-.339-1.491h0l-1.561-1.647a.499.499 0 010-.688h0l1.561-1.647a1.499 1.499 0 00.34-1.492h0L9.576 8.35a.499.499 0 01.299-.621h0l2.105-.797a1.499 1.499 0 00.956-1.203h0l.303-2.25a.499.499 0 01.54-.432h0l2.228.202a1.499 1.499 0 001.39-.672h0L18.633.692a.499.499 0 01.307-.214h0l2.286 1.214a1.499 1.499 0 001.548 0h0L24.69.537a.499.499 0 01.37-.059z" fill="#FFF" data-darkreader-inline-fill="" style="--darkreader-inline-fill: #e8e6e3;"></path><g stroke-linecap="round" stroke-linejoin="round" stroke-width="3"><path d="M16.444 10.64l2.778 7.28L22 10.64M22 10.64l2.777 7.28 2.778-7.28"></path></g></g></svg><div class="order-list__info__wrap__content__text">
		<span>구매등급</span><span class="order-list__info__wrap__content__value">${member_level}</span>
		</div>
		</div></button></div>
	</div>
		
		
		
		<div class="profile-box1">
		<div class="test2">
		<div class="test">
		 <g fill="none" fill-rule="evenodd">
		   <text x="50%" y="50%" dominant-baseline="middle" text-anchor="middle" font-size="12" fill="#757575">입금 대기</text>
		 </g>
		<div class="order-list__info__wrap__content__text"><span></span>
		<span class="order-list__info__wrap__content__value">0</span>
		</div>
		</div>
		
		<div class="test">
		 <g fill="none" fill-rule="evenodd">
		   <text x="50%" y="50%" dominant-baseline="middle" text-anchor="middle" font-size="12" fill="#757575">결제 완료</text>
		 </g>
		<div class="order-list__info__wrap__content__text"><span></span>
		<span class="order-list__info__wrap__content__value">0</span></div>
		</div>
		<div class="test">
		<g fill="none" fill-rule="evenodd">
		   <text x="50%" y="50%" dominant-baseline="middle" text-anchor="middle" font-size="12" fill="#757575">배송 준비</text>
		 </g>
		<div class="order-list__info__wrap__content__text"><span></span>
		<span class="order-list__info__wrap__content__value">${ready}</span></div>
		</div>
		<div class="test">
		<g fill="none" fill-rule="evenodd">
		   <text x="50%" y="50%" dominant-baseline="middle" text-anchor="middle" font-size="12" fill="#757575">배송 중</text>
		 </g>
		<div class="order-list__info__wrap__content__text"><span></span>
		<span class="order-list__info__wrap__content__value">${delivery}</span></div>
		</div>
		<div class="test">
		<g fill="none" fill-rule="evenodd">
		   <text x="50%" y="50%" dominant-baseline="middle" text-anchor="middle" font-size="12" fill="#757575">배송 완료</text>
		 </g>
		<div class="order-list__info__wrap__content__text"><span></span>
		<span class="order-list__info__wrap__content__value">${complete}</span></div>
		</div>
		<div class="test">
		<g fill="none" fill-rule="evenodd">
		   <text x="50%" y="50%" dominant-baseline="middle" text-anchor="middle" font-size="12" fill="#757575">구매 확정</text>
		 </g>
		<div class="order-list__info__wrap__content__text"><span></span>
		<span class="order-list__info__wrap__content__value">0</span></div>
		</div>
		</div>
		</div>
		
		<div class="test3">
		    <div class="dropDown">
		        <button class="dropDownButton" onclick="toggleDropdown1('dropdown1')">
		            <span class="css-cdruys">기간</span>
		            <div class="_chevron_down_18 css-ae93ov"></div>
		            <div class="test4">
		            <div id="dropdown1" class="dropdown-content">
		            	<a href="mypage_shopping.do">전체 보기</a>
		                <a href="mypage_shopping.do?mode=period&detail=1">1개월 전</a>
		                <a href="mypage_shopping.do?mode=period&detail=3">3개월 전</a>
		                <a href="mypage_shopping.do?mode=period&detail=6">6개월 전</a>
		                <a href="mypage_shopping.do?mode=period&detail=12">1년 전</a>
		                <a href="mypage_shopping.do?mode=period&detail=24">2년 전</a>
		                <a href="mypage_shopping.do?mode=period&detail=36">3년 전</a>                
		            </div>
		            </div>
		        </button>
		        <button class="dropDownButton" onclick="toggleDropdown1('dropdown2')">
		            <span class="css-cdruys">주문 상태</span>
		            <div class="_chevron_down_18 css-ae93ov"></div>
		            <div id="dropdown2" class="dropdown-content">
		            	<a href="mypage_shopping.do">전체 보기</a>
		                <a href="mypage_shopping.do?mode=statement&detail=0">입금 대기</a>
		                <a href="mypage_shopping.do?mode=statement&detail=0">결제 완료</a>
		                <a href="mypage_shopping.do?mode=statement&detail=ready">배송 준비</a>
		                <a href="mypage_shopping.do?mode=statement&detail=delivery">배송 중</a>
		                <a href="mypage_shopping.do?mode=statement&detail=complete">배송 완료</a>
		                <a href="mypage_shopping.do?mode=statement&detail=0">구매 확정</a>
		            </div>
		        </button>
				
				<c:if test="${empty order_code_list}">
					주문한 상품이 없습니다
				</c:if>
				
				<c:if test="${not empty order_code_list}">
					<c:forEach var="order_code" items="${order_code_list}">
					<div class="my-box">
					<c:set var="order_price" value="0"/>
					<c:set var="product_qpty" value="0"/>
						<div class="test">
							<ul class="commerce-cart__content__group-list">
								<li class="commerce-cart__content__group-item">
									<article class="commerce-cart__group">
									<div class="order_code234"><span class="order_code123" style=""><a href="order_confirm.do?order=${order_code}">주문 코드 : ${order_code}</a></span></div>
									<hr>
									<c:forEach var="order_list" items="${user_order_list}">
									<c:if test="${order_code == order_list.order_code}">
									<c:set var="date" value="${order_list.order_date}"/>
										<c:set var="product" value="${order_product[order_list.order_num]}"/>
											<ul class="commerce-cart__group__item-list">
												<li class="commerce-cart__group__item">
														<ul class="commerce-cart__delivery-group__product-list">
															<li class="commerce-cart__delivery-group__product-item">
																<a href="prodView_main.do?product_num=${product.product_num}&select=best">
																<article class="carted-product">
																	<div class="carted-product__select">
																		<div class="_3zqA8"></div>
																	</div>
		
																	<div class="product-small-item product-small-item--clickable">
																		<div class="product-small-item__image">
																			<picture> <img src="${upPath}/${product.product_image}" /> </picture>
																		</div>
																		<div class="product-small-item__content">
																			<h1 class="product-small-item__title">${product.product_name}</h1>
		
																			<p class="css-w0e4y9 e1xep4wb1">무료배송 || 일반택배</p>
																			<br> <span class="carted-product__subtotal"
																				display="flex">
																				<p class="css-2kgyr3">
																					<span style="text-decoration: line-through;">
																					<fmt:formatNumber value="${product.product_price}" pattern="###,###" /></span>
																					&nbsp; <span class="css-1wu05q6">${order_list.order_count}개</span>
																					 <span class="css-1wu05q7">할인 적용 금액<span
																						class="discount_price">&nbsp; 
																					<fmt:formatNumber value="${(product.product_price - product.product_discount_price) * order_list.order_count}" pattern="###,###" />원
																					<c:set var="order_price" value="${order_price + (product.product_price - product.product_discount_price) * order_list.order_count}" />
																					<c:set var="product_qpty" value="${product_qpty + order_list.order_count}"/>
																					<!-- 배송 중 뽑아내는 코드 -->
																					<c:set var="delivery_now" value="배송 준비"/>
																					<c:choose>
																						<c:when test="${order_list.order_delivery_now eq 'delivery'}">
																							<c:set var="delivery_now" value="배송 중"/>
																						</c:when>
																						<c:when test="${order_list.order_delivery_now eq 'complete'}">
																							<c:set var="delivery_now" value="배송 완료"/>
																						</c:when>
																						<c:when test="${order_list.order_canceldate != null}">
																							<c:set var="delivery_now" value="취소 상품"/>
																						</c:when>																				
																					</c:choose>
																					</span></span>
																				</p>
																			</span>
																		</div>
																	</div>
		
																	
																</article></a>
															</li>
														</ul>
										</c:if>
									</c:forEach>
									<article class="carted-product"> 
										<p class="css-2kgyr3">
											<span>최종 금액 </span> 
											<span class="css-1wu05q7">상품 개수  ${product_qpty} 개 &nbsp;<span class="discount_price">
											<fmt:formatNumber value="${order_price}" pattern="###,###" />원
											</span></span>
											</p>
									</article>
						<footer class="commerce-cart__delivery-group__footer">
						<p class="commerce-cart__delivery-group__total">주문 날짜 : ${date}</p><br>
						<c:if test="${delivery_now eq '취소 상품'}">
							<p class="commerce-cart__delivery-group__total"><a href="order_confirm.do?order=${order_code}" style="color: red">취소된 상품입니다 : 상세보기</a></p>
						</c:if>
						<c:if test="${delivery_now != '취소 상품'}">
							<p class="commerce-cart__delivery-group__total">배송 상태 : ${delivery_now}</p><br>
							<c:if test="${delivery_now eq '배송 준비'}">
								<p class="commerce-cart__delivery-group__total1"><a href="order_confirm.do?order=${order_code}&mode=cancel">주문 취소 신청</a></p>
							</c:if>
						</c:if>
							<p class="commerce-cart__delivery-group__total">주문 취소 : 상품이 배송된 경우에는 상점으로 직접 문의 주시길 바랍니다</p>
						</footer>
									</article>
												</li>
											</ul>
									</article>
		
								</li>
							</ul>
						</div>
					</div>
					</c:forEach>
				</c:if>
		
				<br><br><br>
		    </div>
		</div>
</div>

<script type="text/javascript">
    function toggleDropdown1(id) {
        var allDropdowns = document.querySelectorAll('.dropdown-content');
        allDropdowns.forEach(function(dropdown) {
            if (dropdown.id === id) {
                dropdown.style.display = (dropdown.style.display === 'block') ? 'none' : 'block';
            } else {
                dropdown.style.display = 'none';
            }
        });
    }
</script>

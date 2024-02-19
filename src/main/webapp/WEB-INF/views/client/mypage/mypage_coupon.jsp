<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ include file="mypage_top.jsp" %>
<link rel="stylesheet" href="${path}/client/mypage_css/mypage.css"/>
<link rel="stylesheet" href="${path}/client/member_css/login.css"/>
<br><br><br>

<h2>쿠폰</h2>

<br><br>

<div class="coupon-feed__coupon-register"><h3 class="coupon-feed__coupon-register__header">쿠폰등록</h3>
<div class="coupon-feed__coupon-register__input-group">
<input type="text" placeholder="쿠폰코드를 입력해주세요." class="form-control" value="">
<button class="button button--color-blue button--size-40 button--shape-4" type="submit">등록</button></div></div>

<div>
<c:set var="num" value="0" />

<c:forEach var="cdto" items="${userCoupons}">
<c:if test="${num % 4 == 0}">
<div class="mer_coupon">
</c:if>
<div class="coupon-item">
<a href="#(상점 바로 가기)"><div class="coupon-item__title coupon-item__title">${cdto.merCouponname}</div></a>
<div class="coupon-item__valuation"><span class="coupon-item__valuation-number">${cdto.merCoupondiscount}원</span></div>
<div class="coupon-item__info"><div class="coupon-item__due-date">∙ <span>유효 기간 : ${cdto.merCouponenddate}</span></div>
<div class="coupon-item__minimum-payment">∙ <span>#원 이상 구매시</span></div>
<br><br>
  <button class="button button--color-blue button--size-50 button--shape-4" type="button" disabled>✓ 받았음</button>
</div></div>
<c:set var="num" value="${num + 1}" />
<c:if test="${num % 4 == 0}">
</div>
</c:if>
</c:forEach>
<br><br>
</div>

<hr>
<hr>
<div></div>
<div></div>

<c:set var="co" value="0" />
<c:forEach var="dto" items="${merCoupons}">
<c:if test="${co % 4 == 0}">
	<div class="mer_coupon">
</c:if>
<div class="coupon-item">
<a href="#(상점 바로 가기)"><div class="coupon-item__title coupon-item__title">${dto.merCouponname}</div></a>
<div class="coupon-item__valuation"><span class="coupon-item__valuation-number">${dto.merCoupondiscount}원</span></div>
<div class="coupon-item__info"><div class="coupon-item__due-date">∙ <span>유효 기간 : ${dto.merCouponenddate}</span></div>
<div class="coupon-item__minimum-payment">∙ <span>#원 이상 구매시</span></div>
<br><br>
	<button class="button button--color-blue button--size-50 button--shape-4" type="button" 
			onclick="window.location.href = '/mypage/coupon/${dto.merCouponnum}'">받기</button>
</div></div>
<c:set var="co" value="${co + 1}" />

<c:if test="${co % 4 == 0}">
	</div>
</c:if>
</c:forEach>


<p><p><p>

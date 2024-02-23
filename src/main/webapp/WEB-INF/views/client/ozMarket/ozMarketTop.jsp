<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/client/ozMarket_css/mainTop.css" />
<div class="container">
	<div class="left-group">
		<div>
			<a href="${pageContext.request.contextPath}/ozMarket"> <img
				src="/merchant/img/ozlogo2.png" width="60" height="60">
			</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/ozMarket/products">둘러보기</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/ozMarket/my-product">내 상품 팔기</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/main">oz의 집</a>
		</div>
	</div>
	<div class="search-container">
		<form action="${pageContext.request.contextPath}/ozMarket/search" method="get" class="search-form">
			<input type="text" placeholder="물품을 검색해보세요" name="search"
				class="search-input">
		</form>
	</div>
	<div class="right-group">
		<div>
			<a href="${pageContext.request.contextPath}/ozMarket/myInfo">내 정보</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/ozMarket/chatts">채팅하기</a>
		</div>
	</div>
</div>

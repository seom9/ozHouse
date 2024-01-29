<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ include file="mypage_top.jsp"%>

<link rel="stylesheet" href="${path}/resources/client/mypage_css/point.css" />
<head>

</head>

<br>
<br>
<br>
<br>
<br>

<div class="css-1h25ori e1t6i3i25">
	<div class="css-0 e1t6i3i24">
		<h2 class="css-o538wr">사용 가능한 포인트</h2>
		<p class="css-of8h0b">${member.member_point}P</p>
	</div>
	<div class="css-1yu4f1z">
		<p class="css-12fah4g">
			30일 이내 소멸 예정 포인트<b>0 P</b>
		</p>
	</div>
</div>

<div class="point-box">
	<div class="css-a4hf5k e1rx7pum13">
		<div class="css-1066lcq e1rx7pum12">
			<h2 class="css-o538wr e1rx7pum11">포인트 내역</h2>
		</div>
		
		<c:forEach var="point" items="${member_p}">
		<div class="css-18ewygj e1rx7pum9">
			<div class="css-oc7sge e1rx7pum8">
				<div class="css-1kwo4sf e1rx7pum7">
					<div class="css-3eylin e1rx7pum6">${point.order_date}</div>
					<div class="css-15jzb03 e1rx7pum5">
						<div class="css-s5xdrg e1rx7pum4">
							<div class="accumulate css-y3863i e1rx7pum3">${point.statement}</div>
							<div class="css-1kzfo6n">주문 번호 : <a href="order_confirm.do?order=${point.order_code}">${point.order_code}</a></div>
						</div>
						<ul class="css-82ta8s e1rx7pum1">
							<c:if test="${point.statement == '적립'}">
								<li>상품 구입을 축하드립니다! ${point.point} 포인트 적립되었습니다!</li>
							</c:if>
							<c:if test="${point.statement == '사용'}">
								<li>상품 구입에 ${point.point} 포인트 사용하였습니다!</li>
							</c:if>
						</ul>
					</div>
				</div>
				<div class="css-lgp5e9 e1rx7pum0">
				<c:if test="${point.statement == '적립'}"> + </c:if>
				<c:if test="${point.statement == '사용'}"> - </c:if>
				${point.point} P
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
</div>

<br><br><br><br><br>

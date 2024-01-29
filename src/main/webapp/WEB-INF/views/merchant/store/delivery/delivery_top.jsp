<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="resources/merchant/css/top.css">
<!-- 주문배송 top -->
<html>
<head>
<title>OZ의 집 : 배송관리</title>
</head>
<body>
	<div class="tab-container">
		<a href="deliveryList.do?mer_num=${merchantLoginMember.mer_num}&mode=all" class="tab-link">전체 배송 주문</a>
		<a href="deliveryList.do?mer_num=${merchantLoginMember.mer_num}&mode=ready" class="tab-link">배송 준비 주문</a>
		<a href="deliveryList.do?mer_num=${merchantLoginMember.mer_num}&mode=delivery" class="tab-link">배송 중인 주문</a>
		<a href="deliveryList.do?mer_num=${merchantLoginMember.mer_num}&mode=complete" class="tab-link">배송 완료 주문</a>
	</div>
</body>
</html>

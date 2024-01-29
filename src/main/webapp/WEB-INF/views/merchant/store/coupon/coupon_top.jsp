<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 쿠폰관리 top -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/top.css">
<html>
<body>
<div class="tab-container">
	<a href="coupon_insert.do?mer_num=${merchantLoginMember.mer_num}" class="tab-link">쿠폰 등록</a> 
	<a href="coupon_list.do?mer_num=${merchantLoginMember.mer_num}" class="tab-link">쿠폰 현황</a>
</div>
</body>
</html>
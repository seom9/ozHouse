<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 매출관리 top -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/top.css">
<html>
<body>
<div class="tab-container">
		<a href="sales_list.do?mer_num=${merchantLoginMember.mer_num}&mode=day" class="tab-link">일별 조회</a> 
		<a href="sales_list.do?mer_num=${merchantLoginMember.mer_num}&mode=month" class="tab-link">월별 조회</a>
		<a href="sales_list.do?mer_num=${merchantLoginMember.mer_num}&mode=year" class="tab-link">연별 조회</a>
</div>

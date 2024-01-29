<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 상품관리 top -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="resources/merchant/css/top.css">
<html>
<head>
</head>
<body>
<div class="tab-container">
<c:set var="mer_num" value="${merchantLoginMember.mer_num}"/>
        <a href="productManagement_input.do?mer_num=${merchantLoginMember.mer_num}" class="tab-link">상품등록</a>
        <a href="productManagement_productList.do?mer_num=${merchantLoginMember.mer_num}" class="tab-link">상품조회</a>
        <a href="productManagement_requestList.do?mer_num=${merchantLoginMember.mer_num}" class="tab-link">요청리스트</a>
        <a href="productManagement_stock.do?mer_num=${merchantLoginMember.mer_num}" class="tab-link">재고관리</a>
    </div>
</body>
</html>

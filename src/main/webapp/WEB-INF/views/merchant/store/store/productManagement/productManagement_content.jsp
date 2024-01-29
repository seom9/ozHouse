<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 상품상세보기 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/productManagementStyle.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="productManagement_top.jsp" %>
<head>
<title>OZ의 집 : 상품상세보기</title>
</head>
<body>
<div class="container">
    <div class="content-container">
    <h1 class="stock-header">상품 상세보기</h1>
            <div class="form-container">
                <div class="section-header">
                    <h2>기본 정보</h2>
                </div>
                <div class="form-section">
                    <div class="form-group">
                        <label for="product_name">상품명</label>
                        <div>${getProduct.product_name}
                    </div>
                    <div class="form-group">
    <label for="categorySelect">카테고리</label>
    <div>${getProduct.category_name}
</div>
                    <div class="form-group">
                        <label>상품금액</label>
                        <div class="price-inputs">
                            <div>${getProduct.product_price}
                            <div>${getProduct.product_discount_rate}
                            <div>${getProduct.product_discount_price}
                        </div>
                    </div>
              
                    <div class="form-group">
                        <label for="product_point">포인트</label>
                        <div class="input-flex">
                            <div>${getProduct.product_point}
                            <span>point</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="product_modifier">상품소개</label>
                        <div>${getProduct.product_modifier}
                    </div>
                </div>
                <div class="section-header">
                    <h2>이미지</h2>
                </div>
                 <div class="form-section">
                    <div class="form-group">
                    	<label>대표이미지</label>
                    	<div>
<img src="data:image/jpeg;base64,${encodedImage}" width="300" height="300">
                    	</div>
                    </div>
<div class="form-group">
    <label>상세이미지</label>
    <div>
<c:forEach var="encodedImagePro" items="${encodedImagesPro}">
            <div>
                <img src="data:image/png;base64,${encodedImagePro}" width="300" height="300">
            </div>
        </c:forEach>
    </div>
</div>
                <div class="section-header">
                    <h2>배송</h2>
                </div>
                <div class="form-section">
                    <div class="form-group">
                        <label for="product_assembly_cost">조립비(설치비)</label>
                        <div class="input-flex">
                            <div>${getProduct.product_assembly_cost}
                            <span>원</span>
                        </div>
                    </div>
                </div>
    </div>
    <div>
    
    
    
    
        <c:if test="${getProduct.product_approval_status=='ur'}">
    
    <div class="container">
    <div class="content-container">
    <h1 class="stock-header">상품 수정 상세보기</h1>
            <div class="form-container">
                <div class="section-header">
                    <h2>기본 정보</h2>
                </div>
                <div class="form-section">
                    <div class="form-group">
                        <label for="product_name">상품명</label>
                        <div>${getreProduct.product_name}
                    </div>
                    <div class="form-group">
    <label for="categorySelect">카테고리</label>
    <div>${getreProduct.category_name}
</div>
                    <div class="form-group">
                        <label>상품금액</label>
                        <div class="price-inputs">
                            <div>${getreProduct.product_price}
                            <div>${getreProduct.product_discount_rate}
                            <div>${getreProduct.product_discount_price}
                        </div>
                    </div>
              
                    <div class="form-group">
                        <label for="product_point">포인트</label>
                        <div class="input-flex">
                            <div>${getreProduct.product_point}
                            <span>point</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="product_modifier">상품소개</label>
                        <div>${getreProduct.product_modifier}
                    </div>
                </div>
                <div class="section-header">
                    <h2>이미지</h2>
                </div>
                 <div class="form-section">
                    <div class="form-group">
                    	<label>대표이미지</label>
                    	<div>
      		            	<img src="${product_image}/${getreProduct.product_image_change}" width="300" height="300">
                    	</div>
                    </div>
<div class="form-group">
    <label>상세이미지</label>
    <div>
        <c:forEach var="image" items="${fn:split(getreProduct.product_image_pro_change, ',')}">
            <div>
                <img src="${product_image_pro}/${image}" width="300" height="300">
            </div>
        </c:forEach>
    </div>
</div>
                <div class="section-header">
                    <h2>배송</h2>
                </div>
                <div class="form-section">
                    <div class="form-group">
                        <label for="product_assembly_cost">조립비(설치비)</label>
                        <div class="input-flex">
                            <div>${getProduct.product_assembly_cost}
                            <span>원</span>
                        </div>
                    </div>
                </div>
    </div>
    <div>
    
    
    </c:if>
    <c:if test="${getProduct.product_approval_status=='ok'}">
    	<input type="button"  value="이미지 수정" onclick="window.location='product_update.do?product_num=${getProduct.product_num}&mer_num=${merchantLoginMember.mer_num}'">
    </c:if>	
    	<input type="button" value="목록보기" onclick="window.location='productManagement_productList.do?mer_num=${merchantLoginMember.mer_num}'">
    </div>
</div>
</body>



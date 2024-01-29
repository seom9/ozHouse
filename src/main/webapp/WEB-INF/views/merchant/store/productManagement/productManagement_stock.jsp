<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 재고관리 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/product_style.css">
<link rel="stylesheet" type="text/css" href="resources/merchant/css/delivery_style.css">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="productManagement_top.jsp" %>
<style>
input[type="submit"].submit2 {
    background-color: #c0c0c0;
    color: black;
    border-color: #F4F4F4;
    font-size: 13px;
    padding: 8px 10px;
    cursor: pointer;
    font-weight: bold;
    }
    
</style>
<head>
<title>OZ의 집 : 재고관리</title>
<script>
function resetForm() {	// 폼 초기화
	document.forms["f1"].reset();  
    document.getElementById("searchString").value = "";
    document.getElementById("search").value = "all";
    
    var stockRadios = document.getElementsByName("stock");
    for(var i = 0; i < stockRadios.length; i++) {
        stockRadios[i].checked = false;
    }
    
    var specCheckboxes = document.querySelectorAll('input[type=checkbox][name=spec]');
    for (var checkbox of specCheckboxes) {
        checkbox.checked = false;
    }
}
</script>
<style>
.flex-cell.division {
    flex: 0 1 10%;
}

</style>
</head>
<div class="container">
	<div class="content-container">
	    <h1 class="stock-header">재고 관리</h1>
		<div class="flex-container">
	        <div class="flex-item">
	        	<p class="info-text">
	        		• 상품에 대한 재고를 쉽게 관리할 수 있는 페이지입니다.<br>
          			• 기타 수정사항은 OZ의 집MD에게 전달해주세요.<br>
	        	<p class="info-text red-text">
                  	• 품절된 옵션 및 품절 임박 옵션을 잘 관리해주세요 (품절 : 0건 / 품절 임박 : 0건 / 미사용 : 0건)<br>
	        	<p class="info-text">
	        		• 품절임박은 옵션 재고가 5개 이하 남은 제품을 의미합니다.<br><br>
       			</p>
			</div>
		</div>
		<c:set var="mer_num" value="${merchantLoginMember.mer_num}"/>
		<form name="f1" action="productManagement_stock.do?mer_num=${merchantLoginMember.mer_num }" method="post" class="flex-container">
	        <div class="flex-row">
	            <div class="flex-cell header-cell custom-label">품절&nbsp;&nbsp;&nbsp;&nbsp;</div>
	            <div class="flex-cell input-cell">
	                <input type="radio" value="out" name="stock" ${param.stock == 'out' ? 'checked' : ''}>품절
	                <input type="radio" value="almost_out" name="stock" ${param.stock == 'almost_out' ? 'checked' : ''}>품절 임박
	                <input type="radio" value="good" name="stock" ${param.stock == 'good' ? 'checked' : ''}>양호
	            </div>
	        </div>
			<div class="flex-row">
			    <div class="flex-cell header-cell custom-label">상품 구분</div>
			    <div class="flex-cell input-cell">
			        <input type="checkbox" value="todays" name="spec" ${param.spec.contains('todays') ? 'checked' : ''}>오늘의 딜
			        <input type="checkbox" value="best" name="spec" ${param.spec.contains('best') ? 'checked' : ''}>BEST
			        <input type="checkbox" value="normal" name="spec" ${param.spec.contains('normal') ? 'checked' : ''}>NORMAL
			    </div>
			</div>
	        <div class="flex-row">
	            <div class="flex-cell header-cell custom-label">검색&nbsp;&nbsp;&nbsp;&nbsp;</div>
	            <div class="flex-cell input-cell">
					<select name="search" id="search">
						<option value="all" ${param.search == 'all' ? 'selected' : ''}>전체</option>
	                    <option value="product_num" ${param.search == 'product_num' ? 'selected' : ''}>상품번호</option>
	                    <option value="product_name" ${param.search == 'product_name' ? 'selected' : ''}>상품명</option>
	                    <option value="category_name" ${param.search == 'category_name' ? 'selected' : ''}>카테고리</option>
	                </select>
		            <input type="text" id="searchString" name="searchString" value="${param.searchString}">
	            </div>
	        </div>
	<div class="flex-subrow custom-button-row">
   				<div class="button-container">
	            	<input type="submit" value="검색">
			            <input type="button" value="초기화" onclick="resetForm()">
	                <input type="hidden" name="mer_num" value="${merchantLoginMember.mer_num }"/>
	            </div>
   			</div>
	    </form>
	    <br>
	    <div align="left" class="results-heading">
	        <font size="2">검색 결과</font>&nbsp;&nbsp;총 ${stockListCount} 건
	    </div>
	    <div class="scroll flex-container content-table">
	        <div class="flex-row header-row">
	        	<div class="flex-cell division">구분</div>
	            <div class="flex-cell">상품번호</div>
	        	<div class="flex-cell">상품설명<div class="sub-header">상품명</div></div>
	            <div class="flex-cell">카테고리</div>
				<div class="flex-cell">이미지</div>
	            <div class="flex-cell">가격</div>
	            <div class="flex-cell">스펙</div>
	            <div class="flex-cell quantity">수량</div>
	            <div class="flex-cell">신청일</div>
	        </div>
	        <c:if test="${empty stockListProduct}">
	            <div class="flex-row">
	                <div class="flex-cell" colspan="9">검색된 결과가 없습니다.</div>
	            </div>
	        </c:if>
	        <c:forEach var="dto" items="${stockListProduct}">
	            <div class="flex-row">
	            	<div class="flex-cell division">
				        <c:if test="${dto.product_today != '0' }">
				        <div class="deal-container">
				        	<img src="resources/merchant/img/todays.png" width="500" height="500"> <br>
				        	<span style="font-size: 18px; color: #FF0000;">${dto.product_today}</span><span>의 딜</span>
						</div>
				        </c:if>
   					</div>
	                <div class="flex-cell">${dto.product_num}</div>
	                <div class="flex-cell">[${dto.product_modifier}]
	            		<div class="sub-content">${dto.product_name}</div>
	            	</div>       
	                <div class="flex-cell">${dto.category_name}</div>            
	                <div class="flex-cell">
        <c:if test="${not empty dto.encodedImage}">
            <img src="data:image/jpeg;base64,${dto.encodedImage}" width="40" height="40">
        </c:if>
        <c:if test="${empty dto.encodedImage}">
            <span>No image</span>
        </c:if>
    </div>
	                <div class="flex-cell"><fmt:formatNumber value="${dto.product_price}" pattern="###,###"/>원</div>
	                <div class="flex-cell">
		            <c:if test="${dto.product_spec == 'best'}">
		            	BEST
		            </c:if>
		            <c:if test="${dto.product_spec == 'normal'}">
		            	NORMAL
		            </c:if>
            		</div>
	                <div class="flex-cell quantity">
	                    <form name="f" method="post" action="stock_update.do?mer_num=${merchantLoginMember.mer_num }">
	                        <input type="hidden" name="product_num" value="${dto.product_num}"/>
	                        <input type="text" name="product_quantity" value="${dto.product_quantity }" size="5">개
<input type="submit" value="수정" class="submit2 edit-button">
	                        <input type="hidden" name="mer_num" value="${merchantLoginMember.mer_num }"/>
	                    </form>
	                </div>
	                <div class="flex-cell">${dto.product_input_date }</div>
	            </div>
	        </c:forEach>
	    </div>
	</div>
</div>

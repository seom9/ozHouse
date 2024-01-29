<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 재고관리 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="productManagementTop.jsp" %>
<style>
	.scroll {
	overflow : auto
	}
</style>
<div align="center">
	<form name="f1" action="productManagement_stock.do">
	<table border="1" width="100%">
	<div align="left">
	- 상품에 대한 재고를 쉽게 관리할 수 있는 페이지입니다.<br>
	- 기타 수정사항은 OZ의 집MD에게 전달해주세요.<br>
	- 품절된 옵션 및 품절 임박 옵션을 잘 관리해주세요 (품절 : 0건 / 품절 임박 : 0건 / 미사용 : 0건)<br>
	- 품절임박은 옵션 재고가 5개 이하 남은 제품을 의미합니다.<br>
	<br>
	</div>
		<tr>
			<th>품절</th>
			<td>
				<input type="radio" value="out" name="stock">품절
				<input type="radio" value="almost_out" name="stock">품절 임박
				<input type="radio" value="good" name="stock">양호
			</td>
		</tr>
		<tr>
			<th>검색</th>
			<td>
			<select name="search">
			<option value="product_num">상품번호</option>
			<option value="product_name">상품명</option>
		</select>
				<input type="text" name="searchString">
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<input type="reset" value="초기화">
				<input type="submit" value="검색">
			</td>
		</tr>
	</table>
	</form>

	<br>
	<div align="left" class="scroll">
	<font size="3">검색 결과</font>
	</div>
	<table border="0" width="100%">
		<tr>
			<th>이미지</th>
			<th>상품번호</th>
			<th>상품명</th>
			<th>가격</th>
			<th>수량</th>
		</tr>
	<c:if test="${empty stockListProduct}">
		<tr>
			<td colspan="5" align="center">검색된 결과가 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${stockListProduct}">
		<tr>
		<td>
			<img src="${product_image}/${dto.product_image}" width="40" height="40">
		</td>
			<td>${dto.product_num}</td>
			<td>${dto.product_name}</td>
			<td><fmt:formatNumber value="${dto.product_price}" pattern="###,###"/>원</td>
			<td>
			<form name="f" method="post" action="stock_update.do">
			    <input type="hidden" name="product_num" value="${dto.product_num}"/>
			    <input type="text" name="product_quantity" value="${dto.product_quantity }">개
			    <input type="submit" value="수정">
			</form>

			</td>
		</tr>				
	</c:forEach>
	</table>
</div>

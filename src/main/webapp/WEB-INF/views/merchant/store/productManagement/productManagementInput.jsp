<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 상품등록 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="productManagementTop.jsp" %>
<form name="f" action="productManagement_input.do" 
						method="post" enctype="multipart/form-data">
<div align="left">
<font size="4"><b>기본 정보</b></font>
</div>
<div align="center">
<table border="1" width="100%">
	<tr>
		<th width="30%">상품명</th>
		<td><input type="text" name="product_name"></td>
	</tr>
	<tr>
		<th>카테고리</th>
		<td>
			<select name="category_num" id="categorySelect">
			    <c:forEach var="dto" items="${listCate}">
			        <option value="${dto.category_num}">
			            ${dto.category_code}[${dto.category_name}]
			        </option>
			    </c:forEach>
			</select>
				</td>
			</tr>
			<tr>
				<th>상품금액</th>
				<td>대표가<input type="text" name="product_price">원
				할인율<input type="text" name="product_discount_rate">원
				할인가<input type="text" name="product_discount_price">원
				</td>
			</tr>
			<tr>
				<th>수량</th>
				<td><input type="text" name="product_quantity">개</td>
			</tr>
			<tr>
				<th>상품소개</th>
				<td>
					<textarea name="product_explanation" rows="5" cols="60"></textarea>
				</td>
			</tr>
			<tr>
				<th>포인트</th>
				<td><input type="text" name="product_price">point</td>
			</tr>
			</table>
			</div>
			<div align="left">
			<br>
			<font size="4"><b>이미지</b></font>
			</div>
			<div align="center">
			<table border="1" width="100%">
			<tr>
				<th width="30%">대표이미지</th>
				<td><input type="file" name="product_image"></td>
			</tr>
			<tr>
				<th width="30%">상세설명</th>
				<td><input type="file" name="product_image_pro"></td>
			</tr>
			</table>
			<div align="left">
			<br>
			<font size="4"><b>배송</b></font>
			</div>
			<div align="center">
			<table border="1" width="100%">
			<tr>
				<th width="30%">조립비(설치비)</th>
				<td><input type="text" name="product_assembly_cost">원</td>
			</tr>
		</table>	
		<table>
		<tr>
				<td align="center" colspan="2">
					<input type="reset" value="취소">
					<input type="submit" value="상품등록">
				</td>
			</tr>
		</table>
	</form>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>"%>
<!-- 배송설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="productManagementTop.jsp" %>
<form name="f" action="main_storeManagement.do" 
						method="post">
<div align="left">
	<table border="1" width="100%">
		<font size="3"><b>지역 추가 배송비</b></font>
		<tr>
			<td width="15%">
				<select name="area">
					<option>지역선택</option>
					<option>서울시</option>
					<option>경기도</option>
					<option>강원도</option>
					<option>충청도</option>
					<option>경상도</option>
					<option>전라도</option>
					<option>제주도</option>
				</select>
			</td>
			<td>
				<input type="text">원
			</td>
		</tr>
		<br>
		<font size="3"><b>반품/교환 배송비</b></font>
		<tr>
			<th>반품배송비</th>
			<td>편도 <input type="text">원</td>
		</tr>
		<tr>
			<th>교환배송비</th>
				<td>왕복 <input type="text">원</td>
		</tr>
		<tr>
			<th>반품/교환지</th>
				<td>
					<input type="text">
						판매자 주소록
				</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<input type="reset" value="취소">
				<input type="submit" value="등록">
			</td>
		</tr>
		</table>
	</form>
</div>

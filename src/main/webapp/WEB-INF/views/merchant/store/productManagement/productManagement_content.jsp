<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/productManagementStyle.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../storeMain/storeManagementTop.jsp"%>
<%@ include file="productManagement_top.jsp"%>
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
						<label for="proName">상품명</label>
						<div>[${getProduct.proModifier}]${getProduct.proName}</div>
					</div>
					<div class="form-group">
						<label for="categorySelect">카테고리</label>
						<div>${getProduct.categoryName}</div>
					</div>
					<div class="form-group">
						<label>상품금액</label>
						<div class="price-inputs">
							<div>
								대표가 :
								<fmt:formatNumber value="${getProduct.proPrice}"
									pattern="###,###" />
								원
							</div>
							<div>
								할인율 :
								<fmt:formatNumber value="${getProduct.proDiscountRate}"
									pattern="###,###" />
								%
							</div>
							<div>
								할인가 :
								<fmt:formatNumber value="${getProduct.proDiscountPrice}"
									pattern="###,###" />
								원
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="proPoint">포인트</label>
						<div class="input-flex">
							<div>${getProduct.proPoint}</div>
							<span>point</span>
						</div>
					</div>
				</div>
				<div class="section-header">
					<h2>이미지</h2>
				</div>
				<div class="form-section">
					<div class="form-group">
						<label>대표이미지</label>
						<div>
							<img src="data:image/jpeg;base64,${encodedImage}" width="800"
								height="800">
						</div>
					</div>
					<div class="form-group">
						<label>상세이미지</label>
						<div>
							<c:forEach var="encodedImagePro" items="${encodedImagesPro}">
								<div>
									<img src="data:image/png;base64,${encodedImagePro}" width="800"
										height="800">
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="section-header">
					<h2>배송</h2>
				</div>
				<div class="form-section">
					<div class="form-group">
						<label for="proAssemblyCost">조립비(설치비)</label>
						<div class="input-flex">
							<div>${getProduct.proAssemblyCost}</div>
							<span>원</span>
						</div>
					</div>
				</div>
			</div>
			<div>




				<c:if
					test="${getProduct.proApprovalStatus == 'ur' || getProduct.proApprovalStatus == 're'}">

					<h1 class="stock-header">상품 수정 상세보기</h1>
					<div class="form-container">
						<div class="section-header">
							<h2>기본 정보</h2>
						</div>
						<div class="form-section">
							<div class="form-group">
								<label for="proName">상품명</label>
								<div>[${getreProduct.proModifier}]${getreProduct.proName}</div>
							</div>
							<div class="form-group">
								<label for="categorySelect">카테고리</label>
								<div>${getreProduct.categoryName}</div>
							</div>
							<div class="form-group">
								<label>상품금액</label>
								<div class="price-inputs">
									<div>
										대표가 :
										<fmt:formatNumber value="${getreProduct.proPrice}"
											pattern="###,###" />
										원
									</div>
									<div>
										할인율 :
										<fmt:formatNumber value="${getreProduct.proDiscountRate}"
											pattern="###,###" />
										%
									</div>
									<div>
										할인가 :
										<fmt:formatNumber value="${getreProduct.proDiscountPrice}"
											pattern="###,###" />
										원
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="proPoint">포인트</label>
								<div class="input-flex">
									<div>${getreProduct.proPoint}</div>
									<span>point</span>
								</div>
							</div>
						</div>
						<div class="section-header">
							<h2>이미지</h2>
						</div>
						<div class="form-section">
							<div class="form-group">
								<label>대표이미지</label>
								<div>
									<img src="data:image/jpeg;base64,${encodedImage2}" width="800"
										height="800">
								</div>
							</div>
							<div class="form-group">
								<label>상세이미지</label>
								<div>
									<c:forEach var="encodedImagePro2" items="${encodedImagesPro2}">
										<div>
											<img src="data:image/png;base64,${encodedImagePro2}"
												width="800" height="800">
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="section-header">
							<h2>배송</h2>
						</div>
						<div class="form-section">
							<div class="form-group">
								<label for="proAssemblyCost">조립비(설치비)</label>
								<div class="input-flex">
									<div>${getreProduct.proAssemblyCost}</div>
									<span>원</span>
								</div>
							</div>
						</div>
					</div>
					<div>
				</c:if>
				<div class="button-container">
					<c:if test="${getProduct.proApprovalStatus=='ok'}">
						<c:set var="merNum" value="${merLoginMember.merNum}" />
						<input type="button" class="update-button" value="수정"
							onclick="window.location='product_update.do?proNum=${getProduct.proNum}&merNum=${merLoginMember.merNum}'">
					</c:if>
					<input type="button" class="list-button" value="목록보기"
						onclick="window.location='${pageContext.request.contextPath}/merchant/${merNum}/store/products'">
				</div>
			</div>
</body>



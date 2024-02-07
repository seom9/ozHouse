<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 상품등록 -->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/merchant/css/productManagementStyle.css">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../storeMain/storeManagementTop.jsp"%>
<%@ include file="productManagement_top.jsp"%>
<head>
<title>OZ의 집 : 상품등록</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
$(document).ready(function() {
	$('#proPrice, #proDiscountRate').on('input', calculateDiscount);

	function calculateDiscount() {
	    var productPrice = parseFloat($('#proPrice').val()) || 0;
	    var discountRate = parseFloat($('#proDiscountRate').val()) || 0;

	    var discountPrice = Math.round(productPrice * (discountRate / 100));
	    $('#proDiscountPrice').val(discountPrice);
	}
    
	 function isNumeric(value) {
	        return /^\d+$/.test(value);
	    }

	    function validateNumericFields() {
	        var fields = [
	            {selector: 'input[name="proPrice"]', name: '대표가'},
	            {selector: 'input[name="proDiscountRate"]', name: '할인율'},
	            {selector: 'input[name="proDiscountPrice"]', name: '할인가'},
	            {selector: 'input[name="proQuantity"]', name: '수량'},
	            {selector: 'input[name="proPoint"]', name: '포인트'},
	            {selector: 'input[name="proAssemblyCost"]', name: '조립비(설치비)'}
	        ];
	        for (var i = 0; i < fields.length; i++) {
	            var field = $(fields[i].selector);
	            var value = field.val().trim();
	            if (!isNumeric(value)) {
	                alert(fields[i].name + ' 는 숫자만 입력해주세요.');
	                field.focus();
	                return false;
	            }
	        }
	        return true;
	    }

	    $('form').submit(function(e) {
	        if (!validateNumericFields()) {
	            e.preventDefault(); 
	        }
	    });

    function sanitizeFileName(fileName) {
        return fileName.replace(/[^a-z0-9]/gi, '_').toLowerCase();
    }

    function updateFileInput(files, input) {
        var dataTransfer = new DataTransfer();
        files.forEach(file => dataTransfer.items.add(file));
        input.files = dataTransfer.files;
    }

    function previewImage(input, previewId, isPrimary = false) {
        var maxImages = 10;
        var previewContainer = $('#' + previewId);

        if (input.files.length > maxImages && previewId === 'additional-image-previews') {
            alert('10장 이상은 등록 불가합니다.');
            input.value = ''; 
            previewContainer.empty(); 
            return; 
        }

        let files = Array.from(input.files).slice(0, maxImages); 
        previewContainer.empty(); 

        files.forEach((file, index) => {
            var reader = new FileReader();
            reader.onload = function(e) {
                var sanitizedFileName = sanitizeFileName(file.name);
                var imgContainerId = isPrimary ? 'primary_img_' : 'detail_img_' + sanitizedFileName;
                var imgContainer = $('<div class="img-preview" id="' + imgContainerId + '"></div>');
                var removeButton = $('<button type="button" class="remove-img">X</button>');

                removeButton.click(function() {
                    $('#' + imgContainerId).remove();

                    if (isPrimary) {
                        input.value = '';
                    } else {
                        files = files.filter(f => sanitizeFileName(f.name) !== sanitizedFileName);
                        updateFileInput(files, input);
                    }
                });

                imgContainer.css({
                    'background-image': 'url(' + e.target.result + ')',
                    'background-size': 'contain',
                    'background-repeat': 'no-repeat',
                    'background-position': 'center center',
                    'height': '500px',
                    'width': '500px',
                    'border': 'none',
                    'position': 'relative',
                    'margin-top': '10px'
                });

                imgContainer.append(removeButton);
                previewContainer.append(imgContainer);
            };
            reader.readAsDataURL(file);
        });
    }

    $('#proImg').change(function() {
        previewImage(this, 'product-image-preview', true);
    });

    $('#proImgPro').change(function() {
        previewImage(this, 'additional-image-previews');
    });

    $('input[type="reset"]').click(function() {
        $('#additional-image-previews').empty();
        $('#proImgPro').val(''); 
        $('#product-image-preview').empty();
        $('#proImg').val(''); 
    });
});
</script>
<style>
input[type='number']::-webkit-inner-spin-button, input[type='number']::-webkit-outer-spin-button
	{
	-webkit-appearance: none;
	margin: 0;
}
</style>
</head>
<body>
	<div class="container">
		<div class="content-container">
			<c:set var="merNum" value="${merchantLoginMember.merNum}" />
			<form method="post"
				action="${pageContext.request.contextPath}/merchants/product-input"
				enctype="multipart/form-data">
				<input type="hidden" name="merNum"
					value="${merchantLoginMember.merNum}">
				<div class="form-container">
					<div class="section-header">
						<h2>기본 정보</h2>
					</div>
					<div class="form-section">
						<div class="form-group">
							<label for="proName">상품명</label> <input type="text" id="proName"
								name="proName" required>
						</div>
						<!-- JSP -->
						<div class="form-group">
							<label for="categorySelect">카테고리</label> <select
								name="category_num" id="categorySelect" required>
								<c:forEach var="category" items="${categories}">
									<option value="${category.ordinal()}">
										[${category.getCategoryCode()}]&nbsp;${category.getCategoryName()}
									</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group">
							<label>상품금액</label>
							<div class="price-inputs" style="display: flex;">
								<div class="input-flex" style="flex-grow: 1;">
									<input type="number" id="proPrice" name="proPrice"
										placeholder="대표가" required
										style="appearance: none; -moz-appearance: textfield; -webkit-appearance: none;"><span>원</span>
								</div>
								<div class="input-flex" style="flex-grow: 1;">
									<input type="number" id="proDiscountRate"
										name="proDiscountRate" placeholder="할인율" required min="0"
										max="100" value="0"
										style="appearance: none; -moz-appearance: textfield; -webkit-appearance: none;"><span>%</span>
								</div>
								<div class="input-flex" style="flex-grow: 1;">
									<input type="text" id="proDiscountPrice"
										name="proDiscountPrice" placeholder="할인가" required readonly><span>원</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="proQuantity">수량</label>
							<div class="input-flex">
								<input type="text" id="proQuantity" name="proQuantity" required>
								<span>개</span>
							</div>
							<div class="form-group">
								<label for="proPoint">포인트</label>
								<div class="input-flex">
									<input type="text" id="proPoint" name="proPoint" required>
									<span>point</span>

								</div>
								<div class="form-group">
									<label for="proModifier">상품소개 <span>10글자 이내로
											작성하세요.</span></label> <input type="text" id="proModifier" name="proModifier"
										maxlength="10" required>
								</div>
							</div>
							<div class="section-header">
								<h2>이미지</h2>
							</div>
							<div class="form-section image-upload-section">
								<div class="form-group image-group">
									<label for="proImg">대표이미지</label> <input type="file"
										id="proImg" name="proImg" accept="image/*" required>
									<div id="product-image-preview" class="image-preview"></div>
								</div>
								<div class="form-group image-group" id="fileUploadContainer">
									<label for="proImgPro">상세설명 <span>최대 10장 추가
											가능합니다.</span></label> <input type="file" name="proImgPro" id="proImgPro"
										multiple accept="image/*" required>
									<div id="additional-image-previews" class="image-preview"></div>
								</div>
							</div>
							<div id="product-image-preview" class="image-preview"></div>
						</div>
					</div>
					<div class="section-header">
						<h2>배송</h2>
					</div>
					<div class="form-section">
						<div class="form-group">
							<label for="proAssemblyCost">조립비(설치비)</label>
							<div class="input-flex">
								<input type="text" id="proAssemblyCost" name="proAssemblyCost"
									required> <span>원</span>
							</div>
						</div>
					</div>
				</div>
				<div class="button-container">
					<input type="submit" value="등록"> <input type="reset"
						value="초기화"> <input type="hidden" name="merNum"
						value="${merchantLoginMember.merNum }" />
				</div>
		</div>
	</div>
	</div>
	</form>
	</div>
	</div>
</body>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 상품수정 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/productManagementStyle.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="productManagement_top.jsp" %>
<head>
<title>OZ의 집 : 상품수정</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(document).ready(function() {
	$('#product_price, #product_discount_rate').on('input', calculateDiscount);

	function calculateDiscount() {
	    var productPrice = parseFloat($('#product_price').val()) || 0;
	    var discountRate = parseFloat($('#product_discount_rate').val()) || 0;

	    var discountPrice = Math.round(productPrice * (discountRate / 100));
	    $('#product_discount_price').val(discountPrice);
	}
	
	 function isNumeric(value) {
	        return /^\d+$/.test(value);
	    }

	    function validateNumericFields() {
	    	console.log("Validating fields"); 
	        var fields = [
	            {selector: 'input[name="product_price"]', name: '대표가'},
	            {selector: 'input[name="product_discount_rate"]', name: '할인율'},
	            {selector: 'input[name="product_discount_price"]', name: '할인가'},
	            {selector: 'input[name="product_point"]', name: '포인트'},
	            {selector: 'input[name="product_assembly_cost"]', name: '조립비(설치비)'}
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
            alert('You cannot upload more than 10 images for detailed description.');
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

    $('#product_image').change(function() {
        previewImage(this, 'product-image-preview', true);
    });

    $('#product_image_pro').change(function() {
        previewImage(this, 'additional-image-previews');
    });

    $('input[type="reset"]').click(function() {
        $('#additional-image-previews').empty();
        $('#product_image_pro').val(''); 
        $('#product-image-preview').empty();
        $('#product_image').val(''); 
    });
    window.setCategoryName = function(selectElement) { 
        var selectedOption = selectElement.options[selectElement.selectedIndex];
        var categoryName = selectedOption.getAttribute('data-name');
        document.getElementById('categoryName').value = categoryName;
    }
});

</script>
<style>
	input[type='number']::-webkit-inner-spin-button,
	input[type='number']::-webkit-outer-spin-button {
	    -webkit-appearance: none;
	    margin: 0;
	}
</style>
</head>
<body>
<div class="container">
    <div class="content-container">
    <h1 class="stock-header">상품 수정</h1>
        <form action="product_update.do" method="post" enctype="multipart/form-data">
            <div class="form-container">
                <div class="section-header">
                    <h2>기본 정보</h2>
                </div>
                <div class="form-section">
			    <div class="form-group">
			        <label for="product_name">상품명</label>
			        <input type="text" id="product_name" name="product_name" value="${getProduct.product_name}" required>
			    </div>
			    <div class="form-group">
			        <label for="categorySelect">카테고리</label>
			        <select name="category_num" id="categorySelect" required>
    <c:forEach var="dto" items="${listCate}">
        <option value="${dto.category_num}" ${dto.category_num == getProduct.category_num ? 'selected' : ''}>
            ${dto.category_code}[${dto.category_name}]
        </option>
    </c:forEach>
</select>
				</div>
<div class="form-group">
        <label>상품금액</label>
        <div class="price-inputs" style="display: flex;">
            <div class="input-flex" style="flex-grow: 1;">
                <input type="number" id="product_price" name="product_price" value="${getProduct.product_price}" placeholder="대표가" required style="appearance: none; -moz-appearance: textfield; -webkit-appearance: none;"><span>원</span>
            </div>
            <div class="input-flex" style="flex-grow: 1;">
                <input type="number" id="product_discount_rate" value="${getProduct.product_discount_rate}" name="product_discount_rate" placeholder="할인율" required min="0" max="100" value="0" style="appearance: none; -moz-appearance: textfield; -webkit-appearance: none;"><span>%</span>
            </div>
            <div class="input-flex" style="flex-grow: 1;">
                <input type="text" id="product_discount_price" value="${getProduct.product_discount_price}" name="product_discount_price" placeholder="할인가" required readonly><span>원</span>
            </div>
        </div>
    </div>
			                <div class="form-group">
			            		<label for="product_point">포인트</label>
			            			<div class="input-flex">
			                			<input type="text" id="product_point" name="product_point" value="${getProduct.product_point}"  required>
			                				<span>point</span>
			            			</div>
							        <div class="form-group">
							            <label for="product_modifier">상품소개</label>
											<input type="text" id="product_modifier" name="product_modifier" maxlength="10" value="${getProduct.product_modifier}"  required> 
							        </div>
    							</div>
<div class="section-header">
                <h2>이미지</h2>
            </div>
            <div class="form-section image-upload-section">
    <div class="form-group image-group">
    <span style="color: red">
    이미지 변경을 원하시지 않는 상황엔 처음과 같은 이미지를 추가해주세요.</span>
        <label for="product_image">대표이미지</label>
        <input type="file" id="product_image" name="product_image" accept="image/*" required> 
        <div id="product-image-preview" class="image-preview"></div>
    </div>
    <div class="form-group image-group" id="fileUploadContainer">
        <label for="product_image_pro">상세설명</label>
        <input type="file" name="product_image_pro" id="product_image_pro" multiple accept="image/*" required> 
        <div id="additional-image-previews" class="image-preview"></div>
    </div>
</div>
        								        	<div id="product-image-preview" class="image-preview"></div>
											</div>
								    	</div>
									</div>
							    <div class="section-header">
							        <h2>배송</h2>
							    </div>
							    <div class="form-section">
									<div class="form-group">
										<label for="product_assembly_cost">조립비(설치비)</label>
											<div class="input-flex">
								                <input type="text" id="product_assembly_cost" name="product_assembly_cost" value="${getProduct.product_assembly_cost}" required>
								                	<span>원</span>
								            </div>
							        </div>
							    </div>
							</div>
<div class="button-container">
<input type="hidden" name="mer_num" value="${merchantUpdate.mer_num}">
                <input type="submit" class="update-button" value="등록">
                <input type="reset" value="초기화">
                <input type="button" class="list-button" value="목록보기" onclick="window.location='productManagement_productList.do?mer_num=${merchantLoginMember.mer_num}'">
                <input type="hidden" name="mer_num" value="${merchantLoginMember.mer_num }"/>
                <input type="hidden" name="product_num" value="${getProduct.product_num}">
            </div>
        </form>
    </div>
</div>
</body>



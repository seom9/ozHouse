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
	
	 function isNumeric(value) {
	        return /^\d+$/.test(value);
	    }

	    // Function to validate numeric fields before submitting the form
	    function validateNumericFields() {
	    	console.log("Validating fields"); // Debugging line
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
	                alert(fields[i].name + ' 필드는 숫자값만 입력해야 합니다.');
	                field.focus();
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    // Event listener for the form submission
	    $('form').submit(function(e) {
	        // Validate the numeric fields
	        if (!validateNumericFields()) {
	            e.preventDefault(); // Prevent form submission if validation fails
	        }

	        // ... (the rest of your form submission code) ...
	    });

    // Function to sanitize file name for use as an ID
    function sanitizeFileName(fileName) {
        return fileName.replace(/[^a-z0-9]/gi, '_').toLowerCase();
    }

    // Function to update the file input when a file is removed
    function updateFileInput(files, input) {
        var dataTransfer = new DataTransfer();
        files.forEach(file => dataTransfer.items.add(file));
        input.files = dataTransfer.files;
    }

    // Function to create a preview of images
    function previewImage(input, previewId, isPrimary = false) {
        var maxImages = 10;
        var previewContainer = $('#' + previewId);

        // Check if more than 10 images are selected for the detailed description
        if (input.files.length > maxImages && previewId === 'additional-image-previews') {
            alert('You cannot upload more than 10 images for detailed description.');
            input.value = ''; // Clear the file input
            previewContainer.empty(); // Clear existing previews
            return; // Exit the function early to prevent previews from being generated
        }

        let files = Array.from(input.files).slice(0, maxImages); // Take only the first 10 files
        previewContainer.empty(); // Clear existing previews

        files.forEach((file, index) => {
            var reader = new FileReader();
            reader.onload = function(e) {
                var sanitizedFileName = sanitizeFileName(file.name);
                var imgContainerId = isPrimary ? 'primary_img_' : 'detail_img_' + sanitizedFileName;
                var imgContainer = $('<div class="img-preview" id="' + imgContainerId + '"></div>');
                var removeButton = $('<button type="button" class="remove-img">X</button>');

                removeButton.click(function() {
                    // Remove the image container
                    $('#' + imgContainerId).remove();

                    // Remove the file from the array and update input only if it's not the primary image
                    if (isPrimary) {
                        // Clear the primary image input if it's the primary image
                        input.value = '';
                    } else {
                        // Remove the file from the array and update input for detailed images
                        files = files.filter(f => sanitizeFileName(f.name) !== sanitizedFileName);
                        updateFileInput(files, input);
                    }
                });

                imgContainer.css({
                    'background-image': 'url(' + e.target.result + ')',
                    'background-size': 'contain',
                    'background-repeat': 'no-repeat',
                    'background-position': 'center center',
                    'height': '200px',
                    'width': '200px',
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

    // Event listeners for file inputs
    $('#product_image').change(function() {
        previewImage(this, 'product-image-preview', true);
    });

    $('#product_image_pro').change(function() {
        previewImage(this, 'additional-image-previews');
    });

    // Event listener for the reset button
    $('input[type="reset"]').click(function() {
        $('#additional-image-previews').empty();
        $('#product_image_pro').val(''); // Clear secondary image input
        $('#product-image-preview').empty();
        $('#product_image').val(''); // Clear primary image input
    });
    // Function to set the category name based on the selected category
    window.setCategoryName = function(selectElement) { // Modified to ensure function is in the global scope
        var selectedOption = selectElement.options[selectElement.selectedIndex];
        var categoryName = selectedOption.getAttribute('data-name');
        document.getElementById('categoryName').value = categoryName;
    }
});

</script>
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
							<option value="${dto.category_num}">
								${dto.category_code}[${dto.category_name}]
							</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label>상품금액</label>
					<div class="price-inputs">
					    <input type="text" name="product_price" placeholder="대표가" value="${getProduct.product_price}"  required>
					    <input type="text" name="product_discount_rate" placeholder="할인율" value="${getProduct.product_discount_rate}"  required>
					    <input type="text" name="product_discount_price" placeholder="할인가" value="${getProduct.product_discount_price}"  required>
					</div>
			                <div class="form-group">
			            		<label for="product_point">포인트</label>
			            			<div class="input-flex">
			                			<input type="text" id="product_point" name="product_point" value="${getProduct.product_point}"  required>
			                				<span>point</span>
			            			</div>
							        <div class="form-group">
							            <label for="product_modifier">상품소개</label>
											<input type="text" id="product_modifier" name="product_modifier" value="${getProduct.product_modifier}"  required> 
							        </div>
    							</div>
<div class="section-header">
                <h2>이미지</h2>
            </div>
            <div class="form-section image-upload-section">
    <div class="form-group image-group">
        <label for="product_image">대표이미지</label>
        <input type="file" id="product_image" name="product_image" accept="image/*"> 
        <div id="product-image-preview" class="image-preview"></div>
    </div>
    <div class="form-group image-group" id="fileUploadContainer">
        <label for="product_image_pro">상세설명</label>
        <input type="file" name="product_image_pro" id="product_image_pro" multiple accept="image/*"> 
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
            <div class="d_file">
                <input type="submit" value="등록">
                <input type="reset" value="초기화">
                <input type="button" value="목록보기" onclick="window.location='productManagement_productList.do?mer_num=${merchantLoginMember.mer_num}'">
                <input type="hidden" name="mer_num" value="${merchantLoginMember.mer_num }"/>
                <input type="hidden" name="product_num" value="${getProduct.product_num}">
            </div>
        </form>
    </div>
</div>
</body>



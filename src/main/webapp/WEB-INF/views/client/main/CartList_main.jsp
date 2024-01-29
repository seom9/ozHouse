<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="top.jsp" %>

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${path}/resources/client/main_css/cart.css"/>
<link rel="stylesheet" href="${path}/resources/Cart.css"/>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
function goOrder(){
    var result = confirm("구매하시겠습니까?");
    if (result) {
		window.location.href ="Order_main.do";
    } else {
		
    }
}


function cartUpdate(product_num, order_count) {
    $.ajax({
        type: 'post',
        url: "cart_update.do",
        data: {
            "product_num": product_num,
            "order_count": order_count
        },
        success: function(data) {
            if (data === "T") {
                console.log("성공");
            } else {
                console.log("실패");
            }
        },
        error: function(error) {
            alert("오류 발생: " + error);
        }
    });
}

function deleteCart() {
    var selectedProductNums = []; // 선택된 제품 번호를 저장할 배열

    $('input[id^="_3UImz"]').each(function() {
        if ($(this).prop('checked')) {
            // 체크된 체크박스의 id에서 product_num을 추출해서 배열에 추가합니다.
            var productId = $(this).attr('id').replace('_3UImz', '');
            selectedProductNums.push(productId);
        }
    });

    // 선택된 제품 번호를 컨트롤러에 POST 요청으로 보냅니다.
    $.ajax({
        type: 'post',
        url: 'cart_delete.do',
        contentType: 'application/json',
        data: JSON.stringify({ selectedProductNums: selectedProductNums }),
        success: function(data) {
        	location.reload();
        },
        error: function(error) {
            alert('정상적으로 처리되지 않았습니다! : ' + error);
        }
    });
}

document.addEventListener("DOMContentLoaded", function() {
    var incrementButtons = document.querySelectorAll(".increment-button");
    var decrementButtons = document.querySelectorAll(".decrement-button");

    // 증가 및 감소 버튼 이벤트 리스너 설정
    incrementButtons.forEach(function(btn) {
        btn.addEventListener("click", function() {
            var productId = this.id.replace('plus', '');
            var qtyInput = document.querySelector("#order_count" + productId);
            var newQuantity = parseInt(qtyInput.textContent || qtyInput.value) + 1;
            qtyInput.textContent = newQuantity;
            cartUpdate(productId, newQuantity);
            updatePrice(productId);
        });
    });

    decrementButtons.forEach(function(btn) {
        btn.addEventListener("click", function() {
            var productId = this.id.replace('minus', '');
            var qtyInput = document.querySelector("#order_count" + productId);
            if (qtyInput.textContent || qtyInput.value > 1) {
                var newQuantity = parseInt(qtyInput.textContent || qtyInput.value) - 1;
                if (newQuantity >= 1) { // qtyInput의 값이 1 이상이면 감소 가능
                    qtyInput.textContent = newQuantity;
                    cartUpdate(productId, newQuantity);
                    updatePrice(productId);
                }
            }
        });
    });

    function updatePrice(productId) {
        var qtyInput = document.querySelector("#order_count" + productId);
        var quantity = parseInt(qtyInput.textContent || qtyInput.value);

        // 제품 단가를 가져옵니다. HTML에서 데이터 속성을 사용하여 단가를 저장합니다.
        var productPrice = parseFloat(document.querySelector("#product_price" + productId).dataset.price);
        
        // 총 가격을 계산합니다.
        var totalProductAmount = quantity * productPrice;

        // 총 가격을 표시할 요소를 찾아 텍스트를 업데이트합니다.
        var totalProductAmountDisplay = document.querySelector("#product_total_price" + productId);
        totalProductAmountDisplay.textContent = totalProductAmount.toLocaleString() + " 원";
        updateTotalPrices();
    }
    
    function updateTotalPrices() {
        var totalOrderCount = 0;
        var totalOrderPrice = 0;
        var totalAssemblyCost = 0;
        var totalOriPrice = 0;
        var totaldiscountPrice = 0;
        
     // 각 제품에 대한 작업을 수행합니다.
        document.querySelectorAll('[id^="product_ori_price"]').forEach(function(item) {
            // id에서 product_num을 추출합니다.
            var productId = item.id.replace('product_ori_price', '');
            
            // 해당 제품의 order_count 값을 가져옵니다.
            var qtyInput = document.querySelector("#order_count" + productId);
            var quantity = parseInt(qtyInput.textContent || qtyInput.value);

            // 해당 제품의 원래 가격을 가져옵니다.
            var productOriPrice = parseFloat(item.dataset.price);

            // 해당 제품의 총 원래 가격을 계산하고 totalOriPrice에 더합니다.
            var totalProductOriPrice = quantity * productOriPrice;
            totalOriPrice += totalProductOriPrice;
        });

        // 총 원래 가격 계산
        document.querySelectorAll('[id^="product_total_price"]').forEach(function(item) {
            var price = parseFloat(item.textContent.replace(/[^0-9.]/g, '')); // 통화 기호를 제거하고 숫자만 추출
            if (!isNaN(price)) {
                totalOrderPrice += price;
            }
            totaldiscountPrice = totalOriPrice - totalOrderPrice; 

        });

        // 총 조립비 계산
        document.querySelectorAll('[id^="product_assembly_price"]').forEach(function(item) {
            // id에서 product_num을 추출합니다.
            var productId = item.id.replace('product_assembly_price', '');

            // 해당 제품의 order_count 값을 가져옵니다.
            var qtyInput = document.querySelector("#order_count" + productId);
            var quantity = parseInt(qtyInput.textContent || qtyInput.value);

            // 해당 제품의 조립비를 가져옵니다.
            var assemblyPrice = parseFloat(item.dataset.price);

            // 해당 제품의 총 조립비를 계산합니다.
            var totalProductAssemblyPrice = quantity * assemblyPrice;
            totalAssemblyCost += totalProductAssemblyPrice;
        });
        
        // 총 구매 개수 계산
        document.querySelectorAll('[id^="order_count"]').forEach(function(item) {
            var quantity = parseInt(item.textContent || item.value);
            if (!isNaN(quantity)) {
                totalOrderCount += quantity;
            }
        });

        // 총 원래 가격과 총 조립비 업데이트
        document.getElementById('total_ori_price').textContent = totalOriPrice.toLocaleString() + " 원";
        document.getElementById('final_order_price').textContent = totalOrderPrice.toLocaleString() + " 원";
        document.getElementById('total_assembly_price').textContent = totalAssemblyCost.toLocaleString() + " 원";
        document.getElementById('total_discount_price').textContent = totaldiscountPrice.toLocaleString() + " 원";
        document.getElementById('total_order_count').textContent = totalOrderCount;
    }
    
    updateTotalPrices();
    
});
</script>
<script>
document.addEventListener("DOMContentLoaded", function() {
    const stickyContainer = document.querySelector('.sticky-container');
    if (stickyContainer) {
        stickyContainer.removeAttribute('style');
    }
    
    // _3UImz 클래스 버튼 클릭 시
    $("#oner").on("click", function(){
        // 체크된 상태를 가져옵니다.
        var isChecked = $(this).prop('checked');

        // _3UImz 로 시작하는 모든 체크박스의 상태를 변경합니다.
        $('input[id^="_3UImz"]').prop('checked', isChecked);
    });
});
</script>

<span class="wairano">장바구니</span>


<body onload="f.member_id.focus()">
	<div  align="center" class="login-wrapper" style="text-align: left">
		<form name="f" method="post" id="login-form" action="order_success">
		<div class="commerce-cart__header"><span class="commerce-cart__header__left"><label class="_3xqzr _4VN_z"><div class="_3zqA8"><input type="checkbox" class="_3UImz" id="oner" value=""><span class="_2mDYR"><svg width="1em" height="1em" viewBox="0 0 16 16" class="_2UftR"><path fill="currentColor" d="M6.185 10.247l7.079-7.297 1.435 1.393-8.443 8.703L1.3 8.432l1.363-1.464z"></path></svg></span></div><span class="_1aN3J"><span class="commerce-cart__header__caption">모두선택</span></span></label></span><span class="commerce-cart__header__right"><button class="commerce-cart__header__delete" type="button" onclick="deleteCart()">선택삭제</button></span></div>
			<c:forEach var="dto" items="${sessionScope.cart.keySet()}" varStatus="loop">
				<article class="carted-product">
					<div class="carted-product__select">
						<div class="_3zqA8">
							<input type="checkbox" class="_3UImz" id="_3UImz${dto.product_num}" value="">
							<span class="_2mDYR"><svg width="1em" height="1em" viewBox="0 0 16 16" class="_2UftR">
							<path fill="currentColor" d="M6.185 10.247l7.079-7.297 1.435 1.393-8.443 8.703L1.3 8.432l1.363-1.464z"></path></svg></span>
						</div>
					</div>
						<a class="product-small-item product-small-item--clickable" href="/productions/1095943/selling">
							<div class="product-small-item__image">
								<picture>	
	         						<img src="data:image/jpeg;base64,${encodedImages[loop.index]}"/>
	  	 						</picture>
							</div>
							<div class="product-small-item__content">
								<h1 class="product-small-item__title">
									${dto.product_name}
								</h1>
								<p class="css-w0e4y9 e1xep4wb1">
									<c:if test="${dto.product_assembly_cost == 0}">
										<span id="product_assembly_price${dto.product_num}" data-price="${dto.product_assembly_cost}">
											무료 조립
										</span>
									</c:if>
									<c:if test="${dto.product_assembly_cost != 0}">
										<span id="product_assembly_price${dto.product_num}" data-price="${dto.product_assembly_cost}">
											조립비 ${dto.product_assembly_cost} 원
										</span>
									</c:if>									
									&nbsp;|&nbsp;일반택배
								</p>
							</div>
						</a>

					<ul class="carted-product__option-list">
						<li class="carted-product__option-list__item"><article
								class="css-m75hpw e1wjoq3w13">
								<h2 class="css-yakegh e1wjoq3w10">
									${dto.product_discount_rate} % 할인!&nbsp;
								</h2>

								<div class="css-1nrstx4 e1wjoq3w8">
									<div class="css-i2qw7n1">
        <span class="e1fp679o3 _subtract_18 css-1k5678y decrement-button" id="minus${dto.product_num}"></span>
        <button class="css-1gjftf7 e1fp679o2 quantity" id="order_count${dto.product_num}">${cart[dto]}</button>
        <span class="e1fp679o3 _add_18 css-1k5678y increment-button" id="plus${dto.product_num}"></span>
									</div>
									<div class="css-sp8wxv e1wjoq3w6">
										<span class="css-1xrj6am e1wjoq3w4" style="text-decoration: line-through;" id="product_ori_price${dto.product_num}" data-price="${dto.product_price}">
											<fmt:formatNumber value="${dto.product_price}" pattern="###,###" />
										</span>
										<span class="css-1xrj6am e1wjoq3w4" id="product_price${dto.product_num}" data-price="${dto.product_price - dto.product_discount_price}">
											 -> <fmt:formatNumber value="${dto.product_price - dto.product_discount_price}" pattern="###,###"/> 원 
										</span>
									</div>
								</div>
							</article>
						</li>
					</ul>
					<div class="carted-product__footer">
						<span class="carted-product__footer__left">
						<button class="carted-product__order-btn" type="button"></button></span>
						<span class="carted-product__subatotal">
						<span class="css-1xrj6am e1wjoq3w4" style="font-size: 22px" id="product_total_price${dto.product_num}">
							<fmt:formatNumber value="${(dto.product_price - dto.product_discount_price)*cart[dto]}" pattern="###,###"/>
						</span>원</span>
					</div>
				</article>
			</c:forEach>
		</form>
	</div>
	
	
<aside>
		<div class="sticky-child commerce-cart__side-bar">
			<dl class="commerce-cart__summary commerce-cart__side-bar__summary">
				<div class="commerce-cart__summary__row">
					<dt>총 상품금액</dt>
					<dd id="total_ori_price">
						<span class="number" id="total_price" style="text-decoration: line-through;"><fmt:formatNumber value="${dto.product_price}" pattern="###,###"/></span> 원
					</dd>
				</div>
				<div class="commerce-cart__summary__row">
					<dt>총 조립비</dt>
					<dd id="total_assembly_price">
						+ <span class="number" id="total_assembly_price">
						<fmt:formatNumber value="${order_assembly_price}" pattern="###,###"/></span> 원
					</dd>
					<input type="hidden" name="order_assembly_cost"
						value="${order_assembly_price}">
				</div>
				<div class="commerce-cart__summary__row">
					<dt>총 할인금액</dt>
					<dd id="total_discount_price">
						- <span class="number" id="total_discount_price">
							${order_dis_discount}</span>원
					</dd>
				</div>
				<div class="commerce-cart__summary__row commerce-cart__summary__row--total">
					<dt>결제금액</dt>
					<dd id="final_order_price">
						<span class="totalPrice" id="final_order_price">${(order_ori_price - order_dis_discount)}</span>원
					</dd>
				</div>
			</dl>
			<div class="commerce-cart__side-bar__order">
				<button
					class="_1eWD8 _3SroY _27do9 commerce-cart__side-bar__order__btn"
					type="button" onclick="goOrder()"><span id="total_order_count"></span> 개 상품 구매하기</button>
			</div>
		</div>
	</aside>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${path}/resources/css/order.css"/>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode1').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
<script>
document.addEventListener("DOMContentLoaded", function () {
    var memberUsePointValue = ${member.member_point}; // 서버 사이드에서 전달된 값
    var incrementButton = document.querySelector(".increment-button");
    var decrementButton = document.querySelector(".decrement-button");
    var memberUsePointAllButton = document.querySelector(".memberUsePointAllButton");
    var memberUsePointButton = document.querySelector(".memberUsePoint"); // 이 부분이 수정되었습니다
    var qtyInput = document.querySelector("input[name='product_quantity']");
    var basePrice = document.getElementById('basePrice').value; // 기본 가격 저장
    var discountPrice = document.getElementById('discountPrice').value;

    function updatePrice() {
        var basePriceValue = parseInt(document.getElementById('basePrice').value) || 0;
        var discountPriceValue = parseInt(document.getElementById('discountPrice').value) || 0;
        var usePointValue = parseInt(memberUsePointButton.value) || 0; // 이 부분이 수정되었습니다
        var qtyValue = parseInt(qtyInput.value) || 0;

        var totalPrice = qtyValue * basePriceValue;
        var finalPrice = (qtyValue * (basePriceValue - discountPriceValue)) - usePointValue;
        var finalDiscountPrice = (qtyValue * discountPriceValue) + usePointValue;

        document.getElementById('ori_price').textContent = new Intl.NumberFormat().format(totalPrice);
        document.getElementById('final_price').textContent = new Intl.NumberFormat().format(finalPrice);
        document.getElementById('final_discount_price').textContent = new Intl.NumberFormat().format(finalDiscountPrice);
    }

    incrementButton.addEventListener("click", function () {
        qtyInput.value = parseInt(qtyInput.value) + 1;
        updatePrice();
    });

    decrementButton.addEventListener("click", function () {
        if (qtyInput.value > 1) {
            qtyInput.value = parseInt(qtyInput.value) - 1;
            updatePrice();
        }
    });

    memberUsePointButton.addEventListener("input", function () {
    	var currentInputValue = parseInt(memberUsePointButton.value) || 0;

        // 입력된 포인트 값이 최대 포인트 값을 초과하는 경우
        if (currentInputValue > memberUsePointValue) {
            memberUsePointButton.value = memberUsePointValue; // 값 조정
        }
    	
    	updatePrice();
    });

    memberUsePointAllButton.addEventListener("click", function () {
        memberUsePointButton.value = memberUsePointValue; // 이 부분이 수정되었습니다
        updatePrice();
    });

    // 초기 페이지 로드 시 가격 업데이트
    updatePrice();
});

   
    
    
   
</script>
</head>

	
<aside>
<div class="sticky-child commerce-cart__side-bar">
	            <dl class="commerce-cart__summary commerce-cart__side-bar__summary">
	                <div class="commerce-cart__summary__row">
	                    <dt>총 상품금액</dt>
	 <dd id="ori_price">
    <span class="number" id="total_price"></span>
   	 원
	</dd>
	                </div>
	    <div class="commerce-cart__summary__row">
	        <dt>총 조립비</dt>
       <dd id="totalAssemblyCost">
    + <span class="number">0</span>
    원
</dd>
               </div>
               <div class="commerce-cart__summary__row">
                   <dt>총 할인금액</dt>
                   <dd id="totalDiscountAmount">
    - <span class="number" id="final_discount_price"></span>
    원
</dd>
               </div>
               <div class="commerce-cart__summary__row commerce-cart__summary__row--total">
                   <dt>결제금액</dt>
                  <dd  id="final_price">
    <span class="totalPrice"></span>원 <!-- Update this to reflect total price calculation -->
</dd>
               </div>
           </dl>
           <div class="commerce-cart__side-bar__order">
               <button class="_1eWD8 _3SroY _27do9 commerce-cart__side-bar__order__btn" type="button">1개 상품 구매하기</button>
           </div>
                   </div>
</aside>

<span class="wairano">주문/결제</span>


<body onload="f.member_id.focus()">
	<div  align="center" class="login-wrapper" style="text-align: left">
	<form name="f" method="post" id="login-form" action="order_success">		
		<span class="wairano2">주문자</span><br><br>
			이름 <br><br>
			<input type="text" value="${member.member_name}" placeholder="이름을 입력해 주세요."><br>
			이메일 <br><br>
			<input type="text" value="${member.member_email}" placeholder="이메일을 입력해 주세요."><br>
			연락처<br><br>
			<input type="text" value="${member.member_hp1}" name="member_hp1" size="3" maxlength="3"> -
			<input type="text" value="${member.member_hp2}" name="member_hp2" size="4" maxlength="4"> -
			<input type="text" value="${member.member_hp3}" name="member_hp3" size="4" maxlength="4">				
		<br><br>


		<span class="wairano2">배송지</span><br><br>
			<input type="text" tabindex="3" id="postcode1" name="member_postcode1" value="${member.member_postcode1}" placeholder="우편번호">
			<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
			<c:set var="addressArray" value="${fn:split(member.member_address1, '/')}" />
			<input type="text" id="sample6_address" name="sample6_address" value="${addressArray[0]}" placeholder="주소"><br>
			<input type="text" id="sample6_detailAddress" name="sample6_detailAddress" value="${addressArray[1]}" placeholder="상세주소">
			<input type="text" id="sample6_extraAddress" name="sample6_extraAddress" value="${addressArray[2]}" placeholder="참고항목">
			<br><br>

	
		<span class="wairano2">주문 상품</span><br><br>	
		
		   <c:if test="${not empty orderProducts}">	
		   

		     <div class="commerce-cart__content-wrap col-12 col-md-7 col-lg-8">
		<div class="commerce-cart__content">
		    <div class="sticky-container commerce-cart__header-wrap">
		        <div class="sticky-child commerce-cart__header">
		            <span class="commerce-cart__header__left">
		                <label class="_3xqzr _4VN_z">
		             <input type="checkbox" class="_3UImz" checked=""/>
		             <span class="_2mDYR">
		                 <svg width="1em" height="1em" viewBox="0 0 16 16" class="_2UftR">
		                     <path fill="currentColor" d="M6.185 10.247l7.079-7.297 1.435 1.393-8.443 8.703L1.3 8.432l1.363-1.464z"></path>
		                 </svg>
		         </span>
		                 </div>
		                 <span class="_1aN3J">
		                     <span class="commerce-cart__header__caption">모두선택</span>
		                 </span>
		             </label>
		         </span>
		         <span class="commerce-cart__header__right">
		             <button class="commerce-cart__header__delete" type="button">선택삭제</button>
		         </span>
		     </div>
		 </div>
		 <ul class="commerce-cart__content__group-list">
		     <li class="commerce-cart__content__group-item">
		     	<c:forEach var="dto" items="${orderProducts.keySet()}">
		         <article class="commerce-cart__group">
		             <h1 class="commerce-cart__group__header">$/{브랜드명}
		             <!-- -->배송</h1>
		
		<ul class="commerce-cart__group__item-list">
		    <li class="commerce-cart__group__item">
		        <article class="commerce-cart__delivery-group">
		<ul class="commerce-cart__delivery-group__product-list">
		    <li class="commerce-cart__delivery-group__product-item">
		   <article class="carted-product">
		       <div class="carted-product__select">
		           <div class="_3zqA8">
		        <input type="checkbox" class="_3UImz" checked=""/>
		        <span class="_2mDYR">
		            <svg width="1em" height="1em" viewBox="0 0 16 16" class="_2UftR">
		                <path fill="currentColor" d="M6.185 10.247l7.079-7.297 1.435 1.393-8.443 8.703L1.3 8.432l1.363-1.464z"></path>
		            </svg>
		        </span>
		           </div>
		       </div>
		
		<span class="css-17x2thm elsmzm01">
		    오늘출발 마감
		
			    <span class="afterDeadLine css-1xskdmv elsmzm00">$/{발송예정일}</span>
			</span>
			<a class="product-small-item product-small-item--clickable" href="#">
			    <div class="product-small-item__image">
			        <picture>	
			         	<img src="${upPath}/${dto.product_image}"/>
			  	   </picture>
			    </div>
			    <div class="product-small-item__content">
			        <h1 class="product-small-item__title">${dto.product_name}</h1>
			
			<p class="css-w0e4y9 e1xep4wb1">무료배송
			<!-- --> ||
			<!-- -->
			        일반택배</p>
			    </div>
			</a>
			<button id="openModal" class="carted-product__delete" type="button" aria-label="삭제">
			    <svg width="12" height="12" viewBox="0 0 12 12" fill="currentColor" preserveAspectRatio="xMidYMid meet">
			        <path fill-rule="nonzero" d="M6 4.6L10.3.3l1.4 1.4L7.4 6l4.3 4.3-1.4 1.4L6 7.4l-4.3 4.3-1.4-1.4L4.6 6 .3 1.7 1.7.3 6 4.6z"></path>
			    </svg>
			</button>
			<ul class="carted-product__option-list">
			    <li class="carted-product__option-list__item">
			       
				<article class="css-m75hpw e1wjoq3w13">
			  
			<h2 class="css-yakegh e1wjoq3w10">${dto.product_name}</h2>
			
			<button type="button" aria-label="삭제" class="css-nr8zwt e1wjoq3w9">
			   
			    <span class="_dismiss_16 css-1cr8apd"></span>
			</button>
			
			<div class="css-1nrstx4 e1wjoq3w8">
			   
			    <div class="quantity-selector">                   
		        <button type="button" class="decrement-button">-</button>
		        <input type="text" id="quantity" name="product_quantity" size="3" value="${orderProducts[dto]}" >
		        <button type="button" class="increment-button">+</button>
		        <input type="hidden" id="basePrice" value="${dto.product_price}">
		        <input type="hidden" id="discountPrice" value="${dto.product_discount_price}">
		    	</div>	      
			    <div class="css-sp8wxv e1wjoq3w6">
			       
		        <span class="css-1xrj6am e1wjoq3w4" id="ori_price"></span>
				
		        <!-- -->
		                                원</span>
		                            </div>
		                        </div>
		                    </article>
		                </li>
		            </ul>
		            <div class="carted-product__footer">
		                <span class="carted-product__footer__left">
		                    <button class="carted-product__edit-btn" type="button">옵션변경</button>
		                    <button class="carted-product__order-btn" type="button">바로구매</button>
		                </span>
		                <span class="carted-product__subtotal">
		                    <span class="carted-product__subtotal__number" id="final_price"></span>
		                    원
		                </span>
		            </div>
		        </article>
		    </li>
		</ul>
		<footer class="commerce-cart__delivery-group__footer">
		    <p class="commerce-cart__delivery-group__total">배송비
		    <!-- -->
		                                   미정</p>
		                               </footer>
		                             </article>
		                         </li>
		                     </ul>
		          
		                 </article>
		                  </c:forEach>
		             </li>
		         </ul>
		</div>
          
  		</c:if>        
		

		<span class="wairano2"> 쿠폰</span><br><br>	
		 <c:if test="${not empty userCouponList}">	
		 
		   	<c:forEach var="cdto" items="${userCouponList}">
		   	<ul>
		   		<div class="eo0ca796 css-113eoa3">
				<input title="${cdto.mer_couponname}" type="checkbox" class="css-s6rm2m">${cdto.mer_couponname}</div>
				<div class=" css-1vjp7rs eo0ca790"><div class="selected css-1gjupqf eo0ca795">${cdto.mer_coupondiscount}원 할인</div>
				<div class="css-1bdbp8h eo0ca794">${cdto.mer_couponenddate}까지</div>
				</div>
			 </ul>
			 
			</c:forEach>
		 </c:if>

		 <c:if test="${empty userCouponList}">	
		   	사용 가능한 쿠폰이 없어요<br><br>	
		 </c:if>
			
		<span class="wairano2">포인트</span><br><br>	
			<input type="text" value="0" class="memberUsePoint" name="member_use_point" maxlength="${member.member_point}" id="memberUsePoint">
			<input type="button" name="use_all_point" class="memberUsePointAllButton" value="전액 사용"><br>
			가용 포인트 : ${member.member_point} points
		<br><br>
		<span class="wairano2">결제 수단</span><br><br>	
		# 추후 추가하겠습니다
		

		</form></div>

</body>


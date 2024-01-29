<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ include file="../mypage/mypage_top2.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="${path}/resources/client/main_css/order.css"/>

<style>
.ordersuccess{
	font-size: 16px;
    line-height: 0;
}
</style>
<c:if test="${param.mode == 'cancel'}">
	<span class="wairano">주문 취소 </span>
</c:if>

<c:if test="${param.mode != 'cancel'}">
	<span class="wairano">주문 확인</span>
</c:if>



<body onload="f.member_id.focus()">
	<div  align="center" class="login-wrapper" style="text-align: left">
	<form name="f" method="post" id="login-form" action="order_success">		
	<c:if test="${param.mode == 'first'}">
		<div class="ordersuccess">주문되었습니다! 감사합니다</div>
	</c:if>
	<c:if test="${orderinfo.order_canceldate != null}">
		<div class="ordersuccess" style="color: red">취소된 주문입니다</div>
	</c:if>
		<br><br>
		<span class="wairano2">주문자</span><br><br>
			이름 <br><br>
			<input type="text" value="${orderinfo.order_name}" name="member_name" ReadOnly><br>
			연락처<br><br>
			<input type="text" value="${orderinfo.order_hp1}" name="member_hp1" ReadOnly> -
			<input type="text" value="${orderinfo.order_hp2}" name="member_hp2" ReadOnly> -
			<input type="text" value="${orderinfo.order_hp3}" name="member_hp3" ReadOnly>				
		<br><br>
		<span class="wairano2">배송지</span><br><br>
			<input type="text" tabindex="3" id="postcode1" name="member_postcode1" value="${orderinfo.order_postcode}" ReadOnly>
			<c:set var="addressArray" value="${fn:split(orderinfo.order_place, '/')}" />
			<input type="text" value="${addressArray[0]}" name="sample6_address" ReadOnly><br>
			<input type="text" value="${addressArray[1]}" name="sample6_detailAddress" ReadOnly>
			<input type="text" value="${addressArray[2]}" name="sample6_extraAddress" ReadOnly>
			<br><br>
			
      <span class="wairano2">주문 상품</span><br><br>   
      
         <c:if test="${not empty confirmOrderProducts}">   
           <div class="commerce-cart__content-wrap col-12 col-md-7 col-lg-8">

       <ul class="commerce-cart__content__group-list">
           <li class="commerce-cart__content__group-item">
      <c:forEach var="dto" items="${confirmOrderProducts.keySet()}">
               <article class="commerce-cart__group">
                   <h1 class="commerce-cart__group__header">$/{브랜드명}</h1>
      
      <ul class="commerce-cart__group__item-list">
          <li class="commerce-cart__group__item">
              <article class="commerce-cart__delivery-group">
      <ul class="commerce-cart__delivery-group__product-list">
          <li class="commerce-cart__delivery-group__product-item">
         <article class="carted-product">
             <div class="carted-product__select">
                 <div class="_3zqA8">

                 </div>
             </div>
      
         <div class="product-small-item product-small-item--clickable">
             <div class="product-small-item__image">
                 <picture>   
                     <img src="${upPath}/${dto.product_image}"/>
                 </picture>
             </div>
             <div class="product-small-item__content">
                 <h1 class="product-small-item__title">${dto.product_name}</h1>
         
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
         </p><br>
                 <span class="carted-product__subtotal" display="flex">
                     <p class="css-2kgyr3"><span style="text-decoration: line-through;"><fmt:formatNumber value="${dto.product_price}" pattern="###,###"/></span> &nbsp; 
                     <span class="css-1wu05q6">${confirmOrderProducts[dto]} 개</span> 
                     <span class="css-1wu05q7">할인 적용 금액<span class="discount_price">&nbsp; <fmt:formatNumber value="${dto.product_discount_price}" pattern="###,###"/>원</span></span></p>
                  </span>
                 <span class="carted-product__subtotal" display="flex">
                     <p class="css-2kgyr3"><span style="text-decoration: line-through;"></span> &nbsp; 
                     <span class="css-1wu05q6"></span> 
                     <span class="css-1wu05q7">상품 합계 금액<span class="discount_price" style="color: black; font-size:20px;">&nbsp; <fmt:formatNumber value="${(dto.product_price - dto.product_discount_price) * confirmOrderProducts[dto]}" pattern="###,###"/>원</span></span></p>
                  </span>   
             </div>
         </div>

         <ul class="carted-product__option-list">
             <li class="carted-product__option-list__item">

                      </li>
                  </ul>
                  <div class="carted-product__footer">
                      
                  </div>
              </article>
          </li>
      </ul>
      <footer class="commerce-cart__delivery-group__footer">
          <p class="commerce-cart__delivery-group__total">배송비 미정</p>
                                     </footer>
                                   </article>
                               </li>
                           </ul>
                
                       </article>
      <c:set var="order_ori_price" value="${order_ori_price + (dto.product_price*confirmOrderProducts[dto])}"/>
      <c:set var="order_dis_discount" value="${order_dis_discount + dto.product_discount_price*confirmOrderProducts[dto]}"/>                       
      <c:set var="order_assembly_cost" value="${order_assembly_cost + dto.product_assembly_cost*confirmOrderProducts[dto]}"/> 
      <c:set var="order_qpty" value="${order_qpty + confirmOrderProducts[dto]}"/>

      
      
                        </c:forEach>
		             </li>
		         </ul>
		</div>
          
  		</c:if>        
		
<!-- 쿠폰 잠깐 보류
		
		 <c:if test="${not empty userCouponList}">	
		 
		   	<c:forEach var="cdto" items="${userCouponList}">

		   		<div class="eo0ca796 css-113eoa3">
				<input title="${cdto.mer_couponname}" type="checkbox" class="css-s6rm2m" data-discount="${cdto.mer_coupondiscount}">${cdto.mer_couponname}</div>
				<div class=" css-1vjp7rs eo0ca790"><div class="selected css-1gjupqf eo0ca795">${cdto.mer_coupondiscount}원 할인</div>
				<div class="css-1bdbp8h eo0ca794">${cdto.mer_couponenddate}까지</div>
				</div>

			 
			</c:forEach>
		 </c:if>
  -->	<span class="wairano2">사용한 쿠폰</span><br><br>	
  
		 <c:if test="${empty userCouponList}">	
		   	사용한 쿠폰이 없어요
		 </c:if>
		 <c:if test="${not empty userCouponList}">	
		   	<c:forEach var="cdto" items="${userCouponList}">
			   	<ul>
			   		<div class="eo0ca796 css-113eoa3">
					<input title="${cdto.mer_couponname}" type="checkbox" name="selectedCoupons" value="${cdto.mer_couponnum}" class="css-s6rm2m" data-discount="${cdto.mer_coupondiscount}">${cdto.mer_couponname}</div>
					<div class=" css-1vjp7rs eo0ca790"><div class="selected css-1gjupqf eo0ca795">${cdto.mer_coupondiscount}원 할인</div>
					<div class="css-1bdbp8h eo0ca794">${cdto.mer_couponenddate}까지</div>
					</div>
				 </ul>
			</c:forEach>
		 </c:if>
			<br><br>

		<span class="wairano2">사용한 포인트</span><br>
			<c:if test="${not empty orderinfo}">	
			   	<input type="text" class="memberUsePoint" name="member_use_point" value="${orderinfo.order_dis_point}" id="memberUsePoint">
			 </c:if>

		<br><br>
		<br><br>

		<span class="wairano2">요청 사항</span><br><br>	
		<input type="text" value="${orderinfo.order_comment}" maxlength="50" name="order_comment">
		<br><br>	
		
		<span class="wairano2">결제 수단</span><br><br>	
		# 추후 추가하겠습니다

		</form></div>
		
<aside class="custom-aside">
	<div class="sticky-child commerce-cart__side-bar">
	            <dl class="commerce-cart__summary commerce-cart__side-bar__summary">
	                <div class="commerce-cart__summary__row">
	                    <dt>총 상품금액</dt>
					 <dd id="ori_price">
				    <span class="number" id="total_price"><fmt:formatNumber value="${order_ori_price}" pattern="###,###"/></span>
				   	 원
					</dd>
	                </div>
	    <div class="commerce-cart__summary__row">
	        <dt>총 조립비</dt>
       <dd id="totalAssemblyCost">
   		 + <span class="number"><fmt:formatNumber value="${order_assembly_cost}" pattern="###,###"/></span>
    		원</dd>
               </div>
               <div class="commerce-cart__summary__row">
                   <dt>총 할인금액</dt>
                   <dd> -
				<span class="number" id="final_discount_price"><fmt:formatNumber value="${order_dis_discount + orderinfo.order_dis_coupon + orderinfo.order_dis_point}" pattern="###,###"/></span>원</dd>
               </div>
               <div class="commerce-cart__summary__row" style="font-size:13px">
                   <dt>상품 할인 금액</dt>
                   <dd> -
				<span class="number" id="final_discount_price"><fmt:formatNumber value="${order_dis_discount}" pattern="###,###"/></span>원</dd>
               </div>
               <div class="commerce-cart__summary__row" style="font-size:13px">
                   <dt>쿠폰 할인 금액</dt>
                   <dd> -
				<span class="number" id="final_discount_price"><fmt:formatNumber value="${orderinfo.order_dis_coupon}" pattern="###,###"/></span>원</dd>
               </div>
               <div class="commerce-cart__summary__row" style="font-size:13px">
                   <dt>포인트 할인 금액</dt>
                   <dd> -
				<span class="number" id="final_discount_price"><fmt:formatNumber value="${orderinfo.order_dis_point}" pattern="###,###"/></span>원</dd>
               </div>
               <div class="commerce-cart__summary__row commerce-cart__summary__row--total">
                   <dt>결제금액</dt>
            	<c:if test="${orderinfo.order_canceldate != null}">
					<div class="ordersuccess" style="color: red">취소된 주문입니다</div><br>
				    <s><span class="totalPrice" id="final_order_price">
       					<fmt:formatNumber value="${order_ori_price + order_assembly_price -(order_dis_discount + orderinfo.order_dis_coupon + orderinfo.order_dis_point)}" pattern="###,###"/>
   					</span>원</s>
				</c:if>
            	<c:if test="${orderinfo.order_canceldate == null}">
					<dd id="final_order_price"><span class="totalPrice" id="final_order_price"><fmt:formatNumber value="${order_ori_price + order_assembly_price -(order_dis_discount + orderinfo.order_dis_coupon + orderinfo.order_dis_point)}" pattern="###,###"/></span>원</dd>
				</c:if>				
               </div>
            <c:if test="${param.mode == 'cancel'}">
            	<br><h1 class="product-small-item__title">사용하신 쿠폰은 복구가 불가능합니다</h1>
				<br><span class="wairano2">주문을 정말 취소하시겠습니까?</span><br><br>
				<div class="commerce-cart__side-bar__order">
               		<button class="_1eWD8 _3SroY _27do9 commerce-cart__side-bar__order__btn" type="button" onclick="location.href='order_cancel.do?order=${orderinfo.order_code}'">주문 취소하기</button>
           		</div>
			</c:if>
               
           </dl>
	</div> 
</aside>


</body>


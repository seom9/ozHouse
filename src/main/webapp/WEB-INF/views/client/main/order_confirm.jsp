<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ include file="../mypage/mypage_top.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="${path}/client/main_css/order.css"/>
<link rel="stylesheet" href="${path}/Cart.css"/>

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

      <br><br>
      <span class="wairano2">주문자</span><br><br>
         이름 <br><br>
         <input type="text" value="${orderinfo.getOName()}" ReadOnly><br>
         연락처<br><br>
         <input type="text" value="${orderinfo.phoneNumber1}" ReadOnly> -
         <input type="text" value="${orderinfo.phoneNumber2}" ReadOnly> -
         <input type="text" value="${orderinfo.phoneNumber3}" ReadOnly>            
      <br><br>
      <span class="wairano2">배송지</span><br><br>
         <input type="text" tabindex="3" id="postcode1" value="${orderinfo.postcode}" ReadOnly>
         <input type="text" value="${orderinfo.city}" ReadOnly><br>
         <input type="text" value="${orderinfo.street}" ReadOnly>
         <input type="text" value="${orderinfo.zipcode}" ReadOnly>
         <br><br>
      
      <span class="wairano2">주문 상품</span><br><br>   
      
         <c:if test="${not empty confirmOrderProducts}">   
           <div class="commerce-cart__content-wrap col-12 col-md-7 col-lg-8">

       <ul class="commerce-cart__content__group-list">
           <li class="commerce-cart__content__group-item">
      <c:forEach var="dto" items="${confirmOrderProducts}">
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
                     <img class="image" src="${dto.productDTO.proImg}" alt="상품 대표 이미지">
                 </picture>
             </div>
             <div class="product-small-item__content">
                 <h1 class="product-small-item__title">${dto.productDTO.proName}</h1>
         
         <p class="css-w0e4y9 e1xep4wb1">
            <c:if test="${dto.productDTO.proAssemblyCost == 0}">
               <span id="product_assembly_price${dto.productDTO.proNum}" data-price="${dto.productDTO.proAssemblyCost}">
                  무료 조립
               </span>
            </c:if>
            <c:if test="${dto.productDTO.proAssemblyCost != 0}">
               <span id="product_assembly_price${dto.productDTO.proNum}" data-price="${dto.productDTO.proAssemblyCost}">
                  조립비 ${dto.productDTO.proAssemblyCost} 원
               </span>
            </c:if>                           
            &nbsp;|&nbsp;일반택배         
         </p><br>
                 <span class="carted-product__subtotal" display="flex">
                     <p class="css-2kgyr3"><span style="text-decoration: line-through;"><fmt:formatNumber value="${dto.productDTO.proPrice}" pattern="###,###"/></span> &nbsp; 
                     <span class="css-1wu05q6">${dto.quantity} 개</span> 
                     <span class="css-1wu05q7">할인 적용 금액<span class="discount_price">&nbsp; <fmt:formatNumber value="${dto.productDTO.proDiscountPrice}" pattern="###,###"/>원</span></span></p>
                  </span>
                 <span class="carted-product__subtotal" display="flex">
                     <p class="css-2kgyr3"><span style="text-decoration: line-through;"></span> &nbsp; 
                     <span class="css-1wu05q6"></span> 
                     <span class="css-1wu05q7">상품 합계 금액<span class="discount_price" style="color: black; font-size:20px;">&nbsp; <fmt:formatNumber value="${(dto.productDTO.proPrice - dto.productDTO.proDiscountPrice) * dto.quantity}" pattern="###,###"/>원</span></span></p>
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
      <c:set var="order_ori_price" value="${order_ori_price + (dto.productDTO.proPrice*dto.quantity)}"/>
      <c:set var="order_dis_discount" value="${order_dis_discount + dto.productDTO.proDiscountPrice*dto.quantity}"/>                       
      <c:set var="order_assembly_cost" value="${order_assembly_cost + dto.productDTO.proAssemblyCost*dto.quantity}"/> 
      <c:set var="order_qpty" value="${order_qpty + dto.quantity}"/>


                        </c:forEach>
                   </li>
               </ul>
      </div>
          
        </c:if>        
      
      <span class="wairano2">사용한 쿠폰</span><br><br>   
  
       <c:if test="${empty userCouponList}">   
            사용한 쿠폰이 없어요
       </c:if>
       <c:if test="${not empty userCouponList}">   
            <c:forEach var="cdto" items="${userCouponList}">
               <ul>
                  <div class="eo0ca796 css-113eoa3">
               <input title="${cdto.merCouponname}" type="checkbox" name="selectedCoupons" value="${cdto.merCouponnum}" class="css-s6rm2m" data-discount="${cdto.merCoupondiscount}">${cdto.merCouponname}</div>
               <div class=" css-1vjp7rs eo0ca790"><div class="selected css-1gjupqf eo0ca795">${cdto.merCoupondiscount}원 할인</div>
               <div class="css-1bdbp8h eo0ca794">${cdto.merCouponenddate}까지</div>
               </div>
             </ul>
         </c:forEach>
       </c:if>
         <br><br>

      <span class="wairano2">사용한 포인트</span><br>
      <input type="text" class="memberUsePoint" value="${orderinfo.getODispoint()}" id="memberUsePoint">


      <br><br>
      <br><br>

      <span class="wairano2">요청 사항</span><br><br>   
      <input type="text" value="${orderinfo.getOComment()}" maxlength="50" name="order_comment">
      <br><br>   
      
      <span class="wairano2">결제 수단</span><br><br>   
      # 추후 추가하겠습니다

      </form></div><br><br><br><br><br><br><br><br><br><br><br><br>
      
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
            <span class="number" id="final_discount_price"><fmt:formatNumber value="${order_dis_discount + 0 + orderinfo.getODispoint()}" pattern="###,###"/></span>원</dd>
               </div>
               <div class="commerce-cart__summary__row" style="font-size:13px">
                   <dt>상품 할인 금액</dt>
                   <dd> -
            <span class="number" id="final_discount_price"><fmt:formatNumber value="${order_dis_discount}" pattern="###,###"/></span>원</dd>
               </div>
               <div class="commerce-cart__summary__row" style="font-size:13px">
                   <dt>쿠폰 할인 금액</dt>
                   <dd> -
            <span class="number" id="final_discount_price"><fmt:formatNumber value="0" pattern="###,###"/></span>원</dd>
               </div>
               <div class="commerce-cart__summary__row" style="font-size:13px">
                   <dt>포인트 할인 금액</dt>
                   <dd> -
            <span class="number" id="final_discount_price"><fmt:formatNumber value="${orderinfo.getODispoint()}" pattern="###,###"/></span>원</dd>
               </div>
               <div class="commerce-cart__summary__row commerce-cart__summary__row--total">
                   <dt>결제금액</dt>
               <c:if test="${orderinfo.getOCanceldate() != null}">
               <div class="ordersuccess" style="color: red">취소 신청된 주문입니다</div><br>
                <s><span class="totalPrice" id="final_order_price">
                      <fmt:formatNumber value="${order_ori_price + order_assembly_price -(order_dis_discount + 0 + orderinfo.getODispoint())}" pattern="###,###"/>
                  </span>원</s>
            </c:if>
               <c:if test="${orderinfo.getOCanceldate() == null}">
               <dd id="final_order_price"><span class="totalPrice" id="final_order_price"><fmt:formatNumber value="${order_ori_price + order_assembly_price -(order_dis_discount + 0 + orderinfo.getODispoint())}" pattern="###,###"/></span>원</dd>
            </c:if>            
               </div>
               <c:if test="${orderinfo.getOCanceldate() == null}">
            <br><span class="wairano2">주문 취소하기</span><br><br>
            <div class="commerce-cart__side-bar__order">
                     <button class="_1eWD8 _3SroY _27do9 commerce-cart__side-bar__order__btn" type="button" onclick="location.href='/order/cancel/${orderinfo.getONum()}'">주문 취소하기</button>
                 </div>
                  </c:if>      
           </dl>
   </div> 
</aside>
   

</body>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="mypage_top.jsp" %>

<c:forEach var="bdto" items="${best}">
<div style="width:100%;height:100%;position:absolute;top:0" data-viewport-type="window">

<div style="box-sizing:border-box;padding-top:0;padding-bottom:0;margin-top:0" data-test-id="virtuoso-item-list">
<div data-index="0" data-known-size="392" data-item-index="0" style="overflow-anchor:none;
	position: relative;   left: 6.5%;">

<div class="css-1bpmso0 e1b6d19b0"> 

<article class="e19k6sjk0 css-ylurzg e2x1i8f0">

 <a class="css-11ab5xd e1fm144d0" href="prodView_main.do?product_num=${bdto.product_num}&select=best"></a>
    
   <div class="product-thumbnail css-bga0xs e192vfif5">
      
       <div class="css-pr93pi e192vfif4">
     
    
           <button type="button" aria-label="scrap 토글 버튼" class="eggro9e0 css-1lyaokr">
             
               <span class="css-5dnyrm">
                
                   <svg class="css-q7lffx" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                       <path fill-rule="evenodd" clip-rule="evenodd" d="M20 2.75H4C3.44772 2.75 3 3.19771 3 3.75V20.8228C3 21.1988 3.39948 21.4403 3.73242 21.2655L11.5352 17.169C11.8262 17.0162 12.1738 17.0162 12.4648 17.169L20.2676 21.2655C20.6005 21.4403 21 21.1988 21 20.8228V3.75C21 3.19772 20.5523 2.75 20 2.75Z" fill="#35C5F0"></path>
                   </svg>
                 
                   <svg class="css-whh5e5" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                       <g clip-path="url(#clip0_15409_67579)">
                           <g filter="url(#filter0_d_15409_67579)">
                               <path d="M4.3 4.05V19.4992L10.9309 16.018C11.6003 15.6666 12.3997 15.6666 13.0691 16.018L19.7 19.4992V4.05H4.3ZM4 2.75H20C20.5523 2.75 21 3.19772 21 3.75V20.8228C21 21.1988 20.6005 21.4403 20.2676 21.2655L12.4648 17.169C12.1738 17.0162 11.8262 17.0162 11.5352 17.169L3.73242 21.2655C3.39948 21.4403 3 21.1988 3 20.8228V3.75C3 3.19771 3.44772 2.75 4 2.75Z" fill="white"></path>
                               <path d="M4.3 4.05V19.4992L10.9309 16.018C11.6003 15.6666 12.3997 15.6666 13.0691 16.018L19.7 19.4992V4.05H4.3Z" fill="white" fill-opacity="0.5"></path>
                           </g>
                       </g>
                       <defs>
                           <filter id="filter0_d_15409_67579" x="-2" y="-0.25" width="28" height="28.5735" filterUnits="userSpaceOnUse" color-interpolation-filters="sRGB">
                               <feFlood flood-opacity="0" result="BackgroundImageFix"></feFlood>
                               <feColorMatrix in="SourceAlpha" type="matrix" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0" result="hardAlpha"></feColorMatrix>
                               <feOffset dy="2"></feOffset>
                               <feGaussianBlur stdDeviation="2.5"></feGaussianBlur>
                               <feColorMatrix type="matrix" values="0 0 0 0 0.247059 0 0 0 0 0.278431 0 0 0 0 0.301961 0 0 0 0.15 0"></feColorMatrix>
                               <feBlend mode="normal" in2="BackgroundImageFix" result="effect1_dropShadow_15409_67579"></feBlend>
                               <feBlend mode="normal" in="SourceGraphic" in2="effect1_dropShadow_15409_67579" result="shape"></feBlend>
                           </filter>
                           <clipPath id="clip0_15409_67579">
                               <rect width="24" height="24" fill="white"></rect>
                           </clipPath>
                       </defs>
                   </svg>
               </span>
           </button>
          
           <div class="css-ypqde8 e192vfif3">
           
            
               <span class="thumbnail-image e192vfif2 css-1t4i64">
                
	<img src="${upPath}/${bdto.product_image}" class="thumbnail-image e192vfif2 css-1l77jhx" alt="Product Image"/>
               </span>
           </div>
        
           <div class="css-b2xyg5 e192vfif1"></div>
       </div>
   </div>
  
   <div class="product-info css-17wu10g e1uchds87">
    
       <div class="css-1r0yqr6 e1uchds86">
         
           <div class="product-brand css-11vbb10 e1uchds85">$/{브랜드명}</div>
         
           <span class="product-name css-11e7usa e1uchds84">${bdto.product_name}</span>
       </div>
      
       <div class="price css-14q3hbk e96bn353">
          
           <span class="css-pzbnhz e96bn352">${bdto.product_discount_rate}
             <span class="percentage">% </span>
            <font color="black"> <span>${bdto.product_price}원</span>
           </span>
           
           <span class="css-13aof0h e96bn351">
           <fmt:formatNumber value="${bdto.product_price}" pattern="###,###"/><br>
         
           </span>
       </div>
     
       <div class="review css-tk8sp3 e121lgxa1">
   
           <span class="icon _star_12 css-w9u1sc"></span>
           <strong class="avg">5</strong>
           <span class="count">리뷰 9999</span>
       </div>
       
         <div class="css-11tnk08 epicx700">
             <svg xmlns="http://www.w3.org/2000/svg" width="47" height="20" class="icon" aria-label="무료배송">
                 <g fill="none" fill-rule="evenodd">
                     <rect width="47" height="20" fill="#EAEDEF" fill-rule="nonzero" rx="4"></rect>
                     <path fill="#828C94" d="M12.73 5.38v3.96h-6.6V5.38h6.6zm-2.68 9.43H8.76v-3.25H5v-1.03h8.86v1.03h-3.81v3.25zm1.4-6.49V6.41H7.43v1.91h4.04zm11.08 2.7h-1.42v1.54h2.26v1.02h-8.86v-1.02h2.24v-1.53h-1.1V7.78h5.32V6.65H15.6V5.63h6.66V8.8h-5.33v1.18h5.61v1.04zm-4.53 0v1.54h1.87v-1.53H18zm14.37 3.78h-1.23V9.86h-.8v4.49h-1.2V5.18h1.2v3.66h.8V5h1.23v9.8zm-4.2-2.54h-3.9V6.01h1.27v2.26h1.36V6h1.28v6.26zm-1.27-1.01v-2h-1.36v2h1.36zm14.49 1.71c0 1.13-1.25 1.82-3.41 1.82s-3.42-.7-3.42-1.82 1.25-1.82 3.4-1.82c2.18 0 3.43.7 3.43 1.82zm-3.41-6.05c-.5 1.13-2.1 1.9-3.51 2.1l-.54-1c1.64-.17 3.39-1.06 3.39-2.54V5.2h1.33v.28c0 1.48 1.99 2.47 3.4 2.53l-.55 1.01c-1.31-.18-3.03-.97-3.52-2.1zm4.42 3.78h-8.86V9.66h3.79V8.4h1.29v1.26h3.78v1.03zm-2.33 2.27c0-.5-.83-.8-2.1-.8s-2.08.3-2.08.8c0 .51.81.8 2.08.8s2.1-.29 2.1-.8z"></path>
                 </g>
             </svg>
             <svg xmlns="http://www.w3.org/2000/svg" width="30" height="20" class="icon" aria-label="특가">
                 <rect width="30" height="20" fill="#F77" rx="4"></rect>
                 <path fill="#fff" d="M12.83 7.93v-.97h-4.9v-.555h5.228v-.991H6.655v4.063h6.59v-.992H7.928V7.93h4.901zm-6.295 3.747v1.002h5.326v2.037h1.274v-3.04h-6.6zm7.733-.588v-1.024H5.5v1.024h8.768zm9.642-1.307V8.725h-1.405V5H21.24v9.705h1.264V9.782h1.405zm-3.954-3.79h-4.53v1.056h3.147c-.174 1.938-1.623 3.975-3.736 4.945l.773.958c2.974-1.612 4.259-4.03 4.346-6.96z"></path>
             </svg>
         </div>
     </div>
      </article>
      <br>
    </c:forEach>
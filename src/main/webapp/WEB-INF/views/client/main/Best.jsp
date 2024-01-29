<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<head>
   <link rel="stylesheet" href="${path}/resources/client/main_css/best.css"/>
   <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
   <script type="text/javascript">
       $(function () {
           function executeScrap(product_num) {
               $.ajax({
                   type: 'post',
                   url: 'scrap_product.do',
                   data: { 'product_num': product_num },
                   success: function (data) {
                       if (data === 'Y') {
                           alert('상품이 스크랩 되었습니다');
                           location.reload(true);
                       } else if (data === 'N') {
                           alert('이미 스크랩한 상품입니다');
                       }
                   },
                   error: function (error) {
                       alert(error);
                   }
               });
           }
   
           // doScrap 버튼 클릭 이벤트 핸들러 등록
           $(".doScrap").click(function () {
               var product_num = $(this).find(".product_num").val();
               executeScrap(product_num);
           });
       });
   </script>
   <script>
	document.addEventListener('DOMContentLoaded', function () {
	    // 페이지 로드가 완료된 후 실행됩니다.
	
	    // top.jsp의 스타일을 삭제합니다.
	    const stickyContainer = document.querySelector('.sticky-container');
	    if (stickyContainer) {
	        stickyContainer.removeAttribute('style');
	    }
	});
</script>
   <script type="text/javascript">
       $(function () {
           function unexecuteScrap(product_num) {
               $.ajax({
                   type: 'post',
                   url: 'unscrap_product.do',
                   data: { 'product_num': product_num },
                   success: function (data) {
                       if (data === 'Y') {
                           alert('상품 스크랩 취소 되었습니다');
                           location.reload(true);
                       } else if (data === 'N') {
                           alert('이미 취소된 상품입니다');
                       }
                   },
                   error: function (error) {
                       alert(error);
                   }
               });
           }
           
           // unScrap 버튼 클릭 이벤트 핸들러 등록
           $(".unScrap").click(function () {
               var product_num = $(this).find(".product_num").val();
               unexecuteScrap(product_num);
           });
       });
   </script>
   <script type="text/javascript">
   function getTimeRemaining() {
       var now = new Date();
       var midnight = new Date(now.getFullYear(), now.getMonth(), now.getDate() + 1, 0, 0, 0);
       var difference = midnight - now;
      
       var hours = Math.floor((difference / (1000 * 60 * 60)) % 24);
       var minutes = Math.floor((difference / 1000 / 60) % 60);
       var seconds = Math.floor((difference / 1000) % 60);
       var year = now.getFullYear()%100;
       var month = now.getMonth() + 1; // 월은 0부터 시작하므로 1을 더해야 실제 월이 됩니다.
       var day = now.getDate();

       var timeString = hours + '시간 ' + minutes + '분 ' + seconds + '초 남음 ';
       $('.css-ngoqre').text(timeString);
       var nowTime = year + "/" +  month + "/" + day + " " + now.getHours() + '시 ' + now.getMinutes() + '분 기준';
       $('#nowTimes').text(nowTime);
   }
   
   getTimeRemaining();
   setInterval(getTimeRemaining, 1000);
   
   </script>

</head>
<div class="css-mga9c9">
	<c:if test="${param.spec == 'best'}">          
	<h1 class="css-7hbob5">BEST 상품</h1>
	<span class="css-hpu1zu ">최고의 상품, 모든 것을 오즈의 집에서</span>
	<span class="css-hpu1zu" id="nowTimes"
	   style="color: black; font-weight: bold;"></span>
	</c:if>
	
	<c:if test="${param.spec == 'today'}">          
	<h1 class="css-7hbob5">Todays DEAL 상품</h1>
	<span class="css-hpu1zu">초특가로 만나는 오즈의 집만의 상품</span>
	</c:if>
	
	<c:if test="${param.spec == 'category'}">          
	<h1 class="css-7hbob5">Category 상품</h1>
	<span class="css-hpu1zu3">최고의 상품, 모든 것을 오즈의 집에서</span>
	</c:if>
	
	<c:set var="rank" value="1"/>
	<c:set var="currentDate" value='<%= new SimpleDateFormat("yy/MM/dd").format(new Date())%>' />
	<c:if test="${empty product}">
		<div class="a">
			<img src="resources/client/image/notice_image.png">
		</div>
	</c:if>
	<div>
		<div class="css-9oiyo">
			<div style="width:100%;height:100%;position:absolute;top:0">
				<div style="box-sizing: border-box; padding-top: 0px; padding-bottom: 1479px; margin-top: 0px;">
					<div class="css-1bpmso0">
						<c:forEach var="tdto" items="${product}" varStatus="loop">
						<article class="css-ylurzg">
							<a href="prodView_main.do?num=${tdto.product_num}"></a>
							<div class="css-bga0xs">
								<div class="css-pr93pi">
									<c:set var="map" value="${scrapCheck}" />
									<c:if test="${tdto.product_today eq currentDate}">
									<span class="css-ngoqre"></span>
									</c:if><!-- 타임나오는 곳 -->
									<c:if test="${not empty sessionScope.loginMember}">
								        <c:if test="${map[tdto.product_num] eq 't'}">
								        	<button type="button" id="unScrap_${tdto.product_num}" aria-label="scrap 토글 버튼" class="css-1lyaokr unScrap">
								        		<input type="hidden" tabindex="1" value="${tdto.product_num}" class="product_num">
								        		<span class="css-5dnyrm">
								        			<svg class="css-whh5e5" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" clip-rule="evenodd" d="M20 2.75H4C3.44772 2.75 3 3.19771 3 3.75V20.8228C3 21.1988 3.39948 21.4403 3.73242 21.2655L11.5352 17.169C11.8262 17.0162 12.1738 17.0162 12.4648 17.169L20.2676 21.2655C20.6005 21.4403 21 21.1988 21 20.8228V3.75C21 3.19772 20.5523 2.75 20 2.75Z" fill="#35C5F0"></path></svg>
								        			<svg class="css-q7lffx" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><g clip-path="url(#clip0_15409_67579)"><g filter="url(#filter0_d_15409_67579)"><path d="M4.3 4.05V19.4992L10.9309 16.018C11.6003 15.6666 12.3997 15.6666 13.0691 16.018L19.7 19.4992V4.05H4.3ZM4 2.75H20C20.5523 2.75 21 3.19772 21 3.75V20.8228C21 21.1988 20.6005 21.4403 20.2676 21.2655L12.4648 17.169C12.1738 17.0162 11.8262 17.0162 11.5352 17.169L3.73242 21.2655C3.39948 21.4403 3 21.1988 3 20.8228V3.75C3 3.19771 3.44772 2.75 4 2.75Z" fill="white"></path><path d="M4.3 4.05V19.4992L10.9309 16.018C11.6003 15.6666 12.3997 15.6666 13.0691 16.018L19.7 19.4992V4.05H4.3Z" fill="white" fill-opacity="0.5"></path></g></g><defs><filter id="filter0_d_15409_67579" x="-2" y="-0.25" width="28" height="28.5735" filterUnits="userSpaceOnUse" color-interpolation-filters="sRGB"><feFlood flood-opacity="0" result="BackgroundImageFix"></feFlood><feColorMatrix in="SourceAlpha" type="matrix" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0" result="hardAlpha"></feColorMatrix><feOffset dy="2"></feOffset><feGaussianBlur stdDeviation="2.5"></feGaussianBlur><feColorMatrix type="matrix" values="0 0 0 0 0.247059 0 0 0 0 0.278431 0 0 0 0 0.301961 0 0 0 0.15 0"></feColorMatrix><feBlend mode="normal" in2="BackgroundImageFix" result="effect1_dropShadow_15409_67579"></feBlend><feBlend mode="normal" in="SourceGraphic" in2="effect1_dropShadow_15409_67579" result="shape"></feBlend></filter><clipPath id="clip0_15409_67579"><rect width="24" height="24" fill="white"></rect></clipPath></defs></svg>
								        		</span>
								        	</button>
								        </c:if>
								        <c:if test="${map[tdto.product_num] ne 't'}">
								        	<button type="button" id="doScrap_${tdto.product_num}" aria-label="scrap 토글 버튼" class="eggro9e0 css-1lyaokr doScrap">  
								        		<input type="hidden" tabindex="1" value="${tdto.product_num}" class="product_num">
								                <span class="css-5dnyrm">
								                	<svg class="css-q7lffx" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" clip-rule="evenodd" d="M20 2.75H4C3.44772 2.75 3 3.19771 3 3.75V20.8228C3 21.1988 3.39948 21.4403 3.73242 21.2655L11.5352 17.169C11.8262 17.0162 12.1738 17.0162 12.4648 17.169L20.2676 21.2655C20.6005 21.4403 21 21.1988 21 20.8228V3.75C21 3.19772 20.5523 2.75 20 2.75Z" fill="#35C5F0"></path></svg>
								                    <svg class="css-whh5e5" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><g clip-path="url(#clip0_15409_67579)"><g filter="url(#filter0_d_15409_67579)"><path d="M4.3 4.05V19.4992L10.9309 16.018C11.6003 15.6666 12.3997 15.6666 13.0691 16.018L19.7 19.4992V4.05H4.3ZM4 2.75H20C20.5523 2.75 21 3.19772 21 3.75V20.8228C21 21.1988 20.6005 21.4403 20.2676 21.2655L12.4648 17.169C12.1738 17.0162 11.8262 17.0162 11.5352 17.169L3.73242 21.2655C3.39948 21.4403 3 21.1988 3 20.8228V3.75C3 3.19771 3.44772 2.75 4 2.75Z" fill="white"></path><path d="M4.3 4.05V19.4992L10.9309 16.018C11.6003 15.6666 12.3997 15.6666 13.0691 16.018L19.7 19.4992V4.05H4.3Z" fill="white" fill-opacity="0.5"></path></g></g><defs><filter id="filter0_d_15409_67579" x="-2" y="-0.25" width="28" height="28.5735" filterUnits="userSpaceOnUse" color-interpolation-filters="sRGB"><feFlood flood-opacity="0" result="BackgroundImageFix"></feFlood><feColorMatrix in="SourceAlpha" type="matrix" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0" result="hardAlpha"></feColorMatrix><feOffset dy="2"></feOffset><feGaussianBlur stdDeviation="2.5"></feGaussianBlur>       <feColorMatrix type="matrix" values="0 0 0 0 0.247059 0 0 0 0 0.278431 0 0 0 0 0.301961 0 0 0 0.15 0"></feColorMatrix><feBlend mode="normal" in2="BackgroundImageFix" result="effect1_dropShadow_15409_67579"></feBlend><feBlend mode="normal" in="SourceGraphic" in2="effect1_dropShadow_15409_67579" result="shape"></feBlend></filter><clipPath id="clip0_15409_67579"><rect width="24" height="24" fill="white"></rect></clipPath></defs></svg>
								                  </span>
								         	</button>       
								         </c:if>
									</c:if>
									<div class="css-ypqde8">

										<img src="data:image/jpeg;base64,${product_encodedImages[loop.index]}" class="css-7bfh27" alt=" ${tdto.product_name}"/>
									</div>
									<div class="css-b2xyg5"></div>   
								</div>
							</div>
							<div class="product-info css-17wu10g">
								<div class="css-1r0yqr6">
									<c:if test="${param.spec == 'best'}">
								    	<c:if test="${rank < 6}"/>
								        	<svg xmlns="http://www.w3.org/2000/svg" height="16" width="18" viewBox="0 0 576 512"><!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.--><path d="M309 106c11.4-7 19-19.7 19-34c0-22.1-17.9-40-40-40s-40 17.9-40 40c0 14.4 7.6 27 19 34L209.7 220.6c-9.1 18.2-32.7 23.4-48.6 10.7L72 160c5-6.7 8-15 8-24c0-22.1-17.9-40-40-40S0 113.9 0 136s17.9 40 40 40c.2 0 .5 0 .7 0L86.4 427.4c5.5 30.4 32 52.6 63 52.6H426.6c30.9 0 57.4-22.1 63-52.6L535.3 176c.2 0 .5 0 .7 0c22.1 0 40-17.9 40-40s-17.9-40-40-40s-40 17.9-40 40c0 9 3 17.3 8 24l-89.1 71.3c-15.9 12.7-39.5 7.5-48.6-10.7L309 106z"/></svg>
							            	<div class="product-brand css-11vbb10 e1uchds85" style="color: red; font-weight: bold; font-size: 17px;">${rank} 위 상품!!</div>
								           	<c:set var="rank" value="${rank+1}"/>
							            </c:if>
										<span class="product-name css-11e7usa e1uchds84">
											<a href="prodView_main.do?num=${tdto.product_num}">[BEST] ${tdto.product_name}</a>
										</span>
							    </div>				      
							    <div class="price css-14q3hbk e96bn353">
							    	<span class="css-pzbnhz e96bn352">
							        	${tdto.product_discount_rate}
							        	<span class="percentage">%</span>
							        </span>
							        <span class="css-13aof0h e96bn351">
							        	<fmt:formatNumber value="${tdto.product_price}" pattern="###,###"/> 원<br>
							        </span>
							    </div>			     
							    <div class="review css-tk8sp3 e121lgxa1">
							    	<span class="css-w9u1sc">
							    		<svg class="icon" width="14" height="14" viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet"><path fill="#50E5B4" fill-rule="evenodd" d="M12 19.72l-5.677 2.405c-.76.322-1.318-.094-1.247-.906l.533-6.142-4.042-4.656c-.54-.624-.317-1.283.477-1.467l6.006-1.39L11.23 2.28c.426-.707 1.122-.699 1.542 0l3.179 5.282 6.006 1.391c.805.187 1.011.851.477 1.467l-4.042 4.656.533 6.142c.072.822-.497 1.224-1.247.906L12 19.72z"></path>
									</svg>
							    	</span>
							    	<span class="count"> 리뷰</span>
							    </div>	
							</div>
						</article>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>     	
</div>
</body>
</html>
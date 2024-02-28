<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<head>
   <link rel="stylesheet" href="${path}/client/main_css/best.css"/>
   <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<!-- 스크랩 스크립트 -->
	<script type="text/javascript">
		function scrap(memberId, productNum, is) {
			// ** json data 전송 시 jstl 태그 자바스크립트에 안 먹음 ** // 		
		    fetch('/scrap/' + memberId + '/' + productNum + '/' + is, {
		        method: 'POST', 
		        headers: {
		            'Content-Type': 'application/json'
		        },
		        body: JSON.stringify({
		        	memberId : memberId,
		        	productNum : productNum
		        }),
		    })
		    .then(response => {
		        if (!response.ok) {
		            throw new Error('Network response was not ok');
		        }
		        return response.text(); 
		    })
		    .then(data => {
		        alert(data)
		        location.reload()
		    })
		    .catch(error => {
		    	alert("서버 통신에 실패했습니다 : 관리자에게 문의해 주세요")
		    });
		}
	</script>
	
	<script type="text/javascript">
	function cantScrap() {
		alert("스크랩 : 로그인 해 주세요")
		window.location.href = "/member/login"
	}
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
	<c:if test="${spec == 'today'}">          
	<h1 class="css-7hbob5">Todays DEAL 상품</h1>
	<span class="css-hpu1zu">초특가로 만나는 오즈의 집만의 상품</span>
	</c:if>
	
	<c:if test="${spec == 'products'}">          
	<h1 class="css-7hbob5">모든 상품</h1>
	<span class="css-hpu1zu3">최고의 상품, 모든 것을 오즈의 집에서</span>
	</c:if>
	
	<c:set var="rank" value="1"/>
	<c:set var="currentDate" value='<%= new SimpleDateFormat("yy/MM/dd").format(new Date())%>' />
	<c:if test="${empty product}">
		<div class="a">
			<img src="client/image/notice_image.png">
		</div>
	</c:if>
	<div>
		<div class="css-9oiyo">
			<div style="width:100%;height:100%;position:absolute;top:0">
				<div style="box-sizing: border-box; padding-top: 0px; padding-bottom: 1479px; margin-top: 0px;">
					<div class="css-1bpmso0">
					 <div class="row">
						<c:forEach var="tdto" items="${product}" varStatus="loop">
					<c:if test="${loop.index % 4 == 0}">
                         <div class="column">
                    </c:if>
						<article class="css-ylurzg">
							<a href="/${tdto.proNum}/prodView"></a>
							<div class="css-bga0xs">
								<div class="css-pr93pi">
									<c:if test="${tdto.proToday eq currentDate}">
									<span class="css-ngoqre"></span>
									</c:if><!-- 타임나오는 곳 -->
										<!-- 스크랩 버튼 -->
										<sec:authorize access="hasAnyRole('ROLE_CLIENT')">
											<button class="production-item-image__scrap-badge" onclick="javascript:scrap('${prc.username}', '${dto.proNum}', ${dto.scrap ? 0 : 1})">
									     		<svg class="icon--stroke" aria-label="스크랩" width="24" height="24" fill="${dto.scrap ? '#50E5B4' : 'rgba(0, 0, 0, 0)'}" stroke="currentColor" stroke-width="0.5" viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet"><path d="M11.53 18.54l-8.06 4.31A1 1 0 0 1 2 21.97V3.5A1.5 1.5 0 0 1 3.5 2h17A1.5 1.5 0 0 1 22 3.5v18.47a1 1 0 0 1-1.47.88l-8.06-4.31a1 1 0 0 0-.94 0z"></path></svg>
											</button>
										</sec:authorize>
										<sec:authorize access="!hasAnyRole('ROLE_CLIENT')">
									      	<button class="production-item-image__scrap-badge" onclick="javascript:cantScrap()">
									     		<svg class="icon--stroke" aria-label="스크랩" width="24" height="24" fill="rgba(0, 0, 0, 0)" stroke="currentColor" stroke-width="0.5" viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet"><path d="M11.53 18.54l-8.06 4.31A1 1 0 0 1 2 21.97V3.5A1.5 1.5 0 0 1 3.5 2h17A1.5 1.5 0 0 1 22 3.5v18.47a1 1 0 0 1-1.47.88l-8.06-4.31a1 1 0 0 0-.94 0z"></path></svg>
											</button>	
										</sec:authorize>
									<div class="css-ypqde8">
										<img class="image" src="${tdto.proImg}" alt="상품 대표 이미지">
									</div>
									<div class="css-b2xyg5"></div>   
								</div>
							</div>
							<div class="product-info css-17wu10g">
								<div class="css-1r0yqr6">

										<span class="product-name css-11e7usa e1uchds84">
											<a href="/${tdto.proNum}/prodView">${tdto.proName}</a>
										</span>
							    </div>				      
							    <div class="price css-14q3hbk e96bn353">
							    	<span class="css-pzbnhz e96bn352">
							        	${tdto.proDiscountRate}
							        	<span class="percentage">%</span>
							        </span>
							        <span class="css-13aof0h e96bn351">
							        	<fmt:formatNumber value="${tdto.proPrice}" pattern="###,###"/> 원<br>
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
					<!-- 네 개씩 끊어서 처리하기 위한 조건 -->
                    <c:if test="${loop.index % 4 == 3 or loop.last}">
                       
                    </c:if>
					</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>     	
</div>
</body>
</html>
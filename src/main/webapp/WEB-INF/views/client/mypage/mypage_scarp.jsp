<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="mypage_top.jsp" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${path}/client/mypage_css/mypageScrap.css"/>
<link rel="stylesheet" href="${path}/resources/client/main_css/best.css"/>

<head>

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

	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<div data-element="Container" data-component="TodayDealsPage" data-source-file="index.page.tsx" class="css-mga9c9">                   
<h1 data-element="Title" data-source-file="index.page.tsx" class="css-7hbob3 e19k6sjk5" align="center">나의 스크랩 상품</h1>
</div>
 <div style="display: flex; flex-wrap: wrap; justify-content: center;" class="product-list-container">
    <c:forEach var="tdto" items="${myScrap}">
        <!-- 상품 하나를 감싸는 div에 너비와 마진을 설정 -->
    <div class="todays">


<article class="e19k6sjk0 css-ylurzg">    
   <div class="product-thumbnail css-bga0xs e192vfif5">
      		<!-- 스크랩 버튼 사진이 안 보여서 일단 이렇게 두고 나중에 옮겨도 무관 -->
			<sec:authorize access="hasAnyRole('ROLE_CLIENT')">
				<button class="production-item-image__scrap-badge" onclick="javascript:scrap('${prc.username}', '${tdto.proNum}', ${tdto.scrap ? 0 : 1})">
		     		<svg class="icon--stroke" aria-label="스크랩" width="24" height="24" fill="${scrapResult eq 'N' ? 'rgba(0, 0, 0, 0)' : '#50E5B4'}" stroke="currentColor" stroke-width="0.5" viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet"><path d="M11.53 18.54l-8.06 4.31A1 1 0 0 1 2 21.97V3.5A1.5 1.5 0 0 1 3.5 2h17A1.5 1.5 0 0 1 22 3.5v18.47a1 1 0 0 1-1.47.88l-8.06-4.31a1 1 0 0 0-.94 0z"></path></svg>
				</button>
			</sec:authorize>
        <div class="css-pr93pi e192vfif4">               
          <div class="css-ypqde8 e192vfif3">
      <a class="css-11ab5xd e1fm144d0" href="prodView_main.do?product_num=${tdto.proNum}&select=best">
        <span class="thumbnail-image e192vfif2 css-1t4i64"><a href="/${tdto.proNum}/prodView">${tdto.proName}</a>
            <img src="${upPath}/${tdto.proImg}" class="thumbnail-image e192vfif2 css-1l77jhx" alt=" ${tdto.proName}"/></a>
        </span>
     </a>
</div>
        
           <div class="css-b2xyg5 e192vfif1"></div>
       </div>
   </div>
  
   <div class="product-info css-17wu10g e1uchds87">
    
       <div class="css-1r0yqr6 e1uchds86">
         
           <div class="product-brand css-11vbb10 e1uchds85">$/{브랜드명}</div>
         
           <span class="product-name css-11e7usa e1uchds84"><a href="/${tdto.proNum}/prodView">${tdto.proName}</a></span>
       </div>
      
       <div class="price css-14q3hbk e96bn353">
          
           <span class="css-pzbnhz e96bn352">
              ${tdto.proDiscountRate}<span class="percentage">% </span>
           </span>
           
           <span class="css-13aof0h e96bn351">
               <fmt:formatNumber value="${tdto.proPrice}" pattern="###,###"/> 원<br>
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

     
       </div>
            
       </c:forEach>


       </div>
</body>
</html>
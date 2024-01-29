<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/client/main_css/mainStyle.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<%@ include file="top.jsp" %>
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
       $('.today-deal-item__timer').text(timeString);
   }
   
   getTimeRemaining();
   setInterval(getTimeRemaining, 1000);
   
   </script>

	
<div class="css-14td677">
	<div id="store-index">
		<div class="featured-carousel">
			<div role="region" aria-roledescription="carousel" class="css-bjn8wh e1tym1gd4">
				<div class="css-d3v9zr e1tym1gd3" style="/* touch-action: pan-y; *//* user-select: none; *//* -webkit-user-drag: none; *//* -webkit-tap-highlight-color: rgba(0, 0, 0, 0); */">
					<ul style="transform: translateX(0%);" aria-live="off" class="css-154jlx0 e1tym1gd2">
						<li role="group" aria-roledescription="slide" aria-label="14 of 15" class="css-l4nyle e1tym1gd1">
							<a href="resources/merchant/img/오늘 입점하세요.png">
								<div class="css-19xf83k e1gf1fv81">
									<div class="css-1brvou9 e1gf1fv80">
										<div class="css-1qd6flo epd1vhg3">
											<img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/store/banners/store_home_banners/170505659818591349.png?w=1920" srcset="https://image.ohou.se/i/bucketplace-v2-development/uploads/store/banners/store_home_banners/170505659818591349.png?w=2880 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/store/banners/store_home_banners/170505659818591349.png?w=3840 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/store/banners/store_home_banners/170505659818591349.png?w=5760 3x" class="css-1jjjg2j">
										</div>
									</div>
								</div>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="css-1obbfpy"><!-- 블로그 -->
		<div class="css-14vj981">
			<div class="css-dlv2hg">
				<div class="css-147wp72">
					<strong class="css-1d0kvw3">이런 사진 찾고있나요?</strong>
				</div>
				<div class="css-1b0htg7">
					<span class="css-1384ga9">좋아하실 만한 인테리어 콘텐츠를 추천해드려요</span>
				</div>	
			</div>
			<div class="css-7z0c8w">
				<button type="button" onclick="blog_main()" class="css-av2k9l">더보기</button>
			</div>
		</div>
		<div class="css-gkfaqp">
			<div class="css-bjn8wh">
				<div class="css-3q4ecs">
					<ul class="css-5n3mug">
						<c:forEach var="blog_dto" items="${blog_list}" varStatus="loop">
						<li class="css-3qi6pg">
							<div class="css-fyyvpx">
								<div class="css-v414oq">
									<img src="data:image/jpeg;base64,${blog_encodedImages[loop.index]}" alt="블로그 이미지" class="css-gnpvt2"/>
									<div class="css-bkonhm">
										<div class="css-s5xdrg">
											<div class="css-7nmw3w">
											<c:choose>
										        <c:when test="${not empty member_encodedImages[loop.index]}">
										        	<img src="data:image/jpeg;base64,${member_encodedImages[loop.index]}" alt="회원 이미지" class="css-1auwp8u"><!-- 회원 이미지 -->
										        </c:when>
										        <c:otherwise>
										            <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/default_images/avatar.png?gif=1&amp;w=144&amp;h=144&amp;c=c&amp;webp=1" class="css-1auwp8u" alt="User Avatar">
										        </c:otherwise>
										    </c:choose>
											</div>
											<span class="css-ihb3jd">${blog_dto.member_id}</span>
										</div>
									</div>
									<div class="css-10pwgp9">
										<button type="button" class="css-pyrw9g" onclick="${scrapResult eq 'Y' ? 'unscrap()' : 'scrap()'}">
											<span class="css-5dnyrm">
												<svg class="css-q7lffx" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" clip-rule="evenodd" d="M20 2.75H4C3.44772 2.75 3 3.19771 3 3.75V20.8228C3 21.1988 3.39948 21.4403 3.73242 21.2655L11.5352 17.169C11.8262 17.0162 12.1738 17.0162 12.4648 17.169L20.2676 21.2655C20.6005 21.4403 21 21.1988 21 20.8228V3.75C21 3.19772 20.5523 2.75 20 2.75Z" fill="#35C5F0"></path></svg>
											</span>
										</button>
									</div>
								</div>
								<a class="css-11ab5xd" href="blog_get.do?num=${blog_dto.blog_num}"></a>
							</div>
						</li>
						</c:forEach>
					</ul>
				</div>

			</div>
		</div>
	</div><!-- 블로그 -->
	<c:set var="currentDate" value='<%= new SimpleDateFormat("yy/MM/dd").format(new Date())%>' />
	<div class="css-1obbfpy"><!-- 오늘의 딜 -->
		<div class="css-14vj981">
			<div class="css-dlv2hg">
				<div class="css-147wp72">
					<strong class="css-1d0kvw3">오늘의 딜</strong>
				</div>
			</div>
			<div class="css-7z0c8w">
				<button type="button" onclick="todaysDeal()" class="css-av2k9l">더보기</button>
			</div>
		</div>
		<div class="css-gkfaqp">
			<div class="css-bjn8wh">
				<div class="css-3q4ecs">
					<ul class="css-5n3mug">
						<c:forEach var="product_dto" items="${list_todays}" varStatus="loop">
						<li class="css-3kqc0z">
							<div class="css-g9s5pw">
								<article class="today-deal-item">
									<a class="today-deal-item__overlay" href="prodView_main.do?num=${product_dto.product_num}"></a>
									<div class="today-deal-item__image">
										<div class="today-deal-item__image__item">
											<div class="production-item-image">
												<img class="image" src="data:image/jpeg;base64,${todayProduct_encodedImages[loop.index]}" alt="상품 대표 이미지">
												<button class="production-item-image__scrap-badge">
													<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" class="inactive-icon">
														<defs>
															<path id="scrap-icon-1-b" d="M12.472 6.93l7.056-3.811A1 1 0 0 1 21 4.002v15.496c0 .83-.672 1.502-1.5 1.502h-15c-.828 0-1.5-.673-1.5-1.502V4.002a1 1 0 0 1 1.472-.883l7.056 3.811a.999.999 0 0 0 .944 0z"></path>
															<filter id="scrap-icon-1-a" width="150%" height="150%" x="-25%" y="-25%" filterUnits="objectBoundingBox">
																<feOffset in="SourceAlpha" result="shadowOffsetOuter1"></feOffset>
																<feGaussianBlur in="shadowOffsetOuter1" result="shadowBlurOuter1" stdDeviation="1.5"></feGaussianBlur>
																<feComposite in="shadowBlurOuter1" in2="SourceAlpha" operator="out" result="shadowBlurOuter1"></feComposite>
																<feColorMatrix in="shadowBlurOuter1" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.26 0"></feColorMatrix>
															</filter>
															<filter id="scrap-icon-1-c" width="150%" height="150%" x="-25%" y="-25%" filterUnits="objectBoundingBox">
																<feGaussianBlur in="SourceAlpha" result="shadowBlurInner1" stdDeviation="1.5"></feGaussianBlur>
																<feOffset in="shadowBlurInner1" result="shadowOffsetInner1"></feOffset>
																<feComposite in="shadowOffsetInner1" in2="SourceAlpha" k2="-1" k3="1" operator="arithmetic" result="shadowInnerInner1"></feComposite>
																<feColorMatrix in="shadowInnerInner1" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.2 0"></feColorMatrix>
															</filter>
														</defs>
														<g fill="none" fill-rule="nonzero" transform="matrix(1 0 0 -1 0 24)">
															<use fill="#000" filter="url(#scrap-icon-1-a)" href="#scrap-icon-1-b"></use>
															<use fill="#FFF" fill-opacity=".4" href="#scrap-icon-1-b"></use>
															<use fill="#000" filter="url(#scrap-icon-1-c)" href="#scrap-icon-1-b"></use>
															<path stroke="#FFF" d="M12.71 7.37h-.002a1.5 1.5 0 0 1-1.417 0L4.236 3.56a.499.499 0 0 0-.736.442v15.496c0 .553.448 1.002 1 1.002h15c.552 0 1-.449 1-1.002V4.002a.499.499 0 0 0-.734-.443l-7.057 3.81zm-.475-.88h-.001z"></path>
														</g>
													</svg>
													<svg class="active-icon" width="24" height="24" viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet">
														<path fill="#35C5F0" fill-rule="nonzero" d="M12.472 17.07a.999.999 0 0 0-.944 0l-7.056 3.811A.999.999 0 0 1 3 19.998V4.502C3 3.672 3.672 3 4.5 3h15c.828 0 1.5.673 1.5 1.502v15.496a1 1 0 0 1-1.472.883l-7.056-3.811z"></path>
													</svg>
												</button>
												<div class="production-item-image__dark-overlay"></div>
												<c:if test="${product_dto.product_today eq currentDate}">
													<span class="today-deal-item__timer"></span>
												</c:if><!-- 타임나오는 곳 -->
											</div><!-- production-item-image -->
											<div class="today-deal-item__content">
												<div class="today-deal-item__content--wrap">
													<h1 class="today-deal-item__header">
														<span class="today-deal-item__header__brand">브랜드명</span>
														<span class="today-deal-item__header__name">${product_dto.product_name}</span>
													</h1>
													<span class="production-item-price">
														<span class="production-item-price__rate">
															${product_dto.product_discount_rate}
															<span class="percentage">% </span>
														</span>
														<span class="production-item-price__price">
															${product_dto.product_price}
														</span>
													</span>
													<div class="today-deal-item__stats-pc">
														<p class="production-item-stats production-item-stats--review">
															<svg class="icon" width="24" height="24" viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet">
																<path fill="currentColor" fill-rule="evenodd" d="M12 19.72l-5.677 2.405c-.76.322-1.318-.094-1.247-.906l.533-6.142-4.042-4.656c-.54-.624-.317-1.283.477-1.467l6.006-1.39L11.23 2.28c.426-.707 1.122-.699 1.542 0l3.179 5.282 6.006 1.391c.805.187 1.011.851.477 1.467l-4.042 4.656.533 6.142c.072.822-.497 1.224-1.247.906L12 19.72z"></path>
															</svg>
															<strong class="avg">별점 평균</strong>
															리뷰 num
														</p>
													</div>
												</div>
											</div><!-- today-deal-item__content -->
										</div>
									</div>
								</article>
							</div>
						</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
		<div class="css-1obbfpy"><!-- 오늘의 딜 -->
		<div class="css-14vj981">
			<div class="css-dlv2hg">
				<div class="css-147wp72">
					<strong class="css-1d0kvw3">모든 상품</strong>
				</div>
			</div>
			<div class="css-7z0c8w">
				<button type="button" onclick="goProduct()" class="css-av2k9l">더보기</button>
			</div>
		</div>
		<div class="css-gkfaqp">
			<div class="css-bjn8wh">
				<div class="css-3q4ecs">
					<ul class="css-5n3mug">
						<c:set var="currentDate" value='<%= new SimpleDateFormat("yy/MM/dd").format(new Date())%>' />
						<c:forEach var="dto" items="${listProduct}" varStatus="loop">
						<li class="css-3kqc0z">
							<div class="css-g9s5pw">
								<article class="today-deal-item">
									<a class="today-deal-item__overlay" href="prodView_main.do?num=${dto.product_num}"></a>
									<div class="today-deal-item__image">
										<div class="today-deal-item__image__item">
											<div class="production-item-image">
												<img class="image" src="data:image/jpeg;base64,${encodedImages[loop.index]}" alt="상품 대표 이미지">
												<button class="production-item-image__scrap-badge">
													<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" class="inactive-icon">
														<defs>
															<path id="scrap-icon-1-b" d="M12.472 6.93l7.056-3.811A1 1 0 0 1 21 4.002v15.496c0 .83-.672 1.502-1.5 1.502h-15c-.828 0-1.5-.673-1.5-1.502V4.002a1 1 0 0 1 1.472-.883l7.056 3.811a.999.999 0 0 0 .944 0z"></path>
															<filter id="scrap-icon-1-a" width="150%" height="150%" x="-25%" y="-25%" filterUnits="objectBoundingBox">
																<feOffset in="SourceAlpha" result="shadowOffsetOuter1"></feOffset>
																<feGaussianBlur in="shadowOffsetOuter1" result="shadowBlurOuter1" stdDeviation="1.5"></feGaussianBlur>
																<feComposite in="shadowBlurOuter1" in2="SourceAlpha" operator="out" result="shadowBlurOuter1"></feComposite>
																<feColorMatrix in="shadowBlurOuter1" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.26 0"></feColorMatrix>
															</filter>
															<filter id="scrap-icon-1-c" width="150%" height="150%" x="-25%" y="-25%" filterUnits="objectBoundingBox">
																<feGaussianBlur in="SourceAlpha" result="shadowBlurInner1" stdDeviation="1.5"></feGaussianBlur>
																<feOffset in="shadowBlurInner1" result="shadowOffsetInner1"></feOffset>
																<feComposite in="shadowOffsetInner1" in2="SourceAlpha" k2="-1" k3="1" operator="arithmetic" result="shadowInnerInner1"></feComposite>
																<feColorMatrix in="shadowInnerInner1" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.2 0"></feColorMatrix>
															</filter>
														</defs>
														<g fill="none" fill-rule="nonzero" transform="matrix(1 0 0 -1 0 24)">
															<use fill="#000" filter="url(#scrap-icon-1-a)" href="#scrap-icon-1-b"></use>
															<use fill="#FFF" fill-opacity=".4" href="#scrap-icon-1-b"></use>
															<use fill="#000" filter="url(#scrap-icon-1-c)" href="#scrap-icon-1-b"></use>
															<path stroke="#FFF" d="M12.71 7.37h-.002a1.5 1.5 0 0 1-1.417 0L4.236 3.56a.499.499 0 0 0-.736.442v15.496c0 .553.448 1.002 1 1.002h15c.552 0 1-.449 1-1.002V4.002a.499.499 0 0 0-.734-.443l-7.057 3.81zm-.475-.88h-.001z"></path>
														</g>
													</svg>
													<svg class="active-icon" width="24" height="24" viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet">
														<path fill="#35C5F0" fill-rule="nonzero" d="M12.472 17.07a.999.999 0 0 0-.944 0l-7.056 3.811A.999.999 0 0 1 3 19.998V4.502C3 3.672 3.672 3 4.5 3h15c.828 0 1.5.673 1.5 1.502v15.496a1 1 0 0 1-1.472.883l-7.056-3.811z"></path>
													</svg>
												</button>
												<div class="production-item-image__dark-overlay"></div>
												
												<c:if test="${dto.product_today eq currentDate}">
													<span class="today-deal-item__timer"></span>
												</c:if><!-- 타임나오는 곳 -->
												
											</div><!-- production-item-image -->
											<div class="today-deal-item__content">
												<div class="today-deal-item__content--wrap">
													<h1 class="today-deal-item__header">
														<span class="today-deal-item__header__brand">브랜드명</span>
														<span class="today-deal-item__header__name">${dto.product_name}</span>
													</h1>
													<span class="production-item-price">
														<span class="production-item-price__rate">
															${dto.product_discount_rate}
															<span class="percentage">% </span>
														</span>
														<span class="production-item-price__price">
															${dto.product_price}
														</span>
													</span>
													<div class="today-deal-item__stats-pc">
														<p class="production-item-stats production-item-stats--review">
															<svg class="icon" width="24" height="24" viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet">
																<path fill="currentColor" fill-rule="evenodd" d="M12 19.72l-5.677 2.405c-.76.322-1.318-.094-1.247-.906l.533-6.142-4.042-4.656c-.54-.624-.317-1.283.477-1.467l6.006-1.39L11.23 2.28c.426-.707 1.122-.699 1.542 0l3.179 5.282 6.006 1.391c.805.187 1.011.851.477 1.467l-4.042 4.656.533 6.142c.072.822-.497 1.224-1.247.906L12 19.72z"></path>
															</svg>
															<strong class="avg">별점 평균</strong>
															리뷰 num
														</p>
													</div>
												</div>
											</div><!-- today-deal-item__content -->
										</div>
									</div>
								</article>
							</div>
						</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
function showNextProducts() {
    // ul 엘리먼트
    var productListUl = document.querySelector('.css-5n3mug');
    
    // 각 상품 엘리먼트의 너비 가져오기
    var productWidth = document.querySelector('.css-3kqc0z').offsetWidth;
    
    // 현재 transform 값 가져오기
    var currentTransform = window.getComputedStyle(productListUl).transform;
    
    // 현재 이동한 거리 계산
    var currentTranslateX = new WebKitCSSMatrix(currentTransform).m41;
    
    // 다음 상품 4개만큼 이동
    productListUl.style.transform = 'translateX(' + (currentTranslateX - productWidth) + 'px)';
}

// 다음 버튼 클릭 시 showNextProducts 함수 호출
document.querySelector('.css-h72v4d button').addEventListener('click', showNextProducts);
</script>
<script>
  // goProduct 함수 정의
  function blog_main() {
    // prodView_main.do 실행
    window.location.href = 'blog_main.do';
  }
  
  function todaysDeal() {
	    // prodView_main.do 실행
	  window.location.href = 'best_main.do?spec=today';
	  }
  
  function goProduct() {
	    // prodView_main.do 실행
	    window.location.href = 'shop_main.do';
	  }
</script>
<%@ include file="bottom.jsp" %>
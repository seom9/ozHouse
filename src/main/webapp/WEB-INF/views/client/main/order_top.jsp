<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="preload" href="https://assets.ohou.se/store/_next/static/css/6be64f3fe2ed3d98.css" as="style"/>
        <link rel="stylesheet" href="https://assets.ohou.se/store/_next/static/css/6be64f3fe2ed3d98.css" data-n-p=""/>
        <noscript data-n-css=""></noscript>
        <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700&display=swap&subset=korean" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/webapp/js/176-cfa6db3a70d47987bf62.chunk.js"></script>
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/253-2a70f4dd.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/63-6f2dfeb3.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/69-a93aa4d8.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/76-44347cd6.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/176-c170165a.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/9-c0cd5c94.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/10-be34fdde.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/45-455aca93.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/62-17c52af2.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/254-2a70f4dd.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/64-6f2dfeb3.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/70-a93aa4d8.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/77-44347cd6.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/177-c170165a.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/6-fa88b322.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/9-c0cd5c94.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/10-be34fdde.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/11-e76ccd97.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/12-122a7274.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/13-70cf3ee0.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/46-455aca93.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/72-975b0143.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/94-7181da44.chunk.css">
        <link rel="stylesheet" href="https://assets.ohou.se/web/dist/css/91-236397d7.chunk.css">
       	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/topStyle_a.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Cart.css"/> 
       
        <style data-emotion="css-global ala7f8">
			@import "https://assets.ohou.se/design-system/bbf3fca1e650ee6d.css";
			@import "https://assets.ohou.se/fonts/pretendard/v1.3.8/pretendardvariable-dynamic-subset.css";
			@font-face {
            	font-family: OhouseIcon;
                src: url(https://assets.ohou.se/design-system/3298ed52addbc709.eot);
                src: url(https://assets.ohou.se/design-system/3298ed52addbc709.eot#iefix) format("embedded-opentype"),url(https://assets.ohou.se/design-system/d8923b386a66fd50.woff2) format("woff2"),url(https://assets.ohou.se/design-system/9e79341d6a2fe0d2.woff) format("woff"),url(https://assets.ohou.se/design-system/5355f736e6a7bc5b.ttf) format("truetype"),url(https://assets.ohou.se/design-system/3ba7913eab100858.svg#OhouseIcon) format("svg");
            }
		</style>
		<script type="text/javascript">
			function toggleDropdown() {
			    var dropdownContent = document.querySelector('.dropdown-content');
			    dropdownContent.style.display = (dropdownContent.style.display === 'block') ? 'none' : 'block';
			}
		</script>
    </head>
<header>
	<div class="sticky-container">
		<div class="css-i7a8i3 e6rqo2c5">
			<div class="e6rqo2c4 css-1mfjm4o">
				<div class="css-55rg8t e6rqo2c3">
					<button type="button" class="css-osmvbo e11i9eav0">
				        <span class="_menu_24 css-cwcsvq"></span>
				    </button>
				</div>
				<div class="css-18i0nar e6rqo2c2"></div>
				<div class="css-1euxu4r e6rqo2c1">
					<a class="css-1qwerc" href="Main.do">
						<span class="css-18nk785">OZ의집</span>
					</a>	     
					<a class="css-53vhmk" href="Category_main.do">
					    <span class="css-18nk785">카테고리</span>
					</a>
				    <a class="css-53vhmk" href="Best_main.do?spec=best">
				        <span class="css-18nk785">베스트</span> </a>
				    <a class="css-53vhmk" href="Best_main.do">
				        <span class="css-18nk785">블로그</span> </a>
				    <a class="css-53vhmk" href="Best_main.do?spec=today">
				        <span class="css-18nk785">오늘의 딜</span>
				    </a>
				</div>
				<div class="css-1i4309w e6rqo2c0">
					<div class="css-10vibjk">
						<div class="css-1o64euu">
							<div id="global-search-combobox" role="combobox" aria-expanded="false" aria-haspopup="listbox" class="css-7whenc">
								<div class="css-1yhxgcl">
									<span class="_search_24 css-hkiqzb"></span>
									<input type="text" value="" placeholder="통합검색" autoComplete="off" aria-autocomplete="list" class="css-1pneado ej5pc7c2"/>
						            <div class="css-s5xdrg"></div>
						    	</div>
							</div>
						</div>
						<div class="css-t6whf">
						    <button type="button" class="css-1bi2id">
						        <span class="_search_24 css-cwcsvq"></span>
						    </button>
						</div>
						<div class="css-1qmvf9l">
						<a aria-label="스크랩북 페이지 링크 버튼" class="css-ym6lm7" href="CartList_main.do">
						
						        <span class="_scrap_outline_24 css-17vaqfq"></span>
						    </a>
						</div>
						<div class="css-ff3m79">
						    <a aria-label="내소식 페이지 링크 버튼" class="css-ym6lm7" href="/notifications/feed">
						        <span class="_notification_outline_24 css-17vaqfq"></span>
						    </a>
						</div>
							<a aria-label="장바구니 페이지 링크 버튼" class="css-ym6lm7" href="CartList_main.do">
							    <span class="_cart_24 css-17vaqfq"></span>
							</a>

						<div class="css-1f624s9">
							<div class="css-1kpxvh4">
								<c:if test="${empty sessionScope.loginMember}">
								<a class="css-1g5o6hv" href="member_login.do">로그인</a>
								<a class="css-1g5o6hv" href="member_join.do">회원가입</a>
							    <a class="css-1tlac5g" href="/customer_center">고객센터</a>
							    </c:if>
							    <c:if test="${not empty sessionScope.loginMember}">
								<a class="css-1g5o6hv" href="member_logout.do">로그아웃</a>
								<a class="css-1g5o6hv" href="mypage_profile.do">마이페이지</a>
							    <a class="css-1tlac5g" href="/customer_center">고객센터</a>
							    </c:if>
							</div>
	             			<div class="dropDown">
	             				<button class="dropDownButton" onclick="toggleDropdown()">
	             					<span class="css-cdruys">글쓰기</span>
		             				<div class="_chevron_down_18 css-ae93ov"></div>
		             				<div class="dropdown-content">
							            <a href="blog_write.do?mode=photo">사진/동영상 올리기</a>
							            <a href="#">상품 리뷰 쓰기</a>
							        </div>
	             				</button>            				
	             			</div>
             			</div>
					</div>
				</div>
			</div><!-- 세번째 div -->
		</div><!-- 두번째 div -->
		
		<div class="css-1yqrra9">
			<div class="css-1702gi6 ez4mxhy0">
				<div class="css-2qd0l8 e1387oiq2">
				    <a href="/store?affect_type=Home&amp;affect_id=0">
						<img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167262690767101882.png?w=256" srcSet="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167262690767101882.png?w=384 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167262690767101882.png?w=512 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167262690767101882.png?w=768 3x" class="e1387oiq1 css-h8ff20"/>
					    <span class="css-xd55zv e1387oiq0">쇼핑하기</span>
				    </a>
				</div>
		        <div class="css-2qd0l8 e1387oiq2">
		            <a href="/store/category?category_id=35000000&amp;affect_type=Home&amp;affect_id=0">
		                <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/170164664361004065.png?w=256" srcSet="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/170164664361004065.png?w=384 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/170164664361004065.png?w=512 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/170164664361004065.png?w=768 3x" class="e1387oiq1 css-h8ff20"/>
		                <span class="css-xd55zv e1387oiq0">원하는걸로</span>
		            </a>
		        </div>
		        <div class="css-2qd0l8 e1387oiq2">
		            <a href="https://store.ohou.se/today_deals?affect_type=Home&amp;affect_id=0">
		                <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198007152582471.png?w=256" srcSet="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198007152582471.png?w=384 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198007152582471.png?w=512 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198007152582471.png?w=768 3x" class="e1387oiq1 css-h8ff20"/>
		                <span class="css-xd55zv e1387oiq0">오늘의딜</span>
		            </a>
		        </div>
		        <div class="css-2qd0l8 e1387oiq2">
		            <a href="https://contents.ohou.se/topics/recommend?affect_type=Home&amp;affect_id=0">
		                <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/169655628839725014.png?w=256" srcSet="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/169655628839725014.png?w=384 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/169655628839725014.png?w=512 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/169655628839725014.png?w=768 3x" class="e1387oiq1 css-h8ff20"/>
		                <span class="css-xd55zv e1387oiq0">변경가능</span>
		            </a>
		        </div>
		        <div class="css-2qd0l8 e1387oiq2">
		            <a href="/competitions/1002?affect_type=Home&amp;affect_id=0">
		                <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/170184318298899959.png?w=256" srcSet="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/170184318298899959.png?w=384 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/170184318298899959.png?w=512 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/170184318298899959.png?w=768 3x" class="e1387oiq1 css-h8ff20"/>
		                <span class="css-xd55zv e1387oiq0">이미지도</span>
		            </a>
		        </div>
		        <div class="css-2qd0l8 e1387oiq2">
		            <a href="/projects?writer=self&amp;affect_type=Home&amp;affect_id=0">
		                <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198010271968429.png?w=256" srcSet="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198010271968429.png?w=384 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198010271968429.png?w=512 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198010271968429.png?w=768 3x" class="e1387oiq1 css-h8ff20"/>
		                <span class="css-xd55zv e1387oiq0">추천받음</span>
		            </a>
		        </div>
		        <div class="css-2qd0l8 e1387oiq2">
		            <a href="https://contents.ohou.se/topics/living?affect_type=Home&amp;affect_id=0">
		                <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/169880736853477508.png?w=256" srcSet="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/169880736853477508.png?w=384 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/169880736853477508.png?w=512 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/169880736853477508.png?w=768 3x" class="e1387oiq1 css-h8ff20"/>
		                <span class="css-xd55zv e1387oiq0">여기다가</span>
		            </a>
		        </div>
		        <div class="css-2qd0l8 e1387oiq2">
		            <a href="/exhibitions/10017?affect_type=Home&amp;affect_id=0">
		                <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198012024333402.png?w=256" srcSet="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198012024333402.png?w=384 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198012024333402.png?w=512 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198012024333402.png?w=768 3x" class="e1387oiq1 css-h8ff20"/>
		                <span class="css-xd55zv e1387oiq0">빠른배송</span>
		            </a>
		        </div>
		        <div class="css-2qd0l8 e1387oiq2">
		            <a href="/experts/v2/pre_consultations/new?expertise=5&amp;affect_type=HomeShortcut&amp;affect_type=Home&amp;affect_id=0">
		                <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198022841390557.png?w=256" srcSet="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198022841390557.png?w=384 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198022841390557.png?w=512 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198022841390557.png?w=768 3x" class="e1387oiq1 css-h8ff20"/>
		                <span class="css-xd55zv e1387oiq0">뭐넣을지</span>
		            </a>
		        </div>
		        <div class="css-2qd0l8 e1387oiq2">
		            <a href="/experts/moving?affect_type=Home&amp;affect_id=0">
		                <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198021046015480.png?w=256" srcSet="https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198021046015480.png?w=384 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198021046015480.png?w=512 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/shortcut/home_feed_shortcut_sets/167198021046015480.png?w=768 3x" class="e1387oiq1 css-h8ff20"/>
		                <span class="css-xd55zv e1387oiq0">추천바람</span>
		            </a>
		        </div>
			</div><!-- 세번째 div -->
		</div><!-- 두번째 div -->      
	</div><!-- 첫번째 div -->   
</header>
<body>
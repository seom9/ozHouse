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
       	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/client/main_css/topStyle.css"/>
       
        <style data-emotion="css-global ala7f8">
			@import "https://assets.ohou.se/design-system/bbf3fca1e650ee6d.css";
			@import "https://assets.ohou.se/fonts/pretendard/v1.3.8/pretendardvariable-dynamic-subset.css";
			@font-face {
            	font-family: OhouseIcon;
                src: url(https://assets.ohou.se/design-system/3298ed52addbc709.eot);
                src: url(https://assets.ohou.se/design-system/3298ed52addbc709.eot#iefix) format("embedded-opentype"),url(https://assets.ohou.se/design-system/d8923b386a66fd50.woff2) format("woff2"),url(https://assets.ohou.se/design-system/9e79341d6a2fe0d2.woff) format("woff"),url(https://assets.ohou.se/design-system/5355f736e6a7bc5b.ttf) format("truetype"),url(https://assets.ohou.se/design-system/3ba7913eab100858.svg#OhouseIcon) format("svg");
            }
		</style>
		<script>
		    function toggleDropdown() {
		        var dropdown = document.querySelector('.placement-bottom');
		        dropdown.style.display = (dropdown.style.display === 'none' || dropdown.style.display === '') ? 'block' : 'none';
		    }
		</script>
		<script>
			function mypage_scrap(){
				var isLogin = ${loginMember != null};
				
			    if (!isLogin) {
			    	alert("로그인이 필요합니다. 로그인 페이지로 이동합니다.");
			        window.location.href = 'member_login.do';
			        return;
			    } else {
			    	window.location.href = 'mypage_scrapbook.do';
			    }
			}
			
			function mypage_cart(){
				var isLogin = ${loginMember != null};
				
			    if (!isLogin) {
			    	alert("로그인이 필요합니다. 로그인 페이지로 이동합니다.");
			        window.location.href = 'member_login.do';
			        return;
			    } else {
			    	window.location.href = 'CartList_main.do';
			    }
			}
		</script>
    </head>
<body>
	<header>
		<div class="sticky-container" style="position: fixed; z-index: 1102; transition: top 0.1s ease 0s; top: 0px; width: 1512.75px;">
			<div class="css-i7a8i3">
				<div class="css-1mfjm4o">
					<div class="css-1euxu4r">
						<a class="css-1qwerc" href="main.do">
							<span class="css-18nk785">OZ의집</span>
						</a>	     
						<a class="css-53vhmk" href="shop_main.do">
						    <span class="css-18nk785">쇼핑</span>
						</a>
					    <a class="css-53vhmk" href="best_main.do?spec=best">
					        <span class="css-18nk785">베스트</span>
					    </a>
					    <a class="css-53vhmk" href="blog_main.do">
					        <span class="css-18nk785">블로그</span>
					    </a>
					    <a class="css-53vhmk" href="best_main.do?spec=today">
					        <span class="css-18nk785">오늘의 딜</span>
					    </a>
					</div>
					<div class="css-1i4309w">
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
							<a aria-label="스크랩북 페이지 링크 버튼" class="css-ym6lm7" onclick="mypage_scrap(event)">
							        <span class="_scrap_outline_24 css-17vaqfq"></span>
							    </a>
							</div>
								<a aria-label="장바구니 페이지 링크 버튼" class="css-ym6lm7" onclick="mypage_cart(event)">
								    <span class="_cart_24 css-17vaqfq"></span>
								</a>
							<div class="css-1f624s9">
								<div class="css-1kpxvh4">
									<c:if test="${empty sessionScope.loginMember}">
									<a class="css-1g5o6hv" href="member_login.do">로그인</a>
									<a class="css-1g5o6hv" href="member_join.do">회원가입</a>
								    <a class="css-1tlac5g" href="merchant_main.do">판매자센터</a>
								    </c:if>
								    <c:if test="${not empty sessionScope.loginMember}">
									<a class="css-1g5o6hv" href="member_logout.do">로그아웃</a>
									<a class="css-1g5o6hv" href="mypage_profile.do">마이페이지</a>
								    <a class="css-1tlac5g" href="merchant_main.do">판매자센터</a>
								    </c:if>
								</div>
		             			<span class="css-1amee4m">
		             				<button class="css-qnc3fr" onclick="toggleDropdown()">
		             					<span class="css-cdruys">글쓰기</span>
 		             					<div class="placement-bottom css-kqp0ar open open-active" style="display: none; position: absolute; inset: 0px auto auto 0px; transform: translate3d(986.4px, 70.4px, 0px);">
		             						<div class="popper-item css-y2j1wi">
		             							<a class="css-1abjig3" href="blog_write.do?mode=photo">
		             								<div class="css-bjn8wh">
		             									<svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="none">
		             										<rect width="27" height="29" x="6.54" y="3.59" fill="#DBDBDB" stroke="#000" stroke-linejoin="round" rx="2.5" transform="rotate(4 6.54 3.6)"></rect>
		             										<rect width="27" height="29" x="2.5" y="1.5" fill="#fff" stroke="#000" stroke-linejoin="round" rx="2.5"></rect>
		             										<rect width="22" height="22" x="5" y="4" fill="#FFE2C7" rx="1"></rect>
		             										<path fill="#fff" fill-rule="evenodd" d="m14 7 5 .45v3.5l-5-.45V7zm0 4.5V15l5 .45v-3.5l-5-.45zm6 .55v3.5l5 .45v-3.5l-5-.45zm5-.55V8l-5-.45v3.5l5 .45z" clip-rule="evenodd"></path>
		             										<path fill="#E6A87C" fill-rule="evenodd" d="m5 19 22 2v7L5 26v-7z" clip-rule="evenodd"></path>
		             										<path fill="#F1C8A3" fill-rule="evenodd" d="M5 3.45h5v16l-5 4v-20z" clip-rule="evenodd"></path>
		             									</svg>
		             								</div>
		             								<div class="css-1qhmto6">
		             									<div class="css-1w2j28v">사진/동영상 올리기</div>
		             									<div class="css-n1vjup">우리 집의 공간과 나의 일상을 기록해 보세요.</div>
		             								</div>
		             							</a>
		             							<a class="css-1abjig3" href="/production_reviews/write">
		             								<div class="css-bjn8wh">
		             									<svg xmlns="http://www.w3.org/2000/svg" width="36" height="36">
		             										<g fill="none" fill-rule="evenodd">
		             											<path d="M0 0h36v36H0z"></path>
		             											<g stroke-linejoin="round" transform="translate(2 3)">
		             											<rect width="4" height="8" x="3" y="21" fill="#FFB787" stroke="#000" rx="2"></rect>
		             											<rect width="24" height="25" fill="#FFE2C7" rx="3"></rect>
		             											<rect width="24" height="25" fill="#ffe2c7" rx="3"></rect>
		             											<rect width="24" height="25" stroke="#000" stroke-width="1.2" rx="3"></rect>
		             											<rect width="6" height="3" x="9" y="5" fill="#DB9F77" stroke="#FFF" rx="1.5"></rect>
		             											<rect width="6" height="3" x="9" y="17" fill="#DB9F77" stroke="#FFF" rx="1.5"></rect>
		             											<path fill="#FFDB92" stroke="#EDC29B" d="M1.5 12.5h21"></path>
		             											</g>
		             											<path fill="#35C5F0" d="m26.25 31.53-3.7 1.32a1 1 0 0 1-1.34-.97l.1-3.93a.99.99 0 0 0-.2-.64l-2.4-3.11a1 1 0 0 1 .51-1.57l3.77-1.12a1 1 0 0 0 .55-.39l2.22-3.24a1 1 0 0 1 1.65 0l2.22 3.24a1 1 0 0 0 .55.4l3.77 1.1a1 1 0 0 1 .5 1.58l-2.4 3.11a1 1 0 0 0-.2.64l.11 3.93a1 1 0 0 1-1.33.97l-3.71-1.32a1 1 0 0 0-.67 0z"></path>
		             											<path fill="#9AE2F7" d="M27.15 17.61a1 1 0 0 1 .26.26l2.22 3.25c.06.09.13.16.22.23l-8.59 8.58.06-1.98a.99.99 0 0 0-.21-.64l-2.4-3.11a1 1 0 0 1 .51-1.57l3.77-1.12a1 1 0 0 0 .55-.39l2.22-3.24a1 1 0 0 1 1.39-.26z"></path>
		             											<path stroke="#000" stroke-width="1.2" d="m26.29 30.85-3.31 1.17a.9.9 0 0 1-1.2-.86l.1-3.51c0-.2-.06-.4-.18-.57l-2.14-2.78a.9.9 0 0 1 .45-1.4l3.37-.99a.9.9 0 0 0 .48-.35l1.99-2.9a.9.9 0 0 1 1.47 0l1.99 2.9c.11.17.28.3.48.35l3.37 1a.9.9 0 0 1 .45 1.4l-2.14 2.77a.89.89 0 0 0-.18.57l.1 3.5a.9.9 0 0 1-1.2.87l-3.3-1.17a.9.9 0 0 0-.6 0z"></path>
		             										</g>
		             									</svg>
		             								</div>
		             								<div class="css-1qhmto6">
		             									<div class="css-1w2j28v">상품 리뷰 쓰기</div>
		             									<div class="css-n1vjup">주문한 상품의 리뷰를 작성해보세요.</div>
		             								</div>
		             							</a>
		             						</div>
		             					</div>
		             				</button>            				
		             			</span>
	             			</div>
						</div>
					</div>
				</div>
			</div> 
		</div>
	</header>
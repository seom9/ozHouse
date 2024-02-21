<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<%@ include file="../main/top.jsp" %>

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
       	<link rel="stylesheet" href="${path}/client/main_css/topStyle.css"/>
       	<link rel="stylesheet" href="${path}/mypage.css"/>
       
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
        // 전역 변수로 현재 활성화된 서브메뉴를 추적
        let activeSubMenu = null;

        function toggleSubMenu(parentElement) {
            const subMenu = parentElement.querySelector('.page-navigation__sub-menu');

            // 현재 클릭한 메뉴가 이미 활성화되어 있으면 숨기기
            if (subMenu === activeSubMenu) {
                subMenu.classList.remove('active');
                activeSubMenu = null;
            } else {
                // 다른 서브메뉴가 활성화되어 있으면 숨기기
                if (activeSubMenu) {
                    activeSubMenu.classList.remove('active');
                }

                // 현재 클릭한 메뉴의 서브메뉴를 토글하고 전역 변수에 할당
                subMenu.classList.toggle('active');
                activeSubMenu = subMenu;
            }
        }
        
        document.addEventListener('DOMContentLoaded', function () {
            // 페이지 로드가 완료된 후 실행됩니다.

            // top.jsp의 스타일을 삭제합니다.
            const stickyContainer = document.querySelector('.sticky-container');
            if (stickyContainer) {
                stickyContainer.removeAttribute('style');
            }
        });
    </script>
    </head>

<div class="myhome-nav myhome-nav--owner">
    <nav class="page-navigation myhome-nav__owner">
        <ul>
            <li class="page-navigation__item" onclick="toggleSubMenu(this)"><a target="_self">내 프로필</a>
            	<span class="page-navigation__sub-menu-items">
                <ul class="page-navigation__sub-menu">
                    <li class="page-navigation__sub-menu-item"><a href="/mypage/profile" target="_self">모두 보기</a></li>
                    <li class="page-navigation__sub-menu-item"><a href="#" target="_self">내 블로그</a></li>
                    <li class="page-navigation__sub-menu-item"><a href="#" target="_self">질문과 답변</a></li>
                    <li class="page-navigation__sub-menu-item"><a href="#" target="_self">나의 블로그</a></li>
                </ul>
                </span>
            </li>
            <li class="page-navigation__item" onclick="toggleSubMenu(this)"><a target="_self">나의 쇼핑</a>
           		<span class="page-navigation__sub-menu-items">
                <ul class="page-navigation__sub-menu">
                    <li class="page-navigation__sub-menu-item"><a href="/mypage/shopping" target="_self">주문 배송 내역 조회</a></li>
                    <li class="page-navigation__sub-menu-item"><a href="/mypage/scrap" target="_self">상품 스크랩북</a></li>
                    <li class="page-navigation__sub-menu-item"><a href="#" target="_self">나의 문의 내역</a></li>
                    <li class="page-navigation__sub-menu-item"><a href="mypage_point.do" target="_self">포인트</a></li>
                    <li class="page-navigation__sub-menu-item"><a href="#" target="_self">공지사항</a></li>
                    <li class="page-navigation__sub-menu-item"><a href="#" target="_self">고객센터</a></li>
                </ul>
                </span>
            </li>
            <li class="page-navigation__item" onclick="toggleSubMenu(this)"><a target="_self">나의 리뷰</a>
            <span class="page-navigation__sub-menu-items">
                <ul class="page-navigation__sub-menu">
                    <li class="page-navigation__sub-menu-item"><a href="#" target="_self">리뷰 쓰기</a></li>
                    <li class="page-navigation__sub-menu-item"><a href="#" target="_self">내가 작성한 리뷰</a></li>
                </ul>
            </span>
            </li>
            <li class="page-navigation__item" onclick="toggleSubMenu(this)"><a target="_self">설정</a>
            <span class="page-navigation__sub-menu-items">
                <ul class="page-navigation__sub-menu">
                    <li class="page-navigation__sub-menu-item"><a href="/mypage/${prc.username}/update" target="_self">회원정보수정</a></li>
                    <li class="page-navigation__sub-menu-item"><a href="#" target="_self">전문가 신청</a></li>
                    <li class="page-navigation__sub-menu-item"><a href="/mypage/${prc.username}/updatepass/up" target="_self">비밀번호 변경</a></li>
                </ul>
            </span>
            </li>
        </ul>
    </nav>
</div>
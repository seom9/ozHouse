<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 메인 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700|Montserrat:400,700&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/merchant/css/styleMain.css">
<%@ include file="mainTop.jsp" %>
<div class="slider">
    <div class="slides" id="slide">
        <div class="slide">
            <a href="merchant_main.do">
                <img src="resources/merchant/img/welcome.png" alt="Image 1" height="80">
            </a>
        </div>
        <div class="slide">
        	<c:set var="mer_num" value="${merchantLoginMember.mer_num}"/>
            <a href="brand_application.do?mer_num=${mer_num }">
                <img src="resources/merchant/img/오늘 입점하세요.png" alt="Image 2">
            </a>
        </div>
    </div>
</div>
<script>
    var slideIndex = 0;
    showSlides();
    function showSlides() {
        var slides = document.getElementsByClassName("slide");
        for (var i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";  
        }
        slideIndex++;
        if (slideIndex > slides.length) {slideIndex = 1}    
        slides[slideIndex-1].style.display = "block"; 
        setTimeout(showSlides, 3000); 
    }
</script>
<br>
<%@ include file="notice_simple.jsp" %>
<%@ include file="mainBottom.jsp" %>

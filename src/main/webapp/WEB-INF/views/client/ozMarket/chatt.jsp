<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <title>채팅</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ozMarket/chatting.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
</head>
<body>
    <div class="top-header">
    <%@ include file="ozMarketTop.jsp"%>
    </div>
    
    <div class="content-container">
        <div class="sidebar" style="margin: 20px 30px;">
            <%@ include file="chatRoom2.jsp"%>
        </div>
        
        <div class="chat-area" style="margin: 20px 30px;">
            <%@ include file="chat.jsp"%>
        </div>
    </div>
</body>
</html>

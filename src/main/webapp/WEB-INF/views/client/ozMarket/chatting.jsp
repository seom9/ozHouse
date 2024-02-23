<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet"
    href="${pageContext.request.contextPath}/ozMarket/chatting.css" />
<!DOCTYPE html>
<html>
<head>
<title>채팅</title>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client/dist/sockjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/stompjs/lib/stomp.min.js"></script>
</head>
<body>
    <h2>채팅</h2>
    <div class="chat-container">
        <div class="chat-list">
            <h3>채팅방 리스트</h3>
            <c:forEach var="room" items="${roomList}">
                <tr>
                    <td><a
                        href="${pageContext.request.contextPath}/ozMarket/chattRoom/${room.roomNum}">${room.roomNum}</a>
                    </td>
                </tr>
            </c:forEach>
        </div>
    </div>
</body>
</html>

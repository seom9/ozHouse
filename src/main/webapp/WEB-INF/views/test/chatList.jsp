<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>

	<form action="/chat/createRoom" method="post">
		<input type="text" name="name" placeholder="채팅방 이름">
		<button type="submit">방 만들기</button>
	</form>

	<table>
		<%-- roomList 객체를 순회하기 위해 JSP의 JSTL c:forEach 태그 사용 --%>
		<c:forEach var="room" items="${roomList}">
			<tr>
				<td>
					<%-- room 객체의 roomId와 name 속성 값 사용 --%> <a
					href="<c:url value='/chatRoom/${room.roomId}' />">${room.name}</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
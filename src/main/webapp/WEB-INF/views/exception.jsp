<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Exception</title>
    <style>
        /* 전체 body를 flex 컨테이너로 만들어 주어서 내용을 가운데로 정렬합니다. */
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }

        /* 이미지, 제목, 메시지, 링크를 포함하는 컨테이너에 대한 스타일 */
        .exception-container {
            text-align: center;
        }

        img {
            max-width: 100%;
            height: auto;
        }

        a {
            display: inline-block;
            margin: 10px;
            padding: 10px;
            background-color: #50E5B4;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        a:hover {
            background-color: #50E5B4;
        }
    </style>
</head>
<body>
    <div class="exception-container">
        <img alt="exception" src="/client/image/exception.jpg" width="700" height="700">
        <h1>죄송합니다, 문제가 발생했습니다.</h1>
        <p><strong>오류:</strong> ${msg}</p>
        <p><strong>URL:</strong> ${url}</p>
        
        <p>문제를 해결하기 위해 노력하겠습니다. 잠시 후 다시 시도해주세요.</p>
        <p>계속해서 문제가 발생하면 고객 서비스팀으로 문의해주시기 바랍니다.</p>
        
        <a href="${url}">다시 시도하기</a>
        <a href="<c:url value='${pageContext.request.contextPath}/'/>">oz의 집으로</a>
        <a href="<c:url value='${pageContext.request.contextPath}/merchant/home'/>">판매자센터로 돌아가기</a>
    </div>
</body>
</html>

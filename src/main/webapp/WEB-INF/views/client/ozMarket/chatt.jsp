<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <script>
        function sendMessage() {
            var message = document.getElementById("message").value;
            // AJAX를 사용하여 서버에 메시지 전송
            // 예: XMLHttpRequest를 사용하거나 jQuery의 $.post 메소드 사용
            console.log("메시지 전송: " + message);
            // 전송 후 텍스트 필드 초기화
            document.getElementById("message").value = '';
        }
    </script>
</head>
<body>
    <h2>채팅</h2>
    <div id="chatBox">
        <p>메시지가 여기에 표시됩니다.</p>
    </div>
    <input type="text" id="message" placeholder="메시지 입력"/>
    <button onclick="sendMessage()">전송</button>
</body>
</html>
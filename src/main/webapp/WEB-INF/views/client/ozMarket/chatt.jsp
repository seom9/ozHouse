<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>채팅</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .chat-container {
            display: flex;
            justify-content: space-between;
        }
        .chat-list, .chat-messages {
            width: 45%;
            border: 1px solid #ddd;
            margin: 10px;
            padding: 10px;
            height: 400px;
            overflow-y: auto;
        }
        .chat-entry {
            margin-top: 10px;
        }
    </style>
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
    <div class="chat-container">
        <div class="chat-list">
            <h3>채팅방 리스트</h3>
            <!-- 채팅방 리스트 출력 -->
            <ul>
                <li>채팅방 1</li>
                <li>채팅방 2</li>
                <!-- 추가 채팅방 목록 -->
            </ul>
        </div>
        <div class="chat-messages">
            <h3>메시지</h3>
            <!-- 메시지 출력 -->
            <div>안녕하세요, 어떻게 도와드릴까요?</div>
            <!-- 추가 메시지 -->
        </div>
    </div>
    <div class="chat-entry">
        <input type="text" id="message" placeholder="메시지 입력"/>
        <button onclick="sendMessage()">전송</button>
    </div>
</body>
</html>
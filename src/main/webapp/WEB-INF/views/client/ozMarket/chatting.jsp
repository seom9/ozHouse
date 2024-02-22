<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>채팅방</title>
</head>
<body>
    <div id="chatMessages" style="margin-bottom:20px; border: 1px solid #ccc; padding: 10px; height: 300px; overflow-y: scroll;"></div>
    <div class="chat-entry" style="margin-top: 20px;">
        <input type="text" id="message" placeholder="메시지 입력" style="width: 300px;"/>
        <button onclick="sendMessage()">전송</button>
    </div>
    <script>
        var ws;

        function connectWebSocket(roomNum) {
            // WebSocket URL 동적 생성 및 연결 초기화
            var contextPath = "/ozMarket"; // 컨텍스트 패스, 실제 환경에서는 동적으로 설정 필요
            ws = new WebSocket("ws://" + window.location.host + contextPath + "/ws/chatting/" + roomNum);

            ws.onopen = function() {
                console.log("채팅방 " + roomNum + "에 연결됨");
            };

            ws.onmessage = function(event) {
                console.log("수신 메시지: " + event.data);
                // 수신 메시지 화면에 표시
                var chatMessages = document.getElementById("chatMessages");
                chatMessages.innerHTML += "<div>" + event.data + "</div>"; // 메시지를 div에 추가
            };

            ws.onclose = function() {
                console.log("채팅방에서 연결 끊김");
            };
        }

        function sendMessage() {
            var message = document.getElementById("message").value;
            
            // WebSocket 연결 상태 확인
            if (ws.readyState === WebSocket.OPEN) {
                ws.send(message); // 연결이 열려있다면 메시지 전송
            } else {
                console.error("WebSocket 연결이 닫혀있습니다. 재연결을 시도합니다.");
                // 연결 재시도 로직 (예: 특정 방 번호로 다시 연결 시도)
                connectWebSocket(roomNum); // connectWebSocket 함수를 호출하여 재연결 시도
                setTimeout(() => {
                    if (ws.readyState === WebSocket.OPEN) {
                        ws.send(message); // 재연결 후 메시지 전송 시도
                    } else {
                        console.error("재연결 실패: 메시지 전송 불가");
                    }
                }, 1000); // 재연결을 위한 충분한 시간 기다림 (1초)
            }
            document.getElementById("message").value = ''; // 메시지 전송 후 입력 필드 초기화
        }

        // 연결 상태를 모니터링하고 자동으로 재연결을 시도하는 로직을 추가할 수도 있습니다.
        // 예를 들어, ws.onclose 이벤트 핸들러 내에서 connectWebSocket 함수를 호출할 수 있습니다.
        ws.onclose = function() {
            console.log("WebSocket 연결이 끊어졌습니다. 재연결을 시도합니다.");
            connectWebSocket(roomNum); // 자동 재연결 시도
        };

        document.addEventListener("DOMContentLoaded", function() {
            // 페이지 로딩 완료 시 WebSocket 연결
            var roomNum = "1"; // 실제 애플리케이션에서는 동적으로 방 번호를 설정해야 함
            connectWebSocket(roomNum);
        });
    </script>
</body>
</html>

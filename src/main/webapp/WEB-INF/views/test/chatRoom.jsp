<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>
    <span>메세지</span>
    <!-- 메시지 표시 영역: 수신한 메시지가 여기에 출력 -->
    <div class="msgArea"></div>
</div>
<input type="text" placeholder="보낼 메세지를 입력하세요." class="content">
<button type="button" value="전송" class="sendBtn" onclick="sendMsg()">전송</button>
<button type="button" value="방나가기" class="quit" onclick="quit()">방 나가기 </button>

</body>

<script>
        // 채팅방에 입장할 때 서버에 보내는 메시지를 구성하고 전송하는 함수
        function enterRoom(socket){
            var enterMsg={"type" : "ENTER","roomId":"${room.roomId}","sender":"chee","msg":""}; // sender는 사용자 이름으로 변경해야 합니다.
            socket.send(JSON.stringify(enterMsg));
        }
        // 웹소켓 객체를 생성하고 서버에 연결을 시도합니다.
        let socket = new WebSocket("ws://localhost:8080/ws/chat");

        // 웹소켓 연결이 성공적으로 열린 경우의 이벤트 핸들러
        socket.onopen = function (e) {
            console.log('open server!')
            enterRoom(socket); // 채팅방에 입장
        };
        // 웹소켓 연결이 닫힌 경우의 이벤트 핸들러
        socket.onclose=function(e){
            console.log('disconnet');
        }

        // 웹소켓 연결 중 오류가 발생한 경우의 이벤트 핸들러
        socket.onerror = function (e){
            console.log(e);
        }

        // 서버로부터 메시지를 수신한 경우의 이벤트 핸들러
        socket.onmessage = function (e) {
            console.log(e.data);
            let msgArea = document.querySelector('.msgArea');
            let newMsg = document.createElement('div');
            newMsg.innerText=e.data;
            msgArea.append(newMsg);
        }

        // 메시지 전송 버튼을 클릭했을 때 호출되는 함수
        function sendMsg() {
            let content=document.querySelector('.content').value; // 입력 필드에서 메시지 내용을 가져옴
             var talkMsg={"type" : "TALK","roomId":"${room.roomId}" ,"sender":"chee","msg":content}; // 메시지 객체를 구성
           socket.send(JSON.stringify(talkMsg)); // 메시지를 서버에 전송
        }

        // 방 나가기 버튼을 클릭했을 때 호출되는 함수
        function quit(){
             var quitMsg={"type" : "QUIT","roomId":"${room.roomId}" ,"sender":"chee","msg":""}; // 방을 나가는 메시지 객체를 구성
           socket.send(JSON.stringify(quitMsg)); // 메시지를 서버에 전송
            socket.close(); // 웹소켓 연결을 닫기
            location.href="/chat/chatList"; // 사용자를 채팅 목록 페이지로 리다이렉트
        }

</script>

</html>
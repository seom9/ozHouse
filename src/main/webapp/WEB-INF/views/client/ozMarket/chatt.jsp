<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="ozMarketTop.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>채팅</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/ozMarket/chatting.css" />
</head>
<body>
	<div class="chat-container">
		<div class="chat-list">
			<div class="user-avatar">
				<c:choose>
					<c:when test="${empty member.memberImage}">
						<img
							src="https://image.ohou.se/i/bucketplace-v2-development/uploads/default_images/avatar.png?gif=1&w=144&h=144&c=c&webp=1"
							alt="User Avatar">
					</c:when>
					<c:otherwise>
						<img src="${member.memberImage}" alt="User Avatar">
					</c:otherwise>
				</c:choose>
			</div>
			<div class="memberNickname">${nickname}</div>
			<c:forEach var="room" items="${roomList}">
				<div class="chat-room-entry">
					<a
						href="${pageContext.request.contextPath}/ozMarket/chattRoom/${room.roomNum}">방
						${room.roomNum}</a>
				</div>
			</c:forEach>
		</div>
		<div class="chat-messages">
			<h3>메세지</h3>
			<!-- 메시지 표시 영역: 수신한 메시지가 여기에 출력 -->
			<div class="msgArea"></div>
			<div class="message-input">
				<input type="text" placeholder="보낼 메세지를 입력하세요." class="content">
				<button type="button" class="sendBtn" onclick="sendMsg()">전송</button>
				<button type="button" value="방나가기" class="quit" onclick="quit()">방
					나가기</button>
			</div>
		</div>
	</div>

	<script>
		var wsUrl = "ws://localhost:8080/ws/chat"; // 웹소켓 서버 URL
		var socket; // 웹소켓 객체를 전역 변수로 선언
		var sender = '<c:out value="${memberNickname}" />'; // 현재 사용자의 닉네임
		var roomNum = '<c:out value="${room.roomNum}" />'; // 현재 방 번호

		// 웹소켓 연결 함수
		function connectWebSocket() {
			// 웹소켓 연결이 이미 열려있는지 확인
			if (socket !== undefined && socket.readyState !== WebSocket.CLOSED) {
				console.log("웹소켓 연결이 이미 열려 있습니다.");
				return; // 이미 열려있는 소켓이 있다면 새로 연결을 시도하지 않음
			}

			// 새 웹소켓 연결 생성
			socket = new WebSocket(wsUrl);

			socket.onopen = function(e) {
				console.log('서버에 연결되었습니다!');
				enterRoom(); // 채팅방 입장 처리
				loadPreviousMessages(roomNum); // 이전 메시지 로드
			};

			socket.onclose = function(e) {
				console.log('연결이 종료되었습니다. 재연결을 시도합니다.');
				setTimeout(connectWebSocket, 5000); // 5초 후 재연결 시도
			};

			socket.onerror = function(e) {
				console.error('웹소켓 오류 발생: ', e);
			};

			socket.onmessage = function(e) {
				console.log('메시지 수신: ', e.data);
				processMessage(e); // 수신된 메시지 처리
			};
		}

		// 채팅방에 들어가는 로직을 처리하는 함수
		function enterRoom() {
			loadPreviousMessages(roomNum); // 이전 메시지를 로드하는 함수 호출
			markAllMessagesAsRead(roomNum);
			console.log("방 입장: " + roomNum);
			// 방에 입장하는 로직, 예: 서버에 메시지 보내기
			var enterMsg = {
				type : "ENTER",
				roomNum : roomNum,
				sender : sender,
				msg : ""
			};
			
		    markAllMessagesAsRead(roomNum);

			if (socket.readyState === WebSocket.OPEN) {
				socket.send(JSON.stringify(enterMsg)); // 서버에 입장 메시지를 보냄
			}
			// 여기에서 이전 메시지를 로드하거나 UI를 준비할 수 있습니다.
		}
		
		// 모든 메시지를 '읽음'으로 표시하는 함수
		function markAllMessagesAsRead(roomNum) {
		    // 예시: 서버에 AJAX 요청을 보내 현재 채팅방의 모든 메시지를 '읽음'으로 처리합니다.
		    // 실제 구현은 서버의 API 엔드포인트와 요청 방식에 따라 달라집니다.
		    fetch(`/ozMarket/markAllMessagesAsRead/${roomNum}`, {
		        method: 'POST',
		        headers: {
		            'Content-Type': 'application/json',
		        }
		        // 필요한 경우 인증 토큰 등 추가 헤더를 여기에 포함
		    })
		    .then(response => {
		        if (!response.ok) {
		            throw new Error('Failed to mark all messages as read');
		        }
		    })
		    .catch(error => {
		        console.error('Error marking messages as read:', error);
		    });
		}

		var httpUrl = "http://localhost:8080/ozMarket/chattRoom/messages/"
				+ roomNum;

		// 이전 메시지를 로드하는 함수
		function loadPreviousMessages(roomNum) {
			// 서버에 AJAX 요청을 보내 이전 메시지를 불러옵니다.
			var xhr = new XMLHttpRequest();
			xhr.open('GET', httpUrl, true);
			xhr.onload = function() {
				if (this.status == 200) {
					var messages = JSON.parse(this.responseText);
					// 메시지를 화면에 표시
					messages.forEach(function(message) {
						displayChatMessage(message);
					});
					// 스크롤을 맨 아래로 설정
					var msgArea = document.querySelector('.msgArea');
					msgArea.scrollTop = msgArea.scrollHeight;
				} else {
					console.error('메시지를 불러오는데 실패했습니다.');
				}
			};
			xhr.send();
		}

		// 메시지 전송 함수
		function sendMsg() {
			let contentField = document.querySelector('.content'); // 입력 필드 선택
			let content = contentField.value.trim(); // 입력 필드에서 메시지 내용을 가져옴

			if (!content) {
				console.log("메시지를 입력하세요.");
				return; // 메시지가 비어있으면 함수를 종료
			}

			var talkMsg = {
				"type" : "TALK",
				"roomNum" : roomNum,
				"sender" : sender,
				"msg" : content
			};

			if (socket.readyState === WebSocket.OPEN) {
				socket.send(JSON.stringify(talkMsg)); // 메시지를 서버에 전송
			} else {
				console.error("웹소켓 연결이 닫혀있습니다. 메시지를 전송할 수 없습니다.");
				connectWebSocket(); // 연결이 닫혀 있을 경우 재연결 시도
			}

			contentField.value = ''; // 입력 필드 초기화
		}

		// 메시지를 수신할 때 호출되는 함수
		function processMessage(message) {
			console.log('메시지 처리: ', message);
			var data = JSON.parse(message.data); // 서버로부터 받은 메시지(JSON 문자열)를 객체로 변환

			// 메시지 유형에 따라 다른 동작을 수행
			if (data.type === "MESSAGE_STATUS_UPDATE") {
				updateMessageStatusOnUI(data);
			} else if (data.type === "TALK") {
				// 채팅 메시지를 화면에 표시하는 로직
				displayChatMessage(data);
			}
			// 기타 메시지 유형에 대한 처리를 여기에 추가
		}
		
		// UI에서 메시지 상태를 업데이트하는 함수
		function updateMessageStatusOnUI(data) {
    // data에는 업데이트할 메시지의 ID와 상태가 포함되어 있다고 가정합니다.
    // 예: data = { msgId: 1, readStatus: true }
    
    // 메시지의 HTML 요소를 찾습니다.
    var messageElement = document.getElementById(`message-${data.msgId}`);
    
    if (messageElement && data.readStatus) {
        // 메시지의 상태가 '읽음'인 경우, 'read' 클래스를 추가합니다.
        messageElement.classList.add('read');
    } else if (messageElement) {
        // 메시지의 상태가 '읽지 않음'인 경우, 'read' 클래스를 제거합니다.
        messageElement.classList.remove('read');
    }
}

		// 채팅 메시지를 화면에 표시하는 함수
		function displayChatMessage(data) {
			var msgArea = document.querySelector('.msgArea');
			var msgDiv = document.createElement('div');
			var msgContentDiv = document.createElement('div'); // 메시지 내용을 담을 div 생성
			var msgTimeSpan = document.createElement('span');
			var readStatusSpan = document.createElement('span'); // 읽음 상태를 표시할 span 생성

			msgDiv.classList.add('message');
			msgContentDiv.classList.add('msg-content');
			msgTimeSpan.classList.add('msg-time');
			readStatusSpan.classList.add('read-status');

			// 메시지 내용 설정
			msgContentDiv.textContent = data.msg;
			// 메시지 시간 설정
			msgTimeSpan.textContent = formatTime(data.inTime);
		    readStatusSpan.textContent = data.readStatus ? '읽음' : '읽지 않음';

			msgContentDiv.appendChild(msgTimeSpan);
			msgDiv.appendChild(msgContentDiv);
			msgArea.appendChild(msgDiv);
			msgDiv.appendChild(readStatusSpan);

			msgArea.scrollTop = msgArea.scrollHeight; // 스크롤을 맨 아래로 이동
		}

		// 시간을 'HH:MM' 형식으로 포맷하는 함수
		function formatTime(timeString) {
			var time = new Date(timeString);
			var hours = time.getHours().toString().padStart(2, '0');
			var minutes = time.getMinutes().toString().padStart(2, '0');
			return hours + ':' + minutes; // 'HH:MM' 형식
		}

		// 방 나가기 버튼을 클릭했을 때 호출될 함수
		function quit() {
			// WebSocket 연결 종료 또는 채팅방 나가기 로직
			if (socket && socket.readyState === WebSocket.OPEN) {
				// 서버에 방 나가기 메시지 전송 등
				socket.close(); // WebSocket 연결 종료
			}
			// 필요한 경우, 사용자를 다른 페이지로 리다이렉션
			window.location.href = '/ozMarket/chatts'; // 예시 URL
		}

		// 페이지 로드 시 웹소켓 연결 시도
		window.onload = connectWebSocket;
	</script>

</body>
</html>
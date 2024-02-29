<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>채팅</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/ozMarket/chatting.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

</head>
<body>
	<div class="chat-area">
		<div class="chat-container">
					<div class="product-container">
							<c:set var="proImgPro"
								value="${fn:split(getProduct.proImgPro, ',')}" />
							<img class="image" src="${proImgPro[0]}" width="60" height="60">
						</div>

						<div class="memberNickname">
							<b>${getProduct.proTitle}</b>
						</div>
						<div class="memberNickname">
							<fmt:formatNumber value="${getProduct.proPrice}"
								pattern="###,###" />
							원
						</div>
						<div class="memberNickname">${getProduct.proApprovalStatus}</div>
						<div class="action-buttons">
							<c:if test="${getProduct.memberNickname == memberNickname}">
								<c:if test="${getProduct.proApprovalStatus == '판매중'}">
									<!-- 예약 -->
									<form id="reserveForm"
										action="/ozMarket/reserveProduct/${getProduct.proNum}"
										method="post">
										<input type="submit" value="예약" />
									</form>
								</c:if>
								<!-- 구매 확정 -->
								<form id="confirmForm"
									action="/ozMarket/confirmPurchase/${getProduct.proNum}"
									method="post">
									<input type="submit" value="확정" />
								</form>

								<c:if test="${getProduct.proApprovalStatus == '예약중'}">
									<!-- 예약 취소 -->
									<form id="cancelForm"
										action="/ozMarket/cancelReservation/${getProduct.proNum}"
										method="post">
										<input type="submit" value="취소" />
									</form>
								</c:if>
							</c:if>
						</div>
						<!-- 메시지 표시 영역: 수신한 메시지가 여기에 출력됩니다. -->
						<div class="msgArea">
							<!-- 여기에 메시지가 동적으로 추가됩니다. -->
						</div>
						<!-- 메시지 입력 영역 -->
						<div class="message-input">
							<input type="text" placeholder="메시지를 입력하시오." class="content"
								id="messageInput">
							<button type="button" class="sendBtn" onclick="sendMsg()">전송</button>
							<button type="button" value="Leave Room" class="quit"
								onclick="quit()">채팅방 나가기</button>
						</div>
					</div>
				</div>
				<script>
		var wsUrl = "ws://" + location.host + "/ws/chat"; // 웹소켓 서버 URL
		var socket; // 웹소켓 객체를 전역 변수로 선언
		var sender = '<c:out value="${memberNickname}" />'; // 현재 사용자의 닉네임
		var roomNum = '<c:out value="${room.roomNum}" />'; // 현재 방 번호
		var nickname = "<c:out value='${nickname}'/>"; // JSP에서 JavaScript 변수로 값을 전달

		function initWebSocket() {
			socket = new WebSocket(wsUrl); // 방 번호를 URL에 포함하여 웹소켓 연결

			socket.onopen = function(event) {
				console.log("Connected to WebSocket server.");
				sendEventMessage("ENTER");
				loadChatHistory(roomNum);
			};

			socket.onmessage = function(event) {
				var msgData = JSON.parse(event.data); // 서버에서 받은 메시지 데이터
				console.log("Received message:", msgData);
				if (msgData.type === "TALK") {
					displayMessage(msgData); // 메시지 표시 함수 호출
				}
			};

			socket.onclose = function(event) {
				console.log("Disconnected from WebSocket server.");
			};

			socket.onerror = function(event) {
				console.error("WebSocket error: ", event);
			};
		}

		// 메시지를 화면에 표시하는 함수
		function displayMessage(messageData) {
    var msgArea = document.querySelector('.msgArea'); // Ensure msgArea is defined and selected correctly
    var msgDiv = document.createElement('div'); // Create a new div for the message
    var msgBubble = document.createElement('div');
    var msgContent = document.createElement('div');
    var msgTime = document.createElement('div');

    // Set the message content
    msgContent.textContent = messageData.msg;
    msgContent.className = 'message-content';

    // Set the message time
    msgTime.textContent = new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
    msgTime.className = 'message-time';

    // Append content and time to the message bubble
    msgBubble.appendChild(msgContent);
    msgBubble.appendChild(msgTime);

    // Assign classes based on whether the message was sent by the current user
    if (messageData.sender === sender) {
        msgDiv.className = 'chat-message sent';
        msgBubble.className = 'message-bubble sent';
    } else {
        msgDiv.className = 'chat-message received';
        msgBubble.className = 'message-bubble received';
    }

    // Append the message bubble to the message div
    msgDiv.appendChild(msgBubble);
    
    // Append the message div to the message area
    msgArea.appendChild(msgDiv);

    // Scroll to the new message
    msgArea.scrollTop = msgArea.scrollHeight;
}

		// 시간 데이터를 '오전/오후 시:분' 형식으로 변환하는 함수
		function formatTime(timestamp) {
		    var date = new Date(timestamp); // Timestamp를 Date 객체로 변환
		    return date.toLocaleTimeString('ko-KR', {
		        hour: '2-digit',
		        minute: '2-digit',
		        hour12: true
		    });
		}

		function sendMsg() {
			var messageInput = document.getElementById('messageInput');
			var message = messageInput.value;
			if (message === "") {
				alert("메시지를 입력하세요.");
				return;
			}
			var msgData = {
				type : "TALK",
				sender : sender,
				msg : message,
				roomNum : roomNum
			};
			socket.send(JSON.stringify(msgData));
			messageInput.value = ''; // 입력 필드 초기화
		}

		function sendEventMessage(eventType) {
			var msgData = {
				type : eventType,
				sender : sender,
				roomNum : roomNum
			};
			socket.send(JSON.stringify(msgData));
		}

		window.onload = function() {
			initWebSocket();
			document.getElementById('messageInput').addEventListener(
					'keypress', function(e) {
						if (e.key === 'Enter' && !e.shiftKey) {
							e.preventDefault(); // 기본 이벤트 방지
							sendMsg(); // 메시지 전송 함수 호출
						}
					});
		};
		
		var httpUrl = "http://" + location.host + "/ozMarket/chattRoom/messages/" + roomNum;

		// 채팅 기록을 불러오는 함수
		function loadChatHistory(roomNumber) {
				
				// 서버에 AJAX 요청을 보내 이전 메시지를 불러옵니다.
				var xhr = new XMLHttpRequest();
				xhr.open('GET', httpUrl, true);
				xhr.onload = function() {
					if (this.status == 200) {
						var messages = JSON.parse(this.responseText);
						
			            insertDateDivider(messages);

						// 메시지를 화면에 표시
						messages.forEach(function(message) {
							displayMessage(message);
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
		
		function insertDateDivider(messages) {
		    let lastDate = null;
		    const msgArea = document.querySelector('.msgArea'); // msgArea를 여기서 정의

		    messages.forEach((message) => {
		        const messageDate = new Date(message.inTime).toLocaleDateString('ko-KR');
		        if (messageDate !== lastDate) {
		            lastDate = messageDate;
		            const dateDivider = document.createElement('div');
		            dateDivider.className = 'date-divider';
		            dateDivider.textContent = messageDate; // 현지화된 날짜 표시
		            msgArea.appendChild(dateDivider);
		        }
		        displayMessage(message);
		    });
		}
		
		function quit() {
			sendEventMessage("QUIT");
			socket.close();
			window.location.href = '/ozMarket/chatts'; // 채팅 목록 페이지로 리다이렉션
		}
	</script>
</body>
</html>
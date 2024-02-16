<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
  <div class="box">
    <div class="chat">
      <div id="msg"></div>
    </div>
    <div class="form-container">
      <form id="chat-form" onsubmit="return false">
        <input id="input-box" type="text" size="50" contenteditable="true" autocomplete="off" />
        <input type="submit" id="send-msg" value="보내기" />
      </form>
    </div>
  </div>
  <body></body>
</body>
</html>
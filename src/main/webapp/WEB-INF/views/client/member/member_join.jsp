<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/top.jsp" %>   
    
<html>
<head>
   <title>회원 가입</title>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <c:set var="path" value="${pageContext.request.contextPath}"/>
   <script src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script type="text/javascript">
      var idChecked = false;
      function check(){
         if (f.id.value == ""){
            alert("아이디를 입력해 주세요")
            f.id.focus()
            return
         }
         if (!idChecked) { // 중복 검사가 실행되지 않았으면
            alert("아이디 유효성을 확인해 주세요");
            return;
         }
         if (!f.member_passwd.value){
            alert("비밀번호를 입력해 주세요")
            f.passwd.focus()
            return
         }
         if (!f.member_passwd2.value) {
            alert("비밀번호 중복 확인을 해 주세요");
            f.member_passwd2.focus();
            return;
         }
         if (f.member_passwd.value !== f.member_passwd2.value) {
            alert("비밀번호가 일치하지 않습니다.");
            f.member_passwd2.focus();
            return;
         }
          if (!isValidPassword($("#password").val())) {
              alert("비밀번호 유효성을 확인해 주세요");
              f.member_passwd2.focus();
              return;
          }
         document.f.submit();
      }
      
      function checkIdFalse() {
         idChecked = false;
      }

      $(function(){ 
          $("#checkId").click(function(){
              let member_id = $("#member_id").val();
              $.ajax({
                  type:'post', //post 형식으로 controller 에 보내기위함!!
                  url:"member_checkId.do", // 컨트롤러로 가는 mapping 입력
                  data: {"member_id":member_id}, // 원하는 값을 중복확인하기위해서  JSON 형태로 DATA 전송
                  success: function(data){ 
                   if (data == "N" ){ // 만약 성공할시
                          result = "사용 가능한 아이디입니다.";
                          $("#result_checkId").html(result).css("color", "green");
                          $("#member_pw").trigger("focus");
                          idChecked = true; // 중복 검사를 실행했음을 기록
                   }else if(data == "E" ){
                          result = "아이디를 입력해 주세요.";
                          $("#result_checkId").html(result).css("color", "red");
                          $("#member_pw").trigger("focus");
                          idChecked = false; // 중복 검사를 실행했음을 기록
                   }else if(data == "L" ){
                          result = "아이디는 6-12자의 영문, 숫자, 기호( - _ )만 사용이 가능합니다";
                          $("#result_checkId").html(result).css("color", "red");
                          $("#member_pw").trigger("focus");
                          idChecked = false; // 중복 검사를 실행했음을 기록
                   }else if(data == "V" ){
                          result = "아이디는 영문, 숫자, 기호( - _ )만 사용이 가능합니다";
                          $("#result_checkId").html(result).css("color", "red");
                          $("#member_pw").trigger("focus");
                          idChecked = false; // 중복 검사를 실행했음을 기록
                   }else{ // 만약 실패할시
                       result="이미 사용중인 아이디입니다.";
                           $("#result_checkId").html(result).css("color","red");
                           $("#member_id").val("").trigger("focus");
                           idChecked = false; // 중복 검사를 실행하지 않았음을 기록
                   }
               },
                  error : function(error){alert(error);}
              });
          });
      });
   </script>
<script>
    function isValidPassword(password) {
        //  최소 8자리 이상 영문 대소문자, 숫자, 특수문자가 각각 1개 이상 
        let regex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$/
        return regex.test(password);
    }
   
    function checkPasswd2() {
       let password = $("#password").val();
        if (!isValidPassword(password)) {
            $("#checkPasswd2").show();
        } else {
            $("#checkPasswd2").hide();
        }
    }
    
    function checkPasswd() {
        let password = $("#password").val();
        let passwordCheck = $("#passwordCheck").val();

        if (password !== passwordCheck) {
            $("#checkPasswd").show();
        } else {
            $("#checkPasswd").hide();
        }
    }

    $(document).ready(function() {
        $("#checkPasswd").hide();
    });
</script>
   <link rel="stylesheet" href="${path}/resources/client/login.css"/>
</head>  
<body onload="f.member_id.focus()">
   <div  align="center" class="login-wrapper" style="top: 70px; position: relative;">
   <form name="f" method="post" id="login-form" action="member_send_email.do">
             <h2><img src="${path}/resources/client/image/ozHouseLogo.png" style="width: 20%"></h2>
            <font face="Roboto, sans-serif">회원 가입</font>
            <p>
              <section>
              <span class="join2">sns계정으로 간편하게 회원가입</span> <br>
              <a class="css-l0qndx e1ufx3to0" href="/users/auth/github">
              <img src="${path}/resources/client/image/github.png">
              </a>
              <a class="css-l0qndx e1ufx3to0" href="https://kauth.kakao.com/oauth/authorize?client_id=e5b283df9616f7c21f3e15db5f9b0df2&redirect_uri=http://localhost:8080/ozHouse/kakao_login.do&response_type=code">
              <img src="${path}/resources/client/image/kakao.png">
              </a>
              <a class="css-l0qndx e1ufx3to0" href="naverLogin.do">
              <img src="${path}/resources/client/image/naver.png">
              </a>
              </section>
            <br><br><br>
            <span class="title">아이디</span>
               <input type="text" tabindex="1" value="${member_id}" placeholder="아이디를 입력해 주세요." id="member_id" name="member_id" class="box" oninput="checkIdFalse()"><br>
               <div><span id="result_checkId" style="font-size:12px;"></span></div>
               <div style="margin-top: 10px;"><span id="checkId"><input type="button" id="checkId" value="중복검사"></span></div>
               
            <br><br>
            <span class="title">닉네임</span>
               <input type="text" tabindex="2" value="${member_nickname}" placeholder="닉네임을 입력해 주세요." name="member_nickname" class="box">

            <span class="title">비밀번호</span>
               <input type="password" tabindex="3" name="member_passwd" placeholder="비밀번호를 입력해 주세요." class="box" placeholder="Enter password" id="password" oninput="checkPasswd2()">
            <span class="title">비밀번호 확인</span>
            <input type="password" tabindex="4" placeholder="비밀번호를 정확하게 입력해 주세요." name="member_passwd2" class="box" placeholder="Enter passwordCheck" id="passwordCheck" oninput="checkPasswd()">
                    <div id="checkPasswd" class="error-message">
                    PASSWORD 가 동일하지 않습니다
               </div>
               <div id="checkPasswd2" class="error-message" style="margin-bottom: 10px; margin-top: 10px;">
                    비밀번호는 8자리 이상 영문 대소문자, 숫자, 특수문자가 각각 1개 이상이어야 합니다
               </div>

            <span class="title">이메일</span>
            <c:if test="${not empty member_email}">
               <input type="text" tabindex="5" value="${member_email}" placeholder="이메일을 입력해주세요." name="email" class="box" ReadOnly>
            </c:if>
            
            <c:if test="${empty member_email}">
               <input type="text" tabindex="5" value="${member_email}" placeholder="이메일을 입력해주세요." name="email" class="box">
            </c:if>   
               
               <input type="hidden" name="member_image" value="${member_image}">
               <input type="button" value="회원가입" onclick="javascript:check()">
               <input type="reset" value="reset">
   </form>
   </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 입점신청 top -->
<%@ include file="../brand/brand_inform_top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="UTF-8">
<title>입점신청</title>
<script type="text/javascript">

function check(fileData) { 
   if(f.inbrand_manname.value==""){
          alert('담당자 이름을 입력해주세요.');
          f.inbrand_manname.focus();
           return;
   }
   var hp1 = f.inbrand_manhp1.value;
   var hp2 = f.inbrand_manhp2.value;
   var hp3 = f.inbrand_manhp3.value;
   if(hp1=="" || hp2=="" || hp3=="") {
   alert('담당자 전화번호를 입력해주세요.');
   f.inbrand_manhp1.focus();
       return;
   }
   var hpExptext = /^[0-9]+/;
   if(hpExptext.test(hp1)==false || 
         hpExptext.test(hp2)==false || hpExptext.test(hp3)==false){
      alert("전화번호에는 숫자만 입력 가능합니다.");
      f.inbrand_manhp1.focus();
      return;
   }
   var email = f.inbrand_manemail.value;
   var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

   if(exptext.test(email)==false){
   //이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우   
      alert("이메일형식이 올바르지 않습니다.");
      f.inbrand_manemail.focus();
      return;
   }
   var isChk = false;
   var values = document.getElementsByName("inbrand_category");
   for(var i=0;i<values.length;i++){
      if(values[i].checked){
          isChk = true;
           break;
       }
   } 
   if(!isChk){
       alert("카테고리를 선택해주세요.");
       return;
   }else{
      var arrCate = [];
      for(var i=0; i<values.length; ++i){
          if(values[i].checked){  //체크된 박스라면
              arrCate.push(values[i].value);  //arrCate 배열에 추기하기
          }
      }
      var cate = arrCate.join(',');  //배열 -> 문자열로 변환
         document.f.inbrand_category.value = cate;
       }
   
   if(!fileData.files || fileData.files.length == 0){
       alert("파일을 등록하여 주세요.");
       return;
    }
   var fileSize = fileData.files[0].size; 
   var maxSize = 1024 * 1024 * 1024;   //1GB
    if(fileSize > maxSize) { 
        alert("파일용량을 초과하였습니다. 업로드 가능한 최대크기는 1GB입니다.");
        return;
    }
   //파일 이름 확인
    var fileName = fileData.files[0].name; //files[0] : 업로드 된 파일 중 첫번째 파일  name : 파일의 이
    const regex = /^[a-zA-Z0-9_]/; 
    if (!regex.test(fileName)) {
        alert("파일 이름의 형식은 '-'를 제외한 사업자등록번호_상점명 입니다.");
        return;
    }
    
    var cNum1 = fileName.substr(0,3);
    var cNum2 = fileName.substr(3,2);
    var cNum3 = fileName.substr(5,5);
    
    if(cNum1 != ${inbrand_comnum1} || cNum2 != ${inbrand_comnum2} || cNum3 != ${inbrand_comnum3}){
       alert("파일명의 사업자등록번호를 확인하여 주세요.");
       return;
    }
    
   if(f.inbrand_homepage.value==""){
      document.f.inbrand_homepage.value = " ";
   }
   if(f.inbrand_othershop.value==""){
      document.f.inbrand_othershop.value = " ";
   }
    document.f.submit();
   }
</script>
<style>
.container {
    margin: 10px auto;
    background-color: white;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.container {
    width: 70%;
    margin: 15px auto;

h2, h3, h4 {
    color: #333;
    margin-bottom: 15px;
}

h3 {
    font-size: 20px;
}

.notice-link, .red-text {
    color: #E53E3E;
}

.flex-container {
    display: flex;
    flex-direction: column;
}

.flex-row {
    display: flex;
    align-items: center;
    margin-bottom: 10px;
}

.flex-header {
    flex: 0 0 150px;
    font-weight: bold;
}

.flex-content, .business-num-inputs {
    flex-grow: 1;
    display: flex;
}

input[type="text"], input[type="email"], input[type="file"] {
    width: 100%;
    padding: 10px;
    margin-right: 5px;
    border: 1px solid #ddd;
    border-radius: 4px;
}

input[type="checkbox"] {
    margin-right: 5px;
}

.button-container {
    text-align: center;
    margin-top: 20px;
}

button {
    background-color: #50E5B4;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

@media (max-width: 600px) {
    .flex-row {
        flex-direction: column;
        align-items: flex-start;
    }

    .flex-header {
        margin-bottom: 5px;
    }
}

.business-num-inputs input[type="text"] {
    width: auto; 
    max-width: 100px;
    padding: 10px;
    margin-right: 5px;
    border: 1px solid #ddd;
    border-radius: 4px;
}
</style>
</head>
<body style="background-color: #F4F4F4">
<div class="container">
<h2>입점신청</h2>
<h4>
   • 입점신청에 관련하여 궁금한 사항은 
      <span class="notice-link">OZ의 집 공지사항</span>
      을 확인하여 주시기 바랍니다.<br>
   • 공지사항 외의 궁금한 사항은 OZ의 집 판매자센터로 연락하시면 친절히 안내해드리겠습니다.<br>
   • 파일 이름은 <span class="red-text">'-'를 제외한 "사업자등록번호"</span>으로 설정하여 주시기 바랍니다.<br>
   • 입점신청중에는 중복 신청이 불가하고, 입점 거절 또는 취소시 재입점 신청은 
      <span class="red-text">3개월 후</span>에 가능합니다.<br><br>
<hr>
</h4>
<h3>상점 정보 입력</h3>
<div align="center">
   <form name="f" action="brand_inform.do" method="post" enctype="multipart/form-data" >
      <div class="flex-container">
          <div class="flex-row">
              <div class="flex-header">사업자 등록번호</div>
              <div class="business-num-inputs">
			    <input type="text" name="inbrand_comnum1" maxlength="3" size="5" value="${inbrand_comnum1}" readOnly/>
			    <span>-</span>
			    <input type="text" name="inbrand_comnum2" maxlength="2" size="3" value="${inbrand_comnum2}" readOnly/>
			    <span>-</span>
			    <input type="text" name="inbrand_comnum3" maxlength="5" size="5" value="${inbrand_comnum3}" readOnly/>
			</div>
            </div>
         <div class="flex-row">
              <div class="flex-header">상점명</div>
              <div class="flex-content">
               <input type="text" name="inbrand_company" size="100" value="${merchantLoginMember.mer_company}" readOnly/>
            </div>
            </div>
         <div class="flex-row">
              <div class="flex-header">홈페이지</div>
            <div class="flex-content">
               <input type="text" name="inbrand_homepage" size="100"/>
            </div>
            </div>
         <div class="flex-row">
              <div class="flex-header">담당자 이름</div>
            <div class="flex-content">
               <input type="text" name="inbrand_manname" size="20"/>
            </div>
            </div>
            <div class="flex-row">
              <div class="flex-header">담당자 전화번호</div>
            <div class="business-num-inputs">
			    <input type="text" name="inbrand_manhp1" size="5" maxlength="3"/>
			    <span>-</span>
			    <input type="text" name="inbrand_manhp2" size="5" maxlength="4"/>
			    <span>-</span>
			    <input type="text" name="inbrand_manhp3" size="5" maxlength="4"/>
			</div>
            </div>
         <div class="flex-row">
              <div class="flex-header">담당자 이메일</div>
            <div class="flex-content">
               <input type="text" name="inbrand_manemail" size="100"/>
            </div>
            </div>
         <div class="flex-row">
              <div class="flex-header">카테고리</div>
            <div class="flex-content">
               <c:forEach var="dto" items="${category}">
                  <input type="checkbox" name="inbrand_category" value="${dto.category_num}">${dto.category_name}
               </c:forEach>
            </div>
            </div>
            <div class="flex-row">
              <div class="flex-header">타입점 쇼핑몰</div>
            <div class="flex-content">
               <input type="text" name="inbrand_othershop" size="100"/>
            </div>
            </div>
         <div class="flex-row">
              <div class="flex-header">파일 첨부</div>
            <div class="flex-content">
               <input type="file" name="inbrand_file"/>
               <input type="hidden" name="mer_num" value="${mer_num}">
            </div>
            </div>
         </div>
      <div class="button-container">
         <button type="button" onclick="check(f.inbrand_file)">다음</button>
      </div>
   </form>
</div>
</div>
</body>
<%@ include file="../main/mainBottom.jsp" %>
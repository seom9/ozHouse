<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- 장바구니 스크립트 -->
<script type="text/javascript">
function goCart() {
   var qtyInput = document.querySelector("button[id='quantity']");
   var value = qtyInput.textContent;
   window.location.href = "CartAdd_main.do?product_num=" + ${param.num} + "&order_count=" + value;
}

function goOrder() {
   var result = confirm("장바구니 상품을 포함하여 주문하시겠습니까?");
   if (result) {
      var qtyInput = document.querySelector("button[id='quantity']");
      var value = qtyInput.textContent;
      window.location.href = "Order_main.do?mode=all&product_num=" + ${param.num} + "&order_count=" + value;
   } else {
      var qtyInput = document.querySelector("button[id='quantity']");
      var value = qtyInput.textContent;
      window.location.href = "Order_main.do?mode=one&product_num=" + ${param.num}   + "&order_count=" + value;
   }
}

function showChoose() {
   var result = confirm("진행하시겠습니까?"); // '예'를 선택하면 true, '아니오'를 선택하면 false 반환

   if (result) {
      // '예'를 선택한 경우
      console.log("사용자가 '예'를 선택했습니다. login.do로 이동합니다.");
      window.location.href = 'login.do'; // 사용자를 login.do로 리디렉션
   } else {
      // '아니오'를 선택한 경우
      console.log("사용자가 '아니오'를 선택했습니다.");
      // '아니오'를 선택했을 때의 동작을 여기에 작성할 수 있습니다.
   }
}
</script>
</body>
</html>
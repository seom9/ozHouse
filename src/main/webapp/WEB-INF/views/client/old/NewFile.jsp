<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- ��ٱ��� ��ũ��Ʈ -->
<script type="text/javascript">
function goCart() {
   var qtyInput = document.querySelector("button[id='quantity']");
   var value = qtyInput.textContent;
   window.location.href = "CartAdd_main.do?product_num=" + ${param.num} + "&order_count=" + value;
}

function goOrder() {
   var result = confirm("��ٱ��� ��ǰ�� �����Ͽ� �ֹ��Ͻðڽ��ϱ�?");
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
   var result = confirm("�����Ͻðڽ��ϱ�?"); // '��'�� �����ϸ� true, '�ƴϿ�'�� �����ϸ� false ��ȯ

   if (result) {
      // '��'�� ������ ���
      console.log("����ڰ� '��'�� �����߽��ϴ�. login.do�� �̵��մϴ�.");
      window.location.href = 'login.do'; // ����ڸ� login.do�� ���𷺼�
   } else {
      // '�ƴϿ�'�� ������ ���
      console.log("����ڰ� '�ƴϿ�'�� �����߽��ϴ�.");
      // '�ƴϿ�'�� �������� ���� ������ ���⿡ �ۼ��� �� �ֽ��ϴ�.
   }
}
</script>
</body>
</html>
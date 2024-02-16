<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <!-- iamport.payment.js -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
    <script>
        var IMP = window.IMP; 
        IMP.init("imp45683405"); 
    
        function requestPay() {
            IMP.request_pay({
                pg : 'kakaopay',
                pay_method : 'card',
                merchant_uid: "merchant_"+new Date().getTime(),
                name : 'ȣ�� 10kg',
                amount : 100,
                buyer_email : 'Iamport@chai.finance',
                buyer_name : '��Ʈ�� ���������',
                buyer_tel : '010-1234-5678',
                buyer_addr : '����Ư���� ������ �Ｚ��',
                buyer_postcode : '123-456'
            }, function (rsp) { // callback
            	console.log(rsp);
            	if (rsp.success){
	            	var msg = '������ �Ϸ�Ǿ����ϴ�.';
			        msg += '����ID : ' + rsp.imp_uid;
			        msg += '���� �ŷ�ID : ' + rsp.merchant_uid;
			        msg += '���� �ݾ� : ' + rsp.paid_amount;
			        msg += '�̸� : ' + rsp.name;
			        alert(msg)
            	}else {
            		alert("�������!!")
            	}
            });
        }
    </script>
    
<a href="javascript:requestPay()">����</a>
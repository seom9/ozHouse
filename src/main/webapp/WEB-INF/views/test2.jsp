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
                name : '호떡 10kg',
                amount : 100,
                buyer_email : 'Iamport@chai.finance',
                buyer_name : '포트원 기술지원팀',
                buyer_tel : '010-1234-5678',
                buyer_addr : '서울특별시 강남구 삼성동',
                buyer_postcode : '123-456'
            }, function (rsp) { // callback
            	console.log(rsp);
            	if (rsp.success){
	            	var msg = '결제가 완료되었습니다.';
			        msg += '고유ID : ' + rsp.imp_uid;
			        msg += '상점 거래ID : ' + rsp.merchant_uid;
			        msg += '결제 금액 : ' + rsp.paid_amount;
			        msg += '이름 : ' + rsp.name;
			        alert(msg)
            	}else {
            		alert("결재실패!!")
            	}
            });
        }
    </script>
    
<a href="javascript:requestPay()">결재</a>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 스토어관리 메인 top -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/top.css">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700|Montserrat:400,700&display=swap" rel="stylesheet">
<html>
<head>
    <style>
        .partner-center {
            margin-left: 10px;
        }

        header img.oz-logo {
            width: 100px; 
            height: 50px;
        }
    </style>
    <script type="text/javascript">
		function logout(){
			if(window.confirm("로그아웃 하시겠습니까?")){
				location.href = "merchant_logout.do";
			}
		}
	</script>
</head>
<body>

<header>
    <a href="merchant_main.do">
        <img src="resources/merchant/img/ozlogo3.png" width="100" height="100">
        <img src="resources/merchant/img/oz3.png" class="oz-logo">
    </a>
    <a href="#">
    	<span class="partner-center">스토어관리</span>
    </a>
    <div class="logout-container">
        <a href="main.do" class="main-button">OZ의집 가기</a>
    
    	<a href="javascript:logout()" class="logout-button">로그아웃</a>
    </div>
</header>
    

<div class="tab-navigation">
    <a href="main_storeManagement.do?mer_num=${merchantLoginMember.mer_num }" class="tab-link">관리홈</a>
    <a href="productManagement_management.do?mer_num=${merchantLoginMember.mer_num }" class="tab-link">상품관리</a>
    <a href="deliveryList.do?mer_num=${merchantLoginMember.mer_num }&mode=all" class="tab-link">주문배송</a>
    <a href="returnCancle_returnList.do?mer_num=${merchantLoginMember.mer_num }&order_orderlike=return" class="tab-link">환불/교환</a>
    <a href="board_board.do?mer_num=${merchantLoginMember.mer_num }" class="tab-link">문의/후기</a>
    <a href="coupon_insert.do?mer_num=${merchantLoginMember.mer_num }" class="tab-link">쿠폰관리</a>
    <a href="sales_list.do?mer_num=${merchantLoginMember.mer_num }&mode=day" class="tab-link">매출관리</a>
</div>
<script>
document.addEventListener('DOMContentLoaded', function () {
    const tabs = document.querySelectorAll('.tab-link');
    tabs.forEach(tab => {
        tab.addEventListener('click', function () {
            tabs.forEach(t => t.classList.remove('active-tab'));
            this.classList.add('active-tab');
        });
    });
});
</script>
</body>


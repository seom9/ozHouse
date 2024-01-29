<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 환불/교환 top -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/top.css">
<html>
<body>
	<div class="tab-container">
		<a href="returnCancle_returnList.do?mer_num=${merchantLoginMember.mer_num}&order_orderlike=return" class="tab-link">환불 리스트</a> 
		<a href="returnCancle_returnList.do?mer_num=${merchantLoginMember.mer_num}&order_orderlike=exchange" class="tab-link">교환 리스트</a>
	</div>
</body>
</html>
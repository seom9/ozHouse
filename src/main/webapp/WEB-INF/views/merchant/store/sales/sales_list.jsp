<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 매출관리 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/top.css">
<link rel="stylesheet" type="text/css" href="resources/merchant/css/sales_style.css">
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="sales_top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<title>OZ의 집 : 매출관리</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
  $( function() {  //html화면이 열리면 function함수가 동작 준비를 함 =>$(document).ready(function(){});과 같
    $( "#startDate" ).datepicker({
    	changeMonth: true,
    	changeYear: true,
    	nextText: '다음 달',
    	prevText: '이전 달',
    	dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
    	dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    	monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    	monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    	dateFormat: "y/mm/dd",
    	maxDate: 0, //선택 가능한 최소날짜, 0: 오늘 이후 선택 불가
    	onClose: function( selectedDate ) {                          
   		//시작일(startDate) datepicker가 닫힐때                      
   		//종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정                     
   		$("#endDate").datepicker( "option", "minDate", selectedDate );                 
    	}	
    });
  });
  $( function() {
    $( "#endDate" ).datepicker({
    	changeMonth: true,
    	changeYear: true,
    	nextText: '다음 달',
    	prevText: '이전 달',
    	dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
    	dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    	monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    	monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    	dateFormat: "y/mm/dd",
    	maxDate: 0, //선택 가능한 최소날짜, 0: 오늘 이후 선택 불가
    	onClose: function( selectedDate ) {                          
   		//시작일(startDate) datepicker가 닫힐때                      
   		//종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정                     
   		$("#endDate").datepicker( "option", "maxDate", selectedDate );                 
    	}
    });
  });
</script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawVisualization);
		
    var date = ${date};
    var cal = ${cal};
    var coupon = ${coupon};
    var dis = [];
    var realCal[];
    var reMoney[];
    
    function drawChart() {
    var data = google.visualization.arrayToDataTable([
          ['Month', '총매출액', '쿠폰할인', '행사할인', '순매출액', '환불금액'],
          ['2004/05',  165,      938,    522,       450,      614.6],
          ['2005/06',  135,      1120,   599,       288,      682],
          ['2006/07',  157,      1167,   587,       397,      623],
          ['2007/08',  139,      1110,   615,       215,      609.4],
          ['2008/09',  136,      691,    629,       366,      569.6]
        ]);
    var options = {
          title : '조회조건별 매출 그래프',
          vAxis: {title: ''},
          hAxis: {title: ''},
          seriesType: 'bars',
          series: {4: {type: 'line'}}
    };
    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
    chart.draw(data, options);
	}
</script>
</head>
<body>
<div class="container">
    <div class="content-container">
        <h1 class="sales-header">
            매출 내역
     		<span class="sales-subtitle">현재까지 판매한 매출내역을 확인할 수 있습니다.</span>
		</h1>
	 	<div class="flex-container">
			<div class="flex-item">
		         <p class="info-text red-text">
		             • 개인정보는 배송 이외의 목적으로 사용을 금하며, 개인정보를 PC에 다운로드하는 경우 반드시 암호화 저장해야 합니다.<br>
		             • OZ의 집 이용 수수료는 상품금액 + 조립비 후 쿠폰할인, 행사할인을 차감한 후의 20%입니다.<br>
		              - 산식: (상품금액 + 조립비 - 쿠폰할인 - 행사할인) x 20%
		         </p>
		         <p class="info-text">
		             • 고객이 사용한 포인트는 OZ의 집에서 모두 부담하므로, 정산에 포함되지 않습니다.<br>
		             • 정산에 포함되는 내역은 귀속월의 배송완료, 배송중인 내역으로, 월이 다른 환불은 각각 발생월에 귀속됩니다.<br><br>
		         </p>
	   		</div>
	   		<c:set var="mer_num" value="${merchantLoginMember.mer_num}"/>
			<form name="f" action="sales_list.do?mer_num=${mer_num}" class="flex-container" method="post"><!-- 로그인 연결하면 mer_num 수정하기 -->
				<div class="flex-row">
		    		<c:if test="${map.mode eq 'day'}">
				        <div class="flex-cell header-cell query-date-label">조회일</div>
				        <div class="flex-cell input-cell">
				            <input type="text" id="startDate" name="startDate" value="${map.startDate}"> ~ 
				            <input type="text" id="endDate" name="endDate" value="${map.endDate}">
				            <input type="hidden" name="mode" value="day">
				            <input type="submit" value="검색">
	            		</div>
		    		</c:if>
				    <c:if test="${map.mode eq 'month'}">
			            <div class="flex-cell header-cell">조회월</div>
			            <div class="flex-cell input-cell">
				            <select name="sYear" class="custom-select">${options.syOptions}</select>
				            <select name="sMonth" class="custom-select">${options.smOptions}</select> ~
				            <select name="eYear" class="custom-select">${options.eyOptions}</select>
				            <select name="eMonth" class="custom-select">${options.emOptions}</select>
				            <input type="hidden" name="mode" value="month">
				            <input type="submit" value="검색">
				        </div>
				    </c:if>
				    <c:if test="${map.mode eq 'year'}">
				        <div class="flex-cell header-cell">조회년</div>
			            <div class="flex-cell input-cell">
				            <select name="sYear" class="custom-select">${options.syOptions}</select> ~
				            <select name="eYear" class="custom-select">${options.eyOptions}</select>
				            <input type="hidden" name="mode" value="year">
				            <input type="submit" value="검색">
				        </div>
				    </c:if>
		    	</div>
			</form>
			<br>
			<div align="left" class="results-heading">
				<c:if test="${ map.mode eq 'day' }">
					<font size="5">- 일별 조회</font>
					<br><br>
					<div class="scroll flex-container content-table full-width-table">
						<div class="flex-row header-row">
							<div class="flex-cell">주문번호<div class="sub-header">ID</div></div>
			            	<div class="flex-cell">주문일<div class="sub-header">취소일</div></div>
			            	<div class="flex-cell">총 수량</div>
							<div class="flex-cell">상품가액</div>
							<div class="flex-cell">조립비</div>
							<div class="flex-cell">쿠폰할인</div>
							<div class="flex-cell">행사할인</div>
							<div class="flex-cell">수수료</div>
							<div class="flex-cell">순매출</div>
							<div class="flex-cell">상태</div>
						</div>
						<c:if test="${empty salesList}">
							<div class="flex-row">
								<div class="flex-cell">조회결과가 없습니다.</div>
							</div>
						</c:if>
						<c:forEach var="dto" items="${salesList}">
							<c:set var="plus" value="${dto.product_price + dto.product_assembly_cost}"/>
							<c:set var="minus" value="${dto.order_dis_coupon + dto.order_dis_discount}"/>
							<c:set var="charge" value="${(plus - minus) * 0.2}"/>
							<c:set var="calculate" value="${plus - minus - charge}"/>
							<div class="flex-row">
			                	<div class="flex-cell">${dto.order_code}
			               			<div class="flex-cell">${dto.member_id}</div>
			                	</div>
	                			<div class="flex-cell">${dto.order_date}
					               	<c:if test="${dto.order_canceldate eq '0'}">
					               		<div class="flex-cell">-</div>
					               	</c:if>
					               	<c:if test="${dto.order_canceldate ne '0'}">
					                   	<div class="flex-cell">${dto.order_canceldate}</div>
					                </c:if>
	               				</div>
				                <div class="flex-cell">
				                    <fmt:formatNumber value="${dto.order_count}" type="number" pattern="###,###"/>
				                </div>
				                <div class="flex-cell">
									<fmt:formatNumber value="${dto.product_price}" type="number" pattern="###,###"/>
				                </div>
				                <div class="flex-cell">
									<fmt:formatNumber value="${dto.product_assembly_cost}" type="number" pattern="###,###"/>
				                </div>
				                <div class="flex-cell">
									<fmt:formatNumber value="${dto.order_dis_coupon}" type="number" pattern="###,###"/>
				                </div>
				                <div class="flex-cell">
									<fmt:formatNumber value="${dto.order_dis_discount}" type="number" pattern="###,###"/>
				                </div>
				                <div class="flex-cell">
									<fmt:formatNumber value="${charge}" type="number" pattern="###,###"/>
				                </div>
				                <div class="flex-cell">
									<fmt:formatNumber value="${calculate}" type="number" pattern="###,###"/>
				                </div>
								<div class="flex-cell">
									<c:choose>
										<c:when test="${dto.order_orderlike eq 'exchange'}">
											<div class="flex-cell">교환</div>
										</c:when>
										<c:when test="${dto.order_orderlike eq 'return'}">
											<div class="flex-cell">환불</div>
										</c:when>
										<c:otherwise>
											<div class="flex-cell">정상주문</div>
										</c:otherwise>
									</c:choose>
								</div>
								<c:set var="allproduct_price" value="${allproduct_price + dto.product_price}"/>
								<c:set var="allProduct_assembly_cost" value="${allProduct_assembly_cost + dto.product_assembly_cost}"/>
								<c:set var="allOrder_dis_coupon" value="${allOrder_dis_coupon + dto.order_dis_coupon}"/>
								<c:set var="allOrder_dis_discount" value="${allOrder_dis_discount + dto.order_dis_discount}"/>
								<c:set var="allCharge" value="${allCharge + charge}"/>
								<c:set var="allCalcul" value="${allCalcul + calculate }"/>
								</div>
							</c:forEach>
						</div>
					</c:if>
				</div>
				<div align="left" class="results-heading">
					<c:if test="${ map.mode eq 'month' }">
						<font size="5">- 월별 조회</font>
						<br><br>
						</div>
						<div class="scroll flex-container content-table full-width-table">
					    	<div class="flex-row header-row">
								<div class="flex-cell">매출월</div>
								<div class="flex-cell">총매출</div>
								<div class="flex-cell">조립비</div>
								<div class="flex-cell">쿠폰할인</div>
								<div class="flex-cell">행사할인</div>
								<div class="flex-cell">수수료</div>
								<div class="flex-cell">순매출</div>
							</div>
							<c:if test="${empty salesList}">
								<div class="flex-row">
									<div class="flex-cell">조회결과가 없습니다.</div>
								</div>
							</c:if>
							<c:forEach var="dto" items="${salesList}">
								<c:set var="plus" value="${dto.product_price + dto.product_assembly_cost}"/>
								<c:set var="minus" value="${dto.order_dis_coupon + dto.order_dis_discount}"/>
								<c:set var="charge" value="${(plus - minus) * 0.2}"/>
								<c:set var="calculate" value="${plus - minus - charge}"/>
								<div class="flex-row">
					                <div class="flex-cell">${dto.order_date}</div>
					                <div class="flex-cell"><fmt:formatNumber value="${dto.product_price}" type="number" pattern="###,###"/></div>
					                <div class="flex-cell"><fmt:formatNumber value="${dto.product_assembly_cost}" type="number" pattern="###,###"/></div>
					                <div class="flex-cell"><fmt:formatNumber value="${dto.order_dis_coupon}" type="number" pattern="###,###"/></div>
					                <div class="flex-cell"><fmt:formatNumber value="${dto.order_dis_discount}" type="number" pattern="###,###"/></div>
			           				<div class="flex-cell"><fmt:formatNumber value="${charge}" type="number" pattern="###,###"/></div>
					                <div class="flex-cell"><fmt:formatNumber value="${calculate}" type="number" pattern="###,###"/></div>
				                </div>
								<c:set var="allproduct_price" value="${allproduct_price + dto.product_price}"/>
								<c:set var="allProduct_assembly_cost" value="${allProduct_assembly_cost + dto.product_assembly_cost}"/>
								<c:set var="allOrder_dis_coupon" value="${allOrder_dis_coupon + dto.order_dis_coupon}"/>
								<c:set var="allOrder_dis_discount" value="${allOrder_dis_discount + dto.order_dis_discount}"/>
								<c:set var="allCharge" value="${allCharge + charge}"/>
								<c:set var="allCalcul" value="${allCalcul + calculate }"/>
							</c:forEach>
						</div>
					</c:if>
				<div align="left" class="results-heading">
					<c:if test="${ map.mode eq 'year' }">
		    			<font size="5">- 연별조회</font>
		    			<br><br>
						</div>
						<div class="scroll flex-container content-table full-width-table">
						    <div class="flex-row header-row">
								<div class="flex-cell">매출년</div>
								<div class="flex-cell">총매출</div>
								<div class="flex-cell">조립비</div>
								<div class="flex-cell">쿠폰할인</div>
								<div class="flex-cell">행사할인</div>
								<div class="flex-cell">수수료</div>
								<div class="flex-cell">순매출</div>
							</div>
							<c:if test="${empty salesList}">
								<div class="flex-row">
									<div class="flex-cell">조회결과가 없습니다.</div>
								</div>
							</c:if>
							<c:forEach var="dto" items="${salesList}">
								<c:set var="plus" value="${dto.product_price + dto.product_assembly_cost}"/>
								<c:set var="minus" value="${dto.order_dis_coupon + dto.order_dis_discount}"/>
								<c:set var="charge" value="${(plus - minus) * 0.2}"/>
								<c:set var="calculate" value="${plus - minus - charge}"/>
								<div class="flex-row">
					                <div class="flex-cell">${dto.order_date}</div>
					                <div class="flex-cell"><fmt:formatNumber value="${dto.product_price}" type="number" pattern="###,###"/></div>
					                <div class="flex-cell"><fmt:formatNumber value="${dto.product_assembly_cost}" type="number" pattern="###,###"/></div>
					                <div class="flex-cell"><fmt:formatNumber value="${dto.order_dis_coupon}" type="number" pattern="###,###"/></div>
					                <div class="flex-cell"><fmt:formatNumber value="${dto.order_dis_discount}" type="number" pattern="###,###"/></div>
									<div class="flex-cell"><fmt:formatNumber value="${charge}" type="number" pattern="###,###"/></div>
					                <div class="flex-cell"><fmt:formatNumber value="${calculate}" type="number" pattern="###,###"/></div>
					               	<c:set var="allproduct_price" value="${allproduct_price + dto.product_price}"/>
									<c:set var="allProduct_assembly_cost" value="${allProduct_assembly_cost + dto.product_assembly_cost}"/>
									<c:set var="allOrder_dis_coupon" value="${allOrder_dis_coupon + dto.order_dis_coupon}"/>
									<c:set var="allOrder_dis_discount" value="${allOrder_dis_discount + dto.order_dis_discount}"/>
									<c:set var="allCharge" value="${allCharge + charge}"/>
									<c:set var="allCalcul" value="${allCalcul + calculate }"/>
								</div>
							</c:forEach>
						</div>
					</c:if>
					<p>
					<div align="left" class="results-heading">
						<br>
					    <font size="5">- 총계</font>
					    <br><br>
					</div>
					<div class="scroll flex-container content-table full-width-table">
					    <div class="flex-row header-row">
					        <div class="flex-cell">총매출(A)</div>
					        <div class="flex-cell">총조립비(B)</div>
					        <div class="flex-cell">C (A+B)</div>
					        <div class="flex-cell">총쿠폰할인(D)</div>
					        <div class="flex-cell">총행사할인(E)</div>
					        <div class="flex-cell">총수수료(F)</div>
					        <div class="flex-cell">총순매출<br>C-(D+E+F)</div>
					    </div>
					    <div class="flex-content">
						    <c:choose>
						        <c:when test="${empty salesList}">
						            <div class="flex-row">
						                <div class="flex-cell">조회결과가 없습니다.</div>
						            </div>
						        </c:when>
								<c:otherwise>
									<div class="flex-row">
									    <div class="flex-cell"><fmt:formatNumber value="${allproduct_price}" type="number" pattern="###,###원"/></div>
									    <div class="flex-cell"><fmt:formatNumber value="${allProduct_assembly_cost}" type="number" pattern="###,###원"/></div>
									    <div class="flex-cell"><fmt:formatNumber value="${allproduct_price + allProduct_assembly_cost}" type="number" pattern="###,###원"/></div>
									    <div class="flex-cell"><fmt:formatNumber value="${allOrder_dis_coupon}" type="number" pattern="###,###원"/></div>
									    <div class="flex-cell"><fmt:formatNumber value="${allOrder_dis_discount}" type="number" pattern="###,###원"/></div>
									    <div class="flex-cell"><fmt:formatNumber value="${allCharge}" type="number" pattern="###,###원"/></div>
									    <div class="flex-cell"><fmt:formatNumber value="${allCalcul}" type="number" pattern="###,###원"/></div>
									</div>
						    	</c:otherwise>
						    </c:choose>
						</div>	
					</div>    
				</div>
			</div>
		</div>
	</div>
</body>

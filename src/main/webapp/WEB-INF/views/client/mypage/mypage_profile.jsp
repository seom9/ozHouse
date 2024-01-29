<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ include file="mypage_top.jsp" %>
<link rel="stylesheet" href="${path}/resources/mypage.css"/>
<link rel="stylesheet" href="${path}/resources/login.css"/>
<br><br><br>
<div class="user-profile"><div class="profile-box">
  <div class="profile-header">
    <div class="sticky-container">
      <div class="sticky-child">
        <div class="profile-actions">
          <button type="button" aria-pressed="false" aria-label="공유" class="share-button">
            <svg width="24" height="24" viewBox="0 0 24 24" fill="currentColor">
              <path d="M9.64 14.646a4.5 4.5 0 1 1 0-5.292l4.54-2.476a4.5 4.5 0 1 1 .63.795l-4.675 2.55c.235.545.365 1.146.365 1.777s-.13 1.232-.365 1.777l4.675 2.55a4.5 4.5 0 1 1-.63.795l-4.54-2.476zM18 8a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7zM6 15.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7zM18 23a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"></path>
            </svg>
          </button>
        </div>
        <div class="profile-info">
          <div class="username">
			<c:if test="${empty member.member_image}">
			    <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/default_images/avatar.png?gif=1&w=144&h=144&c=c&webp=1" alt="User Avatar">
			</c:if>
			<c:if test="${not empty member.member_image}">
				<c:if test="${fn:startsWith(member.member_image, 'http')}">
		        	<img src="${member.member_image}" width="100%" height="100%">
				</c:if>
				<c:if test="${not fn:startsWith(member.member_image, 'http')}">
		        	<img src="${path}/resources/image/${member.member_image}" width="100%" height="100%">
				</c:if>
			</c:if>

          </div>
          <div class="user-details">
            <div class="username">${member.member_nickname}</div>
            <div class="follower-info">
              <dl>
                <dt>팔로워 <a class="follow" href="/users/7228692/follower">0</a> 팔로잉 <a class="follow" href="/users/7228692/followee">0</a></dt>
              </dl>
            </div>
            <div class="profile">
              <button onclick="location.href='member_update.do'" class="edit-profile">설정</button>
              <div class="reward-section">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    </div>
	<div class="css-1049nre epl9oik0">
		<div class="css-134c4us ekeuxnk0">
		<div class="logoProfile1">
			<div class="logoProfile">
				<a class="css-1p9dybm e1q26atk3" href="mypage_scrapbook.do">
					<svg width="24" height="24" viewBox="0 0 24 24" fill="currentColor" preserveAspectRatio="xMidYMid meet" data-darkreader-inline-fill="" style="--darkreader-inline-fill: currentColor;">
						<path fill-rule="evenodd" transform="matrix(1 0 0 -1 0 23.033)" d="M12.943 6.342a2 2 0 0 1-1.886 0L3 2.032V20.5a.5.5 0 0 0 .5.5h17a.5.5 0 0 0 .5-.5V2.033l-8.057 4.309zm-.471-.882l8.056-4.31A1 1 0 0 1 22 2.034V20.5a1.5 1.5 0 0 1-1.5 1.5h-17A1.5 1.5 0 0 1 2 20.5V2.033a1 1 0 0 1 1.472-.882l8.056 4.31a1 1 0 0 0 .944 0z"></path>
					</svg><br>
					 	스크랩북<br>
						
				</a>
			</div>
			<div class="logoProfile">
				<a class="css-1p9dybm e1q26atk3" href="mypage_point.do">	      
					<svg width="24" height="24" viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet">
						<path fill="currentColor" d="M22.971 7.638c-.548-5.17-7.119-7.135-10.57-2.488a.5.5 0 0 1-.802 0C8.148.503 1.577 2.469 1.029 7.625.642 12.451 3.897 17.183 12 21.436c8.104-4.252 11.36-8.984 10.972-13.798zm.996-.093c.428 5.319-3.137 10.446-11.738 14.899a.5.5 0 0 1-.46 0C3.169 17.99-.395 12.864.034 7.532.656 1.67 7.904-.683 12 4.052 16.096-.683 23.344 1.67 23.967 7.545z" data-darkreader-inline-fill="" style="--darkreader-inline-fill: currentColor;"></path>
					</svg><br>	     
						포인트<br>
						
				</a>
			</div>
			<div class="logoProfile">
				<a class="css-1p9dybm e1q26atk3" href="mypage_coupon.do">
					<svg width="24" height="24" viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet">
						<path fill="#424242" fill-rule="nonzero" d="M22.588 3H1.413C.633 3 0 3.638 0 4.426L0 9.53l.605-.088c.12-.017.243-.026.367-.026 1.413 0 2.558 1.157 2.558 2.584S2.385 14.584.972 14.584c-.124 0-.247-.009-.367-.026L0 14.47l.001 5.104C.001 20.362.633 21 1.413 21h21.175c.78 0 1.412-.638 1.412-1.426V4.426C24 3.638 23.368 3 22.588 3zM1.413 4.07h21.175c.195 0 .353.159.353.356v15.148c0 .197-.158.357-.353.357H1.413l-.071-.008c-.161-.033-.282-.176-.282-.349l-.002-3.923-.086.002c1.997 0 3.617-1.635 3.617-3.653l-.004-.182C4.493 9.945 3.006 8.443 1.152 8.35l-.094-.003.002-3.922c0-.197.158-.357.353-.357zm14.646 2.138c.293 0 .53.237.53.53v1.614c0 .292-.237.53-.53.53-.292 0-.53-.238-.53-.53V6.737c0-.292.238-.53.53-.53zm0 4.455c.293 0 .53.237.53.53v1.614c0 .293-.237.53-.53.53-.292 0-.53-.237-.53-.53v-1.614c0-.293.238-.53.53-.53zm0 4.456c.293 0 .53.237.53.53v1.614c0 .292-.237.53-.53.53-.292 0-.53-.238-.53-.53v-1.615c0-.292.238-.53.53-.53z" data-darkreader-inline-fill="" style="--darkreader-inline-fill: #beb9b0;"></path>
					</svg><br>
						내 쿠폰<br>
						
				</a>
			</div>
			
		</div>
	</div>	

  </div>
  <div class="content-section">
  </div>
</div>

</body>
</html>
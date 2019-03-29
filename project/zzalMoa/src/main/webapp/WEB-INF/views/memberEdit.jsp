<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
<jsp:include page="${headerPage}"></jsp:include>
<div id="cnt">
	<div class="member_join_area">
		<form action="member.update" method="post" enctype="multipart/form-data">
			<input class="inp" type="text" name="mb_id" placeholder="아이디" value="${sessionScope.loginMember.mb_id}">
			<input class="inp" type="text" name="mb_name" placeholder="닉네임" value="${sessionScope.loginMember.mb_name}">
			<input class="inp" type="password" name="mb_pw" placeholder="비밀번호">
			<input class="inp" type="password" name="mb_pw2" placeholder="비밀번호 재입력">
			<div class="img_box">
				<c:set var="lm" value="${sessionScope.loginMember}"/>
	   			<c:choose>
	   				<c:when test="${lm.mb_photo eq 'none_photo.jpg'}">
	   				   <img src="resources/img/none_photo.jpg">
	   				</c:when>
	   				<c:when test="${lm.mb_photo ne 'none_photo.jpg'}">
	   				   <img src="resources/photo/${lm.mb_photo}">
	   				</c:when>
	   			</c:choose>			
			</div>
			<input type="file" name="mb_photo" onchange="LoadImg(this);">
			<button>정보수정</button>
		</form>
		<a href="#" onclick="memberDel('${sessionScope.loginMember.mb_id}');">회원탈퇴</a>
	</div>
</div>
</body>
</html>
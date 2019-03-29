<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="${headerPage}"></jsp:include>
<div id="cnt">
	<div class="member_join_area">
		<form action="memberWrite" name="memberForm" onsubmit="return memberCheck();" method="post" enctype="multipart/form-data">
			<input class="inp" type="text" name="mb_id" placeholder="아이디"><a href="javascript:void(0);" onclick="idOverlapCheck();" class="idcheck">중복확인</a>
			<input class="inp" type="text" name="mb_name" placeholder="닉네임">
			<input class="inp" type="password" name="mb_pw" placeholder="비밀번호">
			<input class="inp" type="password" name="mb_pw2" placeholder="비밀번호 재입력">
			<div class="img_box">
				<img src="resources/img/none_photo.jpg" class="change_img">				
			</div>
			<input type="file" name="mb_photo" onchange="LoadImg(this);">
			<button>회원가입</button>
		</form>
	</div>
</div>
</body>
</html>
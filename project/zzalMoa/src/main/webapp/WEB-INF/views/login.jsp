<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="${headerPage}"></jsp:include>
    
<div id="cnt">
	<div class="login_area">
		<form action="login.check" method="post">
			<input class="name" type="text" name="mb_id" placeholder="아이디">
			<input class="password" type="password" name="mb_pw" placeholder="비밀번호">
			<input id="autoLogin" class="checkbox" type="checkbox" name="mb_auto"><label for="autoLogin">자동로그인</label>
			<button>로그인</button>
			<a href="newJoin.go" class="member_join">회원가입</a>
		</form>
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="${headerPage}"></jsp:include>

<div id="cnt">
	<div class="file_upload_area">
		<form action="photoWrite" name="photoForm" method="post" enctype="multipart/form-data" onsubmit="return photoUploadCheck();">
			<div class="img_box">
				<img src="resources/img/none_photo.jpg" class="change_img">
			</div>
			<input type="file" name="pl_photo" onchange="LoadImg(this);">
			<input type="text" name="pl_tag" class="tag" placeholder="태그 태그 태그">
			<span class="notice1">태그는 띄어쓰기로 구별됩니다.</span>
			<button>파일업로드</button>
			<span class="notice2">이미지는 관리자 확인 후 개시됩니다.</span>
		</form>
	</div>
</div>
</body>
</html>
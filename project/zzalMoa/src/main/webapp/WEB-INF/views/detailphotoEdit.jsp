<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:include page="${headerPage}"></jsp:include>

<div id="cnt">
	<div class="search_area">
		<div class="search_form">
			<form action="photolist.search">
				<input type="text" name="pl_tag" placeholder="태그를 입력해주세요" value="${searchTag}">
				<button>검색</button>
			</form>
		</div>
		<div class="tag_list">
		</div>
	</div>
	<script type="text/javascript">
		tagList('${tag.tag_list}');
	</script>
	<div class="detailphoto_area">
		<div>
			<div class="list_img_box">
				<p>대표이미지</p>
					<c:choose>
						<c:when test="${detailPhoto.pl_thumbnail ne '0'}">
							<img class="change_img" src="resources/photo/${detailPhoto.pl_thumbnail}">
						</c:when>
						<c:when test="${detailPhoto.pl_thumbnail eq '0'}">
							<img class="change_img" src="resources/img/none_file.png">
						</c:when>
					</c:choose>
				<div>
					<form action="thumbnail.upload" method="post" name="thumbnailForm" onsubmit="return thumbnailCheck();" enctype="multipart/form-data">
						<input type="hidden" value="${detailPhoto.pl_number}" name="pl_number">
						<input type="file" name="pl_thumbnail"  onchange="LoadImg(this);">
						<button>수정</button>			
					</form>
				</div>
			</div>
			<div class="img_box">
				<p>상세이미지</p>
				<img src="resources/photo/${detailPhoto.pl_photo}">
			</div>
			<div class="tag_list" data-master="${sessionScope.loginMember.mb_master}">
				<script type="text/javascript">
					tagEdit("${detailPhoto.pl_tag}");
				</script>
			</div>
			<div class="edit_box">
				<input type="hidden" value="${detailPhoto.pl_number}" name="pl_number" class="pl_number">
				<input type="hidden" value="${detailPhoto.pl_tag}" name="pl_tag_basic" class="pl_tag_basic">
				<input type="text" name="pl_tag" placeholder="태그를 추가해주세요" class="pl_tag" onkeyup="enterkey();"><button onclick="return tagUploadCheck();">태그추가</button>
				<a href="photo.del?pl_number=${detailPhoto.pl_number}" class="btn_del">이 글 삭제</a>
			</div>
		</div>
	</div>
	<div class="photo_list">
		<ul class="clear" data-page='${pageCount}'>
		</ul>
	</div>
</div>
<script>
listScroll();
</script>
</body>
</html>
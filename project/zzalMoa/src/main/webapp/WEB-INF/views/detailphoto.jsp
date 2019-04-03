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
			<div class="img_box">
				<img src="resources/photo/${detailPhoto.pl_photo}">
				<div class="notice">* 누르면 원본사이즈</div>
			</div>
			<div class="tag_list">
				<script type="text/javascript">
					tag("${detailPhoto.pl_tag}");
				</script>
			</div>
			<div class="edit_box">
				<input type="hidden" value="${detailPhoto.pl_number}" name="pl_number" class="pl_number">
				<input type="hidden" value="${detailPhoto.pl_tag}" name="pl_tag_basic" class="pl_tag_basic">
				<input type="text" name="pl_tag" placeholder="태그를 추가해주세요" class="pl_tag"><button onclick="tagUploadCheck();">태그추가</button>	
			</div>
			<div class="down_box">
				<a href='resources/photo/${detailPhoto.pl_photo}' download="${detailPhoto.pl_photo}">저장</a>
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
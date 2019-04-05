<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="${headerPage}"></jsp:include>
<div id="cnt">
	<div class="">
		<h3>검색 태그 세팅</h3>
		<div>
			<form action="master.tagUpdate">
				<input type="text" value="${tag.tag_list}" name="tag_list"><button>수정</button>			
			</form>
		</div>
	</div>
	<div class="master_photo_area">
		<h3>게시글 관리</h3>
		<table class="master_photolist" data-page='${pageCount}'>
			<tr>
				<th class="number">번호</th>
				<th class="thnmbnail">썸네일</th>
				<th class="photo">사진</th>
				<th class="tag">태그</th>
				<th class="view">게시</th>
			</tr>
		</table>
		<!-- <a href="" onclick="" class="more">리스트 더보기</a> -->
	</div>
</div>
<script type="text/javascript">
	masterPage();
	
	$(document).on('click', '.master_photolist .view input', function(){
		var inputCheck = ($(this).is(':checked')) ? "1" : "0";
		var number = $(this).parent().parent().find(".number").html();
		$.getJSON("PhotoView.update?pl_number="+ number +"&pl_view="+ inputCheck, function(data){});
	})
	
</script>
</body>
</html>
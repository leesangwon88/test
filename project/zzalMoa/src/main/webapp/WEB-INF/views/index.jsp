<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
    
<jsp:include page="${headerPage}"></jsp:include>
<div style="position: fixed;z-index: 100; background: #ccc; font-size: 14px;">
<span id="a"></span>
<span id="b"></span>
<span id="c"></span>
</div>
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
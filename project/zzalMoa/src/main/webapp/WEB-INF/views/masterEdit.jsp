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
	<div class="">
		<h3>게시글 관리</h3>
		<table>
			<tr>
				<th>번호</th>
				<th>사진</th>
				<th>썸네일</th>
				<th>태그</th>
				<th>게시</th>
			</tr>
			<tr>
				<td>1</td>
				<td>사진</td>
				<td>썸넬</td>
				<td><input type="text" value="기본 태그세팅"><button>수정</button></td>
				<td><input type="checkbox"></td>
			</tr>
		</table>
	</div>


</div>
</body>
</html>
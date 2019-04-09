<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>짤모아</title>
	<link rel="stylesheet" type="text/css" href="resources/css/reset.css">
	<link rel="stylesheet" type="text/css" href="resources/css/index.css">
	<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="resources/js/index.js"></script>
	<script type="text/javascript" src="resources/js/joinCheck.js"></script>
	<script type="text/javascript" src="resources/js/validCheck.js"></script>
</head>
<body>
<div id="head">
	<h1><a href="main.go" class="title">짤모아넷</a>${r}<!-- <a href=""> : 태그검색</a> --></h1>
	<div class="nev login">
   		<a href="memberEdit.go" class="myinfo">
   			<c:set var="lm" value="${sessionScope.loginMember}"/>
   			<c:choose>
   				<c:when test="${lm.mb_photo eq 'none_photo.jpg'}">
   				   <img src="resources/img/none_photo.jpg" width="30" height="30">
   				</c:when>
   				<c:when test="${lm.mb_photo ne 'none_photo.jpg'}">
   				   <img src="resources/photo/${lm.mb_photo}" width="30" height="30">
   				</c:when>
   			</c:choose>
   			<span>${sessionScope.loginMember.mb_id}</span>
   		</a>
        <a href="logout" class="logout btn">로그아웃</a>
        <c:if test="${lm.mb_master eq '1'}">
        	<a href="master.edit" class="master btn">관리자</a>
        </c:if>
        <a href="fileUpload.go" class="upload btn">사진 업로드</a>
		<!-- <a href="" class="menu btn">목록</a> -->
	</div>
</div>
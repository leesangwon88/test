var idCheck = true;

function memberCheck(){
	var mb_id = document.memberForm.mb_id;
	var mb_name = document.memberForm.mb_name;
	var mb_pw = document.memberForm.mb_pw;
	var mb_pw = document.memberForm.mb_pw;
	var mb_pw2 = document.memberForm.mb_pw2;
	var mb_photo = document.memberForm.mb_photo;
	
	if(isEmpty(mb_id)) {
		alert("아이디를 입력해주세요.");
		mb_id.focus();
		return false;
	} else if(idCheck) {
		alert("ID중복체크를 해주세요.");
		mb_id.focus();
		return false;
	} else if(isEmpty(mb_name)) {
		alert("닉네임을 입력해주세요.");
		mb_name.focus();
		return false;
	} else if(isEmpty(mb_pw)) {
		alert("비밀번호를 입력해주세요.");
		mb_pw.focus();
		return false;
	} else if(isEmpty(mb_pw2)) {
		alert("비밀번호 재입력을 해주세요.");
		mb_pw2.focus();
		return false;
	} else if(notEquals(mb_pw, mb_pw2)){
		alert("비밀번호가 틀립니다. 다시입력해주세요.");	
		pw.focus();
		return false;
	}
	return true;
}


function idOverlapCheck(){
	idCheck = true;
	var mb_id = document.memberForm.mb_id;
	var id = mb_id.value;
	
	if(id == ""){
		alert("아이디를 입력해주세요.");
		mb_id.focus();
		return false;
	}
	
	$.getJSON("idCheck?mb_id="+id, function(data){
		if(data == true){
			alert("이미존재하는 ID입니다.");
			mb_id.focus();
			return false;
		}
		alert("사용가능한 아이디입니다.");
		document.memberForm.mb_name.focus();
		idCheck = false;
	})
}


function thumbnailCheck(){
	var pl_thumbnail = document.thumbnailForm.pl_thumbnail;
	if(isEmpty(pl_thumbnail)){
		alert("사진을 올려주세요.");
		pl_thumbnail.focus();
		return false;
	} else if (isNotType(pl_thumbnail, "gif") && isNotType(pl_thumbnail, "jpg") && isNotType(pl_thumbnail, "png")){
		alert("jpg, gif, png형식의 파일을 올려주세요.");
		pl_thumbnail.focus();
		return false;
	}
	return true;
}

function photoUploadCheck(){
	var pl_photo = document.photoForm.pl_photo;
	var pl_tag = document.photoForm.pl_tag;
	 
	if(isEmpty(pl_photo)){
		alert("사진을 올려주세요.");
		pl_photo.focus();
		return false;
	}else if(isNotType(pl_photo, "gif") && isNotType(pl_photo, "jpg") && isNotType(pl_photo, "png")){
		alert("jpg, gif, png형식의 파일을 올려주세요.");
		pl_photo.focus();
		return false;
	}else if(isEmpty(pl_tag)) {
		alert("최소한 1개의 태그를 입력해주세요.");
		pl_tag.focus();
		return false;
	}
	tagOverlapCheck();
	return true;
}

function tagOverlapCheck(){
	var tagList = $(".file_upload_area .tag").val().split(" ");
	var tagListCheck = [];
	
	$.each(tagList, function(i, el){
		if($.inArray(el, tagListCheck) == -1) tagListCheck.push(el);
	});
	tagListCheck = tagListCheck.join(" ");
	$(".file_upload_area .tag").val(tagListCheck);
}
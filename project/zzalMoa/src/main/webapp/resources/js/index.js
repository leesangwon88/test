var page = 2;
var allPage = null;

$(function(){
	$(".img_box").click(function(){
		$(".img_box").toggleClass("full_size");
	});	
});

function photolistGet(){
	allPage = $(".photo_list > ul").data("page");
	if(allPage >= page){
		$.getJSON("PhotoList.AJAX.get?page="+page, function(data){
			var dp = data.photolist;
			var plHTML = "";
			$.each(dp, function(i, s){
				plHTML += "<li><a href='photoDetail?pl_number="+ s.pl_number +"'>"
				
				if(s.pl_photo.indexOf(".gif") != -1){
					plHTML += "<span class='gif'><span>움짤</span></span>";
				}
				if(s.pl_thumbnail != '0'){
					plHTML +="<img src='resources/photo/" + s.pl_thumbnail + "'>";
				} else {
					plHTML +="<img src='resources/photo/" + s.pl_photo + "'>";
				}
				plHTML += "</a></li>";
			});
			$(".photo_list ul").append(plHTML);
			page++;
		});
	}
}

function tag(data){
	console.log(data);
	var tagList = data.split(" ");
	var addTag = "";
	for (var i = 0; i < tagList.length; i++) {
		if(tagList[i] != ""){
			addTag += '<a href="photolist.search?pl_tag='+ tagList[i] +'">' + tagList[i] +'</a>';
		}
	}
	$(".detailphoto_area .tag_list").html(addTag);
}

function tagEdit(data){
	console.log(data);
	var tagList = data.split(" ");
	var addTag = "";
	for (var i = 0; i < tagList.length; i++) {
		if(tagList[i] != ""){
			addTag += '<a href="photolist.search?pl_tag='+ tagList[i] +'">' + tagList[i] +'</a><a href="#" onclick="tagDel(\''+data+'\',' +  '\'' +tagList[i]+ '\'); return false;" class="del">X</a>';
		}
	}
	$(".detailphoto_area .tag_list").html(addTag);
}

function tagDel(data, del){
	data = data.replace(del, "");
	var pl_number = $(".pl_number").val();
	location.href = "photoTag.upload?pl_number="+ pl_number +"&pl_tag="+ data;
}

function tagUploadCheck(){
	var tagBaisc = $(".pl_tag_basic").val();
	var tagAdds = $(".pl_tag").val();
	var tagAdd = tagAdds.split(" ");
	
	for (var i = 0; i < tagAdd.length; i++) {
		if(tagBaisc.match(tagAdd[i])){
			alert("동일한 태그가 존재합니다.");
			return false;
		}
	}
	
	var tagListCheck = [];
	
	$.each(tagAdd, function(i, el){
		if($.inArray(el, tagListCheck) == -1) tagListCheck.push(el);
	});
	tagListCheck = tagListCheck.join(" ");
	tagAdds = tagListCheck;
	
	
	var pl_number = $(".pl_number").val();
	tagBaisc = tagBaisc + " " + tagAdds;
	location.href = "photoTag.upload?pl_number="+ pl_number +"&pl_tag="+ tagBaisc;
	return true;
}

function LoadImg(value) {
	if(value.files && value.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$(".change_img").attr('src', e.target.result);
		}
		reader.readAsDataURL(value.files[0]);
	}
}


function memberDel(id) {
	var r = confirm("정말 계정을 삭제하시겠습니까?");
	if(r == true){
    var form = document.createElement("form");
    form.setAttribute("charset", "UTF-8");
    form.setAttribute("method", "Post");
    form.setAttribute("action", "member.Del");
    
    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "mb_id");
    hiddenField.setAttribute("value", id);
    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
	}
}










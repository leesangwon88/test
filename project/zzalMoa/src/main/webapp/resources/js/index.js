var page = 1;
var allPage = null;

$(function(){
	$(".img_box").click(function(){
		$(".img_box").toggleClass("full_size");
	});	
});

function listScroll(){
	photolistGet();
	
	var delta = 300;
	var timer = null;
		
	$(window).on('scroll', function(){
		if ($(document).height() <= $(window).scrollTop() + $(window).height() + 100 ){
			clearTimeout(timer);
			timer = setTimeout(photolistGet, delta);
		}
	});
}

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
			if($("body").height() < $(window).height()){
				console.log(231);
				photolistGet();
			}
		});
	}
}

function masterPage(){
	pagePullMaster();
	
	var delta = 300;
	var timer = null;
		
	$(window).on('scroll', function(){
		if ($(document).height() <= $(window).scrollTop() + $(window).height() + 100 ){
			clearTimeout(timer);
			timer = setTimeout(pagePullMaster, delta);
		}
	});
}
function pagePullMaster(){
	allPage = $(".master_photolist").data("page");
	$.getJSON("PhotoList.AJAX.get?page="+page+"&type=master", function(data){
		var dp = data.photolist;
		var plHTML = "";
		console.log(dp);
		$.each(dp, function(i, s){
			plHTML += "<tr><td class='number'>"+ s.pl_number +"</td>";
			if(s.pl_thumbnail == "0"){
				plHTML +="<td class='thnmbnail'>미등록</td>";
			}else{
				plHTML +="<td class='thnmbnail'><img src='resources/photo/" + s.pl_thumbnail + "'></td>";
			}			plHTML +="<td class='photo'><a href='photoDetail?pl_number="+ s.pl_number +"'><img src='resources/photo/" + s.pl_photo + "'></a></td>";
			plHTML += "<td class='tag edit_box'><input name='' value='"+ s.pl_tag +"'><button>수정</button></td>";
			if(s.pl_view == "0"){
				plHTML += "<td class='view'><input type='checkbox' name=''></td>";				
			} else {				
				plHTML += "<td class='view'><input type='checkbox' name='' checked></td>";				
			}
			plHTML += "</tr>";
		});
		$(".master_photolist").append(plHTML);
		page++;	
		if($("body").height() < $(window).height()){
			pagePullMaster();
		}
	});
}

function tagList(data){
	console.log(data);
	var tagList = data.split(" ");
	var addTag = "";
	for (var i = 0; i < tagList.length; i++) {
		if(tagList[i] != ""){
			addTag += '<a href="photolist.search?pl_tag='+ tagList[i] +'">' + tagList[i] +'</a>';
		}
	}
	$(".search_area .tag_list").html(addTag);
}

function tagDel(data, del){
	if(data == del){
		alert("태그는 최소 한개가 존재해야 합니다.")
		return false;
	}
	data = data.replace(del, "");
	data = $.trim(data);
	if(data == null){
		alert("태그는 최소 한개가 존재해야 합니다.")
		return false;
	}
	tagUploadAXJA(data);			
}

function tagUploadCheck(){
	var tagBaiscs = $(".pl_tag_basic").val();
	var tagBaisc = tagBaiscs.split(" ");
	var tagAdds = $(".pl_tag").val();
	tagAdds = $.trim(tagAdds);
	if(tagAdds == ""){
		alert("정상적인 태그를 입력해주세요.");
		return false;
	}
	
	var tagAdd = tagAdds.split(" ");
	
	for (var i = 0; i < tagBaisc.length; i++) {
		for(var j = 0; j < tagAdd.length; j++){
			if(tagBaisc[i] == tagAdd[j]){
				alert("동일한 태그가 존재합니다.");
				return false;				
			}
		}
	}
	
	var tagListCheck = [];
	$.each(tagAdd, function(i, el){
		if($.inArray(el, tagListCheck) == -1) tagListCheck.push(el);
	});
	tagListCheck = tagListCheck.join(" ");
	tagAdds = tagListCheck;
	tagBaiscs = tagBaiscs + " " + tagAdds;
	tagBaiscs = $.trim(tagBaiscs);
	tagUploadAXJA(tagBaiscs);
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

function tagUploadAXJA(tagData){
	var pl_number = $(".pl_number").val();
	var json = "photoTag.upload?pl_number="+ pl_number +"&pl_tag="+ tagData;
	$.getJSON(json, function(data){
		console.log("태그업로드아작스:" + data.pl_tag);
		var master = $(".detailphoto_area .tag_list").data("master");
		if(master == "1"){			
			tagEdit(data.pl_tag);
		} else {
			tag(data.pl_tag);			
		}
		$(".pl_tag_basic").val(tagData);
	});
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

function enterkey() {
    if (window.event.keyCode == 13) {
    	tagUploadCheck();
    }
}

$(document).on('click', '.master_photolist .tag button', function(){
	var tagBaiscs = $(this).parent().find("input").val();
	var pl_number = $(this).parent().parent().find(".number").html();
	var tagBaisc = tagBaiscs.split(" ");

	if(tagBaiscs == ""){
		alert("정상적인 태그를 입력해주세요.");
		return false;
	}
	var tagListCheck = [];
	$.each(tagBaisc, function(i, el){
		if($.inArray(el, tagListCheck) == -1) tagListCheck.push(el);
	});
	tagListCheck = tagListCheck.join(" ");
	tagBaiscs = tagListCheck;
	tagBaiscs = $.trim(tagBaiscs);
	MasterTagUploadAXJA(tagBaiscs, pl_number);
	alert("정상적으로 수정되었습니다.");
})

function MasterTagUploadAXJA(tag, pl_number){
	var json = "photoTag.upload?pl_number="+ pl_number +"&pl_tag="+ tag
	$.getJSON(json, function(data){});
}





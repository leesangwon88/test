// 잘못되면 true, 정상이면 false

// <input>을 넣어주면 거기에 글자가 없는지 체크해주는 함수
// 없으면 true, 있으면 false 리턴
function isEmpty(field) {
		return (!field.value);
}
// input, 최소 글자수를 넣어주면 체크해주는 함수
// 최소글자수보다 짧으면 true, 길면 false 리턴
function lessThan(field, min){
	return (field.value.length < min);
}

// input, 한글 체크 함수
// 한글/특수문자가 들어있으면 true, 없으면 false 리턴
function HangulCheck(field){
	var str = "qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPASDFGHJKLXZCVBNM";
	for (var i = 0; i < field.value.length; i++) {
		if(str.indexOf(field.value[i]) == -1){
			return true;
		}
	}
	return false;
}

// 한글만 체크하는 함수
function HabgulOnlyCheck(field){
var str = field.value;
for (i = 0; i < str.length; i++) {
    if (!((str.charCodeAt(i) > 0x3130 && str.charCodeAt(i) < 0x318F) 
    || (str.charCodeAt(i) >= 0xAC00 && str.charCodeAt(i) <= 0xD7A3))) 
    {
        return true;
    }
}
return false;
}

// input 2개 넣어서 2개의 값을 비교하는 함수
// 다르면 true, 맞으면 false
function notEquals(field1, field2){
	return (field1.value != field2.value);
}
// input, 허용할 문자열 세트
// 그게 안들어있으면 true, 들어있으면 false값
function notContains(field, set){
	for (var i = 0; i < set.length; i++) {
		if (field.value.indexOf(set[i]) != -1) {
			return false;
		}
	}
	return true;
}

// <input>을 넣어주면 숫자만 있는지 검사하는 함수
// 불순물이 있으면 true, 아니라면 false
function isNotNumber(field){
	console.log(field);
	return isNaN(field.value);
}

// input 파일확장자 png 넣어준다.
// value가 확장자로 안끝나면 true, 끝나면 false
function isNotType(field, type){
	return field.value.toLowerCase().indexOf("."+type) == -1;
	//return (!field.value.toLowerCase().endsWith("." + type));
}

function emailCheck(str) {
	strVal = str.value;
    var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    if (regExp.test(strVal)) return true;
    else return false;
}



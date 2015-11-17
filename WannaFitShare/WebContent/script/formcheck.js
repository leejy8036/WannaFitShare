var idDuplicated = false;


function regModFormCheck(){
	if(!$("#csId").val()){
		$("#csId").focus();
		alert("고객 ID는 필수 입력사항입니다.");
		return false;
	}
	if(!$("#csPassword").val()){
		$("#csPassword").focus();
		alert("고객 패스워드는 필수 입력사항입니다.");
		return false;
	}
	if(!$("#csName").val()){
		$("#csName").focus();
		alert("고객이름은 필수 입력사항입니다.");
		return false;
	}
	if(!$("#csEmail").val()){
		$("#csEmail").focus();
		alert("Email 주소는 필수 입력사항입니다.");
		return false;
	}
	if(!$("#csPhone").val()){
		$("#csPhone").focus();
		alert("Phone 번호는 필수 입력사항입니다.");
		return false;
	}
	return true;
}

function registerFormCheck(){
	if(idDuplicated){
		alert("사용할 수 없는 ID입니다.");
		return false;
	}
	return regModFormCheck();
}


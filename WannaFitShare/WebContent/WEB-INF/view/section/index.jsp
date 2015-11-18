<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript" src="${initParam.rootPath }/script/formcheck.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#csId").on("keyup", function(){
		$.ajax({
			url:"${initParam.rootPath}/customer/idDuplicatedCheck.do", //요청 url
			type:"POST",
			data: {csId:$("#csId").val()},//요청파라미터   id=aaaaa
			dataType:"text",//응답 데이터 타입 - text(기본), json, jsonp, xml
			beforeSend:function(){
				//전송 전에 호출할 함수 등록
				if($("#id").val()==""){
					alert("조회할 ID를 입력하세요");
					return false;//false 리턴시 서버단으로 요청을 하지 않는다.
				}
			},
			success:function(txt){
				$("#layer").text(txt);
				if(txt=='true'){//중복
					$("#idErrorMessage").text("맞는 ID입니다.");
					idDuplicated = true;
				}else{
					$("#idErrorMessage").text("없는 ID입니다.");
					idDuplicated = false;
				}
			}
		});
	});
});
</script>

<div id="layer"></div>
<h2>로그인</h2>
<spring:hasBindErrors name="customer"/>
<form action="${initParam.rootPath}/customer/login/login.do" method="post" id="regForm">
<!-- 요청 처리할 Controller에 대한 구분값 -->
<input type="hidden" name="loginFlag" value="true">
<table border="1" style="width:500px">
	<tr>
		<th>고객 ID</th>
		<td><input type="text" id="csId" name="csId" size="25"> <span class="errorMessage" id="idErrorMessage"><form:errors path="customer.csId"/></span></td>
	</tr>
	<tr>
		<th>패스워드</th>
		<td><input type="password" id="csPassword" name="csPassword" size="25"> <span class="errorMessage"><form:errors path="customer.csPassword"/></span></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="고객등록"> <input type="reset" value="초기화">
		</td>
	</tr>
</table>
</form>

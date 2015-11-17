<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript" src="${initParam.rootPath }/script/formcheck.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#modifyForm").on("submit", modifyFormCheck);
});
</script>
<h2>고객 정보 수정</h2>
<spring:hasBindErrors name="customer"/>
<form action="${initParam.rootPath}/customer/modify.do" method="post" id="modifyForm">
<input type="hidden" name="pageNo" value="${param.pageNo }">
<table border="1" style="width:500px">
	<tr>
		<th>고객 ID</th>
		<td>
			${requestScope.customer.csId }
			<input type="hidden" name="csId" id="csId"
					value="${requestScope.customer.csId }">
		</td>
	</tr>
	<tr>
		<th>패스워드</th>
		<td>
			<input type="password" id="csPassword" name="csPassword" size="25">
			<span class="errorMessage"><form:errors path="customer.csPassword" delimiter=" | "/></span>
		</td>
	</tr>
	<tr>
		<th>고객 이름</th>
		<td>
			<input type="text" id="csName" name="csName" size="25" value="${requestScope.customer.csName }">
			<span class="errorMessage"><form:errors path="customer.csName" delimiter=" | "/></span>	
		</td>
	</tr>
	<tr>
		<th>고객 Email</th>
		<td>
			<input type="text" id="csEmail" name="csEmail" size="25" value="${requestScope.customer.csEmail}">
			<span class="errorMessage"><form:errors path="customer.csEmail" delimiter=" | "/></span>
		</td>
	</tr>
	<tr>
		<th>고객 번호</th>
		<td>
			<input type="text" id="csPhone" name="csPhone" size="25" value="${requestScope.customer.csPhone }">
			<span class="errorMessage"><form:errors path="customer.csPhone" delimiter=" | "/></span>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="수정"> <input type="reset" value="초기화">
		</td>
	</tr>
</table>
</form>

<%@ page contentType="text/html;charset=UTF-8" %>
고객을 등록했습니다.<br>
등록한 정보는 다음과 같습니다.<br>
<table border="1" style="width:300px">
	<tr>
		<th>고객 ID</th>
		<td>${requestScope.customer.csId }</td>
	</tr>
	<tr>
		<th>패스워드</th>
		<td>${requestScope.customer.csPassword }</td>
	</tr>
	<tr>
		<th>고객 이름</th>
		<td>${requestScope.customer.csName }</td>
	</tr>
	<tr>
		<th>고객 Email</th>
		<td>${requestScope.customer.csEmail }</td>
	</tr>
	<tr>
		<th>고객 번호</th>
		<td>${requestScope.customer.csPhone}</td>
	</tr>
</table>

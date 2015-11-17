<%@ page contentType="text/html;charset=UTF-8" %>
<h2>조회한 고객정보</h2>
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
<p>
<a href="${initParam.rootPath}/customer/remove.do?csId=${requestScope.customer.csId }&pageNo=${param.pageNo}">고객정보삭제</a>
<a href="${initParam.rootPath}/customer/modifyForm.do?csId=${requestScope.customer.csId }&pageNo=${param.pageNo}">고객정보수정</a>





















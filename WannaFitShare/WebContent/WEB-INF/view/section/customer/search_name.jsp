<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>친구찾기</h2>
<form action ="${initParam.rootPath}/customer/findByName.do" method="post">
친구이름 입력 :<input type ="text" name ="csName"><br> 
<input type="submit" value ="찾기">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
	<% out.println("<script>alert('실패');</script>"); %>
	
		<table>
			<tr>
				<td><input type="text" placeholder="아이디" name="uid"></td>
			</tr>
			<tr>
				<td><input type="password" placeholder="비밀번호" name="upw"></td>
			</tr>
			<tr>
				<td><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
</body>
</html>
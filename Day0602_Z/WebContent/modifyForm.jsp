<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원 정보 수정</title>
</head>
<body>
	<%
		Member m = (Member)session.getAttribute("user");
			String name = m.getName();
			String pw = m.getPw();
			String email = m.getEmail();
	%>
	<form action="modify" method="post">
		<table>
			<tr>
				<td>
					<input type="text" name="userName" value="<%= name %>">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="userPw" value="<%= pw %>">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="userEmail" value="<%= email %>">
				</td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="수정하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
	<form action="drop" method="post">
		<table>
			<tr>
				<td>
					<input type="text" name="userId" placeholder="아이디">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="userPw" placeholder="비밀번호">
				</td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="탈퇴하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>로그인</title>
	<style type="text/css">
		div, form, table {
			margin: 0 auto;
		}
		div{
			text-align: center;
			width: 100%;
			height: 1200px;
		}
		form{
			width: 500px;
			height: 300px;
		}
		
		table{
			width: 70%;
			height: 50%;
			border: 1px solid gray;
			border-collapse: collapse;
			padding: 20px;
			margin-top: 200px;
		}
		input{
			margin-right: 20px;
		}
		
		td{
			width: 95%;
			height: 35px;
		}
		
	
	</style>
</head>
<body>
	<div>
		<form action="login" method="post">
			<table>
				<tr>
					<td><input type="text" placeholder="아이디" name="userId"></td>
				</tr>
				<tr>
					<td><input type="password" placeholder="비밀번호" name="userPw"></td>
				</tr>
				<tr>
					<td><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form>
			<a href="joinForm">회원가입</a>
	</div>
</body>
</html>
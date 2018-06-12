<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원가입</title>
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
			height: 80%;
			border: 1px solid gray;
			border-collapse: collapse;
			padding: 20px;
			margin-top: 200px;
		}
		
		td{
			width: 95%;
			height: 35px;
		}
	</style>
</head>
<body>
	<div>
		<form action="join" method="post">
			<table>
				<tr>
					<td><input type="text" placeholder="아이디" name="userId"></td>
				</tr>
				<tr>
					<td><input type="text" placeholder="비밀번호" name="userPw"></td>
				</tr>
				<tr>
					<td><input type="text" placeholder="이름" name="userName"></td>
				</tr>
				<tr>
					<td><input type="text" placeholder="이메일" name="userEmail"></td>
				</tr>
				<tr>
					<td><input type="submit" value="회원가입"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>로그인 페이지</title>
	<style type="text/css">
		form{
			margin: 0 auto;
			border: 1px solid white;
			width: 800px;
			height: 670px;
			background-image: url('img/back.png');
			text-align: center;
		}
		table{
			border: 0px solid white;
			margin-top: 250px;
			margin-left: 150px;
			padding: 20px;
		}
		.text{
			border: 1px solid gray;
			width: 460px;
			height: 30px;
			padding: 5px;
			margin-bottom: 20px;
			font-size:15px;
		}
		td{
			text-align: center;
		}
		p{
			font-size: 13px;
		}

	</style>
</head>
<body>
	<form action="login">
		<table>
			<tr>
				<td><input type="text" class="text" name="id" placeholder="아이디"></td>
			</tr>
			<tr>
				<td><input type="text" class="text" name="pw" placeholder="비밀번호"></td>
			</tr>
	 		<tr>
	 			<td colspan="3">
	 				<input TYPE="IMAGE" name="submit" value="submit" src="img/login.png">
	 			</td>
	 		</tr>
		</table>
	 	<p><label><a href="signUp.jsp">회원가입</a></label></p>
	</form>
</body>
</html>
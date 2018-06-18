<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/board.css">
<title>로그인</title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous">
	</script>
	<style type="text/css">
	div, form, table {
		margin: 0 auto;
	}
	div {
		text-align: center;
	}
	table {
		width: 300px;
	}
	th {
		margin: 0px;
		width: 100px;
	}
	tr {
		text-align: center;
		margin-bottom: 15px;
	}
	.input {
		width: 95%;
	}
	span {
		font-size: small;
		color: red;
	}
	</style>
	<script type="text/javascript">
	</script>
</head>
<body background="IMG/simpson6.png" style="background-repeat: no-repeat;">
	<div class="wrap">
		<h1>로그인</h1>
		<form name="frm" action="member" method="post">
			<input type="hidden" name="command" value="member_login">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" id="id" name="id" class="input"><span class="span"></span></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" id="pass" name="pass" class="input" value=${name}><span class="span"></span></td>
				</tr>
				<tr>
					<td colspan="2">
						<input style="margin-left: 10px" type="submit" value="로그인">
						<input style="margin-left: 100px" type="button" value="회원가입"
							onclick="location.href='board?command=member_join_form'">
					</td>
				</tr>
			</table>
		</form>
	</div>
<body>

</body>
</html>
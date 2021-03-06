<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/board.css">
<title>회원가입</title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous">
	</script>
	<style type="text/css">
	div, form, table {
		margin: 0 auto;
	}
	table {
		width: 20%;
		text-align: left;
	}
	div {
		text-align: center;
	}
	th {
		text-align: center;
		margin: 0px;
		width: 50px;
	}
	td {
		width: 150px;
	}
	tr {
		margin-bottom: 15px;
	}
	.input {
		margin-left: 5px;
		width: 60%;
	}
	span {
		font-size: small;
		color: red;
		margin-left: 10px;
	}
	</style>
	<script type="text/javascript">
	
	$(function(){
		$(".input").blur(function(){
			if(($(this).val())=="") {
				$(this).siblings().text('필수 입력');
			} else {
				$(this).siblings().text('');
			}
			return false;
		});
		$("#email").blur(function(){
			var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
			if(($("#email").val())!="" && !regExp.test($("#email").val())) {
				$("#email").siblings().text('이메일 양식을 지켜주세요!');
			}
		 return false;
		});
	});
	</script>
</head>
<body background="IMG/simpson5.png" style="background-repeat: no-repeat;">
	<div class="wrap">
		<h1>회원 가입</h1>
		<h5>*는 필수입력 항목입니다.</h5>
		<form name="frm" action="member" method="post">
			<input type="hidden" name="command" value="member_join">
			<table id="signTable">
				<tr>
					<th>*아이디</th>
					<td><input type="text" id="id" name="id" class="input"><span class="span"></span></td>
				</tr>
				<tr id="passTap">
					<th>*비밀번호</th>
					<td><input type="password" id="pass" name="pass" class="input"><span class="span"></span></td>
				</tr>
				<tr>
					<th>*닉네임</th>
					<td><input type="text" id="name" name="name" class="input"><span class="span"></span></td>
				</tr>
				<tr>
					<th>*이메일</th>
					<td><input type="text" id="email" name="email" class="input"><br><span class="span"></span></td>
				</tr>
				<tr>
					<td colspan="2">
						<input style="margin-left: 100px" type="submit" value="가입">
						<input style="margin-left: 100px" type="button" value="취소"
							onclick="location.href='board?command=member_login_form'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
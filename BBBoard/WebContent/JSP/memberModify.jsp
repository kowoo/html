<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/board2.css">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous">
	</script>
	<jsp:include page="header.jsp"></jsp:include>
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
	.newPw{
		margin-left: 5px;
		width: 60%;
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
		$("#target").submit(function(){
			if(($("#pass").val())=="") {
				alert("비밀번호를 입력해주세요!")
				return false;
			}
			
			if($("#pass3").val()!=$("#pass2").val()) {
				alert("새 비밀번호와 비밀번호 확인이 달라요!")
				return false;
			}
		});
	});
	</script>
</head>
<body background="IMG/simpson7.png" style="background-repeat: no-repeat;">
	<div class="wrap">
		<h1>정보 수정</h1>
		<p style="color:red"><small>${msg}</small></p>
		<h5>*는 필수입력 항목입니다.</h5>
		<form name="frm" id="target" action="member" method="post">
			<input type="hidden" name="command" value="member_modify">
			<table>
				<tr>
					<th>*아이디</th>
					<td><input type="text" id="id" name="id" class="input" readonly="readonly" value="${member.id}">
					<span class="span">수정 불가</span></td>
				</tr>
				<tr id="passTap">
					<th>*비밀번호</th>
					<td><input type="password" id="pass" name="pw" class="input"><span class="span"></span></td>
				</tr>
				<tr>
					<th>새 비밀번호</th>
					<td><input type="password" id="pass2" name="pw2" class="newPw"><span class="span"></span></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" id="pass3" name="pw3" class="newPw"><span class="span"></span></td>
				</tr>
				<tr>
					<th>*닉네임</th>
					<td><input type="text" id="name" name="name" class="input" value="${member.name}"><span class="span"></span></td>
				</tr>
				<tr>
					<th>*이메일</th>
					<td><input type="text" id="email" name="email" class="input" value="${member.email}"><br><span class="span"></span></td>
				</tr>
				<tr>
					<td colspan="2">
						<input style="margin-left: 30px" type="submit" value="수정">
						<input style="margin-left: 50px" type="button" value="돌아가기"
							onclick="history.go(-1)">
						<input style="margin-left: 50px" type="button" value="탈퇴"
							onclick="location.href='member.do?command=member_delete&id=${member.id}'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
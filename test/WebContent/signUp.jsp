<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>네이버 회원가입</title>
	<script type="text/javascript">
		window.onload = function() {
			var btnCheck = document.getElementById("btnCheck");
			var id = document.getElementById("id");
			var name = document.getElementById("name");
			var pw1 = document.getElementById("pw1");
			var pw2 = document.getElementById("pw2");
			var ckResult = document.getElementById("checkResult");
			var pwer = document.getElementById("pwer");
			var ider = document.getElementById("ider");
			var nameer = document.getElementById("nameer");
			var iderror = document.getElementById("iderror");
	 		var pwerror = document.getElementById("pwerror");
	 		var nameerror = document.getElementById("nameerror");
	 		var idForm = document.getElementById("idForm");
	 		var pwForm = document.getElementById("pwForm");
	 		var nameForm = document.getElementById("nameForm");
			btnCheck.onclick = function() {
				if(pw1.value == pw2.value) {
				} else {
					pwer.style.color="red";
					pwer.innerHTML="비밀번호가 다릅니다!";
					pwerror.style.display="block";
				}
			}
			idCheck = function() {
				var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;
				if(id.value=="") {
					idForm.style.height="50px";
					ider.style.color="red";
					ider.innerHTML="아이디는 필수입력 항목입니다.";
					iderror.style.display="block";
				}
				else if(!idReg.test(id.value)) {
					idForm.style.height="50px";
					ider.style.color="red";
					ider.innerHTML="아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.";
					iderror.style.display="block";
				} else {
					idForm.style.height="25px";
					iderror.style.display="none";
				}
			}
			blurblur = function() {
				if(pw1.value != pw2.value) {
					pwForm.style.height="50px";
					pwer.style.color="red";
					pwer.innerHTML="비밀번호가 다릅니다!";
					pwerror.style.display="block";
				} else {
					pwForm.style.height="25px";
					pwerror.style.display="none";
				}
			}
			nameCheck = function() {
				var nameReg = /^[가-힣]{2,4}$/g;
				if(name.value=="") {
					nameForm.style.height="50px";
					nameer.style.color="red";
					nameer.innerHTML="이름은 필수입력 항목입니다.";
					nameerror.style.display="block";
				}
				else if(!nameReg.test(name.value)) {
					nameForm.style.height="50px";
					nameer.style.color="red";
					nameer.innerHTML="이름은 한글로 2글자 이상이어야 합니다.";
					nameerror.style.display="block";
				} else {
					nameForm.style.height="25px";
					nameer.style.display="none";
				}
			}
		};
	</script>
	<style type="text/css">
	div{
		margin: 0 auto;
	}
	#wrapper{
		text-align: center;
		width: 100%;
   		margin: 0 auto;
	}
	#w1{
		width: 500px;
	    margin-bottom: 10px;
	    border: solid 1px gray;
	}
	#title{
		color: green;
		font-size: 5em;
	}
	table{
	}
	.form{
		border: 1px solid gray;
		border-collapse: collapse;
		/*box-sizing: border box;*/
		width: 400px;
		height: 25px; /*오류발생시 50px*/
		padding: 11px;
	}
	input{
		border: none;
		width: 95%;
		heigth: 28px;
		padding: 6px;
		font-size:14px;
		margin-left: px;
	}
	.error{
		font-size: 12px;
		text-align: left;
		margin-left: 20px;
	}
	p{
		display:inline;
	}
	.join{
		margin:20px;
		width:430px;
		height:60px;
		background-color: green;
		color: white;
		text-align: center;
		font-size: 20px;
	}
	</style>
</head>
<body>
	<div id="wrapper">
		<div id="w1">
			<h1 id="title">NAVER</h1>
			<div class="form" id="idForm">
				<input type="text" id="id" placeholder="아이디" maxlength="16" onblur="idCheck();">
				<div class="error" id="iderror" style="display:none">
				<p id="ider">오류확인</p> 
				</div>
			</div>
			<div class="form">
				<input type="text" id="pw1" placeholder="비밀번호" maxlength="20">
			</div>
			<div class="form" id= "pwForm">
				<input type="text" id="pw2" placeholder="비밀번호 확인" maxlength="20" onblur="blurblur();">
				<div class="error" id="pwerror" style="display:none">
				<p id="pwer">오류확인</p>
				</div>
			</div>
			<div class="form" id= "nameForm">
				<input type="text" id="name" placeholder="이름" maxlength="20" onblur="nameCheck();">
				<div class="error" id="nameerror" style="display:none">
				<p id="nameer">오류확인</p>
				</div>
			</div>
			<input type="submit" id="btnCheck" value="가입하기" class="join">
		</div>
	</div>
</body>
</html>
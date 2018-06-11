<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	  src="https://code.jquery.com/jquery-3.3.1.min.js"
	  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	  crossorigin="anonymous">
</script>
<script type="text/javascript">
	$(function(){
		$("#joinForm").on("submit",function() {
			var m = $(this).serialize();
			alert("d: "+ d);
			$.ajax({
				url:"member?command=join",
				type:"post",
				data: m,
				dataType:"json",
				success : function(data) {
					var strResult;
					if(data.result) {
						strResult = '가입성공';
					}else{
						strResult = '가입실패';
					}
				}
			});
			return false;
		});
		$("#userid").on("blur",function() {
			$.ajax({
				url:"member?command=checkId",
				data: {"id":$(this).val()},
				datatype: "json",
				success: function(data) {
					var strResult;
					if(data.result) {
						strResult='사용불가';
						alert("dddddddddddddddddddddddddddd");
					}else {
						strResult='사용가능';
						alert("55555555555");
					}
					$("#idIsDup").text(strResult);
				}
			});
			return false;
		});
		
		$("#email").blur(function() {
			$.ajax({
				url:"member?command=checkEmail",
				data: {"email":$(this).val()},
				datatype: "json",
				success: function(data) {
					var result;
					if(data.result) {
						result='사용가능';
					}else {
						result='사용불가';
					}
					$("#mailIsDup").text(result);
				}
			});
			return false;
		});
	});

</script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원몪롞</title>
	<style type="text/css">
	/*
	   비동기 방식으로 요청/처리 하기
	  1.아이디 확인
	  2.회원가입 후 회원 목록가져오기	
	*/
		table, tr, td, th{
			border: 1px solid gray;
			border-collapse: collapse;
			padding: 10px;
		}
		span{
		}
		input{
			border:none;
		}
		th{
			background-color:black;
			color:white;
		}
	</style>
</head>
<body>
	<form name="joinForm" method="post" id="joinForm">
		<table>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>		
			</tr>
			<tr>
				<td><input type="text" name="userid" id="userid"><span id="idIsDup">아이디중복여부</span></td>
				<td><input type="text" name="password" id="password"></td>
				<td><input type="text" name="name" id="name"></td>
				<td><input type="text" name="email" id="email"><span id="mailIsDup">이메일중복여부</span></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="가입"></td>
		</table>
	</form>
	<h2>회원 목록</h2>
	<table id="listTable">
		<colgroup>
			<col width="150px">
			<col width="250px">
			<col width="100px">
		</colgroup>
		<tr>
			<th>아이디</th>
			<th>이메일</th>
			<th>이름</th>
		</tr>
	
	</table>
</body>
</html>
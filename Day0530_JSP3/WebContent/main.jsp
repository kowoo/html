<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>메인 화면</title>
	<style type="text/css">
		div{
			text-align: center;
			margin: 0 auto;
			margin-top: 200px;
			padding: 50px;
		}
		button{
			margin: 10px;
		}
	</style>
</head>
<body>
	<div>
		<%= session.getAttribute("userid") %> 님 반갑습니다.<br>
		<button onclick = "location.href = 'memberList'">회원목록 보기</button>
		<button onclick = "location.href = 'modifyForm'">회원정보 수정</button>
		<button onclick = "location.href = 'dropForm'">회원탈퇴</button>
		<button onclick = "location.href = 'logout'">로그아웃</button>
		
	</div>
</body>
</html>
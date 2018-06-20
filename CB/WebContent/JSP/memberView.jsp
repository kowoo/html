<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/board.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous">
	</script>
	<style type="text/css">
		th{
			background-color: black;
			color: white;
		}	
	</style>
<title>${m.name}님의 정보</title>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<td>${m.id}</td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td>${m.name}</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>${m.regDate}</td>
		</tr>
		<tr>
			<th>작성한 게시글 수</th>
			<td>${m.boardW}</td>
		</tr>
		<tr>
			<th>작성한 덧글 수</th>
			<td>${m.commentW}</td>
		</tr>
		<tr>
		</tr>
	</table>
</body>
</html>
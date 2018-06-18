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
<title>${id}님의 정보</title>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<th>닉네임</th>
			<th>가입일</th>
			<th>작성한 게시글</th>
			<th>작성한 덧글</th>
		</tr>
		<tr>
			<td>${m.id}</td>
			<td>${m.name}</td>
			<td>${m.regDate}</td>
			<td>${m.boardw}</td>
			<td>${m.commentw}</td>
		</tr>
	</table>
</body>
</html>
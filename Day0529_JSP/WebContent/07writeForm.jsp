<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시글 작성</title>
	<style type="text/css">
		table{
			top: 500px;
			margin: 0 auto;
			border: 1px solid gray;
			padding: 10px;
		}
		tr {
			margin: 15px;
		}
		.btn {
			margin-left: 50px;
		}
	
	</style>
</head>
<body>
	<form action="board" method="post">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="pass"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="작성하기" class="btn"></td>
				<td><input type="reset" value="초기화" class="btn"></td>
			</tr>
		</table>
	</form>
</body>
</html>
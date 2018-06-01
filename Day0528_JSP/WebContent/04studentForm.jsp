<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>학생 등록</title>
	<style type="text/css">
		table{
			border: 1px solid gray;
			text-align: center;
			margin: 0 auto;
			padding: 10px;
		}
		
		h3{
			text-align: center;
		}
		
		tr, td{
			text-align: center;
			padding: 5px;
		}
	
	</style>
</head>
<body>
	<form action="student">
		<h3>학생 등록하기</h3>
		<table>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>학년</th>
				<td><input type="text" name="grade"></td>
			</tr>
			<tr>
				<th>국어</th>
				<td><input type="text" name="kor"></td>
			</tr>
			<tr>
				<th>영어</th>
				<td><input type="text" name="eng"></td>
			</tr>
			<tr>
				<th>수학</th>
				<td><input type="text" name="math"></td>
			</tr>
	 		<tr>
	 			<td colspan="3">
	 				<input type="submit" value = "등록하기">
	 				<input type="reset" value = "다시작성">
	 			</td>
	 		</tr>				
		</table>
	</form>
</body>
</html>
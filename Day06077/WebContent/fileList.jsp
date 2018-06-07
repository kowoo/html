<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>파일 업로드</title>
	<style type="text/css">
		div{
			border: 1px solid black;
			margin: 0 auto;
			width: 300px;
			height: 80px;
		}
		input{
			margin: 10px;
		}
	
	</style>
</head>
<body>
	<div>						<!-- 파일을 보내기 위해 인코드타입을 넣어야함, 서블릿 3 이후만 사용 가능하다 -->
		<form action="upload" method="post" enctype="multipart/form-data">
		<input type="file" name="uploadFile">
		<input type="submit" value="저장">
		</form>
	
	</div>
</body>
</html>
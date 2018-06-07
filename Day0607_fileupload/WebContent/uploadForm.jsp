<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
									<!-- 파일을 보내기 위해 인코드타입을 넣어야함, 서블릿 3 이후만 사용 가능하다 -->
	<form action="upload" method="post" enctype="multipart/form-data">
		file : <input type="file" name="uploadFile"> 
		<input type="submit" value="전송">
	</form>
</body>
</html>
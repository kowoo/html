<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		form: 다른 페이지로 이동하는 요청을 보낼 때, 데이터를 쉽게 전달할 수 있게 해주는 html요소
		url?파라미터이름=값
		ex) localhost:8080/Day0525_JSP/hello?name=홍길동&id=hong
	 -->
	 
	 <!-- method="post"로 하면 데이터가 전달될 때 주소창에 값이 표기 안되게 할 수 있음 -->
	 <!-- method="get"로 하면 데이터가 전달될 때 주소창에 값이 표기 되게 할 수 있음 -->
	 <form action="06logincheck.jsp" method="post">
	 	<p><label>아이디<input type="text" name="userid"></label></p>
	 	<p><label>비밀번호<input type="password" name="userpw"></label></p>
	 	<p><input type="submit" value="로그인"></p>
	 </form>
	 
	 
</body>
</html>
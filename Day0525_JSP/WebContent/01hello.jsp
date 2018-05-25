<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello jsp</title>
</head>
<body>
	<h1>Hello!</h1>
	<%-- jsp에서의 주석 처리
		날짜 출력 >>> 날짜 정보는 자바에서 가져올 수 있다.
		Date객체를 만들면 된다.
		값을 출력하기 위해서 표현부 사용 <%= %>
		JSP페이지 내에서 외부 클래스를 import해서 사용하기 위해서는 디렉티브를 사용해야한다.
		데이트는 외부클래스이므로 그냥 사용할 수는 없으니 임포트를 해줘야하는게 맞겠지!
		임포트 안하면 데이트는 인식이 안돼서 빨간줄이 나옴
		
		값 자체를 보여주는 것이므로 세미콜론 붙이면 안됨!
		
	--%>
	
	오늘의 날짜는 : <%= new Date() %>
</body>
</html>
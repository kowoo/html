<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>요청 객체 리뷰</title>
</head>
<body>
	<%--
		클라이언트가 요청을 하게 되면, 서버가 요청정보를 확인하고 응답을 만들어낸다.
		JSP내에서 요청정보를 확인할 수 있는 내장객체: request
		웹브라우저의 요청 정보를 제공하는 객체, 클라이언트 및 서버 정보를 가지고 있다.
	
		로그인 화면을 만들어보자
		1. 사용자의 아이디, 비밀번호를 받아서 서버로 전달
		*requset객체에는 클라이언트가 보내는 정보도 포함되어 있다
		
		컨텍스트 경로
		프로젝트의 위치(서버가 실행되는 지점)
		
		클라이언트에서 보내는 정보를 받아오자
		login.jsp
	 --%>
	
	클라이언트 IP = <%=request.getRemoteAddr()%><br>
	요청정보 길이 = <%=request.getContentLength()%><br>
	요청 URI = <%=request.getRequestURI()%><br>
	컨텍스트 경로 = <%=request.getContextPath()%><br>

	
	
	
		 
</body>
</html>
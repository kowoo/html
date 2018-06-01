<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인</title>
</head>
<body>
	<%	
		String name = "userid";
		String userid = "";
		Cookie[] cookies = request.getCookies();
		for(int i=0; i<cookies.length; i++) {
			if(name.equals(cookies[i].getName())) {
				userid = cookies[i].getName();
			}
		}
		if(userid=="") {
			response.sendRedirect("02loginForm.jsp");
		}
	
	%>

	<%= userid %>아이디님 반갑습니다.<br> 
	<button onclick = "location.href='logout'">로그아웃</button>
</body>
</html>
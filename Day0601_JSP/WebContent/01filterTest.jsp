<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>필터 테스트</title>
</head>
<body>
	<h1>요청받았습니다!!!</h1>
	id 파라미터: <%=request.getParameter("id") %> <br>
	name 파라미터: <%=request.getParameter("name") %> <br>
	pay 파라미터: <%=request.getParameter("pay") %> <br>
</body>
</html>
<%@ page import="model.Board" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
	<%
		Board board = (Board)session.getAttribute("board");
	%>
	<%-- 
	제목 <%= request.getParameter("title") %> <br>
	이름 <%= request.getParameter("name") %> <br>
	이메일 <%= request.getParameter("email") %> <br>
	비번 <%= request.getParameter("pass") %> <br>
	내용 <%= request.getParameter("content") %> <br>
	 --%>
	<%= board %>
</body>
</html>
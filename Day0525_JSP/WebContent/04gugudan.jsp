<%-- <%@page import="com.sun.xml.internal.ws.api.pipe.NextAction"%> --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
	public int gugudan(int i, int j) {
		return i*j;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>구구단</title>
</head>
<body>
	<%-- 화면에 구구단 출력하기
		예)
			2 X 1 = 2
			2 X 2 = 4
			2 X 3 = 6
	
	 --%>
	
	<%
		for(int i=2; i<=9; i++) {
				out.print(i+"단"+"<br>");
			for(int j=1; j<=9; j++) {
				int gugu = gugudan(i,j);
				//String space = "<&nbsp>;";
				out.print(i + "X" + j + " = " + gugu + "<br>");
			}
		}
	%>

</body>
</html>
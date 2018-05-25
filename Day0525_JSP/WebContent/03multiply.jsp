<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%!
	int result;
	public int multi(int a, int b) {
		int mult = a*b;
		return mult;
	}
	Scanner sc = new Scanner(System.in);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>곱하기</title>
</head>
<body>

		<%
			int a = sc.nextInt();
			int b = sc.nextInt();
			result = multi(a,b);
		%>
		
		<p>숫자1 입력
		<input type="text" id="num1" value=<%= a %>>
		</p>
		<p>숫자2 입력
		<input type="text" id="num2" value=<%= b %>>
		</p>
		<p>두 숫자의 곱
		<input type="text" id="num2" value=<%= result %>>
		</p>
</body>
</html>
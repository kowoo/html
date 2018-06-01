<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Loan"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%!
		ArrayList<Loan> list;
	%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Loan Result</title>
	<style type="text/css">
		table, td, th{
			border: 1px solid black;
			border-collapse: collapse;
			text-align: center;
			padding: 5px;
			font-size: 13px;
		}
		table{
			margin: 0px auto;
		}	
	</style>
</head>
<body>
	<form action="#">
		<table>
			<tr>
				<th>회차</th>
				<th>상환액</th>
				<th>상환원금</th>
				<th>이자</th>
				<th>상환총액</th>
				<th>잔액</th>
			</tr>
	<%
		list = (ArrayList<Loan>)request.getAttribute("loanList");
		for(int i=0; i<list.size(); i++) {
			%>
			<tr>
				<td><%=i%>회차</td>
				<td><%=list.get(i).getRepayTotal() %></td>
				<td><%=list.get(i).getRepayOrigin() %></td>
				<td><%=list.get(i).getInterest() %></td>
				<td><%=list.get(i).getRepaySum() %></td>
				<td><%=list.get(i).getRepayRemain() %></td>
			</tr>
			<%
		}
	%>
		</table>
	</form>
</body>
</html>
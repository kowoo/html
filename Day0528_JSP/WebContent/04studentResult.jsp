<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%!
		ArrayList<Student> list;
	%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>학생 리스트</title>
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
	<form>
		<table>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>학년</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
			</tr>
			<%
				list = (ArrayList<Student>)request.getAttribute("list");
				for(int i=0; i<list.size(); i++) {
					%>
				<tr>
					<td><%=list.get(i).getSnum() %></td>
					<td><%=list.get(i).getName() %></td>
					<td><%=list.get(i).getGrade() %></td>
					<td><%=list.get(i).getKor() %></td>
					<td><%=list.get(i).getEng() %></td>
					<td><%=list.get(i).getMath() %></td>
				</tr>
					<%
				}
			%>
		
		</table>
	
	</form>
</body>
</html>
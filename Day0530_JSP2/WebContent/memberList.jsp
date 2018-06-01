<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Member"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원 목록</title>
	<style type="text/css">
		table, th, td{
			border: 1px solid gray;
			border-collapse: collapse;
			padding: 3px;
			margin: 0 auto;
		}
		table{
			margin-top: 50px;
		}
		
	</style>
</head>
<body>
<%-- 
	<%  
		Member m = new Member();
		List<Member> mList = new ArrayList<Member>();
		mList = (List<Member>)request.getAttribute("mList");
		request.setAttribute("mList", mList);
	%>
	 --%>
	
	<div>
		<table>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>가입일</th>
			</tr>
			
	<c:forEach items="${mList}" var="member">
		<tr>
			<td>${member.id} </td>
			<td>${member.name} </td>
			<td>${member.email} </td>
			<td>${member.regDate} </td>
		</tr>
	</c:forEach>
<%-- 	
	<%
		for(int i=0; i<mList.size(); i++) {
			%>
			<tr>
				<td><%= mList.get(i).getId()%></td>
				<td><%= mList.get(i).getName()%></td>
				<td><%= mList.get(i).getEmail()%></td>
				<td><%= mList.get(i).getRegDate()%></td>
			</tr>
			<%
		}
	%>
	 --%>
		</table>
	</div>
	
</body>
</html>
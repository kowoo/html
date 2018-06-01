<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>메시지 목록</title>
	<style type="text/css">
		div{
			margin: 0 auto;
			width: 600px;
			height: 300px;
		}
		table {
			width: 99%;
			height: 99%;
			margin: 0 auto;
			border: 1px solid black;
			border-collapse: collapse;
		}
		tr, th, td{
			width: 20px;
			height: 30px;
			border: 1px solid gray;
		}
		#message {
			width: 200px;
			height: 100px;
		}
		.abc {
			width: 200px;
			height: 30px;
		}
		form {
			margin-left: 165px;
		}
		input {
			width: 200px;
			height: 30px;
		}
		textarea {
			width: 200px;
			height: 200px;
		}
	</style>
</head>
<body>
	<div>
		<table>
			<c:if test="${mList.siz>0}">
				<c:forEach items="${mList}" var="msg" varStatus="status">
						<tr>
							<th class="abc">내용</th>
							<th>글쓴이</th>
						</tr>
							<tr>
								<td>${status.count}</td>
								<td>${msg.id}</td>
								<td class="abc">${msg.message}</td>
								<td>${msg.name}</td>
							</tr>
						<tr>
						</tr>
				</c:forEach>
			</c:if>
		</table>
		<form action="write">
			<p><label>이름<br><input type="text" name="name"></label></p>
			<p><label>비번<br><input type="text" name="password"></label></p>
			내용<br>
			<p><textarea name="message" cols="20" rows="3"></textarea></p>
			<p><input type="submit" value="작성하기"></p>
		</form>
			
	</div>
</body>
</html>
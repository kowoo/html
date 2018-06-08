<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/board.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시판</title>
<!-- 	<style type="text/css">
		table{
			text-align: center;
			border: 1px solid black;
			width: 50%;
			padding: 20px;
		}
		th{
			border: 1px solid gray;
		}
		
	
	</style> -->
	<style type="text/css">
		table{
			text-align: center;
		}
		.title{
			text-align: left;
		}
		
	</style>
</head>
<body>
	<div id="wrap" align="center">
		<table class="list">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.num}</td>
					<td class="title"><a href="board?command=board_view&num=${board.num}">${board.title}</a></td>
					<td>${board.name}</td>
					<td>${board.writeDate}</td>
					<td>${board.readCount}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="right">
					<a href="board?command=board_write_form">게시글 등록</a>
				</td>
			</tr>
		</table>	
	</div>
</body>
</html>
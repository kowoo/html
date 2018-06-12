<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/board.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>자유게시판</title>
	<jsp:include page="header.jsp"></jsp:include>
	<style type="text/css">
		table{
			text-align: center;
		}
		.title{
			text-align: left;
		}
	</style>
	<script type="text/javascript">
	</script>
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
					<td class="title" width="250px">
					<a href="board?command=board_view&num=${board.num}">${board.title}</a></td>
					<td id="name">${board.name}</td>
					<td>${board.writeDate}</td>
					<td>${board.readCount}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="right"><input type="button"
					onclick="location.href='board.do?command=board_write_form'"
					value="글쓰기"></td>
			</tr>
		</table>
		<a href="board?command=board_list&page=1">[처음]</a>
			<c:forEach var="page" begin="1" end="${pageTotalCount}">
				<a href="board?command=board_list&page=${page}">[${page}]</a>
			</c:forEach>
		<a href="board?command=board_list&page=${pageTotalCount}">[마지막]</a>
	</div>
</body>
</html>
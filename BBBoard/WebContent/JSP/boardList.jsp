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
		#now{
			color: blue;
		}
		table{
		}
		a{
			font: bold;
		}

	</style>
	<script type="text/javascript">
	</script>
</head>
<body background="IMG/simpson.png" style="background-repeat: no-repeat;">
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
						<a href="board?command=board_view&num=${board.num}">${board.title}</a>
						<c:if test="${1 le board.comments}">
							[${board.comments}]
						</c:if>
					</td>
					<td id="name">${board.name}</td>
					<td>${board.writeDate}</td>
					<td>${board.readCount}</td>
				</tr>
			</c:forEach>
		</table>
			<c:if test="${2 le nowPage}">
				<a href="board?command=board_list&page=1">[처음]</a>
				<a href="board?command=board_list&page=${nowPage-1}">[이전]</a>
			</c:if>
			<c:forEach var="page" begin="${startPage}" end="${endPage}">
				<c:if test="${page ne nowPage}">
					<a href="board?command=board_list&page=${page}">[${page}]</a>
				</c:if>
				<c:if test="${page eq nowPage}">
					<a href="board?command=board_list&page=${page}" id="now"><b>[${page}]</b></a>
				</c:if>
			</c:forEach>
			<c:if test="${pageTotalCount > nowPage}">
				<a href="board?command=board_list&page=${nowPage+1}">[다음]</a>
				<a href="board?command=board_list&page=${pageTotalCount}">[마지막]</a>
			</c:if>
			<p><input type="button" onclick="location.href='board.do?command=board_write_form'" value="글쓰기"></p>
	</div>
</body>
</html>
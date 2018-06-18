<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="JS/board.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/board.css">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous">
	</script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>자유게시판</title>
	<jsp:include page="header.jsp"></jsp:include>
	<script type="text/javascript">
	</script>
</head>
<body background="IMG/simpson.png" style="background-repeat: no-repeat;">
	<div id="wrap" align="center">
		<table id="boardList">
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
					<td class="boardTitle">
						<a href="board?command=board_view&num=${board.num}" class="boardTitleFont">${board.title}</a>
						<c:if test="${1 le board.comments}">
							<span class="boardListComment">[${board.comments}]</span>
						</c:if>
					</td>
					<!-- <td class="writerName" onclick="open_win('member?command=member_view_form_&name=${board.name}','delete')">${board.name}</td> -->
					<!-- <td class="writerName" onclick="open_win('member?command=member_view_form_&name=${board.name}','delete')"> -->
					<td><a href="javascript:open_win('member?command=member_view&name=${board.name}')">${board.name}</a></td>
					<td>${board.writeDate}</td>
					<td>${board.readCount}</td>
				</tr>
			</c:forEach>
		</table>
		<form action="board" method="post">
			<input type="hidden" name="command" value="board_search">
			<table id="searchTable">
				<tr>
					<td id="searchOption" valign="bottom">
						<select name="opt">
							<option value="title">제목</option>
							<option value="name">작성자</option>
							<option value="content">내용</option>
						</select>
					</td>
					<td><input type="text" id="keyword" size="16" name="keyword"></td>
					<td><input type="submit" id="searchSubmit" value="찾기"></td>
				</tr>
			</table>
		</form>
			<a href="board?command=board_list&page=1">[처음]</a>
			<a href="board?command=board_list&page=${nowPage-1}">[이전]</a>
		<c:forEach var="page" begin="${startPage}" end="${endPage}">
			<c:if test="${page <= pageTotalCount}">
				<c:if test="${page ne nowPage}">
					<a href="board?command=board_list&page=${page}">[${page}]</a>
				</c:if>
				<c:if test="${page eq nowPage}">
					<a href="board?command=board_list&page=${page}" id="boardNowPage"><b>[${page}]</b></a>
				</c:if>
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
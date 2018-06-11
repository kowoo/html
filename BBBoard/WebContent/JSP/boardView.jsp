<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="CSS/board.css">
	<script type="text/javascript" src="JS/board.js"></script>
	<script type="text/javascript">
		document.title = "${title}";
	</script>
	<jsp:include page="header.jsp"></jsp:include>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
 	<style type="text/css">
		div, form, table{
			margin: 0 auto;
		}
		div, .footer{
			text-align: center;
		}
		th{
			margin: 0px;
			width: 50px;
			text-align: center;
		}
		tr{
			text-align: left;
			margin-bottom: 15px;
		}
		textarea{
			width: 95%;
			height: 200px;
			border: none;
		}
		input{
			display: inline;
			border: none;
		}
	</style>
</head>
<body>
	<div class="wrap">
		<table>
			<tr>
				<th>작성자</th>
				<td class="input">${board.name}</td>	
				<th width="50px">조회수</th>
				<td width="50px">${board.readCount}</td>		
			</tr>
			<tr>
				<th>제목</th>		
				<td colspan="3">${board.title}</td>
			</tr>
			<tr>
				<th>내용</th>		
				<td colspan="3"><textarea readonly="readonly">${board.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="button" value="새 글쓰기" onclick="location.href='board?command=board_write_form'" style="margin-left: 20px" >
					<input type="button" value="수정" 
					onclick="open_win('board?command=board_check_pass_form&num=${board.num}','modify')" style="margin-left: 50px" >
					<input type="button" value="삭제" 
					onclick="open_win('board?command=board_check_pass_form&num=${board.num}','delete')" style="margin-left: 50px" >
					<input type="button" value="목록" onclick="location.href='board?command=board_list'" style="margin-left: 250px" >
				</td>
			</tr>
		</table>
		<br>
	</div>
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
				<td class="footer">${board.num}</td>
				<td class="footer"><a href="board?command=board_view&num=${board.num}">${board.title}</a></td>
				<td class="footer">${board.name}</td>
				<td class="footer">${board.writeDate}</td>
				<td class="footer">${board.readCount}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="right">
				<a href="board?command=board_write_form">게시글 등록</a>
			</td>
		</tr>	
	</table>
</body>
</html>
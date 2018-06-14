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
		button{
			border: none;
		}
		#list{
			border-left: none;
		}
		.writer{
			display: none;
		}
	</style>
	<script type="text/javascript">
	
	$(function(){
		<%-- 수정 및 삭제 버튼은 작성자가 접근했을 경우에만 생성한다.--%>
		if(("${writerId}")==("${userId}")) {
			$(".writer").show();
		}else {
			$(".writer").hide();
		}
<%-- 		
		<% if(session.getAttribute("userId")!=null) {
			%>
			$(".login").show();
// 			$("#modify").show();
// 			$("#delete").show();
			<%
		} else {
		%>
			$(".login").hide();
			//$("#modify").css("display","none");
			//$("#delete").hide();
			<%
		}
		%>
		 --%>
	});	
	function deleteBoard() {
		var check = confirm("이 글을 삭제할까요?");
		if(check) {
			location.href ='board?command=board_delete&num=${board.num}';
		} else {
			return false;
		}
	}
	function modifyBoard() {
		location.href ='board?command=board_modify_form&num=${board.num}';
	}
	</script>
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
				<td colspan="3">
					<input type="button" value="새 글쓰기" onclick="location.href='board.do?command=board_write_form'" style="margin-left: 20px">
					<button onclick="modifyBoard();" style="margin-left: 30px" id="modify" class="writer">수정</button>
					<button onclick="deleteBoard();" style="margin-left: 295px" id="delete" class="writer">삭제</button>
				</td>
				<td>
					<input type="button" value="목록" onclick="location.href='board?command=board_list'" id="list">
				</td>
			</tr>
		</table>
		<jsp:include page="comment.jsp">
			<jsp:param name="num" value="${num}"/>
		</jsp:include>
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
				<td class="footer" style="text-align:left" width="250px"><a href="board?command=board_view&num=${board.num}">${board.title}</a></td>
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
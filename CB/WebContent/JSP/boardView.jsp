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
	<script type="text/javascript">
		$(function(){
			<%-- 수정 및 삭제 버튼은 작성자가 접근했을 경우에만 생성한다.--%>
			if(("${writerId}")==("${userId}")) {
				$(".writer").show();
			}else {
				$(".writer").hide();
			}
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
<body background="IMG/simpson2.png" style="background-repeat: no-repeat;">
	<div class="wrap" id="boardViewDiv">
		<table id="boardViewTable">
			<tr class="boardViewTr">
				<td class="boardViewTd">작성자</td>
				<td class="input" width="200px"><span style="font-size: 14px; font: bold; color:black;">${board.name}</span></td>	
				<td class="boardViewTd">조회수</td>
				<td width="50px">${board.readCount}</td>		
			</tr>
			<tr class="boardViewTr">
				<td class="boardViewTd">제목</td>
				<td colspan="3"><span style="font-size: 14px; font: bold; color:black;">${board.title}</span></td>
			</tr>
			<tr class="boardViewTr">
				<td class="boardViewTd">내용</td>
				<td colspan="3" width="90%"><textarea id="boardViewArea" readonly="readonly" style="background-color:transparent;">${board.content}</textarea></td>
			</tr>
			<tr class="boardViewTr">
				<td colspan="3">
					<input type="button" value="새 글쓰기" class="boardViewBtn" onclick="location.href='board.do?command=board_write_form'" style="margin-left: 20px">
					<button onclick="modifyBoard();" class="boardViewBtn" style="margin-left: 30px" id="modify" class="writer">수정</button>
					<button onclick="deleteBoard();" class="boardViewBtn" style="margin-left: 250px" id="delete" class="writer">삭제</button>
				</td>
				<td>
					<input type="button" value="목록" class="boardViewBtn" onclick="location.href='board?command=board_list'" id="list">
				</td>
			</tr>
		</table>
		<jsp:include page="comment.jsp">
			<jsp:param name="num" value="${num}"/>
			<jsp:param name="size" value="${size}"/>
		</jsp:include>
		<br>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="CSS/board.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous">
	</script>
	<style type="text/css">
	</style>
	<script type="text/javascript">
		document.title = "[수정] ${title}";
		$(function(){
			$(".input").blur(function(){
				if(($(this).val())=="") {
					$(this).siblings().text('필수입력 항목');
				}
				return false;
			});
		});
	</script>
	<title></title>
</head>
<body background="IMG/simpson3.png" style="background-repeat: no-repeat;">
	<div class="wrap" id="boardModifyDiv">
		<h1>게시글 수정하기</h1>
		<h5>*는 필수입력 항목입니다.</h5>
		<form name="frm" action="board" method="post">
			<input type="hidden" name="command" value="board_modify">
			<input type="hidden" name="num" value="${param.num}">
			<table id="boardModifyTable">
				<tr class="boardModifyTr">
					<th class="boardModifyTh">*작성자</th>
					<td><span class="span" id="name" class="input" style="color:black">${board.name}</span></td>
				</tr>
				<tr class="boardModifyTr">
					<th class="boardModifyTh">*제목</th>
					<td><input type="text" id="title" name="title" class="input" value="${board.title}"><span class="boardModifySpan"></span></td>
				</tr>
				<tr class="boardModifyTr">
					<th class="boardModifyTh">*내용</th>
					<td><textarea name="content" id="boardModifyTextArea">${board.content}</textarea></td>
				</tr>
				<tr class="boardModifyTr">
					<td colspan="4">
						<input style="margin-left: 100px" type="submit" value="등록">
						<input style="margin-left: 300px" type="button" value="취소"
							onclick="location.href='board?command=board_view&num=${board.num}'">
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
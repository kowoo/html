<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="CSS/board.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>새 글 작성</title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous">
	</script>
	<style type="text/css">
	div, form, table {
		margin: 0 auto;
	}
	div {
		text-align: center;
	}
	th {
		margin: 0px;
		width: 150px;
	}
	tr {
		text-align: left;
		margin-bottom: 15px;
	}
	textarea {
		width: 95%;
		height: 200px;
	}
	.input {
		width: 60%;
	}
	span {
		font-size: small;
		color: red;
	}
	</style>
	<script type="text/javascript">
	
	$(function(){
		
		$(".input").blur(function(){
			if(($(this).val())=="") {
				$(this).siblings().text(' 필수 입력');
			}
			return false;
		});
	});
	</script>
</head>
<body background="IMG/simpson4.png" style="background-repeat: no-repeat;">
	<div class="wrap" id="boardWriteDiv">
		<h1 style="color:black">자유게시판 / 글쓰기</h1>
		<h5>*는 필수입력 항목입니다.</h5>
		<form name="frm" action="board" method="post" id="boardWriteForm">
			<input type="hidden" name="command" value="board_write">
			<input type="hidden" id="userId" name="userId" value="${userId}">
			<table id="boardWriteTable">
				<tr class="boardWriteTr">
					<th class="boardWriteTh">*작성자</th>
					<td><input type="text" id="name" name="name" class="input" value="${name}" readonly="readonly"><span class="boardWriteSpan"></span></td>
				</tr>
				<tr class="boardWriteTr">
					<th class="boardWriteTh">*제목</th>
					<td><input type="text" id="title" name="title" class="input"><span class="boardWriteSpan"></span></td>
				</tr>
				<tr class="boardWriteTr">
					<th class="boardWriteTh">*내용</th>
					<td><textarea name="content"  id="boardWriteTextArea"></textarea></td>
				</tr>
				<tr class="boardWriteTr">
					<td colspan="4">
						<input style="margin-left: 100px" type="submit" value="등록">
						<input style="margin-left: 300px" type="button" value="취소"
							onclick="location.href='board?command=board_list'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
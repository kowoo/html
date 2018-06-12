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
		span {
			font-size: small;
			color: red;
		}
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
<body>
	<div class="wrap">
		<h1>게시글 수정하기</h1>
		<h5>*는 필수입력 항목입니다.</h5>
		<form name="frm" action="board" method="post">
			<input type="hidden" name="command" value="board_modify">
			<input type="hidden" name="num" value="${param.num}">
			<table>
				<tr>
					<th>*작성자</th>
					<td><input type="text" id="name" name="name" class="input" value="${board.name}"><span class="span"></span></td>
				</tr>
				<tr id="passTap">
					<th>*비밀번호 설정</th>
					<td><input type="password" id="pass" name="pass" class="input" value="${board.pass}"><span class="span"></span></td>
				</tr>
				<tr>
					<th>*제목</th>
					<td><input type="text" id="title" name="title" class="input" value="${board.title}"><span class="span"></span></td>
				</tr>
				<tr>
					<th>*내용</th>
					<td><textarea name="content">${board.content}</textarea></td>
				</tr>
				<tr>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script
	  src="https://code.jquery.com/jquery-3.3.1.min.js"
	  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	  crossorigin="anonymous">
	</script>
	<link rel="stylesheet" type="text/css" href="CSS/board.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript">
		$(function(){
			//ajax로 해보자!
			$("#commentForm").on("submit",function() {
				var c = $(this).serialize();
				$.ajax({
					url: "comment.do?command=comment_write",
					data: c,
					type: "post",
					dataType: "json",
					success: function(data) {
						createList();
					},
					error: function(data) {
						alert("로그인을 해주세요!");
					}
				});
				return false;
			});
			createList();
		});
		function createList() {
			var table = $("#commentListTable");
			$("#commentListTable tr:gt(0)").remove();
			var num = ${num};
			$.ajax({
				url: "comment?command=comment_list",
				type: "get",
				data: {"num": num},
				dataType: "json",
				success: function(data) {
					for(var i in data) {
						var tr = $("<tr>");
						var btn = $("<input type='button' value='x' class='btn'>");
						$("<td class='commentTd'>").text(data[i].name).appendTo(tr);
						$("<td>").text(data[i].text).appendTo(tr);
						$("<td class='commentTd'>").text(data[i].writeDate).appendTo(tr);
						$("<td class='commentTd'>").append(btn).appendTo(tr);
						tr.appendTo(table);
						
						(function(m) {
							btn.on("click",function(){
								var check = confirm("이 덧글을 삭제할까요?");
								if(check) {
									$.ajax({
										url:"comment?command=comment_delete",
										data: {"count":data[m].count},
										type: "post",
										dataType: "json",
										success: function(data) {
											createList();
										}
									});
								}else {
									return false;
								}
							});
						})(i);
					}
				}
			});
		}
	</script>
	<title></title>
</head>
<body>
	<div id="wrap">
		<p id="commentCount">댓글 ${size}개</p>
		<table class="commentListTable" id="commentListTable" border="1">
			<colgroup>
				<col width="100px">
				<col width="400px">
				<col width="150px">
				<col width="30px">
			</colgroup>
			<tr bgcolor="gray">
				<th width="100px">닉네임</th>
				<th width="400px">내용</th>
				<th width="150px">작성일</th>
				<th width="30px">삭제</th>
			</tr>
		</table>
		<form action="comment" id ="commentForm" method="post">
			<input type="hidden" id="num" name="num" value="${num}">
			<input type="hidden" id="command" value="comment_write">
			<table class="commentListTable">
				<tr height="50px">
					<td><textarea id="text" class="commentWriteText" name="text"></textarea></td>
					<td width="30px"><input type="submit" value="등록"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>

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
			var table = $("#listTable");
			$("#listTable tr:gt(0)").remove();
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
						$("<td>").text(data[i].name).appendTo(tr);
						$("<td>").text(data[i].text).appendTo(tr);
						$("<td>").text(data[i].writeDate).appendTo(tr);
						$("<td>").append(btn).appendTo(tr);
						tr.appendTo(table);
						
						(function(m) {
							btn.on("click",function(){
								$.ajax({
									url:"comment?command=delete",
									data: {"count":data[m].count},
									type: "post",
									dataType: "json",
									success: function(data) {
										createList();
									}
								});
							});
						})(i);
					}
				}
			});
		}
		function delBtn() {
			var check = confirm("이 글을 삭제할까요?");
			if(check) {
				$.ajax({
					url: "comment?command=delete",
					data: this.val(),
					type: "post",
					dataType: "json",
					success: function(data) {
						if(data.result) {
							createList();
						}else {
						}
					}
				});
			}else {
				return false;
			}
		}
	</script>
	<style type="text/css">
		table{
			text-align: center;
		}
		.title{
			text-align: left;
		}
		h4{
			text-align: left;
			margin-left: 100px;
		}
		fieldset{
			width: 370px;
			font-size: 12px;
			line-height: 24px;
			margin: 0;
			margin-left: auto;
			margin-right: auto;
		}
		#text{
			width: 100%;
			height: 60px;
		}
		#btn{
			margin-left: 20px;
		}
	</style>
	<title></title>
</head>
<body>
	<div id="wrap" align="center">
		<h4>댓글 ["${title}"]개</h4>
		<table id="listTable" border="1">
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
		<form action="comment" id ="commentForm">
			<input type="hidden" id="num" name="num" value="${num}">
			<input type="hidden" id="command" value="comment_write">
			<table>
				<tr height="50px">
					<td><textarea id="text" name="text"></textarea></td>
					<td width="30px"><input type="submit" value="등록"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>

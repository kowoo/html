<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="CSS/board.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous">
	</script>
	<style type="text/css">
		#header{
			width: 600px;
			height: 50px;
			margin: 0;
			margin-left: auto;
			margin-right: auto;
			background-color: black;
		}
		.headerA{
			display: inline;
			margin-right: 15px;
		}
		.headerB{
			display: inline;
		}
		h2{
			margin-right: 350px;
		}
		.headername{
			width: 129px;
			height: 32px;
			display: inline;
			margin: 5px;
			left: 10px;
			margin-right: 250px;
		}
		#loginin, #logoutout #modify{
			display: none;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			<% if(session.getAttribute("userId")!=null) {
				%>
				$("#loginin").hide();
				$("#logoutout").show();
				$("#modify").show();
				<%
			} else {
			%>
				$("#logoutout").hide();
				$("#modify").hide();
				$("#loginin").show();
// 				$("#loginin").css("display","inline");
// 				$("#logoutout").css("display","none");
				<%
			}
			%>
		});
		
	</script>
</head>
<body>
	<div id="wrap">
		<div id="header" align="center"><a href=""></a>
			<!-- 129x32 사이즈 -->
			<img alt="자유게시판" class="headername" src="IMG/board1.png" onclick="location.href='board?command=board_list'">
			<!--<h2 class="headerA" style="color:white" onclick="location.href='board?command=board_list'">문의게시판</h2> -->
			<a href="member?command=member_login_form" style="color:white" class="headerA" id="loginin"><small>로그인</small></a>
			<a href="member?command=member_logout" style="color:white" class="headerA" id="logoutout"><small>로그아웃</small></a>
			<a href="member?command=member_modify_form&id=${userId}" style="color:white" class="headerA" id="modify"><small>정보수정</small></a>
			<a href="member?command=member_join_form" style="color:white" class="headerB"><small>회원가입</small></a>
		</div>
	</div>
</body>
</html>
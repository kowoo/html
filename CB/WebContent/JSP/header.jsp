<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="CSS/board.css?ver=3">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous">
	</script>
	<style type="text/css">
	
	</style>
	<script type="text/javascript">
		$(function(){
			<% if(session.getAttribute("userId")!=null) {
				//로그인
				%>
				$(".logoutState").hide();
				$(".loginState").show();
				<%
			} else {
				//비로그인
			%>
			$(".loginState").hide();
			$(".logoutState").show();
				<%
			}
			%>
		});
	</script>
</head>
<body>
	<div id="wrap">
		<div class="headerDiv">
			<h2 class="headerH2"><a class="headername" href="board?command=board_list">자유게시판</a></h2>
			<a href="member?command=member_login_form" style="margin-right:15px;" class="logoutState" id="login"><small>로그인</small></a>
			<a href="member?command=member_logout" class="loginState" id="logout"><small>로그아웃</small></a>
			<a href="member.do?command=member_modify_form&id=${userId}" class="loginState" id="modify"><small>정보수정</small></a>
			<a href="member?command=member_join_form" class="logoutState" id="join"><small>회원가입</small></a>
		</div>
	</div>
</body>
</html>
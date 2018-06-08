<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 확인</title>
</head>
<body>
	<!-- 현재페이지 호출 요청의 파라미터에 게시글 번호가 포함되어 있다. -->
	<div align="center">
		<form action="board" name="frm" method="post">
			<input type="hidden" name="command" value="board_check_pass">
			<!-- 다음 페이지로 가면 파라미터의 정보가 사라지기 때문에 처리할 곳에 전달하기 위해 다시 저장함. -->
			<input type="hidden" name="num" value="${param.num}">
			<table>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass" size="20"></td>
				</tr>
			</table>
			<input type="submit" value="확인">
		</form>
	</div>
	<p align="center" style="color:red">${msg}</p>
</body>
</html>
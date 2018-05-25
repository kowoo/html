<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<% String id = request.getParameter("userid"); %>
	<h3>로그인 성공!</h3>
	<%=id%>님 반갑습니다!
	<%-- 널이 나오게 된다.
		왜냐하면 얘가 받은 요청은 파라미터가 존재하지 않기 때문.
		userid의 정보는 로그인체크의 리퀘스트.겟파라미터가 가지고 있음
		이걸 방지하려면 id,pw 정보를 유지해서 받아와야한다.
		이게 forward
	 --%>
</body>
</html>
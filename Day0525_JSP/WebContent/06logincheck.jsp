	<%! 
		String id = "abc";
		String pw = "1234";
	%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 체크</title>
</head>
<body>
	<%-- 여기서 login.jsp에서 보낸 데이터를 받아보자 --%>
	
	<%
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		if(id.equals(userid)) {
			if(pw.equals(userpw)) {
				//로그인 성공하면 화면 이동
				//화면 이동의 방법은 두가지가 있다
				//forward, redirect
				//redirect: 페이지 전환 + 응답 객체가 브라우저에게 새로운 요청을 만들어내게 한다
				//응답객체: response
				//브라우저가 요청을 새롭게 만들게되면 url이 바뀜
				//response.sendRedirect("loginSuccess.jsp");
				//이렇게 보내게 되면 로그인석세스에는 입력받은 userid와 userpw가 전달이 안됨.
				//전달이 되게 하려면 forward가 필요하다
				
				//현재 요청을 유지하면서 화면만 전환
				//forward: 브라우저와는 상관없이 서버내부에서 화면 전환
				RequestDispatcher dispatcher = request.getRequestDispatcher("06loginSuccess.jsp");
				dispatcher.forward(request, response);
				
			} else {
				out.print("비밀번호 불일치"+"<br>");
			}
		} else {
			out.print("아이디 불일치"+"<br>");
		}
	%>
	
	<%-- 입력받은 아이디 : <%= request.getParameter("userid") %><br>
	입력받은 비밀번호 : <%= request.getParameter("userpw") %> --%>
</body>
</html>
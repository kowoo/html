<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>첫 번째 페이지</title>
</head>
<body>
	<%-- 
		JSP 페이지간 데이터를 주고 받거나 공유하기 위해서는 기본객체의 속성을 이용
		1. 기본객체의 속성(Attribute)이용 방법 및 데이터 공유하기
		2. 기본객체의 생명주기 
		pageContext : 페이지 마다 하나씩 생성
		request : 요청 마다 하나 생성
		session : 브라우저 마다 생성
		application : 웹어플리케이션 마다 생성
		
		
		기본객체의 속성에 데이터 넣기
		기본객체.setAttribute("속성이름","데이터");
		
		기본객체 속성 가져오기
		기본객체.getAttribute("속성이름");
		
		객체 생명주기 확인하는 법 == 객체가 바뀌었는지 안바뀌었는지 확인
			1)속성을 집어넣는다
			2)속성을 꺼내온다
			3)집어넣은 속성과 동일한 속성이면 기존 객체, 없다면 새로운 객체
	 --%>
	 	
 	<%
 		pageContext.setAttribute("name", "첫 번째 페이지 객체");
 		request.setAttribute("name", "첫 번째 페이지 요청 객체");
 		session.setAttribute("name", "첫 번째 페이지 섹션 객체");
 		application.setAttribute("name", "첫 번째 페이지 어플리케이션 객체");
 	%>
 	
 	pageContext 속성: <%= pageContext.getAttribute("name") %> <br>
 	request 속성: <%= request.getAttribute("name") %> <br>
 	session 속성: <%= session.getAttribute("name") %> <br>
 	application 속성: <%= application.getAttribute("name") %> <br>
 	
 	<%-- 포워딩으로 페이지 이동 --%>
 	<%
 		RequestDispatcher dispacher;
 		dispacher = request.getRequestDispatcher("02secondPage.jsp");
 		dispacher.forward(request, response);
 	%>
	 
</body>
</html>
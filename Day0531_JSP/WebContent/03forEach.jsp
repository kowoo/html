<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 				바	아이템 	-->
<!-- 	for(Student s:sList) {	-->
<!-- 	} 						-->
	<%-- forEach 태그 연습
		배열, 컬렉션, 맵 등에 있는 값들을 순차적으로 접근해서 처리한다
		items : 순차적으로 접근하고자 하는 데이터들의 모음
		var : 각 회차에서 요소가 저장될 변수의 이름 
		begin : 시작인덱스 설정
		end : 종료 인덱스 설정
		step : 인덱스 증가분 설정
	--%>
	
	<%
		String[] movieList = {"독전","데드풀2","데자뷰","데자뷰","스탠바이,웬디","어벤져스"};
		request.setAttribute("mList",movieList);
	%>
	
	<c:forEach items="${mList}" var="movie">
		${movie} <br>
	</c:forEach>
	
</body>
</html>
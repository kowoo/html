<%@page import="model.Members"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <c:set var="변수명"> : jsp에서 사용할 변수 선언 및 속성 지정
				el에서도 사용 가능하다! --%>
<c:set var="msg">HELLO</c:set>
<c:set var="member" value="<%=new Members()%>"/>

<c:set var="map" value = "<%=new HashMap<String,Object>()%>" scope="request"></c:set>
<%-- 만들어진 속성에 값 넣기 --%>
<c:set target="${map}" property="name" value="홍길동"/>
<c:set target="${member}" property="name" value="홍길순"></c:set>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL</title>
</head>
<body>
	<%-- JSTL 사용하기 
		외부라이브러리, 라이브러리만 가져오면된다.
		1. WEB-INF/lib에 jst1-1.2.jar 복사
		2. 디렉티브에 태그 라이브러리를 사용함을 선언
		<%@ taglib %> 
		
		코어태그
		set, remove, forEach, choose, when otherwise, if 등 등
	 --%>
	 msg : ${msg}<br>
	 map : ${map}<br>
	 map[name] : ${map["name"]}<br>
	 member.name : ${member.name} <br>
	 map.name : ${map.name} <br>
	 
	 <c:remove var="member"/>
	 삭제 후 member.name : ${member.name}<br>
	 
</body>
</html>
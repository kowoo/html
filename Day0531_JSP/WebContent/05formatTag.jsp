<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>formatTag</title>
</head>
<body>
	<%-- 
		fmt
		데이터의 출력 형식 지정
		날짜,숫자
		
		<fmt:~~~>
		<fmt:formatNumber>	: 숫자 포맷지정
		<fmt:formatDate>	: 날짜 포맷지정
		
	--%>

	<c:set var="price" value="10000000"/>
	<%-- 숫자 포맷 설정 --%>
	숫자	 : <fmt:formatNumber type="number" value="${price}"/> <br>
	퍼센트 : <fmt:formatNumber type="percent" value="${price}"/> <br>
	통화	 : <fmt:formatNumber type="currency" value="${price}"/> <br>
	패턴	 : <fmt:formatNumber pattern="00,000,000.00" value="${price}"/> <br>
	
	<c:set var="today" value="<%=new Date()%>"/>
	<%-- 날짜 포맷 설정 --%>
	date :<fmt:formatDate type="date" value="${today}"/> <br>	
	time :<fmt:formatDate type="time" value="${today}"/> <br>
	both :<fmt:formatDate type="both" value="${today}"/> <br>
	pattern :<fmt:formatDate type="both" value="${today}" pattern="YYYY-MM-DD HH:mm:ss"/> <br> 
</body>
</html>






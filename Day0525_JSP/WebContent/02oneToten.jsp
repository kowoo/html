<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<%!	
		//선언부에 선언한 변수는 변환되는 서블릿의 멤버변수로 선언된다.
		int sumNum;
		public int sum(int num) {
			int sum = 0;
			for (int i=1; i<=num; i++) {
				sum += i;
			}
			return sum;
		}
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1부터 10까지</title>
</head>
<body>
	<%-- 1부터 10까지 더하는 프로그램 작성
		스크립트릿 사용하기!
		스크립트릿(sriptlet)
		표현부(expression)
		선언부(declaration)
	--%>
	
	
	<%
//		int sumNum = 0;
//		for (int i=1; i<=10; i++) {
//			sumNum += i;
//		}
		sumNum = sum(8);
	%>
	
	1부터 10까지의 합은 <%= sumNum %>
	
	<%-- 두 숫자를 입력받아서 곱을 화면에 출력하는 multiply.jsp를 작성하자 --%>

</body>
</html>
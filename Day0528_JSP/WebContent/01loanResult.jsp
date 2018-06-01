<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Loan Result</title>
	<style type="text/css">
		table, td, th{
			border: 1px solid black;
			border-collapse: collapse;
			text-align: center;
			padding: 5px;
			font-size: 13px;
		}
		table{
			margin: 0px auto;
		}	
	</style>
</head>
<body>
	<!-- 
		요청에 포함된 파라미터를 받아와서 데이터 기준으로 표만들기
		파라미터는 모두 문자열또는 문자열임
	 -->
	
	<%
	 	String amountStr = request.getParameter("amount");
	 	String rateStr = request.getParameter("rate");
	 	String periodStr = request.getParameter("period");
	 	String typeStr= request.getParameter("type");
	 
	 	int amount = Integer.parseInt(amountStr);
	 	double rate = Double.parseDouble(rateStr);
	 	int period = Integer.parseInt(periodStr);
	 	int type = Integer.parseInt(typeStr);
	 	double mRate = rate/100/12;
	 	
	%>
	
	
	<form action="#">
		<table>
			<tr>
				<th>회차</th>
				<th>상환액</th>
				<th>상환원금</th>
				<th>이자</th>
				<th>상환총액</th>
				<th>잔액</th>
			</tr>
	<!-- 상환개월 수에 맞춰서 열이 늘어나야 하므로 열의 숫자는 동적이어야함. for문을 이용하자 -->
	<%
		//상환 관련 변수 선언
		//상환액: repayTotal (월 상환원금+이자)
		//상환 원금: repayOrigin (월 상환원금)
		//이자: interest
		//상환총액: repaySum (현재까지 갚은 금액)
		//대출잔액: repayRemain
		int repayTotal,repayOrigin,interest,repaySum,repayRemain;
		
		int repayMonth;
		//두 가지 방식으로 계산해야함
		if(type==1) {
			repayMonth = amount/period; 
		}else {
			repayMonth = (int)((amount*mRate*Math.pow((1+mRate),period))/(Math.pow(1+mRate,period)-1));
		}
		//원금 균등상환: repayMonth + 이자
		//원리금 균등상환: repayMonth;
		//원리금 균등상환 계산식: (원금*월이율*Math.pow((1+월이율),period))/(Math.pow(1+월이율,period)-1)
		//AB(1+B)^n/(1+B)^n-1
		//A: 원금, B: 
		repayRemain = amount;
		repaySum= 0;
		
	%>
	
	<%
		for(int i=1; i<=period; i++) {
			interest = (int)(repayRemain*mRate);
			
			if(type==1) {
				//원금 균등상환
				repayTotal = repayMonth+interest;//이번달 내야할 금액
				repayOrigin = repayMonth;//이번달 내야할 원금
			}else {
				//원리금 균등상환
				repayTotal = repayMonth;
				repayOrigin = repayMonth-interest;
			}
			repayRemain = repayRemain-repayOrigin;
			repaySum+= repayTotal;
			%>
			<tr>
				<td><%=i%>회차</td>
				<td><%=repayTotal %></td>
				<td><%=repayOrigin %></td>
				<td><%=interest %></td>
				<td><%=repaySum %></td>
				<td><%=repayRemain %></td>
			</tr>
			<%
		}
	
	%>
		</table>
	</form>
</body>
</html>
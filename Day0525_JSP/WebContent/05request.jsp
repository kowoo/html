<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>��û ��ü ����</title>
</head>
<body>
	<%--
		Ŭ���̾�Ʈ�� ��û�� �ϰ� �Ǹ�, ������ ��û������ Ȯ���ϰ� ������ ������.
		JSP������ ��û������ Ȯ���� �� �ִ� ���尴ü: request
		���������� ��û ������ �����ϴ� ��ü, Ŭ���̾�Ʈ �� ���� ������ ������ �ִ�.
	
		�α��� ȭ���� ������
		1. ������� ���̵�, ��й�ȣ�� �޾Ƽ� ������ ����
		*requset��ü���� Ŭ���̾�Ʈ�� ������ ������ ���ԵǾ� �ִ�
		
		���ؽ�Ʈ ���
		������Ʈ�� ��ġ(������ ����Ǵ� ����)
		
		Ŭ���̾�Ʈ���� ������ ������ �޾ƿ���
		login.jsp
	 --%>
	
	Ŭ���̾�Ʈ IP = <%=request.getRemoteAddr()%><br>
	��û���� ���� = <%=request.getContentLength()%><br>
	��û URI = <%=request.getRequestURI()%><br>
	���ؽ�Ʈ ��� = <%=request.getContextPath()%><br>

	
	
	
		 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Members" %>
<%--
	빈(Bean)객체 하나 만들어서 포워드.
 --%>
<jsp:useBean id="member" class="model.Members" scope="request"></jsp:useBean>
<jsp:setProperty property="address" name="member" value="서초구"/>
<%
// 	Member member = new Member();
// 	member.setAddress("서초구");
// 	request.setAttribute("member",member); 10~12 번째 줄 == 7~8번째 줄 ㅇㅋ?
	member.setId("bitcamp");
	member.setName("홍길동");
%>
<jsp:forward page="02useBean.jsp"/>
<%--
	<jsp:useBean id="" class="" scope="">
	javaBean: javaBean 규약에 맞춰서 클래스로 생성한 객체
	id = "s1" : bean 인스턴스 이름, Student s1 = new Student();
	class : bean 객체의 참조 클래스
	scope : bean 라이프 사이클 관리
		(page, request, session, application)
		(default = page)
		
	<jsp:setProperty> : 빈의 속성을 설정하는 액션태그
		name 	: 속성지정하고자 하는 bean의 식별자(id)
        property: 설정하고자 하는 bean의 속성이름(setter의 이름 setId이면 여기서 set을 빼고 i를 소문자로 해야함. 그냥 id로 적으면 setId로 인식한다는뜻)
        value   : 설정하고자 하는 값
    <jsp:getProperty> : 빈객체의 속성을 가져오는 액션 태그
 --%>

message table 작성

id : number(10),primary key
password : varchar2(50), not null
name : varchar2(20) 기본값 '이름없음', not null
message : varchar2(500)
시퀀스만들기: message_seq
id는 시퀀스로 생성
dao
	MessageDao
model
	Message
service
	MessageService
servlet
	MessageServlet

요청 
	messageList
	write
화면 목록
	messageList.jsp
























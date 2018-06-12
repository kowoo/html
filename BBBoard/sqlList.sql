create table members(
id varchar2(16),
pw varchar2(16),
nick varchar2(12));

insert into members values 
 ('user1','1','뉴비');
 
select 
* from member;
drop table member;

create table member(
id varchar2(14) primary key,
pw varchar2(14) not null,
name varchar2(14) not null,
email varchar2(20) not null,
regdate date default sysdate);

commit;


alter table member add unique(id);
select * from member where id='abcd';

create table message(
id number(10) primary key,
password varchar2(50) not null,
name varchar2(20) default '이름없음' not null,
message varchar2(500) );

create table board(
id number(10) primary key,
rownum number(10) unique,
password varchar2(50) not null,
name varchar2(20) default '이름없음' not null,
message varchar2(500) );

commit;
insert into message (id, password, message) values (message_seq.nextval, '1', '1'); 
insert into message (id, password, message) values (message_seq.nextval, '1', '2'); 
insert into message (id, password, message) values (message_seq.nextval, '1', '3'); 
insert into message (id, password, message) values (message_seq.nextval, '1', '4'); 
insert into message (id, password, message) values (message_seq.nextval, '1', '5'); 
insert into message (id, password, message) values (message_seq.nextval, '1', '22');

select * from message;
select * from member;

drop table message;
alter table message modify(name varchar2(20) constraint massage_name not null);

select message_seq.currval from dual;

alter table message add constraint massage_name not null;

create sequence message_seq start with 1 increment by 1 maxvalue 99999 cycle;

alter sequence message_seq increment by -2;
alter sequence message_seq increment by 1;

select table_name,constraint_name,constraint_type
  from user_constraints
 where table_name = 'MASSAGE';
 
 select * from member;
 select * from message order by id desc;
 
 delete from message where id= 4;
 
 페이징처리;
 select id,password,name,message
   from message
where id between 1 and 10;

  select * from (select id,password,name,message
    from message
    order by id desc) m
   where m.id between 1 and 10;
 
select *
  from (select rownum as rnum,
    m.id,
    m.password,
    m.name,
    m.password
  from (select id,password,name,message
  from message
order by id desc)m );

commit;

alter table message add(rownum number(10));
select * from message;
select * from (select rownum as rnum, m.id, m.password, m.name, m.message
		 from (select id,password,name,message 
		 from message
         order by id desc) m ) 
		 where rnum between 1 and 10;
         
drop table member;
create table member(
id varchar2(20) primary key,
pw varchar2(20) not null,
name varchar2(20) not null,
email varchar2(50) not null);

commit;
select * from member;

insert into member values ('aaa','aaa','고우혁a','aaa@aa.a');
insert into member values ('bbb','bbb','고우혁b','bbb@bb.b');

create table message(
id number(10) primary key,
password varchar2(50) not null,
name varchar2(20) default '이름없음' not null,
message varchar2(500) );

create table uploadfile(
	filename varchar2(100) primary key,
	writedate date default sysdate
);
commit;

select * from uploadfile;

create table files(
	filename varchar2(100) primary key,
	writedate date default sysdate
);

delete uploadfile;


drop table board;
commit;
create table board(
    num number(10) primary key,
    title varchar2(50) not null,
    name varchar2(30) not null,
    pass varchar2(50) not null,
    email varchar2(50) not null,
    content varchar2(1000),
    readCount number(30) default 0,
    writeDate date default sysdate);

commit;

create sequence board_seq start with 1 increment by 1 maxvalue 99999 cycle;
select * from board;

select board_seq.currval from dual;

create table board2(
    num number(10) primary key,
    title varchar2(50) not null,
    name varchar2(30) not null,
    content varchar2(1000),
    readCount number(30) default 0,
    writeDate date default sysdate);
    
    drop table board2;
    insert into board2 values (board_seq2.nextval,'첫번째 게시글','1번','첫번째 게시글 입니다.',0,sysdate);
    
create table member2(
id varchar2(20) primary key,
pw varchar2(20) not null,
name varchar2(20) unique,
email varchar2(50) not null,
regdate date default sysdate,
boardw number(10) default 0,
commentw number(10) default 0);
alter table member2 add unique(name);

create sequence member_seq2 start with 1 increment by 1 maxvalue 99999 cycle;    
create sequence board_seq2 start with 1 increment by 1 maxvalue 99999 cycle;
alter sequence board_seq2 increment by 1;
insert into board2 values (board_seq2.nextval,'첫번째 게시글','1번','1','첫번째 게시글 입니다.',0,sysdate);

select * from board2;
select * from member2;
select count as 
delete from board2 where num=25;
commit;

select * from (select rownum as rnum,b.id,b.name,b.content
         from (select id,name,content
         from board2 order by id desc)b) where rnum between 1 and 5;

select * from (select rownum as rnum,m.num,m.title,m.writeDate,m.readCount,m.name,m.content from (select num,title,name,writeDate,readCount,content
		from board2 order by num desc) m ) where rnum between 1 and 5;
        
        select count(*) from board2;
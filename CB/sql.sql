 페이징처리;
 select id,password,name,message
   from message
where id between 1 and 10;

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
    writerId varchar2(50) not null,
    title varchar2(50) not null,
    name varchar2(30) not null,
    content varchar2(1000),
    readCount number(30) default 0,
    comments number(20) default 0,
    writeDateString varchar2(40),
    writeDate date default sysdate);
    
    alter table comment2 drop CONSTRAINT fk_board2_num;
    drop table comment2;
    drop table board2;
    insert into board2 values (board_seq2.nextval,'첫번째 게시글','3번','첫번째 게시글 입니다.',0,0,0,sysdate);
    
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

select * from board2;
select * from member2;
select count as ;
delete from board2 where num=99999;
commit;

SELECT TO_CHAR(writeDate,'RRRR-MM-DD HH24:MM') "지금시간"
  from board2 ;

select * from (select rownum as rnum,b.id,b.name,b.content
         from (select id,name,content
         from board2 order by id desc)b) where rnum between 1 and 5;

select * from (select rownum as rnum,m.num,m.title,m.writeDate,m.readCount,m.name,m.content from (select num,title,name,writeDate,readCount,content
		from board2 order by num desc) m ) where rnum between 1 and 5;
        
        select count(*) from board2;
drop table comment2;

create table comment2(
    num number(10) not null,
    count number(30) primary key,
    writerId varchar2(20) not null,
    name varchar2(30) not null,
    text varchar2(1000),
    writeDate date default sysdate,
    CONSTRAINT fk_comment2_num FOREIGN KEY (num) REFERENCES board2(num)
     ON DELETE CASCADE);
     
     select * from board2 where title
    like 1 order by num desc;
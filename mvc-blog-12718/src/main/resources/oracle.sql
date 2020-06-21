drop sequence seq_blog;

drop table blog;

create sequence seq_blog increment by 1 start with 1;

create table blog (
	id number(11) not null primary key,
	title	varchar2(50) not null,
	content	varchar2(200),
	filepath	varchar2(30),
	blogger	varchar2(30),
	reg_date_time	date default SYSDATE
);

INSERT INTO blog(id, title, content, filepath, blogger) VALUES(seq_blog.nextval,'제목-1','블로그 내용-1','01.png','blogger-1');
INSERT INTO blog(id, title, content, filepath, blogger) VALUES(seq_blog.nextval,'제목-2','블로그 내용-2','02.png','blogger-2');
INSERT INTO blog(id, title, content, filepath, blogger) VALUES(seq_blog.nextval,'제목-3','블로그 내용-3','03.png','blogger-3');
INSERT INTO blog(id, title, content, filepath, blogger) VALUES(seq_blog.nextval,'제목-4','블로그 내용-4','04.png','blogger-4');
INSERT INTO blog(id, title, content, filepath, blogger) VALUES(seq_blog.nextval,'제목-5','블로그 내용-5','05.png','blogger-5');
INSERT INTO blog(id, title, content, filepath, blogger) VALUES(seq_blog.nextval,'제목-6','블로그 내용-6','06.png','blogger-6');
INSERT INTO blog(id, title, content, filepath, blogger) VALUES(seq_blog.nextval,'제목-7','블로그 내용-7','07.png','blogger-7');
INSERT INTO blog(id, title, content, filepath, blogger) VALUES(seq_blog.nextval,'제목-8','블로그 내용-8','08.png','blogger-8');

select * from blog;

update blog set blogger='member1' where id=1;

update blog set title='update제목', content='update 내용', filepath='ddochi.png', 
reg_date_time=TO_TIMESTAMP('2019-11-11 11:11:00', 'YYYY-MM-DD HH24:MI:SS')  where id=47;

select * from blog where id=31;

drop sequence seq_blogger;

drop table blogger;


create sequence seq_blogger increment by 1 start with 1;

create table blogger ( 
	id number(11) not null primary key,
	bid	varchar2(50) not null, 
	bpw	varchar2(20) not null, 
	bname	varchar2(30), 
	bemail	varchar2(30)
);

INSERT INTO blogger VALUES(seq_blogger.nextval,'admin12718','cometrue','관리자','admin@induk.ac.kr');

update blogger set bid='admin12718' where id=1;

select * from blogger;
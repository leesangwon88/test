create table zzamoa_member(
	mb_id varchar2(20 char) primary key,
	mb_pw varchar2(20 char) not null,
	mb_name varchar2(20 char) not null,
	mb_photo varchar2(200 char) not null,
	mb_master char(1) not null
)

select * from ZZAMOA_MEMBER;

select * from ZZAMOA_MEMBER where mb_id like '2'

insert into zzamoa_member values('ree', 'ree', '이상원', 'X', '0')

update zzamoa_member set mb_pw='2', mb_name='2', mb_photo='2' where mb_id = '4'

update zzamoa_member set mb_photo='6.jpg' where mb_id='2'

delete zzamoa_member;

delete from zzamoa_member where mb_id = '4';

drop table zzamoa_member cascade constraint purge;

----------------------------------------------------

create table zzamoa_Tag(
	tag_type char primary key,
	tag_list varchar2(200 char) not null
)

select * from zzamoa_Tag

insert into zzamoa_Tag values(0, '태그 태그2 태그3 태그4')

update zzamoa_Tag set tag_list='안태그1 안태그2 김태그' where tag_type = 0

delete from zzamoa_Tag

drop table zzamoa_Tag cascade constraint purge;


----------------------------------------------------

create table zzamoa_photolist(
	pl_number number(5) primary key,
	pl_photo varchar2(200 char) not null,
	pl_thumbnail varchar2(200 char) not null,
	pl_tag varchar2(200 char) not null,
	pl_view varchar2(1 char) not null,
	pl_date date not null
)

select * from zzamoa_photolist;

create sequence zzamoa_photolist_seq;

insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'test.jpg', 'test.jpg', '테스트 테스트2', '1', sysdate);

select * from zzamoa_photolist where pl_tag like '%짤%'

select * from zzamoa_photolist where pl_number like '52'

update zzamoa_photolist set pl_tag='보노보노 X같은' where pl_number = '72'

update zzamoa_photolist set pl_view='1' where pl_number = '634'


update zzamoa_photolist set pl_thumbnail='보노보노 X같은' where pl_number = '72'

select * from(
	select rownum as rn, pl_number, pl_photo, pl_thumbnail, pl_tag
	from (
		select *
		from zzamoa_photolist
		order by pl_date
	)
)
order by rn desc;

	select * from (select rownum as rn, pl_number, pl_photo, pl_thumbnail, pl_tag 
	from (select * from zzamoa_photolist where pl_view = '1' order by pl_date )) 
	where rn >= 0 and rn <= 1000 order by rn desc;



delete from zzamoa_photolist where pl_number = '101';

delete zzamoa_photolist;

drop table zzamoa_photolist cascade constraint purge;




insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '1.gif', 's1.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '2.gif', 's2.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '3.gif', 's3.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '4.gif', 's4.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '5.gif', 's5.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '6.gif', 's6.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '7.gif', 's7.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '8.gif', 's8.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '9.gif', 's9.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '10.gif', 's10.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '11.gif', 's11.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '12.gif', 's12.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '13.gif', 's13.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '14.gif', 's14.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '15.gif', 's15.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '16.gif', 's16.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '17.gif', 's17.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '18.gif', 's18.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '19.gif', 's19.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '20.gif', 's20.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '21.gif', 's21.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '22.gif', 's22.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '23.gif', 's23.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '24.gif', 's24.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '25.gif', 's25.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '26.gif', 's26.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '27.gif', 's27.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '28.gif', 's28.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '29.gif', 's29.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '30.gif', 's30.jpg', '움짤 동물 귀여움', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '31.gif', 's31.jpg', '움짤 동물 귀여움', '1', sysdate);

insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (1).jpg', 'is (1).jpg', '마음의소리 조석', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (2).jpg', 'is (2).jpg', '마음의소리 조석', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (3).jpg', 'is (3).jpg', '마음의소리 조석', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (4).jpg', 'is (4).jpg', '마음의소리 조석', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (5).jpg', 'is (5).jpg', '마음의소리 조석', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (6).jpg', 'is (6).jpg', '마음의소리 조석', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (7).jpg', 'is (7).jpg', '마음의소리 조석', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (8).jpg', 'is (8).jpg', '마음의소리 조석', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (9).jpg', 'is (9).jpg', '마음의소리 조석', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (10).jpg', 'is (10).jpg', '마음의소리 조석', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (11).jpg', 'is (11).jpg', '마음의소리 조석', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (12).jpg', 'is (12).jpg', '마음의소리 조석', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (13).jpg', 'is (13).jpg', '마음의소리 조석', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (14).jpg', 'is (14).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (15).jpg', 'is (15).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (16).jpg', 'is (16).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (17).jpg', 'is (17).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (18).jpg', 'is (18).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (19).jpg', 'is (19).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (20).jpg', 'is (20).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (21).jpg', 'is (21).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (22).jpg', 'is (22).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (23).jpg', 'is (23).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (24).jpg', 'is (24).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (25).jpg', 'is (25).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (26).jpg', 'is (26).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (27).jpg', 'is (27).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (28).jpg', 'is (28).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'i (29).jpg', 'is (29).jpg', '이말년 침착맨 이말년시리즈', '1', sysdate);

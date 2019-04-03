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

insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, 'test.jpg', 'test.jpg', '테스트 테스트2', '0', sysdate);

select * from zzamoa_photolist where pl_tag like '%짤%'

select * from zzamoa_photolist where pl_number like '52'

update zzamoa_photolist set pl_tag='보노보노 X같은' where pl_number = '72'



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
	from (select * from zzamoa_photolist order by pl_date )) 
	where rn >= 31 and rn <= 52 order by rn desc;



delete from zzamoa_photolist where pl_number = '101';

delete zzamoa_photolist;

drop table zzamoa_photolist cascade constraint purge;




insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '1.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '2.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '3.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '4.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '5.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '6.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '7.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '8.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '9.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '10.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '11.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '12.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '13.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '14.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '15.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '16.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '17.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '18.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '19.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '20.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '21.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '22.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '23.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '24.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '25.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '26.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '27.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '28.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '29.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '30.gif', '0', '움짤 동물 귀여움', '0', sysdate);
insert into zzamoa_photolist values(zzamoa_photolist_seq.nextval, '31.gif', '0', '움짤 동물 귀여움', '0', sysdate);

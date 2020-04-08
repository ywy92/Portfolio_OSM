create table OSM_MEMBER(
	osm_m_index number(10) primary key,
	osm_m_id varchar2(15) unique not null,
	osm_m_password varchar2(40) not null,
	osm_m_nickname varchar2(15) unique not null,
	osm_m_name varchar2(21) not null check(regexp_like(osm_m_name,'^[가-힣]{2,}')),
	osm_m_birth date not null,
	osm_m_age number(3) check(osm_m_age > 15),
	osm_m_gender char(1) check(osm_m_gender in(0,1)),
	osm_m_zipcode varchar2(6) not null,
	osm_m_address1 varchar2(100) not null,
	osm_m_address2 varchar2(100) not null,
	osm_m_phone varchar2(13) not null,
	osm_m_email varchar2(30) not null,
	osm_m_grant char(1) default 'z' check(regexp_like(osm_m_grant,'[a-z]{1}')),
	osm_m_date date default sysdate
);

select * from OSM_MEMBER where osm_m_id = 'admin'

drop table OSM_MEMBER


select * from OSM_MEMBER

delete from OSM_MEMBER

update OSM_MEMBER set osm_m_grant = 'a'
where osm_m_id = 'admin'

select osm_m_index as "m_index",
	   osm_m_id as "m_id",
	   osm_m_name as "m_name",
	   osm_m_nickname as "m_nickname",
	   osm_m_birth as "m_birth",
	   osm_m_age as "m_age",
	   osm_m_zipcode as "m_zipcode",
	   osm_m_address1 as "m_address1",
	   osm_m_address2 as "m_address2",
	   osm_m_phone as "m_phone",
	   osm_m_email as "m_email",
	   osm_m_date as "m_date",
	   decode(osm_m_gender,'0','남자','여자') "gender",
	   decode(osm_m_grant,'a','운영자','z','일반회원','미정') as "grant"  from OSM_MEMBER




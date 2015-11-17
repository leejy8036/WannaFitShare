--table 삭제
drop table customer;
--table 생성
create table customer(
	cs_id 		varchar2(10) primary key, --primary key 
	cs_password varchar2(15) not null, --pw 6~15자 이하 조건 ,영문+숫자+특수문자
	cs_name 	varchar2(10) not null, --null 제외 조건 
	cs_email	varchar2(20) not null,
	cs_phone	varchar2(20) not null											
);
-- 기본값 설정해주는 방식
-- customerMileage number(7) default 10000 --default는 not null보다 먼저 선언

--insert
insert into customer values ('id-001','1111','유재석', 'ryujs@abc.com','010-6363-0844');
--table customer DB 전체 삭제
delete from customer
--table customer 전체 조회
select * from customer


-- rownum : ResultSet에 생기는 컬럼으로 행번호 값을 가진다.
-- ceil (rownum/10) : 각 행이 포함될 page 번호 ( 10-page당 보여질 데이터(row) 수 ) 

select page, cs_id, cs_password, cs_name, cs_email, cs_phone
from(
	select ceil(rownum/10) page, page, cs_id, cs_password, cs_name, cs_email, cs_phone
	from(
		select page, cs_id, cs_password, cs_name, cs_email, cs_phone
		from customer
			order by cs_id
	)	
)
where page = 1;

--select
-- from select : 각 row에 page(번호) 컬럼 만들기 위해 (rownum 쓰기 위해)
-- from select : 원하는 조건으로 정렬하기 위해

-- 부서 테이블 페이지 처리, 1페이지에 3개씩, 정렬 : 부서이름
-- n 페이지 보는 쿼리문 작성


--select departmentId, departmentName, location
--from(
--select ceil(rownum/3) page, departmentId, departmentName, location
--from(
--select departmentId, departmentName, location
--from department
--order by departmentName
--	)
--)
--where page =3
--
--
--select page, customerId, customerPassword, customerName, customerEmail, customerMileage
--	from(
--			select ceil(rownum/10) page, customerId, customerPassword, customerName, customerEmail, customerMileage
--				from(
--					select customerId, customerPassword, customerName, customerEmail, customerMileage
--					from customer
--					order by customerId
--					)
--	)
--	where page = 1

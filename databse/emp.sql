create database web;
use web;
create table t_emp(
	id int primary key auto_increment,
	name varchar(20),
	salary double,
	gender varchar(2),
	edu varchar(10),
	hobbies varchar(20)
)engine=Innodb default charset=utf8;

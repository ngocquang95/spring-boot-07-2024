create database if not exists student_management_c07;

use student_management_c07;

create table student (
    id int primary key auto_increment,
    name varchar(50),
    score double
);

insert into student (name, score) value ('Hồ Văn Trung', 9.6);
insert into student (name, score) value ('Ngoc Mai', 9.8);
insert into student (name, score) value ('Phương', 9.7);


select id, name, score from student;
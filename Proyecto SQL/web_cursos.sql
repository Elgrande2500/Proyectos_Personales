create database cursos_web;

use cursos_web;

create table user_course (Id_user smallint not null auto_increment primary key, unombre varchar (50), apaterno varchar (20), amaterno varchar (20), 
umail varchar (25), tipo_user varchar (15));

create table courses (Id_course smallint not null auto_increment primary key, cnombre varchar (50), cdescrip varchar (400), cprecio int (4), crama varchar (30),
 cinstructor varchar (30), cduracion varchar (10), ccert varchar (60));

create table discounts_courses (Id_oferta smallint not null auto_increment primary key, Id_user smallint not null references user_course,
 Id_course smallint not null references courses, discoste int (5), disdoc varchar (10), unique (Id_user, Id_course));

create table check_order (Id_order smallint not null auto_increment primary key, check_fecha timestamp, check_conc varchar (50), check_costo int (5), check_costot int (5),
 check_bank int(20), Id_course smallint not null references courses);

create table instructor (Id_instruct smallint not null auto_increment primary key, insnombre varchar (20), insapaterno varchar (20), insamaterno varchar (20),
 insmail varchar (25), insexp varchar (100), insdoc_route varchar (100), instipo_curso varchar (20), Id_course smallint not null references courses);

show tables;

drop database cursos_web;

insert into courses (cnombre, cdescrip, cprecio, crama, cinstructor, cduracion, ccert) values 
('Inversiones en bolsa de valores mexicana', 'Queremos hacer un país de inversionistas, para que las personas tomen el control de sus finanzas y se sientan seguras en momentos de coyuntura como el que estamos atravesando y, por qué no, que también puedan generar nuevas fuentes de ingresos a través de las inversiones', 
150, 'Bolsa de valores', 'Juan Pablo', '20 horas', 'Certificacion finalizacion del curso');

insert into courses (cnombre, cdescrip, cprecio, crama, cinstructor, cduracion, ccert) values 
('Inicio en bases de datos', 'Los objetivos que el estudiante deberá alcanzar al finalizar el curso Bases de datos son Comprender los diferentes modelos de bases de datos, y en concreto dominar el modelo relacional.', 
100, 'Administracion de BD', 'Miguel Angel', '40 horas', 'Certificacion finalizacion del curso');

insert into instructor (insnombre, insapaterno, insamaterno, insmail, insexp, insdoc_route, instipo_curso, Id_course) values ('Miguel Angel', 'Cruz', 'Canedo', 'mikiwarsss@gmail.com', 
'Ingeniero en Informatica', 'C:\Users\Equipo\OneDrive\Fotos\aa', 'Informatica', 2 );

select * from instructor;

select * from courses;


create database BDAlumnos
use BDAlumnos
create table alumno (
   ida int primary key,
   nombre varchar(30),
   fecnac date
)
insert into alumno values(1, 'Luis', '11/12/2000')
insert into alumno values(2, 'Luis', '12/10/1990')
insert into alumno values(3, 'Ana', '13/8/1995')
insert into alumno values(4, 'Elena', '14/7/1998')
insert into alumno values(5, 'Ana', '15/5/2001')
insert into alumno values(6, 'Paco', '15/5/2002')

create table profesor (
   idp int primary key,
   nombre varchar(30),
   departamento varchar(30)
)
insert into profesor values(101, 'Prof1', 'Informática')
insert into profesor values(102, 'Prof2', 'Informática')
insert into profesor values(103, 'Prof3', 'Administrativo')
insert into profesor values(104, 'Prof4', 'Administrativo')
insert into profesor values(105, 'Prof5', 'Inglés')

create table tiene (
   ida int references alumno,
   idp int references profesor,
   tutor bit,
   primary key(ida, idp)
)
insert into tiene values(1,101,0)
insert into tiene values(1,102,1)
insert into tiene values(2,103,1)
insert into tiene values(2,104,0)
insert into tiene values(3,105,1)
insert into tiene values(4,101,0)
insert into tiene values(4,102,0)
insert into tiene values(5,101,0)
insert into tiene values(5,102,0)
insert into tiene values(5,105,1)
insert into tiene values(6,105,1)
insert into tiene values(6,103,0)
insert into tiene values(6,101,0)
insert into tiene values(6,102,0)

create table familiar (
   idf int primary key,
   nombre varchar(30),
   telefono int
)
insert into familiar values(121, 'Fami1', 680680680)
insert into familiar values(122, 'Fami2', 680680681)
insert into familiar values(123, 'Fami3', 680680682)

create table aluMenor (
   idm int primary key references alumno,
   padre int references familiar,
   madre int references familiar
)
insert into aluMenor values(1, 121, 122)
insert into aluMenor values(5, 121, 123)
insert into aluMenor values(6, 121, 122)

create table ciclosInfor (
   idc char(3) primary key,
   nomCiclo varchar(40)
)
insert into ciclosInfor values('DAM','Desarrollo Multiplataforma')
insert into ciclosInfor values('DAW','Desarrollo Web')
insert into ciclosInfor values('SIM','Sistemas Inórmáticos')

create table aluInfor (
   idi int primary key references alumno,
   ciclo char(3) references ciclosInfor
)
insert into aluInfor values (1, 'DAM')
insert into aluInfor values (2, 'DAM')
insert into aluInfor values (5, 'SIM')

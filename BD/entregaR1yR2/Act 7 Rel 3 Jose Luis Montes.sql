/*

	Actividad 7: Los 100tificos :)

*/
create database Rel3
use Rel3


create table cientifico(
	dni varchar(8) primary key,
	nomApels nvarchar(255)
)

create table proyecto(
	id int identity(1,1) primary key,
	nombre nvarchar(255),
	horas int
)

create table asignadoA(
	proyecto int references proyecto(id),
	cientifico varchar(8) references cientifico(dni)
)

insert into cientifico
	values('77889966','Placido Hoy')
		('11223344','David Catastro'),
		('44332211','Josemi Iañhes'),
		('55668899','Daniel Tajo'),
		('77445588','Yo Patata'),
		('55663322','Manuer Jaba')
		
insert into proyecto
	values('Proyecto Mare Nostrum',100),
		('Proyecto Precious Plastic',200),
		('Proyecto Tuberculo',450),
		('Proyecto  Aprobar',100),
		('Proyecto Hombre Y Mujer',900)

insert into asignadoA
	values(1,'55663322'),
		(2,'55668899'),
		(3,'77445588'),
		(5,'11223344'),
		(5,'44332211'),
		(2,'77445588')

select * from cientifico
select * from proyecto 
select * from asignadoA

---->
-- Actividades 
---->

--1
select *
	from cientifico, proyecto, asignadoA
	where dni = cientifico and id = proyecto
	
--2
select id, nombre, COUNT(cientifico)
	from proyecto left join asignadoA
	on proyecto = id
	group by id, nombre

select nomApels, COUNT(proyecto)
	from cientifico left join asignadoA
	on dni = cientifico
	group by nomApels
	
--3

select nomApels, SUM(horas)
	from  cientifico, asignadoA, proyecto
	where dni = cientifico and id = proyecto
	group by nomApels
	
--4

select dni, nomApels, sum(horas) as horas
	from  cientifico, asignadoA, proyecto
	where dni = cientifico and id = proyecto
	group by dni, nomApels


--5

select dni, nomApels
	from  cientifico, asignadoA, proyecto
	where dni = cientifico and id = proyecto
	group by dni, nomApels
	having sum(horas) > 100 
	
	
	
 
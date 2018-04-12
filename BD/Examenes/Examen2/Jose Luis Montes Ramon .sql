
--Actividad 1



--Actividad 2
create database BDA2Donantes
use BDADonantes

create table persona(
	idper int identity(1,1) primary key,
	nombre varchar(40)
)

insert into persona
	values --('David Castro'),
		('Juan Lopez'),
		('Elena Ruiz'),
		('Jesus Sanchez'),
		('Ana Fernandez'),
		('Luis Bueno'),
		('Miguel Cara'),
		('Dolores Dumas')

create table libro(
	nombre varchar(40) primary key,
	donadoPor int references persona
)

insert into libro
	values ('Biblia',1),
		('Corán',2),
		('Buscon',3),
		('Lazarillo',5),
		('Celestina',4),
		('Yerma',6),
		('Crepúsculo',8),
		('Amanece',null)

select * from persona
--2.a , 2.b

--2.c

select idper, nombre,  
	(select COUNT(donadoPor) from libro where externa.idper = donadoPor)
	from persona as externa
	where idper in (select donadoPor from libro)

-- 2.d

select idper, nombre from persona
	where not idper  in (select donadoPor from libro)

-- Actividad 3
create database BDA3Prestamos
use BDA3Prestamos
--3.a 3.b		

--3.c
create table persona(
	idper int identity(1,1) primary key,
	nombre varchar(40)
)

create table libro(
	nombre varchar(40) primary key,
	donadoPor int references persona
)

create table prestamo(
	nombreLibro varchar(40) references libro(nombre),
	prestadoA int references persona(idper),
	fechaPresta date
)
-- 3.d
insert into persona
	values ('Gloria Fuertes'),
	--('David Castro'),
		('Juan Lopez'),
		('Elena Ruiz'),
		('Jesus Sanchez'),
		('Ana Fernandez'),
		('Luis Bueno'),
		('Miguel Cara'),
		('Dolores Dumas')
		
insert into libro
	values ('Biblia',1),
		('Corán',2),
		('Buscon',3),
		('Lazarillo',4),
		('Celestina',4),
		('Yerma',6),
		('Crepúsculo',8),
		('Amanece',null)

insert into prestamo
	values ('Biblia',1,'13-1-2010'),
	('Biblia',1,'13-2-2011'),
	('Biblia',1,'1-5-2011'),
	('Biblia',1,'3-9-2012'),
	('Biblia',1,'22-1-2009'),
	('Biblia',1,'25-1-2009'),
	('Biblia',1,'28-1-2010'),
	('Biblia',1,'1-1-2011')

--3.e


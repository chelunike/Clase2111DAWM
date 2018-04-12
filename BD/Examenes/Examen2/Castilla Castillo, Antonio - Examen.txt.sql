1c
create database BDA1Amigos
use BDA1Amigos

1d
create table amigo(
nombre varchar (30) primary key,
nacimiento date,
altura decimal (6,3)
)

1e
insert into amigo values ('Juan','16/7/1980',1.70)
insert into amigo values ('Ana','31/3/1990',1.65)
insert into amigo values ('Pedro','2/12/1985',1.85)
insert into amigo values ('Elena','29/2/1996',1.60)

1f
select* from amigo
order by nacimiento

1g
select nombre, altura from amigo
order by altura DESC

1h
select MAX(nacimiento) , AVG(altura) from amigo

1i
select altura+3 from amigo where nombre = 'Ana'
select SUM(altura+3) from amigo where nombre = 'Ana'
-------------------------------
2
create database BDA2Donantes
use BDA2Donantes

create table persona(
idper int identity (1,1) primary key,
nombre varchar (30)
)

insert into persona values ('Juan Lopez')
insert into persona values ('Elena Ruiz')
insert into persona values ('Jesus Sanchez')
insert into persona values ('Ana Fernandez')
insert into persona values ('Luis Bueno')
insert into persona values ('Jesus Sanchez')
insert into persona values ('Miguel Cara')
insert into persona values ('Dolores Dumas')

create table libre(
nombre varchar (30) primary key,
donadoPor int references persona
)

insert into libre values ('Quijote',1)
insert into libre values ('Biblia',1)
insert into libre values ('Coran',2)
insert into libre values ('Buscon',3)
insert into libre values ('Lazarillo',4)
insert into libre values ('Celestina',4)
insert into libre values ('Yerma',6)
insert into libre values ('Crepusculo',8)
insert into libre values ('Amanece',null)

2c
select idper,nombre from persona
	where exists
		(select * from libre
			where	persona.idper = libre.donadoPor)
			
2d
select idper,nombre from persona
	where not exists
		(select * from libre
			where	persona.idper = libre.donadoPor)
			
---------------------------
---------------------------
create database BDA3Prestamos
use BDA3Prestamos




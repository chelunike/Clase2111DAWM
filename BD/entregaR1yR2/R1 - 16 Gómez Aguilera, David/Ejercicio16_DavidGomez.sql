create database LaLiga

use LaLiga

create table jugador(
idj varchar(3) primary key,
nombre varchar(20),
fecnac date,
posicion varchar(40)
)

insert into jugador values(000,'Isco','1992-04-21','Mediocentro')
insert into jugador values(001,'Asensio','1996-01-21','Mediocentro')
insert into jugador values(002,'Modric','1985-09-09','Mediocentro')
insert into jugador values(003,'Messi','1987-06-24','Delantero')
insert into jugador values(004,'Griezmann','1991-03-21','Delantero')
insert into jugador values(005,'Diego Costa','1988-10-7','Delantero')
select * from jugador

create table equipo(
ide varchar(3) primary key,
nombre varchar(30),
estadio varchar(40),
aforo int,
ciudad varchar(40),
anio_fundacion date,
idj varchar(3)references jugador(idj)
)
insert into equipo
 values('RM','Real Madrid','Santiago Bernabeu',81044,'Madrid','1947-12-14',000)
insert into equipo
 values('BFC','Barcelona','Camp nou',99354,'Barcelona','1957-09-24',003)
insert into equipo
 values('ATM','Atl�tico de Madrid','Estadio Metropolitano',67829,'Madrid','2017-09-16',004)
select * from equipo

create table partido(
idp varchar(10) primary key,
fecha date,
goles_casa int,
goles_fuera int,
idequipo varchar(3) references equipo(ide)
)
insert into partido
 values('RM-BFC','2018-02-01',3,0,'RM')
insert into partido
 values('ATM-RM','2018-02-05',1,2,'ATM')
insert into partido
 values('BFC-ATM','2018-02-09',1,1,'BFC')
select * from partido

create table gol(
minuto int,
descripcion varchar(50)
)
insert into gol
 values(15,'gol de cabeza')
insert into gol
 values(35,'chilena')
insert into gol
 values(69,'espuela')
select * from gol

create table presidente(
dni varchar (9)primary key,
nombre varchar(20),
apellidos varchar(40),
fecnac date,
equipo varchar(20),
anio_elegido int
)
insert into presidente
 values('11111111f','Tito Floren','P�rez','1947-03-08','Real Madrid',2009)
insert into presidente
 values('22222222w','Josep Maria','Bartomeu','1963-02-06','Barcelona',2015)
insert into presidente
 values('33333333z','Enrique','Cerezo','1948-02-27','Atl�tico de Madrid',2003)
select * from presidente

--1. Consulta que muestre los jugadores con un idj no superior a 3
select * from jugador
	where idj <=3
--2. Consulta que muestre aquellos jugadores cuyo nombre empieze por 'M' 
select * from jugador
	where nombre like 'M%'
--3. Consulta que muestre aquellos jugadores cuya fecha de nacimiento 
--se encuentre entre 1990 y 2000.
select * from jugador
	where fecnac BETWEEN '1990-01-01' and '2000-01-01'
--4. Consulta que muestre el nombre del estadio ordenado por aforo maximo
select estadio from equipo
	order by aforo desc
--5. Consulta que muestre el nombre del presidente del Real Madrid
select nombre from presidente
	where equipo='Real Madrid'
--6. Consulta que devuelva cuantos estadios hay con un aforo superior a 85000 personas
select COUNT(*) from equipo 
	where aforo>=85000
--7. Consulta que devuelva los partidos ordenados por fecha
select * from partido
	order by fecha

--8. Consulta que devuelva a los presidentes ordenados por tiempo ejerciendo
select * from presidente
	order by anio_elegido
--9. Consulta que devuelva el partido en el que juega el Real Madrid en su estadio
select idp from partido
	where idequipo='RM'
	 
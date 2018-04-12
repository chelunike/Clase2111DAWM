create database toritos
use toritos

create table corrida(
	numeroOrden int primary key,
	feria varchar(40) not null,
	año int not null,
	nombrePlaza varchar(40) references plaza
)

create table torero(
	dni char(9) primary key,
	nombre varchar(40),
	apodo varchar(40),
	fechaAlternativa date,
	numeroCorrida int references corrida,
	Dpadrino char(9) references torero,
	Dapoderado char(9) references apoderado
)

create table premio(
	orejas int,
	rabos int,
	puertaGrande char(2) check(puertaGrande in ('si', 'no')),
	Dtorero char(9) references torero,
	primary key (orejas,rabos,puertaGrande)
)

create table apoderado(
	dni char(9) primary key,
	nombre varchar(40),
	direccion varchar(40),
	telefono int
)

create table plaza(
	nombrePlaza varchar(40) primary key,
	localidad varchar(40),
	direccion varchar(40),
	aforo int
)

create table toro(
	numeroOrden int primary key,
	añoNacimiento int,
	nombre varchar(40),
	color varchar(20),
	orden varchar(20),
	codigoGanaderia int references ganaderia,
	numeroCorrida int references corrida
)

create table ganaderia(
	codigo int primary key,
	nombre varchar(40),
	localidad varchar(40),
	antiguedad int
)

insert into apoderado values('11111111A','Pepe','calle Salamanca',958000000),
							('22222222A','Juan','calle Astutias',958000077),
							('33333333A','Antonio','calle Betis',958009999),
insert into apoderado values('44444444A','Carlos','calle dos',958009900)
							
insert into plaza values('plaza 1','Granada','gran via',20500),
						('plaza 2','Cadiz','calle colon',20000),
						('plaza 3','Huelva','calle tres',40000)
						
insert into corrida values(1,'san isidro',2018,'plaza 1'),
						  (2,'grande',2017,'plaza 2'),
						  (3,'san juan',2016,'plaza 3')
						  
insert into torero values('11111111T','David','El manco','02/02/2012',1,'22222222T','11111111A'),
						('22222222T','Josele','El capo','02/06/2010',1,'11111111T','22222222A')
insert into torero values('33333333T','Juan','El feo','03/02/2009',2,'22222222T','11111111A'),
						('44444444T','Josemi','El guapo','02/06/2005',3,'11111111T','33333333A')
						
insert into premio values (2,2,'si','11111111T'),
						  (4,2,'si','22222222T'),
						  (0,0,'no','33333333T'),
						  (0,1,'no','44444444T')
						  
insert into ganaderia values (1,'ganaderia paquita','Granada',1943),
							(2,'ganaderia estilosa','Sevilla',1923),
							(3,'ganaderia supreme','Granada',1956)
							
insert into toro values(1,2000,'negro','negro tizón','primero',1,1),
						(2,2003,'astuto','marrón claro','segundo',2,1),
						(3,2000,'asuston','negro claro','primero',1,2),
						(4,2007,'el bueno','negro tizón','segundo',2,2),
						(5,2000,'pepito','negro','tercero',3,2),
						(6,2000,'torete','marrón y blanco','primero',3,3),
						(7,2003,'bacin','negro oscuro','segundo',1,3)
						
--Toreros cuyo padrino es el torero con dni 11111111T
select * from torero		
	where Dpadrino like '11111111T'
	
--Toreros cuyo padrino es el torero con dni 22222222T y van a la corrida 2
select * from torero		
	where Dpadrino like '22222222T' and numeroCorrida=2
	
--Toros de algun color negro y de la ganaderia 1
select * from toro
	where color like 'negro%' and codigoGanaderia=1
	
-- Numero de toros que hay en cada ganaderia, junto con el nombre de la ganaderia
select ganaderia.nombre,COUNT(*) numeroToros from toro, ganaderia
	where codigoGanaderia=codigo
	group by codigoGanaderia, ganaderia.nombre
	
--Premios obtenidos en la corrida 1 junto con dni del torero y nombre
select orejas,rabos,puertaGrande,premio.Dtorero,nombre from premio, torero
	where premio.Dtorero=torero.dni and numeroCorrida=1

--Apoderados sin toreros
select distinct apoderado.nombre,apoderado.dni from apoderado,torero
	where apoderado.dni not in (select Dapoderado from torero)
	
--Los toros toreados en primer lugar en las corridas 1 y 2 junto con el nombre de la plaza
select toro.nombre, nombrePlaza from toro, corrida
	where numeroCorrida=corrida.numeroOrden and (numeroCorrida=1 or numeroCorrida=2) and orden like 'Primero'

--Funcion que devuelve los toros que participaron en una corrida 
--(se pasa como parametro el nombre de la feria)

alter function func (@feria varchar(40))
	returns table as return
	select toro.nombre,toro.orden from toro, corrida
		where numeroCorrida=corrida.numeroOrden and feria=@feria
		
select * from func('san isidro')
select * from func('grande')
select * from func('san juan')

select * from corrida
select * from toro
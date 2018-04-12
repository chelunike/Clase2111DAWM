create database ejercicioA3
use ejercicioA3

create table Pinoteca(
	Nombre varchar(30) primary key,
	Ciudad varchar(30) not null,
	Direccion varchar(200) not null,
	MetrosC int not null	
)
create table Escuela(
	Nombre varchar(30) primary key,
	Pais varchar(30) not null,
	Fecha date not null
)
create table Pintor(
	Nombre varchar(30) primary key,
	Pais varchar(30) not null,
	Ciudad varchar(30) not null,
	FechaN date not null,
	FechaD date,
	NEscuela varchar(30) references Escuela
)
create table Cuadro(
	Cod int identity(1,1) primary key,
	Nombre varchar(30) not null,
	Dimensiones varchar(7) check (Dimensiones in('Enano','Pequeño','Mediano','Grande','Enorme','Mural')),
	Fecha date not null,
	Tecnica varchar(17) check (Tecnica in('Acuarela','Aguada','Aerografía','Pintura al pastel','Temple al huevo','Fresco','Tinta','Mixto')),
	NPino varchar(30) references Pinoteca not null,
	NAutor varchar(30) references Pintor
)
create table Enseña(
	Maestro varchar(30) references Pintor,
	Aprendiz varchar(30) references Pintor,
	primary key (Maestro, Aprendiz)
)
create table Mecenas(
	Nombre varchar(30) primary key,
	Fecha date not null,
	Pais varchar(30) not null,
	CiudadN varchar(30) not null,
	FechaM date
)
create table Mecenas_Pintor(
	NMecenas varchar(30) references Mecenas,
	NPintor varchar(30) references Pintor,
	primary key (NMecenas,NPintor)
)
insert into Pinoteca values 
('Los colorines','Granada','Calle palacion Nº4', 200),
('La casa de mike','Madrid','Calle rey Nº3', 200),
('Marron puro','Motril','Avenida pastor Nº3', 100),
('Arcoiris 99','Nerja','Calle Jarama Nº2', 100),
('Arte dislike','Marvella','Calle Dilar Nº5', 150)

insert into Escuela values
('La virgen del arte','España','20-10-1974'),
('San francisco','Francia','30-06-1976'),
('Toquero tun','Francia','11-02-1988'),
('Difratada','Rusia','15-09-1922'),
('Misatamari','España','04-11-1935')

insert into Pintor values
('Darius','España','Granada','24-09-1980',null,'San francisco'),
('Vayne','Francia','Paris','22-07-1985',null,null),
('Teemo','España','Granada','01-02-1990',null,'Toquero tun'),
('Gragas','Francia','Paris','15-10-1975',null,'Misatamari'),
('Volibear','Francia','Paris','25-12-1960','01-11-2005','Difratada'),
('Rumble','España','Granada','10-01-1969',null,'La virgen del arte')

insert into Mecenas values
('Julio','01-11-1980','Francia','Paris',null),
('Jaime','07-05-1960','España','Madrid','23-02-2015'),
('Jose Luis','08-09-1970','Rusia','San Petersburgo','25-12-2017'),
('Josemi','22-10-1990','España','Granada',null)

insert into cuadro values
('Torre del alfil','Mediano','10-11-2012','Pintura al pastel','Los colorines','Darius'),
('La gran gargola','Grande','12-09-2011','Aguada','La casa de mike','Vayne'),
('La mente','Pequeño','14-08-2015','Aerografía','Marron puro','Teemo'),
('El pais de nunca','Enorme','16-07-2010','Temple al huevo','Arcoiris 99','Gragas'),
('La diosa de la luz','Enano','18-06-2007','Tinta','Arte dislike','Volibear'),
('El fuego del cañon','Enorme','20-05-2010','Acuarela','Arte dislike','Rumble'),
('Lanza electrica','Pequeño','20-05-2016','Tinta','La casa de mike','Rumble'),
('El avismo','Grande','28-01-1990','Temple al huevo','Marron puro',null)

insert into Enseña values
('Volibear','Vayne'),
('Volibear','Darius'),
('Rumble','Teemo')

insert into Mecenas_Pintor values
('Julio','Vayne'),
('Josemi','Darius'),
('Jose Luis','Teemo')


--Muestra todos los cuadros de todas las pinotecas
select * from Cuadro

--Muestra los cuadros Enormes
select * from Cuadro where Dimensiones = 'Enorme'

--Muestra los cuadros que su dimension empieze por E
select * from Cuadro where Dimensiones like 'E%'

--Muestra los cuadros del pintor Gragas
select * from Cuadro where NAutor = 'Gragas'

--Muestra el titulo de los cuadros anteriores al año 2015
select Nombre from Cuadro where Fecha < '2015-01-01'

--Muestra los cuadros que la tecnica de pintado empieze por A
select * from Cuadro where Tecnica like 'A%'

--Obten el numero de cuadros de cada autor y el nombre del autor
select NAutor, COUNT(NAutor) as 'Cuadros pintados' from Cuadro group by NAutor

--Obten los cuadros de los que se desconozca el pintor
select * from Cuadro where NAutor is null

--Obten los pintores que aprendieron de Volibear
select * from Pintor where Nombre in (select Aprendiz from Enseña where Maestro = 'Volibear')

--Obten los pintores que estan muertos
select * from Pintor where FechaD is not null

--Obten el numero de cuadros que hay en cada pinoteca y el nombre de la misma
select NPino, COUNT(NPino) from Cuadro group by NPino

--Obten las pinotecas con mayor cantidad de metros cuadrados
select * from Pinoteca where MetrosC = (select MAX(MetrosC) from Pinoteca)

--Obten las escuelas que no son ni de españa ni francia
select * from Escuela where not Pais = 'España' and not Pais = 'Francia'

--Obten el nombre y la ciudad de nacimiento de cada mecenas
select Nombre, CiudadN from Mecenas


drop database ejercicioA3
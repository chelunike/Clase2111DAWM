create database EjercicioRelacion14
use EjercicioRelacion14
create table Autor(
CodigoA int identity (1,1) primary key,
NombreA varchar(30)
)
create table Libro(
CodigoL int identity (100, 1) primary key,
Titulo varchar(40) not null,
ISBN char(13) not null,
Editorial varchar(20),
Pagina int
)
create table Ejemplar(
CodigoE varchar(8) primary key,
Localización varchar(20),
CodigoL int references Libro
)
create table Usuario(
CodigoU int identity (10000, 1) primary key,
NombreU varchar(30),
Telefono varchar(9),
Direccion varchar(70)
)
create table Escribe(
CodigoA int references Autor,
CodigoL int references Libro,
)
create table Saca(
CodigoU int references Usuario primary key,
CodigoE varchar (8) references Ejemplar,
FechaDevolucion date,
FechaPrestamo date,
)
insert into Autor values
('Antonio Garcia Lorca'),
('Miguel de Unamuno'),
('Rafael Alberti'),
('Kentaro Miura')
insert into Libro values
('Romancero gitano', '1234567890123', 'S.M.', 170),
('Poeta en Nueva York', '9854632580258', 'Anaya', 115),
('Berserk', '1843254874120', 'Doritos', 60),
('Niebla', '2358468753215', 'Planeta', 105),
('Love Live', '4568215698725', 'Doritos', 400)
insert into Ejemplar values
('12345678','Estantería 1' , 100),
('21584687','Estantería 3' , 100),
('12584653','Estantería 2' , 101),
('89564752','Estantería 1' , 102),
('52145879','Estantería 3' , 103),
('26588475','Estantería 3' , 103),
('15855678','Estantería 1' , 103),
('45887421','Estantería 2' , 104)
insert into Usuario values
('Alberto Privado', '622145263', 'C/ Génova Nº6 4ºD'),
('Mario Pérez', '156489258', 'C/Camino de Ronda 27'),
('Pepe Botella', '484923187', 'C/Luz Casanova Nº3'),
('Max Payne', '458213685', 'C/Arcoiris Nº27'),
('María López', '475213685', 'C/Genil Nº2'),
('Carmen Cano', '214526302', 'C/Recogidas Nº7')
insert into Escribe values
(1, 100),
(1, 101),
(4, 102),
(2, 103),
(4, 104)
insert into Saca values
(10000, '12584653', '29/12/2017', '01/02/2018'),
(10002, '52145879', '28/01/2018', '30/01/2018'),
(10005, '52145879', '29/01/2018', '04/02/2018')
-- Libros cuya editorial sea 'Doritos' y el número de páginas sea mayor a la media
Select CodigoL, Titulo, Pagina
from Libro
where Editorial = 'Doritos'
and Pagina > (select AVG(Pagina) from Libro)
-- Numero de ejemplares de cada libro
Select L.CodigoL, Pagina, COUNT(*)[Número de Ejemplares]
from libro L, Ejemplar E
where L.CodigoL = E.CodigoL
group by L.CodigoL, Pagina
-- Funcion que devuelve el código de ejemplar del libro
create function Nombres (@titulo varchar(30))
returns table
as return select codigoE
from ejemplar E inner join libro L
on E.codigoL = L.codigoL
where titulo = @titulo
select * from Nombres('Berserk')
-- Libro cuya longitud de título es más larga
select * from libro
where len(titulo) =
(select max(len(titulo)) from libro)
-- Número de dias que ha durado el préstamo
select *, DATEDIFF(DD, FechaDevolucion, FechaPrestamo) [Dias de préstamo]
from Saca S inner join Usuario U
on S.CodigoU = U.CodigoU
-- Numero de libros que ha escrito cada autor
select E.codigoA, count(* ) NumLibros from Escribe E, Autor A
where E.codigoA= A.codigoA
group by E.codigoA
-- Ejemplar que más veces se ha prestado
select top 1 with ties
CodigoE, COUNT(*) as [¿Cuantas veces?]
from Saca
group by CodigoE
order by [¿Cuantas veces?] desc
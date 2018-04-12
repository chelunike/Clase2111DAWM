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
Localizaci�n varchar(20),
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
('12345678','Estanter�a 1' , 100),
('21584687','Estanter�a 3' , 100),
('12584653','Estanter�a 2' , 101),
('89564752','Estanter�a 1' , 102),
('52145879','Estanter�a 3' , 103),
('26588475','Estanter�a 3' , 103),
('15855678','Estanter�a 1' , 103),
('45887421','Estanter�a 2' , 104)
insert into Usuario values
('Alberto Privado', '622145263', 'C/ G�nova N�6 4�D'),
('Mario P�rez', '156489258', 'C/Camino de Ronda 27'),
('Pepe Botella', '484923187', 'C/Luz Casanova N�3'),
('Max Payne', '458213685', 'C/Arcoiris N�27'),
('Mar�a L�pez', '475213685', 'C/Genil N�2'),
('Carmen Cano', '214526302', 'C/Recogidas N�7')
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
-- Libros cuya editorial sea 'Doritos' y el n�mero de p�ginas sea mayor a la media
Select CodigoL, Titulo, Pagina
from Libro
where Editorial = 'Doritos'
and Pagina > (select AVG(Pagina) from Libro)
-- Numero de ejemplares de cada libro
Select L.CodigoL, Pagina, COUNT(*)[N�mero de Ejemplares]
from libro L, Ejemplar E
where L.CodigoL = E.CodigoL
group by L.CodigoL, Pagina
-- Funcion que devuelve el c�digo de ejemplar del libro
create function Nombres (@titulo varchar(30))
returns table
as return select codigoE
from ejemplar E inner join libro L
on E.codigoL = L.codigoL
where titulo = @titulo
select * from Nombres('Berserk')
-- Libro cuya longitud de t�tulo es m�s larga
select * from libro
where len(titulo) =
(select max(len(titulo)) from libro)
-- N�mero de dias que ha durado el pr�stamo
select *, DATEDIFF(DD, FechaDevolucion, FechaPrestamo) [Dias de pr�stamo]
from Saca S inner join Usuario U
on S.CodigoU = U.CodigoU
-- Numero de libros que ha escrito cada autor
select E.codigoA, count(* ) NumLibros from Escribe E, Autor A
where E.codigoA= A.codigoA
group by E.codigoA
-- Ejemplar que m�s veces se ha prestado
select top 1 with ties
CodigoE, COUNT(*) as [�Cuantas veces?]
from Saca
group by CodigoE
order by [�Cuantas veces?] desc
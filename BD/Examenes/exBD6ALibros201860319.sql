/* Nombre _________________________________________________
ExABD6 - 2018/03/19

create database BDInstituto
use BDInstituto
create table instituto (
   codIns varchar(5) primary key,
   nomIns varchar(30) not null
)
insert into instituto values ('I1', 'IES Cruz de Mayo'),
('I2', 'IES Soto del Real'),('I3', 'IES Niño de la Bola')
create table aula (
   codIns varchar(5) references instituto,
   codAul int,
   capacidad int,
   primary key (codIns, codAul)
)
insert into aula values ('I1',1,35),('I1',2,30),('I1',3,25), 
('I1',4,32), ('I2',1,34), ('I3',1,30), ('I3',2,30)
create table alumno (
   codAlu varchar(20) primary key,
   nomAlu varchar(30) not null,
   codIns varchar(5) references instituto
)
insert into alumno values ('A01', 'Luis Bueno', 'I1'),
('A02', 'Ana Altea', 'I1'),('A03', 'Fran Llano', 'I1'),
('A04', 'Juan Ramos', 'I2'),('A05', 'Elena Ruiz', 'I2'),
('A06', 'Jesus Lopez', 'I3'),('A07', 'Jose Leon', 'I3')
create table alumInformatica (
   codAlu varchar(20) primary key references alumno,
   conOrdenador bit
)
insert into alumInformatica values ('A03', 1),
('A04', 0), ('A05', 0), ('A06', 0)
create table alumBilingue (
   codAlu varchar(20) primary key references alumno,
   idioma char(3) 
)
insert into alumBilingue values ('A01', 'FRA'),
('A04', 'ING'), ('A05', 'ING'), ('A07', 'ALE')
create table libro (
   codLib varchar(20) primary key,
   nomLib varchar(30) not null,
   codIns varchar(5) references instituto
)
insert into libro values ('L01', 'Biblia en verso', 'I1'),
('L02', 'Soneto en prosa', 'I1'),('L03', 'La luz', 'I1'),
('L04', 'Don Quijote', 'I2'),('L05', 'Galatea', 'I2'),
('L06', 'Romeo y Julieta', 'I2'),('L07', 'Otelo', 'I2'),
('L08', 'Informatismo', 'I3'),('L09', 'Teatro ordenado', 'I3')
create table prestamo (
   codAlu varchar(20) references alumno,
   codLib varchar(20) references libro,
   fecIni date not null,
   fecFin date not null
)
insert into prestamo values ('A01', 'L01', '1-2-2017', '3-2-2017'),
('A01', 'L02', '1-3-2017', '3-3-2017'),
('A01', 'L03', '1-2-2017', '3-2-2017'),
('A02', 'L02', '1-4-2017', '3-4-2017'),
('A02', 'L05', '1-2-2017', '3-2-2017'),
('A03', 'L02', '1-5-2017', '3-5-2017'),
('A03', 'L07', '1-2-2017', '3-2-2017'),
('A05', 'L06', '1-2-2017', '3-2-2017'),
('A06', 'L07', '5-2-2017', '15-2-2017'),
('A07', 'L09', '1-2-2017', '3-2-2017'),
('A07', 'L07', '20-2-2017', '23-2-2017')
 
A1(0.2).- Diagrama relacional.

A2(0.6).- Diagrama E/R.

A3(0.2).- Número de aulas de cada instituto.

A4(0.2).- Instituto(s) com más capacidad (entendido como 
la suma de las capacidades de sus alulas).

A5(0.2).- Código y nombre de los alumnos que no están
ni en informática ni en bilingue.

A6(0.4).- Lista de los alumnos en la que aparezca su nombre 
y el nombre del instituto ordenado por nombre de instituto 
(ascendente) y nombre del alumno (descendente).

A7(0.4).- Nombre de los alumnos a los que se les ha hecho 
más de un prestamo.

A8(0.4).- Obtener un listado completo de préstamos 
que incluya: 
- nombre del alumno y nombre del instituto al que pertenece
- nombre del libro y nombre del instituto al que pertenece
- fecha en que se prestó.

A9(0.4).- Nombre de los libros que han sido prestados a 
alumnos que no son del instituto al que pertenece el libro.

A10(0.4).- Nombre de los institutos en los que hay libros que 
no se les ha prestado a nadie.

A11(0.4).- Nombre de los alumnos a los que no se les ha hecho 
ningún préstamo.

A12(0.4).- Escribe una funcion de nombre fTablaLectores que al 
pasarle como parámetro el nombre de un libro, devuelva una tabla 
con los nombres de los alumnos a los que se les ha prestado ese 
libro.

A13(0.4).- Escribe una función de nombre mediaPrestamoDiasLibro 
que al ejecutarla (mandándole como parámetro el código de un 
libro) devuelve en un float el número medio de días que ha estado
prestado ese libro.

A14(0.4).- Crea una tabla de nombre librosBajos duplicando toda 
la información (usando SELECT e INTO) contenida en la tabla 
'libro', de aquellos libros cuyo nombre empieza por una letra 
inferior a la 'L'. A continuación, pon todas las letras de los 
nombres de los libros de la nueva tabla en mayúsculas.

A15(0.4).- Escribe un disparador que impida que se modifiquen,
mediante update, los datos de la tabla creada en A14.

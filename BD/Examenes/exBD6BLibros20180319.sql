/* Nombre _________________________________________________
ExBBD6 - 2018/03/19

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

B1(0.2).- Diagrama relacional.

B2(0.6).- Diagrama E/R.

B3(0.2).- Capacidad de alumnos de cada instituto (entendido 
como la suma de las capacidades de sus aulas).

B4(0.2).- Aula(s) com más capacidad y a qué instituto(s) 
pertenece(n).

B5(0.2).- Código y nombre de los alumnos que estan en 
informática y bilingue a la vez.
   
B6(0.4).- Obtener un listado completo de préstamos que incluya: 
- nombre del libro y nombre del instituto al que pertenece
- nombre del alumno y nombre del instituto al que pertenece
- fecha en que se devolvió.

B7(0.4).- Nombre de los alumnos a los que se les ha prestado 
libros que no son de su instituto.

B8(0.4).- Lista de los libros en la que aparezca su nombre y el 
nombre del instituto al que pertenece ordenada por nombre del 
instituto (descendente) y nombre del libro (ascendente).

B9(0.4).- Nombre de los libros que se han prestado más de 
dos veces.

B10(0.4).- Nombre de los libros que no han sido prestados.

B11(0.4).- Nombre de los institutos en los que hay alumnos 
que no se les ha prestado ningún libro.

B12(0.4).- Escribe una funcion de nombre fTablaLibros que al 
pasarle como parámetro el nombre de un alumno devuelva una tabla 
con los nombres de los libros que se les ha prestado a ese alumno.

B13(0.4).- Escribe una función de nombre mediaPrestamoDiasAlumno 
que al ejecutarla (mandándole como parámetro el código de un 
alumno) devuelve en un decimal(8,2) el número medio de días de 
los prestamos de ese alumno.

B14(0.4).- Crea una tabla de nombre alumnosAltos duplicando toda 
la información (usando SELECT e INTO) contenida en la tabla 'alumno' 
de aquellos alumnos cuyo nombre empieza por una letra superior a 
la 'F'. A continuación pon todas las letras de los nombres de los 
alumnos de la tabla creada en minúsculas.

B15(0.4).- Escribe un disparador que impida que se borren, mediante 
delete, los datos de la tabla que acabamos de crear en B14.

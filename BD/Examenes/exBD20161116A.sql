/* MODELO A  MODELO A  MODELO A  MODELO A  MODELO A  MODELO A  MODELO A 
 
NOTA IMPORTANTE: las consultas tienen que funcionar de forma correcta 
con los datos de ejemplo o con otros distintos

1(4 puntos).- Queremos guardar los siguientes datos de mis amigos 
(identificados por el nombre). 
		--------------------
Nombre	Nacimiento  Altura
Juan	16/6/1980	1.70
Ana		31/3/1990	1.65
Pedro	2/12/1985	1.85
Elena	29/2/1996	1.60
		--------------------
1a(0.3).- Haz el diagrama E/R.

1b(0.2).- Haz el paso a tabla.

Escribe las ordenes SQL para:

1c(0.2).- crear una base de datos de nombre BDA1Amigos y dejarla 
como BD activa.

1d(0.8).- crear la(s) tabla(s) necesaria(s) para almacenar dichos datos 
con los tipos y restricciones que consideres apropiadas.

1e(0.8).- introducir los datos en la(s) tabla(s).

1f(0.4).- mostrar los datos ordenados por la fecha de nacimiento.

1g(0.4).- mostrar sólo los nombres y sus alturas ordenados por altura 
de mayor a menor.

1h(0.4).- mostrar la fecha de nacimiento más reciente y la altura media.

1i(0.3).- subir 3 centímetros la altura de Ana.

1j(0.2).- eliminar la tupla de Pedro.

2(3 puntos).- Crea una base de datos de nombre BDA2Donantes para guardar 
datos de libros y de personas que los han donado y/o los usan, déjala 
como activa y ejecuta las ordenes SQL que siguen.
		------------------------------------------
create table persona(
   idper int identity(1,1) primary key,
   nombre varchar(40)
)
insert into persona values('Juan López')
insert into persona values('Elena Ruiz')
insert into persona values('Jesús Sánchez')
insert into persona values('Ana Fernández')
insert into persona values('Luis Bueno')
insert into persona values('Jesús Sánchez')
insert into persona values('Miguel Cara')
insert into persona values('Dolores Dumas')
create table libro(
   nombre varchar(30) primary key,
   donadoPor int references persona
)
insert into libro values ('Quijote', 1)
insert into libro values ('Biblia', 1)
insert into libro values ('Corán', 2)
insert into libro values ('Buscón', 3)
insert into libro values ('Lazarillo', 4)
insert into libro values ('Celestina', 4)
insert into libro values ('Yerma', 6)
insert into libro values ('Crepúsculo', 8)
insert into libro values ('Amanece', null)
		---------------------------------------
2a(0.6).- Haz el diagrama E/R.

2b(0.4).- Haz el paso a tabla.

Escribe las ordenes SQL para:

2c(1).- mostrar una lista de las personas que han donado algún libro.
En ella ha de aparecer el codigo de la persona (idper), su nombre y
cuántos libros ha donado.

2d(1).- mostrar el código y el nombre de las personas que no han donado 
ningún libro.

3(3puntos).-  Crea una base de datos de nombre BDA3Prestamos con los 
datos del ejercicio anterior. Queremos que nos permita guardar la 
información que sigue sobre préstamos de libros (por supuesto 
relacionada con los datos anteriores).
		-----------------------------------
insert into prestamo values ('Quijote', 1, '13/1/2010')
insert into prestamo values ('Quijote', 1, '13/2/2011')
insert into prestamo values ('Yerma', 1, '1/5/2011')
insert into prestamo values ('Yerma', 1, '3/9/2012')
insert into prestamo values ('Lazarillo', 2, '22/1/2009')
insert into prestamo values ('Yerma', 2, '25/1/2009')
insert into prestamo values ('Biblia', 2, '28/1/2010')
insert into prestamo values ('Corán', 3, '1/1/2011')
insert into prestamo values ('Biblia', 3, '15/1/2011')
insert into prestamo values ('Amanece', 3, '18/1/2011')
insert into prestamo values ('Yerma', 5, '20/12/2012')
		------------------------------------
3a(0.6).- Haz el diagrama E/R.

3b(0.4).- Haz el paso a tabla.

Escribe las ordenes SQL para:

3c(0.6).- crear la(s) tabla(s) necesaria(s) para almacenar dicha 
información con los tipos y restricciones que consideres apropiadas.

3d(0.4).- introducir la información en la(s) tabla(s).

3e(1).- mostrar el código y el nombre de la(s) persona(s) con más 
libros distintos leidos.

*/

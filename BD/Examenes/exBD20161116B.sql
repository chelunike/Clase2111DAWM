/* MODELO B  MODELO B  MODELO B  MODELO B  MODELO B  MODELO B  MODELO B 
 
NOTA IMPORTANTE: las consultas tienen que funcionar de forma correcta 
con los datos de ejemplo o con otros distintos

1(4 puntos).- Queremos guardar los siguientes datos de mis libros
(identificados por el t�tulo). 
		-----------------
T�tulo	Precio	Publicaci�n
Quijote	3.70	16/6/1980
Biblia	2.65	31/3/1990	
Cor�n	2.85	2/12/1985	
Busc�n	1.60	29/2/1996
		-----------------	
1a(0.3).- Haz el diagrama E/R.

1b(0.2).- Haz el paso a tabla.

Escribe las ordenes SQL para:

1c(0.2).- crear una base de datos de nombre BDB1Libros y d�jala 
como BD activa.

1d(0.8).- crear la(s) tabla(s) necesaria(s) para almacenar dichos 
datos con los tipos y restricciones que consideres apropiadas.

1e(0.8).- introducir los datos en la(s) tabla(s).

1f(0.4).- mostrar los datos ordenados por la fecha de 
publicaci�n descendente.

1g(0.4).- mostrar s�lo los t�tulos y sus precios ordenados por precio.

1h(0.4).- mostrar la fecha de publicaci�n m�s antigua y el precio medio.

1i(0.3).- subir 5 c�nt�mos el precio de Quijote.

1j(0.2).- eliminar la tupla de Busc�n.

2(3 puntos).- Crea una base de datos de nombre BDB2Censo para guardar 
datos de ciudades y de personas que est�n censadas en ellas y/o 
tienen propiedades en ellas, d�jala como activa y ejecuta las ordenes 
SQL que siguen.
		----------------------------------------------
create table ciudad(
   codigo char(2) primary key,
   nombre varchar(40)
)
create table persona(
   idper int identity(1,1) primary key,
   nombre varchar(40),
   censadoEn char(2) references ciudad
)
insert into ciudad values('GR','Granada')
insert into ciudad values('CI','Ciudad Real')
insert into ciudad values('MA','Madrid')
insert into ciudad values('GN','Granada')
insert into ciudad values('MG','M�laga')
insert into ciudad values('CR','Ciudad Rodrigo')
insert into persona values('Juan L�pez', 'GR')
insert into persona values('Elena Ruiz', 'GN')
insert into persona values('Jes�s S�nchez', 'CI')
insert into persona values('Ana Fern�ndez', 'CI')
insert into persona values('Luis Bueno', 'MA')
insert into persona values('Jos� Cuevas', 'MA')
insert into persona values('Miguel Cara', 'CR')
insert into persona values('Dolores Dumas', null)
		-------------------------------------------
2a(0.6).- Haz el diagrama E/R.

2b(0.4).- Haz el paso a tabla.

Escribe las ordenes SQL para:

2c(1).- mostrar una lista de las ciudades que tienen alguna persona 
censada. Debe aparecer el c�digo y el nombre de la ciudad y cu�ntas 
personas est�n censadas en esa ciudad.

2d(1).- mostrar el c�digo y el nombre de las ciudades que no tienen 
ninguna persona censada.

3(3 puntos).- Crea una base de datos de nombre BDB3Propiedades con 
los datos del ejercicio anterior. Queremos que nos permita guardar 
la informaci�n que sigue sobre propiedades: ciudad, propietario y 
referencia de la propiedad (por supuesto relacionada con los datos 
que ya tenemos).
		-------------------------------------
insert into propiedad values ('MA', 1, 1300)
insert into propiedad values ('MA', 1, 1301)
insert into propiedad values ('MA', 1, 1308)
insert into propiedad values ('MG', 1, 2300)
insert into propiedad values ('MG', 1, 2303)
insert into propiedad values ('MG', 2, 2303)
insert into propiedad values ('MG', 2, 2304)
insert into propiedad values ('GR', 3, 3309)
insert into propiedad values ('GN', 4, 4300)
		-------------------------------------
3a(0.6).- Haz el diagrama E/R.

3b(0.4).- Haz el paso a tabla.

Escribe las ordenes SQL para:

3c(0.6).- crear la(s) tabla(s) necesaria(s) para almacenar dicha 
informaci�n con los tipos y restricciones que consideres apropiadas.

3d(0.4).- introducir la informaci�n en la(s) tabla(s).

3e(1).- mostrar el c�digo y el nombre de la(s) ciudad(s) con m�s 
propiedades (�OJO una propiedad puede ser de m�s de una persona!).

*/

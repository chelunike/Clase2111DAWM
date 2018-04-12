MODELO B   MODELO B   MODELO B   MODELO B   MODELO B
(Preguntas 1 y 2: 1 punto cada una. Preguntas 3 a 9: 0.5 puntos cada una.

Queremos crear una BD con los datos de un conjunto de libros de los que 
se han hecho de cada uno distintas ediciones.
De cada libro interesa guardar tres letras que lo identifican (una clave), 
su titulo, su fecha de publicación, su peso, su número de páginas y si 
está premiado. Datos para hacer pruebas:

insert into libro values ('LVJ', 'La oveja', '29/2/1940', 75, 164, 'true') 
insert into libro values ('LRJ', 'La oreja', '26/1/1970', 95, 165, 'true') 
insert into libro values ('GRL', 'Garulo',   '3/5/1971', 108, 160, 'true') 
insert into libro values ('LGL', 'Leguleyo', '4/7/1992',  78, 172, 'false') 
insert into libro values ('LGE', 'Ligero',   '26/1/1990', 65, 170, 'true') 
insert into libro values ('RHJ', 'Rehijo',   '23/2/1980', 88, 190, 'false') 
insert into libro values ('RLJ', 'Reloj',    '2/1/2015',  38,  70, 'false') 
insert into libro values ('RBB', 'Rebaba',   '3/12/2010', 67, 120, 'false') 

Cada edición la vamos a identificar con la clave del libro y su número 
de edición y además guardaremos el nombre de la persona que ha hecho 
la edición. Datos para hacer pruebas:

insert into edicion values ('LVJ', 1, 'Luis Vilchez') 
insert into edicion values ('LVJ', 2, 'Leo Valdés') 
insert into edicion values ('LVJ', 3, 'Luis Valdés') 
insert into edicion values ('LVJ', 4, 'Leo Vilchez') 
insert into edicion values ('LVJ', 5, 'Largo Vuelo') 
insert into edicion values ('LRJ', 1, 'Lola Ruiz') 
insert into edicion values ('LRJ', 2, 'Laura Rios') 
insert into edicion values ('GRL', 1, 'Gastón Rios') 
insert into edicion values ('GRL', 2, 'Grimaldi Román') 
insert into edicion values ('LGL', 1, 'Lola Grandes') 
insert into edicion values ('LGE', 1, 'Lorena Gutierrez') 
insert into edicion values ('RHJ', 1, 'Ramón Hernán') 
insert into edicion values ('RLJ', 1, 'Rosa Lima') 
insert into edicion values ('RLJ', 2, 'Risto Loma') 
insert into edicion values ('RLJ', 3, 'Rastro Lana') 
insert into edicion values ('RBB', 1, 'Ricardo Bueno') 

También queremos guardar los datos sobre una encuesta que se le ha 
pasado a los responsables de las editoriales de los libros en la que 
ponían la afinidad que consideran que tiene su libro con otros libros y 
la calificaban con un valor de 1 a 5. Datos para hacer pruebas:

'GRL': 'LGL' 5, 'LVJ' 2, 'RLJ' 3
'LGE': 'RBB' 4
'LRJ': 'RHJ' 1, 'LVJ' 4
'LVJ': 'GRL' 4, 'LRJ' 1, 'RLJ' 2
'RLJ': 'GRL' 1

insert into afin values ('GRL', 'LGL', 5)
insert into afin values ('GRL', 'LVJ', 2)
insert into afin values ('GRL', 'RLJ', 3)
insert into afin values ('LGE', 'RBB', 4)
insert into afin values ('LRJ', 'RHJ', 1)
insert into afin values ('LRJ', 'LVJ', 2)
insert into afin values ('LVJ', 'GRL', 4)
insert into afin values ('LVJ', 'LRJ', 1)
insert into afin values ('LVJ', 'RLJ', 2)
insert into afin values ('RLJ', 'GRL', 1)

1.- Dibuja el diagrama E/R, y el diagrama relacional (paso a tabla) de 
nuestra base de datos.

2.- Completa su modelo físico (crea la(s) tabla(s) necesaria(s) e inserta 
los datos)

Haz una consulta que muestre...:

3.- ... el(los) libro(s) con el titulo con menos longitud.

4.- ... sólo la clave, titulo y número de páginas de los libros premiados 
cuya número de páginas supera el número medio de páginas
de todos los libros.

5.- ... sólo la clave, páginas y número de ediciones de cada libro

6.- ... sólo la clave y titulo de los libros que han dicho
que tienen libros afines y el peso medio de los afines de cada uno.

7.- Función que le pasamos la clave de un libro y nos 
devuelve el número de libros que han dicho que es su afin.

8.- Función que le pasamos dos claves de libros y 
devuelve los días que separan a sus fechas de publicación.

9.- Función que le pasamos el titulo de un libro y nos 
devuelve los nombres de las personas que han hecho sus 
ediciones (puede haber titulos repetidos).

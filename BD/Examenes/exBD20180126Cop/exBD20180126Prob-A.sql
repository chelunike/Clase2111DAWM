MODELO A   MODELO A   MODELO A   MODELO A   MODELO A
(Preguntas 1 y 2: 1 punto cada una. Preguntas 3 a 9: 0.5 puntos cada una.

Queremos crear una BD con los datos de un grupo de delincuentes que 
posee cada uno distintas personalidades con su correspondiente dni 
(que no se repite ninguno).
De cada delincuente interesa guardar tres letras que lo identifican, 
su alias, su fecha de nacimiento, su peso, su altura y si está fichado. 
Datos para hacer pruebas:

insert into delincuente values ('LVJ', 'La oveja', '29/2/1940', 75, 164, 'true') 
insert into delincuente values ('LRJ', 'La oreja', '26/1/1970', 95, 165, 'true') 
insert into delincuente values ('GRL', 'Garulo',   '3/5/1971', 108, 160, 'true') 
insert into delincuente values ('LGL', 'Leguleyo', '4/7/1992',  78, 172, 'false') 
insert into delincuente values ('LGE', 'Ligero',   '26/1/1990', 65, 170, 'true') 
insert into delincuente values ('RHJ', 'Rehijo',   '23/2/1980', 88, 190, 'false') 
insert into delincuente values ('RLJ', 'Reloj',    '2/1/2015',  38,  70, 'false') 
insert into delincuente values ('RBB', 'Rebaba',   '3/12/2010', 67, 120, 'false') 

Cada personalidad la vamos a identificar con su número de dni y además 
guardaremos el nombre falso y las tres letras con las que tenemos 
identificado al delincuente. Datos para hacer pruebas:

insert into personalidad values (11111111, 'Luis Vilchez', 'LVJ') 
insert into personalidad values (21111111, 'Leo Valdés', 'LVJ') 
insert into personalidad values (31111111, 'Luis Valdés', 'LVJ') 
insert into personalidad values (41111111, 'Leo Vilchez', 'LVJ') 
insert into personalidad values (51111111, 'Largo Vuelo', 'LVJ') 
insert into personalidad values (12111111, 'Lola Ruiz', 'LRJ') 
insert into personalidad values (13111111, 'Laura Rios', 'LRJ') 
insert into personalidad values (11211111, 'Gastón Rios',  'GRL') 
insert into personalidad values (11311111, 'Grimaldi Román',  'GRL') 
insert into personalidad values (11121111, 'Lola Grandes', 'LGL') 
insert into personalidad values (11112111, 'Lorena Gutierrez', 'LGE') 
insert into personalidad values (11111211, 'Ramón Hernán', 'RHJ') 
insert into personalidad values (11111121, 'Rosa Lima', 'RLJ') 
insert into personalidad values (11111131, 'Risto Loma', 'RLJ') 
insert into personalidad values (11111141, 'Rastro Lana', 'RLJ') 
insert into personalidad values (11111112, 'Ricardo Bueno', 'RBB') 

También queremos guardar los datos sobre una encuesta que se le ha 
pasado a los delincuentes en la que ponían los amigos que tenían y 
su grado de amistad (de 1 a 5). Datos para hacer pruebas:

'GRL': 'LGL' 5, 'LVJ' 2, 'RLJ' 3
'LGE': 'RBB' 4
'LRJ': 'RHJ' 1, 'LVJ' 4
'LVJ': 'GRL' 4, 'LRJ' 1, 'RLJ' 2
'RLJ': 'GRL' 1

insert into amigo values ('GRL', 'LGL', 5)
insert into amigo values ('GRL', 'LVJ', 2)
insert into amigo values ('GRL', 'RLJ', 3)
insert into amigo values ('LGE', 'RBB', 4)
insert into amigo values ('LRJ', 'RHJ', 1)
insert into amigo values ('LRJ', 'LVJ', 2)
insert into amigo values ('LVJ', 'GRL', 4)
insert into amigo values ('LVJ', 'LRJ', 1)
insert into amigo values ('LVJ', 'RLJ', 2)
insert into amigo values ('RLJ', 'GRL', 1)

1.- Dibuja el diagrama E/R, y el diagrama relacional (paso a tabla) de 
nuestra base de datos.

2.- Completa su modelo físico (crea la(s) tabla(s) necesaria(s) e inserta 
los datos)

Haz una consulta que muestre...:

3.- ...el (los) delincuente(s) con el alias con más longitud.

4.- ...sólo el identificador, alias y altura de los delincuentes fichados 
cuya altura supera la altura media de todos.

5.- ...sólo identificador, altura y número de personalidades de cada 
delincuente

6.- ...sólo el identificador y alias de los delincuentes que han dicho
que tienen amigos y el peso medio de los amigos de cada uno.

7.- Función que le pasamos el identificador de un delincuente y nos 
devuelve el número de delincuentes que han dicho que es su amigo.

8.- Función que le pasamos dos identificadores de delincuentes y 
devuelve los días que separan a sus fechas de nacimiento.

9.- Función que le pasamos el alias de un delincuente y nos 
devuelve todos los dni que están asociados a ese alias (puede 
haber alias repetidos).

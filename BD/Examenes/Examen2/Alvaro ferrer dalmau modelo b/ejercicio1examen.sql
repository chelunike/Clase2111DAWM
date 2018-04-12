create DATABASE DBD1Libros

create table libros(
titulo varchar (40),
precio float,
publicación DATE)

insert into libros values ('Quijote',3.70,'16/06/1980')
insert into libros values ('Biblia',2.65,'31/03/1990')
insert into libros values ('Coran',2.85,'02/12/1985')
insert into libros values ('Buscon',1.60,'29/02/1996')

select * from libros order by publicación

select titulo, precio from libros order by precio

select (MIN (publicación)), (AVG(precio)) from libros

update libros
	set precio = precio+0.05
	where titulo like 'Q%'
	
delete libros
	where titulo like 'Bus%'

select * from libros
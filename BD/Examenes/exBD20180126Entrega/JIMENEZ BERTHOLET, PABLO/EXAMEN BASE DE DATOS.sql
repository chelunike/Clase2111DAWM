drop database ExamenEnero2018
create database ExamenEnero2018

use ExamenEnero2018


drop table delicuente
create table delincuente(
idletras char(3),
alias varchar(20),
fecnac date,
peso decimal,
altura decimal,
fichado_o_no varchar(5) check(fichado_o_no in ('si','no'))

primary key(idletras)
)


drop table personalidad
create table personalidad(
DNI char(8),
nombre_falso varchar(30),
idletras char(3),

primary key(DNI),
foreign key(idletras) references delincuente(idletras)

on update cascade
on delete no action
)

drop table amigo
create table amigo(
amigo char(3),
idletra char(3),
amistad int check (amistad in(1,2,3,4,5))

primary key(amigo, idletra)
)

insert into delincuente values ('LVJ', 'La oveja', '29/2/1940', 75, 164, 'si') 
insert into delincuente values ('LRJ', 'La oreja', '26/1/1970', 95, 165, 'si') 
insert into delincuente values ('GRL', 'Garulo',   '3/5/1971', 108, 160, 'si') 
insert into delincuente values ('LGL', 'Leguleyo', '4/7/1992',  78, 172, 'no') 
insert into delincuente values ('LGE', 'Ligero',   '26/1/1990', 65, 170, 'si') 
insert into delincuente values ('RHJ', 'Rehijo',   '23/2/1980', 88, 190, 'no') 
insert into delincuente values ('RLJ', 'Reloj',    '2/1/2015',  38,  70, 'no') 
insert into delincuente values ('RBB', 'Rebaba',   '3/12/2010', 67, 120, 'no') 

select* from delincuente


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

select* from personalidad


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

select* from amigo


3.

select*
from delincuente
where alias = MAX(%)



4.
select alias, idletras, AVG(altura)
from delincuente
group by altura, alias, idletras


5.

select delincuente.idletras, altura, count(personalidad.idletras) as num_personalidades
from delincuente inner join personalidad
	on personalidad.idletras = delincuente.idletras 
	group by delincuente.idletras, delincuente.altura


6.

select delincuente.idletras, alias, AVG(delincuente.peso)
from delincuente inner join amigo
on delincuente.idletras = amigo.idletra
group by delincuente.idletras, delincuente.alias



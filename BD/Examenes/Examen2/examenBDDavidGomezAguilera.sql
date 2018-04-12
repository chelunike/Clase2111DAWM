create database BDA1Amigos
use BDA1Amigos
create table amigos
(
nombre varchar(40),
nacimiento date,
altura tinyint
);
select * from amigos
insert into amigos (nombre,nacimiento,altura)
values ('juan','16/6/1980',1.70)
insert into amigos(nombre,nacimiento,altura)
values ('ana','31/3/1990',1.65)
insert into amigos(nombre,nacimiento,altura)
values ('pedro','2/12/1985',1.85)
insert into amigos(nombre,nacimiento,altura)
values ('elena','29/2/1996',1.60)


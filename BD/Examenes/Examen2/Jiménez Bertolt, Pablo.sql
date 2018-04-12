create database BDB2Censo
use bdb2censo
drop table ciudad
create table ciudad(
codigo char(2) primary key, 
nombre varchar(40)
)
create table persona(
idper int identity(1,1) primary key,
nombre varchar(40),
censadoEn char(2)
)
create table props(
ciudad varchar(30),
propietario varchar(30),
referencia int primary key
)
insert into ciudad (codigo,nombre)
values ('GR', 'Granada')
insert into ciudad values ('CI', 'Ciudad Real')
insert into ciudad values ('MA', 'Madrid')
insert into ciudad values ('GN', 'Granada')
insert into ciudad values ('MG', 'Málaga')
insert into ciudad values ('CR', 'Ciudad Rodrigo')
select* from ciudad

insert into persona (nombre, censadoEn)
values('Juan López', 'GR')
insert into persona values ('Elena Ruiz','GN')
insert into persona values ('Jesús Sánchez','CI')
insert into persona values ('Ana Fernandez','CI')
insert into persona values ('Luis Bueno','MA')
insert into persona values ('José Cuevas','MA')
insert into persona values ('Miguel Cara','CR')
insert into persona values ('Dolores Dumas','null')
select* from persona
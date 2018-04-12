
create database BDB1Libros;
use BDB1Libros;
create table Libro (
	Titulo varchar(30) primary key,
	Precio float not null,
	Publicacion date
);

insert into Libro values ('Quijote',3.70,'16/6/1980');
insert into Libro values ('Biblia',2.65,'31/3/1990');
insert into Libro values ('Corán',2.85,'2/12/1985');
insert into Libro values ('Buscón',1.60,'29/2/1996');

select * from Libro order by Publicacion desc;

select Titulo,Precio from Libro order by Precio;

select min(Publicacion),AVG(Precio) from libro;

update Libro set Precio = Precio +0.05 where Titulo = 'Quijote'

delete from Libro where Titulo = 'Buscón'



create database BDB2Censo
use BDB2Censo

create table ciudad(
	codigo char(2) primary key,
	nombre varchar(40)
)
create table persona(
	idper int identity(1,1) primary key,
	nombre varchar(40),
	censadoEn char(2) references ciudad
)
insert into ciudad values('GR','Granada');
insert into ciudad values('CI','Ciudad Real');
insert into ciudad values('MA','Madrid');
insert into ciudad values('GN','Granada');
insert into ciudad values('MG','Málaga');
insert into ciudad values('CR','Ciudad Rodrigo');

insert into persona values('Juan Lopez', 'GR');
insert into persona values('Elena Ruiz', 'GN');
insert into persona values('Jesús Sánchez', 'CI');
insert into persona values('Ana Fernández', 'CI');
insert into persona values('Luis Bueno', 'MA');
insert into persona values('José Cuevas', 'MA');
insert into persona values('Miguel Cara', 'CR');
insert into persona values('Dolores Dumas', null);

select codigo,nombre,(select COUNT(*) from persona where censadoEn = codigo)
 from ciudad where (select COUNT(*) from persona where censadoEn = codigo) >=1
 
select codigo,nombre from ciudad 
where (select COUNT(*) from persona where censadoEn = codigo) = 0

-- By Manuel Herrera, Que nadie me lo copie xD

create database BDB3Propiedades
use BDB3Propiedades

create table ciudad(
	codigo char(2) primary key,
	nombre varchar(40)
)
create table persona(
	idper int identity(1,1) primary key,
	nombre varchar(40),
	censadoEn char(2) references ciudad
)
create table propietario(
	cciudad char(2) references ciudad(codigo),
	idpersona int references persona(idper),
	refP int not null
)
insert into ciudad values('GR','Granada');
insert into ciudad values('CI','Ciudad Real');
insert into ciudad values('MA','Madrid');
insert into ciudad values('GN','Granada');
insert into ciudad values('MG','Málaga');
insert into ciudad values('CR','Ciudad Rodrigo');

insert into persona values('Juan Lopez', 'GR');
insert into persona values('Elena Ruiz', 'GN');
insert into persona values('Jesús Sánchez', 'CI');
insert into persona values('Ana Fernández', 'CI');
insert into persona values('Luis Bueno', 'MA');
insert into persona values('José Cuevas', 'MA');
insert into persona values('Miguel Cara', 'CR');
insert into persona values('Dolores Dumas', null);

insert into propietario VALUES ('MA',1,1300);
insert into propietario VALUES ('MA',1,1301);
insert into propietario VALUES ('MA',1,1308);
insert into propietario VALUES ('MG',1,2300);
insert into propietario VALUES ('MG',1,2303);
insert into propietario VALUES ('MG',2,2303);
insert into propietario VALUES ('MG',2,2304);
insert into propietario VALUES ('GR',3,3309);
insert into propietario VALUES ('GN',4,4300);

Select codigo,nombre from ciudad where 
(select COUNT(*) from propietario where cciudad = codigo) 
>= 
MAX(select COUNT(*) from propietario group by cciudad)
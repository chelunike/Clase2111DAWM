-- BASE DE DATOS
create database ejercicio22
use ejercicio22

-- TABLA PROYECTOS
create table proyecto (
codigo varchar(20) primary key,
descripcion varchar(40),
cuantia int,
fecinic datetime,
fecfin datetime
)

insert into proyecto values('1','p.física','1','10/02/2018','22/03/2018')
insert into proyecto values('2','p.química','1','06/01/2018','04/05/2018')
insert into proyecto values('3','p.astrología','1','16/01/2018','23/03/2018')
insert into proyecto values('4','p.informática','1','12/02/2018','04/03/2018')
insert into proyecto values('5','p.artesanales','1','02/01/2018','22/08/2019')
insert into proyecto values('6','p.escolares','1','09/02/2018','15/07/2018')

-- TABLA CLIENTES
create table cliente (
ccodigo varchar(20) primary key,
tlf int,
domicilio varchar (30),
razonsocial varchar(40)
)

insert into cliente values('1','123456789','calle 01','p.física')
insert into cliente values('2','123456788','calle 02','p.química')
insert into cliente values('3','123456787','calle 03','p.astrología')
insert into cliente values('4','123456786','calle 04','p.informática')
insert into cliente values('5','123456785','calle 05','p.artesanales')
insert into cliente values('6','123456784','calle 06','p.escolares')

-- TABLA COLABORADORES
create table colaborador (
nif varchar(10) primary key,
nombre varchar(30),
domicilio varchar (30),
cotlf int,
banco varchar (30),
numcuenta varchar(30)
)

insert into colaborador values('12345678A','Pepe Ramírez Torres','Calle 10','987654321','BBVA','12345678901020949863')
insert into colaborador values('12345678B','Jose Fuentes Navarro','Calle 11','987654322','BANKIA','12345678901020949864')
insert into colaborador values('12345678C','Luis Cervantes Torres','Calle 12','987654323','BBVA','12345678901020949865')
insert into colaborador values('12345678D','Manuel Cobos Domingo','Calle 13','987654324','BANKINTER','12345678901020949866')
insert into colaborador values('12345678E','Ana Arevalo Fernández','Calle 14','987654325','BANKINTER','12345678901020949867')
insert into colaborador values('12345678F','Lola Arcos Fuentes','Calle 15','987654326','BBVA','12345678901020949861')


-- TABLA PAGOS
create table pago (
numpago varchar (20) primary key,
concepto varchar(30),
cantidad varchar (30),
fechapago datetime
)

insert into pago values('001','p.física','90','02/02/2018')
insert into pago values('002','p.química','76','18/01/2018')
insert into pago values('003','p.astrología','56','21/02/2018')
insert into pago values('004','p.informática','20','01/01/2018')
insert into pago values('005','p.artesanales','86','09/02/2018')
insert into pago values('006','p.escolares','13','10/01/2018')

-- TABLA TIPOS DE PAGO
create table tipospago (
tpcodigo varchar (20) primary key,
descripcion varchar(30)
)

insert into tipospago values('01','MasterCard')
insert into tipospago values('02','Visa')
insert into tipospago values('03','Visa')
insert into tipospago values('04','Visa')
insert into tipospago values('05','MasterCard')
insert into tipospago values('06','Paypal')


-- EJERCICIOS

-- 1. Mostrar el nombre de los colaboradores cuyo banco es BBVA
select nombre, banco from colaborador
where banco = '%BBVA%'

-- 2. Mostrar cuál es el pago máximo y cuál es su concepto
select max(cantidad) as cantidad from pago

--3. Mostrar los DNI de los colaboradores que contengan la letra B
select nombre,NIF from colaborador
where NIF like '%B%'

--4. Mostrar todas las fechas de pago después del mes de enero.
select numpago,fechapago from pago
where fechapago > '31/01/2018'

--5. Mostrar todos los clientes que su razón social son escolares y artesanales.
select ccodigo as codigo,tlf,domicilio,razonsocial from cliente
where razonsocial = 'p.escolares' or razonsocial = 'p.artesanales'

--6. Mostrar cuál es el tipo de pago más usado
select * from tipospago
where descripcion = (select max(descripcion) from tipospago)

--7. Mostrar todos los colaboradores que usan Bankinter
select * from colaborador
where banco = '%BANKINTER%'
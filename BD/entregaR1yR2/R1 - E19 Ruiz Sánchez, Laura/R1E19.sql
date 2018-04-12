create database R1E19
use R1E19

create table categoria(
	codCategoria int check(codCategoria in('1','2','3','4','5')) primary key,
	tipoIVA int,
	descripcion varchar(30)
)

create table hotel(
	nombreH varchar(30) primary key,
	direccionH varchar(50),
	telefonoH varchar(9),
	añoConstrucion date,
	codCategoria int references categoria
)

create table habitacion(
	codHabitacion varchar(3) primary key,
	tipoHa varchar(10) check (tipoHa in('suite','doble','individual')),
	nombreH varchar(30) references hotel
)

create table agencia(
	codAgencia varchar(2) primary key,
	nombreA varchar(30),
	telefonoA varchar(9),
	direccionA varchar(30),
	nombrePart varchar(30)
)

create table reserva_agencia(
	codAgencia varchar(2) references agencia,
	codHabitacion varchar(3) references habitacion,
	fechaInicio date,
	fechaFin date
	primary key (codAgencia, codHabitacion)
)

create table particular(
	codParticular varchar(2) primary key,
	nombreP varchar(30),
	direccionP varchar(30),
	telefonoP varchar(9)
)

create table reserva_particular(
	codParticular varchar(2) references particular,
	codHabitacion varchar(3),
	fechaInicio date,
	fechaFin date,
	primary key (codParticular, codHabitacion)
)

insert into categoria values('3','10','Un hotel normalillo')
insert into categoria values('4','15','Un hotel bueno')
insert into categoria values('1','5','Un hotel malo')
insert into categoria values('2','10','Un hotel regular')
insert into categoria values('5','15','Un hotel genial')

insert into hotel values('Abades','C/Paris ,Granada','958741263','1992-05-12','3')
insert into hotel values('Nazaret','C/Juan Oró ,Almeria','956472103','1997-07-18','2')
insert into hotel values('Saray','C/Francisco ,Jaen','978452013','2004-04-29','4')
insert into hotel values('Barceló','C/Blanco ,Granada','947851203','1990-11-30','5')
insert into hotel values('Galanes','C/Canastas ,Motril','963214785','2011-01-01','1')

insert into habitacion values('102','suite','Abades')
insert into habitacion values('510','doble','Saray')
insert into habitacion values('306','individual','Barceló')
insert into habitacion values('408','doble','Galanes')
insert into habitacion values('104','suite','Nazaret')

insert into agencia values('a1','agencia1','958000001','C/Agencia1','Juan')
insert into agencia values('a2','agencia2','958000002','C/Agencia2','Antonia')
insert into agencia values('a3','agencia3','958000003','C/Agencia3','Pepe')
insert into agencia values('a4','agencia4','958000004','C/Agencia4','Isa')
insert into agencia values('a5','agencia5','958000005','C/Agencia5','Pablo')

insert into reserva_agencia values('a1','510','2018-10-20','2018-10-30')
insert into reserva_agencia values('a2','408','2018-09-20','2018-09-30')
insert into reserva_agencia values('a3','306','2018-08-20','2018-08-30')
insert into reserva_agencia values('a4','104','2018-07-20','2018-07-30')
insert into reserva_agencia values('a5','102','2018-06-20','2018-06-30')

insert into particular values('p1','Lara','C/Girasoles','958120474')
insert into particular values('p2','Lucas','C/Hipica','954712036')
insert into particular values('p3','Luis','C/Andres Segovia','941203685')
insert into particular values('p4','Lorenzo','C/Sierra Nevada','978451203')
insert into particular values('p5','Lucia','C/Antorcha','647120583')

insert into reserva_particular values('p1','510','2018-05-20','2018-05-30')
insert into reserva_particular values('p2','408','2018-04-20','2018-04-30')
insert into reserva_particular values('p3','306','2018-03-20','2018-03-30')
insert into reserva_particular values('p4','104','2018-02-20','2018-02-25')
insert into reserva_particular values('p5','102','2018-01-20','2018-01-22')


select * from categoria
select * from hotel
select * from habitacion
select * from agencia
select * from reserva_agencia
select * from particular
select * from reserva_particular

--1.Hoteles con categoria <=3
select nombreH 
	from hotel
	where codCategoria <=3
	
--2.Muestra el nombre del particular con codigo p1 y 
--el tipo de habitacion que ha reservado
select nombreP, codHabitacion,
				(select tipoHa from habitacion 
				where codHabitacion = rp.codHabitacion)'tipo habitacion'
	from particular p , reserva_particular rp
	where p.codParticular='p1' and rp.codParticular='p1'

--3.Reserva del particular con codigo 2
select * ,(select nombreP from particular
			where codParticular=r.codParticular)'nombre particular'
	from reserva_particular r
	where codParticular='p2'


--4.Cambiar fecha fin(2019-01-01) de la agencia con codigo 4
update reserva_agencia
	set fechaFin = '2019-01-01'
	where codAgencia = '4'
select * from reserva_agencia

--5.Todas las reservas
select * 
	from reserva_agencia ra inner join reserva_particular rp
		on ra.codHabitacion=rp.codHabitacion

--6.Insertar un nuevo hotel con categoria 3
insert into hotel values ('Nuevo','C/Galicia ,Pamplona','987152436','2017-12-31','3')
select * from hotel
delete hotel where nombreH='Nuevo'

--7.Muestras las habitaciones que sean individuales 
--y el nombre del hotel en el que se encuentran
select tipoHa, nombreH from habitacion
	where tipoHa='individual'
	
--8.Mostrar reservas del hotel Saray
select rp.codParticular, (select nombreH from habitacion
						where nombreH='Saray'
						and codHabitacion= rp.codHabitacion)
	from reserva_particular rp, habitacion
	

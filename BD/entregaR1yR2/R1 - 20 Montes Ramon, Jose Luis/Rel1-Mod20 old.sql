-- Agencia de Seguros --

/*
  ___                        _         _____                                
 / _ \                      (_)       /  ___|                               
/ /_\ \ __ _  ___ _ __   ___ _  __ _  \ `--.  ___  __ _ _   _ _ __ ___  ___ 
|  _  |/ _` |/ _ \ '_ \ / __| |/ _` |  `--. \/ _ \/ _` | | | | '__/ _ \/ __|
| | | | (_| |  __/ | | | (__| | (_| | /\__/ /  __/ (_| | |_| | | | (_) \__ \
\_| |_/\__, |\___|_| |_|\___|_|\__,_| \____/ \___|\__, |\__,_|_|  \___/|___/
        __/ |                                      __/ |                    
       |___/                                      |___/     
*/

create database seguros
use seguros

-- Creamos Tablas --
create table persona(
	dni int check(dni>10000000) primary key,
	nombre varchar(30) not null,
	apellidos varchar(50) not null,
	direccion varchar(50),
	poblacion varchar(30),
	telefono int check(telefono>100000000)
)

create table vehiculo(
	matricula char(7) primary key,
	marca varchar(30) not null,
	modelo varchar(30),
)

create table multa(
	id int identity(1,1) primary key,
	fecha date not null,
	hora time not null,
	lugar varchar(50) not null,
	infraccion varchar(250),
	importe decimal(8,2) not null,
	persona int references persona
		on delete cascade
		on update cascade,
	vehiculo char(7) references vehiculo
		on delete cascade
		on update cascade
)

create table accidente(
	numRef int identity(1,1) primary key,
	fecha date not null,
	hora time not null,
	lugar varchar(50) not null
)

create table accidentados(
	accidente int references accidente
		on delete cascade
		on update cascade,
	persona int references persona
		on delete cascade
		on update cascade,
	vehiculo char(7) references vehiculo
		on delete cascade
		on update cascade
)

create table tiene(
	persona int references persona
		on delete cascade
		on update cascade,
	vehiculo char(7) references vehiculo
		on delete cascade
		on update cascade
)

-- Insertamos los datos --

insert into persona values
(11223344,	'Josemi',	'Martinez',	'Calle de la Amargura Nº5',	'Granada',	958456532),
(55667788,	'Antonio',	'Romero',	'Calle Jacinto Nº10',	'Granada',	958455658),
(22334455,	'David',	'Catastro',	'Calle Salamanca Nº23',	'Jaen',	958123145),
(33445566,	'Jose Maria',	'Montiel',	'Calle HTML y CSS',	'Huelva',	958789461),
(44556677,	'Placido',	'Ramirez',	'Calle Almuñecar Nº12',	'Granada',	958613294),
(55447788,	'Manuel',	'Morales',	'Calle Almuñecar Nº14',	'Granada',	958741236)

insert into vehiculo values
('1234abc',	'Opel',	'Corsa'),
('5678def',	'Citroen',	'AX'),
('4321ghi',	'Opel',	'Zafira'),
('9874jkl',	'Peugot',	'2008SUV'),
('7415mno',	'Citroen',	'c4'),
('9856pqr',	'Tesla',	'X'),
('9632stu',	'Peugot',	'308SW')

insert into tiene values
('11223344', '5678def'),
('55447788', '5678def'),
('22334455', '1234abc'),
('55667788', '4321ghi'),
('44556677', '9874jkl'),
('33445566', '9856pqr'),
('33445566', '9632stu'),
('22334455', '7415mno')


insert into accidente values
('03/03/1999',	'16:00', 'Avnda Dilar'),
('08/06/2001',	'7:00', 'Calle Pintor Maldonado'),
('11/09/2001',	'9:59', 'Liberty Street & Church Street'),
('05/09/2004',	'20:00', 'Avnda Don Bosco'),
('04/12/2004',	'14:00', 'Calle Almuñecar'),
('24/07/2005',	'13:30', 'Calle Santa Rosalia'),
('06/09/2006',	'18:30', 'Avnda Dilar'),
('06/09/2006',	'19:00', 'Calle Arabial'),
('07/03/2008',	'12:45', 'Gran Via'),
('09/09/2009',	'19:39', 'Calle Nueve')


insert into accidentados values
(1,	'33445566',	'9856pqr'),
(1,	'11223344',	'5678def'),
(2,	'55447788',	'5678def'),
(2,	'33445566',	'9632stu'),
(3,	'11223344',	'5678def'),
(3,	'11223344',	'5678def'),
(4,	'22334455',	'1234abc'),
(5,	'33445566',	'9856pqr'),
(6,	'55667788',	'4321ghi'),
(7,	'55667788',	'4321ghi'),
(8,	'11223344',	'5678def'),
(9,	'33445566',	'9632stu')


insert into multa values
('04/05/2005',	'23:00',	'Avnda Dilar',	'Conducir en dirrecion contraria',	5996,12,	55667788,	'5678def'),
('06/08/2006',	'7:45',	'Calle Pintor Maldonado',	'Exceso de velocidad',	300,	11223344,	'5678def'),
('01/02/2007',	'13:45',	'Avnda America',	'Saltarse un stop',	100,	22334455,	'7415mno'),
('09/03/2008',	'18:51',	'Carretera de la Sierra',	'Exceso de velocidad 300Km/h',	500,	'33445566,	9856pqr'),
('09/11/2009',	'12:48',	'Calle Santa Rosalia',	'Exceso de velocidad',	300,	55667788,	'5678def'),
('30/05/2010',	'3:25',	'Calle Primavera',	'Conducir Ebrio',	1354,05,	11223344,	'5678def'),
('28/02/2011',	'19:26',	'Avnda Don Bosco',	'Saltarse un shemaforo',	150,	33445566, '9632stu'),
('18/09/2012',	'6:00',	'Calle Pintor Maldonado',	'Saltarse un shemaforo',	150,	11223344,	'5678def'),
('13/02/2018',	'10:15',	'Calle Primavera',	'Invalidez del Carnedtd',	100,99,	55667788, '5678def')

/*
	 -- -- -- -- -- Consultas -- -- -- -- -- 
*/

-- Num Personas y vehiculos que han sufrido algun accidente

-- NUmero de coches con mas de un propietario

-- Personas con mas de un vehiculo

-- Acciendetes con mas de una persona involucrada
-- Y mas de un vehiculo

-- Accidentes con num de personas involucradas anteriores a 2005

-- Numero de multas de un persona

-- Total a pagar en multas de una persona

-- Personas con importes totales superiores a la media

-- Funcion para obtener una lista de accidentes a patir de una persona

-- Procedimiento para obtener un listado de personas que tengan accidentes y multas


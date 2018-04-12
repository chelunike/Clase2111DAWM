create database BDA1Amigos
create table Persona(
	Nombre varchar(20),
	Nacimiento date,
 	Altura decimal(8,2),
 	CONSTRAINT pk_nombre PRIMARY KEY (Nombre)
 	)
 insert into Persona
	values('Juan','16/6/1980',1.70),('Ana','31/3/1990',1.65),
	('Pedro','2/12/1985',1.85),('Elena','29/2/1996',1.60)
select Nombre, Nacimiento, Altura from Persona
	order by Nacimiento
select Nombre, Altura from Persona
	order by Altura asc
select Nacimiento from Persona 
	where DATEDIFF(yy,Nacimiento,GETDATE())=
UPDATE Persona
	where Nombre is 'Ana'
	set Altura='1.68'
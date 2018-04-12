create database ej1_21
use ej1_21

create table viajero(
	dni varchar(10) primary key,
	nombre varchar(30),
	direccion varchar(30),
	telefono int
)

	insert into viajero values
	('111','Antonio','Balsas 4',633999333),
	('222','Paco','Zaidin 4',633999344),
	('333','Jose','Mar 4',633999355),
	('44','Martin','Jupiter 4',633999666)

	
create table lugar(
	codigo varchar(6) primary key,
	nombre varchar(20),
	pais varchar (10)
)
	insert into lugar values
	('001','Granada','España'),
	('002','Xian','China'),
	('003','Tokio','Japon'),
	('004','Barcelona','España')
	
create table viaje(
	codigo varchar(6) primary key,
	fecha date,
	nplazas int,
	origen varchar(6) not null references lugar,
	destino varchar(6) not null
	FOREIGN KEY (destino) REFERENCES lugar (codigo)
)

	insert into viaje values
	('v001','22/2/2002',10,'001','002'),
	('v002','22/2/2002',4,'001','003'),
	('v003','22/6/2002',10,'002','001'),
	('v004','22/2/2002',10,'004','001')
	
create table ticket(
	codigo varchar(6) primary key,
	cviajero varchar(10) references viajero,
	cviaje varchar(6) references viaje,
	clase varchar(10),
	asiento int,
)

	insert into ticket values	('t001','111','v001','VIP',4)
	insert into ticket values	('t002','222','v002','VIP',1)
	insert into ticket values	('t003','333','v003','TURISTA',5)
	insert into ticket values	('t004','44','v004','VIP',4)
	insert into ticket values	('t005','111','v004','VIP',5)
	

--CONSULTAS

--MUESTRA TODOS LOS TICKETS CON DESTINO
--A XIAN DE CLASE VIP

	select * from ticket
		where cviaje in (select codigo from viaje
					where destino='002')
		and clase = 'VIP'
		

--MUESTRA LOS NOMBRES DE LOS VIAJEROS 
--QUE HAN IDO A TOKIO

	select nombre from viajero
	where dni in ( select cviajero from ticket
				   where codigo in (select codigo from viaje
									where destino='003'))
			

--MUESTRA EL VIAJERO CON
--MAS TICKETS COMPRADOS
		select top 1 with ties cviajero, count(*) as veces from ticket
				group by cviajero
				order by veces DESC
	

--VECES QUE SE HA VIAJADO A GRANADA
		select COUNT(*) from viaje
		where destino='001'
		
		
--VECES QUE SE HA VIAJADO A GRANADA
--DESDE XIAN
		select COUNT(*) from viaje
		where destino='001' and
		origen = '002'
		
--CREAR PROCEDIMIENTO PARA CANCELAR LA COMPRA
--DE UN BILLETE QUE HA REALIZADO UN CLIENTE
alter procedure p4
		@tcodigo varchar(6)
	as begin
		delete from ticket
		where codigo = @tcodigo
		end
		
	
	
	exec  p4 't001'
	select * from ticket



--CREAR PROCEDIMIENTO PARA DAR
--DE AlTA A UN CLIENTE
create procedure nuevoSocio
		@dni varchar(6),
		@nombre varchar(30),
		@direccion varchar(30),
		@telefono int
	as begin
		
	
	
	exec  p4 't001'
	select * from ticket
	
	
--FUNCION QUE DEVUELVA UN LISTADO
--DE LOS SOCIOS CON SU DIRECCION
--USANDO CURSOR
alter function fListado()
returns varchar (500)
as begin
	declare @s varchar(500),
			@dni varchar (6), 
			@nombre varchar (30),
			@direccion varchar(30),
			@dirActual varchar (30),
			@telefono int
	set @s=''
	declare cu CURSOR for
		select dni, direccion from viajero	
		order by direccion, dni
	open cu
	fetch cu into @dni, @direccion
	set @dirActual = @direccion
	set @s = 'Socio que vive en '+@direccion+': '
	while (@@fetch_status=0) begin
		if @diractual =@direccion
			set @s += ' '+@dni
		else begin 
			set @dirActual = @direccion
			set @s += char(10)+'Socio que vive en '+@diractual + ':  '+@dni+','
		end
		fetch cu into @dni, @direccion
	end
	close cu
	deallocate cu
	return @s
end

print dbo.fListado()
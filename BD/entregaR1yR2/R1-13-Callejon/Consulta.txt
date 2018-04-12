create database ejercicio13
use ejercicio13


create table persona(
	dni char(9) primary key,
	nombre varchar(30),
	direccion varchar (50),
	telefono char(9),
	padre char(9) references persona,
	madre char(9) references persona,
	
)

drop table persona


--padres
insert into persona values('12345678A','Raul','calle 1',123456789,null,null)
insert into persona values('12345678C','Ana','calle 1',758439584,null,null)
insert into persona values('12345678B','Oscar','calle 2',285869548,null,null)
insert into persona values('12345678D','Maria','calle 2',194859689,null,null)



--hijos
insert into persona values('12345678E','Albert','calle 1',675849609,'12345678A','12345678C')
insert into persona values('12345678H','Alex','calle 1',675849609,'12345678A','12345678C')
insert into persona values('12345678I','Alvaro','calle 1',675849609,'12345678A','12345678B')
insert into persona values('12345678L','Francis','calle 2',675849609,'12345678B','12345678D')



--Haz las consultas..

--Que muestren a las personas que son hijos

select * from persona
where padre is not null and madre  is not null

--Que muestren a las personas que son padres

select * from persona
where padre is  null and madre  is  null

--Que muestre que solo muestre el hijo de raul y ana

select * from persona
where padre = '12345678A' and madre= '12345678C'


--Que muestre las familia que vive en la calle 1

select * from persona
where direccion = 'calle 1'


--Que muestre las personas que en en su dni tenga la A

select * from persona
where dni like '%A%'

--Los padres que viven juntos

select * from persona
where direccion='calle 2' and padre is null and madre is null



--Que muestren los que son hermanos

select dni
into hijos
from persona
where padre = '12345678A' and madre= '12345678C'
group by dni

select * from 
persona P,hijos H
where P.dni= H.dni

drop table hijos

--funcion que le pasamos un dni y nos devuelve un nombre
create function nombres (@dni char(9))
returns table
as return select nombre 
            from persona
             where dni = @dni
			 


select * from persona

select * from nombres('12345678E')
select * from nombres('12345678A')
select * from nombres('12345678B')





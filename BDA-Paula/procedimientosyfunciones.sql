Delimiter //
create procedure  mostrarNombres (codequipo char(3), nombreequipo varchar(40))
begin 


end;//

create function mostrarNombres(cod char(3)) returns varchar(40) reads sql data
begin 
declare nombreequipo varchar(40);
select nombre into nombreequipo from Equipo
where cod_equipo = cod;
return nombreequipo;
end;

drop procedure mostrarNombres;

select mostrarNombres ('012' );




Delimiter //
create procedure  VerEquipo (Cod_Equipo char(3), Nombre varchar(40), Fecha_Fun int, Pais varchar(30), Estadio varchar(100), Deporte varchar(30))
begin 


end;//

Delimiter //
create procedure VerEquipo()
begin
declare Cod_Equipo char(3);
declare Nombre varchar(40);
declare Fecha_Fun int;
declare Pais varchar(30);
declare Estadio varchar(100);
declare Deporte varchar(30);
declare fin bool default 0;
declare c cursor for select Cod_Equipo, Nombre, Fecha_Fun, Pais, Estadio, Deporte from equipo;
declare continue handler for not found set fin = 1;
open c;
fetch c into Cod_Equipo, Nombre, Fecha_Fun, Pais, Estadio, Deporte;
while fin = 0 do
 select concat ('Codigo equipo: ', Cod_Equipo, ' Nombre: ', Nombre, ' Fecha fundacion: ', Fecha_Fun, ' Pais: ', Pais, ' Estadio: ', Estadio, ' Deporte: ', Deporte) "Datos pedidos";
 Fetch c into Cod_Equipo, Nombre, Fecha_fun, Pais, Estadio, Deporte;
end while;
close c;
end//

drop procedure VerEquipo;

call VerEquipo();




Delimiter //
create procedure VerJugadores (eq CHAR(3))
begin
declare Id_Jugador char(5);
declare Nombre varchar(25);
declare Apellido1 varchar(25);
declare Apellido2 varchar(25);
declare Fecha_Nac date;
declare Dorsal int;
declare fin bool default 0;
declare c cursor for select Id_Jugador, Nombre, Apellido1, Apellido2, Fecha_Nac, Dorsal from jugador where Cod_Equipo =
eq;
declare continue handler for not found set fin = 1;
open c;
fetch c into Id_Jugador, Nombre, Apellido1, Apellido2, Fecha_Nac, Dorsal;
while fin = 0 do
 select concat ('Id jugador: ',Id_Jugador, 'Nombre: ', Nombre, 'Primer apellido: ', Apellido1, 'Segundo apellido: ', Apellido2, 'Fecha nacimiento: ', Fecha_Nac, 'Dorsal: ', Dorsal) "Datos jugadores";
 fetch c into Id_Jugador, Nombre, Apellido1, Apellido2, Fecha_Nac, Dorsal;
end while;
close c;
end//


drop procedure VerJugadores;

call VerJugadores('001');




















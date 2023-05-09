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

select mostrarNombres ('006');





drop database if exists Apuestas;
create database Apuestas;
use Apuestas;

#creacion de tabla Cuenta
create table Cuenta (
	Cod_Cuenta char(3) primary key,
    Nombre_Cuenta varchar(50) unique not null,
    email varchar(50) unique not null,
    Contraseña varchar(25) not null);
    
#creacion de tabla Admin
create table Administrador (
	Cod_Cuenta char(3),
	constraint pk_administrador primary key (Cod_Cuenta),
	constraint fk_administrador foreign key (Cod_Cuenta) references Cuenta(Cod_Cuenta));
    
#creacion de tabla user
create table Usuario (
	Cod_Cuenta char(3),
    NºTarjeta int(16) unique not null,
    Fecha_Caducidad date not null,
    CVV char(3) not null,
    Pin char(4) not null,
    Saldo int not null,
    constraint pk_usuario primary key (Cod_Cuenta),
	constraint fk_usuario foreign key (Cod_Cuenta) references Cuenta(Cod_Cuenta));

#creacion de tabla apuesta
create table Apuesta (
	Cod_Apuesta char(3) primary key,
    Fecha_Apuesta date not null,
    Cuota int not null,
    constraint check_Cuota check (Cuota>1));
    
#creacion de tabla gestionar
create table Gestionar (
	Cod_Cuenta char(3),
    Cod_Apuesta char(3),
    constraint pk_gestionar primary key (Cod_Cuenta, Cod_Apuesta),
	constraint fk_gestionar foreign key (Cod_Cuenta) references Administrador(Cod_Cuenta),
	constraint fk_gestionar2 foreign key (Cod_Apuesta) references Apuesta(Cod_Apuesta));
    
#creacion de tabla realizar
create table Realizar (
	Cod_Cuenta char(3),
    Cod_Apuesta char(3),
    Dinero_Apost int not null,
    constraint check_Dinero_Apost check (Dinero_Apost>0),
    constraint pk_realizar primary key (Cod_Cuenta, Cod_Apuesta),
	constraint fk_realizar foreign key (Cod_Cuenta) references Usuario(Cod_Cuenta),
	constraint fk_realizar2 foreign key (Cod_Apuesta) references Apuesta(Cod_Apuesta));
    
#creacion de tabla partido
create table Partido (
	Cod_Partido char(3) primary key,
    Fecha_Partido date not null,
    Resultado char(1));
    
#creacion de tabla Sobre
create table Sobre (
	Cod_Apuesta char(3),
	Cod_Partido char(3),
	constraint pk_sobre primary key (Cod_Partido, Cod_Apuesta),
	constraint fk_sobre foreign key (Cod_Partido) references Partido(Cod_Partido),
	constraint fk_sobre2 foreign key (Cod_Apuesta) references Apuesta(Cod_Apuesta));

#creacion de tabla equipo
create table Equipo (
	Cod_Equipo char(3) primary key,
    Nombre varchar(40) not null,
    Fecha_Fun int not null,
    Localidad varchar(50) not null,
    Pais varchar(30) not null,
    Estadio varchar(100) not null);
    
#creacion de tabla jugar
create table Jugar (
	Cod_Partido char(3),
    Cod_Equipo char(3),
    constraint pk_jugar primary key (Cod_Partido, Cod_Equipo),
	constraint fk_jugar foreign key (Cod_Partido) references Partido(Cod_Partido),
	constraint fk_jugar2 foreign key (Cod_equipo) references Equipo(Cod_Equipo));
    
#creacion de tabla jugador
create table Jugador (
	Id_Jugador char(5) primary key,
    Nombre varchar(25) not null,
    Apellido1 varchar(25) not null,
    Apellido2 varchar(25),
    Fecha_Nac date not null,
    Dorsal int not null,
    Cod_Equipo char(3),
    constraint fk_jugador foreign key (Cod_Equipo) references Equipo(Cod_Equipo));
    
#creacion de tabla golea
create table Golea (
	Cod_Partido char(3),
    Id_Jugador char(5),
    constraint pk_golea primary key (Cod_Partido, Id_Jugador),
	constraint fk_golea foreign key (Cod_Partido) references Partido(Cod_Partido),
	constraint fk_golea2 foreign key (Id_Jugador) references Jugador(Id_Jugador));
    
#creacion de tabla competicion
create table Competicion (
	Cod_Comp char(3) primary key,
    Nombre varchar(100) not null,
    Deporte varchar(45) not null);
    
#creacion de tabla deporte
create table Deporte (
	Cod_Dep char(3) primary key,
    Nombre varchar(30) not null unique);
    
#creacion de tabla participar
create table Participar (
	Cod_Equipo char(3),
    Cod_Comp char(3),
    Cod_Dep char(3),
    constraint pk_participar primary key (Cod_Equipo, Cod_Comp, Cod_Dep),
	constraint fk_participar foreign key (Cod_Equipo) references Equipo(Cod_Equipo),
	constraint fk_participar2 foreign key (Cod_Comp) references Competicion(Cod_Comp),
	constraint fk_participar3 foreign key (Cod_Dep) references Deporte(Cod_Dep));
	
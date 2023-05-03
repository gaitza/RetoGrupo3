use apuestas;

<<<<<<< HEAD
#Inserts de los administradores
insert into cuenta (cod_cuenta, nombre_cuenta, email, contraseña) values (001, "Adrian", "adrianmosan@gmail.com", "abcd*1234");
insert into cuenta (cod_cuenta, nombre_cuenta, email, contraseña) values (002, "Gaizka", "gaizkagorrotxategi87@gmail.com", "abcd*1234");
insert into cuenta (cod_cuenta, nombre_cuenta, email, contraseña) values (003, "Paula", "paulajimenezbenito@gmail.com", "abcd*1234");

insert into administrador (cod_cuenta) values (001);
insert into administrador (cod_cuenta) values (002);
insert into administrador (cod_cuenta) values (003);




#Inserts de deportes
insert into deporte (cod_dep, nombre) values (001, "Futbol");
insert into deporte (cod_dep, nombre) values (002, "Futbol Sala");
insert into deporte (cod_dep, nombre) values (003, "Balonmano");
=======
#Inserts de las Cuentas
insert into cuenta (cod_cuenta, nombre_cuenta, email, contraseña) values ("001", "Adrian", "adrianmosan@gmail.com", "abcd*1234");
insert into cuenta (cod_cuenta, nombre_cuenta, email, contraseña) values ("002", "Gaizka", "gaizkagorrotxategi87@gmail.com", "abcd*1234");
insert into cuenta (cod_cuenta, nombre_cuenta, email, contraseña) values ("003", "Paula", "paulajimenezbenito@gmail.com", "abcd*1234");
insert into cuenta (cod_cuenta, nombre_cuenta, email, contraseña) values ("004", "Jason", "jasontartanga@gmail.com", "abcd*1234");



#Inserts de los administradores
insert into administrador (cod_cuenta) values ("001");
insert into administrador (cod_cuenta) values ("002");
insert into administrador (cod_cuenta) values ("003");


#Inserts de los usuarios
insert into usuario (cod_cuenta, nºtarjeta, fecha_caducidad, cvv, pin, saldo) values ("004","1234567890123456","2026-05-01", "034", "4238", 160);


#Inserts de deportes
insert into deporte (cod_dep, nombre) values ("001", "Futbol");
insert into deporte (cod_dep, nombre) values ("002", "Futbol Sala");
insert into deporte (cod_dep, nombre) values ("003", "Balonmano");
>>>>>>> 55928fbc873144f20d6ce52a5dd1681eb17fba34




#Inserts de competicion
<<<<<<< HEAD
insert into competicion (cod_comp, nombre, deporte) values (001, "Amistoso", "Futbol");
insert into competicion (cod_comp, nombre, deporte) values (002, "Liga Santander (España)", "Futbol");
insert into competicion (cod_comp, nombre, deporte) values (003, "Serie A (Italia)", "Futbol");
insert into competicion (cod_comp, nombre, deporte) values (004, "LNFS Primera Division (España)", "Futbol Sala ");
insert into competicion (cod_comp, nombre, deporte) values (005, "Liga Asobal (España)", "Balonmano");
=======
insert into competicion (cod_comp, nombre, deporte) values ("001", "Amistoso", "Futbol");
insert into competicion (cod_comp, nombre, deporte) values ("002", "Liga Santander (España)", "Futbol");
insert into competicion (cod_comp, nombre, deporte) values ("003", "Serie A (Italia)", "Futbol");
insert into competicion (cod_comp, nombre, deporte) values ("004", "LNFS Primera Division (España)", "Futbol Sala ");
insert into competicion (cod_comp, nombre, deporte) values ("005", "Liga Asobal (España)", "Balonmano");
>>>>>>> 55928fbc873144f20d6ce52a5dd1681eb17fba34




#Inserts de Equipos
<<<<<<< HEAD
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (001, 'Athletic Club', 1898, 'Bilbao', 'España', 'San Mamés');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (002, 'Atlético de Madrid', 1903,	'Madrid', 'España', 'Civitas Metropolitano');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (003, 'UD Almeria', 1989, 'Almeria', 'España', 'Power Horse Stadium');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (004, 'FC Barcelona', 1899, 'Barcelona', 'España', 'Spotify Camp Nou');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (005, 'Cádiz CF', 1910, 'Cádiz', 'España', 'Estadio Nuevo Mirandilla');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (006, 'RC Celta de Vigo', 1923, 'Vigo', 'España', 'Abanca-Balaídos');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (007, 'Elche CF', 1922, 'Elche', 'España', 'Martinez Valero');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (008, 'RCD Espanyol', 1900, 'Barcelona', 'España', 'RCDE Stadium');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (009, 'Getafe CF', 1983, 'Getafe', 'España', 'Coliseum Alfonso Pérez');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (010, 'Girona FC', 1930, 'Girona', 'España', 'Montilivi');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (011, 'RCD Mallorca', 1916, 'Mallorca', 'España', 'Son Moix');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (012, 'CA Osasuna', 1919, 'Pamplona', 'España', 'El Sadar');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (013, 'Rayo Vallecano', 1924, 'Vallecas', 'España', 'Estadio de Vallecas');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (014, 'Real Betis Balonpié', 1907, 'Sevilla', 'España', 'Benito Villamarín');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (015, 'Real Madrid CF', 1902, 'Madrid', 'España', 'Santiago Bernabéu');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (016, 'Real Sociedad', 1909, 'San Sebastián', 'España', 'Reale Arena');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (017, 'Real Valladolid CF', 1928, 'Valladolid', 'España', 'José Zorrilla');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (018, 'Sevilla FC', 1890, 'Sevilla', 'España', 'Ramón Sánchez-Pizjuán');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (019, 'Valencia CF', 1919, 'Valencia', 'España', 'Mestalla');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (020, 'Villarreal CF', 1942, 'Villarreal', 'España', 'Estadio de la Cerámica');

insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (021, 'Atalanta', 1907,	'Bergamo', 'Italia', 'Gewiss Stadium');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (022, 'Bologna', 1909,	'Bolonia', 'Italia', 'Renato Dall´Ara');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (023, 'U.S. Cremonese', 1903, 'Cremona', 'Italia', 'Stadio Giovanni Zini');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (024, 'Empoli F.C.', 1920,	'Empoli', 'Italia', 'Estadio Carlo Castellani');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (025, 'Fiorentina', 1926,	'Florencia', 'Italia', 'Artemio Franchi');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (026, 'Hellas Verona F.C.', 1903,	'Verona', 'Italia', 'Marcantonio Bentegodi');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (027, 'Internazionale', 1908,	'Milan', 'Italia', 'Giuseppe Meazza');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (028, 'Juventus', 1897,	'Turin', 'Italia', 'Allianz Stadium');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (029, 'Lazio', 1900, 'Roma', 'Italia', 'Olímpico de Roma');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (030, 'U.S. Lecce', 1908, 'Lecce', 'Italia', 'Stadio Via del Mare');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (031, 'A.C. Milan', 1899, 'Milan', 'Italia', 'Calcistico San Siro');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (032, 'A.C. Monza', 1912, 'Monza', 'Italia', 'Estadio Brianteo');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (033, 'S.S.C Napoli', 1926, 'Napoles', 'Italia', 'Diego Armando Maradona');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (034, 'A.S. Roma', 1927, 'Roma', 'Italia', 'Olimpico de Roma');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (035, 'U.S. Salernitana', 1919, 'Salermo', 'Italia', 'Arechi');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (036, 'U.C. Sampdoria', 1946, 'Genova', 'Italia', 'Stadio Luigi Ferraris');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (037, 'Sassuolo Calcio', 1920, 'Reggio Emilia', 'Italia', 'MAPEI Stadium - Citta del Tricolore');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (038, 'Spezia Calcio', 1906, 'Via Nicolo Fieschi', 'Italia', 'Estadio Alberto Picco');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (039, 'Torino F.C.', 1906, 'Turin', 'Italia', 'Olimpico de Turin');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (040, 'Udinese', 1896, 'Udine', 'Italia', 'Stadio Friuli');

insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (041, 'Barça', 1978, 'Barcelona', 'España', 'Palau Blaugrana');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (042, 'Cordoba Patrimonio de la Humanidad', 2013, 'Cordoba', 'España', 'Palacio Municipal de Deportes Vista Alegre');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (043, 'ElPozo Murcia Costa Calida', 1989, 'Murcia', 'España', 'Palacio de Deportes de Murcia');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (044, 'Industrias Santa Coloma', 1975, 'Santa Coloma de Gramenet', 'España', 'Pabellon Nuevo');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (045, 'Inter FS', 1977, 'Torrejon de Ardoz', 'España', 'Jorge Garbajosa');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (046, 'Jaen FS', 1980, 'Jaen', 'España', 'Olivo Arena');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (047, 'Jimbee Cartagena', 2013, 'Cartagena', 'España', 'Palacio de los Deportes de Cartagena');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (048, 'Levante UD FS', 2005, 'Valencia', 'España', 'Pabellon Municipal de Paterna');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (049, 'Quesos Hidalgo Manzanares FS', 2001, 'Manzanares', 'España', 'Pabellon Municipal Antonio Caba');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (050, 'Xota FS', 1978, 'Pamplona', 'España', 'Anaitasuna');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (051, 'Mallorca Palma Futsal', 1998, 'Palma(Baleares)', 'España', 'Palau Municipal d´Esports de Son Moix');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (052, 'Viña Albali Valdepeñas', 2002, 'Valdepeñas', 'España', 'Virgen de la Cabeza');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (053, 'Ribera Navarra FS', 2001, 'Tudela', 'España', 'Ciudad de Tudela');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (054, 'Real Betis Futsal', 1987, 'Sevilla', 'España', 'Pabellon de San Pablo');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (055, 'BeSoccer CD UMA Antequera', 1985, 'Antequera', 'España', 'Fernando Argüelles');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (056, 'Noia Portus Apostoli', 2008, 'Noia(A Coruña)', 'España', 'Pabellon Municipal Agustin Mouris');

insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (057, 'Barca', 1943, 'Barcelona', 'España', 'Palau Blaugrana');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (058, 'Rebi Balonmano Cuenca', 1989, 'Cuenca', 'España', 'Pabellón Municipal El Sargal');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (059, 'BM Granollers', 1944, 'Granollers', 'España', 'Palacio de Deportes de Granollers');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (060, 'Bidasoa Irun', 1962, 'Irún', 'Epaña', 'Polideportivo Artaleku');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (061, 'BM Logroño La Rioja', 2003, 'Logroño', 'España', 'Palacio de los Deportes');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (062, 'Abanca Ademar León', 1956, 'Léon', 'España', 'Palacio Municipal de los Deportes');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (063, 'Angel Ximénez-Avia Puente Genil', 1984, 'Puente Genil', 'Córdoba', 'Polideportivo Municipal Alcalde Miguel Salas');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (064, 'Bathco BM Torrelavega', 2002, 'Torrelavega', 'España', 'Pabellón Vicente Trueba');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (065, 'Bada Huesca', 1995, 'Huesca', 'España', 'Palacio Municipal de Deportes');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (066, 'TM Benidorm', 1994, 'Benidorm', 'España', 'Pabellón Liliana Fernández');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (067, 'Helvetia Anaitasuna', 1956, 'Pamplona', 'España', 'Pabellón Anaitasuna');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (068, 'Balonmano Sinfín', 2004, 'Santander', 'España', 'Pabellón de La Albericia');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (069, 'Frigoríficos del Morrazo', 1961, 'Cangas de Morrazo', 'España', 'Municipal O Gatañal');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (070, 'Recoletas Atlético Valladolid', 2014, 'Valladolid', 'España', 'Polideportivo Huerta del Rey');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (071, 'Balonmano Guadalajara', 2007, 'Guadalajara', 'España', 'Polideportivo Municipal David Santamaría');
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (072, 'Club Cisne BM', 1964, 'Pontevedra', 'España', 'Estadio da Xuventude');
=======
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("001", "Athletic Club", 1898, "Bilbao", "España", "San Mamés");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("002", "Atlético de Madrid", 1903,	"Madrid", "España", "Civitas Metropolitano");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("003", "UD Almeria", 1989, "Almeria", "España", "Power Horse Stadium");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("004", "FC Barcelona", 1899, "Barcelona", "España", "Spotify Camp Nou");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("005", "Cádiz CF", 1910, "Cádiz", "España", "Estadio Nuevo Mirandilla");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("006", "RC Celta de Vigo", 1923, "Vigo", "España", "Abanca-Balaídos");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("007", "Elche CF", 1922, "Elche", "España", "Martinez Valero");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("008", "RCD Espanyol", 1900, "Barcelona", "España", "RCDE Stadium");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("009", "Getafe CF", 1983, "Getafe", "España", "Coliseum Alfonso Pérez");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("010", "Girona FC", 1930, "Girona", "España", "Montilivi");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("011", "RCD Mallorca", 1916, "Mallorca", "España", "Son Moix");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("012", "CA Osasuna", 1919, "Pamplona", "España", "El Sadar");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("013", "Rayo Vallecano", 1924, "Vallecas", "España", "Estadio de Vallecas");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("014", "Real Betis Balonpié", 1907, "Sevilla", "España", "Benito Villamarín");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("015", "Real Madrid CF", 1902, "Madrid", "España", "Santiago Bernabéu");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("016", "Real Sociedad", 1909, "San Sebastián", "España", "Reale Arena");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("017", "Real Valladolid CF", 1928, "Valladolid", "España", "José Zorrilla");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("018", "Sevilla FC", 1890, "Sevilla", "España", "Ramón Sánchez-Pizjuán");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("019", "Valencia CF", 1919, "Valencia", "España", "Mestalla");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("020", "Villarreal CF", 1942, "Villarreal", "España", "Estadio de la Cerámica");

insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("021", "Atalanta", 1907,	"Bergamo", "Italia", "Gewiss Stadium");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("022", "Bologna", 1909,	"Bolonia", "Italia", "Renato Dall´Ara");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("023", "U.S. Cremonese", 1903, "Cremona", "Italia", "Stadio Giovanni Zini");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("024", "Empoli F.C.", 1920,	"Empoli", "Italia", "Estadio Carlo Castellani");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("025", "Fiorentina", 1926,	"Florencia", "Italia", "Artemio Franchi");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("026", "Hellas Verona F.C.", 1903,	"Verona", "Italia", "Marcantonio Bentegodi");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("027", "Internazionale", 1908,	"Milan", "Italia", "Giuseppe Meazza");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("028", "Juventus", 1897,	"Turin", "Italia", "Allianz Stadium");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("029", "Lazio", 1900, "Roma", "Italia", "Olímpico de Roma");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("030", "U.S. Lecce", 1908, "Lecce", "Italia", "Stadio Via del Mare");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("031", "A.C. Milan", 1899, "Milan", "Italia", "Calcistico San Siro");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("032", "A.C. Monza", 1912, "Monza", "Italia", "Estadio Brianteo");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("033", "S.S.C Napoli", 1926, "Napoles", "Italia", "Diego Armando Maradona");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("034", "A.S. Roma", 1927, "Roma", "Italia", "Olimpico de Roma");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("035", "U.S. Salernitana", 1919, "Salermo", "Italia", "Arechi");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("036", "U.C. Sampdoria", 1946, "Genova", "Italia", "Stadio Luigi Ferraris");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("037", "Sassuolo Calcio", 1920, "Reggio Emilia", "Italia", "MAPEI Stadium - Citta del Tricolore");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("038", "Spezia Calcio", 1906, "Via Nicolo Fieschi", "Italia", "Estadio Alberto Picco");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("039", "Torino F.C.", 1906, "Turin", "Italia", "Olimpico de Turin");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("040", "Udinese", 1896, "Udine", "Italia", "Stadio Friuli");

insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("041", "Barça", 1978, "Barcelona", "España", "Palau Blaugrana");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("042", "Cordoba Patrimonio de la Humanidad", 2013, "Cordoba", "España", "Palacio Municipal de Deportes Vista Alegre");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("043", "ElPozo Murcia Costa Calida", 1989, "Murcia", "España", "Palacio de Deportes de Murcia");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("044", "Industrias Santa Coloma", 1975, "Santa Coloma de Gramenet", "España", "Pabellon Nuevo");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("045", "Inter FS", 1977, "Torrejon de Ardoz", "España", "Jorge Garbajosa");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("046", "Jaen FS", 1980, "Jaen", "España", "Olivo Arena");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("047", "Jimbee Cartagena", 2013, "Cartagena", "España", "Palacio de los Deportes de Cartagena");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("048", "Levante UD FS", 2005, "Valencia", "España", "Pabellon Municipal de Paterna");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("049", "Quesos Hidalgo Manzanares FS", 2001, "Manzanares", "España", "Pabellon Municipal Antonio Caba");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("050", "Xota FS", 1978, "Pamplona", "España", "Anaitasuna");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("051", "Mallorca Palma Futsal", 1998, "Palma(Baleares)", "España", "Palau Municipal d´Esports de Son Moix");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("052", "Viña Albali Valdepeñas", 2002, "Valdepeñas", "España", "Virgen de la Cabeza");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("053", "Ribera Navarra FS", 2001, "Tudela", "España", "Ciudad de Tudela");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("054", "Real Betis Futsal", 1987, "Sevilla", "España", "Pabellon de San Pablo");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("055", "BeSoccer CD UMA Antequera", 1985, "Antequera", "España", "Fernando Argüelles");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("056", "Noia Portus Apostoli", 2008, "Noia(A Coruña)", "España", "Pabellon Municipal Agustin Mouris");

insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("057", "Barca", 1943, "Barcelona", "España", "Palau Blaugrana");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("058", "Rebi Balonmano Cuenca", 1989, "Cuenca", "España", "Pabellón Municipal El Sargal");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("059", "BM Granollers", 1944, "Granollers", "España", "Palacio de Deportes de Granollers");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("060", "Bidasoa Irun", 1962, "Irún", "Epaña", "Polideportivo Artaleku");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("061", "BM Logroño La Rioja", 2003, "Logroño", "España", "Palacio de los Deportes");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("062", "Abanca Ademar León", 1956, "Léon", "España", "Palacio Municipal de los Deportes");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("063", "Angel Ximénez-Avia Puente Genil", 1984, "Puente Genil", "Córdoba", "Polideportivo Municipal Alcalde Miguel Salas");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("064", "Bathco BM Torrelavega", 2002, "Torrelavega", "España", "Pabellón Vicente Trueba");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("065", "Bada Huesca", 1995, "Huesca", "España", "Palacio Municipal de Deportes");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("066", "TM Benidorm", 1994, "Benidorm", "España", "Pabellón Liliana Fernández");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("067", "Helvetia Anaitasuna", 1956, "Pamplona", "España", "Pabellón Anaitasuna");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("068", "Balonmano Sinfín", 2004, "Santander", "España", "Pabellón de La Albericia");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("069", "Frigoríficos del Morrazo", 1961, "Cangas de Morrazo", "España", "Municipal O Gatañal");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("070", "Recoletas Atlético Valladolid", 2014, "Valladolid", "España", "Polideportivo Huerta del Rey");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("071", "Balonmano Guadalajara", 2007, "Guadalajara", "España", "Polideportivo Municipal David Santamaría");
insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values ("072", "Club Cisne BM", 1964, "Pontevedra", "España", "Estadio da Xuventude");
>>>>>>> 55928fbc873144f20d6ce52a5dd1681eb17fba34



#Inserts de Equipos que pertenecen a una competicion de un deporte
<<<<<<< HEAD
insert into participar (cod_equipo, cod_comp, cod_dep) values (001, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (002, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (003, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (004, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (005, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (006, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (007, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (008, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (009, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (010, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (011, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (012, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (013, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (014, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (015, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (016, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (017, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (018, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (019, 002, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (020, 002, 001);

insert into participar (cod_equipo, cod_comp, cod_dep) values (021, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (022, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (023, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (024, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (025, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (026, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (027, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (028, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (029, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (030, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (031, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (032, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (033, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (034, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (035, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (036, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (037, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (038, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (039, 003, 001);
insert into participar (cod_equipo, cod_comp, cod_dep) values (040, 003, 001);


insert into participar (cod_equipo, cod_comp, cod_dep) values (041, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (042, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (043, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (044, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (045, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (046, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (047, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (048, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (049, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (050, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (051, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (052, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (053, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (054, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (055, 004, 002);
insert into participar (cod_equipo, cod_comp, cod_dep) values (056, 004, 002);

insert into participar (cod_equipo, cod_comp, cod_dep) values (057, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (058, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (059, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (060, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (061, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (062, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (063, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (064, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (065, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (066, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (067, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (068, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (069, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (070, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (071, 005, 003);
insert into participar (cod_equipo, cod_comp, cod_dep) values (072, 005, 003);
=======
insert into participar (cod_equipo, cod_comp, cod_dep) values ("001", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("002", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("003", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("004", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("005", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("006", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("007", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("008", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("009", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("010", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("011", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("012", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("013", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("014", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("015", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("016", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("017", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("018", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("019", "002", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("020", "002", "001");

insert into participar (cod_equipo, cod_comp, cod_dep) values ("021", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("022", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("023", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("024", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("025", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("026", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("027", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("028", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("029", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("030", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("031", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("032", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("033", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("034", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("035", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("036", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("037", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("038", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("039", "003", "001");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("040", "003", "001");


insert into participar (cod_equipo, cod_comp, cod_dep) values ("041", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("042", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("043", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("044", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("045", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("046", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("047", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("048", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("049", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("050", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("051", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("052", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("053", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("054", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("055", "004", "002");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("056", "004", "002");

insert into participar (cod_equipo, cod_comp, cod_dep) values ("057", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("058", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("059", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("060", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("061", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("062", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("063", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("064", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("065", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("066", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("067", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("068", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("069", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("070", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("071", "005", "003");
insert into participar (cod_equipo, cod_comp, cod_dep) values ("072", "005", "003");
>>>>>>> 55928fbc873144f20d6ce52a5dd1681eb17fba34




#Inserts de Jugadores
<<<<<<< HEAD
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00001,'Unai', 'Simón', 'Mendibil', '1997-06-11', 1, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00002,'Julen', 'Agirrezabala', 'Astúlez', '2000-12-26', 13, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00003,'Iñigo', 'Martínez', 'Berridi', '1991-05-17', 4, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00004,'Yeray', 'Álvarez', 'López', '1995-01-24', 5, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00005,'Dani', 'Vivian', 'Moreno', '1999-07-05', 3, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00006,'Yuri', 'Berchiche', 'Izeta', '1990-02-10', 17, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00007,'Mikel', 'Balenziaga', 'Oruesagasti', '1988-02-29', 24, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00008,'Iñigo', 'Lekue', 'Martínez', '1993-11-04', 15, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00009,'Ander', 'Capa', 'Rodríguez', '1992-02-08', 21, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00010,'Óscar', 'de Marcos', 'Arana ', '1989-04-14', 18, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00011,'Mikel', 'Vesga', 'Arruti', '1993-04-08', 6, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00012,'Unai', 'Vencedor', 'Paris', '2000-11-15', 16, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00013,'Oier', 'Zarraga', 'Egaña', '1999-01-04', 19, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00014,'Ander', 'Herrera', 'Agüera', '1989-08-14', 23, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00015,'Dani', 'García', 'Carrillo', '1990-05-24', 14, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00016,'Ohian', 'Sancet', 'Tirapu', '2000-04-25', 8, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00017,'Iker', 'Muniain', 'Goñi', '1992-12-19', 10, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00018,'Alex', 'Berenguer', 'Remiro', '1995-07-04', 7, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00019,'Nico', 'Williams', 'Arthuer', '2002-07-12', 11, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00020,'Iñaki', 'Williams', 'Arthuer', '1994-06-15', 9, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00021,'Raúl', 'Gárcia', 'Escudero', '1986-07-11', 22, 001);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00022,'Gorka', 'Guruzeta', 'Rodríguez', '1996-09-12', 12, 001);

insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00023,'Jan', 'Oblak', '', '1993-01-07', 13, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00024,'Ivo', 'Grbic', '', '1996-01-18', 1, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00025,'José María', 'Giménez', 'de Vargas', '1995-01-20', 2, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00026,'Mario', 'Hermoso', 'Canseco', '1995-06-18', 22, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00027,'Stefan', 'Savic', '', '1991-01-08', 15, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00028,'Reinildo', 'Mandava', '', '1994-01-21', 23, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00029,'Sergio', 'Reguilón', 'Rodríguez', '1996-12-16', 3, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00030,'Nahuel', 'Molina', 'Lucero', '1998-04-06', 16, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00031,'Matt', 'Doherty', '', '1992-01-16', 12, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00032,'Geoffrey', 'Kondogbia', '', '1993-02-15', 4, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00033,'Axel', 'Witsel', '', '1989-01-12', 20, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00034,'Rodrigo', 'de Paul', '', '1994-05-24', 5, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00035,'Marcos', 'LLorente', 'Moreno', '1995-01-30', 14, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00036,'Koke', 'Resurrección', 'Merodio', '1992-01-08', 6, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00037,'Saúl', 'Ñíguez', 'Esclápez', '1994-11-21', 17, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00038,'Pablo', 'Barrios', 'Rivas', '2003-06-15', 24, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00039,'Thomas', 'Lemar', '', '1995-11-12', 11, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00040,'Yannick', 'Carrasco', '', '1993-09-04', 21, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00041,'Ángel', 'Correa', '', '1995-03-09', 10, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00042,'Antoine', 'Griezmann', '', '1991-03-21', 8, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00043,'Álvaro', 'Morata', 'Martín', '1992-10-23', 19, 002);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00044,'Memphis', 'Depay', '', '1994-02-13', 9, 002);

insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00045,'Agustín', 'Marchesín', '', '1988-03-16', 1, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00046,'Iván', 'Villar', 'Martínez', '1997-07-09', 13, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00047,'Joseph', 'Aidoo', '', '1995-09-29', 15, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00048,'Unai', 'Núñez', 'Gestoso', '1997-01-30', 4, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00049,'Óscar', 'Mingueza', 'García', '1999-05-13', 3, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00050,'Carlos', 'Domínguez', 'Cáceres', '2001-02-11', 26, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00051,'Javi', 'Galán', 'Gil ', '1994-11-19', 17, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00052,'Hugo', 'Mallo', 'Novegil ', '1991-06-22', 2, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00053,'Kevin', 'Vázquez', 'Comesaña', '1993-03-23', 20, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00054,'Renato', 'Tapia', 'Cortijo ', '1995-07-28', 14, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00055,'Fran', 'Beltrán', 'Peinado ', '1999-02-03', 8, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00056,'Luca', 'de la Torre', '', '1998-05-23', 23, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00057,'Gabri', 'Veiga', 'Novas', '2002-05-27', 24, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00058,'Óscar', 'Rodríguez', 'Arnaiz', '1998-06-28', 5, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00059,'Williot', 'Swedberg', '', '2004-02-01', 19, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00060,'Franco', 'Cervi', '', '1994-05-26', 11, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00061,'Carles', 'Pérez', 'Sayol', '1998-02-16', 7, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00062,'Augusto', 'Solari', '', '1992-01-03', 21, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00063,'Jörgen', 'Strand', 'Larsen', '2000-02-06', 18, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00064,'Iago', 'Aspas', 'Juncal', '1987-08-01', 10, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00065,'Haris', 'Seferovic', '', '1992-02-22', 22, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00066,'Gonçalo', 'Paciência', '', '1994-08-01', 9, 006);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00067,'Miguel', 'Rodríguez', 'Vidal', '2003-04-29', 29, 006);

insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00068,'Sergio', 'Herrera', 'Pirón', '1993-06-05', 1, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00069,'Aitor', 'Fernández', 'Abarisketa', '1991-05-03', 25, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00070,'David', 'García', 'Zubiría', '1994-02-14', 5, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00071,'Unai', 'García', 'Lugea', '1992-02-03', 4, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00072,'Aridane', 'Hernández', 'Umpiérrez', '1989-03-23', 23, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00073,'Manu', 'Sánchez', 'de la Peña', '2000-08-22', 20, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00074,'Juan', 'Cruz', 'Armada ', '1992-07-28', 3, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00075,'Nacho', 'Vidal', 'Miralles', '1995-01-24', 2, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00076,'Rubén', 'Peña', 'Jiménez', '1991-07-18', 15, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00077,'Lucas', 'Torró', 'Marset', '1994-07-19', 6, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00078,'Jon', 'Moncayola', 'Tollar', '1998-05-13', 7, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00079,'Darko', 'Brasanac', '', '1992-02-12', 8, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00080,'Pablo', 'Ibáñez', 'Lumbreras', '1998-09-20', 19, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00081,'Aimar', 'Oroz', 'Huarte', '2001-11-27', 22, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00082,'Moi', 'Gómez', 'Bordonado', '1994-06-23', 16, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00083,'Abde', 'Ezzalzouli', '', '2001-12-17', 12, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00084,'Rubén', 'García', 'Santos', '1993-07-14', 14, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00085,'Kike', 'Barja', 'Afonso', '1997-04-01', 11, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00086,'Chimy', 'Ávila', '', '1994-02-06', 9, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00087,'Ante', 'Budimir', '', '1991-07-22', 17, 012);
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (00088,'Kike', 'García', 'Martínez', '1989-11-25', 18, 012);



#Privilegios y Roles
create role Administrador;

create user Grupo3 identified by "abcd*1234"
default role Administrador
=======
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00001","Unai", "Simón", "Mendibil", "1997-06-11", 1, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00002","Julen", "Agirrezabala", "Astúlez", "2000-12-26", 13, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00003","Iñigo", "Martínez", "Berridi", "1991-05-17", 4, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00004","Yeray", "Álvarez", "López", "1995-01-24", 5, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00005","Dani", "Vivian", "Moreno", "1999-07-05", 3, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00006","Yuri", "Berchiche", "Izeta", "1990-02-10", 17, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00007","Mikel", "Balenziaga", "Oruesagasti", "1988-02-29", 24, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00008","Iñigo", "Lekue", "Martínez", "1993-11-04", 15, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00009","Ander", "Capa", "Rodríguez", "1992-02-08", 21, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00010","Óscar", "de Marcos", "Arana ", "1989-04-14", 18, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00011","Mikel", "Vesga", "Arruti", "1993-04-08", 6, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00012","Unai", "Vencedor", "Paris", "2000-11-15", 16, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00013","Oier", "Zarraga", "Egaña", "1999-01-04", 19, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00014","Ander", "Herrera", "Agüera", "1989-08-14", 23, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00015","Dani", "García", "Carrillo", "1990-05-24", 14, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00016","Ohian", "Sancet", "Tirapu", "2000-04-25", 8, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00017","Iker", "Muniain", "Goñi", "1992-12-19", 10, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00018","Alex", "Berenguer", "Remiro", "1995-07-04", 7, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00019","Nico", "Williams", "Arthuer", "2002-07-12", 11, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00020","Iñaki", "Williams", "Arthuer", "1994-06-15", 9, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00021","Raúl", "Gárcia", "Escudero", "1986-07-11", 22, "001");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00022","Gorka", "Guruzeta", "Rodríguez", "1996-09-12", 12, "001");

insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00023","Jan", "Oblak", "", "1993-01-07", 13, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00024","Ivo", "Grbic", "", "1996-01-18", 1, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00025","José María", "Giménez", "de Vargas", "1995-01-20", 2, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00026","Mario", "Hermoso", "Canseco", "1995-06-18", 22, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00027","Stefan", "Savic", "", "1991-01-08", 15, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00028","Reinildo", "Mandava", "", "1994-01-21", 23, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00029","Sergio", "Reguilón", "Rodríguez", "1996-12-16", 3, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00030","Nahuel", "Molina", "Lucero", "1998-04-06", 16, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00031","Matt", "Doherty", "", "1992-01-16", 12, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00032","Geoffrey", "Kondogbia", "", "1993-02-15", 4, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00033","Axel", "Witsel", "", "1989-01-12", 20, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00034","Rodrigo", "de Paul", "", "1994-05-24", 5, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00035","Marcos", "LLorente", "Moreno", "1995-01-30", 14, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00036","Koke", "Resurrección", "Merodio", "1992-01-08", 6, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00037","Saúl", "Ñíguez", "Esclápez", "1994-11-21", 17, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00038","Pablo", "Barrios", "Rivas", "2003-06-15", 24, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00039","Thomas", "Lemar", "", "1995-11-12", 11, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00040","Yannick", "Carrasco", "", "1993-09-04", 21, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00041","Ángel", "Correa", "", "1995-03-09", 10, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00042","Antoine", "Griezmann", "", "1991-03-21", 8, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00043","Álvaro", "Morata", "Martín", "1992-10-23", 19, "002");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00044","Memphis", "Depay", "", "1994-02-13", 9, "002");

insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00045","Agustín", "Marchesín", "", "1988-03-16", 1, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00046","Iván", "Villar", "Martínez", "1997-07-09", 13, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00047","Joseph", "Aidoo", "", "1995-09-29", 15, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00048","Unai", "Núñez", "Gestoso", "1997-01-30", 4, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00049","Óscar", "Mingueza", "García", "1999-05-13", 3, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00050","Carlos", "Domínguez", "Cáceres", "2001-02-11", 26, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00051","Javi", "Galán", "Gil ", "1994-11-19", 17, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00052","Hugo", "Mallo", "Novegil ", "1991-06-22", 2, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00053","Kevin", "Vázquez", "Comesaña", "1993-03-23", 20, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00054","Renato", "Tapia", "Cortijo ", "1995-07-28", 14, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00055","Fran", "Beltrán", "Peinado ", "1999-02-03", 8, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00056","Luca", "de la Torre", "", "1998-05-23", 23, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00057","Gabri", "Veiga", "Novas", "2002-05-27", 24, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00058","Óscar", "Rodríguez", "Arnaiz", "1998-06-28", 5, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00059","Williot", "Swedberg", "", "2004-02-01", 19, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00060","Franco", "Cervi", "", "1994-05-26", 11, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00061","Carles", "Pérez", "Sayol", "1998-02-16", 7, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00062","Augusto", "Solari", "", "1992-01-03", 21, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00063","Jörgen", "Strand", "Larsen", "2000-02-06", 18, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00064","Iago", "Aspas", "Juncal", "1987-08-01", 10, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00065","Haris", "Seferovic", "", "1992-02-22", 22, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00066","Gonçalo", "Paciência", "", "1994-08-01", 9, "006");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00067","Miguel", "Rodríguez", "Vidal", "2003-04-29", 29, "006");

insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00068","Sergio", "Herrera", "Pirón", "1993-06-05", 1, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00069","Aitor", "Fernández", "Abarisketa", "1991-05-03", 25, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00070","David", "García", "Zubiría", "1994-02-14", 5, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00071","Unai", "García", "Lugea", "1992-02-03", 4, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00072","Aridane", "Hernández", "Umpiérrez", "1989-03-23", 23, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00073","Manu", "Sánchez", "de la Peña", "2000-08-22", 20, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00074","Juan", "Cruz", "Armada ", "1992-07-28", 3, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00075","Nacho", "Vidal", "Miralles", "1995-01-24", 2, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00076","Rubén", "Peña", "Jiménez", "1991-07-18", 15, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00077","Lucas", "Torró", "Marset", "1994-07-19", 6, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00078","Jon", "Moncayola", "Tollar", "1998-05-13", 7, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00079","Darko", "Brasanac", "", "1992-02-12", 8, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00080","Pablo", "Ibáñez", "Lumbreras", "1998-09-20", 19, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00081","Aimar", "Oroz", "Huarte", "2001-11-27", 22, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00082","Moi", "Gómez", "Bordonado", "1994-06-23", 16, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00083","Abde", "Ezzalzouli", "", "2001-12-17", 12, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00084","Rubén", "García", "Santos", "1993-07-14", 14, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00085","Kike", "Barja", "Afonso", "1997-04-01", 11, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00086","Chimy", "Ávila", "", "1994-02-06", 9, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00087","Ante", "Budimir", "", "1991-07-22", 17, "012");
insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values ("00088","Kike", "García", "Martínez", "1989-11-25", 18, "012");


#insert de partidos
insert into partido (Cod_Partido, Fecha_Partido, Resultado) values ("001","2023-05-13",null);
insert into partido (Cod_Partido, Fecha_Partido, Resultado) values ("002","2023-05-14",null);
insert into partido (Cod_Partido, Fecha_Partido, Resultado) values ("003","2023-06-23",null);

insert into jugar (Cod_Partido, Cod_Equipo) values ("001","001");
insert into jugar (Cod_Partido, Cod_Equipo) values ("001","005");
insert into jugar (Cod_Partido, Cod_Equipo) values ("002","027");
insert into jugar (Cod_Partido, Cod_Equipo) values ("002","029");
insert into jugar (Cod_Partido, Cod_Equipo) values ("003","033");
insert into jugar (Cod_Partido, Cod_Equipo) values ("003","021");


#insert de apuestas
insert into apuesta (Cod_Apuesta, Fecha_Apuesta, Cuota) values("001","2023-05-02",4);
insert into apuesta (Cod_Apuesta, Fecha_Apuesta, Cuota) values("002","2023-04-29",1.25);
insert into apuesta (Cod_Apuesta, Fecha_Apuesta, Cuota) values("003","2023-05-07",2.3);
insert into apuesta (Cod_Apuesta, Fecha_Apuesta, Cuota) values("004","2023-02-27",1.34);

#Privilegios y Roles
drop user if exists Grupo3;
create user Grupo3 identified by "abcd*1234"
>>>>>>> 55928fbc873144f20d6ce52a5dd1681eb17fba34
password expire never;

grant alter, insert, select, update
on apuestas.* 
<<<<<<< HEAD
to Grupo3;
=======
to Grupo3;

#Procedimientos y funciones
>>>>>>> 55928fbc873144f20d6ce52a5dd1681eb17fba34

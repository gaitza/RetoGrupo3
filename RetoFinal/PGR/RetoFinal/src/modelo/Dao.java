package modelo;

import java.util.List;

import javax.swing.JComboBox;

import clases.Apuesta;
import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
import clases.Equipo;
import clases.Jugador;
import clases.Jugar;
import clases.ListadoApuestas;
import clases.Participar;
import clases.Partido;
import clases.Usuario;

public interface Dao {
	
	public boolean registrar(Usuario usuario);
	
	public Cuenta iniciar(String usuario, String contrasenia);
	
	public String contraOlvidada(String email);

	public String buscarNombre(String usuario);
	
	public String buscarEmail(String email);
	
	public boolean esAdmin(String cod);
	
	public String codigoCuentas();
	
	public List<Equipo> listarEquiposPorDeporte(Deporte deportes, Competicion competiciones);
	
	public boolean crearApuesta(Partido partido, Jugar jugar, Apuesta apuesta);
	
	public List<ListadoApuestas> listarApuestas();

	public boolean insertarResultado(Partido partido, ListadoApuestas listadoApuestas, Cuenta cuenta);
	
	public boolean insertarJugador(Jugador jugador);
	
	public boolean insertarEquipo(Equipo equipo);
	
	public boolean insertarDeporte(Deporte deporte);
	
	public boolean insertarCompeticion(Competicion competicion);

	public List<Equipo> listadoEquipos();

	public List<Deporte> listadoDeportes();
	
	public List<Competicion> listadoCompeticiones();
	
	public boolean insertarParticipar(Participar participar, Deporte dep);
	
	public List<Jugador> listadoJugadores(Equipo equipo);

	public boolean bajaJugador(Jugador jug);

	public boolean bajaEquipo(Equipo equipoClase);

	public boolean bajaDeporte(Deporte depClase);

	public boolean bajaCompeticion(Competicion compClase);

	public boolean modificarEquipo(Equipo equipoClase);

	public boolean modificarDeporte(Deporte depClase);

	public boolean modificarCompeticion(Competicion compClase);

	public boolean modificarJugador(Jugador jug, Equipo codEquipo);

	public boolean darseDeBaja(Cuenta cuenta);

	public boolean editarPerfil(Cuenta cuenta, Usuario editarU);
	
	public List<Usuario> listarUsuarios();

	public boolean ingresarDinero(Cuenta cuenta, String text);

	public boolean retirarDinero(Cuenta cuenta, String text);


}

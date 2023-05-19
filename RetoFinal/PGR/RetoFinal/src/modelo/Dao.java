package modelo;

import java.util.List;

import javax.swing.JComboBox;

import clases.Apuesta;
import clases.ApuestasRealizadas;
import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
import clases.Equipo;
import clases.Jugador;
import clases.Jugar;
import clases.ListadoApuestas;
import clases.Participar;
import clases.Partido;
import clases.Realizar;
import clases.Usuario;

/**
 * @author Grupo3
 *
 */
public interface Dao {
	
	/**
	 * @param usuario
	 * @return
	 */
	public boolean registrar(Usuario usuario);
	
	/**
	 * @param usuario
	 * @param contrasenia
	 * @return
	 */
	public Cuenta iniciar(String usuario, String contrasenia);
	
	/**
	 * @param email
	 * @return
	 */
	public String contraOlvidada(String email);

	/**
	 * @param usuario
	 * @return
	 */
	public String buscarNombre(String usuario);
	
	/**
	 * @param email
	 * @return
	 */
	public String buscarEmail(String email);
	
	/**
	 * @param cod
	 * @return
	 */
	public boolean esAdmin(String cod);
	
	/**
	 * @return
	 */
	public String codigoCuentas();
	
	/**
	 * @param deportes
	 * @param competiciones
	 * @return
	 */
	public List<Equipo> listarEquiposPorDeporteYCompeticion(Deporte deportes, Competicion competiciones);
	
	/**
	 * @param partido
	 * @param jugar
	 * @param apuesta
	 * @return
	 */
	public boolean crearApuesta(Partido partido, Jugar jugar, Apuesta apuesta);
	
	public List<ListadoApuestas> listarApuestas();

	/**
	 * @param partido
	 * @param listadoApuestas
	 * @param cuenta
	 * @return
	 */
	public boolean insertarResultado(Partido partido, ListadoApuestas listadoApuestas, Cuenta cuenta);
	
	/**
	 * @param jugador
	 * @return
	 */
	public boolean insertarJugador(Jugador jugador);
	
	/**
	 * @param equipo
	 * @return
	 */
	public boolean insertarEquipo(Equipo equipo);
	
	/**
	 * @param deporte
	 * @return
	 */
	public boolean insertarDeporte(Deporte deporte);
	
	/**
	 * @param competicion
	 * @return
	 */
	public boolean insertarCompeticion(Competicion competicion);

	/**
	 * @return
	 */
	public List<Equipo> listadoEquipos();

	/**
	 * @return
	 */
	public List<Deporte> listadoDeportes();
	
	/**
	 * @return
	 */
	public List<Competicion> listadoCompeticiones();
	
	/**
	 * @param participar
	 * @param dep
	 * @return
	 */
	public boolean insertarParticipar(Participar participar, Deporte dep);
	
	/**
	 * @param equipo
	 * @return
	 */
	public List<Jugador> listadoJugadores(Equipo equipo);

	/**
	 * @param jug
	 * @return
	 */
	public boolean bajaJugador(Jugador jug);

	/**
	 * @param equipoClase
	 * @return
	 */
	public boolean bajaEquipo(Equipo equipoClase);

	/**
	 * @param depClase
	 * @return
	 */
	public boolean bajaDeporte(Deporte depClase);

	/**
	 * @param compClase
	 * @return
	 */
	public boolean bajaCompeticion(Competicion compClase);

	/**
	 * @param equipoClase
	 * @return
	 */
	public boolean modificarEquipo(Equipo equipoClase);

	/**
	 * @param depClase
	 * @return
	 */
	public boolean modificarDeporte(Deporte depClase);

	/**
	 * @param compClase
	 * @return
	 */
	public boolean modificarCompeticion(Competicion compClase);

	/**
	 * @param jug
	 * @param codEquipo
	 * @return
	 */
	public boolean modificarJugador(Jugador jug, Equipo codEquipo);

	/**
	 * @param cuenta
	 * @return
	 */
	public boolean darseDeBaja(Cuenta cuenta);

	/**
	 * @param cuenta
	 * @param editarU
	 * @return
	 */
	public boolean editarPerfil(Cuenta cuenta, Usuario editarU);
	
	/**
	 * @return
	 */
	public List<Usuario> listarUsuarios();

	/**
	 * @param cuenta
	 * @param text
	 * @return
	 */
	public boolean ingresarDinero(Cuenta cuenta, String text);

	/**
	 * @param cuenta
	 * @param text
	 * @return
	 */
	public boolean retirarDinero(Cuenta cuenta, String text);

	/**
	 * @param cuenta
	 * @return
	 */
	public List<ApuestasRealizadas> listarApuestasRealizadas(Cuenta cuenta);

	/**
	 * @param cuenta
	 * @param apostado
	 * @param codApuesta
	 * @return
	 */
	public boolean relizarApuesta(Cuenta cuenta, Realizar apostado, String codApuesta);
	
	/**
	 * @param deportes
	 * @return
	 */
	public List<ListadoApuestas> listarApuestasParaUsers(Deporte deportes);


}

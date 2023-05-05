package modelo;

import java.util.List;

import javax.swing.JComboBox;

import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
import clases.Equipo;
import clases.Jugador;
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
	
	public List<ListadoApuestas> listarApuestas();

	public boolean insertarResultado(Partido partido, ListadoApuestas listadoApuestas);
	
	public boolean insertarJugador(Jugador jugador);
	
	public boolean insertarEquipo(Equipo equipo);
	
	public boolean insertarDeporte(Deporte deporte);
	
	public boolean insertarCompeticion(Competicion competicion);

	public List<Equipo> listadoEquipos();

	public List<Deporte> listadoDeportes();
	
	public List<Competicion> listadoCompeticiones();
	
	public boolean insertarParticipar(Participar participar, Deporte dep);

}

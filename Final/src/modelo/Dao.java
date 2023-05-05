package modelo;

import java.util.List;

import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
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
	
	public List<Competicion> listarCompeticion();
	
	public List<Deporte> listarDeporte();
	
	public List<Partido> listarPartidos();
}

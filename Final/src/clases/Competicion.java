package clases;

import java.io.Serializable;

public class Competicion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//Declaramos las variables
	private String codCompeticion;
	private String nombre;
	private String deporte;
	
	
	//Creamos los constructores
	public Competicion(String codCompeticion, String nombre, String deporte) {
		super();
		this.codCompeticion = codCompeticion;
		this.nombre = nombre;
		this.deporte = deporte;
	}
	
	public Competicion() {
		super();

	}

	
	//creamos los getters y setters
	public String getCodCompeticion() {
		return codCompeticion;
	}

	public void setCodCompeticion(String codCompeticion) {
		this.codCompeticion = codCompeticion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	
	
}

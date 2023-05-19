package clases;

import java.io.Serializable;

/**
 * @author Grupo3
 *
 */
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
	/**
	 * @param codCompeticion
	 * @param nombre
	 * @param deporte
	 */
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
	/**
	 * @return
	 */
	public String getCodCompeticion() {
		return codCompeticion;
	}

	/**
	 * @param codCompeticion
	 */
	public void setCodCompeticion(String codCompeticion) {
		this.codCompeticion = codCompeticion;
	}

	/**
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return
	 */
	public String getDeporte() {
		return deporte;
	}

	/**
	 * @param deporte
	 */
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	
	
}

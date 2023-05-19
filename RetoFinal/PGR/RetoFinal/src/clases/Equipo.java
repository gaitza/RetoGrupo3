package clases;

import java.io.Serializable;

/**
 * @author Grupo3
 *
 */
public class Equipo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Declaramos las variables
	private String codEquipo;
	private String nombreEquipo;
	private int fechaFun;
	private String localidad;
	private String pais;
	private String estadio;
	private String deporte;
	
	
	/**
	 * @param codEquipo
	 * @param nombreEquipo
	 * @param fechaFun
	 * @param localidad
	 * @param pais
	 * @param estadio
	 * @param deporte
	 */
	//Creamos los constructores
	public Equipo(String codEquipo, String nombreEquipo, int fechaFun, String localidad, String pais, String estadio, String deporte) {
		super();
		this.codEquipo = codEquipo;
		this.nombreEquipo = nombreEquipo;
		this.fechaFun = fechaFun;
		this.localidad = localidad;
		this.pais = pais;
		this.estadio = estadio;
		this.deporte = deporte;
	}
	
	public Equipo() {
		super();
	}

	
	//Creamos los getters y los setters
	/**
	 * @return
	 */
	public String getCodEquipo() {
		return codEquipo;
	}

	/**
	 * @param codEquipo
	 */
	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

	/**
	 * @return
	 */
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	/**
	 * @param nombreEquipo
	 */
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	/**
	 * @return
	 */
	public int getFechaFun() {
		return fechaFun;
	}

	/**
	 * @param fechaFun
	 */
	public void setFechaFun(int fechaFun) {
		this.fechaFun = fechaFun;
	}

	/**
	 * @return
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return
	 */
	public String getEstadio() {
		return estadio;
	}

	/**
	 * @param estadio
	 */
	public void setEstadio(String estadio) {
		this.estadio = estadio;
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

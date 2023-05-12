package clases;

import java.io.Serializable;

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
	public String getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public int getFechaFun() {
		return fechaFun;
	}

	public void setFechaFun(int fechaFun) {
		this.fechaFun = fechaFun;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	
}

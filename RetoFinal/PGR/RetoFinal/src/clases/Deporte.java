package clases;

import java.io.Serializable;

public class Deporte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//Declaramos las variables
	private String codDep;
	private String nombreDep;
	
	
	//Creamos los constructores
	public Deporte(String codDep, String nombreDep) {
		super();
		this.codDep = codDep;
		this.nombreDep = nombreDep;
	}
	
	public Deporte() {
		super();
	}
	
	
	//Creamos los getters y los setters
	public String getCodDep() {
		return codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public String getNombreDep() {
		return nombreDep;
	}

	public void setNombreDep(String nombreDep) {
		this.nombreDep = nombreDep;
	}

	
}

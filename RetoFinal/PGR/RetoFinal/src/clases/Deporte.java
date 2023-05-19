package clases;

import java.io.Serializable;

/**
 * @author Grupo3
 *
 */
public class Deporte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//Declaramos las variables
	private String codDep;
	private String nombreDep;
	
	
	//Creamos los constructores
	/**
	 * @param codDep
	 * @param nombreDep
	 */
	public Deporte(String codDep, String nombreDep) {
		super();
		this.codDep = codDep;
		this.nombreDep = nombreDep;
	}
	
	public Deporte() {
		super();
	}
	
	
	//Creamos los getters y los setters
	/**
	 * @return
	 */
	public String getCodDep() {
		return codDep;
	}

	/**
	 * @param codDep
	 */
	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	/**
	 * @return
	 */
	public String getNombreDep() {
		return nombreDep;
	}

	/**
	 * @param nombreDep
	 */
	public void setNombreDep(String nombreDep) {
		this.nombreDep = nombreDep;
	}

	
}

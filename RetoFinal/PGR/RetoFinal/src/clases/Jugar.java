package clases;

import java.io.Serializable;

public class Jugar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Declaramos las variables
	private String codPartido;
	private String codELocal;
	private String codEVisit;
	
	//Creamos los constructores
	public Jugar(String codPartido, String codELocal, String codEVisit) {
		super();
		this.codPartido = codPartido;
		this.codELocal = codELocal;
		this.codEVisit = codEVisit;
	}
	
	public Jugar() {
		super();
	}

	
	//Creamos los getters y setters
	public String getCodPartido() {
		return codPartido;
	}

	public void setCodPartido(String codPartido) {
		this.codPartido = codPartido;
	}

	public String getCodELocal() {
		return codELocal;
	}

	public void setCodELocal(String codELocal) {
		this.codELocal = codELocal;
	}

	public String getCodEVisit() {
		return codEVisit;
	}

	public void setCodEVisit(String codEVisit) {
		this.codEVisit = codEVisit;
	}
	
	
	

}

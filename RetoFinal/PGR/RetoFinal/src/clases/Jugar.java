package clases;

import java.io.Serializable;

/**
 * @author Grupo3
 *
 */
public class Jugar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Declaramos las variables
	private String codPartido;
	private String codELocal;
	private String codEVisit;
	
	/**
	 * @param codPartido
	 * @param codELocal
	 * @param codEVisit
	 */
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
	/**
	 * @return
	 */
	public String getCodPartido() {
		return codPartido;
	}

	/**
	 * @param codPartido
	 */
	public void setCodPartido(String codPartido) {
		this.codPartido = codPartido;
	}

	/**
	 * @return
	 */
	public String getCodELocal() {
		return codELocal;
	}

	/**
	 * @param codELocal
	 */
	public void setCodELocal(String codELocal) {
		this.codELocal = codELocal;
	}

	/**
	 * @return
	 */
	public String getCodEVisit() {
		return codEVisit;
	}

	/**
	 * @param codEVisit
	 */
	public void setCodEVisit(String codEVisit) {
		this.codEVisit = codEVisit;
	}
	
	
	

}

package clases;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Grupo3
 *
 */
public class Partido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//Declaramos las variables
	private String codPartido;
	private LocalDate fechaPartido;
	private String resultado;
	
	
	/**
	 * @param codPartido
	 * @param fechaPartido
	 * @param resultado
	 */
	//Creamos los constructores
	public Partido(String codPartido, LocalDate fechaPartido, String resultado) {
		super();
		this.codPartido = codPartido;
		this.fechaPartido = fechaPartido;
		this.resultado = resultado;
	}
	
	public Partido() {
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
	public LocalDate getFechaPartido() {
		return fechaPartido;
	}

	/**
	 * @param fechaPartido
	 */
	public void setFechaPartido(LocalDate fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	/**
	 * @return
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	

}

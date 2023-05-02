package clases;

import java.io.Serializable;
import java.time.LocalDate;

public class Partido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//Declaramos las variables
	private String codPartido;
	private LocalDate fechaPartido;
	private String resultado;
	
	
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
	public String getCodPartido() {
		return codPartido;
	}

	public void setCodPartido(String codPartido) {
		this.codPartido = codPartido;
	}

	public LocalDate getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(LocalDate fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	

}

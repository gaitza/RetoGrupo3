package clases;

import java.io.Serializable;
import java.time.LocalDate;

public class Apuesta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Declaramos las variables
	private String codApuesta;
	private LocalDate fechaApuesta;
	private float cuota;
	
	//Creamos los constructores
	public Apuesta(String codApuesta, LocalDate fechaApuesta, float cuota) {
		super();
		this.codApuesta = codApuesta;
		this.fechaApuesta = fechaApuesta;
		this.cuota = cuota;
	}
	
	public Apuesta() {
		super();
	}

	
	//Creamos los getters y setters
	public String getCodApuesta() {
		return codApuesta;
	}

	public void setCodApuesta(String codApuesta) {
		this.codApuesta = codApuesta;
	}

	public LocalDate getFechaApuesta() {
		return fechaApuesta;
	}

	public void setFechaApuesta(LocalDate fechaApuesta) {
		this.fechaApuesta = fechaApuesta;
	}

	public float getCuota() {
		return cuota;
	}

	public void setCuota(float cuota) {
		this.cuota = cuota;
	}
	
}

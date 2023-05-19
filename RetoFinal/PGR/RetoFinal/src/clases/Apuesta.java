package clases;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Grupo3
 *
 */
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
	/**
	 * @param codApuesta
	 * @param fechaApuesta
	 * @param cuota
	 */
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
	/**
	 * @return
	 */
	public String getCodApuesta() {
		return codApuesta;
	}

	/**
	 * @param codApuesta
	 */
	public void setCodApuesta(String codApuesta) {
		this.codApuesta = codApuesta;
	}

	/**
	 * @return
	 */
	public LocalDate getFechaApuesta() {
		return fechaApuesta;
	}

	/**
	 * @param fechaApuesta
	 */
	public void setFechaApuesta(LocalDate fechaApuesta) {
		this.fechaApuesta = fechaApuesta;
	}

	/**
	 * @return
	 */
	public float getCuota() {
		return cuota;
	}

	/**
	 * @param cuota
	 */
	public void setCuota(float cuota) {
		this.cuota = cuota;
	}
	
}

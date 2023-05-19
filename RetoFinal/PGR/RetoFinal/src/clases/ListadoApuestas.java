package clases;

import java.time.LocalDate;

/**
 * @author Grupo3
 *
 */
public class ListadoApuestas {
	
	private String eLocal;
	private String eVisitante;
	private LocalDate fPartido;
	private LocalDate fApuesta;
	private float cuota;
	private String codPartido;
	private String codApuesta;
	
	/**
	 * @param eLocal
	 * @param eVisitante
	 * @param fPartido
	 * @param fApuesta
	 * @param cuota
	 * @param codPartido
	 * @param codApuesta
	 */
	//Constructores
	public ListadoApuestas(String eLocal, String eVisitante, LocalDate fPartido, LocalDate fApuesta, float cuota, String codPartido, String codApuesta) {
		super();
		this.eLocal = eLocal;
		this.eVisitante = eVisitante;
		this.fPartido = fPartido;
		this.fApuesta = fApuesta;
		this.cuota = cuota;
		this.codPartido=codPartido;
		this.codApuesta = codApuesta;
	}
	
	public ListadoApuestas() {
		
	}
	
	//Getters y Setters
	/**
	 * @return
	 */
	public String geteLocal() {
		return eLocal;
	}

	/**
	 * @param eLocal
	 */
	public void seteLocal(String eLocal) {
		this.eLocal = eLocal;
	}

	/**
	 * @return
	 */
	public String geteVisitante() {
		return eVisitante;
	}

	/**
	 * @param eVisitante
	 */
	public void seteVisitante(String eVisitante) {
		this.eVisitante = eVisitante;
	}

	/**
	 * @return
	 */
	public LocalDate getfPartido() {
		return fPartido;
	}

	/**
	 * @param fPartido
	 */
	public void setfPartido(LocalDate fPartido) {
		this.fPartido = fPartido;
	}

	/**
	 * @return
	 */
	public LocalDate getfApuesta() {
		return fApuesta;
	}

	/**
	 * @param fApuesta
	 */
	public void setfApuesta(LocalDate fApuesta) {
		this.fApuesta = fApuesta;
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
	public String getCodApuesta() {
		return codApuesta;
	}

	/**
	 * @param codApuesta
	 */
	public void setCodApuesta(String codApuesta) {
		this.codApuesta = codApuesta;
	}
	
	

}

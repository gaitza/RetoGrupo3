package clases;

import java.time.LocalDate;

/**
 * @author Grupo3
 *
 */
public class ApuestasRealizadas {
	
	private String eLocal;
	private String eVisitante;
	private LocalDate fPartido;
	private LocalDate fApuesta;
	private float cuota;
	private String codPartido;
	private String codApuesta;
	private String resultado;
	private String opcionApost;
	private int dineroApost;
	
	//Constructores
	/**
	 * @param eLocal
	 * @param eVisitante
	 * @param fPartido
	 * @param fApuesta
	 * @param cuota
	 * @param codPartido
	 * @param codApuesta
	 * @param resultado
	 * @param opcionApost
	 * @param dineroApost
	 */
	public ApuestasRealizadas(String eLocal, String eVisitante, LocalDate fPartido, LocalDate fApuesta, float cuota, String codPartido, String codApuesta, String resultado, String opcionApost, int dineroApost) {
		super();
		this.eLocal = eLocal;
		this.eVisitante = eVisitante;
		this.fPartido = fPartido;
		this.fApuesta = fApuesta;
		this.cuota = cuota;
		this.codPartido=codPartido;
		this.codApuesta = codApuesta;
		this.resultado = resultado;
		this.opcionApost = opcionApost;
		this.dineroApost = dineroApost;
	}
	
	public ApuestasRealizadas() {
		
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

	/**
	 * @return
	 */
	public String getOpcionApost() {
		return opcionApost;
	}

	/**
	 * @param opcionApost
	 */
	public void setOpcionApost(String opcionApost) {
		this.opcionApost = opcionApost;
	}

	/**
	 * @return
	 */
	public int getDineroApost() {
		return dineroApost;
	}

	/**
	 * @param dineroApost
	 */
	public void setDineroApost(int dineroApost) {
		this.dineroApost = dineroApost;
	}
	
}

package clases;

import java.time.LocalDate;

public class ListadoApuestas {
	
	private String eLocal;
	private String eVisitante;
	private LocalDate fPartido;
	private LocalDate fApuesta;
	private float cuota;
	private String codPartido;
	private String codApuesta;
	
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
	public String geteLocal() {
		return eLocal;
	}

	public void seteLocal(String eLocal) {
		this.eLocal = eLocal;
	}

	public String geteVisitante() {
		return eVisitante;
	}

	public void seteVisitante(String eVisitante) {
		this.eVisitante = eVisitante;
	}

	public LocalDate getfPartido() {
		return fPartido;
	}

	public void setfPartido(LocalDate fPartido) {
		this.fPartido = fPartido;
	}

	public LocalDate getfApuesta() {
		return fApuesta;
	}

	public void setfApuesta(LocalDate fApuesta) {
		this.fApuesta = fApuesta;
	}

	public float getCuota() {
		return cuota;
	}

	public void setCuota(float cuota) {
		this.cuota = cuota;
	}

	public String getCodPartido() {
		return codPartido;
	}

	public void setCodPartido(String codPartido) {
		this.codPartido = codPartido;
	}

	public String getCodApuesta() {
		return codApuesta;
	}

	public void setCodApuesta(String codApuesta) {
		this.codApuesta = codApuesta;
	}
	
	

}

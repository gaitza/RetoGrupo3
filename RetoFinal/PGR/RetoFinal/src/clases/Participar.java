package clases;

public class Participar {
	
	//Variables
	private String codEquipo;
	private String codDeporte;
	private String codCompeticion;
	private String deporteC;
	private String deporteE;
	
	//Constructores
	public Participar(String codEquipo, String codDeporte, String codCompeticion, String deporteC, String deporteE) {
		super();
		this.codEquipo = codEquipo;
		this.codDeporte = codDeporte;
		this.codCompeticion = codCompeticion;
		this.deporteC = deporteC;
		this.deporteE = deporteE;
	}
	
	public Participar() {
		super();
	}

	//Getters y Setters
	public String getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getCodDeporte() {
		return codDeporte;
	}

	public void setCodDeporte(String codDeporte) {
		this.codDeporte = codDeporte;
	}

	public String getCodCompeticion() {
		return codCompeticion;
	}

	public void setCodCompeticion(String codCompeticion) {
		this.codCompeticion = codCompeticion;
	}

	public String getDeporteC() {
		return deporteC;
	}

	public void setDeporteC(String deporteC) {
		this.deporteC = deporteC;
	}

	public String getDeporteE() {
		return deporteE;
	}

	public void setDeporteE(String deporteE) {
		this.deporteE = deporteE;
	}
	
	
}

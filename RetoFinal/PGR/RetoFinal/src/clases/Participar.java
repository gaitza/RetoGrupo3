package clases;

/**
 * @author Grupo3
 *
 */
public class Participar {
	
	//Variables
	private String codEquipo;
	private String codDeporte;
	private String codCompeticion;
	private String deporteC;
	private String deporteE;
	
	//Constructores
	/**
	 * @param codEquipo
	 * @param codDeporte
	 * @param codCompeticion
	 * @param deporteC
	 * @param deporteE
	 */
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
	/**
	 * @return
	 */
	public String getCodEquipo() {
		return codEquipo;
	}

	/**
	 * @param codEquipo
	 */
	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

	/**
	 * @return
	 */
	public String getCodDeporte() {
		return codDeporte;
	}

	/**
	 * @param codDeporte
	 */
	public void setCodDeporte(String codDeporte) {
		this.codDeporte = codDeporte;
	}

	/**
	 * @return
	 */
	public String getCodCompeticion() {
		return codCompeticion;
	}

	/**
	 * @param codCompeticion
	 */
	public void setCodCompeticion(String codCompeticion) {
		this.codCompeticion = codCompeticion;
	}

	/**
	 * @return
	 */
	public String getDeporteC() {
		return deporteC;
	}

	/**
	 * @param deporteC
	 */
	public void setDeporteC(String deporteC) {
		this.deporteC = deporteC;
	}

	/**
	 * @return
	 */
	public String getDeporteE() {
		return deporteE;
	}

	/**
	 * @param deporteE
	 */
	public void setDeporteE(String deporteE) {
		this.deporteE = deporteE;
	}
	
	
}

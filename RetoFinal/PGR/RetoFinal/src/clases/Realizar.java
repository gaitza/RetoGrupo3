package clases;

/**
 * @author Grupo3
 *
 */
public class Realizar {

	private String codCuenta;
	private String codApuesta;
	private int dineroApost;
	private String opcionApost;
	
	
	/**
	 * @param codCuenta
	 * @param codApuesta
	 * @param dineroApost
	 * @param opcionApost
	 */
	//Constructores
	public Realizar(String codCuenta, String codApuesta, int dineroApost, String opcionApost) {
		super();
		this.codCuenta = codCuenta;
		this.codApuesta = codApuesta;
		this.dineroApost = dineroApost;
		this.opcionApost = opcionApost;
	}
	
	public Realizar() {
		super();
	}

	//Getters y Setters
	/**
	 * @return
	 */
	public String getCodCuenta() {
		return codCuenta;
	}

	/**
	 * @param codCuenta
	 */
	public void setCodCuenta(String codCuenta) {
		this.codCuenta = codCuenta;
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
	public int getDineroApost() {
		return dineroApost;
	}

	/**
	 * @param dineroApost
	 */
	public void setDineroApost(int dineroApost) {
		this.dineroApost = dineroApost;
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
	
	
	
}

package clases;

import java.io.Serializable;

/**
 * @author Grupo3
 *
 */
public class Cuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Declaramos las variables
	private String codCuenta;
	private String nombreCuenta;
	private String email;
	private String Contrasenia;
	
	//Creamos los constructores
	/**
	 * @param codCuenta
	 * @param nombreCuenta
	 * @param email
	 * @param contraseña
	 */
	public Cuenta(String codCuenta, String nombreCuenta, String email, String contrasenia) {
		super();
		this.codCuenta = codCuenta;
		this.nombreCuenta = nombreCuenta;
		this.email = email;
		Contrasenia = contrasenia;
	}
	
	/**
	 * 
	 */
	public Cuenta() {
		super();
	}
	
	

	//Creamos los getters y setters
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
	public String getNombreCuenta() {
		return nombreCuenta;
	}

	/**
	 * @param nombreCuenta
	 */
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public String getContrasenia() {
		return Contrasenia;
	}

	/**
	 * @param contraseña
	 */
	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}
	
}

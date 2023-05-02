package clases;

import java.io.Serializable;

public class Cuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Declaramos las variables
	private String codCuenta;
	private String nombreCuenta;
	private String email;
	private String Contraseña;
	
	//Creamos los constructores
	public Cuenta(String codCuenta, String nombreCuenta, String email, String contraseña) {
		super();
		this.codCuenta = codCuenta;
		this.nombreCuenta = nombreCuenta;
		this.email = email;
		Contraseña = contraseña;
	}
	
	public Cuenta() {
		super();
	}
	
	

	//Creamos los getters y setters
	public String getCodCuenta() {
		return codCuenta;
	}

	public void setCodCuenta(String codCuenta) {
		this.codCuenta = codCuenta;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	
}

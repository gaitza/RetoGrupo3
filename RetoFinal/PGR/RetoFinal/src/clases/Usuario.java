package clases;

import java.time.LocalDate;

/**
 * @author Grupo3
 *
 */
public class Usuario extends Cuenta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Declaramos las variables
	/*pin y cvv son string para poder introducir 0 como primer numero*/
	private long nTarjeta;
	private LocalDate FechaCaducidad;
	private String cvv;
	private String pin;
	private float saldo;
	
	/**
	 * @param codCuenta
	 * @param nombreCuenta
	 * @param email
	 * @param contraseña
	 * @param nTarjeta
	 * @param fechaCaducidad
	 * @param cvv
	 * @param pin
	 * @param saldo
	 */
	//Creamos los constructores
	public Usuario(String codCuenta, String nombreCuenta, String email, String Contrasenia, int nTarjeta,
			LocalDate fechaCaducidad, String cvv, String pin, float saldo) {
		super(codCuenta, nombreCuenta, email, Contrasenia);
		this.nTarjeta = nTarjeta;
		FechaCaducidad = fechaCaducidad;
		this.cvv = cvv;
		this.pin = pin;
		this.saldo = saldo;
	}
	
	public Usuario() {
		super();
	}

	
	//Creamos los getters y setters
	/**
	 * @return
	 */
	public long getnTarjeta() {
		return nTarjeta;
	}

	/**
	 * @param nTarjeta
	 */
	public void setnTarjeta(long nTarjeta) {
		this.nTarjeta = nTarjeta;
	}

	/**
	 * @return
	 */
	public LocalDate getFechaCaducidad() {
		return FechaCaducidad;
	}

	/**
	 * @param fechaCaducidad
	 */
	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		FechaCaducidad = fechaCaducidad;
	}

	/**
	 * @return
	 */
	public String getCvv() {
		return cvv;
	}

	/**
	 * @param cvv
	 */
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	/**
	 * @return
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * @param pin
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}

	/**
	 * @return
	 */
	public float getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo
	 */
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
}

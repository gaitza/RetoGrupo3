package clases;

import java.time.LocalDate;

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
	
	//Creamos los constructores
	public Usuario(String codCuenta, String nombreCuenta, String email, String contraseña, int nTarjeta,
			LocalDate fechaCaducidad, String cvv, String pin, float saldo) {
		super(codCuenta, nombreCuenta, email, contraseña);
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
	public long getnTarjeta() {
		return nTarjeta;
	}

	public void setnTarjeta(long nTarjeta) {
		this.nTarjeta = nTarjeta;
	}

	public LocalDate getFechaCaducidad() {
		return FechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		FechaCaducidad = fechaCaducidad;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
}

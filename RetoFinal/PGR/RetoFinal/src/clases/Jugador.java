package clases;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Grupo3
 *
 */
public class Jugador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Declaramos las variables
	private String id;
	private String nombreJ;
	private String apellido1;
	private String apellido2;
	private LocalDate fechaNac;
	private int dorsal;
	private String codEquipo;
	
	
	/**
	 * @param id
	 * @param nombreJ
	 * @param apellido1
	 * @param apellido2
	 * @param fechaNac
	 * @param dorsal
	 * @param codEquipo
	 */
	//Creamos los constructores
	public Jugador(String id, String nombreJ, String apellido1, String apellido2, LocalDate fechaNac, int dorsal,
			String codEquipo) {
		super();
		this.id = id;
		this.nombreJ = nombreJ;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNac = fechaNac;
		this.dorsal = dorsal;
		this.codEquipo = codEquipo;
	}
	
	public Jugador() {
		super();
	}

	
	
	//Creamos los getters y setters
	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getNombreJ() {
		return nombreJ;
	}

	/**
	 * @param nombreJ
	 */
	public void setNombreJ(String nombreJ) {
		this.nombreJ = nombreJ;
	}

	/**
	 * @return
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * @return
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * @param apellido2
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * @return
	 */
	public LocalDate getFechaNac() {
		return fechaNac;
	}

	/**
	 * @param fechaNac
	 */
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	/**
	 * @return
	 */
	public int getDorsal() {
		return dorsal;
	}

	/**
	 * @param dorsal
	 */
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

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
	
	

}

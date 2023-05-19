package controlador;

import modelo.Dao;
import modelo.DaoImplementacion;
import vistas.VElegir;

/**
 * @author Grupo3
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Clase principal desde donde se ejecuta toda el programa.
		Dao dao = new DaoImplementacion();
		VElegir vent = new VElegir(dao);
		vent.setVisible(true);
	}

}

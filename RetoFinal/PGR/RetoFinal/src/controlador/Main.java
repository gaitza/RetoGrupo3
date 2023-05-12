package controlador;

import modelo.Dao;
import modelo.DaoImplementacion;
import vistas.VElegir;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao dao = new DaoImplementacion();
		VElegir vent = new VElegir(dao);
		vent.setVisible(true);
	}

}

package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
import clases.Equipo;
import clases.ListadoApuestas;
import clases.Participar;
import modelo.Dao;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

/**
 * @author Grupo3
 *
 */
public class VRelacionar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private JButton btnVolver;
	private JButton btnContinuar;
	private JComboBox equipo;
	private JComboBox deporte;
	private JComboBox competicion;
	private List<Deporte> listadoDeporte;
	private List<Competicion> listadoCompeticiones;
	private List<Equipo> listadoEquipos;
	private Cuenta cuenta;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param cuenta
	 */
	public VRelacionar(VElegir vElegir, boolean b, Dao dao, Cuenta cuenta) {
		super(vElegir);
		setTitle("Retabet.es");
		this.setModal(b);
		this.dao = dao;
		this.vElegir = vElegir;
		this.cuenta = cuenta;

		setTitle("Retabet.es");
		String ruta = System.getProperty("user.dir");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ruta + "\\src\\fotos\\Logo.jpg"));

		setBounds(100, 100, 495, 595);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 479, 88);
		contentPanel.add(panel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ruta+"\\src\\fotos\\Cabecera.jpg"));
		lblNewLabel.setBounds(156, 0, 220, 88);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 498, 479, 58);
		contentPanel.add(panel_1);

		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(173, 255, 47));
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVolver.setFocusable(false);
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.DARK_GRAY);
		btnVolver.setBounds(50, 11, 107, 36);
		btnVolver.addActionListener(this);
		panel_1.add(btnVolver);

		btnContinuar = new JButton("Confirmar");
		btnContinuar.setForeground(new Color(173, 255, 47));
		btnContinuar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnContinuar.setFocusable(false);
		btnContinuar.setBorder(null);
		btnContinuar.setBackground(Color.DARK_GRAY);
		btnContinuar.setBounds(322, 11, 107, 36);
		btnContinuar.addActionListener(this);
		panel_1.add(btnContinuar);

		equipo = new JComboBox();
		equipo.setBounds(162, 153, 307, 38);
		contentPanel.add(equipo);

		deporte = new JComboBox();
		deporte.setBounds(162, 256, 307, 38);
		contentPanel.add(deporte);

		competicion = new JComboBox();
		competicion.setBounds(162, 345, 307, 38);
		contentPanel.add(competicion);

		JLabel lblEquipos = new JLabel("Equipos:\r\n");
		lblEquipos.setForeground(new Color(173, 255, 47));
		lblEquipos.setFont(new Font("Arial", Font.BOLD, 16));
		lblEquipos.setBounds(20, 150, 128, 40);
		contentPanel.add(lblEquipos);

		JLabel lblDeportes = new JLabel("Deportes:");
		lblDeportes.setForeground(new Color(173, 255, 47));
		lblDeportes.setFont(new Font("Arial", Font.BOLD, 16));
		lblDeportes.setBounds(20, 253, 128, 40);
		contentPanel.add(lblDeportes);

		JLabel lblCompeticiones = new JLabel("Competiciones:");
		lblCompeticiones.setForeground(new Color(173, 255, 47));
		lblCompeticiones.setFont(new Font("Arial", Font.BOLD, 16));
		lblCompeticiones.setBounds(20, 342, 128, 40);
		contentPanel.add(lblCompeticiones);

		cargarEquipos();

		cargarDeportes();

		cargarCompeticiones();

		listadoDeporte = dao.listadoDeportes();
		listadoEquipos = dao.listadoEquipos();
		listadoCompeticiones = dao.listadoCompeticiones();
	}

	private void cargarCompeticiones() {
		// TODO Auto-generated method stub
		List<Competicion> competiciones = dao.listadoCompeticiones();
		for (Competicion comp : competiciones) {
			competicion.addItem(comp.getCodCompeticion() + "-" + comp.getNombre()+"("+comp.getDeporte()+")");
		}
		competicion.setSelectedIndex(-1);
	}

	private void cargarDeportes() {
		// TODO Auto-generated method stub
		List<Deporte> deportes = dao.listadoDeportes();
		for (Deporte dep : deportes) {
			deporte.addItem(dep.getCodDep() + "-" + dep.getNombreDep());
		}
		deporte.setSelectedIndex(-1);
	}

	private void cargarEquipos() {
		// TODO Auto-generated method stub
		List<Equipo> equipos = dao.listadoEquipos();
		for (Equipo equip : equipos) {
			equipo.addItem(equip.getCodEquipo() + "-" + equip.getNombreEquipo()+"("+equip.getDeporte()+")");
		}
		equipo.setSelectedIndex(-1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnContinuar)) {
			confirmar();
		}

		if (e.getSource().equals(btnVolver)) {
			volver();
		}
	}

	private void confirmar() {
		// TODO Auto-generated method stub
		Participar participar;
		Deporte dep;
		Competicion comp;
		List<Competicion> competiciones;

		if (equipo.getSelectedIndex() > -1 && deporte.getSelectedIndex() > -1 && competicion.getSelectedIndex() > -1) {
			participar = new Participar();
			String cadenaE = (String) equipo.getSelectedItem();
			int posE = cadenaE.indexOf("-");
			String codEquipo = cadenaE.substring(0, posE);
			participar.setCodEquipo(codEquipo);

			String cadenaD = (String) deporte.getSelectedItem();
			int posD = cadenaD.indexOf("-");
			String codDeporte = cadenaD.substring(0, posD);
			participar.setCodDeporte(codDeporte);

			String cadenaC = (String) competicion.getSelectedItem();
			int posC = cadenaC.indexOf("-");
			String codCompeticion = cadenaC.substring(0, posC);
			participar.setCodCompeticion(codCompeticion);
			
			participar.setDeporteE(listadoEquipos.get(equipo.getSelectedIndex()).getDeporte());
			participar.setDeporteC(listadoCompeticiones.get(competicion.getSelectedIndex()).getDeporte());
			
			dep = new Deporte();
			String cadenaDep = (String) deporte.getSelectedItem();
			int posDep = cadenaDep.indexOf("-");
			String codDep = cadenaDep.substring(0, posDep);
			dep.setCodDep(codDep);
			
			String cadenaDep2 = (String) deporte.getSelectedItem();
			int posDep2 = cadenaDep2.indexOf("-");
			String nombreDep = cadenaDep2.substring(posDep2+1);
			dep.setNombreDep(nombreDep);

			if (dao.insertarParticipar(participar, dep)) {
				JOptionPane.showMessageDialog(this, "RELACION INTRODUCIDA CORRECTAMENTE.");
				equipo.setSelectedIndex(-1);
				deporte.setSelectedIndex(-1);
				competicion.setSelectedIndex(-1);
			} else {
				JOptionPane.showMessageDialog(this,
						"TODAS LAS OPCIONES DEBEN SER DEL MISMO DEPORTE.");
			}
		} else {
			JOptionPane.showMessageDialog(this, "DEBES RELLENAR TODAS LAS OPCIONES.");
		}
	}

	//Metodo para volver a la anterior Ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
		VInsertarBDA vent = new VInsertarBDA(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}
}

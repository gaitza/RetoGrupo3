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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
import clases.Equipo;
import clases.Partido;
import modelo.Dao;

/**
 * @author Grupo3
 *
 */
public class VDeporteCompeticionDeApuesta extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JButton btnContinuar;
	private JComboBox deportesCombo;
	private JComboBox competicionesCombo;
	private Dao dao;
	private VElegir vElegir;
	private Cuenta cuenta;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param cuenta
	 */
	public VDeporteCompeticionDeApuesta(VElegir vElegir, boolean b, Dao dao, Cuenta cuenta) {
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
		contentPanel.setBackground(new Color(173, 255, 47));
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
		lblNewLabel.setIcon(new ImageIcon(ruta + "\\src\\fotos\\Cabecera.jpg"));
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
		btnVolver.setBounds(43, 11, 107, 36);
		btnVolver.addActionListener(this);
		panel_1.add(btnVolver);

		btnContinuar = new JButton("Continuar");
		btnContinuar.setForeground(new Color(173, 255, 47));
		btnContinuar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnContinuar.setFocusable(false);
		btnContinuar.setBorder(null);
		btnContinuar.setBackground(Color.DARK_GRAY);
		btnContinuar.setBounds(323, 11, 107, 36);
		btnContinuar.addActionListener(this);
		panel_1.add(btnContinuar);

		deportesCombo = new JComboBox();
		deportesCombo.setForeground(new Color(173, 255, 47));
		deportesCombo.setFont(new Font("Arial", Font.PLAIN, 16));
		deportesCombo.setBackground(Color.DARK_GRAY);
		deportesCombo.setBounds(33, 219, 407, 40);
		contentPanel.add(deportesCombo);

		JLabel lblEligeElDeporte = new JLabel("Elige el deporte sobre el que quieres crear la apuesta:");
		lblEligeElDeporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeElDeporte.setFont(new Font("Arial", Font.BOLD, 16));
		lblEligeElDeporte.setBounds(10, 154, 459, 45);
		contentPanel.add(lblEligeElDeporte);

		competicionesCombo = new JComboBox();
		competicionesCombo.setSelectedIndex(-1);
		competicionesCombo.setForeground(new Color(173, 255, 47));
		competicionesCombo.setFont(new Font("Arial", Font.PLAIN, 16));
		competicionesCombo.setBackground(Color.DARK_GRAY);
		competicionesCombo.setBounds(33, 347, 407, 40);
		contentPanel.add(competicionesCombo);

		JLabel lblEligeLaCompeticion = new JLabel("Elige la competición sobre el que quieres crear la apuesta:");
		lblEligeLaCompeticion.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeLaCompeticion.setFont(new Font("Arial", Font.BOLD, 15));
		lblEligeLaCompeticion.setBounds(10, 282, 459, 45);
		contentPanel.add(lblEligeLaCompeticion);

		// cargamos en cada comboBox la informacion necesaria
		cargarDeportes();
		cargaCompeticiones();

	}

	private void cargaCompeticiones() {
		// TODO Auto-generated method stub
		List<Competicion> competiciones = dao.listadoCompeticiones();
		for (Competicion comp : competiciones) {
			competicionesCombo.addItem(comp.getCodCompeticion() + "-" + comp.getNombre() + "|" + comp.getDeporte());
		}
		competicionesCombo.setSelectedIndex(-1);
	}

	private void cargarDeportes() {
		// TODO Auto-generated method stub
		List<Deporte> deportes = dao.listadoDeportes();
		for (Deporte dep : deportes) {
			deportesCombo.addItem(dep.getCodDep() + "-" + dep.getNombreDep());
		}
		deportesCombo.setSelectedIndex(-1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnContinuar)) {
			continuar();
		}
		if (e.getSource().equals(btnVolver)) {
			volver();
		}
	}

	// Metodo para escoger el deporte y la competicion sobre la que deseas crear la
	// apuesta (para acceder a la siguiente ventana la competicion debe ser sobre el mismo deporte al deporte seleccionado)
	private void continuar() {
		// TODO Auto-generated method stub
		if (deportesCombo.getSelectedIndex() != -1 && competicionesCombo.getSelectedIndex() != -1) {
			Deporte deportes = new Deporte();
			String cadenaDeporte = (String) deportesCombo.getSelectedItem();
			int posDep = cadenaDeporte.indexOf("-");
			String codDeporte = cadenaDeporte.substring(0, posDep);
			String nombreDep = cadenaDeporte.substring(posDep + 1);
			deportes.setCodDep(codDeporte);
			deportes.setNombreDep(nombreDep);

			Competicion competiciones = new Competicion();
			String cadenaCompeticion = (String) competicionesCombo.getSelectedItem();
			int posComp = cadenaCompeticion.indexOf("-");
			int posComp2 = cadenaCompeticion.indexOf("|");
			String codComp = cadenaCompeticion.substring(0, posComp);
			String nombreComp = cadenaCompeticion.substring(posComp + 1, posComp2);
			String deporteComp = cadenaCompeticion.substring(posComp2 + 1);
			competiciones.setCodCompeticion(codComp);
			competiciones.setNombre(nombreComp);
			competiciones.setDeporte(deporteComp);

			if (nombreDep.equalsIgnoreCase(deporteComp)) {
				this.dispose();
				VCrearApuestaEquipo vent = new VCrearApuestaEquipo(vElegir, true, dao, deportes, competiciones, cuenta);
				vent.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "LAS DOS OPCIONES DEBEN SER SOBRE EL MISMO DEPORTE.");
			}
		} else {
			JOptionPane.showMessageDialog(this, "DEBES RELLENAR LAS DOS OPCIONES.");
		}

	}

	// metodo para volver a la anterior ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
		VElegirApuesta vent = new VElegirApuesta(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}
}
